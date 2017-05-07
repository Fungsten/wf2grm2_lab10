/*
A file written by Grace and Will
which has been overwritted by Grace and Will as well

import structure5.*;

public class OurNewRobotOverlord implements Player{
  protected char rpColor;
  protected GameTree gameTree;


  //the learning computer player is basically just the random player
  //the important difference is that tue computer player's options are increasingly
  //limited as more and more games are played
  public OurNewRobotOverlord(char color, GameTree tree){
    this.rpColor = color;
    this.gametree = tree;
  }

  // pre: node is a non-null GameNode node; opponent is the player to play after this player
  // post: game is played from this node on, winning player is returned
  public Player play(GameNode node, Player opponent){
    // Heavily modeled after HexBoard's main method
    HexBoard board = node.currBoard;
    Vector<HexMove> moves = node.currBoard.moves(node.color);
    System.out.println(node.toSillyString());
    Random rand = new Random();
    int rpMove = rand.nextInt(moves.size());
    board = new HexBoard(board, moves.elementAt(rpMove));
    System.out.println("This is the current board:");
    System.out.println(board.toString());

    if (board.win(this.rpColor)){
      // If our new robot overlord wins, return OurNewRobotOverlord
      System.out.println("Our new robot overlord wins! Like we ever had a chance");
      return this;
    } else {
      // If our new robot overlord didn't win, return opponent so that play may continue

      //prune tree here and we will be one step closer to world domination
      //*insert evil laugh here*


      node.removeChild(node);
      //remove child, if node does not have children, forfeit and prune



      return opponent;
    }
  }
}
*/
