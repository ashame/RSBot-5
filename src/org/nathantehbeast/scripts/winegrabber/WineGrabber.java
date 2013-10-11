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
        description = "Grabs wines for profit.",
        version = 1.0
)

public class WineGrabber extends Script {

    private final int WINE_ID = 245;
    private final int LAW_ID = 563;

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
