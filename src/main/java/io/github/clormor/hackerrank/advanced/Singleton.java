package io.github.clormor.hackerrank.advanced;

public class Singleton {

    static Singleton instance = new Singleton();
    String str = null;

    // private constructor
    private Singleton() {

    }

    static Singleton getSingleInstance() {
        return instance;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String s) {
        str = s;
    }
}
