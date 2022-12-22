package me.geesy.remainder.mixin;

import me.geesy.remainder.util.Keybinds;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameSettings.class)
public abstract class MixinGameSettings {

    @Shadow
    public KeyBinding[] keyBindings;

    // injected into return at constructor
    @Inject(method = "<init>", at = @At("RETURN"))
    private void addClientKeybinds(CallbackInfo info) {
        KeyBinding[] buffer = new KeyBinding[this.keyBindings.length + 3];
        System.arraycopy(this.keyBindings, 0, buffer, 0, this.keyBindings.length);

        buffer[this.keyBindings.length] = Keybinds.HUD_CONFIG;
        buffer[this.keyBindings.length + 1] = Keybinds.SNAPLOOK;
        buffer[this.keyBindings.length + 2] = Keybinds.ZOOM;
        this.keyBindings = buffer;
    }
}