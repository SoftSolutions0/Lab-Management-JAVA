import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;

public class Main {
    public static void main(String[] args) throws IOException {

//        DataHandler labsFile = new DataHandler();
//
//        labsFile.writeFile("Ahmed", "hassan", 50);
//       labsFile.readFile(5);

        //Creates Department with "Name","HOD","Labs-inCharge"
        Dept newDept = new Dept(
                "Computer Science",
                new Employee("John", 12, "HOD"),
                new Employee("Clara", 12, "inCharge"),
                10
        );

        //Creates input Object
        Scanner input = new Scanner(System.in);

        //Prints department details(Name, HOD-name,inCharge-Name, Department-Capacity of Labs)
        newDept.printDept();

        //Loop for menu options
        while (true) {
            System.out.printf(
                    "%n============" +
                            "%nEnter Options" +
                            "%n1-Create New Lab" +
                            "%n2-List Labs" +
                            "%n3-List Computers in Labs" +
                            "%n4-Search Computer" +
                            "%n5-Read From Lab-File" +
                            "%n6-Remove Lab" +
                            "%n7-Remove Lab from File"+
                            "%n8-Exit" +
                            "%n->"
            );
            int userInput = input.nextInt();

            switch (userInput) {
                case 1 ->
                    //Create New Lab with n No. of Computers
                        newDept.initializeLabs();
                case 2 ->
                    //Prints Labs details of the department
                        newDept.printLabs(newDept.getLabs());
                case 3 ->
                    //Prints computers within no of labs
                        newDept.printLabComputers(newDept.getLabs());
                case 4 ->
                    //Searches for computer
                        newDept.searchComputer(newDept.getLabs());
                case 5 ->
                    //Reads from Lab
                    DataHandler.readLab();
                case 6 ->
                    //Removes Lab
                        newDept.removeLab(newDept.getLabs());
                case 7 ->
                        //Removes Lab from file
                        DataHandler.RUD(false,true,false,true);
                case 8 ->
                    //Exits
                        System.exit(0);
                default -> System.out.println("Invalid Input ");
            }

        }


    }


    public static  void listDepts(Dept[] Depts) { //Pending Function
        for (Dept dept : Depts) {
            if (dept != null) {
                dept.printDept();
            }
        }
    }


}