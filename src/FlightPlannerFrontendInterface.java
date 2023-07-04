import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * FlightPlannerFrontendInterface
 */
public interface FlightPlannerFrontendInterface 
{
  // runs the continuous loop that prompts the user for input until the user quits
  public void runCommandLoop();
  // main menu with all the commands
  public String mainMenu();

  // loads file
  public void loadFile(String file) throws IOException;
  // cheapest path cost according to edge cost
  public String getCheapestPathCost(String start, String end);
  // shortest path cost in terms of length of node path
  public String getShortestPathCost(String start, String end);

  // cheapest path according to edge cost
  public String getCheapestPath(String start, String end);
  // shortest path in terms of length of node path
  public String getShortestPath(String start, String end);

  // calls remove method
  public void removeFlightPath(String  start, String end);
  // calls add method
  public void addFlightPath(String start, String end, double cost);
}
