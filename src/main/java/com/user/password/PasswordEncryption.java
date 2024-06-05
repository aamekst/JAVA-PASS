package com.user.password;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordEncryption {

    static String encryptPassword(String password) {
        try {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            random.nextBytes(salt);


            byte[] combined = new byte[salt.length + password.getBytes().length];
            System.arraycopy(salt, 0, combined, 0, salt.length);
            System.arraycopy(password.getBytes(), 0, combined, salt.length, password.getBytes().length);


            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(combined);

            // Retornar o hash e o salt concatenados
            byte[] hashWithSalt = new byte[hash.length + salt.length];
            System.arraycopy(hash, 0, hashWithSalt, 0, hash.length);
            System.arraycopy(salt, 0, hashWithSalt, hash.length, salt.length);

            return Base64.getEncoder().encodeToString(hashWithSalt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

}
