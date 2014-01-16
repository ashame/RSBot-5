package org.nathantehbeast.scripts.winegrabber;

import org.nathantehbeast.api.framework.Script;
import org.powerbot.script.Manifest;
import org.powerbot.script.util.Timer;
import org.nathantehbeast.scripts.winegrabber.jobs.*;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/10/13
 * Time: 5:07 PM
 * To change this template use File | Settings | File Templates.
 */

@SuppressWarnings("ALL")
@Manifest(
        authors = "Nathan L",
        name = "Nathan's Wine Grabber",
        description = "Grabs wines for profit. Start in the Chaos temple or Falador west bank - Have telegrab on the first actionbar slot, home teleport on the second.",
        version = 1.2,
        topic = 1127473
)

public class WineGrabber extends Script {

    private long startTime;

    @Override
    public boolean setup() {
        startTime = System.currentTimeMillis();
        provide(new BankItems(ctx), new Fleeing(ctx), new GrabWines(ctx), new TraverseBank(ctx), new TraverseTemple(ctx));
        return true;
    }

    @Override
    public void onRepaint(Graphics2D g) {
        g.drawString("Current Node: "+currentNode, 15, 15);
        g.drawString("Run Time: "+ Timer.format(System.currentTimeMillis() - startTime), 15, 30);
    }
}