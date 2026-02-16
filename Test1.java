import java.util.Scanner;

/** 
 *
 * @author bolasika (adapted from dcsaysp)
 */
public class Test1 {
  /**
   * Main method for Test1.
   *
   * @param args Ignored and unused command line arguments.
   */
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();
    
    PiZ piz = new PiZ(3);

    we.expectReturn("Adding BeefPizza 0...",
        () -> piz.addBeefPizza(), "0: BeefPizza added");
    we.expectReturn("Adding BeefPizza 1...",
        () -> piz.addBeefPizza(), "1: BeefPizza added");
    we.expectReturn("2 eaters for BeefPizza 1, 5000 / 2 ==> 2500g sugar intake...",
        () -> piz.eat(1,2), "1: BeefPizza for 2 eater(s) with 2500g sugar intake each");
    we.expectReturn("6 eaters for BeefPizza 0, 5000 / 6 ==> 833.3333g sugar intake each...",
        () -> piz.eat(0,6), "0: BeefPizza for 6 eater(s) with 833g sugar intake each");
    we.expectReturn("Adding BeefPizza 2...",
        () -> piz.addBeefPizza(), "2: BeefPizza added");
    we.expectReturn("1 pax for BeefPizza 2, 5000 / 1 ==> 5000g sugar intake...",
        () -> piz.eat(2,1), "2: BeefPizza for 1 eater(s) with 5000g sugar intake each");

    if (we.pass()) {      
      System.out.println("\n====\n YAY Part 1 secured, attempt part 2!\n====");
    }
  }
}