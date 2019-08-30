package com.company;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        FrameContacto frame = new FrameContacto();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void fibo(int a){
        Scanner leer = new Scanner(System.in);
        int n, f = 0;
        int t1 = 1;
        int t2;
        System.out.print("Cantidad de numeros que desea generar");
        n = leer.nextInt();
        for(int i)
    }
    public class numeroPrimo
{
    public static void main(String[] ARGS)
    {
        Scanner obtenerNumero = new Scanner(System.in);
        int contador,I,numero;
        System.out.print("Ingresa un numero: ");
        numero = obtenerNumero.nextInt();
        contador = 0;
        for(I = 1; I <= numero; I++)
        {

            if((numero % I) == 0)
            {
                contador++;
            }
        }
        if(contador <= 2)
        {

            System.out.println("El numero es primo");

        }else{

            System.out.println("El numero no es primo");
        }
    }

}

}
