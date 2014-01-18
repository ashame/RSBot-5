package org.nathantehbeast.scripts.furbuyer;

import org.nathantehbeast.api.framework.Script;
import org.nathantehbeast.api.framework.methods.LoopTask;
import org.nathantehbeast.scripts.furbuyer.jobs.*;
import org.powerbot.event.MessageEvent;
import org.powerbot.event.MessageListener;
import org.powerbot.script.Manifest;
import org.powerbot.script.methods.Game;
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
        version = 1.2,
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
        ctx.getExecutor().submit(new LoopTask(ctx) {
            @Override
            public int loop() {
                if (ctx.game.getClientState() == Game.INDEX_MAP_LOADED && ctx.backpack.getMoneyPouch() < 20) {
                    delay = -1;
                    return -1;
                }
                return 60000;
            }
        });
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
        g.drawString("Runtime: "+ Timer.format(System.currentTimeMillis() - startTime), 15, 45);
    }

    @Override
    public void messaged(MessageEvent messageEvent) {
        final String msg = messageEvent.getMessage();
        if (msg.contains("20 coins")) {
            fursBought++;
        }
    }
}