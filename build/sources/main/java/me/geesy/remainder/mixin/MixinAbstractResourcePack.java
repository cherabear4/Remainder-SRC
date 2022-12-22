package me.geesy.remainder.mixin;

import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.AbstractResourcePack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

@Mixin({ AbstractResourcePack.class })
public abstract class MixinAbstractResourcePack
{

    /**
     * @author SexyMen
     */
    @Overwrite
    public BufferedImage getPackImage() throws IOException {
        final BufferedImage image = TextureUtil.readBufferedImage(this.getInputStreamByName("pack.png"));
        final BufferedImage scaledImage = new BufferedImage(64, 64, 2);
        final Graphics graphics = scaledImage.getGraphics();
        graphics.drawImage(image, 0, 0, 64, 64, null);
        graphics.dispose();
        return scaledImage;
    }
    
    @Shadow
    protected abstract InputStream getInputStreamByName(final String p0);
}