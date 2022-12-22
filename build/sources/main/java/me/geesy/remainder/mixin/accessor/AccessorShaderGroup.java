package me.geesy.remainder.mixin.accessor;

import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.ShaderGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ShaderGroup.class)
public interface AccessorShaderGroup {
    //@Accessor("mainFramebuffer")
    //public Framebuffer mainFramebuffer();
}
