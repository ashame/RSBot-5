package org.nathantehbeast.scripts.furbuyer.jobs;

import org.nathantehbeast.api.framework.Node;
import org.nathantehbeast.api.framework.context.Context;
import org.nathantehbeast.api.framework.utils.Logger;
import org.nathantehbeast.scripts.furbuyer.FurMain;
import org.powerbot.script.util.Timer;
import org.powerbot.script.wrappers.Tile;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/11/13
 * Time: 3:14 AM
 * To change this template use File | Settings | File Templates.
 */

public class BankFurs extends Node {

    FurMain main;

    public BankFurs(Context ctx, FurMain main) {
        super(ctx);
        this.main = main;
    }

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public boolean activate() {
        return ctx.inventory.isFull() && ctx.players.local().getLocation().distanceTo(new Tile(3187, 3436, 0)) <= 4;
    }

    @Override
    public void execute() {
        if (ctx.bank.open()) {
            final Timer t = new Timer(5000);
            while (t.isRunning() && ctx.inventory.isFull()) {
                ctx.bank.depositInventory();
                sleep(1000);
            }
            Logger.log("Runtime: "+Timer.format(System.currentTimeMillis() - main.startTime));
            Logger.log("Furs Bought: "+main.fursBought);
            ctx.bank.close();
        }
    }
}
