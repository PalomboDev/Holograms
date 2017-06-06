package me.palombo.holograms.command;

import org.bukkit.entity.Player;

import java.util.Collection;

public interface CmdExtend {

    Collection<String> getAliases();
    void execute(Player player, String[] args);
    String getPermission();

}
