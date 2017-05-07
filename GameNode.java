/*
Will Fung and Grace Mazzarella

I hope you like nodes more than we do.
Because it's always better to like something than to dislike something
Unless it's the plague. Or lobotomy. Or pineapple on pizza. That sort of thing.
*/

import structure5.*;

public class GameNode{

  boolean isWin;
  HexBoard currBoard;
  char color;
  Vector<GameNode> children;
  HexMove hm;

  //creates a gamenode with parameters detailing whether or not the node
  //is a win, what the board state at the node is, what move got the board
  //to such a state, and whose turn the node represents
  public GameNode(boolean isWin, HexBoard hb, HexMove hm, char color){
    this.isWin = isWin;
    this.currBoard = hb;
    this.color = color;
    this.hm = hm;
    this.children = new Vector<GameNode>();
  }

  //adds a gamenode to the children of the parent node
  public void addChild(GameNode gn){
    this.children.add(gn);
  }

  //removes a gamenode from the children of the parent node
  //(not actually used, but for the purposes of completion / debugging)
  public void removeChild(GameNode gn){
    this.children.remove(gn);
  }

  //returns the move of the node
  public HexMove getChild(){
    return hm;
  }

  //we get to see the node in string format
  //because humans need to read this too
  public String toSillyString(){
    String moves = "";
    moves = moves + "The board will look like this: \n" + this.currBoard.toString();
    for (int i = 0; i < this.children.size(); ++i){
      moves = moves + "Possible move " + (i + 1) + ": " + this.children.elementAt(i).hm.toString() + "\n";
    }
    return moves;
  }

  //you say potahto, I say potato
  //you say tomato, I say tornado
  public static void main(String[] args){
    GameNode potato = new GameNode(false, new HexBoard(3,3), new HexMove(1, 2, 3), HexBoard.WHITE);
    GameNode tomato = new GameNode(false, new HexBoard(3,3), new HexMove(3,2,1), HexBoard.BLACK);
    potato.addChild(tomato);
    System.out.println(potato.toSillyString());
  }

}
