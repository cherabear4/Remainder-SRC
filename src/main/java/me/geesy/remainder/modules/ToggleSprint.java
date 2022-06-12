package me.geesy.remainder.modules;

import com.google.common.eventbus.Subscribe;
import me.geesy.remainder.event.EventTarget;
import me.geesy.remainder.event.impl.EventUpdate;
import me.geesy.remainder.managers.Category;
import me.geesy.remainder.managers.Mod;
import net.minecraft.potion.Potion;

public class ToggleSprint extends Mod {

	public ToggleSprint() {
		super("ToggleSprint", "Toggle Sprint", Category.MISC);
		// TODO Auto-generated constructor stub
	}
	
	@EventTarget
	private void updateEvent(EventUpdate update) {
		if(this.isEnabled() 
				&& !mc.thePlayer.isBlocking() 
				&& !mc.thePlayer.isSneaking() 
				&& (mc.thePlayer.motionX != 0 
				&&  mc.thePlayer.motionZ != 0) 
				&& !mc.thePlayer.isCollidedHorizontally
				&& !mc.thePlayer.isPotionActive(Potion.moveSlowdown)
				&& !mc.thePlayer.isPotionActive(Potion.confusion)
				&& !mc.gameSettings.keyBindRight.isKeyDown())
		{
			if (mc.gameSettings.keyBindForward.isKeyDown()) {
				mc.thePlayer.setSprinting(true);
		}
		}

	}

	

	@Override

	public void onDisable() {

		super.onDisable();

		

		mc.thePlayer.setSprinting(false);

	}
}