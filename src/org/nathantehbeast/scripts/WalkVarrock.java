package org.nathantehbeast.scripts;

import org.nathantehbeast.api.framework.Script;
import org.powerbot.script.Manifest;
import org.powerbot.script.wrappers.GameObject;
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
    GameObject gate;

    @Override
    public boolean setup() {
        start = ctx.players.local().getLocation();
        return true;
    }

    @Override
    public void loop() {
        if ((gate = ctx.objects.select().id(28691).poll()) != ctx.objects.getNil() && gate.interact("Open")) {
            sleep(1000);
        }
        if (start != null)
            ctx.walking.walkPath(start, new Tile(3218, 3435, 0), "toVarrock");

    }

    @Override
    public void exit() {
    }

    @Override
    public void onRepaint(Graphics2D g) {
    }
}
