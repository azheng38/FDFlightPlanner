import java.util.List;

public interface CityNodeInterface 
{
  // public CityNode (String name);
  
  public String getCityName();

  public List<FlightPathInterface> getOutgoingFlights();

  public List<FlightPathInterface> getIncomingFlights();

}

