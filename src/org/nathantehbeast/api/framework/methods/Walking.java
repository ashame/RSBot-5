package org.nathantehbeast.api.framework.methods;

import org.nathantehbeast.api.framework.context.Context;
import org.nathantehbeast.api.framework.context.Provider;
import org.nathantehbeast.api.framework.utils.Logger;
import org.nathantehbeast.api.framework.utils.Web;
import org.powerbot.script.wrappers.Locatable;
import org.powerbot.script.wrappers.Tile;
import org.powerbot.script.wrappers.TilePath;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/10/13
 * Time: 1:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class Walking extends Provider {

    protected HashMap<String, Web> webCache = new HashMap<String, Web>();

    public Walking(Context ctx) {
        super(ctx);
    }

    public void setRun(boolean on) {
        ctx.movement.setRunning(on);
    }

    public boolean walkTo(Locatable l) {
        return ctx.movement.stepTowards(l);
    }

    public boolean walkPath(final Tile start, final Tile end, final String pathName) {
        return walkPath(start, end, false, pathName);
    }

    public boolean walkPath(final Tile start, final Tile end, final boolean reverse, String pathName) {
        if (!webCache.containsKey(pathName.toLowerCase())) {
            webCache.put(pathName.toLowerCase(), new Web(ctx, start, end));
            Logger.log("[Pathfinder] Added path '"+pathName+"' to cache");
            Logger.log("[Pathfinder] All cached paths: "+webCache.keySet());
        }
        if (reverse)
            return webCache.get(pathName.toLowerCase()).getReversed().traverse();
        return webCache.get(pathName.toLowerCase()).getPath().traverse();
    }

    public TilePath getPath(String key) {
        return getPath(key, false);
    }

    public TilePath getPath(String key, boolean reverse) {
        if (reverse)
            return webCache.get(key.toLowerCase()).getReversed();
        return webCache.get(key.toLowerCase()).getPath();
    }
}
