/*
* Name: Muhammad Shayyan Qazi
* netID: mqazi4
* G#: G01466993
* Lecture section: 002
* Lab section: 204
*/

package src.main;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstract class for defining loops
 * Include logic for filtering {@see SystemWhole} parts by kind.
 * Populates the three ArrayLists (emulation, simulacra, simulation).
 */
public abstract class NarrativeLoop {

    /**
     * List of SystemWhole instances representing emulation.
     */
    protected final List<SystemWhole> emulation = new ArrayList<>();

    /**
     * List of SystemWhole instances representing simulacra.
     */
    protected final List<SystemWhole> simulacra = new ArrayList<>();

    /**
     * List of SystemWhole instances representing simulation.
     */
    protected final List<SystemWhole> simulation = new ArrayList<>();    

    /**
     * The method resets the narrative environment by clearing the emulation, simulacra, and simulation lists.
     * Removes all SystemWhole instances from each realm.
     */
    public void wipeNarrativeLoops(){
        emulation.clear();
        simulacra.clear();
        simulation.clear();
    }

    /**
     * For each SystemWhole it iterates through the Machines it contains.
     * calls {@see determineRealm} with the Machine's kind and both context arrays as parameters.
     * Uses returns from {@see determineRealm} and {@see containsKind} to add SystemWhole to specific list.
     * @param emulationContext array containing {@see SystemWhole} in emulation context.
     * @param simulacraContext array containing {@see SystemWhole} in simulacra context.
     */
    public final void updateNarrativeLoops(SystemWhole[] emulationContext, SystemWhole[] simulacraContext){
        for (SystemWhole systemWhole : emulationContext){
            for (Machine machine: systemWhole.reify()){
                Realm realm = determineRealm(machine.getKind(), emulationContext, simulacraContext);
                if (realm == Realm.EMULATION && !containsKind(emulation, machine.getKind())){
                    emulation.add(systemWhole);
                }
            }
        }

        for (SystemWhole systemWhole : simulacraContext){
            for (Machine machine: systemWhole.reify()){
                Realm realm = determineRealm(machine.getKind(), emulationContext, simulacraContext);
                if (realm == Realm.SIMULACRA && !containsKind(simulacra, machine.getKind())){
                    simulacra.add(systemWhole);
                }else if (realm == Realm.SIMULATION && !containsKind(simulation, machine.getKind())){
                    simulation.add(systemWhole);
                }
            }
        }
    }

    /**
     * calls {@see isInContext} with kind and SystemWhole array to check if it is in context.
     * returns the specific realm which is in context
     * @param kind the kind of machine
     * @param emulationContext SystemWhole array in emulation context
     * @param simulacraContext SystemWhole array in simulacra context
     * @return Realm.SIMULATION if in context of both, Realm.SIMULACRA if in context of simulacra, Realm.EMULATION if both conditionss dosent apply.
     */
    private final Realm determineRealm(String kind, SystemWhole[] emulationContext, SystemWhole[] simulacraContext){
        if (isInContext(kind, emulationContext) && isInContext(kind, simulacraContext)){
            return Realm.SIMULATION;
        }else if (!isInContext(kind, emulationContext) && isInContext(kind, simulacraContext)){
            return Realm.SIMULACRA;
        }else{
            return Realm.EMULATION;
        }
    }

    /**
     * Checks if a machine kind is present in the provided context.
     * @param kind the kind of machine
     * @param context SystemWhole array
     * @return true if any Machine matches the specified kind and false if no match is found.
     */
    private final boolean isInContext(String kind, SystemWhole[] context){
        for (SystemWhole systemWhole : context){
            for(Machine machine : systemWhole.reify()){
                if (machine.getKind().equals(kind)){
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * checks if any Machine within the SystemWhole matches the specified kind
     * @param list list of systemWholes to check.
     * @param kind The kind of the machine.
     * @return true if the kind is present and false otherwise.
     */
    private final boolean containsKind(List<SystemWhole> list, String kind){
        for (SystemWhole systemWhole : list){
            for (Machine machine : systemWhole.reify()){
                if (machine.getKind().equals(kind)){
                    return true;
                }
            }
        }
        return false;
    }
}
