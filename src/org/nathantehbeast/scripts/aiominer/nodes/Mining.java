package org.nathantehbeast.scripts.aiominer.nodes;

import org.nathantehbeast.api.framework.Node;
import org.nathantehbeast.api.framework.methods.Context;
import org.nathantehbeast.scripts.aiominer.Constants.BankLocations;
import org.nathantehbeast.scripts.aiominer.Constants.Ore;
import org.powerbot.script.wrappers.Tile;
import pathfinder.core.util.Structure;
import pathfinder.core.wrapper.TilePath;
import pathfinder.impl.Pathfinder;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/9/13
 * Time: 6:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Mining extends Node {

    private Pathfinder pathfinder;

    public Mining(Context ctx, Ore ore, BankLocations bankLocation, Tile center, int radius) {
        super(ctx);
    }

    @Override
    public int priority() {
        return -1;
    }

    @Override
    public boolean activate() {
        return false;
    }

    @Override
    public void execute() {
        TilePath path = pathfinder.findPath(Structure.TILE.getHash(3186, 3437, 0), Structure.TILE.getHash(3237, 3160, 0), 500, false);



    }
}
