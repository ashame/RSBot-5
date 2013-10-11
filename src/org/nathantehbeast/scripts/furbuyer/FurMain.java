package org.nathantehbeast.scripts.furbuyer;

import org.nathantehbeast.api.framework.Script;
import org.nathantehbeast.scripts.furbuyer.jobs.*;
import org.powerbot.script.Manifest;

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
        hidden = true
)

public class FurMain extends Script {

    @Override
    public boolean setup() {
        provide(new BankFurs(ctx), new BuyFurs(ctx), new TraverseBank(ctx), new TraverseFurs(ctx));
        delay = 75;
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
