package me.geesy.remainder.mixin;

import me.geesy.remainder.Client;
import net.minecraft.network.play.*;
import net.minecraft.client.network.*;
import net.minecraft.client.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.network.play.server.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ NetHandlerPlayClient.class })
public abstract class MixinNetHandlerPlayClient implements INetHandlerPlayClient {
    @Shadow
    private Minecraft gameController;

    @Inject(method = {"handleTimeUpdate"}, at = {@At("HEAD")}, cancellable = true)
    private void handleTimeUpdate(final S03PacketTimeUpdate packetIn, final CallbackInfo ci) {
        S03PacketTimeUpdate packet = packetIn;
        if (Client.getInstance().getHudManager().timeChangerMod.isEnabled()) {
            packet = new S03PacketTimeUpdate(packet.getWorldTime(), -6000L, true);
        }
        PacketThreadUtil.checkThreadAndEnqueue(packet, this, this.gameController);
        this.gameController.theWorld.setTotalWorldTime(packetIn.getTotalWorldTime());
        this.gameController.theWorld.setWorldTime(packetIn.getWorldTime());
        ci.cancel();
    }
}