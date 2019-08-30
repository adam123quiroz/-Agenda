package com.company;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        System.out.print("Cantidad de numeros que desea generar");
        int a = leer.nextInt();
        fibo(a);
	factorial(a);
    numeroPrimo(a);
    }

    public static void fibo(int a){
        Scanner leer = new Scanner(System.in);
        int n, f = 0;
        int t1 = 1;
        int t2;
        for(int i = 1 ; i <= a; i++){
            t2 = f;
            f = t1 + f;
            t1 = t2;
            System.out.println(t1);
        }
    }

    public static int factorial(int numero){
        if (numero == 0) return 1;
	else return numero * factorial(numero-1); 
    }
    public static boolean numeroPrimo(int numero){
        int contador = 0;
        for(int I = 1; I <= numero; I++)
        {

            if((numero % I) == 0)
            {
                contador++;
            }
        }
        if(contador <= 2)
        {

return true;

        }else{

            return false;
        }

    }

}
