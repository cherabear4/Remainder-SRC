package me.geesy.remainder.mixin;

import lombok.Getter;
import net.minecraft.client.gui.Gui;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Gui.class)
public class MixinGui {
    private static final Gui instance = new Gui();
}
