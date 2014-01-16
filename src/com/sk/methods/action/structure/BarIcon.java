package com.sk.methods.action.structure;

import org.powerbot.script.wrappers.Component;
import org.powerbot.script.wrappers.Identifiable;
import org.powerbot.script.wrappers.Validatable;

import org.nathantehbeast.api.framework.context.Context;

public interface BarIcon extends Validatable, Identifiable {

	public Component getComponent(Context ctx);

	public static final BarIcon NIL = Ability.NIL;
}
