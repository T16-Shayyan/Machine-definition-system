public class Replicant extends MovieRobot {
    public Replicant(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated){
        super(serialNumber, flies, autonomous, teleoperated, "like tears in rain...");
    }

    @Override
    public boolean canSpeak(){
        return true;
    }

    public boolean canFight(){
        return true;
    }

    @Override
    public String getCapabilities(){
        String capibilities = super.getCapabilities();
        if (capibilities.equals("")){
            capibilities += "canFight";
        }else{
            capibilities += " canFight";
        }
        return  capibilities;
    }
}