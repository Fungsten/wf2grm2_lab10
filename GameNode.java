/*
Will Fung and Grace Mazzarella
*/

import structure5.*;

public class GameNode{

  boolean isWin;
  HexBoard currBoard;
  char color;
  Vector<GameNode> possMoves;
  HexMove hm;

  public GameNode(boolean isWin, HexBoard hb, HexMove hm, char color){
    this.isWin = isWin;
    this.currBoard = hb;
    this.color = color;
    this.hm = hm;
    this.possMoves = new Vector<GameNode>();
  }

  public void addMove(GameNode gn){
    this.possMoves.add(gn);
  }

  public void removeMove(GameNode gn){
    this.possMoves.remove(gn);
  }

  public HexMove getMove(){
    return hm;
  }

  public String toSillyString(){
    String moves = "";
    moves = moves + "I look like this: \n" + this.currBoard.toString();
    for (int i = 0; i < this.possMoves.size(); ++i){
      moves = moves + "this.possMoves.elementAt(i).toString(): " + this.possMoves.elementAt(i).hm.toString() + "\n";
    }
    return moves;
  }

  public static void main(String[] args){
    char w = HexBoard.WHITE;
    GameNode potato = new GameNode(false, new HexBoard(3,3), new HexMove(1, 2, 3), w);
    GameNode tomato = new GameNode(false, new HexBoard(3,3), new HexMove(3,2,1), w);
    potato.addMove(tomato);
    System.out.println(potato.toSillyString());
  }

}
