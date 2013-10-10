package org.nathantehbeast.scripts.aiominer.nodes;

import org.nathantehbeast.api.framework.Node;
import org.nathantehbeast.api.framework.methods.Context;
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

    public Mining(Context ctx) {
        super(ctx);
    }

    @Override
    public int priority() {
        return 3;
    }

    @Override
    public boolean activate() {
        return true;
    }

    @Override
    public void execute() {
    }
}
