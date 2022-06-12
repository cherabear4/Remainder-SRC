package me.geesy.remainder.modules.hud;

import me.geesy.remainder.managers.HudMod;
import me.geesy.remainder.util.font.FontUtil;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.network.NetworkPlayerInfo;
import org.lwjgl.opengl.GL11;

import java.awt.*;

public class SessionInfoMod extends HudMod {
    public SessionInfoMod() {
        super("SessionInfo", 300, 300,"client/mod/client/info.png");
    }

    @Override
    public void draw() {
        ScaledResolution sr = new ScaledResolution(mc);
        Gui.drawRect(getX() - 5, getY() -5, getX() + mc.fontRendererObj.getStringWidth(mc.thePlayer.getName()) + 33, getY() + getHeight() - 20, new Color(0, 0, 0, 170).getRGB());
        NetworkPlayerInfo playerInfo = mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID());
        if (playerInfo != null)
        {
            mc.getTextureManager().bindTexture(playerInfo.getLocationSkin());
            GL11.glColor4f(1F, 1F, 1F, 1F);

            Gui.drawScaledCustomSizeModalRect(getX(), getY(), 8F, 8F, 8, 8, 25, 25, 64F, 64F);
            FontUtil.normal.drawSmoothString(mc.thePlayer.getName(), getX() + 30, getY() + 9, Color.WHITE.getRGB(), false);
        }
        super.draw();
    }

    @Override
    public void renderDummy(int mouseX, int mouseY) {
        ScaledResolution sr = new ScaledResolution(mc);
        if(mc.thePlayer != null && mc.theWorld != null) {

            Gui.drawRect(getX() - 5, getY() - 5, getX() + mc.fontRendererObj.getStringWidth(mc.thePlayer.getName()) + 33, getY() + getHeight() - 20, new Color(0, 0, 0, 170).getRGB());
            NetworkPlayerInfo playerInfo = mc.getNetHandler().getPlayerInfo(mc.thePlayer.getUniqueID());
            if (playerInfo != null) {
                mc.getTextureManager().bindTexture(playerInfo.getLocationSkin());
                GL11.glColor4f(1F, 1F, 1F, 1F);

                Gui.drawScaledCustomSizeModalRect(getX(), getY(), 8F, 8F, 8, 8, 25, 25, 64F, 64F);
                FontUtil.normal.drawSmoothString(mc.thePlayer.getName(), getX() + 30, getY() + 9, Color.WHITE.getRGB(), false);
            }
        }
        super.renderDummy(mouseX, mouseY);
    }
}
