package org.nathantehbeast.api.framework.methods;

import org.nathantehbeast.api.framework.context.Context;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/8/13
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Task implements Runnable {

    protected final Context ctx;

    public Task(final Context ctx) {
        this.ctx = ctx;
    }

}
