package org.nathantehbeast.api.tools;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: Nathan
 * Date: 10/8/13
 * Time: 3:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class Utilities {

    public static boolean contains(final int[] array, final int id) {
        for (final int i : array) {
            if (i == id) {
                return true;
            }
        }
        return false;
    }

    public static final Image getImage(final String url) {
        try {
            return ImageIO.read(new URL(url));
        } catch (IOException e) {
            Logger.log(e.toString());
            return null;
        }
    }
}
