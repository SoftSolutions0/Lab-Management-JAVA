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
                "%nLab-InCharge: " + this.labIncharge.getName()
        );
    }


    public void initializeLabs() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter no of computers in the lab");
        int userInput = input.nextInt();

        for (int i = 0; i < labs.length; i++) {
            if (labs[i] == null) {
                labs[i] = new Lab("Lab-" + i, new Employee("Hello", 12, "Attend"), userInput);
                labs[i].initializeComputers();
                System.out.println("Lab Created");
                break;
            } else if(i == labs.length-1 && labs[i] != null){
                System.out.printf("%nDepartment Capacity Reached.%nLab not Created");
            }
        }
    }


    public void printLabs(Lab[] labs) {

        for (int i = 0; i < labs.length; i++) {

            if (labs[i] != null) {
                this.labs[i].printLab();
                this.labs[i].printComputers(labs[i].getComputers());

            }
        }
        if (labs[labs.length- labs.length] == null && labs[labs.length-1] ==null){
            System.out.println("No Lab Found.");
        }


    }

}

