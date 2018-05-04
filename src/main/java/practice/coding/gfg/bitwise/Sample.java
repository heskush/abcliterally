package practice.coding.gfg.bitwise;

import java.util.BitSet;

// author -- hemantkumar
public class Sample {
    public static void main(String[] args) {
//        System.out.println(Integer.SIZE);
        BitSet bitSet = new BitSet(10);
        bitSet.set(1, 3, true);
        System.out.println(bitSet.nextSetBit(4));
        bitSet.set(1, 3, false);
        System.out.println(bitSet.toString());

    }
}
