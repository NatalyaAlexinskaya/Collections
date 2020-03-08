package com.company;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FightersCollections {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();
        System.out.println("Время добавления элемента в HashSet = " + add(set1));
        System.out.println("Время добавления элемента в LinkedHashSet = " + add(set2));
        System.out.println("Время удаления элемента в HashSet = " + remove(set1));
        System.out.println("Время удаления элемента в LinkedHashSet = " + remove(set2));
        System.out.println("Время поиска элемента в HashSet = " + contains(set1));
        System.out.println("Время поиска элемента в LinkedHashSet = " + contains(set2));
    }

    public static long add(Collection<Integer> collection) {
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            collection.add(i);
        }
        return System.nanoTime() - start;
    }

    public static long remove(Collection<Integer> collection) {
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            collection.remove(i);
        }
        return System.nanoTime() - start;
    }

    public static long contains(Collection<Integer> collection) {
        long start = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            collection.contains(i);
        }
        return System.nanoTime() - start;
    }
}

//Добавление элемента быстрее происходит в HashSet
//Удаление элемента быстрее происходит в LinkedHashSet
//Поиск элемента быстрее происходит в LinkedHashSet
