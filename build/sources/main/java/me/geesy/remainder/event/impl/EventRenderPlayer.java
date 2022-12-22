package me.geesy.remainder.event.impl;

import me.geesy.remainder.event.Event;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;

public class EventRenderPlayer extends Event {
	public EntityPlayer player;
	public RenderPlayer renderer;
	public float partialRenderTick;
	public double x;
	public double y;
	public double z;

	public EventRenderPlayer(final EntityPlayer player, final RenderPlayer renderer, final float partialRenderTick, final double x, final double y, final double z) {
		this.player = player;
		this.renderer = renderer;
		this.partialRenderTick = partialRenderTick;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public EntityPlayer getPlayer() { return player; }

	public void setPlayer(final EntityPlayer player) { this.player = player; }

	public RenderPlayer getRenderer() { return renderer; }

	public void setRenderer(final RenderPlayer renderer) { this.renderer = renderer; }

	public float getPartialRenderTick() { return partialRenderTick; }

	public void setPartialRenderTick(final float partialRenderTick) { this.partialRenderTick = partialRenderTick; }

	public double getX() { return x; }

	public void setX(final double x) { this.x = x; }

	public double getY() { return y; }

	public void setY(final double y) { this.y = y; }

	public double getZ() { return z; }

	public void setZ(final double z) { this.z = z; }
}