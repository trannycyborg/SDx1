# Squarelotron

[![edX](https://prod-edxapp.edx-cdn.org/static/edx.org/images/logo.790c9a5340cb.png)](https://courses.edx.org)

This assignment is intended to show the benefits of test driven development. The objective is to produce two pieces of code: Squarelotron.java and SquarelotronTest.java.

The primary object here are 2-dimensional arrays or matrices. 2D arrays are best visualized as a matrix.

An example of a 3 x 3 matrix below,

1 2 3

4 5 6

7 8 9

The following code is provided to help understand 2-dimensional arrays:
```sh
  int[][] myMatrix = new int[3][3]
  myMatrix[0][0] = 1;
  myMatrix[0][1] = 2;
  myMatrix[0][2] = 3;
```
//you can declare an entire row
```sh
 int[] secondRow = {4, 5, 6};
 myMatrix[1] = secondRow;
 myMatrix[2][0] = 7;
 myMatrix[2][1] = 8;
 myMatrix[2][2] = 9;
```
//if you want to print out each element on a separate line
```sh
for (int i = 0 ; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        System.out.println(myMatrix[i][j]);
    }
}
```
## Squarelotron

The main assignment deals with more array manipulations.
There are inversions and rotational operations for the 2D array, which is the object called a Squarelotron.
There is only one Squarelotron at a time to deal with, although multiple matrices or higher dimensional arrays 
would be a great challenge.

A Squarelotron consists basically of a matrix of numbers. This matrix can be decomposed as square rings which can flip independently in two different ways: Upside-Down and through the Main Diagonal.

**A**

![4x4 Grid](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/a68b6dbcd504ef69ac0e7ceab5df8f2b/asset-v1:PennX+SD1x+2T2019+type@asset+block/g1.jpg) 

**B**

![5x5 Grid](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/2ae16d277ef6d5d93b47e0c0499a52f6/asset-v1:PennX+SD1x+2T2019+type@asset+block/g2.jpg)
 
For example, consider the following Squarelotrons:

Squarelotron (a) has two rings. The outer ring contains the numbers 1, 2, 3, 4, 5, 8, 9, 12, 13, 14, 15, 16, while the inner ring contains the numbers 6, 7, 10, 11.

Squarelotron (b) has two rings and a center piece. The outer ring contains the numbers 1, 2, 3, 4, 5, 6, 10, 11, 15, 16, 21, 25, 22, 19, 24, 20, while the inner ring contains 7, 8, 9, 12, 14, 17, 18, 23. The number 13 is by itself in the center.

A Upside-Down Flip of the outer ring of Squarelotron (a) yields:

![4x4 Upside-Down Flip](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/9f534e988abd2ec95604f2c24773212a/asset-v1:PennX+SD1x+2T2019+type@asset+block/g3.jpg)

A Flip through the Main Diagonal of the outer ring of squarelotron b) yields:

![5x5 Upside-Down Flip](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/b1437754b9eb731479996fed61af333a/asset-v1:PennX+SD1x+2T2019+type@asset+block/g4.jpg)

Since the squarelotron is a physical object, it can be simply rotated. For example, if the top row of the 4x4 squarelotron contains (1, 2, 3, 4) and the squarelotron is rotated right by 90 degrees, then the rightmost column of the squarelotron will contain (1, 2, 3, 4). This is not considered a "flip."

Note that while we have only shown you 4 by 4 and 5 by 5 squarelotrons, the flip concept and rotation concept extends to any n by n squarelotron.

We will say that the maximum size of the squarelotron is 8 by 8.

We want to write a program that will help us flip and rotate squarelotrons.

We also want you to write this program in a test driven manner. For each of the methods we describe below, please begin by writing the stub of a method and then writing unit tests for it (in SquarelotronTest.java)

Make a class called Squarelotron with the following instance variables
```sh
    int[][] squarelotron.
    int size
```
## Constructors:

Squarelotron should have a constructor.

Squarelotron(int n) - It fills the 2-dimensional array with the numbers 1 to n squared, in order. It also sets the size instance variable to be n.

Note that you could do this with a switch statement for case 4,5,6,7 and 8 individually. That would not be considered wrong but you might want to pause and think about whether there is some kind of pattern that you can exploit which may be generalizable.

## Methods:

In each of the following methods, the ring should be a number and we number from the outermost ring being the number 1.

See the illustration below for clarity

![5x5 Grid](https://prod-edxapp.edx-cdn.org/assets/courseware/v1/f75e87416da8ddd6cbaea919a70dbad3/asset-v1:PennX+SD1x+2T2019+type@asset+block/g5.jpg)

## Squarelotron upsideDownFlip(int ring)

This method performs the Upside-Down Flip of the squarelotron, as described above, and returns the new squarelotron. The original squarelotron should not be modified (we will check for this).

## Squarelotron mainDiagonalFlip(int ring)

This method performs the Main Diagonal Flip of the squarelotron, as described above, and returns the new squarelotron. The original squarelotron should not be modified (we will check for this).

## void rotateRight(int numberOfTurns)

The argument numberOfTurns indicates the number of times the entire squarelotron should be rotated 90° clockwise. Any integer, including zero and negative integers, is allowable as the argument. A value of -1 indicates a 90° counterclockwise rotation. This method modifies the internal representation of the squarelotron; it does not create a new squarelotron.




