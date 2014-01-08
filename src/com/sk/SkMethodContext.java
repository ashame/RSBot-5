package com.sk;

import org.powerbot.script.AbstractScript;
import org.powerbot.script.methods.MethodContext;

import com.sk.methods.Combat;
import com.sk.methods.SkKeyboard;
import com.sk.methods.action.ActionBar;

public final class SkMethodContext extends MethodContext {

	public boolean debug;

	public SkKeyboard keyboard;
	public ActionBar actionBar;
	public Combat combat;

	public AbstractScript script;
	public MethodContext sup;

	public SkMethodContext(boolean debug, AbstractScript script, MethodContext c) {
		super(MethodContext.newContext(c.getBot()));
		this.debug = debug;
		this.script = script;
        this.keyboard = new SkKeyboard(this);
        this.combat = new Combat(this);
		this.sup = c;
	}

	public SkMethodContext(AbstractScript script, MethodContext c) {
		this(false, script, c);
	}
}
