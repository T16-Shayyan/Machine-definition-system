

public class ShapeAnalyzer {
    private static final Object EMPTY_PROPERTY = new Object();

    //method to return the machine
    public static Machine analyze(String json) {
        //parsing entries to make a 2d array
        String[][] keyValue= parseEntries(json);
        //making array dedicated to properties of type Partstate
        Object[] properties = reifyProperties(keyValue);
        //getting kind
        String kind = reifyKind(keyValue);
        //making  new machine object
        Machine currentMachine = new Machine(kind, properties, SystemWhole.isHumanoid(properties));
        return currentMachine;
    }

    public static String[][] parseEntries(String flatJson) {
        //removing all useless thing like " { }
        flatJson = flatJson.replace("\"", "");
        flatJson = flatJson.replace("{", "");
        flatJson = flatJson.replace("}", "");
        //making 1d array with splitted by , and space
        String[] newflatJson = flatJson.split(", ");
        String[][] supernewflatJson = new String[newflatJson.length][2];
        for (int i = 0; i < newflatJson.length; i++) {
            //splitting again to make a 2d array splited by : and space
            supernewflatJson[i] = newflatJson[i].split(": ");
        }
        //returing the parsed 2d array
        return supernewflatJson;
    }

    public static String reifyKind(String[][] entries) {
        for (int i =0; i<entries.length;i++){
            if ("kind".equals(entries[i][0])){    //== dosent work here
                //returning kind
                return entries[i][1];
            }
        }
        return null;
    }

    public static Object[] reifyProperties(String[][] entries) {
        Object[] properties = new Object[entries.length - 1]; //remove kind
        int propertieCount = 0;
        for (int i =0; i <entries.length;i++){
            //if its not kind then make a new partstate object and add properties to array
            if (!"kind".equals(entries[i][0])){
                properties[propertieCount] = new PartState(entries[i][0],inferObject(entries[i][1]));
                propertieCount += 1;
            }
        }
        return properties;
    }

    public static boolean isDigit(char c) {
        //check  if it is a number
        if (c >= '0' && c <= '9'){
            return true;
        }else {
            return false;
        }
    }

    public static boolean hasNonNumbers(String value) {
        int numPeriod = 0;
        char temp;
        //counting number of periods
        for (int i = 0; i<value.length(); i++) {
            //storing current character
            temp = value.charAt(i);
            if (temp == '.') {
                numPeriod += 1;
            }
        }
        for (int i = 0; i<value.length(); i++){
            temp = value.charAt(i);
            //if any one is true its a number
            if (temp == '_' || isDigit(temp) || numPeriod == 1 ){
                return false;
            }
        }
        return true;
    }

    public static Object inferObject(String value) {
        //if null then return EMPTY_PROPERTY
        if (value == null){
            return EMPTY_PROPERTY;
            //check if it has a decimal point if es then change data type to double
        }else if (!hasNonNumbers(value) && value.indexOf('.') != -1) {
            return Double.parseDouble(value);
            //if has no decimal point is not a number then return  the value as string
        } else  if (hasNonNumbers(value) && value.indexOf('.') == -1){
            return value;
            //else return integer
        }else {
            return Integer.parseInt(value);
        }
    }
}