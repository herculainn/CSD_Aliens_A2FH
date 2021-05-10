/*
* Classname: Raygun.java
*
* Version information: 1.0
*
* Date: 21/01/2021
*
* Description: The class implements a ray gun for a game
*
* Author: Dr. Shane Wilson
*
*/

package com.company;

public class Raygun {
    //Data members
    private int maximumCharge; //The maximum charge the Raygun can hold
    private int currentCharge; //The current level of charge the Raygun has

    //Class constructors
    public Raygun(int maximumCharge, int currentCharge) {
        this.maximumCharge = maximumCharge;
        this.currentCharge = currentCharge;
    }

    public void fireAt(Alien alien) {
        if (this.isCharged()) {
            this.currentCharge -= 1;

            if (alien.getDodging()) {
                alien.miss();
            } else {
                alien.hit();
            }
        }
    }

    public void recharge() {
        if (this.currentCharge < this.maximumCharge)
            this.currentCharge += 1;
    }

    public boolean isCharged() {
        return this.currentCharge > 0;
    }

    public boolean isFullyCharged() {
        return this.currentCharge == this.maximumCharge;
    }

    public int getCurrentCharge() {
        return currentCharge;
    }
}
