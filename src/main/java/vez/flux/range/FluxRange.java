package vez.flux.range;

import reactor.core.publisher.Flux;

public class FluxRange {

  public static void main(String[] args) throws InterruptedException {
    // метод Range позволяет сгенерировать поток целых чисел, где
    // 2010 – начальное значение, а 9 – число элементов в последовательности.
    Flux<Integer> stream4 = Flux.range(2010, 9);
    stream4.subscribe(System.out::println);
    Thread.sleep(500);
  }
}
