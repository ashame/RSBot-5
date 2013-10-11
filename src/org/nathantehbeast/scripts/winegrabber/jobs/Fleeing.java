package org.nathantehbeast.scripts.winegrabber.jobs;

import org.nathantehbeast.api.framework.Node;
import org.nathantehbeast.api.framework.context.Context;
import org.powerbot.script.wrappers.Tile;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/11/13
 * Time: 12:21 AM
 * To change this template use File | Settings | File Templates.
 */
public class Fleeing extends Node {

    public Fleeing(Context ctx) {
        super(ctx);
    }

    @Override
    public int priority() {
        return 1;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean activate() {
        return ctx.players.local().isInCombat();
    }

    @Override
    public void execute() {
        ctx.walking.walkPath(new Tile(2949, 3475, 0), new Tile(2948, 3452, 0));
    }
}
