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
    this.groot = new HexBoard();
    this.currNode = groot.groot;
    if (playerOne.equals("h")){
      this.h1 = new HumanPlayer(HexBoard.WHITE);
    } else if (playerOne.equals("r")){
      this.r1 = new RandomPlayer(HexBoard.WHITE);
    } else if (playerOne.equals("c")){
      this.c1 = new OurNewRobotOverlord(HexBoard.WHITE);
    } else {
      System.out.println("Please input a valid player type or else you'll have to start from the beginning.");
      GamePlay(playerOne, playerTwo);
    }
    if (playerTwo.equals("h")){
      this.h2 = new HumanPlayer(HexBoard.BLACK);
    } else if (playerTwo.equals("r")){
      this.r2 = new RandomPlayer(HexBoard.BLACK);
    } else if (playerTwo.equals("c")){
      this.c2 = new OurNewRobotOverlord(HexBoard.BLACK);
    } else {
      System.out.println("Please input a valid player type or else you'll have to start from the beginning.");
      GamePlay(playerOne, playerTwo);
    }
    this.p1Wins = 0;
    this.p2Wins = 0;
  }

  public Player go(){
    if (this.h1 != null){
      while (!this.h1.go().equals(this.h1)){
        this.h1.go();
      }
    } else if (this.r1 != null){

    } else {
      this.c1.go();
    }
  }

  public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    String arg1 = in.nextString();
    String arg2 = in.nextString();
    GamePlay hexapawn = new GamePlay(arg1, arg2);
    hexapawn.go();
  }

}
