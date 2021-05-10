package com.company;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AlienTest {

    @Test
    public void testDodge() {
        Alien bob = new Alien(true, 100);
        Assert.assertEquals(bob.getDodging(), true);
    }

    @Test
    public void testHit() {
        Alien bob = new Alien(true, 100);
        bob.hit();
        Assert.assertEquals(bob.getAlienHealth(), 99);
    }

    @Test
    public void testMiss() {
        Alien bob = new Alien(true, 100);
        bob.miss();
        Assert.assertEquals(bob.getDodging(), false);
    }

}