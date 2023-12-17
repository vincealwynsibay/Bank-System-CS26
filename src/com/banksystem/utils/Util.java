package com.banksystem.utils;

import java.net.URL;
import javax.swing.ImageIcon;

public abstract class Util {

    public static ImageIcon createImageIcon(Object object, String url) {
        URL imgUrl = object.getClass().getResource(url);
        return new ImageIcon(imgUrl);
    }

}
