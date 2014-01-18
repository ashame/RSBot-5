package org.nathantehbeast.scripts.furbuyer.jobs;

import org.nathantehbeast.api.framework.Node;
import org.nathantehbeast.api.framework.context.Context;
import org.powerbot.script.wrappers.Tile;
import org.powerbot.script.wrappers.TilePath;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/11/13
 * Time: 3:17 AM
 * To change this template use File | Settings | File Templates.
 */
public class TraverseBank extends Node {

    private final TilePath path = new TilePath(ctx, new Tile[]{new Tile(3211, 3432, 0), new Tile(3207, 3429, 0), new Tile(3202, 3427, 0), new Tile(3197, 3428, 0),
            new Tile(3192, 3430, 0), new Tile(3188, 3433, 0)});

    public TraverseBank(Context ctx) {
        super(ctx);
    }

    @Override
    public int priority() {
        return 0;
    }

    @Override
    public boolean activate() {
        return ctx.inventory.isFull() && ctx.players.local().getLocation().distanceTo(new Tile(3187, 3436, 0)) > 4;
    }

    @Override
    public void execute() {
        if (ctx.chat.isChatting()) {
            ctx.keyboard.send("{VK_SPACE}");
            sleep(300);
        }
        path.traverse();
    }
}