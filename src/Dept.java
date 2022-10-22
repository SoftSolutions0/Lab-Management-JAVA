import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
                " | Department-HOD: " + this.HOD.getName() +
                " | Lab-InCharge: " + this.labIncharge.getName() +
                " | Department Capacity: " + this.labs.length + "-Labs"
        );
    }


    public void initializeLabs(){

        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        System.out.printf("%nEnter no of computers in the lab:%n->");
        int userIntInput = input.nextInt();
        System.out.printf("Enter Name of Lab-Attendant:%n->");
        String userStringInput = input2.nextLine();

        for (int i = 0; i < labs.length; i++) {
            if (labs[i] == null) {
                labs[i] = new Lab("Lab-" + i, new Employee(userStringInput, 12, "Attendant"), userIntInput,1);

                labs[i].initializeComputers();
                labs[i].initializeSoftwares();
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
        Scanner input = new Scanner(System.in);
        System.out.printf("%nEnter Lab-Name%nLab-");
        String inputLabName = "Lab-"+input.nextLine();

        for (int i = 0; i < labs.length; i++) {

            if (labs[i] != null && labs[i].getName().equals(inputLabName)) {
                this.labs[i].printLab();
                this.labs[i].printComputers(labs[i].getComputers());

            }
        }
        if (labs[0] == null && labs[labs.length - 1] == null) {
            System.out.println("No Lab Found.");
        }


    }


    public void searchComputer(Lab[] labs) {

        Scanner input = new Scanner(System.in);
        System.out.printf("%nEnter Lab-Name%nLab-");
        String inputLabName = "Lab-"+input.nextLine();
        System.out.println("Enter PC-ID");
        String inputPcID = input.nextLine();
        for (int i = 0; i < labs.length; i++) {

            if (
                    labs[i] != null &&
                    labs[i].getName().equals(inputLabName) &&
                    this.labs[i].searchComputer(labs[i].getComputers(),
                    inputPcID)
            ) {
                System.out.println("Computer Found in Lab-"+ i);
            }
        }
        if (labs[0] == null && labs[labs.length - 1] == null) {
            System.out.println("No Lab Found.");
        }


    }


    public void loadLabs() throws IOException {
        File LabFile = new File("files\\Labs.dat");
        Scanner labReader = new Scanner(LabFile);
        File EmployeeFile = new File("files\\Employees.dat");
        Scanner employeeReader = new Scanner(EmployeeFile);

        int counter = 0;

        while(labReader.hasNextLine()){
            boolean validity = true;
            String labLine = labReader.nextLine();


                String labName = labLine.split(",")[0];
                String labAttendant = labLine.split(",")[1];
                String labPcs = labLine.split(",")[2];
                String labSoftware = labLine.split(",")[3];

                Employee emp = new Employee(labAttendant, null, "Attendant");


                    while(Integer.parseInt(labLine.substring(4, 5)) != counter) {
                        counter++;
                    }


                    if (labs[counter] == null && Integer.parseInt(labLine.substring(4, 5)) == counter) {
                        labs[counter] = new Lab(
                                labName,
                                emp,
                                Integer.parseInt(labPcs),
                                Integer.parseInt(labSoftware));

                        labs[counter].loadComputers();
                    }

                    counter++;

        }
    }


    public void saveData(Lab[] labs) throws IOException {
        File labFile = new File("files\\Labs.dat");
        File pcFile = new File("files\\Computers.dat");

        FileWriter lw = new FileWriter(labFile);
        FileWriter cw = new FileWriter(pcFile);
        cw.write("");
        cw.close();
        for (int i = 0; i < labs.length; i++) {

            if (labs[i] != null) {
                lw.write(
                        this.labs[i].getName()+","+
                        this.labs[i].getAttendant().getName()+","+
                        this.labs[i].getComputers().length+","+
                        this.labs[i].getSoftwares().length+"\n"
                );
                this.labs[i].saveComputers(this.labs[i].getComputers());

            }
        }
        lw.close();
        System.out.println("Data Saved.");
    }


}

