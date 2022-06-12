package me.geesy.remainder.util;

import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.input.Keyboard;

public class Keybinds {
    public static final KeyBinding HUD_CONFIG = new KeyBinding("HUD Config", Keyboard.KEY_RSHIFT, "Remainder");
    public static final KeyBinding SNAPLOOK = new KeyBinding("Freelook", Keyboard.KEY_LMENU, "Remainder");
    public static final KeyBinding ZOOM = new KeyBinding("Zoom", Keyboard.KEY_C, "Remainder");
}