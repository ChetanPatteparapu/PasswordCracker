package com.company;

public class Decrypt {
    private final String hash;
    private final int maxPasswordLength = 30;

    public Decrypt(String hash) {
        this.hash = hash;
    }

    public String bruteForce(int expectedLength) {
        if (expectedLength < 0 || expectedLength > 30)
            throw new IllegalArgumentException("Password length too long!");

        return getResult(new StringBuilder(), expectedLength);
    }

    public String bruteForce() {

        for (int i = 1; i <= maxPasswordLength; i++) {
            String result = getResult(new StringBuilder(), i);
            if (result.length() > 0)
                return result;
        }

        return "";
    }

    private String getResult(StringBuilder str, int length) {
        if (str.length() == length)
            return "";

        for (int i = 32; i <= 127; i++) {
            char ch = (char) i;
            str.append(ch);

            getResult(str, length);

            if (str.length() == length) {
                String tempHash = Hashing.md5(str.toString());

                if (tempHash.equals(this.hash))
                    return str.toString();
            }

            str.deleteCharAt(str.length() - 1);
        }

        return "";
    }
}
