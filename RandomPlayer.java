/*
Will Fung and Grace Mazzarella
*/

import structure5.*;
import java.util.Random;

public class RandomPlayer implements Player{
  protected char rpColor;

  public RandomPlayer(char color){
    this.rpColor = color;
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
      // If RandomPlayer wins, return RandomPlayer
      System.out.println("RandomPlayer wins!");
      return this;
    } else {
      // If RandomPlayer didn't win, return opponent so that play may continue
      return opponent;
    }
  }
}
