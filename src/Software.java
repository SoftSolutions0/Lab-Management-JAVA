public class Software {
    private String name;
    private String type;
    private String version;


    public Software(String name, String type, String model) {
        this.name = name;
        this.type = type;
        this.version = model;
    }


    public Software(Software s) {
        this.name = s.name;
        this.type = s.type;
        this.version = s.version;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }


    public Object clone(){
        return new Software(this);
    }

    public void printSoftware(){
        System.out.printf(
                "%nSoftware-Name: "+this.name+
                " | "+"Type: "+this.type+
                " | "+"Version: "+this.version);
    }
}
