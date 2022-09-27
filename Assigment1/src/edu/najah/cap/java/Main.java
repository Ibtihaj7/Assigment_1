package edu.najah.cap.java;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.time.LocalDate;
import java.util.*;

public class Main {
    static Scanner in = new Scanner(System.in);
    static int retrieveCount =0;
    static int deleteCount =0;
    public static void main(String[] args) {
        ArrayList<Student> studentsList = new ArrayList<>();
        int choice;
        menu();
        choice = in.nextInt();
        while(choice != 11){
            switch (choice){
                case 1: addStudent(studentsList,1); break;
                case 2: addStudent(studentsList,2); break;
                case 3: addStudent(studentsList,3); break;
                case 4: addStudent(studentsList,4); break;
                case 5: retrieveStudent(studentsList); break;
                case 6: removeStudent(studentsList); break;
                case 7: printAll(studentsList); break;
                case 8: studentAge(studentsList); break;
                case 9:operateInSystem();break;
                case 10: cheakEqual(studentsList); break;
                default: System.out.println("Bad number.\nTry again enter valid number"); break;
            }
            menu();
            choice = in.nextInt();
        }
        System.out.println("Thanks for using our program .\nBye ");
    }
    static OperationsInTheSystem operationsInTheSystem(){
        OperationsInTheSystem obj = new OperationsInTheSystem(Student.count,deleteCount,retrieveCount);
        return obj;
    }
    static void addStudent(ArrayList students,final int choice){
        String name;
        int day,month,year;
        System.out.print("Enter name of student: ");
        name = in.next();
        System.out.println("Enter date of birth :");
        System.out.print("Year: ");
        year = in.nextInt();
        System.out.print("Month: ");
        month = in.nextInt();
        System.out.print("Day: ");
        day = in.nextInt();
        LocalDate dob = LocalDate.of(year,month,day);
        Student newStudent = null;
        if(choice == 1 ){
            newStudent = new Student(name,dob);
        }else if(choice == 2){
            System.out.print("Enter the supervisor of master student: ");
            String supervisor = in.next();
            int ba_degree = ba_degree_menu();
            if (ba_degree == 1){
                newStudent = new MasterStudent(name,dob,supervisor,MasterStudent.BA_DEGREE.COMMUNICATION);
            }else if(ba_degree ==2){
                newStudent = new MasterStudent(name,dob,supervisor,MasterStudent.BA_DEGREE.EDUCATION);
            }else if(ba_degree ==3){
                newStudent = new MasterStudent(name,dob,supervisor,MasterStudent.BA_DEGREE.ENGLISH);
            }else if(ba_degree == 4){
                newStudent = new MasterStudent(name,dob,supervisor,MasterStudent.BA_DEGREE.FOREIGN_LANGUAGE);
            }else if(ba_degree == 5){
                newStudent = new MasterStudent(name,dob,supervisor,MasterStudent.BA_DEGREE.PHILOSOPHY);
            }else if(ba_degree == 6){
                newStudent = new MasterStudent(name,dob,supervisor,MasterStudent.BA_DEGREE.PSYCHOLOGY);
            }else if(ba_degree == 7){
                newStudent = new MasterStudent(name,dob,supervisor,MasterStudent.BA_DEGREE.SOCIOLOGY);
            }
        }else if(choice ==3){
            System.out.print("Enter name of hospital of medical student: ");
            String hospital = in.next();
            newStudent = new MedicalStudent(name,dob,hospital);
        }else if(choice ==4){
            newStudent = new EngineeringStudent(name,dob);
        }else{
            System.out.println("Error in choice number.\n");
            return;
        }
        students.add(newStudent);
        System.out.println("Added successfully");
    }
    //    function that cheak if the student in the system or not
    static boolean cheakStudent(ArrayList<Student> students, final int id){
        for(Student st:students)
            if(st.getId() == id )
                return true;
        return false;
    }
    static void retrieveStudent(ArrayList<Student> studentsList ){
        System.out.print("Enter id of student you want to retrieve: ");
        int id = in.nextInt();
        if(!cheakStudent(studentsList , id)) System.out.println("the id is not correct,try agin enter another id\n");
        for(Student student:studentsList)
            if(student.getId() == id ){
                retrieveCount++;
                System.out.println(student.toString());
            }
    }
    static void removeStudent(ArrayList<Student> studentsList){
        int num=0;
        System.out.print("Enter id of student you want to retrieve: ");
        int id = in.nextInt();
        if(!cheakStudent(studentsList , id)) System.out.println("the id is not correct,try again enter another id\n");
        for(Student student:studentsList) {
            if (student.getId() == id) {
                studentsList.remove(num);
                System.out.println("Deleted");
                deleteCount++;
            }
            num++;
        }
    }
    static void printAll(ArrayList<Student>studentsList ){
        System.out.println("All Students are: ");
        for(Student student:studentsList)
            System.out.println(student.toString());
    }
    static void studentAge(ArrayList<Student>studentsList){
        int num=0;
        System.out.print("Enter id of student you want know its age: ");
        int id = in.nextInt();
        if(!cheakStudent(studentsList , id)) System.out.println("the id is not correct,try again enter another id\n");
        for(Student student:studentsList) {
            if (student.getId() == id ) {
                System.out.println(student.getName() + "'s age is " + student.getAge());
            }
            num++;
        }
    }
    static void operateInSystem(){
        OperationsInTheSystem object = operationsInTheSystem();
        System.out.println("Numbers of add : " + object.getAdd());
        System.out.println("Numbers of retrieve : " + object.getRetrieve());
        System.out.println("Numbers of remove : " + object.getRemove());
    }
    static void cheakEqual(ArrayList<Student>studentsList){
        int num,index1,index2;
        System.out.print("Enter first student id : ");
        int id1 = in.nextInt();
        System.out.print("Enter second student id: ");
        int id2 = in.nextInt();
        if(!cheakStudent(studentsList,id1) || ! cheakStudent(studentsList,id2)){
            System.out.println("the id is not correct,try again enter valid id\n");
        }else{
            num =index1 = index2 = 0;
            for(Student student:studentsList) {
                if (student.getId() == id1 ) {
                    index1 = num;
                }
                if (student.getId() == id2 ) {
                    index2 = num;
                }
                num++;
            }
            if(studentsList.get(index1).equals(studentsList.get(index2) )){
                System.out.println("two Student have same values");
            }else{
                System.out.println("two Student don't have same values");
            }
        }
    }
    static final void menu(){
        System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*");
        System.out.println("Enter 1 to add new Student.");
        System.out.println("Enter 2 to add new Master students.");
        System.out.println("Enter 3 to add new Medical students.");
        System.out.println("Enter 4 to add new Engineering students.");
        System.out.println("Enter 5 to retrieve Student by id.");
        System.out.println("Enter 6 to remove Student by id.");
        System.out.println("Enter 7 to print all students information.");
        System.out.println("Enter 8 to returns the current age of student by id.");
        System.out.println("Enter 9 to get a report containing numbers of add, retrieve and remove operations made in system.");
        System.out.println("Enter 10 to compare tow student if there information same or not.");
        System.out.println("Enter 11 to Exit program.");
        System.out.print("Your choice: ");
    }
    static final int ba_degree_menu(){
        System.out.println("Choose your specialty from the following: ");
        System.out.println("Enter 1 for Communication.");
        System.out.println("Enter 2 for Education.");
        System.out.println("Enter 3 for English.");
        System.out.println("Enter 4 for Foreign_Language.");
        System.out.println("Enter 5 for Philosophy.");
        System.out.println("Enter 6 for Psychology.");
        System.out.println("Enter 7 for Sociology.");
        int num = in.nextInt();
        while (num!=1 && num!=2 && num!=3 && num!=4 && num!=5 && num!=6 && num!=7){
            System.out.print("Bad number try again,Enter valid number : ");
            num=in.nextInt();
        }
        return num;
    }
}
