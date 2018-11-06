package com.george.j8.lession1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortTest {

    public static class Apple {
        private int weight;
        private Color color;

        public enum Color {
            RED, BLUE, GREEN;
        }

        public Apple(int weight, Color color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color=" + color +
                    '}';
        }

    }

    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        IntStream.range(0, 10).forEach(i -> inventory.add(new Apple(i, Apple.Color.values()[new Random().nextInt(3)])));
        inventory.stream().sorted(Comparator.comparing(Apple::getWeight)).forEach(System.out::println);
        System.out.println("------------------------------------------");
        inventory.stream().filter(apple -> apple.getWeight() > 5).forEach(System.out::println);
        inventory.stream().filter(apple -> apple.getColor() == Apple.Color.GREEN).forEach(System.out::println);

        System.out.println("------------------------------------------");
        appleFilter(inventory, apple -> apple.getColor() == Apple.Color.GREEN).stream().forEach(System.out::println);
    }

    public static List<Apple> appleFilter(List<Apple> inventory, Predicate<Apple> p) {
        return inventory.stream().filter(p).collect(Collectors.toList());
    }
}
