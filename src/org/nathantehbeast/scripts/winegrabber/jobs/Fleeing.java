package org.nathantehbeast.scripts.winegrabber.jobs;

import org.nathantehbeast.api.framework.Node;
import org.nathantehbeast.api.framework.context.Context;
import org.powerbot.script.wrappers.Tile;
import org.powerbot.script.wrappers.TilePath;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/11/13
 * Time: 12:21 AM
 * To change this template use File | Settings | File Templates.
 */

public class Fleeing extends Node {

    private final TilePath PATH;

    public Fleeing(Context ctx) {
        super(ctx);
        this.PATH = new TilePath(ctx, new Tile[]{new Tile(2950, 3475, 0), new Tile(2955, 3477, 0),
                new Tile(2957, 3472, 0), new Tile(2954, 3468, 0),
                new Tile(2951, 3464, 0), new Tile(2950, 3459, 0),
                new Tile(2950, 3454, 0) });
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
        PATH.traverse();
    }
}