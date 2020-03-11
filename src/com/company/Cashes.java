package com.company;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Cashes {
    public static void main(String[] args) {
        Map<String, URL> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String string = scanner.nextLine();
            boolean check = checkMap(string, map).isPresent();

            if (check) {
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

    public static Optional<URL> checkMap(String string, Map<String, URL> map) {
        if (map.containsKey(string)) {
            return Optional.of(map.get(string));
        } else {
            return Optional.empty();
        }
    }
}

//Класс Optional не рекомендуется использовать в качестве входящих параметров методов, потому что он не реализует интерфейс Serializable.