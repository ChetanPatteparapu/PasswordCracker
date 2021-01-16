package com.company;

public class Hashing {

    public static String md5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();

            for (byte b: array)
                sb.append(Integer.toHexString((b & 0xFF) | 0x100), 1, 3);

            return sb.toString();
        }

        catch (java.security.NoSuchAlgorithmException e) {}

        return null;
    }
}
