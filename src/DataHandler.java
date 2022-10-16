import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class DataHandler {



    public static void writeLab(String labName, String attendantName, int computers) throws IOException {

        File file1 = new File("Labs.dat");
        FileWriter writeFile = new FileWriter(file1, true);
        writeFile.write("Lab-No: "+labName+"\n");
        writeFile.write("Attendant-Name: "+attendantName+"\n");
        writeFile.write("No of Computers: "+ computers+"\n");
        writeFile.close();
    }

    public static void readLab() throws IOException {
        File file1 = new File("Labs.dat");
        Scanner scanFile = new Scanner(file1);
        String line = null;
        while(scanFile.hasNextLine()){
            line = scanFile.nextLine();
            System.out.println(line);
        }

    }

    public static void RUD(boolean read, boolean search, boolean update, boolean delete) throws IOException {
        File file1 = new File("Labs.dat");
        Scanner fileReader = new Scanner(file1);

        String data[] = new String[200];
        String line = null;
        int counter = 0;
        while(fileReader.hasNextLine()){
            line = fileReader.nextLine();
            data[counter] = line;
            counter++;
        }


        if(read || search || update || delete){
            Scanner input = new Scanner(System.in);
            String userString=null;

            if(search) {
                System.out.printf("%nEnter Name of Lab:%n->");
                userString = input.nextLine();
            }

            for (int i = 0;i<counter;i+=3) {

                if(read){
                    for(int r=0;r<counter;r++) {
                        System.out.println(data[r]);
                        if(r%3==2){
                            System.out.println("======");
                        }
                    }
                    read = false;
                }

                if(search && data[i].split(" ")[1].equalsIgnoreCase(userString)){
                    System.out.println("Lab Found");


                    if(delete){
                        data[i]=null;
                        data[i+1]=null;
                        data[i+2]=null;
                        FileWriter labsDataDelete = new FileWriter(file1);
                        for(int j=0;j<counter;j++) {
                            if(data[j]!=null) {
                                labsDataDelete.write(data[j] + "\n");
                            }
                        }
                        labsDataDelete.close();
                        System.out.println("Lab Deleted");
                        break;
                    }
                    break;
                }


            }
        }

    }



}
