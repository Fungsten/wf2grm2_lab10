//This is the file you should run to grade our project
//by the illustrious Grace Mazzarella and the absurd Will Fung (whose last name is not Fury)

import java.util.Scanner;
import structure5.*;

public class GamePlay{

  GameTree groot;
  GameNode currNode;
  Player p1;
  Player p2;
  int p1Wins;
  int p2Wins;


  public GamePlay(String playerOne, String playerTwo){
    this.groot = new GameTree();
    this.currNode = groot.groot;
    if (playerOne.equals("h")){
      this.p1 = new Player(playerOne, HexBoard.WHITE);
    } else if (playerOne.equals("r")){
      this.p1 = new Player(playerOne, HexBoard.WHITE);
    } else {
      this.p1 = new Player(playerOne, HexBoard.WHITE);
    }
    if (playerTwo.equals("h")){
      this.p2 = new Player(playerTwo, HexBoard.BLACK);
    } else if (playerTwo.equals("r")){
      this.p2 = new Player(playerTwo, HexBoard.BLACK);
    } else {
      this.p2 = new Player(playerTwo, HexBoard.BLACK);
    }
    this.p1Wins = 0;
    this.p2Wins = 0;
  }

  /*public Player go(){

  }*/

  protected GameNode goHelper(GameNode node, Player player, Player opponent){
    return player.play(node, opponent);
  }

  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    String arg1 = in.next();
    String arg2 = in.next();
    GamePlay hexapawn = new GamePlay(arg1, arg2);
    //hexapawn.go();
  }

}
