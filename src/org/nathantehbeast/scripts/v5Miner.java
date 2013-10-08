package org.nathantehbeast.scripts;

import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;
import org.powerbot.script.util.Timer;
import org.powerbot.script.wrappers.GameObject;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 7/25/13
 * Time: 8:07 PM
 * To change this template use File | Settings | File Templates.
 */
@Manifest(
        authors = "nathantehbeast",
        name = "Nathan's AIO Miner",
        description = "Mines whatever you want it to. If your location isn't currently supported, PM me to have it added.",
        hidden = true,
        version = 1.1
)
public class v5Miner extends PollingScript {

    @Override
    public int poll() {
        final GameObject rock = ctx.objects.select().id(0).nearest().first().iterator().next();
        if (rock != null && contains(rock.getActions(), "mine") && rock.interact("Mine")) {
            final Timer t = new Timer(15000);
            while (ctx.players.local().getAnimation() != -1 && ctx.players.local().isInMotion() && t.isRunning()) {
                sleep(600);
            }
        }
        return 600;
    }

    private boolean contains(String[] arr, String x) {
        for (String s : arr) {
            if (s.toLowerCase().equals(x.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

}
