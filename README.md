# Sudoku Game
This program is a simple Sudoku solver that allows the user to input values and checks if they are valid. Once the puzzle is solved, it congratulates the user.
# How to use
- Run the program. 
- The initial state of the puzzle will be displayed. 
- Enter the row number, column number and value for each move. 
- If the move is valid, it will be added to the board and a success message will be displayed. 
- If the puzzle is solved, a congratulatory message will be displayed. 
# Code structure
The code consists of four main functions:
- main: This function initializes the board, takes input from the user and checks if moves are valid until the puzzle is solved.
- printBoard: This function prints out the current state of the board in a readable format.
- isValidMove: This function checks if a given move is valid by checking if there are any conflicts with existing values in its row, column or box.
- isSolved: This function checks if all cells on the board have been filled with valid values.
# Improvements made
- A constant variable EMPTY_CELL was introduced to replace -1, which was being used as a placeholder for an empty cell in the board array.
- The isValidMove function was optimized by breaking out of loops as soon as an invalid move was found instead of checking all cells in rows/columns/boxes.

