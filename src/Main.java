import java.io.File;
import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.FileHandler;

public class Main {
    public static void main(String[] args) throws IOException {

        //Boolean to check save function
            boolean universalSave = false;
            boolean universalLoad = true;

        //Creates input Object
        Scanner input = new Scanner(System.in);

            //Creates Department with "Name","HOD","Labs-inCharge"
            Dept newDept = new Dept(
                    "Computer Science",
                    new Employee("John", 12, "HOD"),
                    new Employee("Clara", 12, "inCharge"),
                    10
            );


        //Prints department details(Name, HOD-name,inCharge-Name, Department-Capacity of Labs)
//        newDept.printDept();

        File labData = new File("files\\Labs.dat");
        File pcData = new File("files\\Computers.dat");
        File softwareData = new File("files\\Softwares.dat");

        if(labData.length() >0 && pcData.length()>0 && softwareData.length()>0){

            System.out.printf(
                    "%n=====" +
                    "%nData Found in Drive." +
                    "%nDo you wish to load Data?" +
                    "%n1-Yes" +
                    "%n2-No"+
                    "%n->");

            int userInput = input.nextInt();
            switch (userInput) {
                case 1:
                    newDept.loadLabs();
                    universalLoad = false;
                    break;

                case 2:
                    break;

                default:
                    System.out.println("Invalid Input");
            }

        }


            //Loop for menu options
            while (true) {
//
                System.out.println(
                        """
                                            
                                            ============
                                            Enter Options
                        1-Create New Lab                       2-List Labs
                        5-Search Computer                      3-List Computers in Lab
                        6-Remove Lab                           4-List Softwares in Lab
                        7-Save Data                            8-Load Data
                        
                                               0-Exit
                        """
                );
                System.out.print("->");
                int userInput = input.nextInt();

                switch (userInput) {
                    case 1:
                        //Create New Lab with n No. of Computers
                        newDept.initializeLabs();
                        universalSave = true;
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
                        newDept.printLabSoftwares(newDept.getLabs());
                        break;
                    case 5:
                        //Searches for computer
                        newDept.searchComputer(newDept.getLabs());
                        break;
                    case 6:
                        //Removes Lab
                        newDept.removeLab(newDept.getLabs());
                        universalSave = true;
                        break;

                    case 7:
                        //Save Data
                        if(universalSave){
                            newDept.saveData(newDept.getLabs());
                            universalSave = false;
                            universalLoad = true;
                        } else {
                            System.out.println("No Changes to Save.");
                        }
                        break;

                    case 8:
                        //Load Data
                        if(universalLoad){
                            newDept.loadLabs();
                            universalLoad = false;
                        } else {
                            System.out.println("Data Already Loaded");
                        }
                        break;


                    case 0:
                        //Saves || Exits
                        if (universalSave) {
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