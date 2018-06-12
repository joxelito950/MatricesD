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
    
    public int getNfilas() {
        return cabeza.getFila();
    }

    public int getNcolumnas() {
        return cabeza.getColumna();
    }
    
    public int getCdatos(){
        int cont=0;
        Nodo p=cabeza.getLigaFila();
        while(p!=cabeza){
            cont++;
            p=p.getLigaFila();        
        }
        return cont;
    }
    
    public int getFila(int i){
        if(i<=cabeza.getFila()){
            Nodo p=cabeza.getLigaFila();
            while(p!=cabeza){
                if(i==p.getFila())
                    return p.getFila();
                p=p.getLigaFila();
            }
        }
        return Integer.MIN_VALUE;
    }
    
    public int getColumna(int i){
        if(i<=cabeza.getColumna()){
            Nodo p=cabeza.getLigaColumna();
            while(p!=cabeza){
                if(i==p.getColumna())
                    return p.getColumna();
                p=p.getLigaColumna();
            }
        }
        return Integer.MIN_VALUE;
    }
    
    public float getDato(int f, int c){
        if(f<=cabeza.getFila() && c<=cabeza.getColumna()){
            Nodo p=cabeza.getLigaFila();
            while(p!=cabeza){
                if(f==p.getFila() && c==p.getColumna())
                    return p.getDato();
                p=p.getLigaFila();
            }
            return 0;
        }
        return Float.MIN_VALUE;
    }
    
    public void setDato(int f, int c, float dato){
        
    }
    
    public ListaF2 eliminar(){
        return null;
    }
    
    public void mostrar(){
        String muestra="";
        Nodo p=cabeza.getLigaFila();
        while(p!=cabeza){
            for(int i=0;i<=cabeza.getFila();i++){
                for(int j=0;j<=cabeza.getColumna();j++){
                    if(p.getFila()==i && p.getColumna()==j){
                        muestra=muestra+p.getDato()+"   ";
                        p=p.getLigaFila();
                    }
                    else
                        muestra+=0.0+"    ";
                }
                muestra+="\n";
            }
            p=cabeza;
        }
        JOptionPane.showMessageDialog(null, muestra, "Matriz Forma 2", JOptionPane.PLAIN_MESSAGE);
    }
    
    public void mostrarDiferente0(){
        String muestra="";
        Nodo p=cabeza.getLigaFila();
        while(p!=cabeza){
            muestra=muestra+p.getDato()+"   ";
            p=p.getLigaFila();        
        }
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
        if(d!=0){
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
    
    public ListaF1 sumar(Tripleta b){
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
    
    public Tripleta sumar(ListaF1 b){
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
    
    public ListaF2 restar(ListaF2 b){
        if(b!=null){
            if(this.getNfilas()==b.getNfilas() && this.getNcolumnas()==b.getNcolumnas()){
                ListaF2 res=new ListaF2(b.getNfilas(),b.getNcolumnas());
                for(int i=0;i<=this.getNfilas();i++){
                    for(int j=0;j<=this.getNcolumnas();j++)
                        res.insertarDato(i, j, this.getDato(i, j)-b.getDato(i, j));
                }
            return res;
            }
            JOptionPane.showMessageDialog(null, "Las filas y columnas de la matriz no coinciden con la de la otra matriz", "No es posible sumar", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }
    
    public ListaF2 multiplicar(ListaF2 b){
        if(this.getNcolumnas()==b.getNfilas()){
            ListaF2 r=new ListaF2(this.getNfilas(),b.getNcolumnas());
            for(int i=0;i<=this.getNfilas();i++){
                for(int j=0;j<=b.getNcolumnas();j++)
                    r.insertarDato(i, j, calcularProductoEscalar(i, j, b));
            }
            return r;
        }
        return null;
    }
    
    private float calcularProductoEscalar(int fA, int cB,ListaF2 b){
        int acum=0;
        for(int i=0;i<=this.getNcolumnas();i++)
                acum+=this.getDato(fA, i)*b.getDato(i, cB);  
        return acum;
    }
    
    public boolean comparar(ListaF2 b){
        return false;
    }
    
    public ListaF2 copia(){
        ListaF2 r=new ListaF2(cabeza.getFila(),cabeza.getColumna());
         Nodo p=cabeza.getLigaFila();
        while(p!=cabeza){
            r.insertarDato(p.getFila(), p.getColumna(), p.getDato());
            p=p.getLigaFila();        
        }
        return r;
    }
}   