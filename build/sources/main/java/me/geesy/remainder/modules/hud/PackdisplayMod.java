package me.geesy.remainder.modules.hud;

import com.google.common.collect.Lists;
import me.geesy.remainder.managers.HudMod;
import me.geesy.remainder.util.font.FontUtil;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.ResourcePackRepository;

public class PackdisplayMod extends HudMod {
    private int width;
    public PackdisplayMod() {
        super("Packdisplay", 5, 5,"client/mod/client/pack.png" );
    }

    @Override
    public int getWidth() {
        return 150;
    }

    @Override
    public int getHeight() {
        return this.mc.getResourcePackRepository().getRepositoryEntries().size() * 32 + (this.mc.getResourcePackRepository().getRepositoryEntries().size() - 1) * 2;
    }

    @Override
    public void draw() {
        GlStateManager.pushMatrix();
        this.width = 0;
        int offset = 0;
        for (final ResourcePackRepository.Entry entry : Lists.reverse(this.mc.getResourcePackRepository().getRepositoryEntries())) {
            this.width = Math.max(this.width, this.mc.fontRendererObj.getStringWidth(entry.getResourcePackName()) + 38);
        }
        for (final ResourcePackRepository.Entry entry : Lists.reverse(this.mc.getResourcePackRepository().getRepositoryEntries())) {
                entry.bindTexturePackIcon(this.mc.getTextureManager());
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
                GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
                Gui.drawModalRectWithCustomSizedTexture(getX(), getY() + offset, 0.0f, 0.0f, 32, 32, 32.0f, 32.0f);
                GlStateManager.enableTexture2D();
            FontUtil.normal.drawString(entry.getResourcePackName(), getX() + 36, getY() + offset + 1, 16777215);
            offset += 34;
        }
        GlStateManager.popMatrix();
        super.draw();
    }

    @Override
    public void renderDummy(int mouseX, int mouseY) {
        GlStateManager.pushMatrix();
        this.width = 0;
        int offset = 0;
        for (final ResourcePackRepository.Entry entry : Lists.reverse(this.mc.getResourcePackRepository().getRepositoryEntries())) {
            this.width = Math.max(this.width, this.mc.fontRendererObj.getStringWidth(entry.getResourcePackName()) + 38);
        }
        for (final ResourcePackRepository.Entry entry : Lists.reverse(this.mc.getResourcePackRepository().getRepositoryEntries())) {
            entry.bindTexturePackIcon(this.mc.getTextureManager());
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
            Gui.drawModalRectWithCustomSizedTexture(getX(), getY() + offset, 0.0f, 0.0f, 32, 32, 32.0f, 32.0f);
            GlStateManager.enableTexture2D();
            FontUtil.normal.drawString(entry.getResourcePackName(), getX() + 36, getY() + offset + 1, 16777215);
            offset += 34;
        }
        GlStateManager.popMatrix();
        super.renderDummy(mouseX, mouseY);
    }
}
