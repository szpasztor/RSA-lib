package com.rsademo;

import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Demo of decryption in action. When the main method is executed, calculates the original message m from the given input.
 * Suitable for input/output redirection.
 */
public class DecryptionDemo {

    private static @NotNull BigInteger n;
    private static @NotNull BigInteger d;
    private static @NotNull BigInteger m;
    private static @NotNull BigInteger c;

    public static void main(String args[]) {
        System.out.println("--------------------\nDECRYPTION\n--------------------");
        System.out.println("Usage: n d c");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        n = new BigInteger(s);
        System.out.printf("n = %d%n", n);
        s = scanner.next();
        d = new BigInteger(s);
        System.out.printf("d = %d%n", d);
        s = scanner.next();
        c = new BigInteger(s).mod(n);
        System.out.printf("c = %d%n", c);

        m = c.modPow(d, n);
        System.out.printf("%n => m = %d%n", m);
    }

}
