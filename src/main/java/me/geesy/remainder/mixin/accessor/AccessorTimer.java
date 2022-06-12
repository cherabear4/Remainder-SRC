package me.geesy.remainder.mixin.accessor;

import net.minecraft.util.Timer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Timer.class)
public interface AccessorTimer {
    @Accessor("timerSpeed")
    void renderPartialTicks(float partialTicks);
}
