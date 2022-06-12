package me.geesy.remainder.cosmetic.gui;

import java.awt.Color;
import java.io.IOException;

import me.geesy.remainder.cosmetic.CosmeticBoolean;
import me.geesy.remainder.mixin.interfaces.IEntityRenderer;
import me.geesy.remainder.ui.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiInventory;

public class CapeGui extends GuiScreen
{
    AbstractClientPlayer entity;
    
    
    @Override
    public void drawScreen(final int mouseX, final int mouseY, final float partialTicks) {
    	ScaledResolution sr = new ScaledResolution(mc);
        GlStateManager.pushMatrix();
        GlStateManager.disableBlend();
        GlStateManager.disableAlpha();
		RenderUtil.drawSmoothRoundedRect(300, 100, sr.getScaledWidth() - 300, sr.getScaledHeight() - 100, 5, new Color(0,0,0,150).getRGB());
        RenderUtil.drawSmoothRoundedRect(285, 85, sr.getScaledWidth() - 285, sr.getScaledHeight() - 85, 20, new Color(0,0,0,50).getRGB());
        GlStateManager.popMatrix();
		
        super.drawScreen(mouseX, mouseY, partialTicks);
        if(mc.theWorld != null) {
            this.drawEntityOnScreen(600, 225, 50, 100, 0, mc.thePlayer);
        }

    }
    
    @Override
    public void initGui() {
        //((IEntityRenderer) mc.entityRenderer).invokeLoadShader(new ResourceLocation("shaders/post/menu_blur.json"));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 150, 125, this.fontRendererObj.getStringWidth("Sky Cape") + 50, 20, "Sky Cape"));
        this.buttonList.add(new GuiButton(2, this.width / 2 - 150, 150, this.fontRendererObj.getStringWidth("Sky Cape") + 50, 20, "Woman Cape"));
        this.buttonList.add(new GuiButton(3, this.width / 2 - 150, 175, this.fontRendererObj.getStringWidth("Sky Cape") + 50, 20, "Snowy Cape"));
        this.buttonList.add(new GuiButton(4, this.width / 2 - 150, 200, this.fontRendererObj.getStringWidth("Sky Cape") + 50, 20, "Rick Cape"));
        this.buttonList.add(new GuiButton(5, this.width / 2 - 150, 225, this.fontRendererObj.getStringWidth("Sky Cape") + 50, 20, "Lightning Cape"));
        this.buttonList.add(new GuiButton(6, this.width / 2 - 150, 250, this.fontRendererObj.getStringWidth("Sky Cape") + 50, 20, "Sky Cape 2"));
        super.initGui();
    }

    @Override
    public void onGuiClosed() {
        mc.entityRenderer.stopUseShader();
        super.onGuiClosed();
    }

    @Override
    protected void actionPerformed(final GuiButton button) throws IOException {
        if (button.id == 1) {
        	/*IChatComponent chatComponent = new ChatComponentText("Thank you for using remainder. These cosmetics & the cosmetic system was not made by me.");
            (mc.thePlayer).addChatMessage(chatComponent);*/
            CosmeticBoolean.cape1 = false;
            CosmeticBoolean.skycape = true;
            CosmeticBoolean.snowcape = false;
            CosmeticBoolean.rickcape = false;
            CosmeticBoolean.lightningCape = false;
            CosmeticBoolean.skyCapeTwo = false;
        }
        if (button.id == 2) {
        	
            CosmeticBoolean.cape1 = true;
            CosmeticBoolean.skycape = false;
            CosmeticBoolean.snowcape = false;
            CosmeticBoolean.rickcape = false;
            CosmeticBoolean.lightningCape = false;
            CosmeticBoolean.skyCapeTwo = false;
        }
        if (button.id == 3) {
            CosmeticBoolean.cape1 = false;
            CosmeticBoolean.skycape = false;
            CosmeticBoolean.snowcape = true;
            CosmeticBoolean.rickcape = false;
            CosmeticBoolean.lightningCape = false;
            CosmeticBoolean.skyCapeTwo = false;
        }
        if (button.id == 4) {
        	
            CosmeticBoolean.cape1 = false;
            CosmeticBoolean.skycape = false;
            CosmeticBoolean.snowcape = false;
            CosmeticBoolean.rickcape = true;
            CosmeticBoolean.lightningCape = false;
            CosmeticBoolean.skyCapeTwo = false;
        }
        if (button.id == 5) {
            CosmeticBoolean.cape1 = false;
            CosmeticBoolean.skycape = false;
            CosmeticBoolean.snowcape = false;
            CosmeticBoolean.rickcape = false;
            CosmeticBoolean.lightningCape = true;
            CosmeticBoolean.skyCapeTwo = false;
        }
        if (button.id == 6) {
            CosmeticBoolean.cape1 = false;
            CosmeticBoolean.skycape = false;
            CosmeticBoolean.snowcape = false;
            CosmeticBoolean.rickcape = false;
            CosmeticBoolean.lightningCape = false;
            CosmeticBoolean.skyCapeTwo = true;
        }
        super.actionPerformed(button);
    }

    public void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent) {
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)posX, (float)posY, 50.0F);
        GlStateManager.scale((float)(-scale), (float)scale, (float)scale);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        float f = ent.renderYawOffset;
        float f1 = ent.rotationYaw;
        float f2 = ent.rotationPitch;
        float f3 = ent.prevRotationYawHead;
        float f4 = ent.rotationYawHead;
        GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-((float)Math.atan((double)(mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        ent.renderYawOffset = 180;
        ent.rotationYaw = 180;
        ent.rotationPitch = -((float)Math.atan((double)(mouseY / 40.0F))) * 20.0F;
        ent.rotationYawHead = ent.rotationYaw;
        ent.prevRotationYawHead = ent.rotationYaw;
        GlStateManager.translate(0.0F, 0.0F, 0.0F);
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        rendermanager.setPlayerViewY(180.0F);
        rendermanager.setRenderShadow(false);
        rendermanager.renderEntityWithPosYaw(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
        rendermanager.setRenderShadow(true);
        ent.renderYawOffset = f;
        ent.rotationYaw = f1;
        ent.rotationPitch = f2;
        ent.prevRotationYawHead = f3;
        ent.rotationYawHead = f4;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }

}
