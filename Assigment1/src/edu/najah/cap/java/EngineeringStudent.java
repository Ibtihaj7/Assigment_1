package edu.najah.cap.java;

import java.time.LocalDate;

public class EngineeringStudent extends Student {
    private String lab;

    public EngineeringStudent() {
        super();
        this.lab = "";
    }

    public EngineeringStudent(String name, LocalDate dateOfBirth) {
        super(name, dateOfBirth);
        this.lab = lab;
    }

    //function to submit lab
    public void submitLab(final String text){ this.lab = text; }

    @Override
    public String toString() {
        return "EngineeringStudent{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", dateOfBirth=" + super.dateOfBirth() +
                "lab='" + lab + '\'' +
                '}';
    }
}
