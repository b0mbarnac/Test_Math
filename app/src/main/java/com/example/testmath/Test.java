package com.example.testmath;

import java.util.Random;

public class Test {
    private int first_num;
    private int second_num;
    private int result;
    private int tmp_oper;
    private String operation;
    private static int round = 0;

    public void generate_expression() {
        Random r = new Random();
        first_num = r.nextInt(199) + 1;
        tmp_oper = r.nextInt(4);
        switch (tmp_oper) {
            case 0:
                operation = "+";
                second_num = r.nextInt(200 - first_num);
                result = first_num + second_num;
                break;
            case 1:
                operation = "-";
                second_num = r.nextInt(first_num);
                result = first_num - second_num;
                break;
            case 2:
                operation = "*";
                first_num = r.nextInt(55)+1;
                second_num = r.nextInt((int) (200 / first_num));
                result = first_num * second_num;
                break;
            case 3:
                operation = "/";
                second_num = r.nextInt(first_num) + 1;

                while (((double) (first_num) / second_num) % 1 != 0) {
                    second_num--;
                    if (second_num == 0)
                        second_num--;
                }
                result = first_num / second_num;
                break;
        }
//        System.out.println("_______________" + r.nextInt(5)+ "___________________________");
//        System.out.println(first_num + operation + second_num);
//        System.out.println("______________________"+r.nextInt(5)+"____________________");

    }

    public String get_expression() {
        round++;
        return Integer.toString(first_num) + operation + Integer.toString(second_num);
    }

    public int get_result() {
        return result;
    }

    public int get_random_answer() {
        Random r = new Random();
        int res = r.nextInt(200);
        return res;
    }

    public static int getRound() {
        return round;
    }
}
