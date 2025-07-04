# CLI Chess made in Java
This is a working chess game that can be played via the CLI on an ASCII chess board, it lets the user choose and move pieces, determines if the selected move is legal and checks for draws and checkmates before every turn. To try this project download and open the repository in a Java IDE and run `Main.java` located inside of the `src` folder.

<img width="192" alt="Screenshot 2024-12-27 171913" src="https://github.com/user-attachments/assets/3582df28-5089-417b-b448-1ef0236deec5" />

Above is a screenshot of the chess board showing the Queen's Gambit opening, when it is your turn select a piece by entering its position (example `E2`) 
and select where you want to move it (example `E4`). If you want to change your selected piece, any invalid input will let you go back and make another choice. 

After a piece and a move is selected the code will determine if the move is legal or not and let you 
move or let you choose a different move. The move counter can be seen in the bottom left corner of the chess board.

# Pieces
Each piece has its own icon on the terminal chess board where the first letter is the piece's colour and second letter is the first letter of the piece's name. A key can be seen below:

`00` = Empty Square

`WP` = White Pawn | `BP` = Black Pawn

`WN` = White Knight | `BN` = Black Knight

`WB` = White Bishop | `BB` = Black Bishop

`WR` = White Rook | `BR` = Black Rook

`WQ` = White Queen | `BQ` = Black Queen

`WK` = White King | `BK` = Black King
