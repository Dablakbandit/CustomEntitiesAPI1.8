package me.dablakbandit.customentitiesapi;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class CusstomEntitiesConfiguration
{
	private JavaPlugin plugin;
	private FileConfiguration conf = null;
	private File file = null;
	private String fname = null;

	public CusstomEntitiesConfiguration(JavaPlugin plugin, String filename)
	{
		this.plugin = plugin;
		this.fname = filename;
	}

	public void ReloadConfig()
	{
		if (this.file == null) {
			this.file = new File(this.plugin.getDataFolder(), this.fname);
		}
		this.conf = YamlConfiguration.loadConfiguration(this.file);

		InputStream isDefaults = this.plugin.getResource(this.fname);
		if (isDefaults != null)
		{
			@SuppressWarnings("deprecation")
			YamlConfiguration confDefault = YamlConfiguration.loadConfiguration(isDefaults);
			this.conf.setDefaults(confDefault);
		}
	}

	public FileConfiguration GetConfig()
	{
		if (this.conf == null) {
			ReloadConfig();
		}
		return this.conf;
	}

	public boolean SaveConfig()
	{
		if ((this.conf == null) || (this.file == null)) {
			return false;
		}
		try
		{
			this.conf.save(this.file);
			return true;
		}
		catch (IOException ex)
		{
			this.plugin.getLogger().log(Level.SEVERE, "[CustomEntitiesAPI] Error saving configuration file: '" + this.fname + "'!");
		}
		return false;
	}
	
	public boolean exists(){
		if ((this.conf == null) || (this.file == null)) {
			return false;
		}
		return true;
	}
}
