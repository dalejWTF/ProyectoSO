/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.util.ArrayList;


/**
 *
 * @author SMART
 */
public class Fifo {

    private int cantidadPaginas;
    private int cantidadFrames;
    ArrayList<Integer> pagina;
    int[][] matriz;
    int[] fallos;
    int auxiliar = 0;
    int cantidadFallos=0;

    //Constructor
    public Fifo(int cantidadPaginas, int cantidadFrames, ArrayList<Integer> pagina) {
        this.cantidadPaginas = cantidadPaginas;
        this.cantidadFrames = cantidadFrames;
        this.pagina = pagina;
        
    }
    
    //Getters y Setters
    public ArrayList<Integer> getPagina() {
        return pagina;
    }

    public void setPagina(ArrayList<Integer> pagina) {
        this.pagina = pagina;
    }

    
    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int getCantidadPaginas() {
        return cantidadPaginas;
    }

    public void setCantidadPaginas(int cantidadPaginas) {
        this.cantidadPaginas = cantidadPaginas;
    }

    public int getCantidadFrames() {
        return cantidadFrames;
    }

    public void setCantidadFrames(int cantidadFrames) {
        this.cantidadFrames = cantidadFrames;
    }

    public int getCantidadFallos() {
        return cantidadFallos;
    }

    public void setCantidadFallos(int cantidadFallos) {
        this.cantidadFallos = cantidadFallos;
    }

    public int[] getFallos() {
        return fallos;
    }

    public void setFallos(int[] fallos) {
        this.fallos = fallos;
    }
    
    
    //Se rellena el Array a 0
    public void iniciarxfallos() {
        for (int i = 0; i < cantidadPaginas; i++) {
            fallos[i] = 0;
        }
    }

    public void siguiente() {
        auxiliar++;
        if (auxiliar == cantidadFrames) {//si llega al final de los frames regresa al primer frame
            auxiliar = 0;
        }
    }

    public boolean buscar(int paginaAcutal) {
        boolean bandera = false;
        for (int j = 0; j < cantidadFrames; j++) {
            //recorre todos los frames de una pagina determinada
            if (pagina.get(paginaAcutal) == matriz[j][paginaAcutal]) {
                //si el valor de la pagina actual existe en algun frame la bandera se le asigna verdadero
                bandera = true;
            }
        }
        return bandera;
    }
    
    //Se compara si existe en la pagina actual sino pasa
    public void modificar(boolean encontrado, int paginaActual) {
        if (!encontrado) {
            for (int aux = paginaActual; aux < cantidadPaginas; aux++) {
                matriz[auxiliar][aux] = pagina.get(paginaActual);
                fallos[paginaActual] = 1;
            }
            siguiente();
        }
    }

    public void fifo() {
        matriz = new int[cantidadFrames][cantidadPaginas];
        fallos = new int[cantidadPaginas];
        iniciarxfallos();
        for (int i = 0; i < cantidadPaginas; i++) {
            modificar(buscar(i), i);
        }
        TotalFallos();
    }

    public void TotalFallos() {
        cantidadFallos = 0;
        for (int i = 0; i < cantidadPaginas; i++) {
            if (fallos[i] == 1) {
                cantidadFallos++;
            }
        }
    }
}
