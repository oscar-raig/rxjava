package org.raig;

import rx.Observable;
import rx.functions.Func1;

// Transformation
public class Exemple7 {

  public static void run() {

    Observable.just("Hello, world! -Dan")
      .subscribe(s -> System.out.println(s));

    Observable.just("Hello, world!")
      .subscribe(s -> System.out.println(s + " -Dan"));


    // Func1 <String,String> means input String Output String
    Observable.just("Hello, world!")
      .map(new Func1<String, String>() {
        @Override
        public String call(String s) {
          return s + " -Dan";
        }
      })
      .subscribe(s -> System.out.println(s));

    Observable.just("Hello, world!")
      .map(s -> s + " -Dan")
      .subscribe(s -> System.out.println(s));

  }
}
