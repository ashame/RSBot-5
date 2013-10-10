package org.nathantehbeast.api.framework;

import org.nathantehbeast.api.framework.methods.Context;
import org.nathantehbeast.api.framework.methods.Provider;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/8/13
 * Time: 3:51 PM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Node extends Provider {

    public Node(Context arg0) {
        super(arg0);
    }

    public abstract int priority();
    public abstract boolean activate();
    public abstract void execute();

}
