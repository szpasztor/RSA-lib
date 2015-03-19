package com.rsademo.keys;

import java.math.BigInteger;

/**
 * Represents a public key with values n and e.
 */
public class PublicKey {

    private BigInteger n;
    private BigInteger e;

    public PublicKey(BigInteger n, BigInteger e) {
        this.n = n;
        this.e = e;
    }


    public BigInteger getN() {
        return n;
    }

    public BigInteger getE() {
        return e;
    }
}
