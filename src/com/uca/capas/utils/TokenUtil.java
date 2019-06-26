package com.uca.capas.utils;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.codec.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class TokenUtil {
    public static final String SECRET_KEY="LoremCinema";

    public static String createToken(UserDetails userDetails){
        long expires = System.currentTimeMillis() + 1000L * 60 * 60;
        return userDetails.getUsername() + ":" + expires + computeSignature(userDetails, expires);
    }

    public static String computeSignature(UserDetails userDetails, Long expires){
        StringBuilder signatureBuilder = new StringBuilder();
        signatureBuilder.append(userDetails.getUsername()).append(":");
        signatureBuilder.append(expires).append(":");
        signatureBuilder.append(userDetails.getPassword()).append(":");
        signatureBuilder.append(TokenUtil.SECRET_KEY);
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        }catch (NoSuchAlgorithmException e){
            throw new IllegalStateException("No SHA-256 algorithm available!");
        }
        return new String(Hex.encode(digest.digest(signatureBuilder.toString().getBytes())));
    }

    public static String getUsernameFromToken(String authToken){
        if(authToken == null){
            return null;
        }
        String[] parts = authToken.split(":");
        return parts[0];
    }

    public static boolean validateToken(String authToken, UserDetails userDetails){
        String[] parts = authToken.split(":");
        long expires = Long.parseLong(parts[1]);
        String signature = parts[2];
        String signatureToMatch = computeSignature(userDetails, expires);
        return  expires >= System.currentTimeMillis() && signature.equals(signatureToMatch);
    }
}
