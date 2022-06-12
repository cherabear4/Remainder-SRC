package me.geesy.remainder.io;

import me.geesy.remainder.Client;
import me.geesy.remainder.managers.HudMod;
import me.geesy.remainder.managers.Mod;

import java.io.File;
import java.io.IOException;


public class Config {
	
	public File configFolder = new File("Remainder");
	public File modsFolder = new File("Remainder/Mods");
		
	public Configuration config, configToSave = ConfigurationAPI.newConfiguration(new File("Remainder/Mods/ModConfiguration.json"));
	
	public void saveModConfig() {
		if(!configFolder.exists()) {
			configFolder.mkdirs();		
			}
		
		if(!modsFolder.exists()) {
			modsFolder.mkdirs();
		}
		
		System.out.println("Saving Mod Configuration");
		
		for(HudMod m : Client.getInstance().getHudManager().hudMods) {
			configToSave.set(m.name.toLowerCase() + " x", m.getX());
			configToSave.set(m.name.toLowerCase() + " y", m.getY());
			configToSave.set(m.name.toLowerCase() + " enabled", m.isEnabled());
		}
		
		for(Mod mod : Client.getInstance().getModManager().mods) {
			configToSave.set(mod.name.toLowerCase() + " modenabled", mod.isEnabled());
		}
		
		try {
			configToSave.save();
		} catch (IOException e) {
			
			e.printStackTrace();
			System.out.println("Mod Config Save Failed");
		}
		
		

	}
	
	public void saveCoords(){
		if(!configFolder.exists()) {
			configFolder.mkdirs();		
			}
		
		if(!modsFolder.exists()) {
			modsFolder.mkdirs();
		}
		
		System.out.println("Saving Coord Configuration");
	}
	
	public void loadModConfig() {
		try {
			config = ConfigurationAPI.loadExistingConfiguration(new File("Remainder/Mods/ModConfiguration.json"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void loadCoords() {
		try {
			config = ConfigurationAPI.loadExistingConfiguration(new File("Remainder/Mods/Waypoints.clientwaypoints"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}