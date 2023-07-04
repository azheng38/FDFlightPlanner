import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * This is the Flight Planner's frontend class. This contains the UI.
 */
public class FlightPlannerFrontendFD implements FlightPlannerFrontendInterface
{
  private Scanner userInput; // scanner to read the user's input
  private FlightPlannerBackendInterface backend;
  private String input;
  
  /**
   * this is the constructor that sets the scanner and backend objects
   * 
   * @param scanner - the scanner for the user input
   * @param backend - the FlightPlannerBackend object
   */
  public FlightPlannerFrontendFD(Scanner scanner, FlightPlannerBackendInterface backend)
  {
    userInput = scanner;
    this.backend = backend;
    input = "";
  }
  
  /**
   * This method runs the loop that prompts the user to enter a command. This method also takes what
   * the user enters and outputs the corresponding response to it.
   */
  @Override
  public void runCommandLoop() 
  {
    System.out.println("~~~Flight Planner~~~");
    
    // Q is quit command
    while (!input.equals("Q")) 
    {
      mainMenu();
      if (input.equals("F")) // loads a file
      {
        try 
        {
          System.out.println("Which file do you want to load?");
          String file = userInput.nextLine();
          
          loadFile(file);
        } 
        catch (IOException e) 
        {
          System.out.println("File not found");
          input = "error";
        }
      }
      else if (input.equals("e")) // cheapest path cost from place to place
      {
        String start = "";
        String end = "";
        
        System.out.println("Starting city: ");
        start = userInput.nextLine();
        
        System.out.println("Ending city: ");
        end = userInput.nextLine();
        
        System.out.println(getCheapestPathCost(start, end));
      }
      else if (input.equals("c")) // shortest path cost from place to place
      {
        String start = "";
        String end = "";
        
        System.out.println("Starting city: ");
        start = userInput.nextLine();
        
        System.out.println("Ending city: ");
        end = userInput.nextLine();
        
        System.out.println(getShortestPathCost(start, end));
      }
      else if (input.equals("C")) // cheapest flight path from place to place
      {
        String start = "";
        String end = "";
        
        System.out.println("Starting city: ");
        start = userInput.nextLine();
        
        System.out.println("Ending city: ");
        end = userInput.nextLine();
        
        System.out.println(getCheapestPath(start, end));
      }
      else if (input.equals("S")) // shortest flight path from place to place
      {
        String start = "";
        String end = "";
        
        System.out.println("Starting city: ");
        start = userInput.nextLine();
        
        System.out.println("Ending city: ");
        end = userInput.nextLine();
        
        System.out.println(getShortestPath(start, end));
      }
      else if (input.equals("R")) // remove flight path
      {
        String start = "";
        String end = "";
        
        System.out.println("Starting city: ");
        start = userInput.nextLine();
        
        System.out.println("Ending city: ");
        end = userInput.nextLine();
        
        removeFlightPath(start, end);
      }
      else if (input.equals("A")) // add flight path
      {
        String start = "";
        String end = "";
        double cost = 0;
        
        System.out.println("Starting city: ");
        start = userInput.nextLine();
        
        System.out.println("Ending city: ");
        end = userInput.nextLine();
        
        System.out.println("Cost (input a number): " );
        cost = userInput.nextDouble();
        
        addFlightPath(start, end, cost);
      }
      else
      {
        if (!input.equals("Q")) // quit
          System.out.println("Invalid command, input one of the options above");
      }
    }

    // message when the user quits the program
    System.out.println("Have a nice day!");
    
    userInput.close(); // closes scanner since user has quit program
  }

  /**
   * this is the prompt that asks the user what command they would like to enter
   */
  @Override
  public String mainMenu() 
  {
    System.out.println("Choose a command:");
    System.out.println("Load [F]ile");
    System.out.println("Cheap[e]st path cost from place to place");
    System.out.println("Shortest path [c]ost from place to place");
    System.out.println("[C]heapest path from place to palce");
    System.out.println("[S]hortest path from place to place");
    System.out.println("[R]emove flight path");
    System.out.println("[A]dd flight path");
    System.out.println("[Q]uit");

    // asks user to input command
    System.out.print("Choose command: ");
    
    // trim away any leading or trailing whitespace from user's input
    input = userInput.nextLine();
    
    if (input.length() == 0) // if user's choice is blank, return invalid string
        return "-";
    
    return input;
  }
  
  /**
   * This method runs FlightPlannerBackend's load file method and informs the user if the file was 
   * successfully loaded or not
   * 
   * @param file - the file name
   * @throws IOException when the file is not found
   */
  @Override
  public void loadFile(String file) throws IOException
  {
    try 
    {
      backend.loadFile(file);
      
      System.out.println("Successfully loaded");
    } 
    catch (IOException e) 
    {
      throw new IOException();
    }
  }

  /**
   * This method runs the backend's getLowestCost method and formats it for the user
   * 
   * @param start - the starting city name
   * @param end - the destination city name
   */
  @Override
  public String getCheapestPathCost(String start, String end) 
  {
    double result = backend.getLowestCost(start, end);

    return "Cost of cheapest path from " + start + " to " + end + ": " + result;
  }

  /**
   * This method runs the backend's getShortestCost method and formats it for the user
   * 
   * @param start - the starting city name
   * @param end - the destination city name
   */
  @Override
  public String getShortestPathCost(String start, String end) 
  {
    double result = backend.getShortestCost(start, end);

    return "Cost of shortest path from " + start + " to " + end + ": " + result;
  }

  /**
   * This method runs the backend's getLowestCostPath method and formats it for the user
   * 
   * @param start - the starting city name
   * @param end - the destination city name
   */
  @Override
  public String getCheapestPath(String start, String end) 
  {
    List<String> path = backend.getLowestCostPath(start, end);
    
    String result = "Cheapest path from " + start + " to " + end + ": ";
    
    for (int i = 0; i < path.size() - 1; i++)
    {
      result += path.get(i) + ", ";
    }
    
    // add last city without the comma
    if (path.size() != 0)
      result += path.get(path.size() - 1);
    
    return result;
  }

  /**
   * This method runs the backend's getShortestPath method and formats it for the user
   * 
   * @param start - the starting city name
   * @param end - the destination city name
   */
  @Override
  public String getShortestPath(String start, String end) 
  {
    List<String> path = backend.getShortestPath(start, end);
    
    String result = "Shortest path from " + start + " to " + end + ": ";
    
    for (int i = 0; i < path.size() - 1; i++)
    {
      result += path.get(i) + ", ";
    }
    
    // add last city without the comma
    if (path.size() != 0)
      result += path.get(path.size() - 1);
    
    return result;
  }

  /**
   * This method runs the backend's removeFlightPath method and verifies the path removed
   * 
   * @param start - the starting city name
   * @param end - the destination city name
   */
  @Override
  public void removeFlightPath(String start, String end) 
  {
    backend.removeFlightPath(start, end);
    
    // BD needs to add to remove method to check if the remove was not valid and completed
    System.out.println("Removed " + start + " -> " + end);
  }

  /**
   * This method runs the backend's addFlightPath method and verifies the path added
   * 
   * @param start - the starting city name
   * @param end - the destination city name
   */
  @Override
  public void addFlightPath(String start, String end, double cost) 
  {
    backend.addFlightPath(start, end, cost);
    
    // BD needs to add to remove method to check if the remove was not valid and completed
    System.out.println("Added " + start + " -> " + end + " with a cost of " + cost);
    
  }
  
  /**
   * Main method runs the command loop
   */
  public static void main(String[] args)
  {
    Scanner s = new Scanner(System.in);
    FlightPlannerBackendInterface backend = new FlightPlannerBackendFD();
    
    FlightPlannerFrontendInterface test = new FlightPlannerFrontendFD(s, backend);
    test.runCommandLoop();
  }
}
