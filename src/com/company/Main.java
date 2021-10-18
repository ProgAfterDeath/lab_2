package com.company;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.*;

public class Main {

    public static void main(String[] args) {
        Main program = new Main();
        program.run();
    }

    private void run(){
        double x1, x2, stepX, a;
        x1 = enterVar("x1");
        x2 = enterVar("x2");
        stepX = enterVar("Δx");
        a = enterVar("a");

        double[] arrX = getArrayX(x1,x2,stepX);
        double[] arrY = getArrayY(arrX, a);

        printMinimum(arrX, arrY);
        printMaximum(arrX, arrY);
        printAverage(arrY);
        printSum(arrY);
    }



    private double enterVar(String varName) {
        double value;
        while(true){
            System.out.print("Введите значение: " + varName + " = ");
            Scanner sc = new Scanner(System.in);
            value = sc.nextDouble();
            break;
        }
        return value;
    }

    private void printSum(double[] arrY) {
        double sum = sum(arrY);
        System.out.printf("Сумма элементов: %.8f (%d элементы)\n", sum, arrY.length);
    }

    private void printMinimum(double[] arrX, double[] arrY) {
        int minI = getMinIndex(arrY);
        double x = arrX[minI];
        double y = arrY[minI];
        System.out.printf("Минимум: x = %.8f, y = %.8f\n", x, y);
    }

    private void printMaximum(double[] arrX, double[] arrY) {
        int maxI = getMaxIndex(arrY);
        double x = arrX[maxI];
        double y = arrY[maxI];
        System.out.printf("Максимум: x = %.8f, y = %.8f\n", x, y);
    }

    private void printAverage(double[] arrY) {
        double average = calcAverage(arrY);
        System.out.printf("Среднее значение: %.8f (%d элементы)\n", average, arrY.length);
    }

    double calc(double x, double a){
        double eps = 0.0000000000000004;
        if (x > a + eps)
            return x*(sqrt(x-a));

        else if (x < a + eps)
            return (exp(-a*x))*cos(a*x);

        else
            return x*sin(a*x);
    }

    int getArrSize(double initial, double terminal, double stepX){
        if (stepX <= 0) return 0;
        if (initial > terminal) return 0;
        return (int) ((terminal - initial)/stepX + 1);
    }

    double[] getArrayX(double x1, double x2, double increment){
        double[] arrX = new double[getArrSize(x1, x2, increment)];
        for(int i = 0; i<arrX.length; i++){
            arrX[i] = x1 + increment * i;
        }
        return arrX;
    }

    double[] getArrayY(double[] arrX, double a){
        double[] arrY = new double[arrX.length];
        for(int i = 0; i<arrY.length; i++){
            arrY[i] = calc(arrX[i], a);
        }
        return arrY;
    }

    double sum(double[] arrY){
        return Arrays.stream(arrY).sum();
    }

    double calcAverage(double[] arrY){
        return sum(arrY)/arrY.length;
    }

    int getMinIndex(double[] arrY){
        int minI=0;
        for(int i=0; i < arrY.length; i++) {
            if (arrY[i] < arrY[minI]) {
                minI = i;
            }
        }
        return minI;
    }

    int getMaxIndex(double[] arrY){
        int maxI=0;
        for(int i=0; i < arrY.length; i++) {
            if (arrY[i] > arrY[maxI]) {
                maxI = i;
            }
        }
        return maxI;
    }
}

/*      { x*(sqrt(x-a));                x > a;                  1 <= x <= 5;
    y = { x*sin(a*x);                   x = a;     a = 2.4      (delta)x = 0.01;
        { pow(e, -(a*x))*cos(a*x).      x < a.

        test values = 0, 140, 400.

*/