package org.nathantehbeast.scripts.winegrabber.jobs;

import org.nathantehbeast.api.framework.Node;
import org.nathantehbeast.api.framework.context.Context;
import org.nathantehbeast.api.framework.methods.Lodestone;
import org.powerbot.script.wrappers.Tile;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/10/13
 * Time: 11:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class TraverseBank extends Node {

    public TraverseBank(Context ctx) {
        super(ctx);
    }

    @Override
    public int priority() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean activate() {
        return !ctx.players.local().isInCombat() && ctx.inventory.isFull() && ctx.players.local().getLocation().distanceTo(new Tile(2945, 3367, 0)) > 5;
    }

    @Override
    public void execute() {
        if (ctx.players.local().getLocation().distanceTo(new Tile(2952, 3474, 0)) <= 10) {
            ctx.lodestone.teleportTo(Lodestone.Location.FALADOR, 1);
        } else {
            ctx.walking.walkPath(new Tile(2965, 3401, 0), new Tile(2945, 3367, 0), "toBank");
        }
    }
}
