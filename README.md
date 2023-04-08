# Farm-App-Application
The aim of this project is to create a graphical user interface to the application and also store/retrieve the data in external binary files.
# Aims and Objectives
The main application called FarmApp will be used to maintain information 
about animals and also the employees working in the farm. FarmApp will also 
have the main method and will provide the overall interaction with the 
application. Therefore, this class should include the main method where an 
instance of this class is constructed and the menu of commands is displayed to 
the user. Since we have not yet covered Graphical User Interfaces (GUI) in this 
course, you need to implement it as a command-line application. The required 
methods are as follows:

o void menu(): This method will display the interaction menu to the user;
o void addCow(): This method will add new cow to the list of cows
maintained. Each cow needs to have unique tag number, the gender will 
be specified as either male or female, the date of birth will be recorded 
and also whether the cow is purchased or whether it is farm-raising
and you need to also record its weight and create a hashmap for 
recording milks measurements. These measurements will be done 
regularly but when the cow is added it will be initially empty.
o void deleteCow(int tagNo): This method will read a tag number of a 
cow, and delete the corresponding cow object. If the tag number does 
not exist, the program should provide an appropriate error message.
o void getCowDetails(int tagNo): Given a tag number, this method will 
display the Cow details (no need to show medication and treatment 
details). If the tag number does not exist, the program should provide 
an appropriate error message.
o void addVet(): This method will add a new vet with a unique ID.
o void deleteVet(int vetID): Given a vet ID, this method will delete a vet. 
If the vetID does not exist, the program should provide an appropriate 
error message.
o void getVetDetails(int vetID): Given a vetID, this method will display 
the vet details. If the vetID does not exist, the method should provide an 
appropriate error message.
o void addTreatment(int vetId, int tagNo): This method will record the 
treatment given by a particular vet to an animal with the given tag 
number. Animals can have two kinds of treatments: Cleaning and 
Health related. Therefore, you should ask user about the type of the 
treatment and add accordingly. If the vet with the given ID or the cow 
with the given ID does not exist then the relevant error messages should 
be given. Please note that when a treatment is added, the relevant 
medication should also be recorded, and similarly vet and 
farmworker should also be recorded accordingly.
o void getCowTreatment(int tagNo): Given a tag number, this method 
will return the treatment that has been done to the given cow. If the 
treatments have medication, they should also be displayed. If it has 
3
Middle East Technical University 
Northern Cyprus Campus
multiple treatments all will be returned. Please note that if the tag 
number does not exist, relevant messages will be given. 
o void getCowTreatment(int tagNo, Date dateOfTreatment): Given a tag 
number, this method will return the treatment that has been done to the 
given cow on the given particular date. If it has multiple treatments all 
will be returned. Please note that if the tag number does not exist, 
relevant messages will be given. If there is no treatment on a particular 
date then relevant error messages will be given. 
o void listCow(): This method will list all the cows. You do not need to 
display treatments and medications for a cow. You need to display only 
the relevant cow details.
o void listVet(): This method will list all the vets.
o void feedingAnimal(int tagNo): This method will call the feeding() 
method of the animal with the given tagNo to get information about 
how an animal needs to be fed. A cow’s feeding decision is done 
based on their age and also the weight. It can be decided as follows:
▪ If a cow is younger than 3 years old then they are only fed
with grass. 
▪ If a cow is older than 5 years old and weight is less than 500 
then it needs Total mixed ration (TMR) is a diet that 
includes hay, fermented grass (silage), maize silage and 
high energy grains like brewers grains, soy bean, cotton 
seed and citrus pulp.
▪ If a cow is older than 10 years old, it needs grains and oilseed 
meals.
▪ In all other cases, the cow needs be fed with grass and grains.
Similarly, a sheep’s feeding decision is done based on their age as 
follows:
▪ If a sheep is male and younger than 5 years old then only 
grass.
▪ If a sheep is female and younger than 8 years old then only 
grass.
▪ If a sheep is male and older than 5 years old then Total mixed 
ration (TMR) diet is needed. 
▪ If a sheep is female and older than 8 years old then Total 
mixed ration (TMR) diet is needed.
Based on the logic given above, this method will display the relevant 
message based on the tagNo. TagNo will be used to decide about the 
animal, get the relevant details and then display the relevant 
messages given above.
o double getEmpSalary(int empId): This method will return the salary 
of an employee. If the employee with that ID does not exist, it should 
give the necessary error messages. Employee salaries are calculated 
as follows:
▪ Veterinary: Their salary will be calculated as follows: 
grossSalary given in the Payment interface + 
%10*grossSalary*(number of years since their graduation). 
4
Middle East Technical University 
Northern Cyprus Campus
For example, if the grossSalary is 10000 and it has been 2 
years since they graduated then their salary will be 
10000+10000*0.10*2=12000.
▪ FarmWorker: Their salary will be calculated as follows: 
grossSalary given in the Payment interface + 
%2*workexperience. For example, if the grossSalary is 
10000 and work experience is 2 years then they will receive 
10000+10000*0.02*2=10400.
o void addMilkingMeasurement(int tagNo, double amount): The farm 
owner would like to record milking measurements that are done for 
an animal. They measure once in a while to see how much milk an 
animal provides, and the farm owner would like to record these. 
This method will get the animal tagNo, the amount of milk provided. 
To store such details, the Animal class has a Hash Map that will 
store date (the day of the entry will be used) and the milk amount 
recorded. There can be only one measurement per day, therefore, 
the date can be used as a key. Values will be stored as follows:
▪ 2022-10-11=30
▪ 2022-10-12=40
That means for an animal there were two measurements with the 
values of 30 and 40. Hint: You can use the LocalDate class.

![image](https://user-images.githubusercontent.com/110033343/230739596-2f0896fa-b9f2-49e4-8ff7-6976100ccc0d.png)

