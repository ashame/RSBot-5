package org.nathantehbeast.scripts.winegrabber.jobs;

import org.nathantehbeast.api.framework.Node;
import org.nathantehbeast.api.framework.context.Context;
import org.nathantehbeast.api.framework.methods.Lodestone;
import org.nathantehbeast.api.framework.methods.Lodestone.Location;
import org.powerbot.script.util.Timer;
import org.powerbot.script.wrappers.Tile;
import org.powerbot.script.wrappers.TilePath;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/10/13
 * Time: 11:14 PM
 * To change this template use File | Settings | File Templates.
 */

public class TraverseBank extends Node {

    private final TilePath PATH;

    public TraverseBank(Context ctx) {
        super(ctx);
        PATH = new TilePath(ctx, new Tile[]{});
    }

    @Override
    public int priority() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean activate() {
        return !ctx.players.local().isInCombat() && (ctx.inventory.isFull() || !ctx.inventory.contains(563)) && ctx.players.local().getLocation().distanceTo(new Tile(2945, 3367, 0)) > 5;
    }

    @Override
    public void execute() {
        if (ctx.players.local().getLocation().distanceTo(new Tile(2952, 3474, 0)) <= 10) {
            ctx.lodestone.teleportTo(Location.FALADOR, 1);
            sleep(2000);
            final Timer t = new Timer(10000);
            while (ctx.players.local().getAnimation() != -1 && t.isRunning()) {
                sleep(800);
            }
        } else {
            ctx.movement.findPath(new Tile(2945, 3367, 0)).traverse();
            //ctx.walking.walkPath(new Tile(2965, 3401, 0), new Tile(2945, 3367, 0), "toBank");
        }
    }
}