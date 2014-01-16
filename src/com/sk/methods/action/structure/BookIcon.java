package com.sk.methods.action.structure;

import org.powerbot.script.wrappers.Component;

import org.nathantehbeast.api.framework.context.Context;


public interface BookIcon extends WindowedIcon {
	public int getChildIndex();

	public int getChildTexture();
	
	public int getWidget();
	
	public Component getCooldownComponent(Context ctx);
	
	public static final BookIcon NIL = Ability.NIL;
	
	public static final int MAIN_COMPONENT = 1, COOLDOWN_COMPONENT = 2;
}
