package me.geesy.remainder.cosmetic;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;

public class CosmeticBoolean
{
    public static boolean cape1;
    public static boolean haloblue;
    public static boolean halogreen;
    public static boolean snowcape;
    public static boolean skycape;
    public static boolean rickcape;
    public static boolean dragonWings;
    public static boolean retrowaveCape;
    public static boolean lightningCape;
    public static boolean summerCape;
    public static boolean skyCapeTwo;
    
    static {
        CosmeticBoolean.cape1 = false;
        CosmeticBoolean.haloblue = false;
        CosmeticBoolean.halogreen = false;
        CosmeticBoolean.snowcape = false;
        CosmeticBoolean.skycape = false;
        CosmeticBoolean.rickcape = true;
        CosmeticBoolean.dragonWings = true;
        CosmeticBoolean.retrowaveCape = false;
        CosmeticBoolean.lightningCape = false;
        CosmeticBoolean.summerCape = false;
        CosmeticBoolean.skyCapeTwo = false;
    }
    
    
    public static boolean Cape1() {
        return CosmeticBoolean.cape1;
    }
    public static boolean SummerCape() {
        return CosmeticBoolean.summerCape;
    }
    
    public static boolean LightningCape() {
        return CosmeticBoolean.lightningCape;
    }
    
    public static boolean isHaloblue() {
        return CosmeticBoolean.haloblue;
    }
    
    
    public static boolean DragonWings() {
        return CosmeticBoolean.dragonWings;
    }
    
    public static boolean shouldRenderTopHat(final AbstractClientPlayer player) {
        return player.getName().contains(Minecraft.getMinecraft().getSession().getUsername());
    }
    
    public static float[] getHaloColor(final AbstractClientPlayer player) {
        return new float[] { 0.0f, 51.0f, 153.0f, 255.0f };
    }
    
    public static boolean RickCape() {
        return CosmeticBoolean.rickcape;
    }
    
    public static boolean SnowCape() {
        return CosmeticBoolean.snowcape;
    }
    
    public static boolean SkyCape() {
        return CosmeticBoolean.skycape;
    }
    public static boolean RetrowaveCape() {
        return CosmeticBoolean.retrowaveCape;
    }
    public static boolean summerCape() {
        return CosmeticBoolean.summerCape;
    }
    public static boolean skyCapeTwo(){
        return CosmeticBoolean.skyCapeTwo;
    }
}
