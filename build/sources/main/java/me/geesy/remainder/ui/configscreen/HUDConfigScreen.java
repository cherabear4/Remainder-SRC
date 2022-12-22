package me.geesy.remainder.ui.configscreen;

import java.awt.*;
import java.io.IOException;

import me.geesy.remainder.Client;
import me.geesy.remainder.cosmetic.gui.CapeGui;
import me.geesy.remainder.managers.HudMod;
import me.geesy.remainder.mixin.interfaces.IEntityRenderer;
import me.geesy.remainder.ui.clickgui.FeatherClickGUI;
import me.geesy.remainder.ui.util.BlurUtil;
import me.geesy.remainder.ui.util.RenderUtil;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class HUDConfigScreen extends GuiScreen{

	private int animatedOpcaity = 0;
	private boolean isHovered;

	@Override
	public void initGui() {
		super.initGui();
	}
	
	@Override
	public void onGuiClosed() {
		mc.entityRenderer.loadEntityShader(null);
        super.onGuiClosed();
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		if(mc.thePlayer != null && mc.theWorld != null) {
			this.drawDefaultBackground();
			BlurUtil.blur2(0, 0, 1920, 1080, 0, 0);
		} else {

			mc.getTextureManager().bindTexture(new ResourceLocation("client/images/background_menu.png"));
			Gui.drawModalRectWithCustomSizedTexture(-21 + Mouse.getX() / 90, Mouse.getY() * -1 / 90, 0.0F, 0.0F, this.width + 20, this.height + 20, (float)(this.width + 21), (float)(this.height + 20));
			BlurUtil.blur2(0, 0, 1920, 1080, 0, 0);
		}
		RenderUtil.drawSmoothRoundedRect(width / 2 - 50, height / 2 - 50, width / 2 + 50, height / 2 + 50, 100, new Color(0, 0, 0, 150).getRGB());
		RenderUtil.drawSmoothRoundedRect(width / 2.5f - 30, height / 2 - 30, width / 2.5f + 30, height / 2 + 30, 60, new Color(0, 0, 0, 150).getRGB());
		GlStateManager.pushMatrix();
		GlStateManager.disableBlend();
		GL11.glColor3f(1.0F, 1.0F, 1.0F);
		RenderUtil.drawImage(new ResourceLocation("client/icons/edit-icon.png"), width / 2 - 25, height / 2 - 25, 50, 50);
		RenderUtil.drawImage(new ResourceLocation("client/icons/cape-icon.png"), width / 2.5f - 17, height / 2 - 15, 30, 30);
		GlStateManager.popMatrix();
		if (mouseX >= width / 2 - 50 && mouseY >= height / 2 - 50 && mouseX < width / 2 + 50 && mouseY < height / 2 + 50) {
			this.isHovered = true;
		} else {
			this.isHovered = false;

		}

		if (this.isHovered) {
			if (this.animatedOpcaity < 255) {
						this.animatedOpcaity += 3;
			}
		} else {
			if (this.animatedOpcaity != 0) {
				this.animatedOpcaity -= 3;
			}
		}
		for(HudMod m : Client.getInstance().getHudManager().hudMods) {
			if(m.isEnabled()) {
				m.renderDummy(mouseX, mouseY);
			}

		}

		RenderUtil.drawRoundedOutline(width / 2 - 49, height / 2 - 49,   width / 2 + 49, height / 2 + 49, 98, 3, new Color(255,255,255,this.animatedOpcaity).getRGB());

		super.drawScreen(mouseX, mouseY, partialTicks);
	}

	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		// If clicked it toggles the mod
		super.mouseClicked(mouseX, mouseY, mouseButton);
		this.onClick(mouseX, mouseY, mouseButton);
	}

	public void onClick(final int mouseX, final int mouseY, final int button) {
		if (mouseX >= width / 2 - 50 && mouseY >= height / 2 - 50 && mouseX < width / 2 + 50 && mouseY < height / 2 + 50) {
			mc.displayGuiScreen(new FeatherClickGUI());
		}
		if (mouseX >= width / 2.5f - 30 && mouseY >= height / 2 - 30 && mouseX < width / 2.5f + 30 && mouseY < height / 2 + 30) {
			mc.displayGuiScreen(new CapeGui());
		}
	}


}
