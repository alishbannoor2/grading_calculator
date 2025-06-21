package scd_project;

public class Student {
    private String id;
    private String name;
    private double subject1, subject2, subject3;

    public Student(String id, String name, double s1, double s2, double s3) {
        this.id = id;
        this.name = name;
        this.subject1 = s1;
        this.subject2 = s2;
        this.subject3 = s3;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public double getSubject1() { return subject1; }
    public double getSubject2() { return subject2; }
    public double getSubject3() { return subject3; }

    public void setSubject1(double s1) { this.subject1 = s1; }
    public void setSubject2(double s2) { this.subject2 = s2; }
    public void setSubject3(double s3) { this.subject3 = s3; }

    public double getAverage() {
        return (subject1 + subject2 + subject3) / 3.0;
    }

    public String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else if (avg >= 50) return "E";
        else return "F";
    }
}