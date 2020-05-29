/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoso;

import java.util.Arrays;

/**
 *
 * @author danie
 */
public class Metodos {
    String[] nombreProceso;
    int[] tiempoLlegada;
    int[] rafagaCpu;
    int[] tiempoRetorno;
    int[] tiempoEspera;
    
    public Metodos(String[] nombreProceso, int[] tiempoLlegada, int[] rafagaCpu) {
        this.nombreProceso = nombreProceso;
        this.tiempoLlegada = tiempoLlegada;
        this.rafagaCpu = rafagaCpu;
        this.tiempoRetorno =new int[this.rafagaCpu.length+1];
        this.tiempoEspera =new int[this.rafagaCpu.length];
    }

    
    public void Ordenar(){
        int tmp = 0;
        String aux="";
        for (int j = 1; j < tiempoLlegada.length; j++) {
            for (int i = 0; i < tiempoLlegada.length - 1; i++) {
                if (tiempoLlegada[i] > tiempoLlegada[i + 1]) {
                    tmp = tiempoLlegada[i];
                    tiempoLlegada[i] = tiempoLlegada[i + 1];
                    tiempoLlegada[i + 1] = tmp;
                    
                    tmp = rafagaCpu[i];
                    rafagaCpu[i] = rafagaCpu[i + 1];
                    rafagaCpu[i + 1] = tmp;
                    
                    aux=nombreProceso[i];
                    nombreProceso[i]=nombreProceso[i+1];
                    nombreProceso[i+1]=aux;
                }
                
            }
        }
    }
    
    public void TiempoEspera(){
        for (int i = 0; i < tiempoEspera.length; i++) {
            tiempoEspera[i]=tiempoRetorno[i]-tiempoLlegada[i];
        }
    }
    
    public String PresentarTME(){
        String s="";
        double suma=0;
        for (int i = 0; i < tiempoEspera.length; i++) {
            suma+=tiempoEspera[i];
            s+=System.out.printf("%2s %2d\n",nombreProceso[i],tiempoEspera[i]);
        }
        s+=System.out.printf("_________\n   %2.2f\n",(suma/tiempoEspera.length));
        return s;
    }
    
    public void TiempoRetorno(){
        tiempoRetorno[0]=tiempoLlegada[0];
        for (int i = 0; i < this.rafagaCpu.length; i++) {
            tiempoRetorno[i+1]=tiempoRetorno[i]+rafagaCpu[i];            
        }        
    }
    
    public String PresentarTMR(){
        String s="";
        double suma=0;
        
        for (int i = 0; i < this.rafagaCpu.length; i++) {
            suma+=tiempoRetorno[i+1];
            s+=System.out.printf("%2s %2d\n",nombreProceso[i],tiempoRetorno[i+1]);
        }
        s+=System.out.printf("_________\n   %2.2f\n",(suma/rafagaCpu.length));
        return s;
    }
    
    public String PresentarRetorno(){
        String s="";
        s+=System.out.printf("%3d\n",tiempoRetorno[0]);
        for (int i = 0; i < rafagaCpu.length; i++) {
            s+=System.out.printf("%3d %3s\n",tiempoRetorno[i+1],nombreProceso[i]);
        }
        return s;
    }
    
    @Override
    public String toString(){
        String s="";
        System.out.println("\n Ordenado\n"
                + "Pro\tTiempo\tRafaga");
        for (int i = 0; i < tiempoLlegada.length; i++) {
            s+=System.out.printf("%2s: \t[%2d]\t[%2d]\n",nombreProceso[i],tiempoLlegada[i],rafagaCpu[i]);
        }
        return s;
    }
    
}
