package org.nathantehbeast.scripts.winegrabber.jobs;

import com.sk.util.time.TimedCondition;
import org.nathantehbeast.api.framework.Node;
import org.nathantehbeast.api.framework.context.Context;
import org.powerbot.script.methods.Bank;
import org.powerbot.script.wrappers.Tile;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/10/13
 * Time: 11:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class BankItems extends Node {

    public BankItems(Context ctx) {
        super(ctx);
    }

    @Override
    public int priority() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean activate() {
        return ctx.inventory.isFull() && ctx.players.local().getLocation().distanceTo(new Tile(2945, 3370, 0)) <= 8;
    }

    @Override
    public void execute() {
        if (ctx.bank.open()) {
            new TimedCondition() {
                @Override
                public boolean check() {
                    return ctx.bank.isOpen();
                }
            }.waitFor(3000);
            ctx.bank.deposit(245, Bank.Amount.ALL);
            new TimedCondition() {
                @Override
                public boolean check() {
                    return ctx.backpack.count() == 1;
                }
            }.waitFor(1500);
            ctx.bank.close();
        }
    }
}
