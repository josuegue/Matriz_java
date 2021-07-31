/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrices;

/**
 *
 * @author USUARIOTC
 */
public class Clsjava {
    private static String [][] ma = new String [9][9];
    public static void main(String[] args){
      llenado();
      llenadoL();
      imprimir();
        
    }
    public static void llenado(){
          for ( int c =0; c<ma.length; c++){
            for (int f=0; f<ma.length; f++){
                ma[c][f]="X";
            }
        }
    }
    
    public static void imprimir(){
        for ( int c =0; c<ma.length; c++){
            for (int f=0; f<ma.length; f++){
                System.out.print(ma[c][f]);
            }
            System.out.print("\n");
        }
    }
    
    public static void llenadoL(){
        for(int x=0; x<ma.length; x++){
            ma[x][ma.length-1]="FILA";
        }
        for (int y=0; y<ma.length; y++){
            ma[0][y]="COLUMNA";
        }
    }
    
    public static void llenadoX(){
        for (int x=0; x<ma.length; x++){
            
        }
    }
}
