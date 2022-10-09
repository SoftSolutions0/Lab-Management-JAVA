public class Lab {
    private String name;
    private Employee attendant;
    private personalComputer[] computers;

    public Lab(String name, Employee attendant, int computers) {
        this.name = name;
        this.attendant = attendant;
        this.computers = new personalComputer[computers];
    }

    public Lab(Lab l) {
        this.name = l.name;
        this.attendant = l.attendant;
        this.computers = l.computers;

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

    public Object clone() {
        return new Lab(this);
    }

    public void printLab() {
        System.out.printf("%n=======" +
                "%nLab-No: " + this.name +
                "%nAttendant-Name: " + this.attendant.getName() +
                "%nNo of Computers: " + this.getComputers().length

        );
    }

    public void initializeComputers() {

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


    public void printComputers(personalComputer[] computers) {
        for (int i = 0; i < computers.length; i++) {
            if (computers[i] != null) {
                computers[i].printPC();
            }
        }
    }

    public boolean searchComputer(personalComputer[] computers, String computerID) {
        boolean systemFound = false;
        for (int i = 0; i < computers.length; i++) {
            if (computers[i] != null && computers[i].getAssetID().equals(computerID)) {
                systemFound = true;
                break;
            }
        }
        return systemFound;
    }
}
