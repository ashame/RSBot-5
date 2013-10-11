package org.nathantehbeast.api.framework.methods;

import org.nathantehbeast.api.framework.context.Context;
import org.nathantehbeast.api.framework.context.Provider;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/10/13
 * Time: 11:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class Lodestone extends Provider {

    public enum Location {
        LUNAR_ISLE,
        YANILLE,
        ARDOUGNE,
        SEERS,
        CATHERBY,
        BURTHROPE,
        TAVERLY,
        FALADOR,
        PORT_SARIM,
        EDGEVILLE,
        DRAYNOR,
        VARROCK,
        AL_KHARID,
        LUMBRIDGE,
        BANDIT_CAMP;
    }

    public Lodestone(Context ctx) {
        super(ctx);
    }

    public boolean teleportTo(Location loc) {

        return false;
    }


}
