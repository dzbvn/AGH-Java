package lab2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {

        Matrix m1 = new Matrix(new double[][]{{1,2,3,4},{5,6},{7,8},{9}});
        //#test asArray()
        double[][] temp = m1.asArray();
        for(int i = 0; i < temp.length; i++){
            for(int j = 0; j < temp[i].length; j++){
                System.out.printf("%f ",temp[i][j]);
            }
            System.out.print("\n");
        }

        //#test get & set
        System.out.println(m1.get(0,0));
        m1.set(0,0,2);
        System.out.println(m1.get(0,0));

        //#test toString()
        System.out.println(m1.toString());

        //#test reshape()
        m1.reshape(2, 8);
        System.out.println(m1.toString());

        //#test shape()
        System.out.println(Arrays.toString(m1.shape()));

        //#test add(), sub(), mul(), div()
        m1.reshape(4,4);
        Matrix m2 = new Matrix(new double[][]{{7,8,1,1},{9,10},{11,12}, {1}});
        System.out.println(m1.toString());
        System.out.println(m2.toString());
        System.out.println(m1.add(m2));
        System.out.println(m1.sub(m2));
        System.out.println(m1.mul(m2));
        System.out.println(m1.div(m2));

        //#test add(), sub(), mul(), div() skalary
        System.out.println(m1.toString());
        System.out.println(m1.add(2));
        System.out.println(m1.sub(2));
        System.out.println(m1.mul(2));
        System.out.println(m1.div(2));

        //#test mnozenie macierzy
        Matrix m3 = new Matrix(new double[][]{{2, 1, 3},{-1, 4, 0}});
        Matrix m4 = new Matrix(new double[][]{{1, 3, 2},{-2, 0, 1},{5, -3, 2}});
        System.out.println(m3.dot(m4));

        //#test frobenius()
        System.out.println(m1.frobenius());

        //#test random() & eye()
        Matrix r = Matrix.random(2,3);
        System.out.println(r.toString());

        Matrix e = Matrix.eye(3);
        System.out.println(e.toString());

        Matrix m5 = new Matrix(new double[][]{{2, 1, 3},{-1, 4, 0}, {2, 4, 2}});
        System.out.println(m5.toString());
        m5.determinant();
    }
}
