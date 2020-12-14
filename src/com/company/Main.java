package com.company;

public class Main {

    public static void main(String[] args) {
        int[] test = { 5,10,3,12,5,50,6};
        System.out.println("answer: "+mat(test));
    }
    public static int mat(int [] p){
        int [][]m=new int[p.length-1][p.length-1];//двумерный массив для промежуточных результатов
        int n=p.length-1; //кол-во матриц
        //O(n^2) памяти
        for (int i = 0; i < n; i++) {
            m[i][i]=0;
        }
        //O(n^3)
        for (int l = 1; l < n; l++) {//смещение на один элемент вправо
            for (int i = 0; i < n-l; i++) {
                int j=i+l; //вторая координата для ориентации в массиве
                m[i][j]=Integer.MAX_VALUE;//задаём изначальное значение
                for (int k = i; k < j; k++) {
                    m[i][j]=Math.min(m[i][j], m[i][k]+m[k+1][j]+p[i]*p[k+1]*p[j+1]);
                    if(i==0 && l==n-1)//что то же самое что i==0 && l==n-1 т.к. последний m[i][j]
                        System.out.println( m[i][k]+m[k+1][j]+p[i]*p[k+1]*p[j+1]);
                }
            }
        }
        return m[0][n-1];
    }
}
