package org.nathantehbeast.api.framework;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/8/13
 * Time: 4:06 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Task extends Contextable implements Runnable {

    public Task(final Context ctx) {
        super(ctx);
    }

}
