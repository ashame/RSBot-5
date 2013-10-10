package org.nathantehbeast.scripts.aiominer;

import org.nathantehbeast.api.framework.Script;
import org.nathantehbeast.api.framework.methods.Context;
import org.nathantehbeast.scripts.aiominer.Constants.*;

import org.powerbot.script.Manifest;

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
        version = 1.15,
        hidden = true
)

public class v5Miner extends Script {

    private static Ore ore;
    private static int radius;
    public Context ctx;

    public v5Miner() {
        this.ctx = new Context(super.ctx);
    }

    @Override
    public boolean setup() {
        new GUI(ctx);
        return true;
    }

    @Override
    public void loop() {
    }

    @Override
    public void exit() {
    }

    public static void setOre(Ore o) {
        ore = o;
    }

    public static void setRadius(int i) {
        radius = i;
    }

}
