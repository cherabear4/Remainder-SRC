package me.geesy.remainder.managers;

import me.geesy.remainder.modules.hud.*;
import java.util.ArrayList;

public class HudManager {
	
	public ArrayList<HudMod> hudMods = new ArrayList<>();
	
	public WatermarkMod testMod;
	public FPSMod fps;
	public PotCounter potCounter;
	
	public TargetHUD targetHud;
	public SessionInfoMod sessionInfo;
	public Keystrokes keystrokes;
	public Xyz xyz;
	public PotStatus potStatus;
	public Ping ping;
	
	public NoHurtCam noHurtCam;
	public SlowArm slowArm;
	public SmallItem smallItem;
	
	public ArmorStatusMod armorStatusMod;

	public VapeOverlayMod vapeOverlayMod;

	public FontMod fontMod;

	public SnaplookMod snapLookMod;

	public AutoGLHFMod autoGLHFMod;

	public ItemPhysics itemPhysics;

	public TimeChangerMod timeChangerMod;

	public CPSMod cpsMod;

	public MotionBlur motionBlurMod;

	public FlyBoost flyBoost;

	public PackdisplayMod packdisplayMod;

	public Brightness brightnessMod;

	public ToggleSprintMod toggleSprintMod;

	
	public HudManager() {
		hudMods.add(testMod = new WatermarkMod());
		hudMods.add(fps = new FPSMod());
		hudMods.add(targetHud = new TargetHUD());
		hudMods.add(keystrokes = new Keystrokes());
		hudMods.add(xyz = new Xyz());
		hudMods.add(potCounter = new PotCounter());
		hudMods.add(potStatus = new PotStatus());
		hudMods.add(ping = new Ping());
		//hudMods.add(slowArm = new SlowArm());
		//hudMods.add(smallItem = new SmallItem());
		hudMods.add(armorStatusMod = new ArmorStatusMod());
		hudMods.add(vapeOverlayMod = new VapeOverlayMod());
		hudMods.add(sessionInfo = new SessionInfoMod());
		hudMods.add(snapLookMod = new SnaplookMod());
		//hudMods.add(autoGLHFMod = new AutoGLHFMod());
		//hudMods.add(itemPhysics = new ItemPhysics());
		hudMods.add(timeChangerMod = new TimeChangerMod());
		hudMods.add(cpsMod = new CPSMod());
		//hudMods.add(flyBoost = new FlyBoost());
		hudMods.add(motionBlurMod = new MotionBlur());
		hudMods.add(packdisplayMod = new PackdisplayMod());
		hudMods.add(brightnessMod = new Brightness());
		hudMods.add(toggleSprintMod = new ToggleSprintMod());

	}
	
	public void renderMods() {
		for(HudMod m : hudMods) {
			if (m.isEnabled()) {
				m.draw();
			}

		}


	}
}
