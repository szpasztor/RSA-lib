package com.rsademo;

import com.rsademo.keys.PrivateKey;
import com.rsademo.keys.PublicKey;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;

/**
 *
 */
public class RSA {

    public static PublicKey generatePublicKey(BigInteger p, BigInteger q, BigInteger searchEFrom) {
        BigInteger n = p.multiply(q);
        BigInteger phiN = p.subtract(ONE).multiply(q.subtract(ONE));
        BigInteger e = searchEFrom;
        while (!e.gcd(phiN).equals(ONE)) e = e.add(ONE);
        PublicKey key = new PublicKey(n, e);
        return key;
    }

    public static PrivateKey generatePrivateKey(BigInteger p, BigInteger q, BigInteger e) {
        BigInteger n = p.multiply(q);
        BigInteger phiN = p.subtract(ONE).multiply(q.subtract(ONE));
        BigInteger d = e.modInverse(phiN);
        PrivateKey key = new PrivateKey(n, d);
        return key;
    }

    public static BigInteger encrypt(BigInteger m, PublicKey k) {
        BigInteger n = k.getN();
        BigInteger e = k.getE();
        BigInteger c = m.modPow(e, n);
        return c;
    }

    public static BigInteger decrypt(BigInteger c, PrivateKey k) {
        BigInteger n = k.getN();
        BigInteger d = k.getD();
        BigInteger m = c.modPow(d, n);
        return m;
    }

}
