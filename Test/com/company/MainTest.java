package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private Main test;
    private final double DELTA = 1e-14;

    @BeforeEach
    void setUp() {
        test = new Main();
    }

    @Test
    // x > a
    void calcTest_more(){
        double expected = 3.943602414037197;
        double result = test.calc(3.6, 2.4 );
        assertEquals(expected,result, DELTA);
    }

    @Test
        // x < a
    void calcTest_less(){
        double expected = -0.020291934949292052;
        double result = test.calc(1.2, 3.1 );
        assertEquals(expected,result, DELTA);
    }

    @Test
        // x = a
    void calcTest_equal(){
        double expected = -1.1991405194805658;
        double result = test.calc(2.4, 2.4 );
        assertEquals(expected,result, DELTA);
    }

    @Test
    void getArrSizeTest_1(){
        int expected = 0;
        int result = test.getArrSize(1, 2, 0);
        assertEquals(expected, result, "Should return 0 if stepX <= 0 ");
    }

    @Test
    void getArrSizeTest_2(){
        int expected = 0;
        int result = test.getArrSize(4, 3, 0.45);
        assertEquals(expected, result, "Should return 0 if x1 > x2");
    }

    @Test
    void getArrSizeTest_3(){
        int expected = 4;
        int result = test.getArrSize(1, 2.5, 0.45);
        assertEquals(expected, result);
    }

    @Test
    void getArrayXTest_1(){
        double[] arrX;
        arrX = test.getArrayX(1,5,0.01);
        assertEquals(1,arrX[0]);
    }

    @Test
    void getArrayXTest_2(){
        double[] arrX;
        arrX = test.getArrayX(1,5,0.01);
        assertEquals(2.4000000000000004,arrX[140]);
    }

    @Test
    void getArrayXTest_3(){
        double[] arrX;
        arrX = test.getArrayX(1,5,0.01);
        assertEquals(5,arrX[400]);
    }

    @Test
    void getArrayYTest_1(){
        double[] arrX, arrY;
        arrX = test.getArrayX(1,5,0.01);
        arrY = test.getArrayY(arrX,2.4);
        double expected = -0.06689484864237705;
        double result = arrY[0];
        assertEquals(expected, result, DELTA);
    }

    @Test
    void getArrayYTest_2(){
        double[] arrX, arrY;
        arrX = test.getArrayX(1,5,0.01);
        arrY = test.getArrayY(arrX,2.4);
        double expected = -1.1991405194805642;
        double result = arrY[140];
        assertEquals(expected, result, DELTA);
    }

    @Test
    void getArrayYTest_3(){
        double[] arrX, arrY;
        arrX = test.getArrayX(1,5,0.01);
        arrY = test.getArrayY(arrX,2.4);
        double expected = 8.062257748298551;
        double result = arrY[400];
        assertEquals(expected, result, DELTA);
    }

    @Test
    void sumTest(){
        double[] arr = {-0.3434757428, 0.235564654, 1.35465443, 5,723905656};
        double expected = 7.239056622467433E8;
        double result = test.sum(arr);
        System.out.println(result);
        assertEquals(expected, result, DELTA);
    }

    @Test
    void calcAverageTest(){
        double[] arr = {1, 5, 6};
        double expected = 4.0;
        double result = test.calcAverage(arr);
        assertEquals(expected, result, DELTA);
    }

    @Test
    void getMinIndexTest(){
        double[] arr = {-0.24065, 0.54322, 1.55403, 23.54421, -4.51332, 34.66532};
        int expected = 4;
        int result = test.getMinIndex(arr);
        assertEquals(expected, result, DELTA);
    }

    @Test
    void getMaxIndexTest(){
        double[] arr = {-0.24065, 0.54322, 1.55403, 23.54421, -4.51332, 34.66532};
        int expected = 5;
        int result = test.getMaxIndex(arr);
        assertEquals(expected, result, DELTA);
    }
}