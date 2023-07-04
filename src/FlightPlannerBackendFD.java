import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FlightPlannerBackendFD implements FlightPlannerBackendInterface
{
  
  
  public FlightPlannerBackendFD()
  {
    
  }
  
  // hard code to ensure that parameters are right and this method is run properly
  @Override
  public List<String> getLowestCostPath(String start, String end) 
  {
    List<String> testParam = new ArrayList<String>();
    
    testParam.add(start);
    testParam.add(end);
    
    return testParam;
  }

  //hard code to ensure that parameters are right and this method is run properly
  @Override
  public List<String> getShortestPath(String start, String end) 
  {
    List<String> testParam = new ArrayList<String>();
    
    testParam.add(start);
    testParam.add(end);
    
    return testParam;
  }

  //ensures that this method is run when it should be w/ correct parameters
  @Override
  public void removeFlightPath(String start, String end) 
  {
    
    System.out.println(start + end);
  }

  //ensures that this method is run when it should be w/ correct parameters
  @Override
  public void addFlightPath(String start, String end, double cost) 
  {
    System.out.println(start + end + cost);
  }

  @Override
  public void loadFile(String filename) throws IOException
  {
    if (!filename.equals("valid"))
      throw new IOException();
    
  }

  // hardcodes to ensure that this method is run
  @Override
  public double getLowestCost(String start, String end) {

    return 2;
  }

  // hardcodes to ensure that this method is run
  @Override
  public double getShortestCost(String start, String end) {

    return 10;
  }

}
