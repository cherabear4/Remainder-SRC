package me.geesy.remainder.modules.hud;


import me.geesy.remainder.managers.HudMod;
import me.geesy.remainder.util.font.FontUtil;

public class FPSMod extends HudMod {
	
	//�

	public FPSMod() {
		super("FPS", 65, 5, "client/mod/client/fps.png");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		
		FontUtil.normal.drawString("FPS : " + mc.getDebugFPS(), getX(), getY(), -1);
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		FontUtil.normal.drawString("FPS : " + mc.getDebugFPS(), getX(), getY(), -1);
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return fr.getStringWidth("FPS : " + mc.getDebugFPS());
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}
	
	

}

