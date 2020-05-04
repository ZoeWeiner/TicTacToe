/** 
 *"__" means nothing is on the board 
 *constroutor makes clear board 
 * to string just puts it all together 
 */ 
import java.util.Scanner; 
/** 
 * Creates tic tac toe game. 
 */ 
public class tt_Board { 
  public static String [][] Board = new String[3][3]; 
  public static String wins= ""; 
  private static boolean playerOne; // true if its player one' turn (they are X's) 
   
  public static void main(String[] args) {  
    System.out.println(toStrings("empty")); 
    while(!gameOver()) { 
      validMove(); 
      System.out.println(toStrings()); 
      gameOver(); 
      System.out.println(wins); 
    } 
  } 
  /** 
   * Sets the board to empty and fills spaces with "__" 
   * @param me This is a matrix 
   * @return the matrix filled with "__" 
   */ 
  public static String[][] Empty(String[][]me){ 
    for(int a=0;a<3;a++){ 
      for(int s=0; s<3;s++){ 
        me[a][s]="__"; 
      }} 
    gameOver(); 
    return me; 
  } 
  /** 
   * Determines if the players move is valid and then places an "X" at the point the player chooses 
   */ 
  public static void validMove() { 
    boolean invalidMove = true; 
    int row = 0; 
    int col = 0; 
    Scanner scan = new Scanner(System.in); 
    while(invalidMove) { 
      System.out.println("Please enter a row"); 
      row = scan.nextInt(); 
      System.out.println("Please a column"); 
      col = scan.nextInt(); 
      if(row >= 0 && row <= 2 && col >= 0 && col <= 2) { 
        if(Board[row][col] != "__") { 
          System.out.println("This position is taken. Please enter another."); 
        } 
        else { 
          invalidMove = false; 
        } 
      } 
      else { 
        System.out.println("This position is not valid"); 
      } 
    } 
    if( Board[row][col] == "__") { 
      Board[row][col] = "X"; 
      CompMove(row,col); 
    } 
  } 
  /** 
   * Represents the computers move. Places "O" on board. 
   * @param row, col This is the position of the row and column on board 
   */ 
  public static void CompMove(int row,int col){ 
    if((row==col)&&(row==0)){Board[row][col+2]="O";}else 
      if((row==col)&&(row==1)){Board[row+1][col-1]="O";}else 
        if((row==col)&&(row==2)){Board[row][col/2]="O";}else 
        {Board[col][row]="O";} 
  } 
  /** 
   * @param 
   * @return the empty board 
   */ 
  public static String toStrings(String a){ 
    Empty(Board); 
    String line1= Board[0][0]+" "+Board[0][1]+" "+Board[0][2]; 
    String line2= Board[1][0]+" "+Board[1][1]+" "+Board[1][2]; 
    String line3= Board[2][0]+" "+Board[2][1]+" "+Board[2][2]; 
    return line1+"\n"+line2+"\n"+line3+"\n"; 
  } 
    /** 
     * @return the board that takes parameters 
     */ 
  public static String toStrings(){ 
    String line1= Board[0][0]+" "+Board[0][1]+" "+Board[0][2]; 
    String line2= Board[1][0]+" "+Board[1][1]+" "+Board[1][2]; 
    String line3= Board[2][0]+" "+Board[2][1]+" "+Board[2][2]; 
    return line1+"\n"+line2+"\n"+line3+"\n"; 
  } 
  /** 
   * @return if the game is over or not 
   * considering all possible actions of 3 in a row 
   */ 
  public static boolean gameOver(){ 
    boolean over=false; 
    if(over==false){wins="Keep Playing!";} 
    /**line by line or by row*/ 
    if((Board[0][0]=="X")&&(Board[0][1]=="X")&&(Board[0][2]=="X")){over=true;wins="X wins";} 
    if((Board[1][0]=="X")&&(Board[1][1]=="X")&&(Board[1][2]=="X")){over=true;wins="X wins";} 
    if((Board[2][0]=="X")&&(Board[2][1]=="X")&&(Board[2][2]=="X")){over=true;wins="X wins";} 
    /**by collum*/ 
    if((Board[0][0]=="X")&&(Board[1][0]=="X")&&(Board[2][0]=="X")){over=true;wins="X wins";} 
    if((Board[0][1]=="X")&&(Board[1][1]=="X")&&(Board[2][1]=="X")){over=true;wins="X wins";} 
    if((Board[0][2]=="X")&&(Board[1][2]=="X")&&(Board[2][2]=="X")){over=true;wins="X wins";} 
    /**by diagonal*/ 
    if((Board[0][0]=="X")&&(Board[1][1]=="X")&&(Board[2][2]=="X")){over=true;wins="X wins";} 
    if((Board[2][0]=="X")&&(Board[1][1]=="X")&&(Board[0][2]=="X")){over=true;wins="X wins";} 
    /*Space for eyes because thats crowded*/ 
    /**by row*/ 
    if((Board[0][0]=="O")&&(Board[0][1]=="O")&&(Board[0][2]=="O")){over=true;wins="O wins";} 
    if((Board[1][0]=="O")&&(Board[1][1]=="O")&&(Board[1][2]=="O")){over=true;wins="O wins";} 
    if((Board[2][0]=="O")&&(Board[2][1]=="O")&&(Board[2][2]=="O")){over=true;wins="O wins";} 
    /**by collum*/ 
    if((Board[0][0]=="O")&&(Board[1][0]=="O")&&(Board[2][0]=="O")){over=true;wins="O wins";} 
    if((Board[0][1]=="O")&&(Board[1][1]=="O")&&(Board[2][1]=="O")){over=true;wins="O wins";} 
    if((Board[0][2]=="O")&&(Board[1][2]=="O")&&(Board[2][2]=="O")){over=true;wins="O wins";} 
    /**by diagonal*/ 
    if((Board[0][0]=="O")&&(Board[1][1]=="O")&&(Board[2][2]=="O")){over=true;wins="O wins";} 
    if((Board[2][0]=="O")&&(Board[1][1]=="O")&&(Board[0][2]=="O")){over=true;wins="O wins";} 
    return over; 
  } 
}