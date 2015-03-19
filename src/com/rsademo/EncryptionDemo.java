package com.rsademo;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Demo of encryption in action. When the main method is executed, calculates the cyphertext c from the input given.
 * Suitable for input/output redirection.
 */
public class EncryptionDemo {

    private static @NotNull BigInteger n;
    private static @NotNull BigInteger e;
    private static @NotNull BigInteger m;
    private static @NotNull BigInteger c;

    public static void main(String args[]) {
        System.out.println("--------------------\nENCRYPTION\n--------------------");
        System.out.println("Usage: n e m\n");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        n = new BigInteger(s);
        System.out.printf("n = %d%n", n);
        s = scanner.next();
        e = new BigInteger(s);
        System.out.printf("e = %d%n", e);
        s = scanner.next();
        m = new BigInteger(s).mod(n);
        System.out.printf("m = %d%n", m);

        c = m.modPow(e, n);
        System.out.printf("%n => c = %d%n", c);

    }

}
