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
    private static Tripleta A=null, B=null, C=null;
    private static ListaF1 M=null,N=null,O=null;
    private static ListaF2 X=null,Y=null,Z=null;
    
    private static void menu(){
        String infoMenu="0. Salir\n"+"1. Crear MD\n"+"2. Mostrar MD\n"+"3. Sumar MD\n"+"4. Multiplicar MD\n"+"5. Eliminar MD\n";
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
                mostrarMD(Integer.parseInt(JOptionPane.showInputDialog(null, "Mostar\n"+"0. A\n"+"1. B\n"+"2. C variable para respuestas\n"+"3. M\n"+"4. N\n"+"5. O variable para respuestas\n"+"6. X\n"+"7. Y\n"+"8. Z variable para respuestas\n", "Selecione una variable", JOptionPane.PLAIN_MESSAGE)));
                break;
            case 3: 
                sumarMD(Integer.parseInt(JOptionPane.showInputDialog(null, "0. Tripletas A+B\n"+"1. Forma 1 M+N\n"+"2. Forma 2 X+Y\n"+"3. Combinado", "Tipo de MD a sumar", JOptionPane.PLAIN_MESSAGE)));
                break;
            case 4:
                multiplicarMD(Integer.parseInt(JOptionPane.showInputDialog(null, "0. Tripletas A*B\n"+"1. Forma 1 M*N\n"+"2. Forma 2 X*Y\n"+"3. Combinado", "Tipo de MD a Multiplicar", JOptionPane.PLAIN_MESSAGE)));
                break;
            case 5:
                eliminarMD(Integer.parseInt(JOptionPane.showInputDialog(null, "0. A     "+"1. B     "+"2. C\n"+"3. M    "+"4. N     "+"5. O\n"+"6. X    "+"7. Y     "+"8. Z\n", "Seleccione matriz a Eliminar", JOptionPane.PLAIN_MESSAGE)));
                break;
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
                    mostrar(A);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;    
            case 1:
                if(B!=null){
                    mostrar(B);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;  
                case 2:
                if(C!=null){
                    mostrar(C);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;  
            case 3:
                if(M!=null){
                    mostrar(M);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;
            case 4:
                if(N!=null){
                    mostrar(N);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;
            case 5:
                if(O!=null){
                    mostrar(O);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;
            case 6:
                if(X!=null){
                    mostrar(X);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;
            case 7:
                if(Y!=null){
                    mostrar(Y);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;
            case 8:
                if(Z!=null){
                    mostrar(Z);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se ha creado una Matriz Dispersa", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(null, "No esta Definido", Integer.toString(tipo), JOptionPane.ERROR_MESSAGE);
                break;
        }       
    }
    
    public static void mostrar(Tripleta a){
        if(a!=null)
            a.mostrar();
        else
            JOptionPane.showMessageDialog(null, "No se ha creado una MD tripleta", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void mostrar(ListaF1 m){
        if(m!=null)
            m.mostrar();
        else
            JOptionPane.showMessageDialog(null, "No se ha creado una MD Forma 1", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void mostrar(ListaF2 x){
        if(x!=null)
            x.mostrar();
        else
            JOptionPane.showMessageDialog(null, "No se ha creado una MD Forma 2", "Falta Matriz", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void sumarMD(int t){
        switch(t){
            case 0:
                if(A!=null && B!=null){
                    C=A.sumar(B);
                    JOptionPane.showMessageDialog(null, "Respuesta guardada en C\nAcepte para ver respuesta", "El resultado de la suma", JOptionPane.PLAIN_MESSAGE);
                    mostrar(C);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se han creado las MD Tripleta para realizar la suma.", "Sin Datos", JOptionPane.QUESTION_MESSAGE);
                break;
            case 1:
                if(M!=null && N!=null){
                    O=M.sumar(N);
                    JOptionPane.showMessageDialog(null, "Respuesta guardada en O\nAcepte para ver respuesta", "El resultado de la suma", JOptionPane.PLAIN_MESSAGE);
                    mostrar(O);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se han creado las MD Forma 1 para realizar la suma.", "Sin Datos", JOptionPane.QUESTION_MESSAGE);
                break;
            case 2:
                if(X!=null && Y!=null){
                    Z=X.sumar(Y);
                    JOptionPane.showMessageDialog(null, "Respuesta guardada en Z\nAcepte para ver respuesta", "El resultado de la suma", JOptionPane.PLAIN_MESSAGE);
                    mostrar(Z);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se han creado las MD Forma 2 para realizar la suma.", "Sin Datos", JOptionPane.QUESTION_MESSAGE);
                break;
            case 3:
                sumarCombinado();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion no valida", "Error", JOptionPane.QUESTION_MESSAGE);
                break;
        }
    }
    
    public static void sumarCombinado(){
        int t=Integer.parseInt(JOptionPane.showInputDialog(null, "0. A + M\n"+"1. A + X\n"+"2. M + X\n", "Sumar Combinado", JOptionPane.PLAIN_MESSAGE));
        switch(t){
            case 0:
                if(A==null)
                    JOptionPane.showMessageDialog(null, "Matriz Tripleta A no definida ", "Falta Matriz", JOptionPane.QUESTION_MESSAGE);
                else{
                    if(M==null)
                        JOptionPane.showMessageDialog(null, "Matriz Forma 1 M no definida ", "Falta Matriz", JOptionPane.QUESTION_MESSAGE);
                    else{
                        Z=A.sumar(M);
                        JOptionPane.showMessageDialog(null, "Respuesta guardada en Z\nAcepte para ver respuesta", "El resultado de la suma", JOptionPane.PLAIN_MESSAGE);
                        mostrar(Z);
                    }
                }
                break;
            case 1:
                if(A==null)
                    JOptionPane.showMessageDialog(null, "Matriz Tripleta A no definida ", "Falta Matriz", JOptionPane.QUESTION_MESSAGE);
                else{
                    if(X==null)
                        JOptionPane.showMessageDialog(null, "Matriz Forma 2 X no definida ", "Falta Matriz", JOptionPane.QUESTION_MESSAGE);
                    else{
                        O=A.sumar(X);
                        JOptionPane.showMessageDialog(null, "Respuesta guardada en O\nAcepte para ver respuesta", "El resultado de la suma", JOptionPane.PLAIN_MESSAGE);
                        mostrar(O);
                    }
                }
                break;
            case 2:
                if(X==null)
                    JOptionPane.showMessageDialog(null, "Matriz Forma 2 X no definida ", "Falta Matriz", JOptionPane.QUESTION_MESSAGE);
                else{
                    if(M==null)
                        JOptionPane.showMessageDialog(null, "Matriz Forma 1 M no definida ", "Falta Matriz", JOptionPane.QUESTION_MESSAGE);
                    else{
                        C=M.sumar(X);
                        JOptionPane.showMessageDialog(null, "Respuesta guardada en C\nAcepte para ver respuesta", "El resultado de la suma", JOptionPane.PLAIN_MESSAGE);
                        mostrar(C);
                    }
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion no valida", "Error", JOptionPane.QUESTION_MESSAGE);
                break;

        }
    }
    
    public static void multiplicarMD(int tipo){
        switch(tipo){
            case 0:
                if(A!=null && B!=null){
                    C=A.multiplicar(B);
                    JOptionPane.showMessageDialog(null, "Respuesta guardada en C\nAcepte para ver respuesta", "El resultado de la multiplicacion", JOptionPane.PLAIN_MESSAGE);
                    mostrar(C);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se han creado las MD Tripleta para realizar la multiplicacion.", "Sin Datos", JOptionPane.QUESTION_MESSAGE);
                break;
            case 1:
                if(M!=null && N!=null){
                    O=M.multiplicar(N);
                    JOptionPane.showMessageDialog(null, "Respuesta guardada en O\nAcepte para ver respuesta", "El resultado de la multiplicacion", JOptionPane.PLAIN_MESSAGE);
                    mostrar(O);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se han creado las MD Forma 1 para realizar la multiplicacion.", "Sin Datos", JOptionPane.QUESTION_MESSAGE);
                break;
            case 2:
                if(X!=null && Y!=null){
                    Z=X.multiplicar(Y);
                    JOptionPane.showMessageDialog(null, "Respuesta guardada en Z\nAcepte para ver respuesta", "El resultado de la multiplicacion", JOptionPane.PLAIN_MESSAGE);
                    mostrar(Z);
                }
                else
                    JOptionPane.showMessageDialog(null, "No se han creado las MD Forma 2 para realizar la multiplicacion.", "Sin Datos", JOptionPane.QUESTION_MESSAGE);
                break;
            case 3:
                multiplicarCombinado();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion no valida", "Error", JOptionPane.QUESTION_MESSAGE);
                break;
        }
    }
    
    public static void multiplicarCombinado(){
        int t=Integer.parseInt(JOptionPane.showInputDialog(null, "0. A*M\n"+"1. A*X\n"+"2. M*X\n", "Multiplicar Combinado", JOptionPane.PLAIN_MESSAGE));
        switch(t){
            case 0:
                if(A==null)
                    JOptionPane.showMessageDialog(null, "Matriz Tripleta A no definida ", "Falta Matriz", JOptionPane.QUESTION_MESSAGE);
                else{
                    if(M==null)
                        JOptionPane.showMessageDialog(null, "Matriz Forma 1 M no definida ", "Falta Matriz", JOptionPane.QUESTION_MESSAGE);
                    else{
                        Z=A.sumar(M);
                        JOptionPane.showMessageDialog(null, "Respuesta guardada en Z\nAcepte para ver respuesta", "El resultado de la multiplicacion", JOptionPane.PLAIN_MESSAGE);
                        mostrar(Z);
                    }
                }
                break;
            case 1:
                if(A==null)
                    JOptionPane.showMessageDialog(null, "Matriz Tripleta A no definida ", "Falta Matriz", JOptionPane.QUESTION_MESSAGE);
                else{
                    if(X==null)
                        JOptionPane.showMessageDialog(null, "Matriz Forma 2 X no definida ", "Falta Matriz", JOptionPane.QUESTION_MESSAGE);
                    else{
                        O=A.sumar(X);
                        JOptionPane.showMessageDialog(null, "Respuesta guardada en O\nAcepte para ver respuesta", "El resultado de la multiplicacion", JOptionPane.PLAIN_MESSAGE);
                        mostrar(O);
                    }
                }
                break;
            case 2:
                if(X==null)
                    JOptionPane.showMessageDialog(null, "Matriz Forma 2 X no definida ", "Falta Matriz", JOptionPane.QUESTION_MESSAGE);
                else{
                    if(M==null)
                        JOptionPane.showMessageDialog(null, "Matriz Forma 1 M no definida ", "Falta Matriz", JOptionPane.QUESTION_MESSAGE);
                    else{
                        C=M.sumar(X);
                        JOptionPane.showMessageDialog(null, "Respuesta guardada en C\nAcepte para ver respuesta", "El resultado de la multiplicacion", JOptionPane.PLAIN_MESSAGE);
                        mostrar(C);
                    }
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Opcion no valida", "Error", JOptionPane.QUESTION_MESSAGE);
                break;
        }
    }
    
    public static void eliminarMD(int v){
        switch(v){
            case 0:
                A=A.eliminarTrip();
                break;
            case 1:
                B=B.eliminarTrip();
                break;
            case 2:
                C=C.eliminarTrip();  
                break;
            case 3:
                M=M.eliminar();
                break;
            case 4:
                N=N.eliminar();
                break;
            case 5:
                O=O.eliminar();
                break;
            case 6:
                X=X.eliminar();
                break;
            case 7:
                Y=Y.eliminar();
                break;
            case 8:
                Z=Z.eliminar();
                break;
            default:
                JOptionPane.showMessageDialog(null, "No esta Definido", Integer.toString(v), JOptionPane.ERROR_MESSAGE);
                break;
        } 
    }
    
    public static void main(String[] args) {
        menu();
    }
    
}