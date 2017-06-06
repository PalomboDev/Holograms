package me.palombo.holograms.hologram;

import me.palombo.holograms.Holograms;
import me.palombo.holograms.module.Module;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
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
}
