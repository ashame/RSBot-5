package org.nathantehbeast.scripts.winegrabber;

import org.nathantehbeast.api.framework.Script;
import org.nathantehbeast.scripts.winegrabber.jobs.*;
import org.powerbot.script.Manifest;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/10/13
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */

@Manifest(
        authors = "Nathan L",
        name = "Nathan's Wine Grabber",
        description = "Grabs wines for profit. Start in the Chaos temple or Falador west bank - Have telegrab on the first actionbar slot, home teleport on the second.",
        version = 1.1
)

public class WineGrabber extends Script {

    @Override
    public boolean setup() {
        provide(new GrabWines(ctx), new Fleeing(ctx), new BankItems(ctx), new TraverseBank(ctx), new TraverseTemple(ctx));
        return true;
    }

    @Override
    public void loop() {

    }

    @Override
    public void exit() {

    }

    @Override
    public void onRepaint(Graphics2D g) {
        g.drawString("Current Node: "+currentNode, 15, 15);
    }
}