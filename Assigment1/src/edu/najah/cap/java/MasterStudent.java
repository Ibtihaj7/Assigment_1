package edu.najah.cap.java;

import java.time.LocalDate;

public class MasterStudent extends Student{
    private String research;
    private String supervisor;
    private BA_DEGREE ba_degree;
    enum BA_DEGREE{
        COMMUNICATION, EDUCATION, ENGLISH, FOREIGN_LANGUAGE, PHILOSOPHY, PSYCHOLOGY, SOCIOLOGY
    }

    //  Constructors
    public MasterStudent() {
        super();
        this.research = "";
        this.supervisor = "";
    }

    public MasterStudent(final String name, final LocalDate dateOfBirth, final String supervisor,final BA_DEGREE ba_degree) {
        super(name, dateOfBirth);
        this.supervisor = supervisor;
        this.ba_degree = ba_degree;
    }

//  Gitter & Sitter

    public BA_DEGREE getBa_degree() { return ba_degree; }
    public void setBa_degree(BA_DEGREE ba_degree) { this.ba_degree = ba_degree; }

    public String getResearch() { return research; }
    public void setSupervisor(final String supervisor) { this.supervisor = supervisor; }

    //    submit Research function
    public void submitResearch(final String text){ this.research = text; }
    //  function to git supervisor
    public String getSupervisor() { return supervisor; }

    @Override
    public String toString() {
        return "MasterStudent{" +
                "id=" + super.getId() +
                ", name='" + super.getName() + '\'' +
                ", dateOfBirth=" + super.dateOfBirth() +
                "research='" + research + '\'' +
                ", supervisor='" + supervisor + '\'' +
                "the ba_degree ="+this.ba_degree+
                '}';
    }
}
