/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matricesd;

import javax.swing.JOptionPane;

/**
 *
 * @author jose-
 */
public class ListaF1 {
    private Nodo cab;

    public ListaF1(int nf, int nc) {
        cab=crearCabezas(nf,nc);
    }

    public Nodo getCab() {
        return cab;
    }
    
    public void mostrar(){
        
    }
    
    public void almacenarDato(int f, int c, float d){
        Nodo p, q, antF, antC;
        p=cab.getLiga();
        while(p!=cab && p.getFila()<f)
            p=p.getLiga();
        antF=p;
        q=p.getLigaFila();
        while(q!=p && q.getColumna()<c){
            antF=q;
            q=q.getLigaFila();
        }
        p=cab.getLiga();
        while(p!=cab && p.getColumna()<c)
            p=p.getLiga();
        antC=p;
        q=p.getLigaColumna();
        while(q!=p && q.getFila()<f){
            antC=q;
            q=q.getLigaColumna();
        }
        if(q!=p && q.getFila()==f && q.getColumna()==c){
            JOptionPane.showMessageDialog(null, "Ya existe un dato en esa posicion", "NO se puede almacenar", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            Nodo x=new Nodo(f,c,d);
            x.setLigaFila(antF.getLigaFila());
            antF.setLigaFila(x);
            x.setLigaColumna(antC.getLigaColumna());
            antC.setLigaColumna(x);
        }
    }
    
    public void insertarDato(int f, int c, float d){
        Nodo p,q,antF,antC;
        p=cab.getLiga();
        while(p!=cab && p.getFila()<f)
            p=p.getLiga();
        antF=p;
        q=p.getLigaFila();
        while(q!=p && q.getColumna()<c){
            antF=q;
            q=q.getLigaFila();
        }
        p=cab.getLiga();
        while(p!=cab && p.getColumna()<c)
            p=p.getLiga();
        antC=p;
        q=p.getLigaColumna();
        while(q!=p && q.getFila()<f){
            antC=q;
            q=q.getLigaColumna();
        }
        if(q!=p && q.getFila()==f && q.getColumna()==c){
            if(q.getDato()+d!=0)
                q.setDato(q.getDato()+d);
            else{
                antF.setLigaFila(q.getLigaFila());
                antC.setLigaColumna(q.getLigaColumna());
            }
        }
        else{
            Nodo x=new Nodo(f,c,d);
            x.setLigaFila(antF.getLigaFila());
            antF.setLigaFila(x);
            x.setLigaColumna(antC.getLigaColumna());
            antC.setLigaColumna(x);
        }
    }
    
    public void insertarEnFila(Nodo x){
        
    }
    
    public void insertarEnColumna(Nodo x){
        
    }
    
    public Nodo crearCabezas(int nf,int nc){
        Nodo p,x,ult;
        int k,n;
        if(nf>nc)
            n=nf;
        else
            n=nc;
        p=new Nodo(nf,nc,0);
        ult=p;
        for(k=1;k<=n;k++){
            x=new Nodo(k,k,0);
            x.setLigaFila(x);
            x.setLigaColumna(x);
            ult.setLiga(x);
            ult=x;
        }
        ult.setLiga(p);
        return p;
    }
    
    public void sumarFilas(){
        
    }
    
    public void promedioColumnas(){
        
    }
    
    public void mayorLista(){
        
    }
    
    public ListaF1 transpuesta(){
        return null;
    }
    
    public void eliminarDato(){
        
    }
    
    public ListaF1 sumar(ListaF1 b){
        return b;
    }
    
    public ListaF1 multiplicar(ListaF1 b){
        return b;
    }
    
    public void comparar(ListaF1 b){
        
    }
    
    public ListaF1 hacerCopia(){
        return null;
    }
}