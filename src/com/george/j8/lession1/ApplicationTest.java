package com.george.j8.lession1;

import org.junit.Test;

import java.io.File;
import java.util.stream.Stream;

public class ApplicationTest {

    @Test
    public void test1() {
        File[] hiddenFiles = new File("C://").listFiles(File::isHidden);
        Stream.of(hiddenFiles).forEach(System.out::println);
    }
}
