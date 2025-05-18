/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start=1;
        int end=n;
        while(start<=end){
            int mid=start+(end-start)/2;    //Find middle value
            int num=guess(mid);                //Checks if my guessed integer was correct in each loop passes.
            if(num==0)                          //if 0 was returned in num then I got it, just return it.
            return mid;
            else if(num==-1)                    //if -1 was returned means I guessed larger number, I need to go lower, so I decreased my end value.
            end=mid-1;
            else                                //if +1 was returned means I guessed less value, I need to go higher so I updated start value.
            start=mid+1;
        }
        return -1;      //My program will never reach here until the number was outside the range of 1 to n, correct guess will be returned in the loop itself.
    }
}   //Upvote if you got it.