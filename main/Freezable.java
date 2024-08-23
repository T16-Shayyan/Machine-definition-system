/*
* Name: Muhammad Shayyan Qazi
* netID: mqazi4
* G#: G01466993
* Lecture section: 002
* Lab section: 204
*/

package src.main;

/**
 * The Freezable interface defines a standardized specification for objects that require the functionality to temporarily suspend their operations.
 */
public interface Freezable {

    /**
     * freezes ongoing processes, ensuring the safe cessation of activities.
     * @return true or false is defined by the implementing classes
     */
    boolean freeze();
}
