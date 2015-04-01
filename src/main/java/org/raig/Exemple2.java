package org.raig;

import rx.Observable;
import rx.functions.Action1;

public class Exemple2 {

  public static void run() {

      String myArrayOfInt[] = new String[3];
      myArrayOfInt[0] = "2";
      myArrayOfInt[1] = "3";
      myArrayOfInt[2] = "4";
      Observable.from(myArrayOfInt).subscribe(new Action1<String>() {
        @Override
        public void call(String s) {
          System.out.println("Hello " + s + "!");
        }
      });
  }
}
