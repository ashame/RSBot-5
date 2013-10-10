package org.nathantehbeast.scripts.aiominer;

import org.nathantehbeast.api.framework.Script;
import org.nathantehbeast.api.framework.methods.Context;
import org.powerbot.script.Manifest;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 7/25/13
 * Time: 8:07 PM
 * To change this template use File | Settings | File Templates.
 */
@Manifest(
        authors = "Nathan L",
        name = "Nathan's AIO Miner",
        description = "Currently being rewritten.",
        version = 1.2,
        hidden = true
)

public class v5Miner extends Script {

    public Context ctx;

    public v5Miner() {
        this.ctx = new Context(super.ctx);
    }

    @Override
    public boolean setup() {
        return true;
    }

    @Override
    public void loop() {
    }

    @Override
    public void exit() {
    }

    @Override
    public void onRepaint(Graphics2D g) {
        g.drawString("Current Node: "+currentNode, 15, 15);
    }
}
