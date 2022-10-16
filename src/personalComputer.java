public class personalComputer{
    private String assetID;
    private String PCname;
    private String LCDName;
    private int ramSize;
    private int diskSize;
    private boolean GPU;

    public personalComputer(personalComputer p) { //Copy constructor
        this.assetID = p.assetID;
        this.PCname = p.PCname;
        this.LCDName = p.LCDName;
        this.ramSize = p.ramSize;
        this.diskSize = p.diskSize;
        this.GPU = p.GPU;
    }

    public personalComputer(String assetID, String PCname, String LCDName, int ramSize, int diskSize, boolean GPU) {
        this.assetID = assetID;
        this.PCname = PCname;
        this.LCDName = LCDName;
        this.ramSize = ramSize;
        this.diskSize = diskSize;
        this.GPU = GPU;
    }


    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getPCName() {
        return PCname;
    }

    public void setName(String PCname) {
        this.PCname = PCname;
    }

    public String getLCDName() {
        return LCDName;
    }

    public void setLCDName(String LCDName) {
        this.LCDName = LCDName;
    }

    public int getRamSize() {
        return ramSize;
    }

    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }

    public int getDiskSize() {
        return diskSize;
    }

    public void setDiskSize(int diskSize) {
        this.diskSize = diskSize;
    }

    public boolean isGPU() {
        return GPU;
    }

    public void setGPU(boolean GPU) {
        this.GPU = GPU;
    }


    public Object clone() {
        return new personalComputer(this);
    }

    public void printPC() { //Prints PC details
        System.out.printf("%n======" +
                "%nPC-ID: " + this.assetID +
                "%nPC-Name:" + this.PCname +
                "%nLCD-Name: " + this.LCDName +
                "%nRam-Size: " + this.ramSize +
                "%nDisk-Size: " + this.diskSize +
                "%nGPU: " + this.GPU
        );
    }

}
