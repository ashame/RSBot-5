package org.nathantehbeast.scripts.furbuyer.jobs;

import org.nathantehbeast.api.framework.Node;
import org.nathantehbeast.api.framework.context.Context;
import org.powerbot.script.wrappers.Tile;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/11/13
 * Time: 3:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class TraverseFurs extends Node {

    public TraverseFurs(Context ctx) {
        super(ctx);
    }

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public boolean activate() {
        return ctx.players.local().getLocation().distanceTo(new Tile(3218, 3435, 0)) > 6 && !ctx.inventory.isFull();
    }

    @Override
    public void execute() {
        ctx.walking.walkPath(new Tile(3187, 3436, 0), new Tile(3218, 3435, 0), "toFurs");
    }
}
