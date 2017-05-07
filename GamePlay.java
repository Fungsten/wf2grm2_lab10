//This is the file you should run to grade our project
//by the illustrious Grace Mazzarella and the absurd Will Fung (whose last name is not Fury)

import java.util.Scanner;
import structure5.*;

public class GamePlay{

  GameTree groot;
  GameNode currNode;
  HumanPlayer h1;
  HumanPlayer h2;
  RandomPlayer r1;
  RandomPlayer r2;
  OurNewRobotOverlord c1;
  OurNewRobotOverlord c2;
  int p1Wins;
  int p2Wins;


  public GamePlay(String playerOne, String playerTwo){
    this.groot = new GameTree();
    this.currNode = groot.groot;
    if (playerOne.equals("h")){
      this.h1 = new HumanPlayer(HexBoard.WHITE);
    } else if (playerOne.equals("r")){
      this.r1 = new RandomPlayer(HexBoard.WHITE);
    } else {
      this.c1 = new OurNewRobotOverlord(HexBoard.WHITE, new GameTree());
    }
    if (playerTwo.equals("h")){
      this.h2 = new HumanPlayer(HexBoard.BLACK);
    } else if (playerTwo.equals("r")){
      this.r2 = new RandomPlayer(HexBoard.BLACK);
    } else {
      this.c2 = new OurNewRobotOverlord(HexBoard.BLACK, new GameTree());
    }
    this.p1Wins = 0;
    this.p2Wins = 0;
  }

  /*public Player go(){
    if (this.h1 != null){
      while (!this.h1.go().equals(this.h1)){
        this.h1.play();
      }
    } else if (this.r1 != null){

    } else {
      this.c1.go();
    }
  }*/

  /*protected Player goHelper(GameNode node, Player){

  }*/

  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    String arg1 = in.next();
    String arg2 = in.next();
    GamePlay hexapawn = new GamePlay(arg1, arg2);
    //hexapawn.go();
  }

}
