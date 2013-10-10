package org.nathantehbeast.api.framework.methods;

import org.powerbot.script.methods.MethodProvider;

import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/9/13
 * Time: 7:13 PM
 * To change this template use File | Settings | File Templates.
 */
public class Provider extends MethodProvider {

    public Context ctx;
    public Logger log = Logger.getLogger(this.getClass().getSimpleName());

    public Provider(Context ctx) {
        super(ctx);
        this.ctx = ctx;
    }
}
