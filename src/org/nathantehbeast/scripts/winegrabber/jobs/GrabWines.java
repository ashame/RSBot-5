package org.nathantehbeast.scripts.winegrabber.jobs;

import com.sk.util.time.TimedCondition;
import org.nathantehbeast.api.framework.Node;
import org.nathantehbeast.api.framework.context.Context;
import org.powerbot.script.lang.Filter;
import org.powerbot.script.methods.Menu;
import org.powerbot.script.wrappers.GroundItem;
import org.powerbot.script.wrappers.Tile;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/10/13
 * Time: 8:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class GrabWines extends Node {

    private final Tile HOVER = new Tile(2952, 3473, 0);
    private GroundItem wine;

    public GrabWines(Context ctx) {
        super(ctx);
    }

    private final Filter<Menu.Entry> CASTING = new Filter<Menu.Entry>() {
        @Override
        public boolean accept(Menu.Entry entry) {
            return entry.option.contains("Grab -> Wine");
        }
    };


    @Override
    public int priority() {
        return 0;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public boolean activate() {
        return !ctx.players.local().isInCombat() && !ctx.inventory.isFull() && ctx.inventory.contains(563) && ctx.players.local().getLocation().distanceTo(new Tile(2952, 3474, 0)) <= 1 && (wine = ctx.groundItems.select().id(245).poll()) != ctx.groundItems.getNil();
    }

    @Override
    public void execute() {
        final Point point = ctx.game.groundToScreen((int) ((HOVER.getX() - ctx.game.getMapBase().getX() + 0.6D) * 512.0D), (int) ((HOVER.getY() - ctx.game.getMapBase().getY() + 0.37D) * 512.0D), 2, 500);
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
        if (!wine.isOnScreen()) {
            ctx.camera.turnTo(wine);
        }
        if (!ctx.players.local().isInMotion() && ctx.mouse.move(point) && wine.isValid()) {
            if (ctx.mouse.click(false)) {
                ctx.menu.click(CASTING);
                new TimedCondition() {
                    @Override
                    public boolean check() {
                        return !wine.isValid();
                    }
                }.waitFor(1500);
            }
        }

    }
}
