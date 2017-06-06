package me.palombo.holograms.hologram;

import me.palombo.holograms.Holograms;
import me.palombo.holograms.module.Module;
import me.palombo.holograms.update.TickEvent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class HologramManager extends Module {

    private ArrayList<Hologram> holograms;
    private ArrayList<EntityHologram> entityHolograms;

    public HologramManager(JavaPlugin plugin) {
        super(plugin);

        holograms = new ArrayList<>();
        entityHolograms = new ArrayList<>();

        Holograms.get().getCommandManager().addCommand(new HologramTestCmd(this));
    }

    public EntityHologram addEntityHologram(Entity entity, String text){
        EntityHologram eh = new EntityHologram(entity, text);
        entityHolograms.add(eh);
        return eh;
    }

    public Hologram spawnHologram(Location loc, String text){
        Hologram h = new Hologram(loc, ChatColor.translateAlternateColorCodes('&', text));
        holograms.add(h);
        return h;
    }

    public void clearHolograms(){
        holograms.forEach(Hologram::remove);

        entityHolograms.forEach(EntityHologram::remove);

        holograms.clear();
        entityHolograms.clear();
    }

    @EventHandler
    public void onEntDeath(EntityDeathEvent event){
        entityHolograms.stream().filter(eh -> eh.getEntity().equals(event.getEntity())).forEach(EntityHologram::remove);
    }

    @EventHandler
    public void onEntRemoved(TickEvent event){
        entityHolograms.stream().filter(eh -> eh.getEntity() == null || eh.getEntity().isDead()).forEach(EntityHologram::remove);
    }

    @EventHandler
    public void onInteract(EntityInteractEvent event){
        holograms.stream().filter(h -> h.getEntity().equals(event.getEntity())).forEach(h -> {
            event.setCancelled(true);
        });

        entityHolograms.stream().filter(h -> h.getArmorStand().equals(event.getEntity())).forEach(h -> {
            event.setCancelled(true);
        });
    }

    @EventHandler
    public void onHurt(EntityDamageEvent event){
        holograms.stream().filter(h -> h.getEntity().equals(event.getEntity())).forEach(h -> {
            event.setCancelled(true);
        });

        entityHolograms.stream().filter(h -> h.getArmorStand().equals(event.getEntity())).forEach(h -> {
            event.setCancelled(true);
        });
    }
}
