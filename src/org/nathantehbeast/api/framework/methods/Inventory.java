package org.nathantehbeast.api.framework.methods;

import org.nathantehbeast.api.framework.context.Context;
import org.nathantehbeast.api.framework.context.Provider;
import org.powerbot.script.wrappers.Item;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/10/13
 * Time: 8:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Inventory extends Provider {

    public Inventory(Context ctx) {
        super(ctx);
    }

    public boolean isEmpty() {
        return ctx.backpack.select().count() == 0;
    }

    public boolean isFull() {
        return ctx.backpack.select().count() == 28;
    }

    public boolean contains(int id) {
        for (Item item : ctx.backpack.getAllItems()) {
            if (item.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
