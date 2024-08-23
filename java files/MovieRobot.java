public abstract class MovieRobot extends Robot{
    private String catchphrase;

    public MovieRobot(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated, String catchphrase){
        super(serialNumber, flies, autonomous, teleoperated);
        this.catchphrase = catchphrase;
    }

    public MovieRobot(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated){
        super(serialNumber, flies, autonomous, teleoperated);
    }

    public abstract boolean canSpeak();

    @Override
    public String getCapabilities(){
        String capibilities = super.getCapabilities();
        if (canSpeak()){
            if (capibilities.equals("")){
                capibilities += "canSpeak";
            }else{
                capibilities += " canSpeak";
            }
        }
        return capibilities;
    }

    @Override
    public String toString(){
        String sendingString = super.toString();
        if (canSpeak()){
            sendingString += (" \"" + this.catchphrase + "\"");
        }
        return sendingString;
    }

}
