package com.leetcode.exam.medium;

public class Test001 {
    public static void main(String[] args) {
        staticFunction();
    }

    static Test001 st = new Test001();

    static {
        System.out.println("1");
    }

    {
        System.out.println("2");
    }

    Test001() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    static int b = 112;
}
