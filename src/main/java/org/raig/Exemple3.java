package org.raig;

import rx.Observable;
import rx.Subscriber;

public class Exemple3 {

  public static void run() {

    System.out.println("---Begin 3");

    Observable<String> myObservable = Observable.create (
      new Observable.OnSubscribe<String>() {
        @Override
        public void call(Subscriber<? super String> sub) {
          sub.onNext("Hello, world!");
          sub.onCompleted();
        }
      }
    );

    Subscriber<String> mySubscriber = new Subscriber<String>() {

      @Override
      public void onNext(String s) {

        System.out.println(s);
      }

      @Override
      public void onCompleted() {

        System.out.println("onCompleted!!");

      }

      @Override
      public void onError(Throwable e) {

      }
    };

    myObservable.subscribe(mySubscriber);

    System.out.println("---End 3");
  }
}
