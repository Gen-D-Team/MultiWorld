package com.multiworld;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ImportWorld implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        String name = args[0];

        WorldCreator worldCreator = new WorldCreator(name);
        World world = Bukkit.getWorld(name);
        Bukkit.getServer().createWorld(worldCreator);

        if(command.getName().equalsIgnoreCase("createworld")) {
            if (args[0].equalsIgnoreCase("help")) {
                player.sendMessage(ChatColor.GOLD + "/createworld help to show all available commands");
                player.sendMessage(ChatColor.GOLD + "/createworld <name> to create a world");
                player.sendMessage(ChatColor.GOLD + "+ <name> write the name you want for new world");
                player.sendMessage(ChatColor.GOLD + "/createworld flat <name> to create a flat world");
                player.sendMessage(ChatColor.GOLD + "/joinworld <name> to join the world that exist");
                player.sendMessage(ChatColor.GOLD + "/import <url> import the world from the url");
                return true;
            }
            
            if (world != null) {
                player.sendMessage("The world with name " + name + " exist");
                return true;
            } else {
                player.sendMessage("The world name " + name + " does not exist");
                return false;
            }
        }

        if (command.getName().equalsIgnoreCase("joinworld")) {
            if (args.length < 1) {
                player.sendMessage(ChatColor.GOLD + "/joinworld <name>");
                return false;
            }

            if (world != null) {
                Location spawnlocation = world.getSpawnLocation();
                player.teleport(spawnlocation);
                return true;
            }
            player.sendMessage("That world is not exist");
            return false;
        }

        return false;
    }
}
