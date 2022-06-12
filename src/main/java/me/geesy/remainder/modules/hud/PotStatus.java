package me.geesy.remainder.modules.hud;

import java.util.Collection;

import me.geesy.remainder.managers.HudMod;
import me.geesy.remainder.util.font.FontUtil;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;

//neko client

public class PotStatus extends HudMod {

	public PotStatus() {
		super("Pot Status", 898, 92,"client/mod/client/potionstatus.png");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void draw() {
		int i = 80;
        int j = 0;
        Collection<PotionEffect> collection = this.mc.thePlayer.getActivePotionEffects();
        if (!collection.isEmpty()) {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.disableLighting();
            int k = 18;
            if (collection.size() > 5) {
                k = 132 / (collection.size() - 1);
            }
            for (PotionEffect potioneffect : this.mc.thePlayer.getActivePotionEffects()) {
                Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
                String s = I18n.format(potion.getName());
                ResourceLocation inventoryBackground = new ResourceLocation("textures/gui/container/inventory.png");
                mc.getTextureManager().bindTexture(inventoryBackground);
                if (potion.hasStatusIcon()) {
                    int i1 = potion.getStatusIconIndex();
                    new Gui().drawTexturedModalRect(getX(), getY() + j, 0 + i1 % 8 * 18, 198 + i1 / 8 * 18, 18, 18);
                }
                if (potioneffect.getAmplifier() == 0) {
                    s = "";
                } else if (potioneffect.getAmplifier() == 1) {
                    s = EnumChatFormatting.DARK_GRAY + "II";
                } else if (potioneffect.getAmplifier() == 2) {
                    s = EnumChatFormatting.DARK_GRAY + "III";
                } else if (potioneffect.getAmplifier() == 3) {
                    s = EnumChatFormatting.DARK_GRAY + "IV";
                } else if (potioneffect.getAmplifier() == 4) {
                    s = EnumChatFormatting.DARK_GRAY + "V";
                }
                FontUtil.normal.drawString(s, (float) getX() + 43, (float) (getY() + j + 5), 16777215);
                String s1 = Potion.getDurationString(potioneffect);
                FontUtil.normal.drawString(EnumChatFormatting.GRAY + s1, (float) getX() + 20, (float) (getY() + j + 5), 8355711);
                j += k;
        }
    }
	    }
	       
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		ResourceLocation inventoryBackground = new ResourceLocation("textures/gui/container/inventory.png");

        int j = 1;
        int i1 = 1;

        GlStateManager.pushMatrix();
        this.mc.getTextureManager().bindTexture(inventoryBackground);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        GlStateManager.enableBlend();
        //Gui.instance.drawTexturedModalRect(getX(), getY(), 18, 198, 18, 18);
        //Gui.instance.drawTexturedModalRect(getX(), getY() + 18, 2 % 8 * 18, 198, 18, 18);
        //Gui.instance.drawTexturedModalRect(getX(), getY() + 36, 3 % 8 * 18, 198, 18, 18);
        //Gui.instance.drawTexturedModalRect(getX(), getY() + 54, 4 % 8 * 18, 198, 18, 18);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        FontUtil.normal.drawString(EnumChatFormatting.GRAY + "0:00" + EnumChatFormatting.DARK_GRAY +" I", (float) getX() + 20, (float) (getY() + j + 5), -1);
        FontUtil.normal.drawString(EnumChatFormatting.GRAY + "0:00" + EnumChatFormatting.DARK_GRAY +" II", (float) getX() + 20, (float) (getY() + j + 22), -1);
        FontUtil.normal.drawString(EnumChatFormatting.GRAY + "0:00" + EnumChatFormatting.DARK_GRAY +" III", (float) getX() + 20, (float) (getY() + j + 38), -1);
        FontUtil.normal.drawString(EnumChatFormatting.GRAY + "0:00" + EnumChatFormatting.DARK_GRAY +" IV", (float) getX() + 20, (float) (getY() + j + 55), -1);
        super.renderDummy(mouseX, mouseY);
	}
	
	
	@Override
	public int getWidth() {
		return 18 + fr.getStringWidth("0:00" + "III") + 6;
	}
	
	@Override
	public int getHeight() {
		return 72;
	}

}


