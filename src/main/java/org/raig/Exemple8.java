package org.raig;

import rx.Observable;
import rx.functions.Func1;

public class Exemple8 {

  // Functions
  // Observable.just
  // Observable.map
  // Observable.subscribe
  // Comments:
  // Func1<String, Integer> means: input String, Output Integer
  public static void run() {

    System.out.println("Begin Exemple 8");

    Observable.just("Hello, world!")
      .map(new Func1<String, Integer>() {
        @Override
        public Integer call(String s) {
          return s.hashCode();
        }
      })
      .subscribe(i -> System.out.println(Integer.toString(i)));

    System.out.println("Same with lambdas");

    Observable.just("Hello, world!").map(s -> s.hashCode()).
      subscribe(i->System.out.println(Integer.toString(i)));

    System.out.println("Same with another map");

    Observable.just("Hello, world!")
      .map(s -> s.hashCode())
      .map(i -> Integer.toString(i))
      .subscribe(s -> System.out.println(s));

    System.out.println("Same with modifying the original String");

    Observable.just("Hello, world!")
      .map( s -> s + " - Oscar")
      .map( s -> s.hashCode())
      .map( i -> i.hashCode())
      .subscribe( s -> System.out.println(s));

    System.out.println("End Exemple 8");

  }
}
