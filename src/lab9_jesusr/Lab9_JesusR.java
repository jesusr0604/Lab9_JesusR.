package lab9_jesusr;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Lab9_JesusR {
    static Scanner leer = new Scanner(System.in);
    static Random random = new Random();
    static Game_Lab9_JesusR g = new Game_Lab9_JesusR ();
    public static void main(String[] args) {
     int opcion=0;
      ArrayList<String>Game= new ArrayList<>();  
        do {
            opcion = menu();
            switch (opcion) {
                case 1:{
                    int ron;
                    System.out.println("Ingrese el numero de rondas: ");
                    ron= leer.nextInt();
                    int x=0;
                    int y =0;
                       
                       
                       Game.clear();
                        int[][] tablero = new int[10][10];
                        int[][] tablero2 = new int[10][10];
                       tablero= llenar(tablero, tablero2,Game);
                       g.setTablero1(tablero);
                       g.jugar(ron);
                       
                      
                       // System.out.println(imprimir(tablero));
                       
                        
                   
                         
                } 
                break;
                
                case 0:{
                    System.out.println("No Valido");
                }
                    
                    
            }
        }while(opcion!= 0);    
    }
    public static int menu (){
         System.out.println("1: Game of Life ");
            System.out.println("0:Salir");
            System.out.println("Ingrese su desicion");
            int opcion = leer.nextInt();
     return opcion;
    }
    
     public static int[][] llenar(int[][] matriz1, int [][] Matriz2,ArrayList<String>Game) {
      
         
        for (int i = 1; i < matriz1.length-1; i++) {
            for (int j = 1; j < matriz1[0].length-1; j++) {
                matriz1[i][j] = random.nextInt(2);
                if (matriz1[i][j]==1) {
                    Game.add(i+":"+j);
                }
                //g.print(Game);
                
                
            }
        }
        g.setTablero2(Matriz2);
        g.setGame(Game);
        
        
        return matriz1;
     }
       public static String imprimir(int[][] numero) {
        String cadena = "";

        for (int i = 0; i < numero.length; i++) {
            for (int j = 0; j < numero[i].length; j++) {
                cadena += "[" + numero[i][j] + "]" + " ";
            }
            cadena += "\n";
        }
        
        return cadena;
       }
       
      
}
