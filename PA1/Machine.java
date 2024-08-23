public class Machine {
    private final Object kind; // Type of shape as Object
    private final Object[] properties; // Properties of the shape as an array of Object
    private final boolean humanConstrained; // Stores the result of the humanoid check
    private boolean humanEmergence; // Stores the result of the humanoid check

    public Machine(Object kind, Object[] partStates, boolean humanConstrained) {
        //constructor puts values in proper place
        this.humanConstrained = humanConstrained;
        this.properties = partStates;
        this.kind = kind;
        //default emergence is false
        this.humanEmergence = false;
    }

    public Object[] getProperties() {
        //get method for properties
        return this.properties;
    }

    public void emergeFromLimitations() {
        //updates humanEmergence with true
        this.humanEmergence = true;
    }

    public boolean isHumanoid() {
        //if either is true the machine is humanoid
        if (this.humanEmergence || this.humanConstrained){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("Machine{kind=%s, humanoid=%s, properties=%s}", kind, humanConstrained,
                propertiesToString(properties));
    }

    public static String propertiesToString(Object[] machineProperties) {
        String propertiesString = "[";
        for (int i =0; i<machineProperties.length;i++){
            //appending properties with new ones from PArtState
            propertiesString = propertiesString + machineProperties[i].toString() + ", ";
        }
        //using substring to remove the leading ", "
        propertiesString = propertiesString.substring(0,propertiesString.length()-2);
        propertiesString += "]";
        return propertiesString;
    }
}