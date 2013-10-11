package org.nathantehbeast.scripts.furbuyer.jobs;

import org.nathantehbeast.api.framework.Node;
import org.nathantehbeast.api.framework.context.Context;
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

    public BankFurs(Context ctx) {
        super(ctx);
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
            ctx.bank.close();
        }
    }
}
