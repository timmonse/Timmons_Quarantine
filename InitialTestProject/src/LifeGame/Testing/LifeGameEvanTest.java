package LifeGame.Testing;

import LifeGame.LifeGameEvan;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Scanner;

class LifeGameEvanTest {


    @Test
    public static void main(String args[]) throws IOException {
//        LifeGameEvan game = new LifeGameEvan();
//        InputStream input = new BufferedInputStream(new FileInputStream("src/LifeGame/test.txt"));
//        System.setIn(input);
//
//        System.out.println(input.readAllBytes());

        LifeGameEvan game = new LifeGameEvan();
        System.out.println("main");
        String[] args1 = null;
        final InputStream original = System.in;
        //final FileInputStream fips = new FileInputStream(new File("src/LifeGame/test2"));
        InputStream fips = new BufferedInputStream(new FileInputStream("src/LifeGame/test2"));
        System.setIn(fips);
        game.main(args1);
        //System.setIn(original);
    }
}
