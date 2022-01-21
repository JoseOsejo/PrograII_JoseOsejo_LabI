/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LabPrograII_JoseOsejo;

import java.util.Scanner;

/**
 *
 * @author jcoq2
 */
public class LabI_JoseOsejo_PrograII {

    static double[][] matriz;
    static int r;
    static double epsilon;

    /* crear una matriz de NxM
    luego con un metodo mandar a que se llene con numeros aleatorios(1-100)
    luego con una funcion mandar a imprimir la matriz
    luego mediante un busqueda binaria recursiva buscar la raiz cuadrada de cada elemento 
    dentro de la matriz
    luego imprimir la matriz con otra funcion pero ya los valores con su raiz*/
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Ingrese Numero de filas: ");
        int rows = leer.nextInt();
        System.out.print("Ingrese Numero de columnas: ");
        int cols = leer.nextInt();
        System.out.print("Ingrese el valor de epsilon: ");
        epsilon = leer.nextInt();
        System.out.println("");
        System.out.println("************Matriz Generada**************");
        LabI_JoseOsejo_PrograII.crearMatriz(rows, cols);
        LabI_JoseOsejo_PrograII.printMatriz();
        System.out.println("");
        System.out.println("************Raiz Generada**************");
        LabI_JoseOsejo_PrograII.roots(matriz, epsilon);
        
    }

    public static double[][] crearMatriz(int x, int y) {
        matriz = new double[x][y];
        return matriz;
    }

    public static void printMatriz() {
        for (int row = 0; row < matriz.length; row++) {
            for (int column = 0; column < matriz[row].length; column++) {
                r = (int) (Math.random() * 100 + 1);
                matriz[row][column] = r;
                System.out.print("[" + matriz[row][column] + "] ");
            }
            System.out.println();
        }
    }

    /* public static void sqrtMatriz(){
         for (int row = 0; row < matriz.length; row++) {
            for (int column = 0; column < matriz[row].length; column++) {
                double sqrt = Math.sqrt(matriz[row][column]);
                System.out.print("["+sqrt+"] ");
            }
            System.out.println();
        }
    }*/
    public static double binSearch(double number, double rmax, double rmin, double error) {
        double rmed = 0;
        rmed = (rmax + rmin) / 2;
        double rmedCuadrado = Math.pow(rmed, 2);
        if (number - error <= rmedCuadrado && rmedCuadrado <= number + error) {
            return rmed;
        } else {
            if (rmedCuadrado < number) {
                rmin = rmed;
            } else {
                rmax = rmed;
            }
        }
        return binSearch(number, rmax, rmin, error);
    }

    public static void roots(double[][] matriz, double error) {
        double[][] matrizRaiz = new double[matriz.length][matriz[0].length];
        for (int row = 0; row < matriz.length; row++) {
            for (int col = 0; col < matriz[row].length; col++) {
                matrizRaiz[row][col] = binSearch(matriz[row][col], matriz[row][col], 0, error);
                System.out.print("["+matrizRaiz[row][col]+"] ");
            }
            System.out.println();
        }
        
    }

}
