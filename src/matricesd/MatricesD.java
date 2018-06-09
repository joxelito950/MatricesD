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
public class MatricesD {

    /**
     * @param args the command line arguments
     */
    private static Tripleta A = null, B=null, C=null;
    private static ListaF1 M=null,N=null,O=null;
    private static ListaF2 X=null,Y=null,Z=null;
    
    private static void menu(){
        String infoMenu="0. Salir\n"+"1. Crear MD\n"+"2. Mostrar MD\n"+"3. Sumar MD\n";
        boolean sw;
        do{
        sw=opcion(Integer.parseInt(JOptionPane.showInputDialog(null, infoMenu, "***MENU***", JOptionPane.PLAIN_MESSAGE)));
        }while(sw);
        JOptionPane.showMessageDialog(null, "Feliz dia", "Cerrando", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private static boolean opcion(int op){
        switch (op){
            case 0:
                return false;
            case 1: 
                crearMD(Integer.parseInt(JOptionPane.showInputDialog(null, "0. Tripletas\n"+"1. Forma 1\n"+"2. Forma 2\n", "Tipo de MD a crear", JOptionPane.PLAIN_MESSAGE)));
                break;
            case 2:
                mostrarMD(Integer.parseInt(JOptionPane.showInputDialog(null, "Mostar 1\n0. A\n"+"1. B\n"+"2. C\n"+"3. M\n"+"4. N\n"+"5. O\n"+"6. X\n"+"7. Y\n"+"8. Z\n", "Selecione una variable", JOptionPane.PLAIN_MESSAGE)));
                if(A!=null){
                    A.mostrar();
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;
            case 3: 
                int t=Integer.parseInt(JOptionPane.showInputDialog(null, "0. Tripletas\n"+"1. Forma 1\n"+"2. Forma 2\n"+"3. Combinado", "Tipo de MD a crear", JOptionPane.PLAIN_MESSAGE));
                switch(t){
                    case 0:
                        C=A.sumar(B);
                        C.mostrar();
                        break;
                    case 1:
                        O=M.sumar(N);
                        O.mostrar();
                        break;
                    case 2:
                        Z=X.sumar(Y);
                        Z.mostrar();
                        break;
                    case 3:
                        sumarCombinado();
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opcion no valida", "Error", JOptionPane.QUESTION_MESSAGE);
                        break;
                        
                }
            default:
                JOptionPane.showMessageDialog(null, "Opcion no valida", "Error", JOptionPane.QUESTION_MESSAGE);
                break;
        }
        return true;
    }
    
    public static void crearMD(int tipo){
        switch(tipo){
            case 0:
                crearTrip(Integer.parseInt(JOptionPane.showInputDialog(null, "Variable que reporesentara la Matriz Tripleta\n0. A\n"+"1. B\n", "Selecione una variable", JOptionPane.PLAIN_MESSAGE)));
                break;    
            case 1:
                crearF1(Integer.parseInt(JOptionPane.showInputDialog(null, "Variable que reporesentara la Matriz Forma 1\n0. M\n"+"1. N\n", "Selecione una variable", JOptionPane.PLAIN_MESSAGE)));
                break;
            case 2:
                crearF2(Integer.parseInt(JOptionPane.showInputDialog(null, "Variable que reporesentara la Matriz Forma 1\n0. X\n"+"1. Y\n", "Selecione una variable", JOptionPane.PLAIN_MESSAGE)));
                break;
            default:
                JOptionPane.showMessageDialog(null, "No es un tipo de MD", Integer.toString(tipo), JOptionPane.ERROR_MESSAGE);
                break;
        }       
    }
    
    public static void crearTrip(int v){
            switch(v){
            case 0:
                if(A==null){
                int nF=Integer.parseInt(JOptionPane.showInputDialog(null,"Filas","Ingrese",JOptionPane.PLAIN_MESSAGE));
                int nC=Integer.parseInt(JOptionPane.showInputDialog(null,"Columnas","Ingrese",JOptionPane.PLAIN_MESSAGE));
                int nD=Integer.parseInt(JOptionPane.showInputDialog(null,"Datos diferentes de 0","Ingrese",JOptionPane.PLAIN_MESSAGE));
                A = new Tripleta(nF, nC, nD);
                    for(int i=0;i<A.getCdatos();i++){
                        nF=Integer.parseInt(JOptionPane.showInputDialog(null,"Fila","Ingrese",JOptionPane.PLAIN_MESSAGE));
                        nC=Integer.parseInt(JOptionPane.showInputDialog(null,"Columna","Ingrese",JOptionPane.PLAIN_MESSAGE));
                        nD=Integer.parseInt(JOptionPane.showInputDialog(null,"Dato","Ingrese",JOptionPane.PLAIN_MESSAGE));
                        A.almacenarTrip(nF, nC, nD);
                    }                    
                }
                else
                    JOptionPane.showMessageDialog(null, "Ya se creo una Matriz Dispersa", "Ya existe", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 1:
                if(B==null){
                int nF=Integer.parseInt(JOptionPane.showInputDialog(null,"Filas","Ingrese",JOptionPane.PLAIN_MESSAGE));
                int nC=Integer.parseInt(JOptionPane.showInputDialog(null,"Columnas","Ingrese",JOptionPane.PLAIN_MESSAGE));
                int nD=Integer.parseInt(JOptionPane.showInputDialog(null,"Datos diferentes de 0","Ingrese",JOptionPane.PLAIN_MESSAGE));
                B = new Tripleta(nF, nC, nD);
                    for(int i=0;i<B.getCdatos();i++){
                        nF=Integer.parseInt(JOptionPane.showInputDialog(null,"Fila","Ingrese",JOptionPane.PLAIN_MESSAGE));
                        nC=Integer.parseInt(JOptionPane.showInputDialog(null,"Columna","Ingrese",JOptionPane.PLAIN_MESSAGE));
                        nD=Integer.parseInt(JOptionPane.showInputDialog(null,"Dato","Ingrese",JOptionPane.PLAIN_MESSAGE));
                        B.almacenarTrip(nF, nC, nD);
                    }                    
                }
                else
                    JOptionPane.showMessageDialog(null, "Ya se creo una Matriz Dispersa", "Ya existe", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(null, "No es una Variable Definida para representar la matriz", Integer.toString(v), JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
    
    public static void crearF1(int v){
            switch(v){
            case 0:
                if(M==null){
                int nF=Integer.parseInt(JOptionPane.showInputDialog(null,"Filas","Ingrese",JOptionPane.PLAIN_MESSAGE));
                int nC=Integer.parseInt(JOptionPane.showInputDialog(null,"Columnas","Ingrese",JOptionPane.PLAIN_MESSAGE));
                M = new ListaF1(nF, nC);
                    for(int i=0;i<100;i++){
                        nF=Integer.parseInt(JOptionPane.showInputDialog(null,"Fila","Ingrese",JOptionPane.PLAIN_MESSAGE));
                        nC=Integer.parseInt(JOptionPane.showInputDialog(null,"Columna","Ingrese",JOptionPane.PLAIN_MESSAGE));
                        int nD=Integer.parseInt(JOptionPane.showInputDialog(null,"Dato","Ingrese",JOptionPane.PLAIN_MESSAGE));
                        M.almacenarDato(nF, nC,nD);
                        if(Integer.parseInt(JOptionPane.showInputDialog(null,"0. Finalizar #.continuar",JOptionPane.PLAIN_MESSAGE))==0)
                            break;
                    }                    
                }
                else
                    JOptionPane.showMessageDialog(null, "Ya se creo una Matriz Dispersa", "Ya existe", JOptionPane.INFORMATION_MESSAGE);
                break;
            case 1:
                if(N==null){
                int nF=Integer.parseInt(JOptionPane.showInputDialog(null,"Filas","Ingrese",JOptionPane.PLAIN_MESSAGE));
                int nC=Integer.parseInt(JOptionPane.showInputDialog(null,"Columnas","Ingrese",JOptionPane.PLAIN_MESSAGE));
                N = new ListaF1(nF, nC);
                    for(int i=0;i<100;i++){
                        nF=Integer.parseInt(JOptionPane.showInputDialog(null,"Fila","Ingrese",JOptionPane.PLAIN_MESSAGE));
                        nC=Integer.parseInt(JOptionPane.showInputDialog(null,"Columna","Ingrese",JOptionPane.PLAIN_MESSAGE));
                        int nD=Integer.parseInt(JOptionPane.showInputDialog(null,"Dato","Ingrese",JOptionPane.PLAIN_MESSAGE));
                        N.almacenarDato(nF, nC,nD);
                        if(Integer.parseInt(JOptionPane.showInputDialog(null,"0. Finalizar #.continuar",JOptionPane.PLAIN_MESSAGE))==0)
                            break;
                    }                    
                }
                else
                    JOptionPane.showMessageDialog(null, "Ya se creo una Matriz Dispersa", "Ya existe", JOptionPane.INFORMATION_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(null, "No es una Variable Definida para representar la matriz", Integer.toString(v), JOptionPane.ERROR_MESSAGE);
                break;
        }
    }
    
    public static void crearF2(int v){
        switch(v){
        case 0:
            if(X==null){
            int nF=Integer.parseInt(JOptionPane.showInputDialog(null,"Filas","Ingrese",JOptionPane.PLAIN_MESSAGE));
            int nC=Integer.parseInt(JOptionPane.showInputDialog(null,"Columnas","Ingrese",JOptionPane.PLAIN_MESSAGE));
            X = new ListaF2(nF, nC);
                for(int i=0;i<100;i++){
                    nF=Integer.parseInt(JOptionPane.showInputDialog(null,"Fila","Ingrese",JOptionPane.PLAIN_MESSAGE));
                    nC=Integer.parseInt(JOptionPane.showInputDialog(null,"Columna","Ingrese",JOptionPane.PLAIN_MESSAGE));
                    int nD=Integer.parseInt(JOptionPane.showInputDialog(null,"Dato","Ingrese",JOptionPane.PLAIN_MESSAGE));
                    X.almacenarDato(nF, nC,nD);
                    if(Integer.parseInt(JOptionPane.showInputDialog(null,"0. Finalizar #.continuar",JOptionPane.PLAIN_MESSAGE))==0)
                            break;
                }                    
            }
            else
                JOptionPane.showMessageDialog(null, "Ya se creo una Matriz Dispersa", "Ya existe", JOptionPane.INFORMATION_MESSAGE);
            break;
        case 1:
            if(Y==null){
            int nF=Integer.parseInt(JOptionPane.showInputDialog(null,"Filas","Ingrese",JOptionPane.PLAIN_MESSAGE));
            int nC=Integer.parseInt(JOptionPane.showInputDialog(null,"Columnas","Ingrese",JOptionPane.PLAIN_MESSAGE));
            Y = new ListaF2(nF, nC);
                for(int i=0;i<100;i++){
                    nF=Integer.parseInt(JOptionPane.showInputDialog(null,"Fila","Ingrese",JOptionPane.PLAIN_MESSAGE));
                    nC=Integer.parseInt(JOptionPane.showInputDialog(null,"Columna","Ingrese",JOptionPane.PLAIN_MESSAGE));
                    int nD=Integer.parseInt(JOptionPane.showInputDialog(null,"Dato","Ingrese",JOptionPane.PLAIN_MESSAGE));
                    Y.almacenarDato(nF, nC,nD);
                    if(Integer.parseInt(JOptionPane.showInputDialog(null,"0. Finalizar #.continuar",JOptionPane.PLAIN_MESSAGE))==0)
                            break;
                }                    
            }
            else
                JOptionPane.showMessageDialog(null, "Ya se creo una Matriz Dispersa", "Ya existe", JOptionPane.INFORMATION_MESSAGE);
            break;
        default:
            JOptionPane.showMessageDialog(null, "No es una Variable Definida para representar la matriz", Integer.toString(v), JOptionPane.ERROR_MESSAGE);
            break;
    }
}
        
    public static void mostrarMD(int tipo){
        switch(tipo){
            case 0:
                if(A!=null){
                    mostrarTrip(A);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;    
            case 1:
                if(B!=null){
                    mostrarTrip(B);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;  
                case 2:
                if(C!=null){
                    mostrarTrip(C);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;  
            case 3:
                if(M!=null){
                    mostrarF1(M);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;
            case 4:
                if(N!=null){
                    mostrarF1(N);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;
            case 5:
                if(O!=null){
                    mostrarF1(O);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;
            case 6:
                if(X!=null){
                    mostrarF2(X);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;
            case 7:
                if(Y!=null){
                    mostrarF2(Y);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;
            case 8:
                if(Z!=null){
                    mostrarF2(Z);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(null, "No esta Definido", Integer.toString(tipo), JOptionPane.ERROR_MESSAGE);
                break;
        }       
    }
    
    public static void mostrarTrip(Tripleta a){
        a.mostrar();
    }
    
    public static void mostrarF1(ListaF1 m){
        m.mostrar();
    }
    
    public static void mostrarF2(ListaF2 x){
        x.mostrar();
    }
    
    public static void sumarCombinado(){
        int t=Integer.parseInt(JOptionPane.showInputDialog(null, "0. A + M\n"+"1. A + X\n"+"2. M + X\n", "Sumar Combinado", JOptionPane.PLAIN_MESSAGE));
        switch(t){
            case 0:
                Z=A.sumar(M);
                Z.mostrar();
                break;
            case 1:
                O=A.sumar(X);
                O.mostrar();
                break;
            case 2:
                C=M.sumar(X);
                C.mostrar();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion no valida", "Error", JOptionPane.QUESTION_MESSAGE);
                break;

        }
    }
    
    public static void main(String[] args) {
        menu();
    }
    
}