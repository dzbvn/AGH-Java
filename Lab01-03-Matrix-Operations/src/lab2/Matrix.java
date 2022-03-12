package lab2;
import java.util.Arrays;
import java.lang.Math;
import java.util.Random;

public class Matrix {
    double[]data;
    int rows;
    int cols;

    Matrix(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        data = new double[rows*cols];
    }

    Matrix(double[][] d){
        if(d.length == 0){
            throw new RuntimeException("Array is empty");
        }
        int maxRow = Arrays.stream(d).map(row -> row.length).max(Integer::compare).get();
        data = new double[maxRow*d.length];
        this.cols = maxRow;
        this.rows = d.length;

        for(int i = 0; i < d.length; i++){
            for(int j = 0; j < d[i].length; j++) {
                data[i * maxRow + j] = d[i][j];
            }
        }
    }

    double[][] asArray(){
        double[][] res = new double[this.rows][this.cols];
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < this.cols; j++){
                res[i][j] = this.data[j + i * this.cols];
            }
        }
        return res;
    }
    double get(int r, int c){
        return data[r * cols + c];
    }
    void set(int r, int c, double value){
        data[r * cols + c] = value;
    }
    public String toString(){
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        for(int i=0;i<rows;i++){
            buf.append("[");
            for(int j = 0; j < cols; j++){
                buf.append(" ");
                buf.append(data[i*cols + j]);
                if(j != cols - 1) {
                    buf.append(", ");
                }
                else{
                    buf.append(" ");
                }
            }
            if(i == rows - 1){
                buf.append("]");
            }
            else {
                buf.append("],\n");
            }
        }
        buf.append("]");
        return buf.toString();
    }
    void reshape(int newRows,int newCols){
        if(rows*cols != newRows*newCols)
            throw new RuntimeException(String.format("%d x %d matrix can't be reshaped to %d x %d",rows,cols,newRows,newCols));
        this.cols = newCols;
        this.rows = newRows;
    }
    int[] shape(){
        return new int[]{rows, cols};
    }

    Matrix add(Matrix m){
        if(this.rows != m.rows || this.cols != m.cols){
            throw new RuntimeException("Dimension error");
        }

        double[][] res = new double[this.rows][this.cols];
        for(int i = 0; i < this.rows; i++){

            for(int j = 0; j < this.cols; j++){
                res[i][j] = this.get(i, j) + m.get(i, j);
            }
        }
        Matrix resM = new Matrix(res);
        return resM;
    }

    Matrix sub(Matrix m){
        if(this.rows != m.rows || this.cols != m.cols){
            throw new RuntimeException("Dimension error");
        }

        double[][] res = new double[this.rows][this.cols];
        for(int i = 0; i < this.rows; i++){

            for(int j = 0; j < this.cols; j++){
                res[i][j] = this.get(i, j) - m.get(i, j);
            }
        }
        return new Matrix(res);
    }

    Matrix mul(Matrix m){
        if(this.rows != m.rows || this.cols != m.cols){
            throw new RuntimeException("Dimension error");
        }

        double[][] res = new double[this.rows][this.cols];
        for(int i = 0; i < this.rows; i++){

            for(int j = 0; j < this.cols; j++){
                res[i][j] = this.get(i, j) * m.get(i, j);
            }
        }
        return new Matrix(res);
    }

    Matrix div(Matrix m){
        if(this.rows != m.rows || this.cols != m.cols){
            throw new RuntimeException("Dimension error");
        }

        double[][] res = new double[this.rows][this.cols];
        for(int i = 0; i < this.rows; i++){

            for(int j = 0; j < this.cols; j++){
                res[i][j] = this.get(i, j) / m.get(i, j);
            }
        }
        return new Matrix(res);
    }

    Matrix add(double w){

        double[][] res = new double[this.rows][this.cols];
        for(int i = 0; i < this.rows; i++){

            for(int j = 0; j < this.cols; j++){
                res[i][j] = this.get(i, j) + w;
            }
        }
        return new Matrix(res);
    }

    Matrix sub(double w){

        double[][] res = new double[this.rows][this.cols];
        for(int i = 0; i < this.rows; i++){

            for(int j = 0; j < this.cols; j++){
                res[i][j] = this.get(i, j) - w;
            }
        }
        return new Matrix(res);
    }

    Matrix mul(double w){

        double[][] res = new double[this.rows][this.cols];
        for(int i = 0; i < this.rows; i++){

            for(int j = 0; j < this.cols; j++){
                res[i][j] = this.get(i, j) * w;
            }
        }
        return new Matrix(res);
    }

    Matrix div(double w){

        double[][] res = new double[this.rows][this.cols];
        for(int i = 0; i < this.rows; i++){

            for(int j = 0; j < this.cols; j++){
                res[i][j] = this.get(i, j) / w;
            }
        }
        return new Matrix(res);
    }

    Matrix dot(Matrix m){
        if(this.cols != m.rows){
            throw new RuntimeException("Dimensions error");
        }
        double[][] res = new double[this.rows][m.cols];
        for(int i = 0; i < this.rows; i++){
            for(int j = 0; j < m.cols; j++) {
                res[i][j] = 0;
                for(int k = 0; k < m.rows; k++) {
                    res[i][j] += this.data[k + i * this.cols] * m.data[k * m.cols + j];
                }
            }
        }
        return new Matrix(res);
    }
    double frobenius(){
        double res = 0;

        for(int i = 0; i < this.data.length; i++){
            res += Math.pow(this.data[i], 2);
        }
        return Math.sqrt(res);
    }

    public static Matrix random(int rows, int cols){
        Matrix m = new Matrix(rows,cols);
        Random r = new Random();
        //m.set(0,0,r.nextDouble());
        for(int i = 0; i < m.data.length; i++){
            m.data[i] = r.nextDouble();
        }
        /*for(int i = 0; i < m.rows; i++){
            for(int j = 0; j < m.cols; j++){
                m.set(i, j, r.nextDouble());
            }
        }*/
        return m;
    }

    public static Matrix eye(int n){
        Matrix m = new Matrix(n, n);
        for(int i = 0; i < n; i++){
            m.data[i + i * n] = 1;
        }
        return m;
    }

    double determinant(){
        int r = 99999;
        for(int k = 0; k < this.cols; k++) {
            for (int i = 0; i < this.rows; i++) {

                if (this.get(i, k) == 1) {
                    r = i;
                }
            }
            if (r >= this.rows) {
                r = 0;
                double temp = this.data[k];
                for (int i = 0; i < this.asArray()[k].length; i++) {
                    this.data[i] /= temp;
                }
            }

            for (int i = 0; i < this.rows; i++) {
                if (i != r) {
                    double temp2 = this.data[i * this.cols];
                    System.out.println(this.toString());
                    for (int j = 0; j < this.cols; j++) {
                        System.out.println(this.data[i * this.cols + j]);
                        this.data[i * this.cols + j] -= this.data[j] * temp2;
                        System.out.println(this.data[j]);
                        //System.out.println(temp2);
                        //System.out.println(this.data[i * this.cols + j]);
                    }
                }

            }
        }
        System.out.println(this.toString());

        return 2.3;
    }
}


