package me.geesy.remainder.managers;

import com.google.common.eventbus.EventBus;
import me.geesy.remainder.Client;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mod {
	
	public Minecraft mc = Minecraft.getMinecraft();
	public String name, description;
	public boolean enabled;
	public Category category;
	
	public Mod(String name, String description, Category category) {
		this.name = name;
		this.description = description;
		this.category = category;
		
		try {
			this.setEnabled((boolean) Client.getInstance().getConfig().config.get(name.toLowerCase() + " modenabled"));
		} catch (NullPointerException e){
			e.printStackTrace();
			this.enabled = true;
			
		}
	}

	
	public void onEnable() {
		Client.getInstance().getEventM().register(this);
	}

	
	public void onDisable() {

		Client.getInstance().getEventM().unregister(this);
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		if(enabled) {
			onEnable();
		} else {
			onDisable();
		}
	}


	public void toggle() {
		setEnabled(!this.enabled);
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public Category getCategory() {
		return category;
	}
	

}
