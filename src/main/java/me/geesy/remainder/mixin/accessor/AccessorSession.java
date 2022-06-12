package me.geesy.remainder.mixin.accessor;

import net.minecraft.util.Session;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Session.class)
public class AccessorSession {
    public Session getSession() {
        return null;
    }

    public void setSession(Session session) {
    }
}
