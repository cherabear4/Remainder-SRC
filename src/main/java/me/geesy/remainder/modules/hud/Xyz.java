package me.geesy.remainder.modules.hud;

import me.geesy.remainder.managers.HudMod;
import me.geesy.remainder.util.font.FontUtil;
import net.minecraft.client.Minecraft;

//authors: eric golde/quickdaffy


public class Xyz extends HudMod {
	
	//�

	public Xyz() {
		super("Coordinates", 896, 504, "client/mod/client/coords.png");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		
		 FontUtil.normal.drawString("X - " + Math.round(Minecraft.getMinecraft().thePlayer.posX * 1000.0) / 1000L + ", Y - " +  Math.round(Minecraft.getMinecraft().thePlayer.posY * 1000.0) / 1000L + ", Z - " +  Math.round(Minecraft.getMinecraft().thePlayer.posZ * 1000.0) / 1000L, this.drag.getxPosition() + 2, this.drag.getyPosition() + 2, -1);
	       super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		if(mc.thePlayer != null && mc.theWorld != null) {
			FontUtil.normal.drawString("X - " + Math.round(Minecraft.getMinecraft().thePlayer.posX * 1000.0) / 1000L + ", Y - " +  Math.round(Minecraft.getMinecraft().thePlayer.posY * 1000.0) / 1000L + ", Z - " +  Math.round(Minecraft.getMinecraft().thePlayer.posZ * 1000.0) / 1000L, this.drag.getxPosition() + 2, this.drag.getyPosition() + 2, -1);
		}

        super.renderDummy(mouseX, mouseY);
	}
	
	
	@Override
	public int getWidth() {
		return 100;
	}
	
	@Override
	public int getHeight() {
		return 30;
	}

}

