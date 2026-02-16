import java.net.URI;
import java.util.List;
import java.util.function.Supplier;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;

/**
 * A helper class to test CS2030S labs.
 */
class CS2030STest {

  private static final String ANSI_RESET = "\u001B[0m";
  private static final String ANSI_RED = "\033[1;31m";
  private static final String ANSI_GREEN = "\033[1;32m";

  private int fail;

  public CS2030STest() {
    this.fail = 0;
  }

  /**
   * Test if two objects are equals
   *
   * @param test A description of the test.
   * @param output The output from an expression.
   * @param expect The expected output from that expression.
   * @return this object.
   */
  public CS2030STest expect(String test, Object output, Object expect) {
    System.out.print(test);
    if ((expect == null && output == null) || output.equals(expect)) {
      System.out.println(".. " + ANSI_GREEN + "ok" + ANSI_RESET);
    } else {
      System.out.println(".. " + ANSI_RED + "failed" + ANSI_RESET);
      System.out.println("  expected: " + expect);
      System.out.println("  got this: " + output);
      this.fail++;
    }
    return this;
  }

  /**
   * Test if a given supplier produces a given object.
   *
   * @param <T> The type of object the given task will produce.
   * @param test A description of the test.
   * @param task The task to run.
   * @param expect The expected output from that expression.
   * @return this object.
   */
  public <T> CS2030STest expect(String test, Supplier<T> task, Object expect) {
    System.out.print(test);
    try {
      T output = task.get();
      if ((expect == null && output == null) || output.equals(expect)) {
        System.out.println(".. " + ANSI_GREEN + "ok" + ANSI_RESET);
      } else {
        System.out.println(".. " + ANSI_RED + "failed" + ANSI_RESET);
        System.out.println("  expected: " + expect);
        System.out.println("  got this: " + output);
        this.fail++;
      }
    } catch (Exception e) {
      System.out.println(".. " + ANSI_RED + "failed" + ANSI_RESET);
      System.out.println("  with exception: " + e.getMessage());
      e.printStackTrace();
      this.fail++;
    }
    return this;
  }

  /**
   * Test if a given producer returns a value.  Wrapper around expect(..)
   * to simplify caller.
   *
   * @param <T> The type of object the given task will produce.
   * @param test A description of the test.
   * @param task The task to run.
   * @param expect The expected output from that expression.
   * @return this object.
   */
  public <T> CS2030STest expectReturn(String test, Supplier<T> task, Object expect) {
    return this.expect(test + " returns " + expect, task, expect);
  }

  /**
   * Test if an expression throws an exception.
   *
   * @param test A description of the test.
   * @param task A lambda expression of the expression.
   * @param expectedE A exception instance of the same type as the expected one.
   * @return this object.
   */
  public CS2030STest expectException(String test, Runnable task, String expName, String expMsg) {
    System.out.print(test + " throws " + expName);
    boolean gotException = false;
    boolean gotMessage = false;
    try {
      task.run();
    } catch (Exception e) {
      if (e.getClass().getSimpleName().equals(expName)) {
        gotException = true;
        if (e.getMessage().equals(expMsg)) {
          gotMessage = true;
        }
      }
    }
    if (gotException && gotMessage) {
      System.out.println(".. " + ANSI_GREEN + "ok" + ANSI_RESET);
    } else if(!gotException && gotMessage) {
      System.out.println(".. " + ANSI_RED + "failed" + ANSI_RESET);
      System.out.println("  did not catch expected exception " + expName);
      this.fail++;
    } else if(gotException && !gotMessage) {
      System.out.println(".. " + ANSI_RED + "failed" + ANSI_RESET);
      System.out.println("  did not catch expected message " + expMsg);
      this.fail++;
    } else {
      System.out.println(".. " + ANSI_RED + "failed" + ANSI_RESET);
      System.out.println("  did not catch expected exception " + expName);
      System.out.println("  did not catch expected message " + expMsg);
    }
    return this;
  }

  /**
   * Test if an expression compiles with/without error.
   *
   * @param test A description of the test.
   * @param statement The java statement to compile
   * @param success Whether the statement is expected to compile or not 
   *     (true if yes; false otherwise)
   * @return this object.
   */
  public CS2030STest expectCompile(String test, String statement, boolean success) {
    System.out.print(test);

    class JavaSourceFromString extends SimpleJavaFileObject {
      final String code;

      JavaSourceFromString(String code) {
        super(URI.create("string:///TempClass.java"), Kind.SOURCE);
        this.code = "class TempClass {void foo(){" +  code + ";}}";
      }

      @Override
      public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return code;
      }
    }

    boolean noError = ToolProvider
        .getSystemJavaCompiler()
        //.getTask(null, null, new DiagnosticCollector<>(), null, null, 
        .getTask(null, null, null, null, null, 
            List.of(new JavaSourceFromString(statement)))
        .call();

    if (noError != success) {
      System.out.println(".. " + ANSI_RED + "failed" + ANSI_RESET);
      if (!success) {
        System.out.println("  expected compilation error but it compiles fine.");
      } else {
        System.out.println("  expected the statement to compile without errors but it does not.");
      }
      this.fail++;
    } else {
      System.out.println(".. " + ANSI_GREEN + "ok" + ANSI_RESET);
    }
    return this;
  }

  public boolean pass() {
    return this.fail == 0;
  }
}