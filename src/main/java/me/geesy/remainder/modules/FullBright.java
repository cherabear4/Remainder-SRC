package me.geesy.remainder.modules;

import com.google.common.eventbus.Subscribe;
import me.geesy.remainder.Client;
import me.geesy.remainder.event.EventTarget;
import me.geesy.remainder.event.impl.EventUpdate;
import me.geesy.remainder.managers.Category;
import me.geesy.remainder.managers.Mod;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

public class FullBright extends Mod {

	public FullBright() {
		super("FullBright", "mod", Category.WORLD);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onEnable() {
		Client.getInstance().getEventM().register(this);
		
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		mc.thePlayer.removePotionEffect(Potion.nightVision.getId());
		Client.getInstance().getEventM().unregister(this);
		super.onDisable();
	}

	@EventTarget
	public void updateEvent(EventUpdate event) {
		mc.thePlayer.addPotionEffect(new PotionEffect(Potion.nightVision.getId(), 5201, 1));

	}

}
