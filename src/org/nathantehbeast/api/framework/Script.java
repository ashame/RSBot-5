package org.nathantehbeast.api.framework;

import org.nathantehbeast.api.tools.Logger;
import org.powerbot.script.PollingScript;
import org.powerbot.script.methods.Environment;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/8/13
 * Time: 3:47 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Script extends PollingScript {

    private static final List<Node> container = Collections.synchronizedList(new ArrayList<Node>());
    public Node currentNode;
    public int delay = 600;
    private boolean logger = Environment.getDisplayName().equalsIgnoreCase("nathantehbeast");
    private Context ctx = new Context(getContext());

    public synchronized final void provide(final Node... nodes) {
        if (nodes != null) {
            for (Node node : nodes) {
                if (!container.contains(node)) {
                    container.add(node);
                    Logger.log("Providing: "+node);
                }
            }
        }
    }

    public synchronized final void revoke(final Node... nodes) {
        if (nodes != null) {
            for (Node node : nodes) {
                if (container.contains(node)) {
                    container.remove(node);
                    Logger.log("Revoking: "+node);
                }
            }
        }
    }

    @Override
    public void start() {
        ctx.init(getContext());
        if (logger) {
            new Logger(new Font("Calibri", Font.PLAIN, 11));
            ctx.getExecutor().submit(new LoopTask(ctx) {
                @Override
                public int loop() {
                    Logger.updateTime();
                    return 1000;
                }
            });
        }
        if (!setup()) {
            Logger.log("There was an error starting the script.");
            try {
                Logger.remove();
            } catch (Exception ignored) {}
            stop();
        }
    }

    public abstract boolean setup();

    @Override
    public int poll() {
        try {
            loop();
        } catch (Exception e) {
            Logger.log("Timer pls fix internal errors");
        }
        return delay;
    }

    public abstract void loop();

    @Override
    public void stop() {
        if (logger)
            Logger.remove();
        exit();
    }

    public abstract void exit();

}
