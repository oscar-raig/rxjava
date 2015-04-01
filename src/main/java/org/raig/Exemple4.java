package org.raig;

import rx.Observable;
import rx.functions.Action1;

public class Exemple4 {

  public static void run(){


    System.out.println("---Begin 4");

    Observable<String> myObservable =
      Observable.just("Hello, world!");

    Action1<String> onNextAction = new Action1<String>() {
      @Override
      public void call(String s) {
        System.out.println(s);
      }
    };

    myObservable.subscribe(onNextAction);
    System.out.println("---End 4");
  }
}
