/*
Will Fung and Grace Mazzarella
*/

import structure5.*;
import java.util.Scanner;

public class HumanPlayer implements Player{
  protected char color;

  public HumanPlayer(char color){
    this.color = color;
  }

  // pre: node is a non-null GameNode node; opponent is the player to play after this player
  // post: game is played from this node on, winning player is returned
  public GameNode play(GameNode node, Player opponent){
    // Heavily modeled after HexBoard's main method
    HexBoard board = node.currBoard;
    Vector<GameNode> moves = node.children;
    System.out.println(node.toSillyString());
    Scanner in = new Scanner(System.in);
    System.out.println("Please type one of the given integers: ");
    int hMove = in.nextInt() + 1;
    if (hMove > moves.size()){
      System.out.println("You have typed an invalid move. If you choose to type an invalid move again, you will forfeit the game.");
      hMove = in.nextInt() + 1;
      if (hMove > moves.size()){
        return node;
      } else {
        board = new HexBoard(board, moves.elementAt(hMove).hm);
      }
    }
    board = new HexBoard(board, moves.elementAt(hMove).hm);

    GameNode newNode = new GameNode(board.win(color), board, moves.elementAt(hMove).hm, opponent.color);

    System.out.println("This is the current board:");
    System.out.println(newNode.currBoard.toString());

    if (newNode.currBoard.win(this.color)){
      // If HumanPlayer wins, return HumanPlayer

      System.out.println("The human triumphs!");
      return node;

    } else {
      // If HumanPlayer didn't win, return current node
      return newNode;
    }
  }
}
