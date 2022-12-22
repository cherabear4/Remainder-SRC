package me.geesy.remainder.managers;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import me.geesy.remainder.Client;
import me.geesy.remainder.ui.configscreen.DraggableComponent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class HudMod {
	
	public Minecraft mc = Minecraft.getMinecraft();
	public FontRenderer fr = mc.fontRendererObj;
	
	public String name;
	public boolean enabled;
	public DraggableComponent drag;
	public String image;

	public int x, y;
	
	public HudMod(String name, int x, int y, String image) {
		this.name = name;
		this.image = image;
		if(image == null) {
			this.image = "";
		}
		try {
			this.x = (int) Client.getInstance().getConfig().config.get(name.toLowerCase() + " x");
			this.y = (int) Client.getInstance().getConfig().config.get(name.toLowerCase() + " y");
			this.setEnabled((boolean) Client.getInstance().getConfig().config.get(name.toLowerCase() + " enabled"));
		} catch (NullPointerException e){
			e.printStackTrace();
			this.x = x;
			this.y = y;
			this.enabled = false;

		}


		drag = new DraggableComponent(this.x, this.y, getWidth(), getHeight(), new Color(0,0,0,0).getRGB());

	}

	public int getWidth() {
		return 50;

	}

	public boolean isHovered(int mouseX, int mouseY) {

		return mouseX >= x && mouseX <= x + getWidth() && mouseY >= y && mouseY <= y + getHeight();

	}


	public int getHeight() {
		return 50;

	}
	
	public void draw() {
		
	}
	
	public void renderDummy(int mouseX, int mouseY) {
		drag.draw(mouseX, mouseY);
		
		
	}
	
	public int getX() {
		return drag.getxPosition();
	}
	
	public int getY() {
		return drag.getyPosition();
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void toggle() {
		this.setEnabled(!enabled);

	}

	
	public boolean isEnabled() {
		return enabled;
	}

}
