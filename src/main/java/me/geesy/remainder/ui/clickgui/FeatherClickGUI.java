package me.geesy.remainder.ui.clickgui;

import me.geesy.remainder.Client;
import me.geesy.remainder.managers.HudMod;
import me.geesy.remainder.ui.clickgui.comp.FeatherCard;
import me.geesy.remainder.ui.util.BlurUtil;
import me.geesy.remainder.ui.util.GlUtil;
import me.geesy.remainder.ui.util.RenderUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class FeatherClickGUI extends GuiScreen {
    public static Minecraft mc = Minecraft.getMinecraft();

    public static int scrolled;
    public static boolean scrollLocked;
    private int x = 97;
    private int y = 127;
    private int xAdd = 0;
    private int xFactor = 157;
    private int yAdd = 0;
    private int spots = 0;
    private GuiTextField searchField;
    public boolean filtered;
    public ScaledResolution sr = new ScaledResolution(mc);

    ArrayList<FeatherCard> featherCard = new ArrayList<>();
    public ArrayList<HudMod> hudMods = new ArrayList<>();
    Client INSTANCE = new Client();


    @Override
    public void onGuiClosed() {
        //Removing the blur on close
        mc.entityRenderer.loadEntityShader(null);
        Keyboard.enableRepeatEvents(false);
        super.onGuiClosed();
    }

    public void drawMods() {
        //Adds the mods from the ModFrame class automatically
        this.featherCard.clear();


        while ((spots * xFactor) < (350)) {
            spots++;
        }
        for (HudMod m : Client.getInstance().getHudManager().hudMods) {
            if (xAdd == (spots * xFactor) && xAdd != 0) {
                xAdd = 0;
                yAdd += 105;
            }
            //Mapping out cards with the given props from the mods and what not
            this.featherCard.add(new FeatherCard(x + 200 + xAdd, y + 50 + yAdd, 65, mc.fontRendererObj.FONT_HEIGHT + 5, m, new ResourceLocation(m.image)));
            xAdd += xFactor;



        }
    }



    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        //Scrolling!!
        BlurUtil.blur2(0, 0, 1920, 1080, 0, 0);
        
        //Getting the scroll wheel
        int eventDWheel = Mouse.getDWheel();


        if (eventDWheel < 0) {
            scrolled -= 10;
            //System.out.println("Scrolling down");
        } else if (eventDWheel > 0) {
            scrolled += 10;
            //Scrolling up
        }
        
        if(scrolled < 0) { //prevents scrolling where we dont need to scroll
            scrolled = (spots * xFactor) - (spots * xFactor);
        }
        if(scrolled > (spots * xFactor) + 50) {
            //i believe (i forgot) that this resets the scrolling if we go too far down
            scrolled = (spots * xFactor) - (spots * xFactor);
        }
        ScaledResolution sr = new ScaledResolution(mc);

        //Card
        RenderUtil.drawSmoothRoundedRect(229, 60, 960 - 245, 505 - 60, 10, new Color(0, 0, 0,170).getRGB());
        //Navbar
        RenderUtil.drawSmoothRoundedRect(229, 60, 960 - 245, 505 / 5 - 5, 3, new Color(0,0,0, 134).getRGB());
        //Searchbar
        //this.searchField.drawSeachField();

            //Scissor for scrolling to cut off the mods
            GL11.glEnable(GL11.GL_SCISSOR_TEST);
            GlUtil.scissor(213, 100, 960 - 219, 505 - 60);
            RenderUtil.drawRoundedRect(960 - 249, 95 + scrolled, 960 - 247, 155 + scrolled - 5, 3, new Color(230,235,235,235).getRGB());
            GL11.glDisable(GL11.GL_SCISSOR_TEST);
            GL11.glEnable(GL11.GL_SCISSOR_TEST);
            GlUtil.scissor(213, 505 / 5 - 5, 960 - 219, 505 - 60);

            for(FeatherCard m : featherCard) {

                m.drawFrame();
            }
            GL11.glDisable(GL11.GL_SCISSOR_TEST);




        RenderUtil.drawImage(new ResourceLocation("client/images/remainder_background.png"), 230, 32, 87, 87, 1);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() {

        //mc.entityRenderer.loadShader(new ResourceLocation("client/blur.json"));
        super.initGui();

        //Drawing the mods from above
        this.drawMods();
        (this.searchField = new GuiTextField(100, this.fontRendererObj, 960 - 408, 70, 960 - 808, 20)).setFocused(true);
        Keyboard.enableRepeatEvents(true);

    }



    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        // If clicked it toggles the mod
        super.mouseClicked(mouseX, mouseY, mouseButton);
        for(FeatherCard m : featherCard) {
            m.onClick(mouseX, mouseY, mouseButton);

        }

        try {
            super.mouseClicked(mouseX, mouseY, mouseButton);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.searchField.mouseClicked(mouseX, mouseY, mouseButton);

    }
    
    //Methods for the search bar
    @Override
    protected void keyTyped(final char character, final int key) throws IOException {
        try {
            super.keyTyped(character, key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (character == '\t' && !this.searchField.isFocused()) {
            this.searchField.setFocused(true);
        }
        if (character == '\r') {
            this.featherCard.clear();
            for (HudMod m : Client.getInstance().getHudManager().hudMods) {
                
                //Search function
                if (m.name.toLowerCase().startsWith(this.searchField.getText().toLowerCase()) || m.name.toLowerCase().contains(this.searchField.getText().toLowerCase())) {
                    while ((spots * xFactor) < (350)) {
                        spots++;
                    }
                    for (HudMod j : Client.getInstance().getHudManager().hudMods) {
                        if (xAdd == (spots * xFactor) && xAdd != 0) {
                            xAdd = 0;
                            yAdd += 105;
                        }

                        //Rendering cards based off of the search?
                        this.featherCard.add(new FeatherCard(x + 200 + xAdd, y + yAdd, 65, mc.fontRendererObj.FONT_HEIGHT + 5, j, new ResourceLocation(j.image)));


                        xAdd += xFactor;
                    }
                }
            }
        }
        this.searchField.textboxKeyTyped(character, key);
    }

    @Override
    public void updateScreen() {
        this.searchField.updateCursorCounter();
    }

}
