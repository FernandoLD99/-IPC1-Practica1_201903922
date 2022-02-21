
package practica_1_2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Practica_1_2022 {

  //variable global aqui
    //para la matriz y los conteos
    public static String[][] tab;
    
    public static int punteoGlobal = 10;
    
    public static int puntajeMax;
    
    public static String nombreJugador;
    
    public static int movimientos = 0;
    
    public static String[] jugadoresRegistro = new String[10];
    
    public static int[] punteosRegistro = new int[10];
    
    public static int[] movimientosRegistro = new int[10];
    
    public static int contador = 0;
    
    
    

   
    public static void main(String[] args) {
         
         menu();
         
         
      
              
    }
    // El menu inicial 
    public static void menu(){
        
        System.out.println("");
        System.out.println("    Menu   ");
        System.out.println("1. Jugar");
        System.out.println("2. Historial");
        System.out.println("3. Salir");
        System.out.println("");
        System.out.print("Ingrese una opcion: ");
        int opcion;
        Scanner nc = new Scanner(System.in);
        opcion = nc.nextInt();
        
       
        if (opcion == 1) {
            
            jugador();
            seleccionar();
            
            
        }else if (opcion == 2) {
            historial();
        }else if (opcion == 3) {
            //cierra el programa
            System.exit(0);  
        }else{
            System.out.println("Seleccion incorrecta");
            System.out.println("");
            menu();
        }
        
        
    
    }
    
    //se carga el nombre del jugador y deberia guardarse 
    public static void jugador(){
     
        Scanner jugador = new Scanner(System.in);
        System.out.print("Ingrese nombre del jugador: ");
        nombreJugador = jugador.next();
        System.out.println("");
        
    }
    //Historial de jugadores
    public static void historial(){
        System.out.println("-----Historial de jugadores-----");
        if (jugadoresRegistro[0] == null) {
            System.out.println();
            System.out.println("Aun no hay partidas");
            System.out.println();
        }else{
            
        for (int i = 0; i < jugadoresRegistro.length; i++) {
            if (jugadoresRegistro[i] != null) {
            if(movimientosRegistro[i]!=0){  
            System.out.print(jugadoresRegistro[i] +" ");
            System.out.print(punteosRegistro[i] + " ");
            System.out.print(movimientosRegistro[i]);
            System.out.println("");
            }
           }
         }
        menu();
        }
        
    }
   public static void datosHistorial(){
       if(movimientos != 0){
       jugadoresRegistro[contador] = nombreJugador;
       punteosRegistro[contador] = punteoGlobal;
       movimientosRegistro[contador] = movimientos; 
       }
       
    }
        
        
   
   
      
    //metodos
    //Maneja la eleccion del usuario
    public static void seleccionar(){
        
        System.out.println("");
        System.out.println("Seleccione su dificultad");
        System.out.println("1. Facil");
        System.out.println("2. Intermedio");
        System.out.println("3. Dificil");
        System.out.println("");
        System.out.print("Ingrese una opcion(1-3): ");
        
        Scanner nc = new Scanner(System.in);
        int n;
        n = nc.nextInt();
        dificultad(n);
        
    }
    
    //unicamente el menu de la dificulad
    public static int dificultad(int n){
      
      if(n<4 && n>0){
          System.out.println("");
          System.out.println("Elegiste " + n);
          System.out.println("");
          tablero(n);
          playground(tab);
          
          

           
          
      }else{
            System.out.println("");
            System.out.println("Numero incorrecto");
             System.out.println("");
                seleccionar();         
        }
        
        return(n);
    }
    
    //Se encarga de rellenar el tablero que esta en la variable global 
    public static void tablero(int n){
        int f = 0;
        int c = 0;
        
        switch (n) {
            case 1: puntajeMax = 100;
                break;
            case 2: puntajeMax = 200;
                break;
            case 3: puntajeMax = 300;
                break;
            default:
                break;
        }
        
        //modifica el tablero segun la dificultad elegida
        if (n == 1) {
            f = 8;
            c = 8;
        }else if (n==2) {
            f = 12;
            c = 12;
        }else if (n==3) {
            f = 16;
            c = 16;
        }
        
        //se crea el tablero
        tab = new String[f][c];
        
        for (int i = 0; i < tab.length; i++) {
            tab[i][0]= " * ";
            tab[i][tab.length -1]= " * ";
            
            for (int j = 0; j <tab.length; j++) {
                tab[0][j] = " * "; 
                tab[tab.length - 1][j] = " * ";   
                if (tab[i][j] == null) {
                    tab[i][j] = "   ";
                }
            }
      
        }
        //El marco de la matriz ya esta hecho  
        //ahora se insertara los elementos al azar
        int pacman = 1;
        int cNumeral = 0;
        int cDinero = 0;
        int cArroba = 0;
        int cPared = 0;
        if (n==1) {    
            cNumeral = 5;
            cDinero = 4;
            cArroba = 7;
            cPared = 2;
        }else if (n==2) {
            cNumeral = 10;
            cDinero = 8;
            cArroba = 14;
            cPared = 3;
        }else if (n==3) {
            cNumeral = 17;
            cDinero = 14;
            cArroba = 24;
            cPared = 4;
        }
        for (int counter = 0; counter < cPared; counter++) {
             int pos1 = random(tab.length-3);
             int pos2 = random(tab.length-3);
                if (tab[pos1][pos2] == "   ") {
                        tab[pos1][pos2] = "|||";
                    tab[pos1 + 1][pos2] = "|||";
                    tab[pos1 + 2][pos2] = "|||";
                }else{ 
                   counter--;
                }
        }
        
        for (int counter = 0; counter < cNumeral; counter++) {
                int pos1 = random(tab.length);
                int pos2 = random(tab.length);
                if (tab[pos1][pos2] == "   ") {
                    tab[pos1][pos2] = " # "; 
                }else{ 
                   counter--;
                }
        }
        for (int counter = 0; counter < cDinero; counter++) {
             int pos1 = random(tab.length);
                int pos2 = random(tab.length);
                if (tab[pos1][pos2] == "   ") {
                    tab[pos1][pos2] = " $ "; 
                }else{ 
                   counter--;
                }
        }
        for (int counter = 0; counter < cArroba; counter++) {
             int pos1 = random(tab.length);
                int pos2 = random(tab.length);
                if (tab[pos1][pos2] == "   ") {
                    tab[pos1][pos2] = " @ "; 
                }else{ 
                   counter--;
                }
        }
        for (int counter = 0; counter < pacman; counter++) {
             int pos1 = random(tab.length);
                int pos2 = random(tab.length);
                if (tab[pos1][pos2] == "   ") {
                    tab[pos1][pos2] = " V "; 
                }else{ 
                   counter--;
                }
        }
        
                  
        
    }
    
    
    //area de juego  
    public static void playground(String[][] play){ 
        
        String opcion = " ";
        Scanner nc = new Scanner(System.in);
        
        
        //Bucle que imprime el juego
         while(!"L".equals(opcion)){ 
             
         if ("a".equals(opcion) || "s".equals(opcion) || "d".equals(opcion) || "w".equals(opcion)||"p".equals(opcion) || " ".equals(opcion)||"M".equals(opcion)) {    
                 if ("p".equals(opcion)) {
                     menuPausa();
                 }else if("M".equals(opcion)){
                     
                    datosHistorial();
                    contador++;
                    punteoGlobal = 0;
                    movimientos = 0;
                    menu();
                    
                 }else{ 
                //juegoTerminado();
                movimiento(opcion);
                System.out.println("Jugador: "+ nombreJugador +"  Punteo:" + punteoGlobal + "  Movimientos: " + movimientos);
                imprimir(play);  
                juegoTerminado();
                opcion =nc.next();
                //juegoTerminado();
                 
                 }
             }else{
             
             System.out.println("Comando no valido");
             System.out.println("Jugador: "+ nombreJugador +"  Punteo:" + punteoGlobal + "  Movimientos: " + movimientos);
             imprimir(play);
             opcion = nc.next();
         }
         
             
        }     
    }
    
    public static void menuPausa(){
    
        System.out.println("");
        System.out.println("    Pausa   ");
        System.out.println("1. Jugar");
        System.out.println("2. Historial");
        System.out.println("3. Salir");
        System.out.println("");
        System.out.print("Ingrese una opcion: ");
        int opcion;
        Scanner nc = new Scanner(System.in);
        opcion = nc.nextInt();
        if (opcion == 1) {
            
            playground(tab);
            
        }else if (opcion == 2) {
            historial();
        }else if (opcion == 3) {
            //cierra el programa
            System.exit(0);  
        }else{
            System.out.println("Seleccion incorrecta");
            System.out.println("");
            menuPausa();
        }
    }
    
    //controla el movimiento del pacman :V
    public static void movimiento(String opcion){
        int fila = buscarFila();
        int columna = buscarColumna();
        
        switch(opcion){
            
            case "w":
                tab[fila][columna] = "   ";
                if (fila-1 ==0) {
                    fila = tab.length-1;
                }else if("|||".equals(tab[fila-1][columna])){
                    fila = fila +1;
                }
                verificar(fila-1,columna);
                tab[fila-1][columna] = " V ";
                movimientos++;
                break;
                
            case "a":
                tab[fila][columna] = "   ";
                if (columna-1 ==0) {
                    columna = tab.length-1;
                }else if("|||".equals(tab[fila][columna-1])){
                    columna = columna +1;
                }
                verificar(fila,columna-1);
                tab[fila][columna-1] = " V ";
                movimientos++;
                break;
                
            case "s":
                tab[fila][columna] = "   ";
                if (tab[fila+1][columna] == " * ") {
                    fila = 0;
                }else if("|||".equals(tab[fila+1][columna])){
                    fila = fila - 1;
                }
                verificar(fila+1,columna);
                tab[fila+1][columna] = " V ";
                movimientos++;
                break;
                
            case "d":
                tab[fila][columna] = "   ";
                if (tab[fila][columna+1] == " * ") {
                    columna = 0;
                }else if("|||".equals(tab[fila][columna+1])){
                    columna = columna -1;
                }
                verificar(fila,columna+1);
                tab[fila][columna+1] = " V ";
                movimientos++;
                break; 
        }      
    
    }
    
    //verifican que items hay 
    public static void verificar(int fila, int columna){
    
        switch(tab[fila][columna]){
            case " @ ":
                punteoGlobal = punteoGlobal + 10;
                break;
            case " # ":
                punteoGlobal = punteoGlobal - 10;  
                break;
            case " $ ":
                 punteoGlobal = punteoGlobal + 15; 
                break; 
        }
    
    }
      
    
    //estos metodos encuentran la posicion del jugador
    public static int buscarFila(){
     int fila = 0; 
     for (int i = 0; i < tab.length; i++) {        
            for (int j = 0; j < tab[i].length; j++) {
                
                if (" V ".equals(tab[i][j])) {
                    fila = i;
                    
                }
                               
            }
        }
    return fila;
    }
    public static int buscarColumna(){
      int columna = 0;
     for (int i = 0; i < tab.length; i++) {        
            for (int j = 0; j < tab[i].length; j++) {
                
                if (" V ".equals(tab[i][j])) {
                    columna = j;
                    
                }
                               
            }
        }
    return columna;
    }
    
    
    
    
    //metodo para imprimir el tablero 
    public static void imprimir(String[][] tabla){
        for (int i = 0; i < tabla.length; i++) {
            
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.print(tabla[i][j]);               
            }
            System.out.println("");
        }
    }
    
    
    public static void juegoTerminado(){
        if (punteoGlobal >= puntajeMax) {
            System.out.println("");
             System.out.println("");
              System.out.println("");
            System.out.println("Felicidades has ganado");
             System.out.println("");
              System.out.println("");
               System.out.println("");
               datosHistorial();
                    contador++;
                    punteoGlobal = 0;
                    movimientos = 0;
                    menu();
              System.out.println("");
        }else if(contadorComida(tab) == 0 ){
             System.out.println("");
             System.out.println("");
              System.out.println("");
            System.out.println("Felicidades has ganado");
             System.out.println("");
              System.out.println("");
               System.out.println("");
               datosHistorial();
                    contador++;
                    punteoGlobal = 0;
                    movimientos = 0;
                    menu();
                    
             System.out.println("");
             
        }else if (punteoGlobal < 0) {
            System.out.println("");
             System.out.println("");
              System.out.println("");
            System.out.println("Felicidades has perdido");
             System.out.println("");
              System.out.println("");
               System.out.println("");
               datosHistorial();
                    contador++;
                    punteoGlobal = 0;
                    movimientos = 0;
                    menu();
                    System.out.println("");

            
        }
        
    }   
    
    public static int contadorComida(String[][] tab){
        int n = 0;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                if (tab[i][j]== " @ " || tab[i][j]== " $ ") {
                    n = 1;
                }
            }
                
        }
    
        return n;
    }
   
    //generador de enteros al azar n = lo que mide el tablero 
    public static int random(int n){
    
    int random = (int)(Math. random()*(n-2)+1);
    
    return random;
    }

   
}
