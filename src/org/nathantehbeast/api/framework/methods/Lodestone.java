package org.nathantehbeast.api.framework.methods;

import com.sk.util.time.TimedCondition;
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
        LUNAR_ISLE(39),
        YANILLE(52),
        ARDOUGNE(41),
        SEERS(49),
        CATHERBY(43),
        BURTHROPE(42),
        TAVERLY(50),
        FALADOR(46),
        PORT_SARIM(48),
        EDGEVILLE(45),
        DRAYNOR(44),
        VARROCK(51),
        AL_KHARID(40),
        LUMBRIDGE(47),
        BANDIT_CAMP(7);

        private int childId;

        Location(final int childId) {
            this.childId = childId;
        }

        public int getChildId() {
            return this.childId;
        }
    }

    public Lodestone(Context ctx) {
        super(ctx);
    }

    public boolean isTeleporting() {
        return ctx.players.local().getAnimation() == 16385;
    }

    public boolean teleportTo(Location loc, int actionSlot) {
        if (!isTeleporting()) {
            ctx.actionBar.getActionAt(actionSlot).select();
            new TimedCondition() {
                @Override
                public boolean check() {
                    return ctx.widgets.get(1092, 8).isOnScreen();
                }
            }.waitFor(2000);
            if (ctx.widgets.get(1092, 8).isOnScreen()) {
                return ctx.mouse.click(ctx.widgets.get(1092, loc.getChildId()).getCenterPoint(), true);
            }
        }
        return false;
    }


}
