package practice2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sol {

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(4);
        arr.add(2);
        arr.add(15);
        int x = goodSegment(arr, 1, 10);

    }

    public static int goodSegment(List<Integer> badNumbers, int l, int r) {
        Collections.sort(badNumbers);
        int lowerPointInRange = Collections.binarySearch(badNumbers, l);
        int higherPointInRange = Collections.binarySearch(badNumbers, r) ;

        // if the lower end of the range is exactly present in the array, then it's good , otherwise find the index
        // of the bad number just greater than the lower range.
        if (lowerPointInRange < 0 ){
            lowerPointInRange = -lowerPointInRange -1;
        }
        // if the higher end of the range is not exactly present in the array then find the index of the bad number
        // just lower than the higher end of range.
        if(higherPointInRange < 0 ) {
            higherPointInRange = -higherPointInRange  -2 ;
        }

        // if the range is outside the range of bad badNumbers
        if(lowerPointInRange == badNumbers.size() || higherPointInRange < 0){
            return 0;
        }
        int currentLeft = l;
        int currentRange;
        int currentMaxRange = Integer.MIN_VALUE;
        for(Integer integer : badNumbers.subList(lowerPointInRange, higherPointInRange+1))  {
            currentRange = (integer-1) - currentLeft  +1;
            if(currentRange > currentMaxRange){
                currentMaxRange  = currentRange;
            }
            currentLeft = integer + 1 ;
        }

        return currentMaxRange;







    }
}
