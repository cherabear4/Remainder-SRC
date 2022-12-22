package me.geesy.remainder.modules.hud;
import me.geesy.remainder.managers.HudMod;
import me.geesy.remainder.util.font.FontUtil;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

//Iconic client armorStatus

public class ArmorStatusMod extends HudMod {
	
    

    public ArmorStatusMod() {
		super("ArmorStatus", 100, 100, "client/mod/client/amorstatus.png");
		// TODO Auto-generated constructor stub
	}

	public void draw() {
        this.getArmorValues();
        super.draw();
    }

    public void renderDummy(int mouseX, int mouseY) {
        int number = 0;
        this.renderItem(number, new ItemStack(Items.diamond_helmet));
        ++number;
        this.renderItem(number, new ItemStack(Items.diamond_chestplate));
        ++number;
        this.renderItem(number, new ItemStack(Items.diamond_leggings));
        ++number;
        this.renderItem(number, new ItemStack(Items.diamond_boots));
        super.renderDummy(mouseX, mouseY);
    }

    private void getArmorValues() {
        int number = 3;
        int iVal = 0;

        for(int i = 0; i < this.mc.thePlayer.inventory.armorInventory.length; ++i) {
            ItemStack itemStack = this.mc.thePlayer.inventory.armorInventory[i];
            this.renderItem(number - i, itemStack);
            ++iVal;
        }

    }

    private void renderItem(int i, ItemStack is) {
        if (is != null) {
            GL11.glPushMatrix();
            int yVal = this.getY() + this.fr.FONT_HEIGHT * i * 2;
            int xVal = this.getX();
            if (is.getItem().isDamageable()) {
                double damage = (double)(is.getMaxDamage() - is.getItemDamage()) / (double)is.getMaxDamage() * 100.0D;
                FontUtil.normal.drawString(String.format("%.2f%%", damage), (float)(xVal + 20), (float)(yVal + 4), -1);
            } else {
                String number = String.valueOf(is.stackSize);
                if (!number.equals("1") && !number.equals("0")) {
                    this.fr.drawStringWithShadow(number, (float)(xVal + 20), (float)(yVal + 4), -1);
                }
            }

            RenderHelper.enableGUIStandardItemLighting();
            this.mc.getRenderItem().renderItemAndEffectIntoGUI(is, xVal, yVal);
            GL11.glPopMatrix();
        }
    }

    public int getWidth() {
        return this.fr.getStringWidth(this.name);
    }

    public int getHeight() {
        return this.fr.FONT_HEIGHT;
    }
}
