/** 
 *
 * @author bolasika (adapted from dcsaysp)
 */
public class Test2 {
  /**
   * Main method for Test2.
   *
   * @param args Ignored and unused command line arguments.
   */
  public static void main(String[] args) {
    CS2030STest we = new CS2030STest();

    PiZ piz = new PiZ(3);

    we.expectReturn("Adding BeefPizza 0...",
        () -> piz.addBeefPizza(), "0: BeefPizza added");
    we.expectReturn("Adding PersonalFries 1...",
        () -> piz.addPersonalFries(), "1: PersonalFries added");
    we.expectReturn("3 eaters for BeefPizza 0, 5000 / 3 ==> 1666.66666g sugar intake...",
        () -> piz.eat(0, 3), "0: BeefPizza (3 eater(s)) with 1666g sugar intake each");
    we.expectReturn("1 eater for PersonalFries 1, 250g sugar intake",
        () -> piz.eat(1,1), "1: PersonalFries with 250g sugar intake each");
    we.expectReturn("Adding PersonalFries 2...",
        () -> piz.addPersonalFries(), "2: PersonalFries added");
    we.expectException("4 pax for PersonalFries",
        () -> piz.eat(2, 4), "PersonalException", "PERSONAL FOOD! Not for 4");
  }
}