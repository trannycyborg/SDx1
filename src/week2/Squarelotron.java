package wk2Homework;

/*Author: TrannyCyborg

Project: Squarelotron

Date: January 2020*/



/*A Squarelotron consists basically of a matrix of numbers.

This matrix can be decomposed as square rings which can flip

independently in two different ways: Upside-Down and through

the Main Diagonal.*/

import java.util.*;

public class Squarelotron {
  
        //instance variables
              int[][] squarelotron;
              int size;

              /*This constructor fills the 2-dimensional array with
               * the numbers 1 to n squared, in order. It also sets 
               * the size instance variable to be n.*/
              public Squarelotron(int n) {
                size = n; //This will be the row and column length
                int num = 1; //This is the first number in the array.
                squarelotron= new int[n][n];
                
                //nested for loop to populate the array with numbers 1 to n.
                for(int i = 0; i < size; i++) {
                  for(int j = 0; j < size; j++) {
                    squarelotron[i][j] = num;
                    num ++;
                  }
                }
                
              }

              /*This method performs the Upside-Down Flip of the
              squarelotron.The original squarelotron should not be
              modified (we will check for this).*/
              public Squarelotron upsideDownFlip(int ring) {    
                /*Create a new temporary Squarelotron of the same 
                 * dimensions to populate with the flipped matrix.*/
                Squarelotron temp = new Squarelotron(this.size);
                  //Loop through the matrix.
                for (int i = 0; i < size; i++){     //Start at the index 0 rows.
                      for (int j = 0; j < size; j++){   //Start at the index 0 columns.
                        /*The OR conditional determines if the row/column address is in the
                         * outer rings. If the address is of the innermost ring the 
                         * conditions are not met, and it defers to the else statement.*/
                          if(i == ring - 1 || i == size - ring || j == ring - 1 || j == size - ring){
                            //Populate the temp array with the opposite row same column, the flip.
                              temp.squarelotron[i][j] = this.squarelotron[size - i - 1][j];
                          }
                          else{
                            //Innermost ring, so populate with the same numbers as original.
                              temp.squarelotron[i][j] = this.squarelotron[i][j];
                          }
                      }
                  }
                  return temp;  //Return the temp, which is the new flipped matrix.
              }
          
              /*This method performs the Main Diagonal Flip of the
              squarelotron. The original squarelotron should not be
              modified (we will check for this).*/
              public Squarelotron mainDiagonalFlip(int ring) {                           
                /*Create a new temporary Squarelotron of the same 
                 * dimensions to populate with the diagonally flipped matrix.*/
                Squarelotron temp = new Squarelotron(this.size);
                  //Loop through the matrix.
                for (int i = 0; i < size; i++){     //Start at the index 0 rows.
                      for (int j = 0; j < size; j++){   //Start at the index 0 columns.
                        /*The OR conditional determines if the row/column address is in the
                         * outer rings. If the address is of the innermost ring the 
                         * conditions are not met, and it defers to the else statement.*/
                          if(i == ring - 1 || i == size - ring || j == ring - 1 || j == size - ring){
                            /*Populate the temp array with the inverse address, the flip.
                             * This means, for example, that the original arr[0][3] will be
                             * the temp arr[3][0]. This is done by temp[i][j] being populated
                             * with original[j][i].*/
                              temp.squarelotron[i][j] = this.squarelotron[j][i];
                          }
                          else{
                            //Innermost ring, so populate with the same numbers as original.
                              temp.squarelotron[i][j] = this.squarelotron[i][j];
                          }
                      }
                  }
                  return temp;  //Return the temp, which is the new diagonally flipped matrix.
              }
              
              /*The argument numberOfTurns indicates the number of times the entire squarelotron 
               * should be rotated 90° clockwise. Any integer, including zero and negative 
               * integers, is allowable as the argument. A value of -1 indicates a 90° counterclockwise 
               * rotation. This method modifies the internal representation of the squarelotron; it 
               * does not create a new squarelotron.*/
              public void rotateRight(int numberOfTurns) {
                /*If the numberOfTurns is negative then make it a positive int with modulo 4 that 
                 * will yield the positive inverse int to reflect correct number of turns in
                 * the right (clockwise) direction.*/
                if(numberOfTurns < 0) {
                  numberOfTurns = (numberOfTurns % 4);
                }
                //Loop through the numberOfTurns with each loop moving the array address one turn.
                  for (int n = 0; n < numberOfTurns; n++) {
                    //Create a new temp instance with each turn to be copied.
                      Squarelotron temp = new Squarelotron(size);
                      //Loop through the rows.
                      for (int i = 0; i < size; i++) {
                        //Loop through the columns.
                          for (int j = 0; j < size; j++) {
                                //This will iterate through the ith row and copy it to the jth column. 
                                  temp.squarelotron[j][size - 1 - i] = this.squarelotron[i][j];
                          }
                      }
                      this.squarelotron = Arrays.copyOf(temp.squarelotron, temp.size);
                  }
              }
}
