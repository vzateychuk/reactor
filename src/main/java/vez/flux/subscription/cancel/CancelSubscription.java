package vez.flux.subscription.cancel;

import reactor.core.publisher.Flux;

public class CancelSubscription {

  /**
   * Сначала с помощью оператора range генерируется 100 значений. 2. Выполняется подписка на поток,
   * так же как это делалось в предыдущем примере. 3. Однако теперь мы управляем подпиской. Сначала
   * запрашивается четыре элемента (3.1), а потом подписка сразу же отменяется (3.2), то есть другие
   * элементы вообще не должны генерироваться
   */
  public static void main(String[] args) {
    //
      Flux.range(1, 100) //(1)
              .subscribe( // (2)
                      data -> System.out.println("onNext: " + data ),
                      err -> { /* игнорируется */ },
                      () -> System.out.println("onComplete"),
                      subscription -> { // (3)
                          subscription.request(4); // (3.1)
                          subscription.cancel(); // (3.2)
                      }
              );
  }
}
