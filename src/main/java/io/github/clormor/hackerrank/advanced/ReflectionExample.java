package io.github.clormor.hackerrank.advanced;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionExample {

    public String getStudentMethods() {
        Method[] methods = Student.class.getDeclaredMethods();
        String[] methodNames = new String[methods.length];

        for (int i = 0; i < methods.length; i++) {
            methodNames[i] = methods[i].getName();
        }

        Arrays.sort(methodNames);
        StringBuilder result = new StringBuilder();
        for (String name: methodNames) {
            result.append(name).append(System.lineSeparator());
        }

        // if building via gradle we might get some jacoco classes, so remove these here
        return result.toString().replaceAll("\\$jacocoInit\\n", "");
    }
}
