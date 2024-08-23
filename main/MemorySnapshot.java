/*
* Name: Muhammad Shayyan Qazi
* netID: mqazi4
* G#: G01466993
* Lecture section: 002
* Lab section: 204
*/

package src.main;

import java.util.List;

/**
 * a record encapsulating the memory states of SystemWhole instances across three realms: EMULATION, SIMULACRA, and SIMULATION.
 * used for data structures intended to hold snapshot information.
 */
public record MemorySnapshot(
    /**
     * A list of SystemWhole instances for the EMULATION realm.
     */
    List<SystemWhole> emulationMemory, 

    /**
     * A list for the SIMULACRA realm.
     */
    List<SystemWhole> simulacraMemory, 

    /**
     * A list for the SIMULATION realm.
     */
    List<SystemWhole> simulationMemory) {
}
