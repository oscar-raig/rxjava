package org.raig;

import rx.Observable;

public class Exemple6 {
  public static void run() {

    System.out.println("---Begin 6");

    Observable.just("Hello, world! Exemple 6")
      .subscribe(s -> System.out.println(s));

    System.out.println("---End 6");

  }
}
