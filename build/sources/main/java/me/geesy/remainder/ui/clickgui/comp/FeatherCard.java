package me.geesy.remainder.ui.clickgui.comp;

import me.geesy.remainder.managers.HudMod;
import me.geesy.remainder.ui.clickgui.FeatherClickGUI;
import me.geesy.remainder.ui.util.RenderUtil;
import me.geesy.remainder.util.font.FontUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class FeatherCard {


	Minecraft mc = Minecraft.getMinecraft();
    public int scrollAmount;
	public int x;
	public int y;
	public int w;
	public int h;
	public HudMod m;
	public ResourceLocation texture;
    private int mouseX;
    private int mouseY;


	public FeatherCard(final int x, final int y, final int w, final int h, final HudMod m, final ResourceLocation texture) {
		this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.m = m;
        this.texture = texture;
	}
	
	public void drawFrame() {

        GlStateManager.pushMatrix();
        GlStateManager.translate(0, 0 - FeatherClickGUI.scrolled, 0.0f);

        RenderUtil.drawRoundedRect(this.x - 60, this.y - 79, this.x + this.w + 31, this.y + this.h + 11, 5, new Color(30, 30, 30,150).getRGB());
        RenderUtil.drawRoundedRect(this.x - 60, this.y - 79, this.x + this.w + 30, this.y + this.h + 10, 5, new Color(0,0,0,160).getRGB());
        RenderUtil.drawRoundedRect(this.x - 59, this.y - 3, this.x + this.w + 29, this.y + this.h + 9, 1, new Color(0,0,0,160).getRGB());
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        RenderUtil.drawImage(this.texture, this.x, this.y - 60, 40, 40);
        GlStateManager.popMatrix();
        //RenderUtil.drawImage(new ResourceLocation(texture), this.x, this.y - 60, 40, 40);



        //Gui.drawRect(this.x, this.y - 5, this.x + this.w, this.y + this.h + 4, this.getColor());
        if(m.isEnabled()) {
            GlStateManager.pushMatrix();

            GlStateManager.translate(0.0f, 0.0f - FeatherClickGUI.scrolled, 0.0f);

            RenderUtil.drawRoundedRect(this.x + this.w - 17, this.w + y - 63, this.x + this.w + 20, this.w + y - 47, 16, new Color(53, 221, 56).getRGB());
            RenderUtil.drawRoundedRect(this.x + this.w + 4, this.w + y - 62, this.x + this.w + 18, this.w + y - 48, 14, new Color(24, 77, 18, 255).getRGB());
            GlStateManager.popMatrix();

            // OUTLINE
            //RenderUtil.drawRoundedOutline(this.x + 140, this.w + y - 8, this.x + this.w - 10,
            //this.w + y + 13 + yPosition, 10, 1, new Color(73, 131, 245, 255).getRGB());

        } else {

            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0f, 0.0f - FeatherClickGUI.scrolled, 0.0f);
            RenderUtil.drawRoundedRect(this.x + this.w - 17, this.w + y - 63, this.x + this.w + 20, this.w + y - 47, 16, new Color(221, 53, 53).getRGB());
            RenderUtil.drawRoundedRect(this.x + this.w - 15, this.w + y - 62, this.x + this.w, this.w + y - 48, 14, new Color(77, 18, 18, 255).getRGB());
            GlStateManager.popMatrix();

        }
        FontUtil.normal.drawString(this.m.name, this.x - 45, this.y + 7 - FeatherClickGUI.scrolled, new Color(192, 192, 192, 255).getRGB());

        //RenderUtil.drawRoundedRect(this.x, this.y, this.x + this.w, this.y + this.h, 5, -1);





        //this.renderImage();
    }


	

    
    private void drawBackGround(final int x, final int y, final int w, final int h, final ResourceLocation resource) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
    protected void drawVerticalLine(final int xPosition2, final int i, final int yPosition2, final int Color) {
    }

    protected void drawHorizontalLine(final int xPosition2, final int i, final int j, final int Color) {
    }
    
    //Gets color based on if mod is on or not
    
    public int getColor() {
        if (this.m.isEnabled()) {
            return new Color(109, 255, 71, 255).getRGB();
        }
        return new Color(114, 114, 114, 255).getRGB();
    }
    
    public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	public int getWidth() {
		return w;
	}
    public int getHeight() {
        return h;
    }
    
    //Onclick Method
    
    public void onClick(final int mouseX, final int mouseY, final int button) {
        if (mouseX >= this.x + this.w - 17 && mouseX <= this.x + this.w + 20 && mouseY >= this.w + y - 63 - FeatherClickGUI.scrolled && mouseY <= this.w + y - 47 - FeatherClickGUI.scrolled) {
            if (this.m.isEnabled()) {
                this.m.setEnabled(false);
            } else {

                this.m.setEnabled(true);
            }
        }
    }

    //Onhover method
    public boolean isHovered(int mouseX, int mouseY) {

        return mouseX >= this.x - 70 && mouseX <= this.x + this.w + 30 && mouseY >= this.y - 7- FeatherClickGUI.scrolled && mouseY <= this.y + this.h -3;

    }



}
