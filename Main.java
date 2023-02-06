import java.util.Arrays;
import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner (System.in);
    char [][] tab = new char [8][8];
    for (int i=0; i< tab.length; i++){
      Arrays.fill(tab[i],'O');
    }
    int[]score = new int [5];
    for(int i=0; i< score.length; i++){
        score[i] = i +1;
    }
    int ships = 5;
    while (ships > 0){
      System.out.println ("Jugador1: Ingrese la posicion de su barco. 0 a 7 (fila y columna)");
      int fila = scan.nextInt();
      int columna = scan.nextInt();
      if(fila >= 0 && fila < 8 && columna >=0 && columna < 8 && tab[fila][columna]=='O'){
        tab[fila][columna] = 'B';
        System.out.println("Barco colocado. Puntaje: "+score[ships -1]);
        ships--;
      }else{
        System.out.println("Posición inválida. Intente denuevo");
      }
      System.out.println("Tablero con sus barcos:");
      for (int i=0; i < tab.length; i++){
        for(int j = 0; j < tab.length; j++){
            System.out.print(tab[i][j]+" ");

        }
        System.out.println();

      }
    }
    int intentos = 20;
    int puntaje = 0;
    int hundidos = 0;

    while (intentos > 0){
        System.out.println("Jugador2: Ingrese la posición de su disparo. 0 a 7( fila y columna)");
        System.out.println("Disparos restantes:"+ intentos);
        int fila = scan.nextInt();
        int columna = scan.nextInt();
        if(fila >= 0 && fila < 8 && columna >=0 && columna < 8){
           if(tab[fila][columna]=='B'){
            System.out.println("Ha dado!");
            char anterior =tab [fila][columna];
            tab[fila][columna] = 'X';
            if(anterior == 'B'){
                puntaje += score[hundidos];
                hundidos++;
            }
            if(hundidos == 5){
                System.out.println("Todos los barcos han sido hundidos");
                break;
            }
           } else {
            System.out.println("Ha fallado");
            tab[fila][columna]='-';
    
           }
           intentos--;
        }else{
            System.out.println("Disparo inválido. Intente denuevo");
    
        }
    
        System.out.println("Tablero con sus disparos:");
        for (int i=0; i < tab.length; i++){
          for(int j = 0; j < tab.length; j++){
              System.out.print(tab[i][j]+" ");
    
          }
          System.out.println();
        }
       
    }
    System.out.println("El juego ha terminado. Puntaje final: " + puntaje);

    
  
}
}