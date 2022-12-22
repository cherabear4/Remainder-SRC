package me.geesy.remainder.mixin;

import me.geesy.remainder.Client;
import me.geesy.remainder.event.impl.EventUpdate;
import net.minecraft.client.entity.EntityPlayerSP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayerSP.class)
public abstract class MixinEntityPlayerSP {

    @Inject(at = @At("HEAD"), method = "onUpdate")
    public void injectOnUpdate(CallbackInfo ci){
        EventUpdate update = new EventUpdate();
        update.call();
    }
}