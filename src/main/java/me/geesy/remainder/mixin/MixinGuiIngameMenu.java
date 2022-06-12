package me.geesy.remainder.mixin;

import me.geesy.remainder.util.font.FontUtil;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.client.gui.*;

@Mixin(GuiIngameMenu.class)
public class MixinGuiIngameMenu extends GuiScreen {
    @Inject(method = "initGui", at = @At("TAIL"))
    private void initGui(CallbackInfo ci) {
        this.buttonList.add(new GuiButton(-1, this.width / 2 - 100, this.height / 4 + 56, 200, 20, "Servers"));
    }

    @Inject(method = "actionPerformed", at = @At("HEAD"))
    private void actionPerformed(GuiButton button, CallbackInfo ci) {
        if (button.id == -1) {
            this.mc.displayGuiScreen(new GuiMultiplayer(this));
        }
    }

    @Inject(method = "drawScreen", at = @At("TAIL"))
    private void drawScreen(int mouseX, int mouseY, float partialTicks, CallbackInfo ci) {
        FontUtil.normal.drawString("Remainder", 5, 5, 0xFFFFFF);
    }
}