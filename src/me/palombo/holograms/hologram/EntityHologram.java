package me.palombo.holograms.hologram;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;

public class EntityHologram {

    private Entity entity;
    private String text;
    private ArmorStand armorStand;

    public EntityHologram(Entity entity, String text) {
        this.entity = entity;
        this.text = text;

        spawn();
    }

    private void spawn(){
        armorStand = entity.getWorld().spawn(entity.getLocation(), ArmorStand.class);
        armorStand.setSmall(true);
        armorStand.setVisible(false);
        armorStand.setBasePlate(false);
        armorStand.setGravity(false);
        armorStand.setCustomName(text);
        armorStand.setCustomNameVisible(true);
        entity.setPassenger(armorStand);
    }

    public Entity getEntity() {
        return entity;
    }

    public String getText() {
        return text;
    }

    public ArmorStand getArmorStand() {
        return armorStand;
    }

    public void remove(){
        armorStand.remove();
    }
}
