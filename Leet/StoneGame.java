package Leet;

// https://leetcode.com/problems/stone-game/
public class StoneGame {
    public static boolean stoneGame(int[] piles) {
        int first = 0;
        int last = piles.length-1;
        int A=0,B=0;
        int turn = 1;
        while (first<=last){
            if(turn==1) {
                if (piles[first]>piles[last]) {
                    A+=piles[first];
                    first++;
                } else {
                    A+=piles[last];
                    last--;
                }
                turn=2;
            }
            else {
                if (piles[first]>piles[last]) {
                    B+=piles[first];
                    first++;
                } else {
                    B+=piles[last];
                    last--;
                }
                turn=1;
            }
        }
        return A>B;
    }
}
