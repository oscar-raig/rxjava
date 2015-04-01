package org.raig;

import rx.Observable;
import rx.functions.Action1;

public class Exemple5 {

  public static void run() {
    System.out.println("---Begin 5");

    Observable.just("Hello, world! Exemple 5")
      .subscribe(new Action1<String>() {
        @Override
        public void call(String s) {
          System.out.println(s);
        }
      });
    System.out.println("---End 5");
  }
}

