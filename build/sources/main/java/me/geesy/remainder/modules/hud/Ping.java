package me.geesy.remainder.modules.hud;

import me.geesy.remainder.managers.HudMod;
import me.geesy.remainder.util.font.FontUtil;


public class Ping extends HudMod {
	
	//�

	public Ping() {
		super("Ping", 895, 492, "client/mod/client/ping.png");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		
		 if (mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID()) != null) {
			 FontUtil.normal.drawString("Ping : " + mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID()).getResponseTime(), getX() + 1, getY() + 1, -1);
	        } else {
	            FontUtil.normal.drawString("Ping : 0", getX() + 1, getY() + 1, -1);
	        }
	     super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		if(mc.thePlayer != null && mc.theWorld != null) {
			if (mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID()) != null) {
				FontUtil.normal.drawString("Ping : " + mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID()).getResponseTime(), getX() + 1, getY() + 1, -1);
			} else {
				FontUtil.normal.drawString("Ping : 0", getX() + 1, getY() + 1, -1);
			}
			super.renderDummy(mouseX, mouseY);
		}
}
	
	
	@Override
	public int getWidth() {
		return fr.getStringWidth("[Ping] 100");
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

}

