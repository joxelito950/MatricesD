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
public class Tripleta {
    int nFilas, nColumnas,nt;
    float listaTrip[][];
    
    public Tripleta(int nf,int nc,int cd){
        this.nFilas=nf;
        this.nColumnas=nc;
        this.nt= cd+1;
        listaTrip = new float[nt][3];
        listaTrip[0][0]=nFilas;
        listaTrip[0][1]=nColumnas;
        listaTrip[0][2]=cd;
    }
    
    public void mostrar(){
        String m="";
        int i=1,k,j;
        for(k=0;k<=listaTrip[0][0];k++){
            for(j=0;j<=listaTrip[0][1];j++){
                    if(i<=listaTrip[0][2] && listaTrip[i][0]==k && listaTrip[i][1]==j){
                        m+=listaTrip[i][2]+"    ";
                        i++;
                    }
                    else{
                        m+=0.0+"    ";
                    }
            }
            m+="\n";
        }
        JOptionPane.showMessageDialog(null,m,"Matriz",JOptionPane.PLAIN_MESSAGE);
    }
    
    public void almacenarTrip(int f, int c, float d){
        int k=1,j;
        while(k<listaTrip[0][2] && listaTrip[k][0]<f && listaTrip[k][2]!=0)
            k++;
        while(k<listaTrip[0][2] && listaTrip[k][0]<=f && listaTrip[k][1]<c && listaTrip[k][2]!=0)
            k++;
        if(k<listaTrip[0][2] && listaTrip[k][0]==f && listaTrip[k][1]==c && f!=0 && c!=0)
            JOptionPane.showMessageDialog(null,"Ya existe un dato en esa posicion","No Insertado",JOptionPane.INFORMATION_MESSAGE);
        else{
            for(j=(int)listaTrip[0][2];j>=k;j--){
                listaTrip[j][0]=listaTrip[j-1][0];
                listaTrip[j][1]=listaTrip[j-1][1];
                listaTrip[j][2]=listaTrip[j-1][2];
            }
            listaTrip[k][0]=f;
            listaTrip[k][1]=c;
            listaTrip[k][2]=d;
        }
    }
    
    public void insertarTrip(int f,int c, float d){
        if(d!=0){
            int k=1,j;
            while(k<=listaTrip[0][2] && listaTrip[k][0]<f && listaTrip[k][2]!=0)
                k++;
            while(k<=listaTrip[0][2] && listaTrip[k][0]<=f && listaTrip[k][1]<c && listaTrip[k][2]!=0)
                k++;
            if(k<=listaTrip[0][2] && listaTrip[k][0]==f && listaTrip[k][1]==c){
                if(listaTrip[k][2]+d!=0)
                    listaTrip[k][2]=listaTrip[k][2]+d;
                else{
                    for(j=k;j<listaTrip[0][2];j++){
                        listaTrip[j][0]=listaTrip[j-1][0];
                        listaTrip[j][1]=listaTrip[j-1][1];
                        listaTrip[j][2]=listaTrip[j-1][2];
                    }
                    listaTrip[0][2]=listaTrip[0][2]-1;
                }
            }
            else{
                if(listaTrip[0][2]==nt-1)
                    redimensionar();
                for(j=(int)listaTrip[0][2];j>=k;j--){
                    listaTrip[j+1][0]=listaTrip[j][0];
                    listaTrip[j+1][1]=listaTrip[j][1];
                    listaTrip[j+1][2]=listaTrip[j][2];
                }
                listaTrip[k][0]=f;
                listaTrip[k][1]=c;
                listaTrip[k][2]=d;
                listaTrip[0][2]=listaTrip[0][2]+1;
            }
        }
    }
    
    public void redimensionar(){
        int k;
        nt+=nt;
        float aux[][]=new float [nt][3];
        for(k=0;k<=listaTrip[0][2];k++){
            aux[k][0]=listaTrip[k][0];
            aux[k][1]=listaTrip[k][1];
            aux[k][2]=listaTrip[k][2];
        }
        listaTrip=aux;
    }

    public int getNfilas() {
        return nFilas;
    }

    public int getNcolumnas() {
        return nColumnas;
    }
    
    public int getCdatos(){
        return (int)listaTrip[0][2];
    }
    
    public int getFila(int i){
        if(i<=listaTrip[0][0])
            return (int)listaTrip[i][0];
        return Integer.MIN_VALUE;
    }
    
    public int getColumna(int i){
        if(i<=listaTrip[0][1])
            return (int)listaTrip[i][1];
        return Integer.MIN_VALUE;
    }
    
    public float getDato(int f, int c){
        for(int i=1;i<=getCdatos();i++){
            if(listaTrip[i][0]==f && listaTrip[i][1]==c)
                return listaTrip[i][2];
        }
        return 0;
    }
    
    public void setDato(int f, int c, float dato){
        
    }
    
    public float promedio(){
        float p=0;
        for(int i=1;i<=getCdatos();i++){
            p=p+listaTrip[i][2];
        }
        return p/(getNcolumnas()*getNfilas());
    }
    
    public void sumarfilas(){
        int j=0;
        for(int i=1;i<=listaTrip[0][2];i++){
            float s=0;
            while(listaTrip[i][0]==j && i<=getNfilas()){
                s=s+listaTrip[i][2];
                i++;
            }
            i--;
            j++;
            JOptionPane.showMessageDialog(null, s, "Suma fila "+j, JOptionPane.PLAIN_MESSAGE);
        }
    }
    
    public void menorColumna(){
        
    }
    
    public void promedioCol(){
        float s=0;
        int j=1;
        while(j<=getNcolumnas()){
            s=listaTrip[j][2];
            for(int i=1;i<=getCdatos();i++){
                if(listaTrip[j][1]==listaTrip[i][1])
                    s=s+listaTrip[i][2];
            }
            JOptionPane.showMessageDialog(null, s/getNcolumnas(), "sumatoria fila "+j, JOptionPane.PLAIN_MESSAGE);
            j++;
        }
    }
    
    
    
    public void menor(){
        
    }
    
    public Tripleta eliminarTrip(){
        return null;
    }
    
    public Tripleta traspuesta(){
         Tripleta p = new Tripleta(0,0,0);
         return p;
    }
    
    public Tripleta sumar(Tripleta b){ 
        if(this.getNfilas()==b.getNfilas() && this.getNcolumnas()==b.getNcolumnas()){
            Tripleta res=new Tripleta(this.nFilas,this.nColumnas,0);
            for(int i=0;i<=listaTrip[0][0];i++){
                for(int j=0;j<=listaTrip[0][1];j++)
                    res.insertarTrip(i, j, this.getDato(i, j)+b.getDato(i, j));
            }
            return res;
        }
        JOptionPane.showMessageDialog(null, "Las filas y columnas de la matriz Tripleta no coinciden con la de la otra matriz", "No es posible sumar", JOptionPane.INFORMATION_MESSAGE);
        return null;
    }
    
    public ListaF1 sumar(ListaF2 b){
        if(b!=null){
            if(this.nFilas==b.getNfilas() && this.nColumnas==b.getNcolumnas()){
                ListaF1 res=new ListaF1(b.getNfilas(),b.getNcolumnas());
                for(int i=0;i<=listaTrip[0][0];i++){
                    for(int j=0;j<=listaTrip[0][1];j++)
                        res.insertarDato(i, j, this.getDato(i, j)+b.getDato(i, j));
                }
            return res;
            }
            JOptionPane.showMessageDialog(null, "Las filas y columnas de la matriz A no coinciden con la de la otra matriz", "No es posible sumar", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }
    
    public ListaF2 sumar(ListaF1 b){
        if(b!=null){
            if(this.nFilas==b.getNfilas() && this.nColumnas==b.getNcolumnas()){
                ListaF2 res=new ListaF2(b.getNfilas(),b.getNcolumnas());
                for(int i=0;i<=listaTrip[0][0];i++){
                    for(int j=0;j<=listaTrip[0][1];j++)
                        res.insertarDato(i, j, this.getDato(i, j)+b.getDato(i, j));
                }
            return res;
            }
            JOptionPane.showMessageDialog(null, "Las filas y columnas de la matriz A no coinciden con la de la otra matriz", "No es posible sumar", JOptionPane.INFORMATION_MESSAGE);
        }
        return null;
    }
    
    public Tripleta multiplicar(Tripleta b){
        if(this.getNcolumnas()==b.getNfilas()){
            Tripleta r=new Tripleta(this.getNfilas(),b.getNcolumnas(),0);
            int k=0,l=0;
            for(int i=0;i<=this.getNcolumnas();i++){
                int acum=0;
                for(int j=0;j<=b.getNfilas();j++)
                    acum+=this.getDato(i, j)*b.getDato(j, i);  
                r.insertarTrip(k, l, acum);
                if(k<=this.getNfilas() && l<=b.getNcolumnas()){
                    k++;
                    l++;
                }
                else{
                    k=0;
                    l=0;
                }
            }
            return r;
        }
        JOptionPane.showMessageDialog(null, "Las filas de la matriz A no coinciden con las columnas de la otra matriz", "No es posible multiplicar", JOptionPane.INFORMATION_MESSAGE);
        return null;
    }
    
    public void comparar(Tripleta b){
        
    }
    
    public void hacerCopia(){
        
    }
}