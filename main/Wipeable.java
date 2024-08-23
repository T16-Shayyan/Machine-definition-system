/*
* Name: Muhammad Shayyan Qazi
* netID: mqazi4
* G#: G01466993
* Lecture section: 002
* Lab section: 204
*/

package src.main;

/**
 * Wipeable interface inherits from {@see Analyzable}
 * includes the ability to reset or clear an objects state on top of analytical capabilities.
 */
public interface Wipeable extends Analyzable{

    /**
     * Clears or resets the state of the object.
     * Implementing classes must define a behavior for this method.
     */
    void wipe();
}
