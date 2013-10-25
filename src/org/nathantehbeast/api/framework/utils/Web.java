package org.nathantehbeast.api.framework.utils;

import org.nathantehbeast.api.framework.context.Context;
import org.powerbot.script.methods.MethodProvider;
import org.powerbot.script.wrappers.Tile;
import org.powerbot.script.wrappers.TilePath;
import pathfinder.core.util.Structure;
import pathfinder.impl.Pathfinder;

public class Web extends MethodProvider {

    private final Pathfinder pathfinder;
    private final TilePath path;
    private final TilePath reversed;

    private final pathfinder.core.wrapper.TilePath tilePath;

    public Web(final Context ctx, final Tile start, final Tile end) {
        super(ctx);
        Logger.log("[Pathfinder] Finding path from " + start + " to " + end);
        pathfinder = new Pathfinder();
        tilePath = pathfinder.findPath(Structure.TILE.getHash(start.x, start.y, start.plane), Structure.TILE.getHash(end.x, end.y, end.plane), 1000, false);
        path = toPath(tilePath);
        reversed = clone().reverse();
    }

    public TilePath clone() {
        return ctx.movement.newTilePath(path.toArray());
    }

    public TilePath getPath() {
        return path;
    }

    public TilePath getReversed() {
        return reversed;
    }

    public double distance(final Tile tile) {
        return ctx.players.local().getLocation().distanceTo(tile);
    }

    public double distanceToDestination(final boolean forward) {
        return ctx.players.local().getLocation().distanceTo(forward ? getPath().getEnd() : getReversed().getEnd());
    }

    public double distanceToStart(final boolean forward) {
        return ctx.players.local().getLocation().distanceTo(forward ? getPath().getStart() : getReversed().getStart());
    }

    public boolean walk(final boolean forward) {
        return forward ? getPath().traverse() : getReversed().traverse();
    }

    private Tile toTile(int hash) {
        return new Tile(Structure.TILE.getX(hash), Structure.TILE.getY(hash), Structure.TILE.getZ(hash));
    }

    private TilePath toPath(final pathfinder.core.wrapper.TilePath tp) {
        final Tile[] arr = new Tile[tp.size()];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = toTile(tp.get(i).getHash());
        }
        return ctx.movement.newTilePath(arr);
    }

}