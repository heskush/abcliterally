package practice2018.language.java.generics;

import java.util.List;

// author -- hemantkumar
public class Example1<T, U, V, S, UI> {
  T a;
  U b;
  V v;
  S s;
  UI ui;

  public Example1(T a, U b, V v) {
    this.a = a;
    this.b = b;
    this.v = v;
    this.s = s;
    this.ui = ui;
  }

  public static void print(List<? extends Number> list) {

  }

  public static <K> void m1(K x) {

  }

  public static void addNumbers(List<? super Integer> list) {
    for (int i = 1; i <= 10; i++) {
      list.add(i);
    }
  }

  public static void main(String[] args) {
    Example1<Integer, Integer, Integer, Integer, Integer> example1 = new Example1<>(1, 2, 3);

  }

}
