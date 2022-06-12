package me.geesy.remainder;

import com.google.common.eventbus.EventBus;
import lombok.Getter;
import me.geesy.remainder.event.EventManager;
import me.geesy.remainder.event.EventTarget;
import me.geesy.remainder.event.impl.ClientTick;
import me.geesy.remainder.io.Config;
import me.geesy.remainder.managers.HudManager;
import me.geesy.remainder.managers.ModManager;
import me.geesy.remainder.ui.configscreen.HUDConfigScreen;
import me.geesy.remainder.ui.util.BlurUtil;
import me.geesy.remainder.util.AntiCheat;
import me.geesy.remainder.util.Keybinds;
import me.geesy.remainder.util.Logger;
import me.geesy.remainder.util.font.FontUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.util.MovingObjectPosition;
import org.lwjgl.opengl.Display;

@Getter
public final class Client {

    @Getter private static Client instance;
    @Getter private static Minecraft mc = Minecraft.getMinecraft();

    @EventTarget
    public void tickEvent(ClientTick tick){
        if (mc.gameSettings.keyBindAttack.isKeyDown() && mc.thePlayer != null && mc.theWorld != null && mc.pointedEntity == null && mc.thePlayer.isBlocking() && mc.thePlayer.onGround && !mc.thePlayer.isRiding()  && mc.thePlayer.isUsingItem() && mc.objectMouseOver != null && mc.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            mc.thePlayer.swingItem();

        }
        if(Keybinds.HUD_CONFIG.isPressed()){
            mc.displayGuiScreen(new HUDConfigScreen());
        }
        this.getModManager().toggleSprint.setEnabled(this.getHudManager().toggleSprintMod.isEnabled());
        this.modManager.fullBright.setEnabled(this.getHudManager().brightnessMod.isEnabled());

        if (Keybinds.SNAPLOOK.isKeyDown() && this.getHudManager().snapLookMod.isEnabled()) {
            this.getModManager().perspective.setEnabled(true);
        }

        if (mc.gameSettings.keyBindAttack.isKeyDown() && mc.thePlayer != null && mc.theWorld != null && mc.pointedEntity == null && mc.thePlayer.isBlocking() && mc.thePlayer.onGround && !mc.thePlayer.isRiding()  && mc.thePlayer.isUsingItem() && mc.objectMouseOver != null && mc.objectMouseOver.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
            mc.thePlayer.swingItem();
        }

        if (Keybinds.ZOOM.isKeyDown()) {
            this.modManager.customZoom.setEnabled(true);
        } else if(!Keybinds.ZOOM.isKeyDown()) {
            this.modManager.customZoom.setEnabled(false);
        }
    }

    private ModManager modManager;
    public EventManager eventM;
    private HudManager hudManager;
    private Config config;
    public void start() {
        instance = this;
        AntiCheat.removeCheats();
        Display.setTitle("Remaidner - " + this.getVersion());
        Logger.info("Starting Up.");
        eventM.register(this);
        (this.config = new Config()).loadModConfig();
        this.hudManager = new HudManager();
        this.modManager = new ModManager();
        BlurUtil.initFboAndShader();
        FontUtil.bootstrap();
    }

    public void stop() {
        config.saveModConfig();
        eventM.unregister(this);
        Logger.info("Shutting Down.");
    }

    public String getName(){
        return "Remainder";
    }

    public String getVersion() {
        return "3.0.0";
    }
}
