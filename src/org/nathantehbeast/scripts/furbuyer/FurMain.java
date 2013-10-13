package org.nathantehbeast.scripts.furbuyer;

import org.nathantehbeast.api.framework.Script;
import org.nathantehbeast.scripts.furbuyer.jobs.*;
import org.powerbot.event.MessageEvent;
import org.powerbot.event.MessageListener;
import org.powerbot.script.Manifest;
import org.powerbot.script.util.Timer;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/11/13
 * Time: 3:13 AM
 * To change this template use File | Settings | File Templates.
 */

@Manifest(
        authors = "Nathan L",
        name = "Nathan's Bear Fur Buyer",
        description = "Buys bear furs",
        version = 1.1,
        instances = 1,
        hidden = true
)

public class FurMain extends Script implements MessageListener {

    public int fursBought;
    public long startTime;

    @Override
    public boolean setup() {
        provide(new BankFurs(ctx, this), new BuyFurs(ctx), new TraverseBank(ctx), new TraverseFurs(ctx));
        startTime = System.currentTimeMillis();
        delay = 50;
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
        g.drawString("Furs Bought: "+fursBought, 15, 30);
        g.drawString("Runtime: "+ Timer.format(startTime - System.currentTimeMillis()), 15, 45);
    }

    @Override
    public void messaged(MessageEvent messageEvent) {
        final String msg = messageEvent.getMessage();
        if (msg.contains("20 coins")) {
            fursBought++;
        }
    }
}
