package me.geesy.remainder.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EntityPlayer.class)
public abstract class MixinEntityPlayer extends EntityLivingBase {

    private float currentHeight = 1.62F;
    private long lastMillis = System.currentTimeMillis();

    public MixinEntityPlayer(World worldIn) {
        super(worldIn);
    }

    /**
     * @author asbyth
     * @reason sneaking animation
     */
    @Overwrite
    public float getEyeHeight() {
        EntityPlayer player = Minecraft.getMinecraft().thePlayer;
            int timeDelay = 1000 / 60;

            if (player.isSneaking()) {
                float sneakingHeight = 1.54F;

                if (currentHeight > sneakingHeight) {
                    long time = System.currentTimeMillis();
                    long timeSinceLastChance = time - lastMillis;

                    if (timeSinceLastChance > timeDelay) {
                        currentHeight -= 0.012F;
                        lastMillis = time;
                    }
                }
            } else {
                float standingHeight = 1.62F;

                if (currentHeight < standingHeight && currentHeight > 0.2F) {
                    long time = System.currentTimeMillis();
                    long timeSinceLastChange = time - lastMillis;

                    if (timeSinceLastChange > timeDelay) {
                        currentHeight += 0.012F;
                        lastMillis = time;
                    }
                } else {
                    currentHeight = 1.62F;
                }
            }

            if (player.isPlayerSleeping()) {
                currentHeight = 0.2F;
            }

            return currentHeight;
        }
}