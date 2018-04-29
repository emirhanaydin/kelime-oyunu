package com.example.kelimebulma;

import java.text.DecimalFormat;

public class GameHelper {
    private static final DecimalFormat df = new DecimalFormat("0.0");

    public static String getTimeString(long millis) {
        return df.format((float) millis / 1000);
    }
}
