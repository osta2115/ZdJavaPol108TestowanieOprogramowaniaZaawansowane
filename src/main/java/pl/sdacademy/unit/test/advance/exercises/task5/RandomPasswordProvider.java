package pl.sdacademy.unit.test.advance.exercises.task5;

import java.util.Random;
import java.util.UUID;

public class RandomPasswordProvider {
    public String generateRandomPassword() {
//        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
//                +"lmnopqrstuvwxyz!@#$%&";
//        Random rnd = new Random();
//        StringBuilder sb = new StringBuilder(len);
//        for (int i = 0; i < len; i++)
//            sb.append(chars.charAt(rnd.nextInt(chars.length())));
//        return sb.toString();
        return UUID.randomUUID().toString();
    }
}
