package Logic;

/**
 * Created by Benny on 11/16/2016.
 */
public class Part {

    private String partName;
    private double partDurability;

    public Part(){
        this.partName = "TestPart";
        this.partDurability = 10.0;
    }

    public Part(String partName, double partDurability){
        this.partName = partName;
        this.partDurability = partDurability;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public double getPartDurability() {
        return partDurability;
    }

    public void setPartDurability(double partDurability) {
        this.partDurability = partDurability;
    }

    public String toString(){
        return "Part Name:" + partName + "\nPart Durability:" + partDurability;
    }
}
