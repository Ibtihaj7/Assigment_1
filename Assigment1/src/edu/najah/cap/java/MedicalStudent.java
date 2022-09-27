package edu.najah.cap.java;

import java.time.LocalDate;

public class MedicalStudent extends Student {
    private String hospital;
    private String research;

    //  Constructors
    public MedicalStudent() {
        super();
        this.hospital = "";
    }
    public MedicalStudent(String name, LocalDate dateOfBirth, String hospital) {
        super(name, dateOfBirth);
        this.hospital = hospital;
    }
//  Getter & Setter

    public String getHispotal() { return hospital; }
    public void setHispotal(final String hispotal) { this.hospital = hispotal; }
    public String getResearch() { return research; }

    //  function to submit research
    public void submitResearch(final String text){ this.research = text; }

    @Override
    public String toString() {

        return "MedicalStudent{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", dateOfBirth=" + super.dateOfBirth() +
                "hospital='" + hospital + '\'' +
                ", research='" + research + '\'' +
                '}';
    }
}
