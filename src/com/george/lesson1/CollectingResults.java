package com.george.lesson1;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectingResults {

    public static Stream<String> noVowels() throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("resources/spring_boot.txt")), StandardCharsets.UTF_8);
        List<String> wordList = Arrays.asList(contents.split("\\PL+"));
        Stream<String> words = wordList.stream();

        return words.map(s -> s.replaceAll("[aeiouAEIOU]", ""));
    }

    public static <T> void show(String label, Set<T> set) {
        System.out.println(label + ": " + set.getClass().getName());
        System.out.println("[" + set.stream().limit(10).map(Object::toString).collect(Collectors.joining(",")) + "]");
    }

    public static void main(String[] args) throws IOException {
        Iterator<Integer> iter = Stream.iterate(0, n -> n + 1).limit(10).iterator();
        while (iter.hasNext())
            System.out.println(iter.next());

        Object[] numbers = Stream.iterate(0, n -> n + 1).limit(10).toArray();
        System.out.println("Object array: " + numbers);

        try {
            Integer number = (Integer) numbers[0];
            System.out.println("number: " + number);
            System.out.println("The following statement throws an exception:");
            Integer[] numbers2 = (Integer[]) numbers;
        } catch (ClassCastException e) {
            System.out.println(e);
        }

        Integer[] number3 = Stream.iterate(0, n -> n + 1).limit(10).toArray(Integer[]::new);
        System.out.println("Integer array: " + number3);
        Set<String> noVowelsSet = noVowels().collect(Collectors.toSet());

        show("noVowelSet", noVowelsSet);

        TreeSet<String> noVowelTreeSet = noVowels().collect(Collectors.toCollection(TreeSet::new));
        show("noVowelsTreeSet", noVowelTreeSet);


    }
}
