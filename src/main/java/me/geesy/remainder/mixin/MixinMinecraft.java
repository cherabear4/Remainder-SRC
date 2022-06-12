package me.geesy.remainder.mixin;

import me.geesy.remainder.Client;
import me.geesy.remainder.event.impl.ClientTick;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {

    @Shadow public GameSettings gameSettings;



    @Inject(method = "startGame", at = @At("RETURN"))
    public void injectStartGame(CallbackInfo ci) {
        new Client().start();
        this.gameSettings.guiScale = 2;
    }

    @Inject(method = "shutdownMinecraftApplet", at = @At("HEAD"))
    public void injectShutdown(CallbackInfo ci) {
        Client.getInstance().stop();
    }

    @Inject(at = @At("HEAD"), method = "runTick")
    public void injectClientTick(CallbackInfo ci){
        ClientTick tick = new ClientTick();
        tick.call();
    }
}
