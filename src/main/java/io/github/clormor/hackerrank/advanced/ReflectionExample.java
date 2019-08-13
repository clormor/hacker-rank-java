package io.github.clormor.hackerrank.advanced;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionExample {

    public String getObjectMethods() {
        Method[] methods = Object.class.getDeclaredMethods();
        String[] methodNames = new String[methods.length];

        for (int i = 0; i < methods.length; i++) {
            methodNames[i] = methods[i].getName();
        }

        Arrays.sort(methodNames);
        StringBuilder result = new StringBuilder();
        for (String name : methodNames) {
            result.append(name).append(System.lineSeparator());
        }

        // if building via gradle we might get some jacoco classes, so remove these here
        return result.toString().replaceAll("\\$jacocoInit\\n", "");
    }

    static class Inner {

        class Private {

            private boolean powerOf2(int n) {
                if (n == 1) {
                    return true;
                }
                do {
                    if (n == 2) {
                        return true;
                    }
                } while ((n /= 2) > 1);
                return false;
            }
        }
    }
}
