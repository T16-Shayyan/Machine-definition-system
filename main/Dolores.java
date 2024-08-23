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
 * Dolores class extends {@see Robot} and implemets {@see Wipeable} interface.
 * It analyzes and manages a list of narrativeloops.
 */
public class Dolores extends Robot implements Wipeable {

    /**
     * List of narrativeloops object.
     */
    private List<NarrativeLoop> narrativeLoops = new ArrayList<>();
    
    /**
     * Constructor to initialize Dolores.
     * Provide defaults for the parent.
     */
    public Dolores(){
        super(null, 0, false, false, false);
    }

    /**
     * adds a narrativeloop instance to the Dolores's list.
     * @param narrativeLoop a single narrtive loop
     */
    public final void addNarrativeLoop(NarrativeLoop narrativeLoop){
        narrativeLoops.add(narrativeLoop);
    }

    /**
     * Throws UnsupportedOperationException to indicate that fetching absolute capabilities directly is not supported.
     * @throws UnsupportedOperationException Thrown to tell its not supported.
     */
    public final Machine[] getAbsoluteCapabilities() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("fetching absolute capabilities directly is not supported.");
    }

    /**
     * It is used to halt all operations and activities
     * @return false as ineffective on Dolores.
     */
    public boolean freezeAllMotorFunctions(){
        return false;
    }

    /**
     * Implementation of the wipe functionality required by the {@see Wipeable} interface.
     * used for resetting or clearing Dolores's state.
     */
    @Override
    public void wipe(){}

    /**
     * Ovverrides the analyze method from the {@see Wipeable} interface.
     * Designed to protect Dolores' memory from being wiped and to log each memory wipe.
     * @return null if narrativeLoops empty else returns a MemorySnapshot that includes the states from the emulation, simulacra, and simulation lists within the narrative loop.
     */
    @Override
    public MemorySnapshot analyze(){
        if (narrativeLoops.size() == 0){
            return null;
        }else{
            NarrativeLoop narrativeLoop = narrativeLoops.get(narrativeLoops.size()-1);
            return new MemorySnapshot(List.copyOf(narrativeLoop.emulation), List.copyOf(narrativeLoop.simulacra), List.copyOf(narrativeLoop.simulation));
        }
    }

}
