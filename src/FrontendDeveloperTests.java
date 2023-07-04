import static org.junit.jupiter.api.Assertions.*;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

/**
 * Tests the classes of the FD
 */
class FrontendDeveloperTests 
{

  /**
   * Tests if loading a non-valid file outputs the correct message
   */
  @Test
  void test1() 
  {
    TextUITester tester = new TextUITester("F\notValid\nQ\n");
    
    Scanner input = new Scanner(System.in);
    FlightPlannerBackendInterface backend = new FlightPlannerBackendFD();
    
    FlightPlannerFrontendInterface frontend = new FlightPlannerFrontendFD(input, backend);
    
    frontend.runCommandLoop();
    
    String output = tester.checkOutput();

    if(output.contains("Which file do you want to load?") && output.contains("File not found"))
        System.out.println("Test1 passed.");
    else
        fail("Non-valid file did not print out correct result");
  }
  
  /**
   * Tests if loading a valid file outputs the correct message
   */
  @Test
  void test2() 
  {
    TextUITester tester = new TextUITester("F\nvalid\nQ\n");
    
    Scanner input = new Scanner(System.in);
    FlightPlannerBackendInterface backend = new FlightPlannerBackendFD();
    
    FlightPlannerFrontendInterface frontend = new FlightPlannerFrontendFD(input, backend);
    
    frontend.runCommandLoop();
    
    String output = tester.checkOutput();

    if(output.contains("Which file do you want to load?") && output.contains("Successfully loaded"))
        System.out.println("Test2 passed.");
    else
        fail("test2");
  }
  
  /**
   * make sure getLowestPathCost outputs the correct message and runs correct method
   */
  @Test
  void test3() 
  {
    TextUITester tester = new TextUITester("e\nNew York City\nBoston\nQ\n");
    
    Scanner input = new Scanner(System.in);
    FlightPlannerBackendInterface backend = new FlightPlannerBackendFD();
    
    FlightPlannerFrontendInterface frontend = new FlightPlannerFrontendFD(input, backend);
    
    frontend.runCommandLoop();
    
    String output = tester.checkOutput();

    if(output.contains("Starting city:") && output.contains("2"))
        System.out.println("Test3 passed.");
    else
        fail("test3");
  }
  
  /**
   * make sure getShortestPathCost outputs the correct message and runs correct method
   */
  @Test
  void test4() 
  {
    TextUITester tester = new TextUITester("c\nNew York City\nBoston\nQ\n");
    
    Scanner input = new Scanner(System.in);
    FlightPlannerBackendInterface backend = new FlightPlannerBackendFD();
    
    FlightPlannerFrontendInterface frontend = new FlightPlannerFrontendFD(input, backend);
    
    frontend.runCommandLoop();
    
    String output = tester.checkOutput();

    if(output.contains("Starting city:") && output.contains("10"))
        System.out.println("Test4 passed.");
    else
        fail("test4");
  }
  
  /**
   * make sure getLowestCostPath outputs the correct message and runs correct method
   */
  @Test
  void test5() 
  {
    TextUITester tester = new TextUITester("C\nNew York City\nBoston\nQ\n");
    
    Scanner input = new Scanner(System.in);
    FlightPlannerBackendInterface backend = new FlightPlannerBackendFD();
    
    FlightPlannerFrontendInterface frontend = new FlightPlannerFrontendFD(input, backend);
    
    frontend.runCommandLoop();
    
    String output = tester.checkOutput();

    if (output.contains("Starting city:")
        && output.contains("Cheapest path from New York City to Boston: New York City, Boston"))
        System.out.println("Test5 passed.");
    else
        fail("test5");
  }
  
  /**
   * make sure getShortestPath outputs the correct message and runs correct method
   */
  @Test
  void test6() 
  {
    TextUITester tester = new TextUITester("S\nMadison\nBoston\nQ\n");
    
    Scanner input = new Scanner(System.in);
    FlightPlannerBackendInterface backend = new FlightPlannerBackendFD();
    
    FlightPlannerFrontendInterface frontend = new FlightPlannerFrontendFD(input, backend);
    
    frontend.runCommandLoop();
    
    String output = tester.checkOutput();

    if (output.contains("Starting city:")
        && output.contains("Shortest path from Madison to Boston: Madison, Boston"))
        System.out.println("Test6 passed.");
    else
        fail("test6");
  }
  
  /**
   * make sure removeFlightPath outputs the correct message and runs correct method
   */
  @Test
  void test7() 
  {
    TextUITester tester = new TextUITester("R\nMadison\nBoston\nQ\n");
    
    Scanner input = new Scanner(System.in);
    FlightPlannerBackendInterface backend = new FlightPlannerBackendFD();
    
    FlightPlannerFrontendInterface frontend = new FlightPlannerFrontendFD(input, backend);
    
    frontend.runCommandLoop();
    
    String output = tester.checkOutput();

    if (output.contains("Starting city: ") && output.contains("Ending city: ")
        && output.contains("Removed Madison -> Boston") && output.contains("MadisonBoston"))
        System.out.println("Test7 passed.");
    else
        fail("test7");
  }

  
  /**
   * make sure addFlightPath outputs the correct message and runs correct method
   */
  @Test
  void test8() 
  {
    TextUITester tester = new TextUITester("A\nMadison\nBoston\n8\nQ\n");
    
    Scanner input = new Scanner(System.in);
    FlightPlannerBackendInterface backend = new FlightPlannerBackendFD();
    
    FlightPlannerFrontendInterface frontend = new FlightPlannerFrontendFD(input, backend);
    
    frontend.runCommandLoop();
    
    String output = tester.checkOutput();

    if (output.contains("Starting city: ") && output.contains("Ending city: ")
        && output.contains("Added Madison -> Boston with a cost of 8") && output.contains("MadisonBoston8"))
        System.out.println("Test8 passed.");
    else
        fail("test8");
  }
}
