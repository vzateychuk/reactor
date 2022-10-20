package vez.subscriber;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;

/**
 * Класс BaseSubscriber предлагает методы для более точного управления требованиями – request(long) и  requestUnbounded().
 * Кроме того, с классом BaseSubscriber намного проще реализовать TCK-совместимого подписчика.
 * Такой подход выглядит более предпочтительным, когда сам подписчик обладает ценными ресурсами со своим жизненным циклом.
 * Например, подписчик может включать обработчик файлов или соединение WebSocket со сторонней службой.
* */
public class MySubscriber<T> extends BaseSubscriber<T> {

    @Override
    protected void hookOnSubscribe(Subscription sub) {
        System.out.println("initial request for 1 element");
        this.request(1);
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println("onNext: " + value);
        System.out.println("request for 1 more element");
        this.request(1);
    }

  public static void main(String[] args) {
      Flux<String> stream = Flux.just("Hello", "world", "!"); // (4)
      MySubscriber<String> subscriber = new MySubscriber<>();
      stream.subscribe(subscriber);
      //
  }
}
