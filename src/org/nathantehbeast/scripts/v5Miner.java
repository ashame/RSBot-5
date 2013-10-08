package org.nathantehbeast.scripts;

import org.nathantehbeast.api.framework.Script;
import org.nathantehbeast.api.tools.Logger;
import org.powerbot.script.Manifest;

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
        version = 1.11

)
public class v5Miner extends Script {

    @Override
    public boolean setup() {
        return true;
    }

    @Override
    public void loop() {
       delay = 10000;
        Logger.log("Testing");
    }

    @Override
    public void exit() {

    }
}
