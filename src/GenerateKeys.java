import org.jetbrains.annotations.NotNull;

import java.math.BigInteger;
import java.util.Scanner;

import static java.math.BigInteger.ONE;

/**
 *
 */
public class GenerateKeys {

    private static @NotNull BigInteger p;
    private static @NotNull BigInteger q;
    private static @NotNull BigInteger n;
    private static @NotNull BigInteger phiN;
    private static @NotNull BigInteger e;
    private static @NotNull BigInteger d;

    public static void main(String args[]) {
        System.out.println("--------------------\nGENERATE KEYS\n--------------------");
        System.out.println("Usage: p q\n");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        p = new BigInteger(s);
        System.out.printf("p = %d%n", p);
        s = scanner.next();
        q = new BigInteger(s);
        System.out.printf("q = %d%n", q);

        n = p.multiply(q);
        System.out.println("n = " + n);

        phiN = p.subtract(ONE).multiply(q.subtract(ONE));
        System.out.println("phi(n) = " + phiN);

        e = phiN.divide(BigInteger.valueOf(3));
        while(e.gcd(phiN).equals(ONE) == false) e = e.add(ONE);
        System.out.println("e = " + e);

        d = e.modInverse(phiN);
        System.out.println("d = " + d);

        System.out.printf("%nPublic key:%n\tn = %d%n\te = %d%n", n, e);
        System.out.printf("%nPrivate key:%n\tn = %d%n\td = %d%nP, q and phi(n) must also be kept private, since they can be used to calculate d%n", n, d);

    }

}
