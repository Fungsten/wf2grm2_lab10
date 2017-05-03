# wf2grm2_lab10

Procedure. During the course of this project you are to
1. Construct a tree of Hex-a-Pawn board positions. Each node of the tree is called a GameTree. The structure of the class is of your own design, but it is likely to be similar to the BinaryTree implementation.
2. Construct three classes of Players that play the game of Hex-a-Pawn. These three classes may interact in pairs to play a series of games.
Available for your use are three Javafiles:
HexBoard This class describes the state of a board. The default board is the 3×3 starting position. You can ask a board to print itself out (toString) or to return the HexMoves (moves) that are possible from this position. You can also ask a HexBoard if the current position is a win for a particular color— HexBoard.WHITE or HexBoard.BLACK. A static utility method, opponent, takes a color and returns the opposite color. The main method of this class demonstrates how HexBoards are manipulated.
HexMove This class describes a valid move. The components of the Vector re- turned from the HexBoard.moves contains objects of type HexMove. Given a HexBoard and a HexMove one can construct the resulting HexBoard using a HexBoard constructor.


Binary Trees
Player When one is interested in constructing players that play Hex-a-Pawn, the Player interface describes the form of the play method that must be provided. The play method takes a GameTree node and an opposing Player. It checks for a loss, plays the game according to the GameTree, and then turns control over to the opposing player.
Read these class files carefully. You should not expect to modify them.
There are many approaches to experimenting with Hex-a-Pawn. One series
of experiments might be the following:
1. Compile HexBoard.java and run it as a program. Play a few games against the computer. You may wish to modify the size of the board. Very little is known about the games larger than 3 × 3.
2. Implement a GameTree class. This class should have a constructor that, given a HexBoard and a color (a char, HexBoard.WHITE or HexBoard.BLACK), generates the tree of all boards reachable from the specified board posi- tion during normal game play. Alternate levels of the tree represent boards that are considered by alternate players. Leaves are winning positions for the player at hand. The references to other GameTree nodes are suggested by the individual moves returned from the moves method. A complete game tree for 3 × 3 boards has 252 nodes.
3. Implement the first of three players. It should be called HumanPlayer. If it hasn’t already lost (i.e., if the opponent hasn’t won), this player prints the board, presents the moves, and allows a human (through a ReadStream) to select a move. The play is then handed off to the opponent.
4. The second player, RandPlayer, should play randomly. Make sure you check for a loss before attempting a move.
5. Thethirdplayer,calledCompPlayer,shouldattempttohavetheCompPlayer object modify the game tree to remove losing moves.
Clearly, Players may be made to play against each other in any combination.



Thought Questions. Consider the following questions as you complete the lab:
1. How many board positions are there for the 3 × 4 board? Can you deter- mine how many moves there are for a 3 × 5 board?
2. If you implement the learning machine, pit two machines against each other. Gardner called the computer to move first H.I.M., and the ma- chine to move second H.E.R. Will H.I.M. or H.E.R. ultimately win more frequently? Explain your reasoning in a short write-up. What happens for larger boards?
