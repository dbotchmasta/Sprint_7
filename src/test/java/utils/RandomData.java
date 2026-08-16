package utils;

import java.util.UUID;

public class RandomData {
    public static String getRandomLogin(){
        return "login_" + UUID.randomUUID();
    }

    public static String getRandomPassword(){
        return "pass_" + UUID.randomUUID();
    }

    public static String getRandomName(){
        return "name_" + UUID.randomUUID();
    }
}
