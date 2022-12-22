package me.geesy.remainder.mixin;

import me.geesy.remainder.Client;
import me.geesy.remainder.ui.configscreen.HUDConfigScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngame.class)
public class MixinGuiIngame {

    @Inject(method = "renderGameOverlay", at = @At("RETURN"))
    private void renderGameOverlay(float partialTicks, CallbackInfo ci) {
        Minecraft mc = Minecraft.getMinecraft();
        if(!(mc.currentScreen instanceof HUDConfigScreen)) {
            Client.getInstance().getHudManager().renderMods();
        }
    }

}
