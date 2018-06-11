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
    
    public int getNfilas() {
        return cab.getFila();
    }

    public int getNcolumnas() {
        return cab.getColumna();
    }
    
    public int getCdatos(){
        int cont=0;
        Nodo p=cab.getLiga();
        while(p!=cab){
            Nodo q=p.getLigaFila();
            while(q!=p){
                cont++;
                q=q.getLigaFila();
            }
            p=p.getLiga();        
        }
        return cont;
    }
    
    public int getFila(int i){
        if(i<=cab.getFila()){
            Nodo p=cab.getLiga();
            while(p!=cab){
                Nodo q=p.getLigaFila();
                while(q!=p){
                    if(i==q.getFila())
                        return q.getFila();
                    q=q.getLigaFila();
                }
                p=p.getLiga();
            }
        }
        return Integer.MIN_VALUE;
    }
    
    public int getColumna(int i){
        if(i<=cab.getColumna()){
            Nodo p=cab.getLiga();
            while(p!=cab){
                Nodo q=p.getLigaColumna();
                while(q!=p){
                    if(i==q.getColumna())
                        return q.getColumna();
                    q=q.getLigaColumna();
                }
                p=p.getLiga();
            }
        }
        return Integer.MIN_VALUE;
    }
    
    public float getDato(int f, int c){
        if(f<=cab.getFila() && c<=cab.getColumna()){
            Nodo p=cab.getLiga();
            while(p!=cab){
                Nodo q=p.getLigaFila();
                while(q!=p){
                    if(f==q.getFila()&&c==q.getColumna())
                        return q.getDato();
                    q=q.getLigaFila();
                }
                p=p.getLiga();
            }
            return 0;
        }
        return Float.MIN_VALUE;
    }
    
    public void setDato(int f, int c, float dato){
        
    }
    
    public void mostrar(){
        String muestre="";
        Nodo p=cab.getLiga();
        while(p!=cab){
            for(int i=0;i<=cab.getFila();i++){
                Nodo q=p.getLigaFila();
                for(int j=0;j<=cab.getColumna();j++){
                    if(i==q.getFila() && j==q.getColumna()){
                        muestre+=q.getDato()+"  ";
                        q=q.getLigaFila();
                    }
                    else
                        muestre+=0.0+"  ";  
                }
                p=p.getLiga();
                muestre+="\n";
            }
            p=cab;
        }
        JOptionPane.showMessageDialog(null, muestre, "Matriz",JOptionPane.PLAIN_MESSAGE);
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
        if(d!=0){
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
        for(k=0;k<=n;k++){
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
    
    public ListaF1 eliminar(){
        return null;
    }
    
    public ListaF1 sumar(ListaF1 b){
        if(b!=null){
            if(this.getNfilas()==b.getNfilas() && this.getNcolumnas()==b.getNcolumnas()){
                ListaF1 res=new ListaF1(b.getNfilas(),b.getNcolumnas());
                for(int i=0;i<=this.getNfilas();i++){
                    for(int j=0;j<=this.getNcolumnas();j++)
                        res.insertarDato(i, j, this.getDato(i, j)+b.getDato(i, j));
                }
            return res;
            }
            JOptionPane.showMessageDialog(null, "Las filas y columnas de la matriz no coinciden con la de la otra matriz", "No es posible sumar", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }
    
    public Tripleta sumar(ListaF2 b){
        if(b!=null){
            if(this.getNfilas()==b.getNfilas() && this.getNcolumnas()==b.getNcolumnas()){
                Tripleta res=new Tripleta(b.getNfilas(),b.getNcolumnas(),0);
                for(int i=0;i<=this.getNfilas();i++){
                    for(int j=0;j<=this.getNcolumnas();j++)
                        res.insertarTrip(i, j, this.getDato(i, j)+b.getDato(i, j));
                }
            return res;
            }
            JOptionPane.showMessageDialog(null, "Las filas y columnas de la matriz no coinciden con la de la otra matriz", "No es posible sumar", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }
    
    public ListaF2 sumar(Tripleta b){
        if(b!=null){
            if(this.getNfilas()==b.getNfilas() && this.getNcolumnas()==b.getNcolumnas()){
                ListaF2 res=new ListaF2(b.getNfilas(),b.getNcolumnas());
                for(int i=0;i<=this.getNfilas();i++){
                    for(int j=0;j<=this.getNcolumnas();j++)
                        res.insertarDato(i, j, this.getDato(i, j)+b.getDato(i, j));
                }
            return res;
            }
            JOptionPane.showMessageDialog(null, "Las filas y columnas de la matriz no coinciden con la de la otra matriz", "No es posible sumar", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
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