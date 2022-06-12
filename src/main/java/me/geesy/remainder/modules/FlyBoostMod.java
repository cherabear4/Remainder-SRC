package me.geesy.remainder.modules;


import com.google.common.eventbus.Subscribe;
import me.geesy.remainder.Client;
import me.geesy.remainder.event.EventTarget;
import me.geesy.remainder.event.impl.EventUpdate;
import me.geesy.remainder.managers.Category;
import me.geesy.remainder.managers.Mod;

public class FlyBoostMod extends Mod {
    public FlyBoostMod() {
        super("FlyBoost", "Help Me", Category.WORLD);
    }


    public void onEnable() {
        super.onEnable();
        Client.getInstance().getEventM().register(this);
    }

    public void onDisable() {
        super.onDisable();
        Client.getInstance().getEventM().unregister(this);
    }

    @EventTarget
    public void updateEvent(EventUpdate event) {
        if (mc.thePlayer.capabilities.isFlying && Client.getInstance().getHudManager().flyBoost.isEnabled() && mc.theWorld != null) {
            mc.thePlayer.capabilities.setFlySpeed(0.2F);

        } else if(mc.theWorld != null) {
            mc.thePlayer.capabilities.setFlySpeed(0.05F);
        }
    }
}
