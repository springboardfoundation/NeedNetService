package org.springboardfoundation.common.utiliy;

import java.util.UUID;

public class Utility {
    public static String generateUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-","");
    }
}