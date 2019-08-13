package io.github.clormor.hackerrank.advanced;

public class Add {

    public String add(int n1, int... ns) {
        int sum = n1;
        StringBuilder result = new StringBuilder().append(n1);
        for (int n : ns) {
            result.append("+").append(n);
            sum += n;
        }
        result.append("=").append(sum);
        return result.toString();
    }

}
