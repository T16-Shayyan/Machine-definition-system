/*
* Name: Muhammad Shayyan Qazi
* netID: mqazi4
* G#: G01466993
* Lecture section: 002
* Lab section: 204
*/

package src.main;

/**
 * Host class extendes {@see Dolores} and implements {@see Freezable} interface.
 * it is a nuanced entity capable of engaging with narrative structures and responding to control commands.
 * it is equipped with mechanisms for narrative analysis, memory management, and operational control.
 */
public class Host extends Dolores implements Freezable{

    /**
    * The private instance of NarrativeLoop.
    */
    private final NarrativeLoop narrativeLoop;

    /**
     * constructor which also calls Dolores constructor
     * assigns narrative loop
     * adds the loop to the narrative loop list in Dolores.
     * @param narrativeLoop NarrativeLoop instance associated with this Host.
     */
    public Host(NarrativeLoop narrativeLoop){
        super();
        this.narrativeLoop = narrativeLoop;
        addNarrativeLoop(narrativeLoop);
    }

    /**
     * stops all of the host's operations and activities.
     * @return true showing its successful
     */
    public boolean freezeAllMotorFunctions(){
        return true;
    }

    /**
     * checks if narrativeloop is empty.
     * if not then creates a MemorySnapshot.
     * @return if empty then null else a new MemorySnapshot instance.
     */
    public MemorySnapshot analyze(){
        if (narrativeLoop.equals(null)){
            return null;
        }else{
            return new MemorySnapshot(narrativeLoop.emulation, narrativeLoop.simulacra, narrativeLoop.simulation);
        }
    }

    /**
     * Calls the wipeNarrativeLoops() method.
     * use to reset or clear the narrative states within the loop.
     */
    public void wipe(){
        narrativeLoop.wipeNarrativeLoops();
    }

    /**
     * Implements the freeze method from the {@see Freezable} interface.
     * uses freezeAllMotorFunctions().
     * @return the return of freezeAllMotorFunctions() which is true.
     */
    @Override
    public boolean freeze(){
        return freezeAllMotorFunctions();
    }
    
}
