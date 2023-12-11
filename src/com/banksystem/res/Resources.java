package com.banksystem.res;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public abstract class Resources {
    public enum FontWeight {
        PLAIN, MEDIUM, BOLD
    }

    public static final Color PRIMARY = Color.decode("#417DF9");
    public static final Color LIGHT = Color.decode("#FFFFFF");
    public static final Color LIGHT_GRAY = new Color(0, 0, 0, (float) 0.40);

    public static final String DATE_FORMAT = "MMMM dd, yyyy";

    public static Font createPoppinsFont(FontWeight weight, int size) {
        String fontPath = "";
        int weightCallback = Font.PLAIN;

        switch (weight) {
            case PLAIN:
                fontPath = "../res/fonts/Poppins-Regular.ttf";
                break;
            case MEDIUM:
                fontPath = "../res/fonts/Poppins-Medium.ttf";
                weightCallback = Font.BOLD;
                break;
            case BOLD:
                fontPath = "../res/fonts/Poppins-Bold.ttf";
                weightCallback = Font.BOLD;
                break;
        }

        try (InputStream inputStream = Resources.class.getResourceAsStream(fontPath)) {
            Font font = Font.createFont(Font.TRUETYPE_FONT, inputStream);
            return font.deriveFont(Font.PLAIN, size);
        } catch (FontFormatException | IOException e) {
            return new Font("Arial", weightCallback, size);
        }
    }

}
