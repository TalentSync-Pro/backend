package com.example.TalentSyncpro.Transformers;

import java.util.Random;

public class UserTransformer {

    public static String generateRandomUuid() {
        StringBuilder uuid = new StringBuilder("xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx");
        Random random = new Random();

        for (int i = 0; i < uuid.length(); i++) {
            char c = uuid.charAt(i);
            if (c == 'x') {
                uuid.setCharAt(i, Character.forDigit(random.nextInt(16), 16));
            } else if (c == 'y') {
                uuid.setCharAt(i, Character.forDigit((random.nextInt(4) | 0x8), 16));
            }
        }

        return uuid.toString();
    }


}
