package org.nathantehbeast.scripts.winegrabber.jobs;

import com.sk.util.time.TimedCondition;
import org.nathantehbeast.api.framework.Node;
import org.nathantehbeast.api.framework.context.Context;
import org.powerbot.script.wrappers.GroundItem;
import org.powerbot.script.wrappers.Tile;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/10/13
 * Time: 8:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class GrabWines extends Node {

    private GroundItem wine;

    public GrabWines(Context ctx) {
        super(ctx);
    }

    @Override
    public int priority() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean activate() {
        return !ctx.inventory.isFull() && ctx.inventory.contains(563) && ctx.players.local().getLocation().distanceTo(new Tile(2952, 3474, 0)) < 2 && (wine = ctx.groundItems.select().id(245).poll()) != ctx.groundItems.getNil();
    }

    @Override
    public void execute() {
        if (!ctx.getClient().isSpellSelected()) {
            ctx.actionBar.setExpanded(true);
            ctx.actionBar.getActionAt(0).select();
            new TimedCondition() {
                @Override
                public boolean check() {
                    return ctx.getClient().isSpellSelected();
                }
            }.waitFor(1000);
            return;
        }
        if (!wine.isOnScreen())
            ctx.camera.turnTo(wine);
        if (wine.interact("Cast", "Wine of Zamorak")) {
            new TimedCondition() {
                @Override
                public boolean check() {
                    return !wine.isValid();
                }
            }.waitFor(2000);
        }
    }
}
