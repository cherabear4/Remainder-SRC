package me.geesy.remainder.mixin;

import me.geesy.remainder.cosmetic.impl.*;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.client.renderer.entity.layers.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ RenderPlayer.class })
public abstract class MixinRenderPlayer extends RendererLivingEntity<AbstractClientPlayer>
{
    public MixinRenderPlayer(final RenderManager renderManagerIn, final ModelBase modelBaseIn, final float shadowSizeIn) {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }
    
    @Inject(method = { "<init>(Lnet/minecraft/client/renderer/entity/RenderManager;Z)V" }, at = { @At("RETURN") })
    private void constructor(final RenderManager renderManager, final boolean useSmallArms, final CallbackInfo ci) {
        this.addLayer(new LayerCape(net.minecraft.client.renderer.entity.RenderPlayer.class.cast(this)));
        this.addLayer(new CosmeticSkyCape(net.minecraft.client.renderer.entity.RenderPlayer.class.cast(this)));
        this.addLayer(new CosmeticSnowyCape(net.minecraft.client.renderer.entity.RenderPlayer.class.cast(this)));
        this.addLayer(new CosmeticLightningCape(net.minecraft.client.renderer.entity.RenderPlayer.class.cast(this)));
        this.addLayer(new CosmeticRickrollCape(net.minecraft.client.renderer.entity.RenderPlayer.class.cast(this)));
        this.addLayer(new CosmeticSummerCape(net.minecraft.client.renderer.entity.RenderPlayer.class.cast(this)));
        this.addLayer(new CosmeticSkyCapeTwo(net.minecraft.client.renderer.entity.RenderPlayer.class.cast(this)));
    }
}