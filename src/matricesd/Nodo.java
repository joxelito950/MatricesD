/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricesd;

/**
 *
 * @author jose-
 */
public class Nodo {
    private int fila,columna;
    private float dato;
    private Nodo liga, ligaFila, ligaColumna;
    
    public Nodo(int f,int c, float d){
        fila=f;
        columna=c;
        dato=d;
        liga=null;
        ligaFila=null;
        ligaColumna=null;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public float getDato() {
        return dato;
    }

    public void setDato(float dato) {
        this.dato = dato;
    }

    public Nodo getLiga() {
        return liga;
    }

    public void setLiga(Nodo liga) {
        this.liga = liga;
    }

    public Nodo getLigaFila() {
        return ligaFila;
    }

    public void setLigaFila(Nodo ligaFila) {
        this.ligaFila = ligaFila;
    }

    public Nodo getLigaColumna() {
        return ligaColumna;
    }

    public void setLigaColumna(Nodo ligaColumna) {
        this.ligaColumna = ligaColumna;
    }
    
}
