package practice.coding.interviewbit.arrays;

import java.util.ArrayList;

// author -- hemantkumar
public class AddOneToNumber {

  public ArrayList<Integer> plusOne(ArrayList<Integer> a) {

    ArrayList<Integer> sol = new ArrayList<>();
    if (a.isEmpty()) {
      return sol;
    }
    int headIndx = 0;
    int lastIndx = a.size() - 1;
    int nonZeroHead = a.get(0);
    while (nonZeroHead == 0) {
      headIndx++;
      nonZeroHead = a.get(headIndx);
    }
    if (nonZeroHead == lastIndx) {
      sol.add(1);
      return sol;
    }
    sol.ensureCapacity(lastIndx - nonZeroHead + 1);

    return sol;
  }

}
