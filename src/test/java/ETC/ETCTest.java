package ETC;

import electronictollcollection.customers.TollCostVisitor;
import electronictollcollection.customers.VehicleOwner;
import electronictollcollection.customers.Visitor;
import electronictollcollection.etcsystem.EtcSystem;
import electronictollcollection.etcsystem.Transponder;
import electronictollcollection.vehicles.Vehicle;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class ETCTest {
  private int numCustomers;
  private int numHighways;
  private int numMonths;

  @Before
  public void setup() {
    numCustomers = 20;
    numHighways = 100;
    numMonths = 9;
  }

  @Test
  public void testSimulation() {

    // Uses Singleton Pattern to create a single unique instance of EtcSystem.
    EtcSystem etc = EtcSystem.getInstance();

    // Uses Strategy Pattern and Factory Method to assign customers to random vehicles.
    etc.simulateCustomers(numCustomers);
    etc.simulateHighwayNetwork(numHighways);
    etc.simulateVehicleTravel(numMonths);

    // Uses Visitor Pattern to calculate toll costs.
    Visitor tollCostVisitor = new TollCostVisitor();
    etc.accept(tollCostVisitor);

    // test number of customers in HashMap data structure used to hold data.
    int expected = numCustomers;
    int actual = etc.getTransponderMap().keySet().size();

    // verify
    Assert.assertEquals(actual, expected);

    // test number of highways in ArrayList data structure used to hold data.
    expected = numHighways;
    actual = etc.getHighways().size();

    // verify
    Assert.assertEquals(actual, expected);

    // Test the total number of vehicles, which is randomly generated.
    // Customers, VehicleOwners, in the TransponderMap data structure can own more than
    // one vehicle. The number of customer vehicles in the TravelRecordMap data structure
    // should equal the total number of customer vehicles. Customers, VehicleOwners, are
    // retrieved from the TransponderMap data structure, and all their vehicles are
    // totalled, while taken into account customers with multiple vehicles. And then that
    // total is compared to the number of vehicles in the TravelRecordMap data structure.
    int numVehiclesInTransponderMap = 0;
    for (Map.Entry<VehicleOwner, Transponder> entry : etc.getTransponderMap().entrySet()) {
      VehicleOwner vehicleOwner = entry.getKey();

      // Customers can own more than one vehicle
      for (Vehicle vehicle : vehicleOwner.getCustomerVehicles()) {
        numVehiclesInTransponderMap += 1;
      }
    }

    // Number of Vehicles in TravelRecordMap data structure.
    int numVehiclesInTravelRecordMap = etc.getTravelRecordMap().keySet().size();

    // verify
    Assert.assertEquals(numVehiclesInTransponderMap, numVehiclesInTravelRecordMap);

  }





}
