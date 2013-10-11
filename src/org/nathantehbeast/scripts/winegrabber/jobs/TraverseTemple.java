package org.nathantehbeast.scripts.winegrabber.jobs;

import org.nathantehbeast.api.framework.Node;
import org.nathantehbeast.api.framework.context.Context;
import org.powerbot.script.wrappers.Tile;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/10/13
 * Time: 11:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class TraverseTemple extends Node {

    public TraverseTemple(Context ctx) {
        super(ctx);
    }

    @Override
    public int priority() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean activate() {
        return ctx.backpack.count() == 1 && ctx.players.local().getLocation().distanceTo(new Tile(2951, 3474, 0)) > 5 && !ctx.bank.isOpen();
    }

    @Override
    public void execute() {
        if (ctx.players.local().getLocation().distanceTo(new Tile(2945, 3367, 0)) <= 8) {
            ctx.actionBar.getActionAt(1).select();
            //Lodestone stuff
        } else {
            ctx.walking.walkPath(new Tile(2965, 3401, 0), new Tile(2951, 3474, 0));
        }
    }
}
