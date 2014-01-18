package org.nathantehbeast.scripts.furbuyer.jobs;

import org.nathantehbeast.api.framework.Node;
import org.nathantehbeast.api.framework.context.Context;
import org.powerbot.script.wrappers.Tile;
import org.powerbot.script.wrappers.TilePath;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/11/13
 * Time: 3:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class TraverseFurs extends Node {

    private final TilePath path = new TilePath(ctx, new Tile[]{new Tile(3185, 3435, 0), new Tile(3188, 3431, 0), new Tile(3193, 3429, 0),
            new Tile(3198, 3429, 0), new Tile(3203, 3429, 0), new Tile(3208, 3429, 0),new Tile(3213, 3431, 0), new Tile(3213, 3434, 0)});

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
        if (ctx.bank.isOpen())
            ctx.bank.close();
        path.traverse();
    }
}