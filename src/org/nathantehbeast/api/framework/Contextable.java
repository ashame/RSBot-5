package org.nathantehbeast.api.framework;

import org.powerbot.script.methods.MethodProvider;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/8/13
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Contextable extends MethodProvider {

    protected final Context context;

    public Contextable(final Context ctx) {
        super(ctx);
        this.context = ctx;
    }
}
