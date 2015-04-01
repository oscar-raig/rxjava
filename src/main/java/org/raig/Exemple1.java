package org.raig;

import rx.Observable;
import rx.functions.Action1;

public class Exemple1 {
  public static void hello(String... names) {

    // 1. from method convert list of strings
    //    to a observable that emits those strings

    Observable.from(names).subscribe(new Action1<String>() {
      @Override
      public void call(String s) {
        System.out.println("Hello " + s + "!");
      }

    });
  }

  public static void run() {
    System.out.println("Begining Example 1");
    hello("Ben", "George");
    System.out.println("Ending Example 1");
  }
}
