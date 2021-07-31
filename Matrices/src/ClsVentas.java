
import java.text.DecimalFormat;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIOTC
 */
public class ClsVentas {
    // Objetos
    public static DecimalFormat rd = new DecimalFormat("###.##");
    public static Scanner sn = new Scanner (System.in);
    private static String Enero;
    private static String Febrero;
    private static String Marzo;
    private static double  Total;
    private static double Promedio;
    private static double TotalEne;
    private static double TotalFebe;
    private static double TotalMar;
    private static double GranTotal;
    private static String [][] Matriz;
    private static int fila;
    private static int columna;
    
    
     public static void main(String[] args) {
         Menu();
    }
      public static String [][]IngresoTanMa(){
        columna = 6;
        System.out.print("Ingrese el numero de filas: ");
        fila=sn.nextInt();
        sn.nextLine();
        return Matriz = new String [fila][columna];  
    }
    public static String [][] LlenarMatriz(){
        System.out.println("________________________________________________");
        for (int f=0; f<Matriz.length; f++) {
            for (int c = 0; c<Matriz[0].length; c++) {
                if(c==0){
                    System.out.print("Ingrese nombre: ");
                    Matriz[f][c]=sn.nextLine()+" | ";
                }
                else if(c==1){
                    System.out.print("Ingrese venta de enero: ");
                    Enero=sn.nextLine();
                    TotalEne+=Integer.parseInt(Enero);
                    Matriz[f][c]="Q"+Enero+" | ";
                }
                else if(c==2){
                    System.out.print("Ingrese venta de febrero: ");
                    Febrero=sn.nextLine();
                    TotalFebe+=Integer.parseInt(Febrero);
                    Matriz[f][c]="Q"+Febrero+" | ";
                }
                else if (c==3){
                    System.out.print("Ingrese venta de marzo:  ");
                    Marzo=sn.nextLine();
                    TotalMar+=Integer.parseInt(Marzo);
                    Matriz[f][c]="Q"+Marzo+" | ";
                }
                else if( c==4){
                    Total=Integer.parseInt(Enero)+Integer.parseInt(Febrero)+Integer.parseInt(Marzo);
                    GranTotal+=Total;
                    Matriz[f][c]="Q"+Total+" | ";
                }   
                else if( c==5){
                    Promedio=Total/3;
                    Matriz[f][c]="Q"+rd.format(Promedio)+" |";
                } 
            }  
            System.out.println("________________________________________________");
        }
        return Matriz;
    }   
       
    
     public static void ImprimirMatriz(){
         System.out.println("\n\n________________________________________________");
         System.out.println("Nombre | Enero | Febrero | Marzo | Total | Promedio |");
         System.out.println("________________________________________________");
        for (int f=0; f<Matriz.length; f++) {
            for (int c = 0; c<Matriz[0].length; c++) {
                System.out.print(Matriz[f][c]);
            }
            System.out.println("\n________________________________________________");
        }
        System.out.println();
        System.out.println("Ventas realizadas en enero Q" + TotalEne);
        System.out.println("Ventas realizadaas en febrero Q"+ TotalFebe);
        System.out.println("Ventas realizadas en marzo Q"+ TotalMar);
        System.out.println("Gran total por todas las ventas Q" + GranTotal);
        System.out.println("Filas["+Matriz.length+"] Columnas["+Matriz[0].length+"]");
    }
     public static void Menu(){
        boolean salir=false;
         do{
             int opcion=0;
             
         System.out.print("1. Ingresar informacion"
                 + "\n2. Minimo vendedor por mes"
                 + "\n3. Maximo Vendedor por mes"
                 + "\n4. Maximo venderdor"
                 + "\n5. Mostrar matriz"
                 + "\n6. Busqueda por venta"
                 + "\n7. Salir"
                 + "\nIngresa tu opcion: ");
         opcion=Integer.parseInt(sn.nextLine());
         
         switch(opcion){
             case 1:
                 System.out.println("\n________________________________________________");
                 IngresoTanMa();
                 LlenarMatriz();
                 System.out.println("Llenado de datos realizada con exito");
                 System.out.println("\n________________________________________________");
                 break;
             case 2:
                 int mes=0;
                 System.out.print("1. Enero"
                         + "\n2. Febrero"
                         + "\n3. Marzo"
                         + "\nIngrea tu opcion: ");
                 mes=Integer.parseInt(sn.nextLine());
                 System.out.println("\n________________________________________________");
                 System.out.print("El que vendio el minimo en el mes "+mes+" es:"
                         + "\n"+MinVendedorMes(Matriz,mes));
                 System.out.println("\n________________________________________________");
                 break;
             case 3:
                 int mes1=0;
                 System.out.print("1. Enero"
                         + "\n2. Febrero"
                         + "\n3. Marzo"
                         + "\nIngresa tu opcion: ");
                 mes1=Integer.parseInt(sn.nextLine());
                 System.out.println("\n________________________________________________");
                 System.out.print("El que vendio el maximo en el mes "+mes1+" es:"
                         + "\n"+MxVendedorMes(Matriz,mes1));
                 System.out.println("\n________________________________________________");
                 break;
             case 4:
                 System.out.println("\n________________________________________________");
                 System.out.print("Maximo vendedor:"
                         + "\n"+MxVendedor(Matriz));
                 System.out.println("\n________________________________________________");
                 break;
             case 5:
                 ImprimirMatriz();
                 break;
             case 6:
                 String monto="";
                 System.out.print("Ingrese el monto de venta a buscar: ");
                 monto=sn.nextLine();
                 System.out.println("\n________________________________________________");
                 System.out.println("El usuario es "+BusquedaVentas(Matriz,monto));
                 System.out.println("________________________________________________");
                 break;
             case 7:
                 salir=true;
                 break;
             default:
                 System.out.println("Seleccionaste una opcion fuera de rango."
                         + "\n¡Intenta de nuevo por favor!");
                 break;
         }
         System.out.println("\n");
         
         }while(!salir);
         
     }
     public static String MxVendedorMes(String [][] matriz, int col){
         String datos="";
         double maximo=Double.parseDouble(matriz[0][1].substring(1,matriz[0][1].length()-3));
         for (int i=0; i<matriz.length; i++){
             
             if (Integer.parseInt(matriz[i][col].substring(1,matriz[i][col].length()-3))>=maximo){
                 maximo=Integer.parseInt(matriz[i][col].substring(1,matriz[i][col].length()-3));
                 datos=matriz[i][0]+"Q"+maximo;
             }
         }
         return datos;
     }
     public static String MinVendedorMes(String [][] matriz, int col){
         String datos="";
         
         double min=Double.parseDouble(matriz[0][1].substring(1,matriz[0][1].length()-3));
         for (int i=0; i<matriz.length; i++){
             
             if (Integer.parseInt(matriz[i][col].substring(1,matriz[i][col].length()-3))<=min){
                 min=Integer.parseInt(matriz[i][col].substring(1,matriz[i][col].length()-3));
                 datos=matriz[i][0]+"Q"+min;
             }
         }
         return datos;
     }
     public static String MxVendedor(String [][] matriz){
         String datos="";
         final int col=4;
         double maximo=Double.parseDouble(matriz[0][col].substring(1,matriz[0][col].length()-3));
         for (int i=0; i<matriz.length; i++){
             if (Double.parseDouble(matriz[i][col].substring(1,matriz[i][col].length()-3))>=maximo){
                 maximo=Double.parseDouble(matriz[i][col].substring(1,matriz[i][col].length()-3));
                 datos=matriz[i][0]+"Q"+maximo;
             }
         }
         return datos;
     }
     public static String BusquedaVentas(String [][] matriz, String venta){
         String datos="";
         int encontrado=0;
         int cantidad=Integer.parseInt(venta);
         for (int i=0; i<matriz.length; i++){
             if (Integer.parseInt(matriz[i][1].substring(1,matriz[i][1].length()-3))==cantidad){
                 encontrado=Integer.parseInt(matriz[i][1].substring(1,matriz[i][1].length()-3));
                 if(encontrado==cantidad){
                     datos=matriz[i][0]+matriz[i][1];
                 }
             }
             else if (Integer.parseInt(matriz[i][2].substring(1,matriz[i][2].length()-3))==cantidad){
                 encontrado=Integer.parseInt(matriz[i][2].substring(1,matriz[i][2].length()-3));
                 if(encontrado==cantidad){
                     datos=matriz[i][0]+matriz[i][2];
                 }
             }
             else if (Integer.parseInt(matriz[i][3].substring(1,matriz[i][3].length()-3))==cantidad){
                 encontrado=Integer.parseInt(matriz[i][3].substring(1,matriz[i][3].length()-3));
                 if(encontrado==cantidad){
                     datos=matriz[i][0]+matriz[i][3];
                 }
             }   
         }
         return datos;
     }
}
