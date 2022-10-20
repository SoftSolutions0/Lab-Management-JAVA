public class Lab {
    private String name;
    private Employee attendant;
    private personalComputer[] computers;

    private Software[] softwares;

    public Lab(String name, Employee attendant, int computers, int softwares) {
        this.name = name;
        this.attendant = attendant;
        this.computers = new personalComputer[computers];
        this.softwares = new Software[softwares];
    }

    public Lab(Lab l) { //Copy constructor
        this.name = l.name;
        this.attendant = l.attendant;
        this.computers = l.computers;
        this.softwares = l.softwares;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getAttendant() {
        return attendant;
    }

    public void setAttendant(Employee attendant) {
        this.attendant = attendant;
    }

    public personalComputer[] getComputers() {
        return computers;
    }

    public void setComputers(personalComputer[] computers) {
        this.computers = computers;
    }

    public Software[] getSoftwares() {
        return softwares;
    }

    public void setSoftwares(Software[] softwares) {
        this.softwares = softwares;
    }

    public Object clone() {
        return new Lab(this);
    }

    public void printLab() { //Print lab details
        System.out.printf("=====" +
                "%nLab-No: " + this.name +
                " | Attendant-Name: " + this.attendant.getName() +
                " | No of Computers: " + this.getComputers().length+
                " | "

        );
    }

    public void initializeSoftwares(){
        for (int i =0;i<softwares.length;i++){
            if(softwares[i] == null){
                softwares[i] = new Software("Adobe", "Utility", "0.03");
            }
        }
    }

    public void printSoftwares(Software[] softwares ){
        for(Software software: softwares){
            if(software != null){
                software.printSoftware();
            }
        }
    }



    public void initializeComputers() {
        //Creates n no. of computers in lab
        for (int i = 0; i < computers.length; i++) {
            if (computers[i] == null)
                computers[i] = new personalComputer(
                        "00" + i,
                        "Dell",
                        "Lenovo",
                        512,
                        256,
                        true

                );
        }
    }


    public void printComputers(personalComputer[] computers) { //Prints computer details
        for (personalComputer computer : computers) {
            if (computer != null) {
                computer.printPC();
            }
        }
    }

    public boolean searchComputer(personalComputer[] computers, String computerID) { //Searches for computer ID
        boolean systemFound = false;
        for (personalComputer computer : computers) {
            if (computer != null && computer.getAssetID().equals(computerID)) {
                systemFound = true;
                break;
            }
        }
        return systemFound;
    }
}
