package org.nathantehbeast.api.framework.methods;

import org.powerbot.script.wrappers.Locatable;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/10/13
 * Time: 1:15 AM
 * To change this template use File | Settings | File Templates.
 */
public class Walking extends Provider {

    public Walking(Context ctx) {
        super(ctx);
    }

    public void setRun(boolean on) {
        ctx.movement.setRunning(on);
    }

    public boolean walkTo(Locatable l) {
        return ctx.movement.stepTowards(l);
    }

}
