package me.geesy.remainder.modules;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import me.geesy.remainder.event.EventTarget;
import me.geesy.remainder.event.impl.EventUpdate;
import me.geesy.remainder.managers.Category;
import me.geesy.remainder.managers.Mod;
import me.geesy.remainder.util.Keybinds;

public class Perspective extends Mod {
    public Perspective() {
        super("Snaplook", "look around", Category.WORLD);
    }

    public boolean snaplook = false;

    @EventTarget
    public void updateEvent(EventUpdate event) {
    if(mc.theWorld != null) {
        if(Keybinds.SNAPLOOK.isKeyDown()) {
            snaplook = false;
            mc.gameSettings.thirdPersonView = 1;

        } else if (!snaplook) {
            snaplook = true;
            mc.gameSettings.thirdPersonView = 0;

        }
    }}

    public void onEnable() {
        super.onEnable();
        EventBus bus = new EventBus();
        bus.register(this);
        }

    @Override
    public void toggle() {
        super.toggle();
    }

    public void onDisable() {
        super.onDisable();
        EventBus bus = new EventBus();
        bus.register(this);
        //this.mc.gameSettings.thirdPersonView = this.prevF5;
    }

    }
