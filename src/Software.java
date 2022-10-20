public class Software {
    private String name;
    private String type;
    private String model;


    public Software(String name, String type, String model) {
        this.name = name;
        this.type = type;
        this.model = model;
    }


    public Software(Software s) {
        this.name = s.name;
        this.type = s.type;
        this.model = s.model;
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public Object clone(){
        return new Software(this);
    }

    public void printSoftware(){
        System.out.println("Software-Name: "+this.name+" | "+"Type: "+this.type+" | "+"Model: "+this.model);
    }
}
