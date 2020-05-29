/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoso;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author danie
 */
public class ProyectoSO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int n;
        Scanner keyboard = new Scanner(System.in);
        
        String[] nombreProceso;//= new String []{"P1","P2","P3","P4","P5","P6"};
        int[] tiempoLlegada;// = new int[]{16, 4, 18, 12, 1, 6};
        int[] rafagaCpu;// = new int[]{6, 14, 8, 2, 11, 66};
        
        System.out.printf("Cantidad de procesos a evaluar: ");
        n= keyboard.nextInt();
        nombreProceso=new String[n];
        tiempoLlegada= new int[n];
        rafagaCpu= new int[n];
        
        for (int i = 0; i < n; i++) {
            System.out.printf("Proceso %d\n",i);
            nombreProceso[i]=String.format("P%d", i);
            System.out.printf("Tiempo de llegada Proceso %d: ", i);
            tiempoLlegada[i]=keyboard.nextInt();
            System.out.printf("Rafaga de CPU Proceso %d: ", i);
            rafagaCpu[i]=keyboard.nextInt();
        }
        
        Metodos metodo= new Metodos(nombreProceso,tiempoLlegada,rafagaCpu);
        
        System.out.println("Procesos Ingresados:\n"
                + "Pro\tTiempo\tRafaga");
        for (int i = 0; i < tiempoLlegada.length; i++) {
            System.out.printf("%2s:\t[%2d]\t[%2d]\n",nombreProceso[i],tiempoLlegada[i],rafagaCpu[i]);
        }
        
        metodo.Ordenar();
        metodo.toString();
        metodo.TiempoRetorno();
        metodo.TiempoEspera();
        System.out.println("");
        System.out.println("Grafica Tiempo Retorno:");
        metodo.PresentarRetorno();
        System.out.println("");
        System.out.println("Tiempo Medio Retorno");
        metodo.PresentarTMR();
        System.out.println("");
        System.out.println("Tiempo Medio Espera");        
        metodo.PresentarTME();
    }

}
