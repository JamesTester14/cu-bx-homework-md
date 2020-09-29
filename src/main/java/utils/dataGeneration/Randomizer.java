package utils.dataGeneration;

import org.apache.commons.lang3.RandomStringUtils;

public class Randomizer {
    public static String randomizeString(int length) {
        boolean useLetters = true;
        boolean useNumbers = false;
        return RandomStringUtils.random(length, useLetters, useNumbers).toLowerCase();
    }
}
