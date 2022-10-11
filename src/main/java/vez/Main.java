package vez;

import reactor.core.publisher.Flux;

import java.util.List;

public class Main {

  public static void main(String[] args) {
    //
    List<Integer> list = Flux.range(1, 100).collectList().block();
    System.out.println(list);
  }
}
