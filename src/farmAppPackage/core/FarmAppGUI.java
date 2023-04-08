package farmAppPackage.core;

import farmAppPackage.support.Animal;
import farmAppPackage.support.Employee;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.security.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 * class that has all GUI components
 * @author Kerem Keptig 2453355.
 * @version JDK 19
 */
public class FarmAppGUI extends JFrame implements Serializable{
    private JPanel parentPanel;
    private JButton addCowButton;
    private JButton exitButton;
    private JButton deleteCowButton;
    private JButton cowDetailsButton;
    private JButton vetDetailsButton;
    private JButton addTreatmentButton;
    private JButton addVetButton;
    private JButton deleteVetButton;
    private JButton cowTreatmentButton;
    private JButton listCowsButton;
    private JButton listVetsButton;
    private JPanel menuPanel;
    private JPanel addCowPanel;
    private JTextField cowTagNumber;
    private JTextField cowDateOfBirth;
    private JTextField cowWeight;
    private JComboBox cowGender;
    private JComboBox cowPurchased;
    private JButton addCow;
    private JButton addSheepButton;
    private JButton addFarmWorkerButton;
    private JPanel listCowPanel;
    private JTextField sheepTagNumber;
    private JTextField dateOfBirthSheep;
    private JComboBox genderSheep;
    private JComboBox purchasedSheep;
    private JButton addSheep;
    private JPanel addSheepPanel;
    private JTextField deleteCowText;
    private JLabel deleteTag;
    private JButton deleteCow;
    private JPanel deletePanel;
    private JPanel getCowDetails;
    private JTextField cowDetailsText;
    private JTextArea cowDetailsTagNo;
    private JPanel textCowPanel;
    private JPanel buttonTabs;
    private JButton CowDetailButton;
    private JTextField vetIdText;
    private JComboBox vetGenderBox;
    private JTextField vetDateText;
    private JComboBox vetDegreeBox;
    private JTextField graduationVetText;
    private JTextField expertiseLevelVetText;
    private JPanel addVetPanel;
    private JButton addVet;
    private JPanel listVetsPanel;
    private JPanel addFarmWorkerPanel;
    private JTextField farmWorkerIdText;
    private JComboBox workerGenderBox;
    private JTextField dateWorkerText;
    private JTextField prevFarmNameText;
    private JTextField experienceWorkerText;
    private JButton addFarmWorker;
    private JButton feedingAnimalButton;
    private JButton employeeSalaryButton;
    private JButton addMilkingButton;
    private JPanel deleteVetPanel;
    private JTextField deleteVetText;
    private JButton deleteVet;
    private JTextField vetDetailsIDText;
    private JPanel vetDetailsPanel;
    private JPanel textVetDetails;
    private JTextArea vetIDText;
    private JButton vetDetails;
    private JPanel addTreatmentPanel;
    private JTextField tagNoTreatment;
    private JTextField vetIdTreatment;
    private JComboBox medicationType;
    private JButton proceedButton;
    private JPanel cleaningPanel;
    private JTextField cleaningDateText;
    private JTextField cleaningMaterialText;
    private JButton addCleaningTreatmentButton;
    private JTextField healthDateText;
    private JTextField healthMedText;
    private JComboBox healthEmBox;
    private JTextField healthDurText;
    private JTextField healthMedDateText;
    private JTextField healthDosText;
    private JTextField healthMedNotesText;
    private JButton addHealthTreatmentButton;
    private JPanel healthTreatmentPanel;
    private JPanel getCowTreatment;
    private JTextField treatmentDetailsEntered;
    private JScrollPane cowTreatmentPanel;
    private JTextArea cowTreatmentText;
    private JButton treatmentDetailsButton;
    private JButton cowTreatmentWithDateButton;
    private JPanel getCowTreatmentDate;
    private JTextField treatmentDateTagNo;
    private JButton TreatmentDetailsDate;
    private JTextArea cowTreatmentDateText;
    private JTextField treatmentDate;
    private JScrollPane cowTreatmentDatePanel;
    private JPanel feedingAnimalPanel;
    private JTextField feedingTagNoText;
    private JButton feedingAnimalsDetailsButton;
    private JPanel employeePanel;
    private JTextField employeeSalText;
    private JButton employeeSalaryDetailsButton;
    private JTextField milkingTextTag;
    private JTextField milkingAmountText;
    private JButton addMilkingButton1;
    private JPanel milkingPanel;
    private JButton deleteSheepButton;
    private JPanel deleteSheepPanel;
    private JTextField deleteTextSheep;
    private JButton deleteSheepButton1;
    private JButton sheepDetailsButton;
    private JPanel getSheepDetails;
    private JTextField sheepTagNoDetails;
    private JButton sheepDetailsButton1;
    private JTextArea sheepDetailsTagNo;
    private JPanel sheepTextPanel;
    private JPanel deleteFarmWorker;
    private JTextField deleteFArmWorkerText;
    private JButton deleteFarmWorkerButton;
    private JButton deleteFarmWorkerButton2;
    private JButton farmWorkerDetailsButton;
    private JButton listFarmWorkersButton;
    private JButton listSheepsButton;
    private JTextField farmWorkerIDarea;
    private JButton farmWorkerDetailsButton1;
    private JTextArea farmWorkerIDText;
    private JPanel farmWorkerDetailsPanel;
    private JPanel farmWorkerAreaPanel;
    private JPanel listFarmWorker;
    private JPanel listSheep;
    private JButton listCowButton;
    private static FarmAppGUI farmAppGUI;
    private JScrollPane scrollPaneCow;
    private JScrollPane scrollPaneVet;
    private JTable cowTable;
    private JTable vetTable;
    private JFrame guiFrame;
    private JTable farmWorkerTable;
    private JScrollPane farmWorkerPane;
    private JTable sheepTable;
    private JScrollPane sheepPane;

    public FarmAppGUI(DataStorage storage) {
        guiFrame = new JFrame();
        JMenuBar menuBar = new JMenuBar();
        JMenu item1 = new JMenu("File");
        JMenu item2 = new JMenu("Edit");

        JMenuItem saveBar = new JMenuItem("Save");
        JMenuItem loadAnimal = new JMenuItem("Load Animal");
        JMenuItem loadEmployee = new JMenuItem("Load Employee");
        JMenuItem exitApp = new JMenuItem("Exit");
        item1.add(saveBar);
        item1.add(loadAnimal);
        item1.add(loadEmployee);
        item1.add(exitApp);
        menuBar.add(item1);
        menuBar.add(item2);

        guiFrame.setJMenuBar(menuBar);

        //exit application
        guiFrame.addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                //write to external file
               try {
                    ObjectOutputStream outAnimal = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Animal.txt")));

                    for(Animal animal:FarmApp.animals){
                        outAnimal.writeObject(animal);
                    }
                    outAnimal.close();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                storage.generateMD5();
                System.exit(0);
            }
        });

        guiFrame.add(parentPanel);
        guiFrame.setTitle("Farm App");
        guiFrame.setSize(800,800);
        guiFrame.setVisible(true);
        //guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        hideAllPanels();
        // this is the welcome to farm app screen, and shown it only once at the beginning
        menuPanel.setVisible(true);

        loadAnimal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setCurrentDirectory(new File("."));
                // select file to open, and returns response
                int currentResponse = jFileChooser.showOpenDialog(null);
                if (currentResponse == jFileChooser.APPROVE_OPTION){
                    File file = new File(jFileChooser.getSelectedFile().getAbsolutePath());

                    try {
                        ObjectInputStream inputAnimal = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file.getAbsolutePath())));

                        Animal animal = null;
                        do{
                            try {
                                animal = (Animal) inputAnimal.readObject();
                                FarmApp.animals.add(animal);

                            } catch (EOFException exception) {
                                break;
                            } catch (ClassNotFoundException exception) {
                                throw new RuntimeException(exception);
                            }

                        }while (animal != null);

                        inputAnimal.close();
                    } catch (EOFException exception) {
                        //This means file initially empty.
                    } catch (FileNotFoundException exception) {
                        throw new RuntimeException(exception);
                    } catch (IOException exception) {
                        throw new RuntimeException(exception);
                    }
                }

            }
        });

        loadEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                jFileChooser.setCurrentDirectory(new File("."));
                // select file to open, and returns response
                int currentResponse = jFileChooser.showOpenDialog(null);
                if (currentResponse == jFileChooser.APPROVE_OPTION){
                    File file = new File(jFileChooser.getSelectedFile().getAbsolutePath());

                    try {
                        ObjectInputStream inputEmployee = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file.getAbsolutePath())));

                        Employee employee = null;
                        do{
                            try {
                                employee = (Employee) inputEmployee.readObject();
                                FarmApp.employees.add(employee);

                            } catch (EOFException exception) {
                                break;
                            } catch (ClassNotFoundException exception) {
                                throw new RuntimeException(exception);
                            }

                        }while (employee != null);

                        inputEmployee.close();
                    } catch (EOFException exception) {
                        //This means file initially empty.
                    } catch (FileNotFoundException exception) {
                        throw new RuntimeException(exception);
                    } catch (IOException exception) {
                        throw new RuntimeException(exception);
                    }
                }

            }
        });

        saveBar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ObjectOutputStream outAnimal = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("animal.dat")));
                    ObjectOutputStream outEmployee = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("employee.dat")));

                    for(Animal animal:FarmApp.animals){
                        outAnimal.writeObject(animal);
                    }

                    for(Employee employee:FarmApp.employees){
                        outEmployee.writeObject(employee);
                    }
                    outAnimal.close();
                    outEmployee.close();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(saveBar,"File is saved");
            }
        });
        exitApp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //write to external file
                try {
                    ObjectOutputStream outAnimal = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Animal.txt")));

                    for(Animal animal:FarmApp.animals){
                        outAnimal.writeObject(animal);
                    }
                    outAnimal.close();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                storage.generateMD5();
                System.exit(0);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //write to external file
                try {
                    ObjectOutputStream outAnimal = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("Animal.txt")));

                    for(Animal animal:FarmApp.animals){
                        outAnimal.writeObject(animal);
                    }
                    outAnimal.close();

                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                hideAllPanels();
                storage.generateMD5();
                FileInputStream fis = null;

                System.exit(0);
            }
        });

        addCowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                addCowPanel.setVisible(true);
            }
        });

        addCow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag = 1;
                for (int i=0; i < FarmApp.animals.size();i++){

                    if (FarmApp.animals.get(i).getTagNo() == Integer.parseInt(cowTagNumber.getText())){
                        // flag for if a given tag number is already exist, it doesn't do add operation.
                        flag = 0;
                    }
                }
                if (flag == 1) {

                    Calendar date = Calendar.getInstance();
                    int tagNo = Integer.parseInt(cowTagNumber.getText());
                    int genderSelect = cowGender.getSelectedIndex();
                    String gender = "";
                    if (genderSelect == 1) {
                        gender = "Male";
                    } else {
                        gender = "Female";
                    }
                    String[] dateString = cowDateOfBirth.getText().split("/");
                    date.set(Integer.parseInt(dateString[2]), Integer.parseInt(dateString[1]), Integer.parseInt(dateString[0]));

                    int purchasedSelect = cowPurchased.getSelectedIndex();
                    boolean purchased = false;
                    if (purchasedSelect == 1) {
                        purchased = true;
                    } else {
                        purchased = false;
                    }
                    int weight = Integer.parseInt(cowWeight.getText());
                    HashMap<String, Double> milking = new HashMap<>();
                    ArrayList<Treatment> treatments = new ArrayList<Treatment>();
                    Cow cow = new Cow(tagNo, gender, date, purchased, milking, treatments, weight);
                    FarmApp.animals.add(cow);
                    JOptionPane.showMessageDialog(addCow, "Cow Successfully Added");
                    // adds cow into a database
                    storage.insertValuesAnimal(cow);
                }else{
                    JOptionPane.showMessageDialog(addCow,"There is an animal with this tag");
                }

            }
        });

        listCowsButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    listCowPanel.remove(scrollPaneCow);
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
                hideAllPanels();
                listCowPanel.setVisible(true);
                listCows();

            }
        });
        addSheepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                addSheepPanel.setVisible(true);
            }
        });
        addSheep.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int flag = 1;
                for (int i=0; i < FarmApp.animals.size();i++){

                    if (FarmApp.animals.get(i).getTagNo() == Integer.parseInt(sheepTagNumber.getText())){
                        // flag for if a given tag number is already exist, it doesn't do add operation.
                        flag = 0;
                    }
                }if (flag == 1){
                    Calendar date = Calendar.getInstance();
                    int tagNo = Integer.parseInt(sheepTagNumber.getText());
                    int genderSelect = genderSheep.getSelectedIndex();
                    String gender = "";
                    if (genderSelect == 1){
                        gender = "Male";
                    }else{
                        gender = "Female";
                    }
                    String[] dateString = dateOfBirthSheep.getText().split("/");
                    date.set(Integer.parseInt(dateString[2]),Integer.parseInt(dateString[1]),Integer.parseInt(dateString[0]));

                    int purchasedSelect = purchasedSheep.getSelectedIndex();
                    boolean purchased = false;
                    if (purchasedSelect == 1){
                        purchased = true;
                    }else{
                        purchased = false;
                    }
                    HashMap<String,Double> milking = new HashMap<>();
                    ArrayList<Treatment> treatments = new ArrayList<Treatment>();
                    Sheep sheep = new Sheep(tagNo,gender,date,purchased,milking,treatments);
                    FarmApp.animals.add(sheep);
                    // adds sheep into a database
                    storage.insertValuesAnimal(sheep);
                    JOptionPane.showMessageDialog(addSheep, "Sheep Successfully Added");
                }else{
                    JOptionPane.showMessageDialog(addSheep,"There is an animal with this tag");
                }

            }
        });

        deleteCowButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                deletePanel.setVisible(true);
            }
        });
        deleteCow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i,flag = 1;

                for (i = 0; i < FarmApp.animals.size(); i++){

                    if (FarmApp.animals.get(i).getTagNo() == Integer.parseInt(deleteCowText.getText()) && FarmApp.animals.get(i) instanceof Cow){

                        FarmApp.animals.remove(i);
                        // deletes cow with given tag number from database
                        storage.deleteAnimal(Integer.parseInt(deleteCowText.getText()));
                        JOptionPane.showMessageDialog(deleteCow,"The cow with the "+ deleteCowText.getText() +" tag number has been deleted");
                        // flag for if a given tag number doesn't exist, it doesn't do delete operation.
                        flag = 0;
                    }
                }
                if (flag == 1){

                    JOptionPane.showMessageDialog(deleteCow,"There is no cow with this given tag number");
                }
            }
        });
        cowDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                getCowDetails.setVisible(true);
                textCowPanel.setVisible(false);
            }
        });
        CowDetailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textCowPanel.setVisible(true);
                String setCowText = "";
                int i,flag = 1;
                for (i = 0; i < FarmApp.animals.size(); i++)
                {

                    if (FarmApp.animals.get(i).getTagNo() == Integer.parseInt(cowDetailsText.getText()) && FarmApp.animals.get(i) instanceof Cow)
                    {
                        try {
                            Cow cow = (Cow) FarmApp.animals.get(i);
                            setCowText += "Tag Number: "+cow.getTagNo()+"\n";
                            setCowText += "Gender: "+cow.getGender()+"\n";

                            setCowText += "Date Of Birth: "+cow.getDateOfBirth().get(Calendar.DATE) + "/" + cow.getDateOfBirth().get(Calendar.MONTH) + "/" + cow.getDateOfBirth().get(Calendar.YEAR)+"\n";

                            if (FarmApp.animals.get(i).isPurchased() == true) {

                                setCowText += "Purchased: Yes" + "\n";
                            } else {

                                setCowText += "Purchased: No" + "\n";
                            }
                            setCowText += "Weight: "+ cow.getWeight() + "\n";
                            if (cow.getMilking().keySet().size() >= 1){
                                setCowText += "Milking: \n";

                                for (Object key: cow.getMilking().keySet()){
                                    setCowText += "Milking Date: "+ key+" Amount: "+cow.getMilking().get(key)+"\n";
                                }
                            }

                            flag = 0;
                        }catch (Exception exception){
                            if (exception instanceof ClassCastException){
                                System.out.println("Class exception !!");
                            }
                        }
                    }
                }
                if (flag == 1){
                    textCowPanel.setVisible(false);
                    JOptionPane.showMessageDialog(cowDetailsButton,"There is no record for this tag");
                }else{
                    cowDetailsTagNo.setText(setCowText);
                }

            }
        });
        addVetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                addVetPanel.setVisible(true);
            }
        });
        addVet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i,flag = 1;
                Calendar calendar = Calendar.getInstance();
                Calendar graduation = Calendar.getInstance();
                for (i=0; i < FarmApp.employees.size();i++){

                    if (FarmApp.employees.get(i).getEmpID() == Integer.parseInt(vetIdText.getText())){
                        // flag for if a given vet id is already exist, it doesn't do add operation.
                        flag = 0;
                    }
                }
                if (flag == 1)
                {
                    Veterinary vet = new Veterinary();
                    vet.setEmpID(Integer.parseInt(vetIdText.getText()));
                    //buffer
                    int index = vetGenderBox.getSelectedIndex();
                    if (index == 1){
                        vet.setGender("Male");
                    }else{
                        vet.setGender("Female");
                    }


                    String[] dateString = vetDateText.getText().split("/");

                    calendar.set(Integer.parseInt(dateString[2]),Integer.parseInt(dateString[1]),Integer.parseInt(dateString[0]));
                    vet.setDateOfBirth(calendar);

                    index = vetDegreeBox.getSelectedIndex();

                    if(index == 1){
                        vet.setBScDegree(true);
                    }else{
                        vet.setBScDegree(false);
                    }


                    dateString = graduationVetText.getText().split("/");

                    graduation.set(Integer.parseInt(dateString[2]),Integer.parseInt(dateString[1]),Integer.parseInt(dateString[0]));
                    vet.setDateOfGraduation(graduation);


                    vet.setExpertiseLevel(Integer.parseInt(expertiseLevelVetText.getText()));
                    //add veterinary into a database
                    storage.insertValuesEmployee(vet);
                    FarmApp.employees.add(vet);
                    JOptionPane.showMessageDialog(addVet,"Veterinary Successfully Added");
                }else{

                    JOptionPane.showMessageDialog(addVet,"There is an employee with this id");
                }
            }
        });
        listVetsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    listVetsPanel.remove(scrollPaneVet);
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
                hideAllPanels();
                listVetsPanel.setVisible(true);
                listVets();
            }
        });
        addFarmWorkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                addFarmWorkerPanel.setVisible(true);
            }
        });
        addFarmWorker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i,id,flag = 1;

                Calendar calendar = Calendar.getInstance();
                String dateString[];
                String date;

                for (i=0; i < FarmApp.employees.size();i++){

                    if (FarmApp.employees.get(i).getEmpID() == Integer.parseInt(farmWorkerIdText.getText())){
                        // flag for if a given vet id is already exist, it doesn't do add operation.
                        flag = 0;
                    }
                }
                if (flag == 1)
                {
                    FarmWorker farmWorker = new FarmWorker();
                    farmWorker.setEmpID(Integer.parseInt(farmWorkerIdText.getText()));
                    int index = workerGenderBox.getSelectedIndex();
                    if (index == 1){
                        farmWorker.setGender("Male");
                    }else {
                        farmWorker.setGender("Female");
                    }

                    dateString = dateWorkerText.getText().split("/");

                    calendar.set(Integer.parseInt(dateString[2]),Integer.parseInt(dateString[1]),Integer.parseInt(dateString[0]));
                    farmWorker.setDateOfBirth(calendar);

                    farmWorker.setPreviousFarmName(prevFarmNameText.getText());

                    farmWorker.setWorkexperience(Integer.parseInt(experienceWorkerText.getText()));
                    JOptionPane.showMessageDialog(addFarmWorker,"Farm Worker Successfully Added");
                    //add farm worker into a database
                    storage.insertValuesEmployee(farmWorker);
                    FarmApp.employees.add(farmWorker);
                }else{
                    JOptionPane.showMessageDialog(addFarmWorker,"There is a employee with this given id");
                }
            }
        });
        deleteVetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                deleteVetPanel.setVisible(true);
            }
        });
        deleteVet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i,flag = 1;

                for (i = 0; i < FarmApp.employees.size(); i++){

                    if (FarmApp.employees.get(i).getEmpID() == Integer.parseInt(deleteVetText.getText()) && FarmApp.employees.get(i) instanceof Veterinary){

                        FarmApp.employees.remove(i);
                        storage.deleteEmployee(Integer.parseInt(deleteVetText.getText()));
                        JOptionPane.showMessageDialog(deleteVet,"Veterinary with the "+ deleteVetText.getText() +" ID has been deleted");
                        // flag for if a given tag number doesn't exist, it doesn't do delete operation.
                        flag = 0;
                    }
                }
                if (flag == 1){

                    JOptionPane.showMessageDialog(deleteVet,"There is no Veterinary with this given ID");
                }
            }
        });
        vetDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                vetDetailsPanel.setVisible(true);
                textVetDetails.setVisible(false);
            }
        });
        vetDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                textVetDetails.setVisible(true);
                String setVetText = "";
                int i,flag = 1;
                for (i = 0; i < FarmApp.employees.size(); i++)
                {

                    if (FarmApp.employees.get(i).getEmpID() == Integer.parseInt(vetDetailsIDText.getText()) && FarmApp.employees.get(i) instanceof Veterinary)
                    {
                        try {
                            Veterinary vet = (Veterinary) FarmApp.employees.get(i);
                            setVetText += "Veterinary ID: "+vet.getEmpID()+"\n";
                            setVetText += "Gender: "+vet.getGender()+"\n";

                            setVetText += "Date Of Birth: "+vet.getDateOfBirth().get(Calendar.DATE) + "/" + vet.getDateOfBirth().get(Calendar.MONTH) + "/" + vet.getDateOfBirth().get(Calendar.YEAR)+"\n";

                            if (((Veterinary) FarmApp.employees.get(i)).isBScDegree() == true) {

                                setVetText += "BScDegree: Yes" + "\n";
                            } else {

                                setVetText += "BScDegree: No" + "\n";
                            }
                            setVetText += "Graduation Date: "+vet.getDateOfGraduation().get(Calendar.DATE) + "/" + vet.getDateOfBirth().get(Calendar.MONTH) + "/" + vet.getDateOfBirth().get(Calendar.YEAR)+"\n";

                            setVetText += "Expertise Level: "+ vet.getExpertiseLevel() + "\n";

                            flag = 0;
                        }catch (Exception exception){
                            if (exception instanceof ClassCastException){
                                System.out.println("Class exception !!");
                            }
                        }
                    }
                }
                if (flag == 1){
                    textVetDetails.setVisible(false);
                    JOptionPane.showMessageDialog(vetDetails,"There is no record for this employee ID");
                }else{
                    vetIDText.setText(setVetText);
                }

            }
        });
        addTreatmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                addTreatmentPanel.setVisible(true);
            }
        });
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();

                int i, flagCow = 0, flagVet = 0;
                Calendar calendar = Calendar.getInstance();
                String dateString[];


                int typeOfMedication = medicationType.getSelectedIndex();

                for (i=0; i < FarmApp.animals.size();i++) {

                    if (FarmApp.animals.get(i).getTagNo() == Integer.parseInt(tagNoTreatment.getText()) && FarmApp.animals.get(i) instanceof Cow) {
                        // if there is a tag number given for cow, it will save as flagCow = 1.
                        flagCow = 1;
                    }
                }
                for (i=0; i < FarmApp.employees.size();i++) {

                    if (typeOfMedication == 1)
                    {
                        if (FarmApp.employees.get(i).getEmpID() == Integer.parseInt(vetIdTreatment.getText()) && FarmApp.employees.get(i) instanceof FarmWorker) {
                            // if there is a tag number given for cow, it will save as flagCow = 1.
                            flagVet = 1;
                        }

                    } else if (typeOfMedication == 2)
                    {
                        if (FarmApp.employees.get(i).getEmpID() == Integer.parseInt(vetIdTreatment.getText()) && FarmApp.employees.get(i) instanceof Veterinary) {
                            // if there is a tag number given for cow, it will save as flagCow = 1.
                            flagVet = 1;
                        }
                    }


                }
                if (flagCow == 1 && flagVet == 1){
                    if (typeOfMedication == 1){
                        cleaningPanel.setVisible(true);
                    }else{
                        healthTreatmentPanel.setVisible(true);
                    }
                }else{
                    addTreatmentPanel.setVisible(true);
                    if (flagCow == 0){
                        JOptionPane.showMessageDialog(proceedButton,"There is no animal with this given tag number");
                    }else{
                        if (typeOfMedication == 1){
                            JOptionPane.showMessageDialog(proceedButton,"There is no employee for Cleaning treatment");
                        }else if (typeOfMedication == 2){
                            JOptionPane.showMessageDialog(proceedButton,"There is no employee for Health treatment");
                        }
                    }
                }


            }
        });
        addCleaningTreatmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int recordAnimal=0,recordEmployee = 0;
                Calendar calendar = Calendar.getInstance();
                String[] dateString = cleaningDateText.getText().split("/");
                CleaningTreatment treatment = new CleaningTreatment();

                calendar.set(Integer.parseInt(dateString[2]),Integer.parseInt(dateString[1]),Integer.parseInt(dateString[0]));
                treatment.setDateOFTreatment(calendar);

                treatment.setMaterialsused(cleaningMaterialText.getText());

                for (int i=0; i < FarmApp.employees.size();i++) {
                    if (FarmApp.employees.get(i).getEmpID() == Integer.parseInt(vetIdTreatment.getText()) && FarmApp.employees.get(i) instanceof FarmWorker) {
                        // records the tag number of the cow that treatment is to be added.
                        recordEmployee = i;
                    }
                }

                try{
                    FarmWorker farmWorker = (FarmWorker) FarmApp.employees.get(recordEmployee);
                    treatment.setFarmWorker(farmWorker);
                }catch (Exception exception){
                    if (exception instanceof ClassCastException){
                        System.out.println("Class exception !!");
                    }
                }
                for (int i=0; i < FarmApp.animals.size();i++) {

                    if (FarmApp.animals.get(i).getTagNo() == Integer.parseInt(tagNoTreatment.getText()) && FarmApp.animals.get(i) instanceof Cow) {
                        // if there is a tag number given for cow, it will save as flagCow = 1.
                        recordAnimal = i;
                    }
                }
                FarmApp.animals.get(recordAnimal).getTreatment().add(treatment);
                JOptionPane.showMessageDialog(addCleaningTreatmentButton,"Cleaning Treatment Successfully added");
            }
        });
        addHealthTreatmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int recordAnimal = 0,recordEmployee = 0;
                Calendar calendar = Calendar.getInstance();
                Calendar medDate = Calendar.getInstance();
                String[] dateString = healthDateText.getText().split("/");
                String[] medicationString = healthMedDateText.getText().split("/");
                HealthTreatment treatment = new HealthTreatment();

                calendar.set(Integer.parseInt(dateString[2]),Integer.parseInt(dateString[1]),Integer.parseInt(dateString[0]));
                treatment.setDateOFTreatment(calendar);

                int index = healthEmBox.getSelectedIndex();
                if (index == 1){
                    treatment.setEmergency(true);
                }else{
                    treatment.setEmergency(false);
                }
                medDate.set(Integer.parseInt(medicationString[2]),Integer.parseInt(medicationString[1]),Integer.parseInt(medicationString[0]));

                Medication medication = new Medication(healthMedText.getText(),Integer.parseInt(healthDurText.getText()),medDate,Integer.parseInt(healthDosText.getText()),healthMedNotesText.getText());
                treatment.getMedications().add(medication);

                for (int i=0; i < FarmApp.employees.size();i++) {
                    if (FarmApp.employees.get(i).getEmpID() == Integer.parseInt(vetIdTreatment.getText()) && FarmApp.employees.get(i) instanceof Veterinary) {
                        // records the tag number of the cow that treatment is to be added.
                        recordEmployee = i;
                    }
                }
                
                try{
                    Veterinary vet = (Veterinary) FarmApp.employees.get(recordEmployee);
                    treatment.setVeterinary(vet);
                }catch (Exception exception){
                    if (exception instanceof ClassCastException){
                        System.out.println("Class exception !!");
                    }
                }

                for (int i=0; i < FarmApp.animals.size();i++) {

                    if (FarmApp.animals.get(i).getTagNo() == Integer.parseInt(tagNoTreatment.getText()) && FarmApp.animals.get(i) instanceof Cow) {
                        // if there is a tag number given for cow, it will save as flagCow = 1.
                        recordAnimal = i;
                    }
                }
                FarmApp.animals.get(recordAnimal).getTreatment().add(treatment);
                JOptionPane.showMessageDialog(addHealthTreatmentButton,"Health Treatment Successfully added");
            }

        });
        cowTreatmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                getCowTreatment.setVisible(true);

            }
        });
        treatmentDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cowTreatmentPanel.setVisible(true);
                int tagNo = Integer.parseInt(treatmentDetailsEntered.getText());
                String treatmentsDetailsText = "";
                int i,j,k,flag = 1;

                // visits the animal objects and if it finds a cow with the entered tag number,
                // it visits the cow's treatments and displays treatment details.
                // According to treatment type it displays farmWorker or veterinary,medications.
                for (i=0; i < FarmApp.animals.size();i++){

                    if (FarmApp.animals.get(i).getTagNo() == tagNo && FarmApp.animals.get(i) instanceof Cow) {

                        for (j=0; j < FarmApp.animals.get(i).getTreatment().size(); j++) {
                            try {
                                Cow cow = (Cow) FarmApp.animals.get(i);
                                treatmentsDetailsText += "Treatment " + (j + 1) + "\n";

                                treatmentsDetailsText += "Date of treatment: ";
                                treatmentsDetailsText += cow.getTreatment().get(j).getDateOFTreatment().get(Calendar.DATE) + "/" + cow.getTreatment().get(j).getDateOFTreatment().get(Calendar.MONTH) + "/" + cow.getTreatment().get(j).getDateOFTreatment().get(Calendar.YEAR)+"\n";
                                if (cow.getTreatment().get(j) instanceof HealthTreatment) {

                                    HealthTreatment treatment = (HealthTreatment) cow.getTreatment().get(j);
                                    treatmentsDetailsText += "Health treatment:" + "\n";
                                    boolean isUrgent = treatment.isEmergency();

                                    if (isUrgent == true) {
                                        treatmentsDetailsText += "Emergency: Yes" + "\n";
                                    } else {
                                        treatmentsDetailsText += "Emergency: No"+ "\n";
                                    }
                                    // Vet information
                                    Veterinary veterinary = (Veterinary) treatment.getVeterinary();

                                    treatmentsDetailsText +=  "Veterinary ID: " + veterinary.getEmpID() + "\n";
                                    treatmentsDetailsText += "Veterinary gender: " + veterinary.getGender() + "\n";
                                    treatmentsDetailsText += "Veterinary date of birth: ";
                                    treatmentsDetailsText += veterinary.getDateOfBirth().get(Calendar.DATE) + "/" + veterinary.getDateOfBirth().get(Calendar.MONTH) + "/" + veterinary.getDateOfBirth().get(Calendar.YEAR)+"\n";
                                    treatmentsDetailsText += "Veterinary salary: " + veterinary.getSalary()+"\n";

                                    if (veterinary.isBScDegree() == true) {
                                        treatmentsDetailsText += "Veterinary has a BScDegree: Yes"+"\n";
                                    } else {
                                        treatmentsDetailsText += "Veterinary has a BScDegree: No"+"\n";
                                    }
                                    treatmentsDetailsText += "Veterinary graduation date: ";
                                    treatmentsDetailsText += veterinary.getDateOfGraduation().get(Calendar.DATE) + "/" + veterinary.getDateOfGraduation().get(Calendar.MONTH) + "/" + veterinary.getDateOfGraduation().get(Calendar.YEAR) + "\n";

                                    treatmentsDetailsText += "Veterinary expertise level: " + veterinary.getExpertiseLevel()+"\n";

                                    //medication details
                                    for (k = 0; k < treatment.getMedications().size(); k++) {

                                        treatmentsDetailsText += "====================="+"\n";
                                        treatmentsDetailsText += "Medication: " + (k + 1)+"\n";
                                        treatmentsDetailsText += "Details: " + treatment.getMedications().get(k).getDetails()+"\n";
                                        treatmentsDetailsText += "Duration: " + treatment.getMedications().get(k).getDuration()+"\n";
                                        treatmentsDetailsText += "Start Date: ";
                                        treatmentsDetailsText += treatment.getMedications().get(k).getStartDate().get(Calendar.DATE) + "/" + treatment.getMedications().get(k).getStartDate().get(Calendar.MONTH) + "/" + treatment.getMedications().get(k).getStartDate().get(Calendar.YEAR)+"\n";
                                        treatmentsDetailsText += "Dosage: " + treatment.getMedications().get(k).getDosage() + "\n";
                                        treatmentsDetailsText += "Notes: " + treatment.getMedications().get(k).getNotes() + "\n";
                                    }

                                } else if (cow.getTreatment().get(j) instanceof CleaningTreatment) {

                                    CleaningTreatment treatment = (CleaningTreatment) cow.getTreatment().get(j);

                                    treatmentsDetailsText += "Cleaning treatment:"+"\n";
                                    treatmentsDetailsText += "Materialsused: " + treatment.getMaterialsused() + "\n";
                                    treatmentsDetailsText += "=====================" + "\n";
                                    treatmentsDetailsText += "Farm worker information:" + "\n";
                                    //get vet details bak
                                    treatmentsDetailsText += "Farm worker ID: " + treatment.getFarmWorker().getEmpID() + "\n";
                                    treatmentsDetailsText +="Gender: " + treatment.getFarmWorker().getGender() + "\n";
                                    treatmentsDetailsText +="Salary: " + treatment.getFarmWorker().getSalary() + "\n";
                                    treatmentsDetailsText +="Date of birth: ";
                                    treatmentsDetailsText +=treatment.getFarmWorker().getDateOfBirth().get(Calendar.DATE) + "/" + treatment.getFarmWorker().getDateOfBirth().get(Calendar.MONTH) + "/" + treatment.getFarmWorker().getDateOfBirth().get(Calendar.YEAR) + "\n";
                                    treatmentsDetailsText +="Previous farm name: " + treatment.getFarmWorker().getPreviousFarmName() + "\n";
                                    treatmentsDetailsText +="Work experience: " + treatment.getFarmWorker().getWorkexperience() + "\n";
                                }
                            } catch (Exception exception) {
                                if (exception instanceof ClassCastException) {
                                    System.out.println("Class exception !!");
                                }
                            }
                            // if it finds a cow has to the entered tag number, sets flag = 0.
                            flag = 0;
                            treatmentsDetailsText += "-------------------------------------\n";
                        }
                    }
                }
                if (flag == 1){
                    cowTreatmentPanel.setVisible(false);
                    JOptionPane.showMessageDialog(treatmentDetailsButton,"There is no cow with this tag");

                }else{
                    cowTreatmentText.setText(treatmentsDetailsText);

                }
            }
        });
        cowTreatmentWithDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                getCowTreatmentDate.setVisible(true);

            }
        });

        TreatmentDetailsDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cowTreatmentDatePanel.setVisible(true);
                int tagNo = Integer.parseInt(treatmentDateTagNo.getText());
                Calendar dateOfTreatment = Calendar.getInstance();
                String[] date = treatmentDate.getText().split("/");
                dateOfTreatment.set(Integer.parseInt(date[2]),Integer.parseInt(date[1]),Integer.parseInt(date[0]));
                Calendar calendar;
                String treatmentsDetailsText = "";
                int i,j,k,flag = 1;

                for (i=0; i < FarmApp.animals.size();i++){

                    if (FarmApp.animals.get(i).getTagNo() == tagNo && FarmApp.animals.get(i) instanceof Cow) {

                        for (j=0; j < FarmApp.animals.get(i).getTreatment().size(); j++)
                        {
                            calendar = FarmApp.animals.get(i).getTreatment().get(j).getDateOFTreatment();

                            if (calendar.get(Calendar.DATE) == dateOfTreatment.get(Calendar.DATE) && calendar.get(Calendar.MONTH) == dateOfTreatment.get(Calendar.MONTH) && calendar.get(Calendar.YEAR) == dateOfTreatment.get(Calendar.YEAR))
                            {

                                try {
                                    Cow cow = (Cow) FarmApp.animals.get(i);
                                    treatmentsDetailsText += "Treatment " + (j + 1) + "\n";

                                    treatmentsDetailsText += "Date of treatment: ";
                                    treatmentsDetailsText += cow.getTreatment().get(j).getDateOFTreatment().get(Calendar.DATE) + "/" + cow.getTreatment().get(j).getDateOFTreatment().get(Calendar.MONTH) + "/" + cow.getTreatment().get(j).getDateOFTreatment().get(Calendar.YEAR) + "\n";
                                    if (cow.getTreatment().get(j) instanceof HealthTreatment) {

                                        HealthTreatment treatment = (HealthTreatment) cow.getTreatment().get(j);
                                        treatmentsDetailsText += "Health treatment:" + "\n";
                                        boolean isUrgent = treatment.isEmergency();

                                        if (isUrgent == true) {
                                            treatmentsDetailsText += "Emergency: Yes" + "\n";
                                        } else {
                                            treatmentsDetailsText += "Emergency: No" + "\n";
                                        }
                                        // Vet information
                                        Veterinary veterinary = (Veterinary) FarmApp.employees.get(i);

                                        treatmentsDetailsText += "Veterinary ID: " + veterinary.getEmpID() + "\n";
                                        treatmentsDetailsText += "Veterinary gender: " + veterinary.getGender() + "\n";
                                        treatmentsDetailsText += "Veterinary date of birth: ";
                                        treatmentsDetailsText += veterinary.getDateOfBirth().get(Calendar.DATE) + "/" + veterinary.getDateOfBirth().get(Calendar.MONTH) + "/" + veterinary.getDateOfBirth().get(Calendar.YEAR) + "\n";
                                        treatmentsDetailsText += "Veterinary salary: " + veterinary.getSalary() + "\n";

                                        if (veterinary.isBScDegree() == true) {
                                            treatmentsDetailsText += "Veterinary has a BScDegree: Yes" + "\n";
                                        } else {
                                            treatmentsDetailsText += "Veterinary has a BScDegree: No" + "\n";
                                        }
                                        treatmentsDetailsText += "Veterinary graduation date: ";
                                        treatmentsDetailsText += veterinary.getDateOfGraduation().get(Calendar.DATE) + "/" + veterinary.getDateOfGraduation().get(Calendar.MONTH) + "/" + veterinary.getDateOfGraduation().get(Calendar.YEAR) + "\n";

                                        treatmentsDetailsText += "Veterinary expertise level: " + veterinary.getExpertiseLevel() + "\n";

                                        //medication details
                                        for (k = 0; k < treatment.getMedications().size(); k++) {

                                            treatmentsDetailsText += "=====================" + "\n";
                                            treatmentsDetailsText += "Medication: " + (k + 1) + "\n";
                                            treatmentsDetailsText += "Details: " + treatment.getMedications().get(k).getDetails() + "\n";
                                            treatmentsDetailsText += "Duration: " + treatment.getMedications().get(k).getDuration() + "\n";
                                            treatmentsDetailsText += "Start Date: ";
                                            treatmentsDetailsText += treatment.getMedications().get(k).getStartDate().get(Calendar.DATE) + "/" + treatment.getMedications().get(k).getStartDate().get(Calendar.MONTH) + "/" + treatment.getMedications().get(k).getStartDate().get(Calendar.YEAR) + "\n";
                                            treatmentsDetailsText += "Dosage: " + treatment.getMedications().get(k).getDosage() + "\n";
                                            treatmentsDetailsText += "Notes: " + treatment.getMedications().get(k).getNotes() + "\n";
                                        }

                                    } else if (cow.getTreatment().get(j) instanceof CleaningTreatment) {

                                        CleaningTreatment treatment = (CleaningTreatment) cow.getTreatment().get(j);

                                        treatmentsDetailsText += "Cleaning treatment:" + "\n";
                                        treatmentsDetailsText += "Materialsused: " + treatment.getMaterialsused() + "\n";
                                        treatmentsDetailsText += "=====================" + "\n";
                                        treatmentsDetailsText += "Farm worker information:" + "\n";
                                        treatmentsDetailsText += "Farm worker ID: " + treatment.getFarmWorker().getEmpID() + "\n";
                                        treatmentsDetailsText += "Gender: " + treatment.getFarmWorker().getGender() + "\n";
                                        treatmentsDetailsText += "Salary: " + treatment.getFarmWorker().getSalary() + "\n";
                                        treatmentsDetailsText += "Date of birth: ";
                                        treatmentsDetailsText += treatment.getFarmWorker().getDateOfBirth().get(Calendar.DATE) + "/" + treatment.getFarmWorker().getDateOfBirth().get(Calendar.MONTH) + "/" + treatment.getFarmWorker().getDateOfBirth().get(Calendar.YEAR) + "\n";
                                        treatmentsDetailsText += "Previous farm name: " + treatment.getFarmWorker().getPreviousFarmName() + "\n";
                                        treatmentsDetailsText += "Work experience: " + treatment.getFarmWorker().getWorkexperience() + "\n";
                                    }
                                } catch (Exception exception) {
                                    if (exception instanceof ClassCastException) {
                                        System.out.println("Class exception !!");
                                    }
                                }
                                // if it finds a cow has to the entered tag number, sets flag = 0.
                                flag = 0;
                                treatmentsDetailsText += "-------------------------------------\n";
                            }
                        }
                    }
                }
                if (flag == 1){
                    cowTreatmentDatePanel.setVisible(false);
                    JOptionPane.showMessageDialog(TreatmentDetailsDate, "There is no cow with this tag or given particular date");
                }else{
                    cowTreatmentDateText.setText(treatmentsDetailsText);
                }
            }
        });
        feedingAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                feedingAnimalPanel.setVisible(true);
            }
        });
        feedingAnimalsDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i,flag = 0;
                String feedingMessage = "";
                for (i=0; i < FarmApp.animals.size();i++)
                {
                    if (FarmApp.animals.get(i).getTagNo() == Integer.parseInt(feedingTagNoText.getText()) && FarmApp.animals.get(i) instanceof Cow)
                    {
                        try{
                            Cow cow = (Cow) FarmApp.animals.get(i);
                            feedingMessage = cow.feeding();
                            flag = 1;
                        } catch (Exception exception) {
                            if (exception instanceof ClassCastException) {
                                System.out.println("Class exception !!");
                            }
                        }
                    }else if(FarmApp.animals.get(i).getTagNo() == Integer.parseInt(feedingTagNoText.getText()) && FarmApp.animals.get(i) instanceof Sheep){
                        try {
                            Sheep sheep = (Sheep) FarmApp.animals.get(i);
                            feedingMessage = sheep.feeding();
                            flag = 1;
                        } catch (Exception exception) {
                            if (exception instanceof ClassCastException) {
                                System.out.println("Class exception !!");
                            }
                        }
                    }
                }
                if (flag == 1){
                    JOptionPane.showMessageDialog(feedingAnimalsDetailsButton,feedingMessage);
                }else{
                    JOptionPane.showMessageDialog(feedingAnimalsDetailsButton,"Animal not found with this given tag number");
                }

            }
        });
        employeeSalaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                employeePanel.setVisible(true);
            }
        });
        employeeSalaryDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int empID = Integer.parseInt(employeeSalText.getText());
                int i,flag = 1,recordEmp=0;

                for (i=0; i < FarmApp.employees.size();i++){
                    if (FarmApp.employees.get(i).getEmpID() == empID){
                        flag = 0;
                        recordEmp = i;
                    }
                }
                // -1 means there is no employee with this id
                if (flag == 1){
                    JOptionPane.showMessageDialog(employeeSalaryDetailsButton,"There is no employee with this id");
                }else{
                    JOptionPane.showMessageDialog(employeeSalaryDetailsButton,"Employee salary is "+FarmApp.employees.get(recordEmp).getSalary());
                }
            }
        });
        addMilkingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                milkingPanel.setVisible(true);
            }
        });
        addMilkingButton1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                int i,recordAnimal = 0,flag = 1;
                for(i=0; i < FarmApp.animals.size();i++){
                    if (FarmApp.animals.get(i).getTagNo() == Integer.parseInt(milkingTextTag.getText())){
                        recordAnimal = i;
                        flag = 0;//0 means find the animal
                    }
                }
                if (flag == 0){
                    int flagDate = 1;
                    HashMap<String, Double> milking = new HashMap<String, Double>();
                    String currentDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    for (i=0; i < FarmApp.animals.get(recordAnimal).getMilking().size();i++)
                    {
                        //if there is a record same date, gives the error message.
                        if (FarmApp.animals.get(recordAnimal).getMilking().containsKey(currentDate))
                        {
                            JOptionPane.showMessageDialog(addMilkingButton1,"Previously given milk on this date !!");
                            flagDate = 0;
                        }
                    }
                    //if there is no record same date, add the amount to given date.
                    if (flagDate == 1){
                        JOptionPane.showMessageDialog(addMilkingButton1,"Milking Amount "+ Double.valueOf(milkingAmountText.getText())+" Successfully Added");
                        FarmApp.animals.get(recordAnimal).getMilking().put(currentDate, Double.valueOf(milkingAmountText.getText()));
                    }

                }else{
                    JOptionPane.showMessageDialog(addMilkingButton1,"There is no animal with this tag number");
                }
            }
        });

        deleteSheepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                deleteSheepPanel.setVisible(true);
            }
        });
        deleteSheepButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i,flag = 1;

                for (i = 0; i < FarmApp.animals.size(); i++){

                    if (FarmApp.animals.get(i).getTagNo() == Integer.parseInt(deleteTextSheep.getText()) && FarmApp.animals.get(i) instanceof Sheep){

                        FarmApp.animals.remove(i);
                        // deletes sheep with given tag number from database.
                        storage.deleteAnimal(Integer.parseInt(deleteTextSheep.getText()));
                        JOptionPane.showMessageDialog(deleteSheepButton1,"The sheep with the "+ deleteTextSheep.getText() +" tag number has been deleted");
                        // flag for if a given tag number doesn't exist, it doesn't do delete operation.
                        flag = 0;
                    }
                }
                if (flag == 1){

                    JOptionPane.showMessageDialog(deleteSheepButton1,"There is no cow with this given tag number");
                }

            }
        });
        sheepDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                getSheepDetails.setVisible(true);
                sheepTextPanel.setVisible(false);
            }
        });
        sheepDetailsButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sheepTextPanel.setVisible(true);
                String setSheepText = "";
                int i,flag = 1;
                for (i = 0; i < FarmApp.animals.size(); i++)
                {

                    if (FarmApp.animals.get(i).getTagNo() == Integer.parseInt(sheepTagNoDetails.getText()) && FarmApp.animals.get(i) instanceof Sheep)
                    {
                        try {
                            Sheep sheep = (Sheep) FarmApp.animals.get(i);
                            setSheepText += "Tag Number: "+sheep.getTagNo()+"\n";
                            setSheepText += "Gender: "+sheep.getGender()+"\n";

                            setSheepText += "Date Of Birth: "+sheep.getDateOfBirth().get(Calendar.DATE) + "/" + sheep.getDateOfBirth().get(Calendar.MONTH) + "/" + sheep.getDateOfBirth().get(Calendar.YEAR)+"\n";

                            if (FarmApp.animals.get(i).isPurchased() == true) {

                                setSheepText += "Purchased: Yes" + "\n";
                            } else {

                                setSheepText += "Purchased: No" + "\n";
                            }

                            if (sheep.getMilking().keySet().size() >= 1){
                                setSheepText += "Milking: \n";

                                for (Object key: sheep.getMilking().keySet()){
                                    setSheepText += "Milking Date: "+ key+" Amount: "+sheep.getMilking().get(key)+"\n";
                                }
                            }

                            flag = 0;
                        }catch (Exception exception){
                            if (exception instanceof ClassCastException){
                                System.out.println("Class exception !!");
                            }
                        }
                    }
                }
                if (flag == 1){
                    sheepTextPanel.setVisible(false);
                    JOptionPane.showMessageDialog(sheepDetailsButton1,"There is no record for this tag");
                }else{
                    sheepDetailsTagNo.setText(setSheepText);
                }

            }

        });
        deleteFarmWorkerButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                deleteFarmWorker.setVisible(true);
            }
        });
        deleteFarmWorkerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int i,flag = 1;

                for (i = 0; i < FarmApp.employees.size(); i++){

                    if (FarmApp.employees.get(i).getEmpID() == Integer.parseInt(deleteFArmWorkerText.getText()) && FarmApp.employees.get(i) instanceof FarmWorker){

                        FarmApp.employees.remove(i);
                        storage.deleteEmployee(Integer.parseInt(deleteFArmWorkerText.getText()));
                        JOptionPane.showMessageDialog(deleteFarmWorkerButton,"Farm Worker with the "+ deleteFArmWorkerText.getText() +" ID has been deleted");
                        // flag for if a given tag number doesn't exist, it doesn't do delete operation.
                        flag = 0;
                    }
                }
                if (flag == 1){

                    JOptionPane.showMessageDialog(deleteFarmWorkerButton,"There is no Veterinary with this given ID");
                }
            }

        });
        farmWorkerDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hideAllPanels();
                farmWorkerDetailsPanel.setVisible(true);
                farmWorkerAreaPanel.setVisible(false);
            }
        });
        farmWorkerDetailsButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                farmWorkerAreaPanel.setVisible(true);
                String setFarmText = "";
                int i,flag = 1;
                for (i = 0; i < FarmApp.employees.size(); i++)
                {

                    if (FarmApp.employees.get(i).getEmpID() == Integer.parseInt(farmWorkerIDarea.getText()) && FarmApp.employees.get(i) instanceof FarmWorker)
                    {
                        try {
                            FarmWorker farmWorker = (FarmWorker) FarmApp.employees.get(i);
                            setFarmText += "Farm Worker ID: "+ farmWorker.getEmpID()+"\n";
                            setFarmText += "Gender: "+ farmWorker.getGender()+"\n";

                            setFarmText += "Date Of Birth: "+ farmWorker.getDateOfBirth().get(Calendar.DATE) + "/" + farmWorker.getDateOfBirth().get(Calendar.MONTH) + "/" + farmWorker.getDateOfBirth().get(Calendar.YEAR)+"\n";

                            setFarmText += "Previous farm name: "+ farmWorker.getPreviousFarmName()+"\n";

                            setFarmText += "Work experience: "+ farmWorker.getWorkexperience() + "\n";

                            flag = 0;
                        }catch (Exception exception){
                            if (exception instanceof ClassCastException){
                                System.out.println("Class exception !!");
                            }
                        }
                    }
                }
                if (flag == 1){
                    farmWorkerAreaPanel.setVisible(false);
                    JOptionPane.showMessageDialog(farmWorkerDetailsButton1,"There is no record for this employee ID");
                }else{
                    farmWorkerIDText.setText(setFarmText);
                }
            }
        });
        listFarmWorkersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    listFarmWorker.remove(farmWorkerPane);
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
                hideAllPanels();
                listFarmWorker.setVisible(true);
                listFarmWorkers();
            }
        });
        listSheepsButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    listSheep.remove(sheepPane);
                }catch (Exception ex){
                    System.out.println(ex.getMessage());
                }
                hideAllPanels();
                listSheep.setVisible(true);
                listSheeps();
            }
        });

    }
    /**
     * lists all vets in a JTable ,and it creates new GridLayout and adds on it
     */
    public void listVets(){
        listVetsPanel.setLayout(new GridLayout());
        int vetSize = 0,counterVets = 0;

        for (int j=0; j < FarmApp.employees.size(); j++){
            if (FarmApp.employees.get(j) instanceof Veterinary){
                vetSize++;
            }
        }

        Object[][] employees = new Object[vetSize][6];
        for (int i=0; i < FarmApp.employees.size(); i++){

            if (FarmApp.employees.get(i) instanceof Veterinary){

                Veterinary vet = (Veterinary) FarmApp.employees.get(i);
                employees[counterVets][0] = vet.getEmpID();
                employees[counterVets][1] = vet.getGender();
                employees[counterVets][2] = vet.getDateOfBirth().get(Calendar.DATE)+"/"+vet.getDateOfBirth().get(Calendar.MONTH)+"/"+vet.getDateOfBirth().get(Calendar.YEAR);
                employees[counterVets][3] = vet.isBScDegree();
                employees[counterVets][4] = vet.getDateOfGraduation().get(Calendar.DATE)+"/"+vet.getDateOfGraduation().get(Calendar.MONTH)+"/"+vet.getDateOfGraduation().get(Calendar.YEAR);
                employees[counterVets][5] = vet.getExpertiseLevel();
                counterVets++;
            }
        }

        String[] columnNames = {"Veterinary ID","Gender","Date Of Birth","BCsDegree","Graduation Date","Expertise Level"};
        DefaultTableModel model = new DefaultTableModel(employees,columnNames);
        vetTable = new JTable(model);
        vetTable.setModel(model);
        scrollPaneVet = new JScrollPane(vetTable);
        scrollPaneVet.getViewport().setBackground(new Color(109,110,110));
        listVetsPanel.add(scrollPaneVet, BorderLayout.SOUTH);
    }
    /**
     * lists all farm workers in a JTable ,and it creates new GridLayout and adds on it
     */
    public void listFarmWorkers(){
        listFarmWorker.setLayout(new GridLayout());
        int farmWSize = 0, counterFarmWorkers = 0;

        for (int j=0; j < FarmApp.employees.size(); j++){
            if (FarmApp.employees.get(j) instanceof FarmWorker){
                farmWSize++;
            }
        }

        Object[][] employees = new Object[farmWSize][5];
        for (int i=0; i < FarmApp.employees.size(); i++){

            if (FarmApp.employees.get(i) instanceof FarmWorker){

                FarmWorker farmWorker = (FarmWorker) FarmApp.employees.get(i);
                employees[counterFarmWorkers][0] = farmWorker.getEmpID();
                employees[counterFarmWorkers][1] = farmWorker.getGender();
                employees[counterFarmWorkers][2] = farmWorker.getDateOfBirth().get(Calendar.DATE)+"/"+farmWorker.getDateOfBirth().get(Calendar.MONTH)+"/"+farmWorker.getDateOfBirth().get(Calendar.YEAR);
                employees[counterFarmWorkers][3] = farmWorker.getPreviousFarmName();
                employees[counterFarmWorkers][4] = farmWorker.getWorkexperience();
                counterFarmWorkers++;
            }
        }

        String[] columnNames = {"Farm Worker ID","Gender","Date Of Birth","Previous Farm Name","Work experience"};
        DefaultTableModel model = new DefaultTableModel(employees,columnNames);
        farmWorkerTable = new JTable(model);
        farmWorkerTable.setModel(model);
        farmWorkerPane = new JScrollPane(farmWorkerTable);
        farmWorkerPane.getViewport().setBackground(new Color(109,110,110));
        listFarmWorker.add(farmWorkerPane, BorderLayout.SOUTH);
    }

    /**
     * to hide all panels,so I can show only the desired panel.
     */
    public void hideAllPanels(){
        menuPanel.setVisible(false);
        listCowPanel.setVisible(false);
        addCowPanel.setVisible(false);
        addSheepPanel.setVisible(false);
        deletePanel.setVisible(false);
        getCowDetails.setVisible(false);
        textCowPanel.setVisible(false);
        addVetPanel.setVisible(false);
        listVetsPanel.setVisible(false);
        addFarmWorkerPanel.setVisible(false);
        deleteVetPanel.setVisible(false);
        vetDetailsPanel.setVisible(false);
        textVetDetails.setVisible(false);
        addTreatmentPanel.setVisible(false);
        cleaningPanel.setVisible(false);
        healthTreatmentPanel.setVisible(false);
        getCowTreatment.setVisible(false);
        cowTreatmentPanel.setVisible(false);
        getCowTreatmentDate.setVisible(false);
        cowTreatmentDatePanel.setVisible(false);
        feedingAnimalPanel.setVisible(false);
        employeePanel.setVisible(false);
        milkingPanel.setVisible(false);
        deleteSheepPanel.setVisible(false);
        getSheepDetails.setVisible(false);
        sheepTextPanel.setVisible(false);
        deleteFarmWorker.setVisible(false);
        farmWorkerDetailsPanel.setVisible(false);
        farmWorkerAreaPanel.setVisible(false);
        listFarmWorker.setVisible(false);
        listSheep.setVisible(false);

    }


    /**
     * lists all cows in a JTable ,and it creates new GridLayout and adds on it
     */
    public void listCows(){
        listCowPanel.setLayout(new GridLayout());
        int cowSize = 0,counterCowIndex = 0;

        for (int j=0; j < FarmApp.animals.size(); j++){
            if (FarmApp.animals.get(j) instanceof Cow){
                cowSize++;
            }
        }

        Object[][] animals = new Object[cowSize][6];
        for (int i=0; i < FarmApp.animals.size(); i++){

            if (FarmApp.animals.get(i) instanceof Cow){

                Cow cow = (Cow) FarmApp.animals.get(i);
                animals[counterCowIndex][0] = cow.getTagNo();
                animals[counterCowIndex][1] = cow.getGender();
                animals[counterCowIndex][2] = cow.getDateOfBirth().get(Calendar.DATE)+"/"+cow.getDateOfBirth().get(Calendar.MONTH)+"/"+cow.getDateOfBirth().get(Calendar.YEAR);
                animals[counterCowIndex][3] = cow.isPurchased();
                animals[counterCowIndex][4] = cow.getWeight();
                animals[counterCowIndex][5] = cow.getMilking();
                counterCowIndex++;
            }
        }
        String[] columnNames = {"Tag Number","Gender","Date Of Birth","Purchased","Weight","Milking Date"};
        DefaultTableModel model = new DefaultTableModel(animals,columnNames);
        cowTable = new JTable(model);
        cowTable.setModel(model);
        scrollPaneCow = new JScrollPane(cowTable);
        scrollPaneCow.getViewport().setBackground(new Color(109,110,110));
        listCowPanel.add(scrollPaneCow, BorderLayout.SOUTH);

    }
    /**
     * lists all sheeps in a JTable ,and it creates new GridLayout and adds on it
     */
    public void listSheeps(){
        listSheep.setLayout(new GridLayout());
        int sheepSize = 0, counterSheep = 0;

        for (int j=0; j < FarmApp.animals.size(); j++){
            if (FarmApp.animals.get(j) instanceof Sheep){
                sheepSize++;
            }
        }

        Object[][] animals = new Object[sheepSize][5];
        for (int i=0; i < FarmApp.animals.size(); i++){

            if (FarmApp.animals.get(i) instanceof Sheep){

                Sheep sheep = (Sheep) FarmApp.animals.get(i);
                animals[counterSheep][0] = sheep.getTagNo();
                animals[counterSheep][1] = sheep.getGender();
                animals[counterSheep][2] = sheep.getDateOfBirth().get(Calendar.DATE)+"/"+sheep.getDateOfBirth().get(Calendar.MONTH)+"/"+sheep.getDateOfBirth().get(Calendar.YEAR);
                animals[counterSheep][3] = sheep.isPurchased();
                animals[counterSheep][4] = sheep.getMilking();
                counterSheep++;
            }
        }
        String[] columnNames = {"Tag Number","Gender","Date Of Birth","Purchased","Milking Date"};
        DefaultTableModel model = new DefaultTableModel(animals,columnNames);
        sheepTable = new JTable(model);
        sheepTable.setModel(model);
        sheepPane = new JScrollPane(sheepTable);
        sheepPane.getViewport().setBackground(new Color(109,110,110));
        listSheep.add(sheepPane, BorderLayout.SOUTH);

    }


}
