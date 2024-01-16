package com.multiworld;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * multiworld java plugin
 */
public class Plugin extends JavaPlugin
{
  private static final Logger LOGGER=Logger.getLogger("multiworld");
  private ImportWorld importworld ;

  public void onEnable()
  {
    LOGGER.info("multiworld enabled");
    importworld = new ImportWorld();
    
    getCommand("createworld").setExecutor(importworld);
    // getCommand("import").setExecutor(importworld);
    getCommand("joinworld").setExecutor(importworld);
  }

  public void onDisable()
  {
    LOGGER.info("multiworld disabled");
  }
}
