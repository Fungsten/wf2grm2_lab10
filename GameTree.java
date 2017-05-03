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

  GameTree(){
    this.groot = new GameNode(false, this.b, null, this.color);
  }

  public void addNodes(GameNode parent, char color){
    System.out.println("this.b.moves(color).size(): " + parent.currBoard.moves(color).size());
    GameNode gn;

  	Vector<HexMove> moves;
    HexBoard newB;
  	int move = 0;

    // move to play
    moves = parent.currBoard.moves(color);
    System.out.println(moves.size());
    Iterator iter = moves.iterator();
    while (iter.hasNext()){

      // read move
      newB = new HexBoard(parent.currBoard, moves.elementAt(move));
      gn = new GameNode(newB.win(color), newB, moves.elementAt(move), color);
      System.out.println(gn.toString());
      parent.addMove(gn);
      nodenumber++;
      iter.next();
      move++;
    }
    for (int i = 0; i < parent.possMoves.size(); i++){
      int counter = 0;
      if (parent.isWin == true){
        // pass
      } else {
        if (counter % 2 == 0){
          addNodes(parent.possMoves.elementAt(i), HexBoard.WHITE);
          counter++;
        } else {
          addNodes(parent.possMoves.elementAt(i), HexBoard.BLACK);
          counter++;
        }
      }
    }
  }

  /*public void populate(GameNode parent){
    int counter = 0;
    if (parent.isWin == true){
      // pass
    } else {
      if (counter % 2 == 0){
        addNodes(parent, HexBoard.WHITE);
      } else {
        addNodes(parent, HexBoard.BLACK);
      }

    }
  }*/







  public static void main(String[] args){
    System.out.println("I compiled!");
    GameTree babygroot = new GameTree();
    babygroot.addNodes(babygroot.groot, WHITE);
    System.out.println("node number: " + babygroot.nodenumber);
  }

}
