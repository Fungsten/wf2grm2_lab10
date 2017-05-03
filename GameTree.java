/*
Will Fung and Grace Mazzarella
*/

import java.util.Iterator;
import structure5.*;

class GameTree{

  GameNode groot;
  HexBoard b = new HexBoard(3, 3);
  char color;
  public final static char WHITE = 'o';
  public final static char BLACK = '*';
  int nodenumber = 0;
  int counter = 0;


  GameTree(){
    this.groot = new GameNode(false, this.b, null, BLACK);
  }


  public void addNodes(GameNode parent, char color){
    //System.out.println("this.b.moves(color).size(): " + parent.currBoard.moves(color).size());
    GameNode gn;

  	Vector<HexMove> moves;
    HexBoard newB;
  	int move = 0;

    // move to play
    moves = parent.currBoard.moves(color);
    //System.out.println(moves.size());
    nodenumber = nodenumber + moves.size();
    Iterator iter = moves.iterator();
    while (iter.hasNext()){

      // read move
      newB = new HexBoard(parent.currBoard, moves.elementAt(move));
      gn = new GameNode(newB.win(color), newB, moves.elementAt(move), color);
      //System.out.println(gn.toString());
      parent.addMove(gn);
      iter.next();
      move++;
    }
    /*
    for (int i = 0; i < parent.possMoves.size(); i++){

      if (counter % 2 == 0){
        addNodes(parent.possMoves.elementAt(i), HexBoard.WHITE);
      } else {
        addNodes(parent.possMoves.elementAt(i), HexBoard.BLACK);
      }

      if (parent.isWin == true){
      } else {
        if (parent.color == HexBoard.BLACK){
          addNodes(parent.possMoves.elementAt(i), HexBoard.WHITE);
        } else {
          addNodes(parent.possMoves.elementAt(i), HexBoard.BLACK);
        }
      }
    }
    */
  }


  public void populate(GameNode parent){
    if (parent.possMoves.size() == 0 || parent.isWin == true){
      System.out.println("Winner winner chicken dinner");
    } else {
      for (int i = 0; i < parent.possMoves.size(); i++){
        System.out.println("WEE WOO WEE WOO");
        if (parent.color == HexBoard.BLACK){
          //System.out.println("I passed! tutrle");
          addNodes(parent, HexBoard.WHITE);
          //System.out.println("I passed! poato");
          populate(parent.possMoves.elementAt(i));
          //System.out.println("I passed! tornato");
        } else {
          //System.out.println("I passed! black");
          addNodes(parent, HexBoard.BLACK);
          populate(parent.possMoves.elementAt(i));
        }
      }
    }
  }







  public static void main(String[] args){
    System.out.println("I compiled!");
    GameTree babygroot = new GameTree();
    babygroot.addNodes(babygroot.groot, HexBoard.BLACK);
    System.out.println(babygroot.groot.toSillyString());
    System.out.println("I passed!");
    //babygroot.populate(babygroot.groot);
    System.out.println("node number: " + babygroot.nodenumber);
  }

}
