package com.company;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cashes {
    public static void main(String[] args) {
        Map<String, URL> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String string = scanner.nextLine();

            if (map.containsKey(string)) {
                System.out.println(map.get(string));
                break;
            } else {
                getUrl(string, map);
                System.out.println(map.get(string));
            }
        }
    }

    public static void getUrl(String string, Map<String, URL> map) {
        URL url;
        try {
            url = new URL("https://" + string);
            map.put(string, url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
