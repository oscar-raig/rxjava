package org.raig;

import rx.Observable;

import java.util.List;

public class Part2Exemple1 {


  static Observable  <List<String>> query( String textValue ) {

      String []  listUrl = {"url1", "url2", "url3"};

      return Observable.from(listUrl).toList();

  }


  public static void run() {
    System.out.println("Begining Example 1");

    System.out.println("Step 1");

    query("Hello, world!")
      .subscribe(url -> System.out.println(url));

    System.out.println("Step 2");

    query("Hello, world!")
      .subscribe(urls -> {
        for (String url : urls) {
          System.out.println(url);
        }
      });

    System.out.println("Step 3");

    // A Glimmer of Hope
    query("Hello, world!")
      .subscribe(urls -> {
        Observable.from(urls)
          .subscribe(url -> System.out.println(url));
      });

    System.out.println("Ending Example 1");
  }
}
