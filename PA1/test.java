class test{
    public static void main(String[] args) {
        String thing = "{\"kind\": \"Humanoid\", \"bodyType\": \"physical\", \"faceType\": \"anthropomorphic\", \"reverie\": \"mechatypical\"}";
        thing = thing.replace("\"", "");
        thing = thing.replace("{", "");
        thing = thing.replace("}", "");
        String[] newthing = thing.split(", ");
        String[][] superthing = new String[newthing.length][2];
        for (int i = 0; i < newthing.length; i++) {
            superthing[i] = newthing[i].split(": ");
        }

        for (int j = 0; j < newthing.length; j++) {
            for (int k = 0; k < superthing[j].length; k++) {
                System.out.println(superthing[j][k]);
            }
        }
    }
}