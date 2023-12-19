package com.banksystem.utils;

import java.net.URL;
import javax.swing.ImageIcon;

// Util class for the application for a more centralized utility functions
public abstract class Util {

    // create an ImageIcon from a url
    public static ImageIcon createImageIcon(Object object, String url) {
        URL imgUrl = object.getClass().getResource(url);
        return new ImageIcon(imgUrl);
    }

}
