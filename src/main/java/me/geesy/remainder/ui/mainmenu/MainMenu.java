package me.geesy.remainder.ui.mainmenu;

import me.geesy.remainder.ui.configscreen.HUDConfigScreen;
import me.geesy.remainder.ui.loginfield.AltManagerGui;
import me.geesy.remainder.ui.mainmenu.util.MenuButton;
import me.geesy.remainder.ui.util.BlurUtil;
import me.geesy.remainder.ui.util.RenderUtil;
import me.geesy.remainder.util.Logger;
import me.geesy.remainder.util.font.FontUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Mouse;

import java.io.IOException;

public class MainMenu extends GuiScreen {
    public enum BackgroundEnum {
        BACKGROUND_1,
        BACKGROUND_2,
        BACKGROUND_3,
        BACKGROUND_4;
    }

    public boolean displayMode = false;

    public void refresh(){
        mc.displayGuiScreen(new MainMenu());
    }

    public BackgroundEnum background = BackgroundEnum.BACKGROUND_1;
    public ResourceLocation BACKGROUND1 = new ResourceLocation("client/images/background_menu.png");
    public ResourceLocation BACKGROUND2 = new ResourceLocation("client/images/backgroundtwo.jpg");
    public ResourceLocation BACKGROUND3 = new ResourceLocation("client/images/shaders3.jpg");
    public ResourceLocation BACKGROUND4 = new ResourceLocation("client/images/shaders4.jpg");

    //create class constant for s var instead of repeating in methods
    private final ScaledResolution s = new ScaledResolution(mc);

    @Override
    public void initGui() {
        //((IEntityRenderer) mc.entityRenderer).invokeLoadShader(new ResourceLocation("shaders/post/menu_blur.json"));
        System.out.println(s.getScaledWidth() + " " + s.getScaledHeight());

        this.buttonList.add(new GuiButton(4, 10000, 100000, 1, 1, "Exit Game"));
        this.buttonList.add(new MenuButton(1, (int) (s.getScaledWidth() / 2 - 240 * 0.01), (int) (s.getScaledHeight() / 2 - 10 * 0.01), 75, 20, "Multiplayer"));
        this.buttonList.add(new MenuButton(2, (int) (s.getScaledWidth() / 2 - 330 * 0.01), (int) (s.getScaledHeight() / 2 - 5 * 0.01), 75, 20, "Singleplayer"));
        this.buttonList.add(new MenuButton(5, s.getScaledWidth() / 2 - 420, s.getScaledHeight() / 2 - 0, 75, 20, "Capes"));
        this.buttonList.add(new MenuButton(3, s.getScaledWidth() / 2 + 160, s.getScaledHeight() / 2 - 10, 75, 20, "Settings"));
        this.buttonList.add(new MenuButton(4, s.getScaledWidth() / 2 + 250, s.getScaledHeight() / 2 - 5, 75, 20, "HUD"));
        this.buttonList.add(new MenuButton(6, s.getScaledWidth() / 2 + 340, s.getScaledHeight() / 2 - 0, 75, 20, "Alt Manager"));
        this.buttonList.add(new MenuButton(7, s.getScaledWidth() / 2 - 72, s.getScaledHeight() / 2 + 25, 75, 20, "Background"));
        this.buttonList.add(new MenuButton(6, s.getScaledWidth() / 2 + 5, s.getScaledHeight() / 2 + 25, 75, 20, "Alt Manager"));
    }

    @Override
    public void drawScreen(int p_drawScreen_1_, int p_drawScreen_2_, float p_drawScreen_3_) {
        if(background == BackgroundEnum.BACKGROUND_1) {
            mc.getTextureManager().bindTexture(BACKGROUND1);
        } else if(background == BackgroundEnum.BACKGROUND_2){
            mc.getTextureManager().bindTexture(BACKGROUND2);
        } else if(background == BackgroundEnum.BACKGROUND_3){
            mc.getTextureManager().bindTexture(BACKGROUND3);
        } else if(background == BackgroundEnum.BACKGROUND_4){
            mc.getTextureManager().bindTexture(BACKGROUND4);
        }
        Gui.drawModalRectWithCustomSizedTexture(-21 + Mouse.getX() / 90, Mouse.getY() * -1 / 90, 0.0F, 0.0F, s.getScaledWidth() + 20, s.getScaledHeight() + 20, (float)(s.getScaledWidth() + 21), (float)(s.getScaledHeight() + 20));
        BlurUtil.blur2(0, 0, 1920, 1080, 200,200);
        RenderUtil.drawImage(new ResourceLocation("client/images/remainder-menu-text.png"), 0, 0, s.getScaledWidth(), s.getScaledHeight());
        RenderUtil.drawImage(new ResourceLocation("client/icons/exit-button.png"), s.getScaledWidth() - 21.0f, s.getScaledHeight() / 50 - 1, 12, 12);
        FontUtil.normal.drawString("Toggle Display", s.getScaledWidth() - 95, s.getScaledHeight() / 50 + 2, 0xFFFFFF);
        RenderUtil.drawRoundedOutline(s.getScaledWidth() - 25, s.getScaledHeight() / 50 - 5, s.getScaledWidth() - 5, s.getScaledHeight() / 50 + 15, 5, 2, -1);
        RenderUtil.drawRoundedOutline(s.getScaledWidth() - 100, s.getScaledHeight() / 50 - 5, s.getScaledWidth() - 30, s.getScaledHeight() / 50 + 15, 5, 2, -1);
        super.drawScreen(p_drawScreen_1_, p_drawScreen_2_, p_drawScreen_3_);
    }

    @Override
    public void onGuiClosed() {
        Minecraft.getMinecraft().entityRenderer.loadEntityShader(null);
        super.onGuiClosed();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        if (button.id == 2) {
            mc.displayGuiScreen(new GuiSelectWorld(this));
        }
        if (button.id == 1) {
            mc.displayGuiScreen(new GuiMultiplayer(this));
        }
        if (button.id == 3) {
            mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
        }
        if (button.id == 4) {
            mc.displayGuiScreen(new HUDConfigScreen());
        }

        if(button.id == 6) {
            mc.displayGuiScreen(new AltManagerGui());

        }

        if(button.id == 7) {
            if(background == BackgroundEnum.BACKGROUND_1) {
                background = BackgroundEnum.BACKGROUND_2;
            } else if(background == BackgroundEnum.BACKGROUND_2){
                background = BackgroundEnum.BACKGROUND_3;
            } else if(background == BackgroundEnum.BACKGROUND_3){
                background = BackgroundEnum.BACKGROUND_4;
            } else if(background == BackgroundEnum.BACKGROUND_4){
                background = BackgroundEnum.BACKGROUND_1;
            }
        }

        super.actionPerformed(button);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int p_mouseClicked_3_) throws IOException {
        super.mouseClicked(mouseX, mouseY, p_mouseClicked_3_);
        ScaledResolution s = new ScaledResolution(mc);
        if (mouseX >= s.getScaledWidth() - 25 && mouseX <= s.getScaledWidth() - 5 && mouseY >= s.getScaledHeight() / 50 - 5 && mouseY <= s.getScaledHeight() / 50 + 15) {
            mc.shutdown();
            Logger.info("Shutting down!");
        }
        if (mouseX >= s.getScaledWidth() - 100 && mouseX <= s.getScaledWidth() - 30 && mouseY >= s.getScaledHeight() / 50 - 5 && mouseY <= s.getScaledHeight() / 50 + 15){
                mc.gameSettings.guiScale = 1;
                refresh();
        }
    }
}
