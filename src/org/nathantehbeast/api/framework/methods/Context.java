package org.nathantehbeast.api.framework.methods;

import com.sk.SkMethodContext;
import org.powerbot.script.AbstractScript;
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

    public SkMethodContext sk;
    public AbstractScript script;
    public GameObject gameObject;

    public Context(final MethodContext ctx) {
        super(ctx.getBot());
        this.running = true;
        this.executor = Executors.newCachedThreadPool();
        this.sk = new SkMethodContext(script, this);
        this.gameObject = new GameObject(this);
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
