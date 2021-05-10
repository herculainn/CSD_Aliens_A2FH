package com.company;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RaygunTest {

    @Test
    public void testConstructor() {
        // Arrange, Act
        int maxCharge = 10;
        int currentCharge = 8;
        Raygun ray = new Raygun(
                maxCharge,
                currentCharge);

        // Assert
        Assert.assertEquals(
                ray.getCurrentCharge(),
                currentCharge);
    }

    @Test
    public void testFireAt() {
        // Arrange
        int maxCharge = 10;
        int currentCharge = 1;

        Raygun ray = new Raygun(
                maxCharge,
                currentCharge);

        Alien myself = new Alien(
                false,
                100);

        // Act
        ray.fireAt(myself);
        int fireOne = ray.getCurrentCharge();

        ray.fireAt(myself);
        int fireTwo = ray.getCurrentCharge();

        // Assert
        Assert.assertEquals(
                fireOne,
                (currentCharge - 1)); // decremented

        Assert.assertEquals(
                fireTwo,
                (currentCharge - 1)); // not decremented (at min)
    }

    @Test
    public void testRecharge() {
        // Arrange
        int maxCharge = 10;
        int currentCharge = 9;

        Raygun ray = new Raygun(
                maxCharge,
                currentCharge);

        // Act
        ray.recharge();
        int chargeOne = ray.getCurrentCharge();

        ray.recharge();
        int chargeTwo = ray.getCurrentCharge();

        // Assert
        Assert.assertEquals(
                ray.getCurrentCharge(),
                (currentCharge + 1)); // Incremented

        Assert.assertEquals(
                ray.getCurrentCharge(),
                (currentCharge + 1)); // Not incremented (at max)
    }

    @Test
    public void testIsCharged() {
        // Arrange
        int maxCharge = 10;
        int currentCharge = 1;

        Raygun ray = new Raygun(
                maxCharge,
                currentCharge);

        Alien myself = new Alien(
                false,
                100);

        // Act
        boolean chargedOne = ray.isCharged();

        ray.fireAt(myself);
        boolean chargedTwo = ray.isCharged();

        // Assert
        Assert.assertTrue(chargedOne);  // Before firing single shot
        Assert.assertFalse(chargedTwo); // After discharging our shot
    }

    @Test
    public void testIsFullyCharged() {
        // Arrange
        int maxCharge = 10;
        int currentCharge = 9;

        Raygun ray = new Raygun(
                maxCharge,
                currentCharge);

        // Act
        boolean chargedOne = ray.isCharged();

        ray.recharge();
        boolean chargedTwo = ray.isCharged();

        // Assert
        Assert.assertFalse(chargedOne); // Before reaching full charge
        Assert.assertTrue(chargedTwo);  // After recharging
    }
}