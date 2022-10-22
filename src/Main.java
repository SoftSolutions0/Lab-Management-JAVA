import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;

public class Main {
    public static void main(String[] args) throws IOException {

            boolean universalValue = true;

            //Creates Department with "Name","HOD","Labs-inCharge"
            Dept newDept = new Dept(
                    "Computer Science",
                    new Employee("John", 12, "HOD"),
                    new Employee("Clara", 12, "inCharge"),
                    10
            );

            newDept.loadLabs();

            //Creates input Object
            Scanner input = new Scanner(System.in);

            //Prints department details(Name, HOD-name,inCharge-Name, Department-Capacity of Labs)
            newDept.printDept();

            //Loop for menu options
            while (true) {
                System.out.printf(
                        "%n=======" +
                                "%nEnter Options" +
                                "%n1-Create New Lab" +
                                "%n2-List Labs" +
                                "%n3-List Computers in Labs" +
                                "%n4-Search Computer" +
                                "%n5-Remove Lab" +
                                "%n6-Exit" +
                                "%n->"
                );
                int userInput = input.nextInt();

                switch (userInput) {
                    case 1:
                        //Create New Lab with n No. of Computers
                        newDept.initializeLabs();
                        universalValue = false;
                        break;
                    case 2:
                        //Prints Labs details of the department
                        newDept.printLabs(newDept.getLabs());
                        break;
                    case 3:
                        //Prints computers within no of labs
                        newDept.printLabComputers(newDept.getLabs());
                        break;
                    case 4:
                        //Searches for computer
                        newDept.searchComputer(newDept.getLabs());
                        break;
                    case 5:
                        //Removes Lab
                        newDept.removeLab(newDept.getLabs());
                        universalValue = false;
                        break;

                    case 6:
                        //Exits
                        if (!universalValue) {
                            System.out.printf("%nWould you like to save changes?%n1-Yes%n2-No%n->");
                            int saveValue = input.nextInt();
                            switch (saveValue) {
                                case 1:
                                    newDept.saveData(newDept.getLabs());
                                    break;

                                case 2:
                                    break;

                                default:
                                    System.out.println("Invalid Input");
                            }
                        }
                        System.out.println("Exiting...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Input ");

                }

            }


    }

}