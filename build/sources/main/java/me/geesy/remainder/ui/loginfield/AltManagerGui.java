package me.geesy.remainder.ui.loginfield;

import me.geesy.remainder.ui.loginfield.microsoft.GuiLoginMicrosoft;
import me.geesy.remainder.ui.loginfield.mojang.GuiLoginMojang;
import me.geesy.remainder.ui.mainmenu.MainMenu;
import me.geesy.remainder.ui.util.BlurUtil;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class AltManagerGui extends GuiScreen {

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        mc.getTextureManager().bindTexture(new ResourceLocation("client/images/background_menu.png"));
        Gui.drawModalRectWithCustomSizedTexture(-21 + Mouse.getX() / 90, Mouse.getY() * -1 / 90, 0.0F, 0.0F, this.width + 20, this.height + 20, (float)(this.width + 21), (float)(this.height + 20));
        BlurUtil.blur2(0, 0, 1920, 1080, 0, 0);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() {
        this.buttonList.add(new GuiButton(0, width / 2 + 4 + 50, height - 24, 100, 20, "Cancel"));
        this.buttonList.add(new GuiButton(1, width / 2 + 4 + 50, height - 48, 100, 20, "Use Cracked"));
        this.buttonList.add(new GuiButton(2, width / 2 - 50, height - 48, 100, 20, "Use Microsoft"));
        this.buttonList.add(new GuiButton(3, width / 2 - 150 - 4, height - 48, 100, 20, "Use Mojang"));
        this.buttonList.add(new GuiButton(4, width / 2 - 50, height - 24, 100, 20, "Coming Soon..."));
        this.buttonList.add(new GuiButton(5, width / 2 - 150 - 4, height - 24, 100, 20, "Coming Soon..."));
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        if (button.id == 0) {
            mc.displayGuiScreen(new MainMenu());
        }
        if(button.id == 1){
            mc.displayGuiScreen(new GuiLogin());
        }
        if(button.id == 2){
            mc.displayGuiScreen(new GuiLoginMicrosoft());
        }
        if(button.id == 3){
            mc.displayGuiScreen(new GuiLoginMojang());
        }
    }
}
