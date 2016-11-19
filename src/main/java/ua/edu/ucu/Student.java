package ua.edu.ucu;


import java.util.Objects;

class Student {

    private double gpa;
    private int year;
    private String name;
    private String surname;

    public Student(String name, String surname, double gpa, int year) {
        this.gpa = gpa;
        this.year = year;
        this.name = name;
        this.surname = surname;
    }

    public double getGPA() {
        return gpa;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "Student{name=" + name + ", surname="
                + surname + ", " + "GPA=" + gpa + ", year=" + year + '}';
    }

    public boolean equals(Object stud) {
        return (stud instanceof Student)
                && (Objects.equals(((Student) stud).getSurname(), getSurname()))
                && (Objects.equals(((Student) stud).getName(), getName()))
                && (((Student) stud).getGPA() == getGPA())
                && (((Student) stud).getYear() == getYear());
    }

}
