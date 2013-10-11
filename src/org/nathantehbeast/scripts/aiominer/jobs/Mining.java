package org.nathantehbeast.scripts.aiominer.jobs;

import org.nathantehbeast.api.framework.Node;
import org.nathantehbeast.api.framework.context.Context;
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
        return false;
    }

    @Override
    public void execute() {

    }
}
