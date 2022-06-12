package me.geesy.remainder.ui.mainmenu.util;

import me.geesy.remainder.ui.util.RenderUtil;
import me.geesy.remainder.util.font.FontUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;

import java.awt.*;

public class MenuButton extends GuiButton {

	public MenuButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
		super(buttonId, x, y, widthIn, heightIn, buttonText);
		// TODO Auto-generated constructor stub
	}
	
    public void drawButton(Minecraft mc, int mouseX, int mouseY)
    {
        if (this.visible)
        {
        	GlStateManager.disableBlend();
            RenderUtil.drawRoundedOutline(xPosition + width, yPosition + height, xPosition, yPosition, 0, 1, new Color(255,255,255,255).getRGB());
            this.mouseDragged(mc, mouseX, mouseY);
            int j = 14737632;

            if (!this.enabled)
            {
                j = 10526880;
            }
            else if (this.hovered)
            {
                j = 16777120;
            }
            FontUtil.normal.drawCenteredString(this.displayString, this.xPosition + this.width / 2, (this.yPosition + (this.height - 5f) / 2), j);
        }
    }



}
