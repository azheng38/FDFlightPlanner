
public interface FlightPathInterface
{
    // public FlightPath(int cost, CityInterface startCity, CityInterface destinationCity);
  
    public CityNodeInterface getStartCity(); // predecessor
    
    public CityNodeInterface getDestinationCity(); // successor
    
    public int getCost(); // path weight
}

