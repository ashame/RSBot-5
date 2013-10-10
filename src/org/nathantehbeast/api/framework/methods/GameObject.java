package org.nathantehbeast.api.framework.methods;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/9/13
 * Time: 10:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class GameObject extends Provider {

    public GameObject(Context ctx) {
        super(ctx);
    }

    public boolean isEmpty() {
        return ctx.objects.isEmpty();
    }
}
