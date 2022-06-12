package me.geesy.remainder.modules.hud;

import me.geesy.remainder.util.font.FontUtil;
import org.lwjgl.input.Mouse;
import me.geesy.remainder.managers.HudMod;

import java.util.ArrayList;
import java.util.List;

public class CPSMod extends HudMod
{
    private List<Long> clicks;
    private boolean wasPressed;
    private long lastPressed;
    private List<Long> clicks2;
    private boolean wasPressed2;
    private long lastPressed2;

    public CPSMod() {
        super("CPSMod", 50, 50, "client/mod/client/cps.png");
        this.clicks = new ArrayList<Long>();
        this.clicks2 = new ArrayList<Long>();
    }

    private void drawCps1() {
        FontUtil.normal.drawCenteredString("CPS [" + String.valueOf(this.getCPS()) + "]", (float)this.getX(), (float)this.getY(), -1);
    }

    @Override
    public void draw() {
        final boolean lpressed = Mouse.isButtonDown(0);
        final boolean rpressed = Mouse.isButtonDown(1);
        if (lpressed != this.wasPressed) {
            this.lastPressed = System.currentTimeMillis();
            this.wasPressed = lpressed;
            if (lpressed) {
                this.clicks.add(this.lastPressed);
            }
        }
        else if (rpressed != this.wasPressed2) {
            this.lastPressed2 = System.currentTimeMillis() + 10L;
            if (this.wasPressed2 == rpressed) {
                this.clicks2.add(this.lastPressed2);
            }
        }
        try {
                this.drawCps1();
        }
        catch (NullPointerException ignored) {}
        super.draw();
    }

    @Override
    public void renderDummy(final int mouseX, final int mouseY) {
            this.drawCps1();
        super.renderDummy(mouseX, mouseY);
    }

    @Override
    public int getWidth() {
        return this.fr.getStringWidth("1 | 1") + 1;
    }

    @Override
    public int getHeight() {
        return this.fr.FONT_HEIGHT + 1;
    }

    private int getCPS() {
        final long time = System.currentTimeMillis();
        this.clicks.removeIf(aLong -> aLong + 1000L < time);
        return this.clicks.size();
    }

    private int getCPS2() {
        final long time2 = System.currentTimeMillis();
        this.clicks2.removeIf(aLong2 -> aLong2 + 1000L < time2);
        return this.clicks2.size();
    }
}
