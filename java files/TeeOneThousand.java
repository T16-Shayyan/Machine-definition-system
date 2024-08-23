public class TeeOneThousand extends MovieRobot {
    public TeeOneThousand(int serialNumber, boolean flies, boolean autonomous, boolean teleoperated){
        super(serialNumber, flies, autonomous, teleoperated);
    }

    @Override
    public boolean canSpeak(){
        return false;
    }

    public boolean canClean(){
        return true;
    }

    @Override
    public String getCapabilities(){
        String capibilities = super.getCapabilities();
        if (capibilities.equals("")){
            capibilities += "canClean";
        }else{
            capibilities += " canClean";
        }
        return  capibilities;
    }

    public static void main(String[] args){
        TeeOneThousand t = new TeeOneThousand(0, false, true, false);
        System.out.println(t.getCapabilities());
        System.out.println(t.toString());

        Replicant r = new Replicant(1, false, false, true);
        System.out.println(r.getCapabilities());
        System.out.println(r.toString());

        HAL9000 h = new HAL9000(2, true, false, false);
        System.out.println(h.getCapabilities());
        System.out.println(h.toString());

        Vacuum v = new Vacuum(4);
        System.out.println(v.getCapabilities());
        System.out.println(v.toString());

        Drone d = new Drone(5);
        System.out.println(d.getCapabilities());
        System.out.println(d.toString());
    }
}
