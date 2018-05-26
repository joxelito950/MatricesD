/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricesd;

import javax.swing.JOptionPane;

/**
 *
 * @author sala311
 */
public class ListaF2 {
    private Nodo cabeza;

    public ListaF2(int nf, int nc) {
        cabeza = new Nodo(nf,nc,0);
        cabeza.setLigaFila(cabeza);
        cabeza.setLigaColumna(cabeza);
    }
    
    public void mostrar(){
        String muestra="";
        Nodo p=cabeza.getLigaFila();
        while(p!=cabeza){
            muestra=muestra+p.getDato();
            p=p.getLigaFila();        }
        JOptionPane.showMessageDialog(null, muestra, "Datos diferentes de cero en la matriz", JOptionPane.PLAIN_MESSAGE);
    }

    public void almacenarDato(int f, int c, float d){
        Nodo p=cabeza.getLigaFila(), q, antF=cabeza, antC=cabeza;
        while(p!=cabeza && p.getFila()<f){
            antF=p;
            p=p.getLigaFila();
        }
        while(p!=cabeza && p.getFila()==f && p.getColumna()<c){
            antF=p;
            p=p.getLigaFila();
        }
        p=cabeza.getLigaColumna();
        while(p!=cabeza && p.getColumna()<c){
            antC=p;
            p=p.getLigaColumna();
        }
        while(p!=cabeza && p.getColumna()==c && p.getFila()<f){
            antC=p;
            p=p.getLigaColumna();
        }
        if(p!=cabeza && p.getColumna()==c && p.getFila()==f)
            JOptionPane.showMessageDialog(null, "El Dato "+p.getDato()+" ya existe en la posicion", "Ya existe un dato", JOptionPane.INFORMATION_MESSAGE);
        else{
            Nodo x=new Nodo(f,c,d);
            x.setLigaFila(antF.getLigaFila());
            antF.setLigaFila(x);
            x.setLigaColumna(p);
            antC.setLigaColumna(x);
        }
    }
    
    public void insertarDato(int f, int c, float d){
        Nodo p=cabeza.getLigaFila(), q, antF=cabeza, antC=cabeza;
        while(p!=cabeza && p.getFila()<f){
            antF=p;
            p=p.getLigaFila();
        }
        while(p!=cabeza && p.getFila()==f && p.getColumna()<c){
            antF=p;
            p=p.getLigaFila();
        }
        p=cabeza.getLigaColumna();
        while(p!=cabeza && p.getColumna()<c){
            antC=p;
            p=p.getLigaColumna();
        }
        while(p!=cabeza && p.getColumna()==c && p.getFila()<f){
            antC=p;
            p=p.getLigaColumna();
        }
        if(p!=cabeza && p.getColumna()==c && p.getFila()==f){
            if(p.getDato()+d!=0)
                p.setDato(p.getDato()+d);
            else{
                antF.setLigaFila(p.getLigaFila());
                antC.setLigaColumna(p.getLigaColumna());
            }
        }
        else{
            Nodo x=new Nodo(f,c,d);
            x.setLigaFila(antF.getLigaFila());
            antF.setLigaFila(x);
            x.setLigaColumna(p);
            antC.setLigaColumna(x);
        }
    }

    public float[] sumarFilas(){
        Nodo p=cabeza.getLigaFila();
        float[] sum= new float[cabeza.getColumna()];
        while(p!=cabeza){
            sum[p.getColumna()]=sum[p.getColumna()]+p.getDato();
            p=p.getLigaFila();
        }
        return sum;
    }
    
    public void promedioCol(){
        float sum[]=sumarFilas();
        for(int k=1; k<=cabeza.getColumna();k++)
            JOptionPane.showMessageDialog(null, sum[k-1]/cabeza.getFila(), "Promedio columna "+k, JOptionPane.PLAIN_MESSAGE);
    }
    
    public float mayormdLista(){
        float mayor=Float.MIN_VALUE;
        
        return mayor;
    }
    
    public ListaF2 sumar(ListaF2 b){
        return b;
    }
    
    public ListaF2 multiplicar(ListaF2 b){
        return b;
    }
    
    public boolean comparar(ListaF2 b){
        return false;
    }
    
    public ListaF2 copia(){
        ListaF2 r=new ListaF2(cabeza.getFila(),cabeza.getColumna());
        return r;
    }
}   