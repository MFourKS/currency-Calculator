package com.company;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static PrintWriter pw= new PrintWriter(System.out, true);
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {

        //Объявление переменных
        String[] str;
        String fcn = "";
        String fcn1 = "";
        String fcn2 = "";
        double valueOut = 0;
        double value = 0;
        int parСount = 0;
//        String[] tr;
//        int k = 0;

        pw.printf("Вас приветствует программа-конвертер. Конвертер работает с рублями и долларами.\n");
        System.gc();
        pw.printf("\nБазовые функции конвертера:\n" +
                "toDollars() - перевод результата в доллары($);\ntoRubles() - перевод результата в рубли(р);\nКурс $1 = 75.09р\n" +
                "Пример использования конвертера: toDollars(737р + toRubles($85.4))\nДробные значения пишутся через точку(.)!\n\nВведите функцию для получения результата:\n");
        fcn = scan.nextLine();
        pw.printf(fcn);
        str = new String[fcn.length()];
//        tr = new String[fcn.length()];

        int indexToDollars = fcn.indexOf("toDollars(");
        int indexToRubles = fcn.indexOf("toRubles(");
        if(indexToRubles>indexToDollars){
            fcn1 = fcn.substring(0, indexToRubles);
            fcn2 = fcn.substring(indexToRubles+10);
            int indexEndFunction = fcn2.indexOf(")");
            value = Double.parseDouble(fcn2.substring(0, indexEndFunction));

            fcn = fcn1 + removeCharAt(fcn2, indexEndFunction);;
            valueOut = value * 75.09;
            pw.printf("\n"+fcn);
            pw.println("\n"+ valueOut);
        }
        else {
            fcn1 = fcn.substring(0, indexToDollars);
            fcn2 = fcn.substring(indexToDollars + 10);
            int indexEndFunction = fcn2.indexOf(")");
            value = Double.parseDouble(fcn2.substring(0,fcn2.indexOf("р")));
            removeCharAt(fcn2, indexEndFunction);
            fcn = fcn1 + fcn2;
            pw.printf("\n" + fcn);
        }
        fcn1 = fcn.substring(0, indexToDollars);
        fcn2 = fcn.substring(indexToDollars + 10);
        int indexEndFunction = fcn2.indexOf(")");
        //value = Double.parseDouble(fcn2.substring(0, indexEndFunction));


        value = Double.parseDouble(fcn2.substring(0,fcn2.indexOf("р")));
        fcn = fcn1 + removeCharAt(fcn2, indexEndFunction);
        valueOut = (valueOut + value)/75.09;
        pw.printf("\n" + fcn + " " + valueOut);



     //   int indexToRubles = fcn.indexOf("toRubles");

//        pw.println(indexToDollars);
//        pw.println(indexToRubles);
//        for(int i = indexToDollars + 9; i < fcn.length(); i++){
//           String tmp = Character.toString(fcn.charAt(i));
//            if(tmp.equals("(")) parСount++;
//        }
//        for(int i = indexToRubles + 8; i < fcn.length(); i++){
//
//        }

//        for (int i = 0; i < fcn.length(); i++) {
//            str[i] = "";tr[i] = "";
//        }

    }
    public static String removeCharAt(String s, int pos) {
            return s.substring(0, pos) + s.substring(pos+1);
    }
}
