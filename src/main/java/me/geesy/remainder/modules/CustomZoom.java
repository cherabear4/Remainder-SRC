package me.geesy.remainder.modules;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import me.geesy.remainder.event.EventTarget;
import me.geesy.remainder.event.impl.EventUpdate;
import me.geesy.remainder.managers.Category;
import me.geesy.remainder.managers.Mod;
import me.geesy.remainder.util.Keybinds;
import org.lwjgl.input.Mouse;

public class CustomZoom extends Mod {

    public CustomZoom() {
        super("Zoom", "zoom", Category.MISC);
    }

    public boolean zoomed;
    private int scrollAmount;
    public float prevFov = this.mc.gameSettings.fovSetting;

    @EventTarget
    public void updateEvent(EventUpdate event) {
        if(mc.theWorld != null) {
            if(Keybinds.ZOOM.isPressed()) {
                int eventDWheel = Mouse.getDWheel();
                if(eventDWheel < 0) {
                    scrollAmount += 2;
                } else if(eventDWheel > 0) {
                    scrollAmount -= 2;
                }
                zoomed = false;
                int mouse = Mouse.getDWheel();
                mc.gameSettings.fovSetting = (int) (mc.gameSettings.mouseSensitivity * 100 + scrollAmount);


            } else if (!zoomed) {
                zoomed = true;
                mc.gameSettings.fovSetting = prevFov;

            }
        }
    }

    @Override
    public void onEnable() {
        super.onEnable();
        EventBus bus = new EventBus();
        bus.register(this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        EventBus bus = new EventBus();
        bus.unregister(this);
    }
}
