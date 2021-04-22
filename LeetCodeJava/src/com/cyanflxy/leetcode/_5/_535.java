package com.cyanflxy.leetcode._5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class _535 {

    private String tinyUrl = "http://tinyurl.com/";
    private Map<String, String> urlMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = getDigest(longUrl).substring(0, 10);
        String result = tinyUrl + key;
        urlMap.put(key, longUrl);
        return result;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String key = shortUrl.substring(tinyUrl.length());
        return urlMap.get(key);
    }

    private String getDigest(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] result = md.digest();

            StringBuilder sb = new StringBuilder();
            for (byte b : result) {
                sb.append(b);
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";
    }

}
