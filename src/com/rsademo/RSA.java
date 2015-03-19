package com.rsademo;

import com.rsademo.keys.PrivateKey;
import com.rsademo.keys.PublicKey;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;

/**
 * Class holding externally usable API for key generation, encryption and decryption.
 */
public class RSA {

    /**
     * Generates a public key using the given input.
     * @param p prime used for generation. Must not equal q, and shouldn't be too close to it.
     * @param q prime used for generation. Must not equal p, and shouldn't be too close to it.
     * @param searchEFrom a value to start looking for a relative prime to phi(n) from.
     * @return the public key.
     */
    public static PublicKey generatePublicKey(BigInteger p, BigInteger q, BigInteger searchEFrom) {
        BigInteger n = p.multiply(q);
        BigInteger phiN = p.subtract(ONE).multiply(q.subtract(ONE));
        BigInteger e = searchEFrom;
        while (!e.gcd(phiN).equals(ONE)) e = e.add(ONE);
        PublicKey key = new PublicKey(n, e);
        return key;
    }

    /**
     * Generates a private key using the given input.
     * @param p prime used for generation. Must not equal q, and shouldn't be too close to it.
     * @param q prime used for generation. Must not equal p, and shouldn't be too close to it.
     * @param e value of e obtained from the public key.
     * @return the private key.
     */
    public static PrivateKey generatePrivateKey(BigInteger p, BigInteger q, BigInteger e) {
        BigInteger n = p.multiply(q);
        BigInteger phiN = p.subtract(ONE).multiply(q.subtract(ONE));
        BigInteger d = e.modInverse(phiN);
        PrivateKey key = new PrivateKey(n, d);
        return key;
    }

    /**
     * Encrypts the given message m using modular exponentiation.
     * @param m the message
     * @param k the public key
     * @return the cyphertext c
     */
    public static BigInteger encrypt(BigInteger m, PublicKey k) {
        BigInteger n = k.getN();
        BigInteger e = k.getE();
        BigInteger c = m.modPow(e, n);
        return c;
    }

    /**
     * Decrypts the given cyphertext c using modular exponentiation.
     * @param c the cyphertext
     * @param k the private key
     * @return the original message m
     */
    public static BigInteger decrypt(BigInteger c, PrivateKey k) {
        BigInteger n = k.getN();
        BigInteger d = k.getD();
        BigInteger m = c.modPow(d, n);
        return m;
    }

}
