package me.palombo.holograms.hologram;

import me.palombo.holograms.command.CommandBase;
import org.bukkit.entity.Player;

public class HologramTestCmd extends CommandBase<HologramManager> {

    public HologramTestCmd(HologramManager module) {
        super(module, "holograms.admin", "hologram", "holo", "holograms");
    }

    @Override
    public void execute(Player player, String[] args) {

        if (args.length == 0) {
            player.sendMessage("§7/hologram <text>");
        } else {
            String text = "";
            for (String a : args){
                text += a + " ";
            }
            text = text.trim();

            getModule().spawnHologram(player.getLocation(), text);
            player.sendMessage("§7Spawned hologram: " + text + "§7.");
        }
    }
}
