package com.example.Alpha.Util;

import java.util.Random;

public class RandomUtils {
    private static final String CODES = "0123456789";
    private static final int CODE_LENGTH = 6;

    public static String generateCode() {
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < CODE_LENGTH; i++) {
            int index = random.nextInt(CODES.length());
            sb.append(CODES.charAt(index));
        }
        return sb.toString();
    }
}
