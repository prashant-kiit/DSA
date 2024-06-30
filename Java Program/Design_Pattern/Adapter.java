package Design_Pattern;

import java.util.ArrayList;
import java.util.List;

public class Adapter {
    public static void main(String[] args) {
        School school = new School();
        Mafia mafia = new Mafia("Prashant");
        StudentAdapter studentAdapter = new StudentAdapter(mafia);
        school.addStudent(studentAdapter);
        System.out.println(school.getStudents().get(0).getName());
    }
}

class School {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public List<Student> getStudents() {
        return this.students;
    }
}

interface Student {
    public String getName();
}

class Mafia {
    private String name;

    public Mafia(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}

class StudentAdapter implements Student {
    private String name;

    public StudentAdapter(Mafia mafia) {
        this.name = mafia.getName();
    }

    public String getName() {
        return this.name;
    }
}