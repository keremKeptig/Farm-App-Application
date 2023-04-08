package farmAppPackage.core;
import farmAppPackage.support.Animal;
import farmAppPackage.support.Employee;

import javax.swing.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *  class operates read,write and generate MD5.
 *  @author Kerem Keptig 2453355.
 *  @version JDK 19
 */
public class DataStorage {
    /**
     * first connects to the database.
     * It retrieves the values from the Animal table and properly adds it to the Animal list in the application
     * @param animals FarmApp.Animal list
     */
    public void animalDataBaseRead(ArrayList<Animal> animals) {
        String userName = "cng443user";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/FarmAppDB";
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);

            Statement statement = connection.createStatement();

            //Retrieves Animal information

            ResultSet resultSet = statement.executeQuery("select * from Animal");

            while (resultSet.next())
            {
                if(resultSet.getString("type").equals("c") ){
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(resultSet.getDate(3));

                    String gender = "";
                    if (resultSet.getString(2).equals("m")){
                        gender = "Male";
                    }else{
                        gender = "Female";
                    }
                    boolean isPurchased;
                    if(resultSet.getInt(4) == 1){
                        isPurchased = true;
                    }else{
                        isPurchased = false;
                    }
                    Cow cow = new Cow(resultSet.getInt(1),gender,calendar,isPurchased,resultSet.getDouble(6));
                    FarmApp.animals.add(cow);
                }
                if(resultSet.getString("type").equals("s")){
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(resultSet.getDate(3));
                    String gender = "";
                    if (resultSet.getString(2).equals("m")){
                        gender = "Male";
                    }else{
                        gender = "Female";
                    }
                    Sheep sheep = new Sheep(resultSet.getInt(1),gender,calendar,resultSet.getBoolean(4));
                    FarmApp.animals.add(sheep);
                }
            }

            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * first connects to the database.
     * It retrieves the values from the Employee table and properly adds it to the Employee list in the application
     * @param employees FarmApp.Employee list
     */
    public void employeeDatabaseRead(ArrayList<Employee> employees){
        String userName = "cng443user";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/FarmAppDB";
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);

            Statement statement = connection.createStatement();
        //Retrieves Employee information
        ResultSet resultSet2 = statement.executeQuery("select * from Employee");

        while (resultSet2.next())
        {
            if(resultSet2.getString("type").equals("v") ){
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(resultSet2.getDate(3));

                String gender = "";
                if (resultSet2.getString(2).equals("m")){
                    gender = "Male";
                }else{
                    gender = "Female";
                }

                boolean isBScDegree;
                if(resultSet2.getInt(5) == 1){
                    isBScDegree = true;
                }else{
                    isBScDegree = false;
                }
                //date of graduate
                Calendar calendar3 = Calendar.getInstance();
                calendar3.setTime(resultSet2.getDate(6));

                Veterinary veterinary = new Veterinary(resultSet2.getInt(1),gender,calendar2,isBScDegree,resultSet2.getInt(7),calendar3);
                FarmApp.employees.add(veterinary);
            }
            if(resultSet2.getString("type").equals("f")){
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(resultSet2.getDate(3));

                String gender = "";
                if (resultSet2.getString(2).equals("m")){
                    gender = "Male";
                }else{
                    gender = "Female";
                }

                FarmWorker farmWorker = new FarmWorker(resultSet2.getInt(1),gender,calendar2,resultSet2.getString(8),resultSet2.getInt(9));
                FarmApp.employees.add(farmWorker);
            }
        }
        resultSet2.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * first connects to the database.
     * After making the correct changes, adds to the Animal table in the database.
     * @param animal current animal that will be added
     */
    public void insertValuesAnimal(Animal animal){
        String userName = "cng443user";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/FarmAppDB";
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);

            String SQL = "INSERT INTO Animal(tagNo,gender,dateOfBirth,purchased,type,Weight) "
                    + "VALUES(?,?,?,?,?,?)";
            try {
                PreparedStatement statement = connection.prepareStatement(SQL);
                int count = 0;

                statement.setInt(1, animal.getTagNo());
                //gender
                String gender = "";
                if (animal.getGender().equals("Male")) {
                    gender = "m";
                } else {
                    gender = "f";
                }
                statement.setString(2, gender);
                // to convert date
                String date = animal.getDateOfBirth().get(Calendar.YEAR)+"-"+animal.getDateOfBirth().get(Calendar.MONTH)+"-"+animal.getDateOfBirth().get(Calendar.DAY_OF_MONTH);

                statement.setDate(3, Date.valueOf(date));
                //purchased if 1, true,else 0 false
                int isPurchased = 0;
                if (animal.isPurchased() == true){
                    isPurchased = 1;
                }else{
                    isPurchased = 0;
                }
                statement.setInt(4, isPurchased);
                // animal type
                String type = "";
                if (animal instanceof Cow){
                    type = "c";
                }else{
                    type = "s";
                }
                statement.setString(5, type);
                // if animal cow then insert weight if not, insertion doesn't occur
                if (animal instanceof Cow){
                    statement.setInt(6, (int) ((Cow) animal).getWeight());
                }else{
                    // -1 means null
                    statement.setInt(6, -1);
                }

                statement.execute();

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            connection.close();
        } catch (SQLException exx) {
            throw new RuntimeException(exx);
        } catch (ClassNotFoundException exx) {
            throw new RuntimeException(exx);
        }
    }

    /**
     * first connects to the database.
     * deletes from the database where the given tag number equals to same tag number in the database (Animal table).
     * @param tagNo tag number of the animal that want to delete
     */
    public void deleteAnimal(int tagNo){
        String userName = "cng443user";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/FarmAppDB";
        Connection connection = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);

            Statement statement = connection.createStatement();

            String query = "delete from Animal where tagNo = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, tagNo);

            // execute the preparedstatement
            preparedStmt.execute();

            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    /**
     * first connects to the database.
     * After making the correct changes, adds to the Employee table in the database.
     * @param employee current employee that will be added
     */
    public void insertValuesEmployee(Employee employee){
        String userName = "cng443user";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/FarmAppDB";
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);

            String SQL = "INSERT INTO Employee(empId,gender,dateOfBirth,type,BScDegree,dateOfGraduation,expertiseLevel,previousFarmName,workExperience) "
                    + "VALUES(?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement statement = connection.prepareStatement(SQL);
                int count = 0;

                statement.setInt(1, employee.getEmpID());
                //gender
                String gender = "";
                if (employee.getGender().equals("Male")) {
                    gender = "m";
                } else {
                    gender = "f";
                }
                statement.setString(2, gender);
                // to convert date
                String date = employee.getDateOfBirth().get(Calendar.YEAR)+"-"+employee.getDateOfBirth().get(Calendar.MONTH)+"-"+employee.getDateOfBirth().get(Calendar.DAY_OF_MONTH);
                statement.setDate(3, Date.valueOf(date));
                //if employee Veterinary
                if (employee instanceof Veterinary){
                    // BScDegree
                    int isBScDegree = 0;
                    if (((Veterinary) employee).isBScDegree() == true){
                        isBScDegree = 1;
                    }else{
                        isBScDegree = 0;
                    }
                    statement.setString(4,"v");
                    statement.setInt(5,isBScDegree);
                    // date of graduate
                    String graduateDate = ((Veterinary) employee).getDateOfGraduation().get(Calendar.YEAR)+"-"+((Veterinary) employee).getDateOfGraduation().get(Calendar.MONTH)+"-"+((Veterinary) employee).getDateOfGraduation().get(Calendar.DAY_OF_MONTH);
                    statement.setDate(6, Date.valueOf(graduateDate));
                    // expertise level
                    statement.setInt(7,((Veterinary) employee).getExpertiseLevel());
                    //veterinary insertion complete, other values set to null
                    statement.setString(8,"Unknown");
                    statement.setInt(9,-1);
                }else{
                    //-1 means null,2000-01-01 means null
                    statement.setString(4,"f");
                    statement.setInt(5,-1);
                    statement.setDate(6,Date.valueOf("2000-01-01"));
                    statement.setInt(7,-1);
                    statement.setString(8,((FarmWorker)employee).getPreviousFarmName());
                    statement.setInt(9,((FarmWorker)employee).getWorkexperience());
                }

                statement.execute();

            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }

            connection.close();
        } catch (SQLException exx) {
            throw new RuntimeException(exx);
        } catch (ClassNotFoundException exx) {
            throw new RuntimeException(exx);
        }
    }

    /**
     * first connects to the database.
     * deletes from the database where the given empID equals to same empID in the database (Employee table).
     * @param empID
     */
    public void deleteEmployee(int empID){
        String userName = "cng443user";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/FarmAppDB";
        Connection connection = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);

            Statement statement = connection.createStatement();

            String query = "delete from Employee where empID = ?";
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, empID);

            // execute the preparedstatement
            preparedStmt.execute();

            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * it generates MD5 according to Animal.txt
     */
    public void generateMD5(){
        /* Generate a DSA signature */
        FileInputStream animalFile = null;
        try {
            animalFile = new FileInputStream("Animal.txt");

            BufferedInputStream inputStream = new BufferedInputStream(animalFile);
            ByteArrayOutputStream updateStream = new ByteArrayOutputStream();
            int ch;
            while ((ch = inputStream.read()) != -1) {
                updateStream.write(ch);

            }
            byte buffer[] = updateStream.toByteArray();
            // Get a MessageDigest for the appropriate algorithm.
            MessageDigest algorithm = MessageDigest.getInstance("MD5"); // MD5

            // Ensure the digest's buffer is empty.
            algorithm.reset();

            // Fill the digest's buffer with data to compute a message digest from.
            algorithm.update(buffer);

            // Generate the digest. This does any necessary padding required by the
            // algorithm.
            byte digest[] = algorithm.digest();

            // Save digest bytes.
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < digest.length; i++) {
                hexString.append(Integer.toHexString(0xFF & digest[i]));
            }
            //write to new MD5 into storedMD5.txt
            FileOutputStream keyfos = new FileOutputStream("storedMD5.txt");
            keyfos.write(hexString.toString().getBytes());

        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (NoSuchAlgorithmException ex) {
            throw new RuntimeException(ex);
        }

    }

    /**
     * class allows to create threads for checking MD5.
     */
    public static class CheckMD5Thread  implements Runnable{

        private String fileName;
        private String checkMD5;

        /**
         * sets file name and old MD5 value
         * @param fileName equals to Animal.txt
         * @param checkMD5 equals to MD5 value before application closed
         */

        public CheckMD5Thread(String fileName,String checkMD5) {
            this.fileName = fileName;
            this.checkMD5 = checkMD5;
        }

        /**
         * With the MD5 value before the application closes, it reads from the recalculated Animal.txt and generates a new MD5,
         * and if this value is the same as the old value, it gives the appropriate message with a pop-up.
         */
        @Override
        public void run() {

            try {

                BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(fileName));
                ByteArrayOutputStream updateStream = new ByteArrayOutputStream();
                int ch;
                while ((ch = inputStream.read()) != -1) {
                    updateStream.write(ch);

                }
                byte buffer[] = updateStream.toByteArray();
                // generate new MD5 for current objects
                MessageDigest algorithm = MessageDigest.getInstance("MD5");

                // Ensure the digest's buffer is empty.
                algorithm.reset();

                // Fill the digest's buffer with data to compute a message digest from.
                algorithm.update(buffer);

                byte[] digest = algorithm.digest();

                // Save digest bytes.
                StringBuffer hexString = new StringBuffer();
                for (int i = 0; i < digest.length; i++) {
                    hexString.append(Integer.toHexString(0xFF & digest[i]));
                }
                if (checkMD5 == null) {
                    //MD5 didn't create this means application opened first time, I chose to display "Animal objects have not been changed"
                    JOptionPane.showMessageDialog(null, "Animal objects have not been changed");
                } else {
                    // if old MD5 value is equal then displays Animal objects have not been changed
                    if (hexString.toString().equals(checkMD5)) {
                        JOptionPane.showMessageDialog(null, "Animal objects have not been changed");
                    } else {
                        JOptionPane.showMessageDialog(null, "Animal objects have been changed !!");
                    }
                }

                inputStream.close();
                updateStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
