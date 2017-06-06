package me.palombo.holograms.hologram;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;

public class Hologram {

    private Location loc;
    private String text;
    private ArmorStand entity;

    public Hologram(Location loc, String text) {
        this.loc = loc;
        this.text = text;

        spawn();
    }

    public Location getLoc() {
        return loc;
    }

    public String getText() {
        return text;
    }

    public ArmorStand getEntity() {
        return entity;
    }

    private void spawn(){
        entity = loc.getWorld().spawn(loc, ArmorStand.class);
        entity.setCustomName(text);
        entity.setCustomNameVisible(true);
        entity.setVisible(false);
        entity.setGravity(false);
        entity.setBasePlate(false);
    }

    public void remove(){
        entity.remove();
    }
}
