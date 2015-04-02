package org.raig;

import rx.Observable;

import java.util.List;

public class Part2Exemple4 {

  // Operators Galore
  private static Observable<List<String>> query( String queryText) {

    String[] listOfresults = {"1","2","3"};

    return Observable.from(listOfresults).toList();

  }

  private static Observable <String>  getTitle(String url) {

      return Observable.just("title " + url);
  }

  public static void run() {

    System.out.println("Begin Part2 Exemple 4");


    query("Hello, world!")
      .flatMap(urls -> Observable.from(urls))
      .flatMap(url -> getTitle(url))
      .filter(title -> title != null)
      .subscribe(title -> System.out.println(title));


    query("Exemple 4")
      .flatMap(url -> Observable.from(url))
      .flatMap(url -> getTitle(url))
      .filter(title -> title != null)
      .take(1)
      .subscribe(url -> System.out.println(url));

  }


}
