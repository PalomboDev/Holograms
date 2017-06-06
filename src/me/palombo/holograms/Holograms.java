package me.palombo.holograms;

import me.palombo.holograms.command.CommandManager;
import me.palombo.holograms.hologram.HologramManager;
import me.palombo.holograms.update.Ticker;
import org.bukkit.plugin.java.JavaPlugin;

public class Holograms extends JavaPlugin {

    public static Holograms holograms;

    private CommandManager commandManager;
    private HologramManager hologramManager;

    public void onEnable() {
        holograms = this;

        commandManager = new CommandManager(this);
        hologramManager = new HologramManager(this);

        new Ticker(this);

    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public static Holograms get() {
        return holograms;
    }
}
