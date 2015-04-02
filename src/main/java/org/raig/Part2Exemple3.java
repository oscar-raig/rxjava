package org.raig;

import rx.Observable;
import rx.functions.Func1;

import java.util.Arrays;
import java.util.List;

public class Part2Exemple3 {

  static Observable <List<String>> query( String textValue ) {

    String a[] = new String[]{"url1", "url2", "url3"};
    List<String> listUrl   = Arrays.asList(a);
    return Observable.from(listUrl).toList();

  }

  static Observable<String> getTitle(String URL) {

    String[] list = {"item1","item2"};

    return Observable.from(list);

  }

  public static void run() {

    System.out.println("Begin Exemple 3");

    System.out.println("Step 1");

    query("Hello World").subscribe( url -> System.out.println( url ));

    System.out.println("Step 2");

    query("Hello World").flatMap( url ->
      Observable.from(url))
      .subscribe(url -> System.out.println(url));

    System.out.println("Step 3");

    query("Hello, world!")
      .flatMap(urls -> Observable.from(urls))
      .flatMap(new Func1<String, Observable<String>>() {
        @Override
        public Observable<String> call(String url) {
          System.out.println(url);
          return getTitle(url);
        }
      })
      .subscribe(title -> {
          System.out.println("Begin title " + title);
          System.out.println(title);
          System.out.println("End title " + title);
          }
        );

    query("Hello, world!")
      .flatMap(urls -> Observable.from(urls))
      .flatMap(url -> getTitle(url))
      .subscribe(title -> System.out.println(title));

  }
}
