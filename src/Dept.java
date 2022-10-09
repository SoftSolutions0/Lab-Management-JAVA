import java.util.Scanner;

public class Dept {
    private final String name;
    private final Employee HOD;
    private final Employee labIncharge;
    private Lab[] labs;


    public Dept(String name, Employee HOD, Employee labIncharge, int labs) {
        this.name = name;
        this.HOD = HOD;
        this.labIncharge = labIncharge;
        this.labs = new Lab[labs];
    }

    public Dept(Dept d) {
        this.name = d.name;
        this.HOD = d.HOD;
        this.labIncharge = d.labIncharge;
        this.labs = d.labs;
    }

    public Lab[] getLabs() {
        return labs;
    }

    public void setLabs(Lab[] labs) {
        this.labs = labs;
    }

    public Object clone() {
        return new Dept(this);
    }

    public void printDept() {
        System.out.printf("%n=======" +
                "%nDepartment-Name: " + this.name +
                "%nDepartment-HOD: " + this.HOD.getName() +
                "%nLab-InCharge: " + this.labIncharge.getName() +
                "%nDepartment Capacity: " + this.labs.length + "-Labs"
        );
    }


    public void initializeLabs() {

        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        System.out.printf("%nEnter no of computers in the lab:%n->");
        int userIntInput = input.nextInt();
        System.out.printf("Enter Name of Lab-Attendant:%n->");
        String userStringInput = input2.nextLine();


        for (int i = 0; i < labs.length; i++) {
            if (labs[i] == null) {
                labs[i] = new Lab("Lab-" + i, new Employee(userStringInput, 12, "Attendant"), userIntInput);
                labs[i].initializeComputers();
                break;
            } else if (i == labs.length - 1 && labs[i] != null) {
                System.out.printf("%nDepartment Capacity Reached.%nLab not Created");
            }
        }
    }


    public void printLabs(Lab[] labs) {

        for (int i = 0; i < labs.length; i++) {

            if (labs[i] != null) {
                this.labs[i].printLab();


            }
        }
        if (labs[0] == null && labs[labs.length - 1] == null) {
            System.out.println("No Lab Found.");
        }


    }


    public void removeLab(Lab[] labs) {

        Scanner input = new Scanner(System.in);
        System.out.printf("%nEnter Lab Number:%n->");
        int userIntInput = input.nextInt();
        String concat = "Lab-"+userIntInput;


        for (int i = 0; i < labs.length; i++) {

            if (labs[i] != null && this.labs[i].getName().equals(concat)) {
                this.labs[i] = null;
                System.out.printf("%nLab Removed.");
                break;
            }
        }


    }


    public void printLabComputers(Lab[] labs) {

        for (int i = 0; i < labs.length; i++) {

            if (labs[i] != null) {
                this.labs[i].printLab();

                System.out.printf("%nNo of Computers: " + labs[i].getComputers().length);

                this.labs[i].printComputers(labs[i].getComputers());

            }
        }
        if (labs[0] == null && labs[labs.length - 1] == null) {
            System.out.println("No Lab Found.");
        }


    }


    public void searchComputer(Lab[] labs) {

        Scanner input = new Scanner(System.in);
        System.out.printf("%nEnter PC-ID");
        String inputPcID = input.nextLine();

        for (int i = 0; i < labs.length; i++) {

            if (labs[i] != null && this.labs[i].searchComputer(labs[i].getComputers(), inputPcID)) {
                System.out.printf("%nComputer Found in Lab-%d", i);
            }
        }
        if (labs[0] == null && labs[labs.length - 1] == null) {
            System.out.println("No Lab Found.");
        }


    }

}

