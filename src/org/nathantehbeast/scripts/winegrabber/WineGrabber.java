package org.nathantehbeast.scripts.winegrabber;

import org.nathantehbeast.api.framework.Script;
import org.nathantehbeast.scripts.winegrabber.jobs.*;
import org.powerbot.script.Manifest;
import org.powerbot.script.util.SkillData;
import org.powerbot.script.util.Timer;

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
        version = 1.1,
        topic = 1127473
)

public class WineGrabber extends Script {

    private SkillData sd;
    private long startTime;

    @Override
    public boolean setup() {
        provide(new GrabWines(ctx), new Fleeing(ctx), new BankItems(ctx), new TraverseBank(ctx), new TraverseTemple(ctx));
        sd = new SkillData(ctx);
        startTime = System.currentTimeMillis();
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
        g.drawString("Run Time: "+ Timer.format(System.currentTimeMillis() - startTime), 15, 25);
    }
}