package org.nathantehbeast.api.framework.context;

import com.sk.methods.Combat;
import com.sk.methods.SkKeyboard;
import com.sk.methods.action.ActionBar;
import org.nathantehbeast.api.framework.methods.*;
import org.powerbot.script.methods.MethodContext;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/8/13
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */

public class Context extends MethodContext {

    private final ExecutorService executor;
    private boolean running;

    public GameObject gameObject;
    public Skills skill;
    public Walking walking;
    public Inventory inventory;
    public Lodestone lodestone;

    public SkKeyboard skKeyboard;
    public ActionBar actionBar;
    public Combat combat;

    public Context(final MethodContext ctx) {
        super(ctx.getBot());
        this.running = true;
        this.executor = Executors.newCachedThreadPool();
        this.gameObject = new GameObject(this);
        this.skill = new Skills(this);
        this.walking = new Walking(this);
        this.inventory = new Inventory(this);
        this.skKeyboard = new SkKeyboard(this);
        this.actionBar = new ActionBar(this);
        this.combat = new Combat(this);
        this.lodestone = new Lodestone(this);
    }

    @Override
    public void init(MethodContext ctx) {
        super.init(ctx);
    }

    public void shutdownExecutor() {
        this.running = false;
        executor.shutdown();
    }

    public ExecutorService getExecutor() {
        return this.executor;
    }

    public boolean isRunning() {
        return this.running;
    }
}
