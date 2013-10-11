package org.nathantehbeast.api.framework.methods;

import org.nathantehbeast.api.framework.context.Context;
import org.nathantehbeast.api.framework.context.Provider;
import org.nathantehbeast.api.framework.utils.Web;
import org.powerbot.script.wrappers.Locatable;
import org.powerbot.script.wrappers.Tile;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/10/13
 * Time: 1:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class Walking extends Provider {

    protected Web web;

    public Walking(Context ctx) {
        super(ctx);
    }

    public void setRun(boolean on) {
        ctx.movement.setRunning(on);
    }

    public boolean walkTo(Locatable l) {
        return ctx.movement.stepTowards(l);
    }

    public boolean walkPath(final Tile start, final Tile end) {
        return walkPath(start, end, false);
    }

    public boolean walkPath(final Tile start, final Tile end, final boolean reverse) {
        if (web == null) web = new Web(ctx, start, end);
        if (reverse)
            return web.getReversed().traverse();
        return web.getPath().traverse();
    }

    public void clearWeb() {
        web = null;
    }
}
