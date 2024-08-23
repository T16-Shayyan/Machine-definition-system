public class Vacuum extends Robot{
    
    public Vacuum(int serialNumber){
        super(serialNumber, false, true, false);
    }

    public boolean canClean(){
        return true;
    }

    @Override
    public String getCapabilities(){
        String capibilities = super.getCapabilities();
        capibilities += " canClean";
        return  capibilities;
    }

    @Override
    public boolean canFly(){
        return false;
    }

    @Override
    public boolean isAutonomous(){
        return true;
    }

    @Override
    public boolean isTeleoperated(){
        return false;
    }
}