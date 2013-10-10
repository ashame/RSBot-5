package org.nathantehbeast.api.framework;

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

    public Context(final MethodContext ctx) {
        super(ctx.getBot());

        this.running = true;
        this.executor = Executors.newCachedThreadPool();
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
