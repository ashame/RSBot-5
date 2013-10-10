package org.nathantehbeast.api.framework.methods;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/9/13
 * Time: 7:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class mining extends Provider {

    public mining(Context ctx) {
        super(ctx);
    }

    public boolean a() {
        return ctx.npcs.select().isEmpty();
    }
}
