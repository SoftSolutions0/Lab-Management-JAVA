import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
        System.out.printf(
                "%nLab-Name: " + this.name +
                " | Attendant-Name: " + this.attendant.getName() +
                " | No of Computers: " + this.getComputers().length+
                " | No of Softwares: " + this.getSoftwares().length

        );
    }

    public void initializeSoftwares(){
        for (int i =0;i<softwares.length;i++){
            if(softwares[i] == null){
                softwares[i] = new Software(
                        "Adobe",
                        "Utility",
                        "0.03"
                );
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
            if (computers[i] == null) {
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
    }

    public void loadComputers() throws FileNotFoundException {
        File computerFile =new File("files\\Computers.dat");
        Scanner pcReader = new Scanner(computerFile);

        int counter = 0;
        while(pcReader.hasNextLine() && counter<computers.length){
            String pcLine = pcReader.nextLine();

            String labID = pcLine.split(",")[0];
            String pcID = pcLine.split(",")[1];
            String pcName = pcLine.split(",")[2];
            String pcLCD = pcLine.split(",")[3];
            String pcRam = pcLine.split(",")[4];
            String pcDisk = pcLine.split(",")[5];
            String pcGPU = pcLine.split(",")[6];
            if(this.name.equals(labID)) {
                computers[counter] = new personalComputer(
                        pcID,
                        pcName,
                        pcLCD,
                        Integer.parseInt(pcRam),
                        Integer.parseInt(pcDisk),
                        Boolean.parseBoolean(pcGPU));
                counter++;
            }




        }


    }

    public void loadSoftwares() throws FileNotFoundException {
        File softwareFile =new File("files\\Softwares.dat");
        Scanner softwareReader = new Scanner(softwareFile);

        int counter = 0;
        while(softwareReader.hasNextLine() && counter<softwares.length){
            String softwareLine = softwareReader.nextLine();

            String labID = softwareLine.split(",")[0];
            String softwareName = softwareLine.split(",")[1];
            String softwareType = softwareLine.split(",")[2];
            String softwareModel = softwareLine.split(",")[3];

            if(this.name.equals(labID)) {
                softwares[counter] = new Software(
                        softwareName,
                        softwareType,
                        softwareModel);
                counter++;
            }




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


    public void saveComputers(personalComputer[] computers) throws IOException {
        File computerFile = new File("files\\Computers.dat");
        FileWriter cw = new FileWriter(computerFile, true);

        for (int i=0; i<computers.length;i++){

            if(computers[i] != null){
                cw.write(
                        this.name+","+
                                computers[i].getAssetID()+","+
                                computers[i].getPCName()+","+
                                computers[i].getLCDName()+","+
                                computers[i].getRamSize()+","+
                                computers[i].getDiskSize()+","+
                                computers[i].isGPU()+"\n"
                );
            }

        }
        cw.close();


    }



    public void saveSoftwares(Software[] softwares) throws IOException {
        File softwareFile = new File("files\\Softwares.dat");
        FileWriter sw = new FileWriter(softwareFile, true);

        for (int i=0; i<softwares.length;i++){

            if(softwares[i] != null){
                sw.write(
                        this.name+","+
                                softwares[i].getName()+","+
                                softwares[i].getType()+","+
                                softwares[i].getVersion()+"\n"
                );
            }

        }
        sw.close();


    }
}
