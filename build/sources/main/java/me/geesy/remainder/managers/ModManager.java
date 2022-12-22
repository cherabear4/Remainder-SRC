package me.geesy.remainder.managers;

import me.geesy.remainder.modules.*;

import java.util.ArrayList;

public class ModManager {
	
	public ToggleSprint toggleSprint;
	public FullBright fullBright;
	public Perspective perspective;
	public FlyBoostMod flyBoostMod;
	public CustomZoom customZoom;
	
	public ArrayList<Mod> mods;
	
	public ModManager() {
		mods = new ArrayList<>();
		
		mods.add(toggleSprint = new ToggleSprint());
		mods.add(fullBright = new FullBright());
		mods.add(perspective = new Perspective());
		mods.add(flyBoostMod = new FlyBoostMod());
		mods.add(customZoom = new CustomZoom());
	}

}
