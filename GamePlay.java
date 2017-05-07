//This is the file you should run to grade our project
//by the illustrious Grace Mazzarella and the absurd Will Fung (whose last name is not Fury)

import java.util.Scanner;
import structure5.*;

public class GamePlay{

  GameTree root;
  GameNode currNode;
  Player p1;
  Player p2;
  int p1Wins;
  int p2Wins;


  public GamePlay(String playerOne, String playerTwo){
    this.root = new GameTree();
    this.currNode = root.groot;
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

  protected Player oppPlayer(Player currPlayer){
    if (currPlayer.equals(this.p1)){
      return this.p2;
    } else {
      return this.p1;
    }
  }

  public void go(){
    Player currPlayer = this.p1;
    GameNode playedNode = this.root.groot;

    while (!currPlayer.currNode.equals(playedNode)){
      currPlayer.play(playedNode, oppPlayer(currPlayer));
      currPlayer = oppPlayer(currPlayer);
      playedNode = currPlayer.currNode;
    }
    if (currPlayer.equals(this.p1)){
      ++this.p1Wins;
    } else {
      ++this.p2Wins;
    }
  }

  public static void main(String args[]){
    /*Scanner in = new Scanner(System.in);
    System.out.println("Player 1: please input 'h' to play as yourself, 'r' to watch a random player play, or 'c' to watch a learning computer play.");
    String arg1 = in.next();
    System.out.println("Player 2: please input 'h' to play as yourself, 'r' to watch a random player play, or 'c' to watch a learning computer play.");
    String arg2 = in.next();*/
    GamePlay hexapawn = new GamePlay("h", "r");
    //System.out.println(hexapawn.currNode.children.size());
    hexapawn.go();
    System.out.println("P1 wins: " + hexapawn.p1Wins);
    System.out.println("P2 wins: " + hexapawn.p2Wins);
  }

}
