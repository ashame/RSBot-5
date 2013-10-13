package org.nathantehbeast.scripts;

import org.nathantehbeast.api.framework.Script;
import org.powerbot.script.Manifest;
import org.powerbot.script.wrappers.Tile;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/12/13
 * Time: 1:26 AM
 * To change this template use File | Settings | File Templates.
 */

@Manifest(
        name = "Walks to Varrock",
        description = "Literally just walks to Varrock from just about anywhere.",
        authors = "Nathan L"
)
public class WalkVarrock extends Script {

    Tile start = null;

    @Override
    public boolean setup() {
        start = ctx.players.local().getLocation();
        return true;
    }

    @Override
    public void loop() {
        if (start != null)
            ctx.walking.walkPath(start, new Tile(3218, 3435, 0), "toVarrock");
    }

    @Override
    public void exit() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void onRepaint(Graphics2D g) {
    }
}
