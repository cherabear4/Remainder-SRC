package me.geesy.remainder.mixin.accessor;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Render.class)
public interface AccessorRender {
    //@Accessor("renderManager")
    //RenderManager renderManager();

}
