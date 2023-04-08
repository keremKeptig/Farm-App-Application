package farmAppPackage.core;

import farmAppPackage.support.Animal;
import farmAppPackage.support.Employee;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Creates a GUI and Runs interactive application.
 * @author Kerem Keptig 2453355.
 * @version JDK 19
 *
 */
public class FarmApp implements Serializable {
    public static ArrayList<Animal> animals;
    public static ArrayList<Employee> employees;

    /**
     * Default constructor.
     */
    public FarmApp() {
        this.animals = new ArrayList<Animal>();
        this.employees = new ArrayList<Employee>();
    }
    /**
     * The constructor, which takes all the parameters (animal and employee ArrayList),and assigns it to the values in the class.
     * @param animals Sets all animal objects within an ArrayList.
     * @param employees Sets all employee objects within an ArrayList.
     */
    public FarmApp(ArrayList<Animal> animals, ArrayList<Employee> employees) {
        int i;
        this.animals = new ArrayList<Animal>();
        this.employees = new ArrayList<Employee>();

        for (i=0; i < animals.size(); i++) {

            this.animals.add(animals.get(i));
        }
        for (i=0; i < employees.size(); i++) {

            this.employees.add(employees.get(i));
        }
    }

    public static void main(String[] args) {
        FarmApp.animals = new ArrayList<Animal>();
        FarmApp.employees = new ArrayList<Employee>();
        //database connection
        DataStorage storage = new DataStorage();
        //reading animals from database and adds into FarmApp.animals list
        storage.animalDataBaseRead(FarmApp.animals);
        //reading employees from database and adds into FarmApp.employees list
        storage.employeeDatabaseRead(FarmApp.employees);


        File animalText = new File("Animal.txt");
        File md5Text = new File("storedMD5.txt");
        //create file
        try {
            if (!animalText.exists()){
                animalText.createNewFile();
            }
            if (!md5Text.exists()){
                md5Text.createNewFile();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Before application closed MD5 value
        String storedMD5 = "";

        try {
            BufferedReader reader = new BufferedReader(new FileReader("storedMD5.txt"));
            storedMD5 = reader.readLine();
        } catch (IOException ex) {
            System.out.println(ex);
            return;
        }

        // Creates MD5 based on the data in Animal.txt
        // and compares it with the MD5 before the application was closed
        // also I wrote my thread class in my DataStorage class
        DataStorage.CheckMD5Thread checkMD5Thread = new DataStorage.CheckMD5Thread("Animal.txt", storedMD5);
        // Creates Thread for checkMD5Thread object
        Thread thread = new Thread(checkMD5Thread);
        thread.start();

        //my gui object also runs in thread because it runs parallel
       Thread guiThread = new Thread(new Runnable() {
            public void run() {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        FarmAppGUI farmAppGUI = new FarmAppGUI(storage);
                    }
                });
            }
        });
        guiThread.start();


    }

}
