import java.io.IOException;
import java.util.List;

public interface FlightPlannerBackendInterface
{
  
  public void loadFile(String filename) throws IOException;
  // Load graph structure from file
  
  public void removeFlightPath(String  start, String end);
  
  public void addFlightPath(String start, String end,double cost);

  public List<String> getLowestCostPath(String start, String end);
  //It returns path with lowest cost from start and end

  public List<String> getShortestPath(String  start, String end);
  //return the flight path with the shortest number of in between destinations.

  public double getLowestCost(String start, String end); // gets cost of lowest cost path

  public double getShortestCost(String start, String end); // gets cost of shortest cost path
}

