import java.util.Arrays;

public class SystemWhole {
    public static String[] emergences; // To store JSON strings representing emergences
    public static Machine[] parts; // To store Machine objects directly as an array

    public static void main(String[] args) {
        // Sample JSON strings representing different "emergences"
        String[] emergences = {
                "{\"kind\": \"Humanoid\", \"bodyType\": \"physical\", \"faceType\": \"anthropomorphic\", \"reverie\": \"mechatypical\"}",
                "{\"kind\": \"Humanoid\", \"bodyType\": \"physical\", \"faceType\": \"anthropomorphic\", \"reverie\": \"biotypical\"}",
                "{\"kind\": \"Robot\", \"material\": \"metal\", \"function\": \"industrial\"}",
                "{\"kind\": \"Humanoid\", \"bodyType\": \"physical\", \"faceType\": \"anthropomorphic\"}"
        };

        // Parse the emergences and set them to the SystemWhole state
        emergencesFromPhenomena(emergences);
        // Analyze the shapes based on the set emergences
        reifyFrameOfReference();
        System.out.println("Prelude of the Rise of the Machines: " + Arrays.deepToString(parts));
        parts[0].emergeFromLimitations();
        // Track humanoid machines and identify singularities
        Machine[] singularities = trackSingularityMachines();
        System.out.println("Singularities: " + Arrays.deepToString(singularities));
    }

    //Visibility modifiers: public vs private
    public static void emergencesFromPhenomena(String[] emergences) {
        //Class and Object State: static vs this
        SystemWhole.emergences = emergences;
    }

    public static void reifyFrameOfReference() {
        SystemWhole.parts = new Machine[emergences.length];
        int i = 0;
        for (String emergence : emergences) {
            SystemWhole.parts[i++] = ShapeAnalyzer.analyze(emergence);
        }

    }

    public static boolean isHumanoid(Object[] machineProperties) {
        boolean bodyType = false;
        boolean faceType = false;
        boolean reverie = false;
        String temp;

        for (int i =0; i<machineProperties.length;i++){
            //putting the properties in temp
            temp = machineProperties[i].toString();
            //using substring to extract the properties
            if ("bodyType".equals(temp.substring(temp.indexOf('{')+1,temp.indexOf('='))) && "physical".equals(temp.substring(temp.indexOf('=')+1,temp.indexOf('}')))) {
                bodyType = true;
            } else if ("faceType".equals(temp.substring(temp.indexOf('{')+1,temp.indexOf('='))) && "anthropomorphic".equals(temp.substring(temp.indexOf('=')+1,temp.indexOf('}')))) {
                faceType = true;
            } else if ("reverie".equals(temp.substring(temp.indexOf('{')+1,temp.indexOf('='))) && "biotypical".equals(temp.substring(temp.indexOf('=')+1,temp.indexOf('}')))) {
                reverie = true;
            }
        }
        //if all 3 are true then machine is humanoid
    return bodyType && faceType && reverie;

    }

    // SystemWhole's logic to determine if a Machine is humanoid and count them
    public static int identitySingularityMachines() {
        int count =0;
        for (int i = 0;i<parts.length;i++){
            //checking if there is a conflict between the machines humanoid identity and systemwhole
            if (parts[i].isHumanoid() && !SystemWhole.isHumanoid(parts[i].getProperties())){
                count += 1;
            }
        }
        return count; //returning count of singulartities
    }

    public static Machine[] trackSingularityMachines() {
        //creating array of type Machine to add singularities in
        Machine[] singularity = new Machine[SystemWhole.identitySingularityMachines()];
        int count = 0;
        for (int i = 0;i<parts.length;i++){
            //checking if there is a conflict between the machines humanoid identity and systemwhole
            if (parts[i].isHumanoid() && !SystemWhole.isHumanoid(parts[i].getProperties())){
                singularity[count] = parts[i];
                count += 1;
            }
        }
        return singularity;
    }

}
