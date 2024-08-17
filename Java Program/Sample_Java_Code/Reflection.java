package Sample_Java_Code;

import java.lang.reflect.Field;
import java.util.Arrays;

public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Student student = new Student();
        student.setName("Prashant");
        System.out.println(student.getClass());
        // student.getClass().getClassLoader().loadClass("");
        System.out.println(student.getClass().getName());
        System.out.println(student.getClass().getSimpleName());
        System.out.println(student.getClass().getCanonicalName());
        Field[] fields = student.getClass().getDeclaredFields();
        Arrays.stream(fields).forEach(field -> System.out.println(field.getName()));
    }
}

class Student {
    String name;

    String getName() {
        return this.name;
    }

    void setName(String name) {
        this.name = name;
    }
}
