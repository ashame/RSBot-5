package org.nathantehbeast.api.framework.context;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/8/13
 * Time: 4:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class Contextable extends Provider {

    protected final Context context;

    public Contextable(final Context ctx) {
        super(ctx);
        this.context = ctx;
    }
}
