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
    private static Tripleta mDTrip = null;
    
    private static void menu(){
        String infoMenu="0. Salir\n"+"1. Crear MD\n"+"2. \n"+"3. \n"+"4. \n";
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
                if(mDTrip==null){
                    int nF=Integer.parseInt(JOptionPane.showInputDialog(null,"Filas","Ingrese",JOptionPane.PLAIN_MESSAGE));
                    int nC=Integer.parseInt(JOptionPane.showInputDialog(null,"Columnas","Ingrese",JOptionPane.PLAIN_MESSAGE));
                    int nD=Integer.parseInt(JOptionPane.showInputDialog(null,"Datos diferentes de 0","Ingrese",JOptionPane.PLAIN_MESSAGE));
                    mDTrip = new Tripleta(nF, nC, nD);
                    for(int i=0;i<mDTrip.getCdatos();i++){
                        nF=Integer.parseInt(JOptionPane.showInputDialog(null,"Fila","Ingrese",JOptionPane.PLAIN_MESSAGE));
                        nC=Integer.parseInt(JOptionPane.showInputDialog(null,"Columna","Ingrese",JOptionPane.PLAIN_MESSAGE));
                        nD=Integer.parseInt(JOptionPane.showInputDialog(null,"Dato","Ingrese",JOptionPane.PLAIN_MESSAGE));
                        mDTrip.almacenarTrip(nF, nC, nD);
                    }                    
                }
                else
                    JOptionPane.showMessageDialog(null, "Ya se creo una Matriz Dispersa", "Ya existe", JOptionPane.INFORMATION_MESSAGE);
                    
                break;
            case 2:
                
                break;
            case 3: 
                
                break;
            case 4:
                
                break;
            default:
                break;
        }
        return true;
    }
    
    public static void main(String[] args) {
        menu();
    }
    
}
