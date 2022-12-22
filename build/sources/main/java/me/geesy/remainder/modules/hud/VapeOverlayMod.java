package me.geesy.remainder.modules.hud;

import me.geesy.remainder.managers.HudMod;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;

public class VapeOverlayMod extends HudMod {
    public VapeOverlayMod() {
        super("Vape (FAKE)", 5, 5, "client/mod/client/vape.png");
    }

    public void draw() {
        this.mc.getTextureManager().bindTexture(new ResourceLocation("client/images/vape-overlay.png"));
        Gui.drawModalRectWithCustomSizedTexture(this.getX(), this.getY(), 0.0F, 0.0F, 70, 55, 70.0F, 55.0F);
        super.draw();
    }

    public void renderDummy(int mouseX, int mouseY) {
        this.mc.getTextureManager().bindTexture(new ResourceLocation("client/images/vape-overlay.png"));
        Gui.drawModalRectWithCustomSizedTexture(this.getX(), this.getY(), 0.0F, 0.0F, 70, 55, 70.0F, 55.0F);
        super.renderDummy(mouseX, mouseY);
    }

    public int getWidth() {
        return 70;
    }

    public int getHeight() {
        return 70;
    }
}
