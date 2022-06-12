package me.geesy.remainder.modules.hud;

import java.awt.Color;

import me.geesy.remainder.managers.HudMod;
import me.geesy.remainder.util.font.FontUtil;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class TargetHUD extends HudMod {
	
	EntityLivingBase target;

	public TargetHUD() {
		super("TargetHUD", 857, 11, "client/mod/client/target.png");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		renderTargetHud();
		//Gui.drawRect(getX()-2, getY()-2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 0/*170*/).getRGB());
		super.draw();
		
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		if(mc.thePlayer != null && mc.theWorld != null) {
			Gui.drawRect(getX(),getY() - 10, getX() + 100, getY() + 33, new Color(0,0,0,190).getRGB());
			FontUtil.normal.drawString(mc.thePlayer.getName(), getX() + 2, getY() + 2, -1);
			FontUtil.normal.drawString((int)mc.thePlayer.getHealth() + " \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
			GuiInventory.drawEntityOnScreen((int) (getX() + FontUtil.normal.getStringWidth(mc.thePlayer.getName()) + 30), getY() + 30, 20, 100, 0, mc.thePlayer);
		}

		
		
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return 100;
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT * 2 + 4;
	}
	
	private void renderTargetHud() {
		
		if((mc.pointedEntity instanceof EntityPlayer)) {
		target = (EntityLivingBase) mc.pointedEntity;
		
		Gui.drawRect(getX(),getY() - 10, getX() + 100, getY() + 33, new Color(0, 0, 0,210).getRGB());
		fr.drawStringWithShadow(target.getName(), getX() + 2, getY() + 2, -1);
		fr.drawStringWithShadow((int)target.getHealth() + " \u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
		GuiInventory.drawEntityOnScreen(getX() + fr.getStringWidth(target.getName()) + 30, getY() + 30, 20, 50, 0, target);
		} else {
			return;
		}
	}
}
