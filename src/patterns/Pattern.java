package patterns;

import java.util.Set;

public interface Pattern {
   boolean matches(Set<Integer> markedIndices);
}


/*
everytime a check on the bingo card happens, the index of it should be stored on an array
that array will then be used to compare to the index arrays of the pattern chosen

for example line pattern
one of the index array will be [0, 1, 2, 3, 4] which is the top row of the bingo card

it will then be compared to the index array of the bingo card that was stored
if all matched then bingo


use this index for checking of pattern match to the bingo cards
card index
0  1  2  3  4
5  6  7  8  9
10 11 12 13 14
15 16 17 18 19
20 21 22 23 24


LINEPATTERN =  0 1 2 3 4
               5 6 7 8 9
               10 11 12 13 14
               15 16 17 18 19
               20 21 22 23 24
               
               0 5 10 15 20
               1 6 11 16 21
               2 7 12 17 22
               3 8 13 18 23
               4 9 14 19 24
               
               0 6 12 18 24
               4 8 12 16 20
               
FULLCARDPATTERN = 0  1  2  3  4
                  5  6  7  8  9
                  10 11 12 13 14
                  15 16 17 18 19
                  20 21 22 23 24
                  
FOURCORNERSPATTER = 0 4 20 24

RANDOMPATTERN = generate random numbers from 0 to 24 and it will be the on
                  used for checking
 */