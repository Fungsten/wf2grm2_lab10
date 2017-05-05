/*
Will Fung and Grace Mazzarella
*/

import structure5.*;

public class GameNode{

  boolean isWin;
  HexBoard currBoard;
  char color;
  Vector<GameNode> children;
  HexMove hm;

  public GameNode(boolean isWin, HexBoard hb, HexMove hm, char color){
    this.isWin = isWin;
    this.currBoard = hb;
    this.color = color;
    this.hm = hm;
    this.children = new Vector<GameNode>();
  }

  public void addChild(GameNode gn){
    this.children.add(gn);
  }

  public void removeChild(GameNode gn){
    this.children.remove(gn);
  }

  public HexMove getChild(){
    return hm;
  }

  public String toSillyString(){
    String moves = "";
    moves = moves + "The board will look like this: \n" + this.currBoard.toString();
    for (int i = 0; i < this.children.size(); ++i){
      moves = moves + "Possible move " + (i + 1) + ": " + this.children.elementAt(i).hm.toString() + "\n";
    }
    return moves;
  }

  public static void main(String[] args){
    GameNode potato = new GameNode(false, new HexBoard(3,3), new HexMove(1, 2, 3), HexBoard.WHITE);
    GameNode tomato = new GameNode(false, new HexBoard(3,3), new HexMove(3,2,1), HexBoard.BLACK);
    potato.addChild(tomato);
    System.out.println(potato.toSillyString());
  }

}
