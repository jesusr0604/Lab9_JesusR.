package lab9_jesusr;


import java.util.ArrayList;

public class Game_Lab9_JesusR {
    public int[][] tablero1;
    public int[][] tablero2;
    public ArrayList<String> Game;
    int ron;

    public Game_Lab9_JesusR(){
    }
    
    
    public void print(ArrayList<String>Game){
        int prov[][]= new int [10][10];
        System.out.print("Coordenadas: ");
        for (int i = 0; i < Game.size(); i++) {
            String cadena = Game.get(i);
            String[] arr = cadena.split(":");
            int x =Integer.parseInt(arr[0]);
            int y = Integer.parseInt(arr[1]);
            prov[x][y] = 1;
            System.out.print(Game.get(i)+",");
        }
        System.out.println("");
        for (int i = 0; i < prov.length; i++) {
            for (int j = 0; j < prov.length; j++) {
                System.out.print("["+prov[i][j]+"]");
            }
            System.out.println("");
        }
        
       
    }
  
    public void jugar(int ron){
        System.out.println("Matriz Original");
        print(Game);
        System.out.println("----------------");
        for (int i = 1; i <= ron; i++) {
            System.out.println("Ronda"+i);    
            nextgen();
            print(Game);
        }
    }

    public void nextgen(){
        Game.clear();
        int temp[][] = new int[10][10];
        for(int i = 0; i < tablero1.length; i++){
            for(int j = 0; j < tablero1[0].length; j++){
                int vivos = 0;
                if(i > 0 && j > 0 && i < tablero1.length-1 && j < tablero1[0].length-1){
                    if(tablero1[i-1][j-1] == 1){
                        vivos++;
                    }
                    if(tablero1[i-1][j] == 1){
                        vivos++;
                    }
                    if(tablero1[i-1][j+1] == 1){
                        vivos++;
                    }
                    if(tablero1[i][j-1] == 1){
                        vivos++;
                    }
                    if(tablero1[i][j+1] == 1){
                        vivos++;
                    }
                    if(tablero1[i+1][j-1] == 1){
                        vivos++;
                    }
                    if(tablero1[i+1][j] == 1){
                        vivos++;
                    }
                    if(tablero1[i+1][j+1] == 1){
                        vivos++;
                    }
                }else{
                    if(i == 0 && j == 0){
                        if(tablero1[i][j+1] == 1){
                            vivos++;
                        }
                        if(tablero1[i+1][j] == 1){
                            vivos++;
                        }
                        if(tablero1[i+1][j+1] == 1){
                            vivos++;
                        }
                    }else if(i == 0 && j > 0 && j < 9){
                        if(tablero1[i][j-1] == 1){
                            vivos++;
                        }
                        if(tablero1[i+1][j-1] == 1){
                            vivos++;
                        }
                        if(tablero1[i+1][j] == 1){
                            vivos++;
                        } 
                        if(tablero1[i+1][j+1] == 1){
                            vivos++;
                        }
                        if(tablero1[i][j+1] == 1){
                            vivos++;
                        }
                    }else if(i == 0 && i == 9){
                        if(tablero1[i][j-1] == 1){
                            vivos++;
                        }
                        if(tablero1[i+1][j-1] == 1){
                            vivos++;
                        }
                        if(tablero1[i+1][j] == 1){
                            vivos++;
                        }
                    }else if(i == 9 && j == 0){
                        if(tablero1[i-1][j] == 1){
                            vivos++;
                        }
                        if(tablero1[i-1][j+1] == 1){
                            vivos++;
                        } 
                        if(tablero1[i][j+1] == 1){
                            vivos++;
                        } 
                    }else if(i == 9 && j == 9){
                        if(tablero1[i][j-1] == 1){
                            vivos++;
                        } 
                        if(tablero1[i-1][j-1] == 1){
                            vivos++;
                        } 
                        if(tablero1[i-1][j] == 1){
                            vivos++;
                        } 
                    }else if(i > 0 && i < 9){
                        if(j == 0){
                            if(tablero1[i-1][j] == 1){
                                vivos++;
                            } 
                            if(tablero1[i-1][j+1] == 1){
                                vivos++;
                            }
                            if(tablero1[i][j+1] == 1){
                                vivos++;
                            } 
                            if(tablero1[i+1][j+1] == 1){
                                vivos++;
                            } 
                            if(tablero1[i+1][j] == 1){
                                vivos++;
                            } 
                        }else if(j == 9){
                            if(tablero1[i-1][j] == 1){
                                vivos++;
                            } 
                            if(tablero1[i-1][j-1] == 1){
                                vivos++;
                            } 
                            if(tablero1[i][j-1] == 1){
                                vivos++;
                            } 
                            if(tablero1[i+1][j-1] == 1){
                                vivos++;
                            } 
                            if(tablero1[i+1][j] == 1){
                                vivos++;
                            } 
                        }
                    }
                }
                if(vivos < 2 && tablero1[i][j] == 1){
                    temp[i][j] = 0;
               
                }else if(vivos > 3 && tablero1[i][j] == 1){
                    temp[i][j] = 0;
                }else if(vivos == 3 && tablero1[i][j] == 0){
                    temp[i][j] = 1;
                    Game.add(i+":"+j);
                }else if(vivos == 2 && tablero1[i][j] == 1){
                    temp[i][j] = 1;
                     Game.add(i+":"+j);
                }
            }
        }
        tablero1 = temp;
    
    }
    
    
    
    public void setTablero1(int[][] tablero1) {
        this.tablero1 = tablero1;
    }

    public int[][] getTablero2() {
        return tablero2;
    }

    public void setTablero2(int[][] tablero2) {
        this.tablero2 = tablero2;
    }

    public ArrayList<String> getGame() {
        return Game;
    }

    public void setGame(ArrayList<String> Game) {
        this.Game = Game;
    }

    public int getRon() {
        return ron;
    }

    public void setRon(int ron) {
        this.ron = ron;
    }
}
