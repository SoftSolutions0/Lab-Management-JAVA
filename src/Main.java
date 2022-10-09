import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Dept newDept = new Dept(
                "Computer Science",
                new Employee("John", 12, "HOD"),
                new Employee("Clara", 12, "inCharge"),
                2);
        Scanner input = new Scanner(System.in);

        newDept.printDept();
        while (true) {
            System.out.printf(
                    "%n============"+
                    "%nEnter Options"+
                    "%n1-Create New Lab"+
                    "%n2-List Labs"+
                    "%n3-Exit"+
                    "%n->"
            );
            int userInput = input.nextInt();

            switch (userInput) {
                case 1:
                    newDept.initializeLabs();
                    break;
                case 2:

                    newDept.printLabs(newDept.getLabs());
                    break;

                case 3:
                    System.exit(0);
                default:
                    System.out.println("Invalid Input ");


            }

        }


    }


    public static void listDepts(Dept[] Depts) {
        for (int i = 0; i < Depts.length; i++) {
            if (Depts[i] != null) {
                Depts[i].printDept();
            }
        }
    }


}