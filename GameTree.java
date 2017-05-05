/*
Will Fung and Grace Mazzarella
*/

import java.util.Iterator;
import structure5.*;

public class GameTree{

  GameNode groot;
  HexBoard board;
  char color; // needed? A node-only thing?
  public final static char WHITE = 'o';
  public final static char BLACK = '*';
  int nodeNumber;
  int counter;


  public GameTree(){
    this.board = new HexBoard();
    this.groot = new GameNode(false, this.board, null, HexBoard.BLACK);
    this.nodeNumber = 0;
    this.counter = 0;
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
    nodeNumber = nodeNumber + moves.size();
    Iterator iter = moves.iterator();
    while (iter.hasNext()){

      // read move
      newB = new HexBoard(parent.currBoard, moves.elementAt(move));
      gn = new GameNode(newB.win(color), newB, moves.elementAt(move), color);
      //System.out.println(gn.toString());
      parent.addChild(gn);
      iter.next();
      move++;
    }
    /*
    for (int i = 0; i < parent.children.size(); i++){

      if (counter % 2 == 0){
        addNodes(parent.children.elementAt(i), HexBoard.WHITE);
      } else {
        addNodes(parent.children.elementAt(i), HexBoard.BLACK);
      }

      if (parent.isWin == true){
      } else {
        if (parent.color == HexBoard.BLACK){
          addNodes(parent.children.elementAt(i), HexBoard.WHITE);
        } else {
          addNodes(parent.children.elementAt(i), HexBoard.BLACK);
        }
      }
    }
    */
  }


  public void populate(GameNode parent){
    if (parent.children.size() == 0 || parent.isWin == true){
      System.out.println("nodeNumber: " + this.nodeNumber);
    } else {
      for (int i = 0; i < parent.children.size(); i++){
        System.out.println("nodeNumber: " + this.nodeNumber);
        if (parent.color == HexBoard.BLACK){
          //System.out.println("I passed! tutrle");
          addNodes(parent, HexBoard.WHITE);
          //System.out.println("I passed! poato");
          populate(parent.children.elementAt(i));
          //System.out.println("I passed! tornato");
        } else {
          //System.out.println("I passed! black");
          addNodes(parent, HexBoard.BLACK);
          populate(parent.children.elementAt(i));
        }
      }
    }
  }

  public static void main(String[] args){
    GameTree babygroot = new GameTree();
    babygroot.addNodes(babygroot.groot, HexBoard.BLACK);
    System.out.println(babygroot.groot.toSillyString());
    System.out.println(babygroot.groot.children.toString());
    /*for (int i = 0; i < babygroot.groot.children.size(); ++i){
      System.out.println(babygroot.groot.children.elementAt(i));
      System.out.println(babygroot.groot.children.elementAt(i).toSillyString());
    }*/
    babygroot.populate(babygroot.groot);
    System.out.println("node number: " + babygroot.nodeNumber);
  }

}
