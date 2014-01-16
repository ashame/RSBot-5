package org.nathantehbeast.api.framework.methods;

import org.nathantehbeast.api.framework.context.Context;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/8/13
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class LoopTask extends Task {
    private boolean running;

    public LoopTask(final Context ctx) {
        super(ctx);
        this.running = true;
    }

    public abstract int loop();

    @Override
    public void run() {
        while (running && ctx.isRunning()) {
            try {
                final int wait = loop();
                if (wait > 0) {
                    Thread.sleep(wait);
                } else {
                    running = false;
                }
            } catch (final Throwable t) {
                t.printStackTrace();
            }
        }
    }
}
