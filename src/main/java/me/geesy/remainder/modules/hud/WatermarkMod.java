package me.geesy.remainder.modules.hud;

import me.geesy.remainder.managers.HudMod;
import me.geesy.remainder.util.font.FontUtil;

public class WatermarkMod extends HudMod {

	public WatermarkMod() {
		super("Watermark", 5, 5, "client/images/remainder_background.png");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		//Gui.drawRect(getX()-2, getY()-2, getX() + getWidth(), getY() + getHeight(), new Color(0, 0, 0, 0/*170*/).getRGB());
		FontUtil.normal.drawString("Remainder", getX(), getY(), -1 );
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		FontUtil.normal.drawString("Remainder", getX(), getY(), -1);
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return fr.getStringWidth(name);
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
	


}
