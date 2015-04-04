package org.raig;

import rx.Observable;
import rx.Subscriber;

public class Part3Exemple1 {

  private static String potentialException( String text ) throws Exception {
      throw new Exception("Exception thrown potencialException");
  //  return text;

  }

  private static String anotherPotentialException( String text ) {

    return text;

  }

  public static void run() {
    System.out.println("Begining Example 1");
    Observable.just("Hello, world!")
      .map(s -> {
        try {
          potentialException(s);
        } catch (Exception e) {
          //e.printStackTrace();
          System.out.println("Catched");
          throw e;
        } finally {
          return s;
        }

        })
        .map(s -> anotherPotentialException(s))
          .subscribe(new Subscriber<String>() {
            @Override
            public void onNext(String s) {
              System.out.println(s);
            }

            @Override
            public void onCompleted() {
              System.out.println("Completed!");
            }

            @Override
            public void onError(Throwable e) {
              System.out.println("Ouch!");
            }
          });
        System.out.println("Ending Example 1");
      }
  }
