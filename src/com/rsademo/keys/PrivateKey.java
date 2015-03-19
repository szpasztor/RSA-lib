package com.rsademo.keys;

import java.math.BigInteger;

/**
 * Represents a private key with values n and d.
 */
public class PrivateKey {

    private BigInteger n;
    private BigInteger d;

    public PrivateKey(BigInteger n, BigInteger d) {
        this.n = n;
        this.d = d;
    }


    public BigInteger getN() {
        return n;
    }

    public BigInteger getD() {
        return d;
    }
}
