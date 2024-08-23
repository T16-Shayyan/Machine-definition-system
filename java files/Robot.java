
public class Robot{
    private int serialNumber;
    private boolean flies;
    private boolean autonomous;
    private boolean teleoperated;

    public Robot(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated){
        this.serialNumber = serialNumber;
        this.teleoperated = teleoperated;
        this.flies = flies;
        this.autonomous = autonomous;
    }

    public void setCapabilities(boolean flies, boolean autonomous, boolean teleoperated){
        this.autonomous = autonomous;
        this.flies  = flies;
        this.teleoperated = teleoperated;
    }

    public int getSerialNumber(){
        return this.serialNumber;
    }

    public boolean canFly(){
        return this.flies;
    }

    public boolean isAutonomous(){
        return this.autonomous;
    }

    public boolean isTeleoperated(){
        return this.teleoperated;
    }

    public String getCapabilities(){
        String thing = "";
        if (canFly()){
            thing += "canFly ";
        }
        if (isAutonomous()){
            thing += "isAutonomous ";
        }
        if(isTeleoperated()){
            thing += "isTeleoperated ";
        }

        if (!thing.equals("")){
            thing = thing.substring(0, thing.length()-1);
        }

        return thing;
    }

    @Override public String toString(){
        return ("ID: " + this.getSerialNumber() + ", Capabilities: " + this.getCapabilities());
    }
}