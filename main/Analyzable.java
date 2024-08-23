/*
* Name: Muhammad Shayyan Qazi
* netID: mqazi4
* G#: G01466993
* Lecture section: 002
* Lab section: 204
*/


package src.main;

/**
 * Analyze interface makes a uniform specification for objects 
 * that are capable to be analyzed, yielding insights or data snapshots of their current state. 
 */
public interface Analyzable {

    /**
     * Analyzes the current state or condition of the object.
     * @return a MemorySnapshot.
     */
    MemorySnapshot analyze();
}
