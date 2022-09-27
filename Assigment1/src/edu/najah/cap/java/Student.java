package edu.najah.cap.java;

import java.time.LocalDate;

public class Student {
    static int count = 0;
    private final int id;
    private String name;
    private LocalDate dateOfBirth;
    public static final int currentYear = 2022 ;

    //    Constructors
    public Student() {
        this.count++;
        this.id = count;
    }
    public Student(final String name,final LocalDate dateOfBirth) {
        this.count++;
        this.id = count;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }
    //    Getter
    final public int getAge() { return currentYear - dateOfBirth.getYear(); }
    final public LocalDate dateOfBirth() { return dateOfBirth; }
    final public int getId() { return id; }
    public String getName() { return name; }

    //    Setter
    public void setName(final String name) { this.name = name; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    //    Equal function
    public boolean equals(Student student){
        return this.dateOfBirth.isEqual(student.dateOfBirth)&& this.name.equals(student.getName());
    }

    //  function to Print student information
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
