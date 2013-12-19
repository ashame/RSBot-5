package org.nathantehbeast.api.framework;

import com.sk.SkMethodContext;
import org.powerbot.event.PaintListener;
import org.powerbot.script.methods.Environment;

import org.nathantehbeast.api.framework.context.Context;
import org.nathantehbeast.api.framework.methods.LoopTask;
import org.nathantehbeast.api.framework.utils.Logger;
import org.powerbot.script.PollingScript;
import org.powerbot.script.methods.MethodContext;

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
public abstract class Script extends PollingScript implements PaintListener {

    private final List<Node> container = Collections.synchronizedList(new ArrayList<Node>());
    public Node currentNode;
    private boolean logger = Environment.getDisplayName().equalsIgnoreCase("nathan l");
    public int delay = 600;
    public Context ctx;
    public SkMethodContext sk;

    public Script() {
        this.ctx = new Context(super.ctx, this);
        this.ctx.init(super.ctx);
    }

    public int getContainerSize() {
        return container.size();
    }

    public synchronized final void provide(final Node... nodes) {
        if (nodes != null) {
            for (Node node : nodes) {
                if (!container.contains(node)) {
                    container.add(node);
                    Logger.log("Providing: " + node);
                }
            }
        }
    }

    @Override
    public void start() {
        if (logger) {
            Logger.log("Attaching logger");
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
            } catch (Exception ignored) {
            }
            stop();
        }
    }

    public abstract boolean setup();

    @Override
    public int poll() {
        try {
            if (container != null) {
                synchronized (container) {
                    for (Node node : container) {
                        if (node.activate()) {
                            node.execute();
                            currentNode = node;
                        }
                    }
                }
            }
            loop();
        } catch (Exception e) {
            e.printStackTrace();
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

    @Override
    public void repaint(Graphics g) {
        onRepaint((Graphics2D) g);
    }

    public abstract void onRepaint(Graphics2D g);

}
