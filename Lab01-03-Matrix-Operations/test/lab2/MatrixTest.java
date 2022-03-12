package lab2;

import java.util.Random;

import static org.junit.Assert.*;

public class MatrixTest {

    @org.junit.Test
    public void Matrix(){
        for(int i = 0; i < 10; i++){
            Matrix test  = new Matrix(i*2, i*3);
            assertArrayEquals(new int[]{i*2, i*3}, test.shape());
        }
        Matrix test2 = new Matrix(new double[][]{{2, 3, 2}, {2}, {2, 3}});

        for(int i = 0; i < 3; i++){
            assertEquals(3, test2.asArray()[i].length);
        }

        assertEquals(0, test2.get(1,1), 1e-3);
        assertEquals(0, test2.get(1,2), 1e-3);
        assertEquals(0, test2.get(2,2), 1e-3);


    }


    @org.junit.Test
    public void asArray() {
        Matrix test = new Matrix(new double[][]{{2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}, {2, 2, 2, 2}});
        for(int i = 0; i < 4; i++) {
            assertEquals(4, test.asArray()[i].length);
        }

        Matrix test2 = new Matrix(new double[][]{{2, 2, 2, 2},{},{},{}});
        for(int i = 0; i < 4; i++) {
            assertEquals(4, test.asArray()[i].length);
        }
    }

    @org.junit.Test
    public void get(){
        Matrix test = new Matrix(new double[][]{{1, 2}, {3, 4}});
        assertEquals(1.0, test.get(0,0), 0);
        assertEquals(3.0, test.get(1,0), 0);
    }

    @org.junit.Test
    public void set(){
        Matrix test = new Matrix(new double[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}});
        assertEquals(5.0, test.get(1, 1), 0);
        test.set(1, 1, 15.0);
        assertEquals(15.0, test.get(1, 1), 0);
    }

    @org.junit.Test
    public void testToString() {
        Matrix test = new Matrix(new double[][]{{1, 1, 1, 1}, {2, 2,}, {3}, {4}});
        assertEquals("[[ 1.0,  1.0,  1.0,  1.0 ],\n" +
                "[ 2.0,  2.0,  0.0,  0.0 ],\n" +
                "[ 3.0,  0.0,  0.0,  0.0 ],\n" +
                "[ 4.0,  0.0,  0.0,  0.0 ]]", test.toString());


        //String s= "[[1.0,2.3,4.56], [12.3,  45, 21.8]]";
        String s = test.toString();
        s= s.replaceAll("(\\[|\\]|\\s\\n)+","");
        String[] t = s.split("(,)+");
        for(String x:t){
            System.out.println(String.format("\'%s\'",x ));
        }

        double[]d=new double[t.length];
        for(int i=0;i<t.length;i++) {
            d[i] = Double.parseDouble(t[i]);
        }

        double arr[][]=new double[1][];
        arr[0]=d;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.println(arr[i][j]);
            }
        }

    }

    @org.junit.Test
    public void reshape(){
        Matrix test = new Matrix(new double[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}});
        try{
            test.reshape(2, 4);
        }
        catch(Exception a){
            return;
        }
        fail();
    }

    @org.junit.Test
    public void shape() {
        //Matrix test = new Matrix(new double[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}});
        for(int i = 0; i < 10; i++){
            Matrix test = new Matrix(4*i, 4*i);
            assertArrayEquals(new int[]{4*i, 4*i}, test.shape());
        }

    }

    @org.junit.Test
    public void add() {
        for(int i = 0; i < 20; i++){
            Matrix m1 = new Matrix(new double[][]{{i*9, i*8, i*7}, {i*6, i*5, i*4}, {i*3, i*2, i*1}});
            Matrix m2 = new Matrix(new double[][]{{i+1, i+2, i+3}, {i+4, i+5, i+6}, {i+7, i+8, i+9}});
            double[][] res = new double[3][3];
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++)
                    res[j][k] = m1.get(j, k) + m2.get(j, k);
            }
            assertArrayEquals(res, m1.add(m2).asArray());
        }

    }

    @org.junit.Test
    public void sub() {
        for(int i = 0; i < 20; i++){
            Matrix m1 = new Matrix(new double[][]{{i*9, i*8, i*7}, {i*6, i*5, i*4}, {i*3, i*2, i*1}});
            Matrix m2 = new Matrix(new double[][]{{i+1, i+2, i+3}, {i+4, i+5, i+6}, {i+7, i+8, i+9}});
            double[][] res = new double[3][3];
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++)
                    res[j][k] = m1.get(j, k) - m2.get(j, k);
            }
            assertArrayEquals(res, m1.sub(m2).asArray());
        }
    }

    @org.junit.Test
    public void mul() {
        for(int i = 0; i < 20; i++){
            Matrix m1 = new Matrix(new double[][]{{i*9, i*8, i*7}, {i*6, i*5, i*4}, {i*3, i*2, i*1}});
            Matrix m2 = new Matrix(new double[][]{{i+1, i+2, i+3}, {i+4, i+5, i+6}, {i+7, i+8, i+9}});
            double[][] res = new double[3][3];
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++)
                    res[j][k] = m1.get(j, k) * m2.get(j, k);
            }
            assertArrayEquals(res, m1.mul(m2).asArray());
        }
    }

    @org.junit.Test
    public void div() {
        for(int i = 0; i < 20; i++){
            Matrix m1 = new Matrix(new double[][]{{i*9, i*8, i*7}, {i*6, i*5, i*4}, {i*3, i*2, i*1}});
            Matrix m2 = new Matrix(new double[][]{{i+1, i+2, i+3}, {i+4, i+5, i+6}, {i+7, i+8, i+9}});
            double[][] res = new double[3][3];
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++)
                    res[j][k] = m1.get(j, k) / m2.get(j, k);
            }
            assertArrayEquals(res, m1.div(m2).asArray());
        }
    }

    @org.junit.Test
    public void testAdd() {
        for(int i = 0; i < 20; i++){
            Matrix m1 = new Matrix(new double[][]{{i*9, i*8, i*7}, {i*6, i*5, i*4}, {i*3, i*2, i*1}});
            double[][] res = new double[3][3];
            Random r = new Random();
            double s = r.nextDouble();
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++)
                    res[j][k] = m1.get(j, k) + s;
            }
            assertArrayEquals(res, m1.add(s).asArray());
        }
    }

    @org.junit.Test
    public void testSub() {
        for(int i = 0; i < 20; i++){
            Matrix m1 = new Matrix(new double[][]{{i*9, i*8, i*7}, {i*6, i*5, i*4}, {i*3, i*2, i*1}});
            double[][] res = new double[3][3];
            Random r = new Random();
            double s = r.nextDouble();
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++)
                    res[j][k] = m1.get(j, k) - s;
            }
            assertArrayEquals(res, m1.sub(s).asArray());
        }
    }

    @org.junit.Test
    public void testMul() {
        for(int i = 0; i < 20; i++){
            Matrix m1 = new Matrix(new double[][]{{i*9, i*8, i*7}, {i*6, i*5, i*4}, {i*3, i*2, i*1}});
            double[][] res = new double[3][3];
            Random r = new Random();
            double s = r.nextDouble();
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++)
                    res[j][k] = m1.get(j, k) * s;
            }
            assertArrayEquals(res, m1.mul(s).asArray());
        }
    }

    @org.junit.Test
    public void testDiv() {
        for(int i = 0; i < 20; i++){
            Matrix m1 = new Matrix(new double[][]{{i*9, i*8, i*7}, {i*6, i*5, i*4}, {i*3, i*2, i*1}});
            double[][] res = new double[3][3];
            Random r = new Random();
            double s = r.nextDouble();
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++)
                    res[j][k] = m1.get(j, k) / s;
            }
            assertArrayEquals(res, m1.div(s).asArray());
        }
    }

    @org.junit.Test
    public void dot() {
        Matrix m1 = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6,}});
        Matrix m2 = new Matrix(new double[][]{{10, 11}, {20, 21}, {30, 31}});
        double [][] res = new double[][]{{140, 146}, {320, 335}};
        assertArrayEquals(res, m1.dot(m2).asArray());
    }

    @org.junit.Test
    public void frobenius() {
        Matrix test = new Matrix(new double[][]{{1, 1, 1}, {3, 3, 3}, {2, 2, 2}});
        assertEquals(Math.sqrt(1+1+1+3*3+3*3+3*3+2*2+2*2+2*2), test.frobenius(), 1e-4);
    }

    @org.junit.Test
    public void random() {
        for(int i = 1; i < 10; i++) {
            Matrix test = Matrix.random(i, i*2);

            assertArrayEquals(new int[]{i, i*2}, test.shape());
        }

    }

    @org.junit.Test
    public void eye() {
        for(int i = 0; i < 20; i++) {
            Matrix test = Matrix.eye(i);

            assertEquals(Math.sqrt(i), test.frobenius(), 1e-4);
        }
    }

    @org.junit.Test
    public void determinant() {
    }
}