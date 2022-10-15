package vez.flux.subscription.disposable;

import reactor.core.Disposable;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * Этот код выполняет следующие операции.
 * 1. Фабричный метод interval позволяет генерировать события с заданной периодичностью (в данном
 *  случае каждые 50 мс). Генерируемый им поток данных не имеет конца.
 * 2. Подписываясь на поток, мы задаем только обработчик сигналов onNext.
 * 3. Ждем некоторое время, чтобы получить несколько событий (200 : 50 = 4, то есть должно быть сгенерировано примерно
 *  четыре события).
 * 4. Вызов метода dispose, который отменяет подписку.
 */
public class SubscriptionCancelWithDisposable {

  public static void main(String[] args) throws InterruptedException {
    Disposable disposable = Flux.interval(Duration.ofMillis(50)) // (1)
            .subscribe( // (2)
                    data -> System.out.println("onNext: " + data)
            );
    Thread.sleep(200); // (3)
    disposable.dispose(); // (4)
  }
}
