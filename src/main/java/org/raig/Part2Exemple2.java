package org.raig;

import rx.Observable;
import rx.functions.Func1;

import java.util.Arrays;
import java.util.List;

public class Part2Exemple2 {

  static Observable <List <String>> query( String textValue ) {

    String a[] = new String[]{"url1", "url2", "url3"};
    List<String> listUrl   = Arrays.asList(a);
    return Observable.from(listUrl).toList();

  }


  public static void run() {

    System.out.println("Begining Part 2 Example 2");

    // A Better Way
    // Func1 gets a List<STRING> return Observable<String>
    query("Hello, world!")
      .flatMap(new Func1<List<String>, Observable<String>>() {
        @Override
        public Observable<String> call(List<String> urls) {
          return Observable.from(urls);
        }
      })
      .subscribe(url -> System.out.println(url));

    System.out.println("Step 2");

    query("Hello, world!")
      .flatMap(urls -> Observable.from(urls))
      .subscribe(url -> System.out.println(url));
  }
}
