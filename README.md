## Chess game

**Main.java** defines the game engine loop.
- Players take turn alternatively. - Prompt asks player to enters start and end position of the piece they want to move.
- After each turn, the board is printed to show current state.

**Game.java**
- The logic for game movement, like movement of pieces, killing, keeping track of turn and game termination.

**Board.java**
- Defaut setup and state of game (piece position) tracking.

**Player.java**
- Person who is active in a game.
- Which side (white/black) is a player on.

**Piece.java**
- Abstract class, defines attributes like colour, ability to move, live/dead status.
- Classes like `Pawn.java`, `Bishop.java`, `Queen.java`, extend this class and define the particular movement abilities. 

**Spot.java**
- Keeps track of a particular spot on board. 
- Attributes : x-cord, y-cord, Piece.


---

  

What is index.js doing?  
Nothing, thats for future extension.
