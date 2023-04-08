package farmAppPackage.core;

import farmAppPackage.support.Animal;
import farmAppPackage.support.Employee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

/**
 *  Class has attributes that animal list and employee list.
 *  @author Kerem Keptig 2453355.
 *  @version JDK 19
 */
public class PopulateData implements Serializable {
    private ArrayList<Animal> animals;
    private ArrayList<Employee> employees;

    /**
     * Builds 2 cow objects, 2 sheep objects, 2 vet objects and 2 farmWorker objects sets their initial values.
     */
    public PopulateData() {
        animals = new ArrayList<Animal>();
        employees = new ArrayList<Employee>();

        // Here I determine the values that I send into the function.
        String[] medicationNotes = {"animal should be vaccinated","animal needs medicine","animal must have surgery","animal is aggressive"};
        String[] datesVet = {"01/02/1980","02/05/1995","06/07/1975"};
        String[] datesCow = {"03/09/2000","04/08/2012","07/05/2022","08/08/2005"};
        String[] datesMedication = {"01/04/2020","25/10/2022","06/12/2021","14/09/2003"};
        String[] datesTreatment = {"02/03/2020","07/10/2022","13/09/2021","13/09/2003"};
        String[] datesGraduate = {"01/05/2001","02/05/2015","06/05/2000"};
        String[] prevFarmName = {"molly farm","tom farm","pure farm"};
        String[] genderSelect = {"male","female","male","female"};
        String[] materialUsed = {"iron","wood","plastic","gold"};
        double[] amount = {100,200,300,400};
        int vetId = 1, tag = 0;
        boolean[] purchased = {true,false,true,false};
        int i;

        // to create 2 cow objects, 2 vet objects and 2 farmWorker, it invokes populateCow function and takes the values I set above.
        for (i=0; i < 2;i++)
        {

            tag++;
            animals.add(populateCow(tag,genderSelect[i], purchased[i],datesVet[i],datesCow[i],datesMedication[i],datesTreatment[i],datesGraduate[i],
                    vetId,amount[i],medicationNotes[i],prevFarmName[i],materialUsed[i]));
            vetId += 2;
        }
        //2 sheep objects created here
        tag++;
        animals.add(populateSheep((Veterinary) employees.get(0),(FarmWorker) employees.get(1),tag,genderSelect[2],datesCow[2],datesTreatment[2],datesMedication[2],purchased[2],amount[2],medicationNotes[2],materialUsed[2]));
        tag++;
        animals.add(populateSheep((Veterinary) employees.get(2),(FarmWorker) employees.get(3),tag,genderSelect[3],datesCow[3],datesTreatment[2],datesMedication[2],purchased[3],amount[3],medicationNotes[2],materialUsed[2]));
    }

    /**
     * Gets a cow object with the vet inside and farmWorker the cow object.
     * @param tag tag number of the cow.
     * @param gender gender of the cow.
     * @param purchased purchased of the cow.
     * @param dateVet birthdate of the vet.
     * @param dateCow birthdate of the cow.
     * @param dateMedication start date of the medication.
     * @param datesTreatment start date of the treatment.
     * @param graduate graduate date of vet.
     * @param amount amount of milk.
     * @param vetId vet id of the veterinary.
     * @param medicationNote note of the medication.
     * @param previousName previousName of the farmWorker.
     * @param materialUsed materialUsed of the Cleaning treatment.
     * @return cow object with the vet inside the cow object.
     */

    public Cow populateCow(int tag, String gender,boolean purchased, String dateVet,String dateCow,String dateMedication,String datesTreatment,String graduate,
                           int vetId,double amount,String medicationNote,String previousName,String materialUsed)
    {

        int dosage = tag;
        int duration = tag*10;

        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar3= Calendar.getInstance();
        Calendar calendar4 = Calendar.getInstance();
        Calendar calendar5 = Calendar.getInstance();
        Calendar calendar6 = Calendar.getInstance();

        String dateCowString[],dateVetString[],dateMedicationString[],dateTreatmentString[],dateOfGraduate[];
        dateCowString = dateCow.split("/");
        dateVetString = dateVet.split("/");
        dateMedicationString = dateMedication.split("/");
        dateTreatmentString = datesTreatment.split("/");
        dateOfGraduate = graduate.split("/");
        // set calendar object, calendar1 = cow date.
        // calendar2 = veterinary date.
        // calendar3 = medication date.
        // calendar4 = treatment date.
        // calendar5 = date of graduation
        calendar1.set(Integer.parseInt(dateCowString[2]),Integer.parseInt(dateCowString[1]) ,Integer.parseInt(dateCowString[0]));
        calendar2.set(Integer.parseInt(dateVetString[2]),Integer.parseInt(dateVetString[1]) ,Integer.parseInt(dateVetString[0]));
        calendar3.set(Integer.parseInt(dateMedicationString[2]),Integer.parseInt(dateMedicationString[1]) ,Integer.parseInt(dateMedicationString[0]));
        calendar4.set(Integer.parseInt(dateTreatmentString[2]), Integer.parseInt(dateTreatmentString[1]), Integer.parseInt(dateTreatmentString[0]));
        calendar5.set(Integer.parseInt(dateOfGraduate[2]), Integer.parseInt(dateOfGraduate[1]), Integer.parseInt(dateOfGraduate[0]));
        calendar6.set(Integer.parseInt(dateTreatmentString[2]), Integer.parseInt(dateTreatmentString[1]), Integer.parseInt(dateTreatmentString[0])-2);
        Medication medication = new Medication("Medication "+ tag ,duration,calendar3,dosage,medicationNote);
        boolean bscDegree = false;
        int expLevel = 1*tag;

        Veterinary veterinary = new Veterinary(vetId, gender, calendar2,bscDegree,expLevel,calendar5);

        employees.add(veterinary);

        FarmWorker farmWorker = new FarmWorker(vetId+1,gender,calendar2,previousName,expLevel);

        employees.add(farmWorker);

        ArrayList<Treatment> treatments = new ArrayList<Treatment>();
        HealthTreatment treatment = new HealthTreatment(calendar4,false,veterinary);

        CleaningTreatment treatment2 = new CleaningTreatment(calendar6,materialUsed,farmWorker);
        treatment.getMedications().add(medication);
        treatments.add(treatment);
        treatments.add(treatment2);

        HashMap<String, Double> milking= new HashMap<String, Double>();

        double weight = 1000.0;
        milking.put(dateMedication,amount);

        Cow cow = new Cow(tag, gender, calendar1, purchased,milking, treatments,weight);

        return cow;
    }

    /**
     * Gets a sheep object with the vet inside and farmWorker the sheep object.
     * @param veterinary same cow veterinary take care sheep.
     * @param farmWorker same cow farmWorker take care sheep.
     * @param tag tag number of the sheep.
     * @param gender gender of the sheep.
     * @param dateOfBirth birthdate of the sheep.
     * @param dateOfTreatment start date of the treatment.
     * @param dateOfMedication start date of the medication.
     * @param purchased purchased of the sheep.
     * @param amount amount of milk.
     * @param medicationNote note of the medication.
     * @param materialUsed material used for Cleaning treatment.
     * @return
     */
    public Sheep populateSheep(Veterinary veterinary,FarmWorker farmWorker,int tag,String gender,String dateOfBirth,String dateOfTreatment,String dateOfMedication,boolean purchased,double amount,String medicationNote,String materialUsed){

        int dosage = tag;
        int duration = tag*10;

        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Calendar calendar3= Calendar.getInstance();

        String dateSheepString[],dateVetString[],dateMedicationString[],dateTreatmentString[],dateOfGraduate[];
        dateSheepString = dateOfBirth.split("/");
        dateMedicationString = dateOfMedication.split("/");
        dateTreatmentString = dateOfTreatment.split("/");
        // set calendar object, calendar1 = cow date.
        // calendar2 = treatment date.
        // calendar3 = medication date.

        calendar1.set(Integer.parseInt(dateSheepString[2]),Integer.parseInt(dateSheepString[1]) ,Integer.parseInt(dateSheepString[0]));
        calendar2.set(Integer.parseInt(dateTreatmentString[2]),Integer.parseInt(dateTreatmentString[1]) ,Integer.parseInt(dateTreatmentString[0]));
        calendar3.set(Integer.parseInt(dateMedicationString[2]),Integer.parseInt(dateMedicationString[1]) ,Integer.parseInt(dateMedicationString[0]));

        Medication medication = new Medication("Medication "+ tag ,duration,calendar3,dosage,medicationNote);
        boolean bscDegree = false;
        int expLevel = 1;

        ArrayList<Treatment> treatments = new ArrayList<Treatment>();
        HealthTreatment treatment = new HealthTreatment(calendar2,false,veterinary);

        CleaningTreatment treatment2 = new CleaningTreatment(calendar2,materialUsed,farmWorker);
        treatment.getMedications().add(medication);
        treatments.add(treatment);
        treatments.add(treatment2);

        HashMap<String, Double> milking= new HashMap<String, Double>();

        milking.put(dateOfTreatment,amount);
        Sheep sheep = new Sheep(tag, gender, calendar1, purchased,milking, treatments);
        return sheep;
    }
    /**
     * Gets all animals in a arrayList.
     * @return all animals in a arrayList.
     */
    public ArrayList<Animal> getAnimals() {
        return animals;
    }
    /**
     * Sets all animals in a arrayList.
     * @param animals animals new animals in a arrayList.
     */
    public void setAnimals(ArrayList<Animal> animals) {
        this.animals = animals;
    }

    /**
     * Gets all employees in a arrayList.
     * @return all employees in a arrayList.
     */
    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    /**
     * Sets all employees in a arrayList.
     * @param employees employees new employees in a arrayList.
     */
    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}
