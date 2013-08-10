package org.nathantehbeast.scripts;

import org.powerbot.script.Manifest;
import org.powerbot.script.PollingScript;
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
        name = "Test",
        description = "v5 Test Script",
        hidden = true,
        version = 1.0
)
public class v5Miner extends PollingScript {

    @Override
    public int poll() {
        final GameObject rock = ctx.objects.select().id(0).nearest().first().iterator().next();
        if (rock != null && rock.interact("Mine")) {
            System.out.println("Sleeping for 1 minute.");
            return 60000;
        } else {
            return 300;
        }
    }

}
