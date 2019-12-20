package electronictollcollection.etcsystem;

import electronictollcollection.customers.TravelRecord;
import electronictollcollection.customers.VehicleOwner;
import electronictollcollection.customers.Visitor;
import electronictollcollection.highways.Highway;
import electronictollcollection.highways.Location;
import electronictollcollection.highways.Tollgate;
import electronictollcollection.vehicles.Vehicle;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class EtcSystem {

  // Singleton
  private static EtcSystem uniqueInstance;

  private Map<VehicleOwner, Transponder> transponderMap;
  private Map<Vehicle, TravelRecord> travelRecordMap;
  private List<Highway> highways;
  private TravelRecord travelRecord;
  private Random random;
  private int numCustomers;
  private int numMonths;
  private int  totalTollsTraveled;



  /**
   * Construct an ETCSystem.
   */
  private EtcSystem() {
    transponderMap = new HashMap<>();
    highways = new ArrayList<>();
    travelRecordMap = new HashMap<>();
    random = new Random();
  }

  /**
   * Get a Singleton of EtcSystem.
   *
   * @return a single unique instance of EtcSystem
   */
  public static synchronized EtcSystem getInstance() {
    if (uniqueInstance == null) {
      uniqueInstance = new EtcSystem();
    }
    return uniqueInstance;
  }

  /**
   * Register a vehicle with the Electronic Toll Collection System.
   *
   * @param vehicle the vehicle to register
   * @return a transponder assigned to the given vehicle
   */
  public Transponder registerVehicle(Vehicle vehicle) {
    Transponder transponder = new Transponder();

    while (checkDuplicateIds(transponder)) {
      transponder = new Transponder();
    }

    transponderMap.put(vehicle.getVehicleOwner(), transponder);
    return transponderMap.get(vehicle.getVehicleOwner());
  }

  /**
   * Check if there is a duplicate with any current transponder id.
   *
   * @param transponder the newly generated transponder
   * @return true if there is a duplicate id, false otherwise
   */
  private boolean checkDuplicateIds(Transponder transponder) {
    for (Map.Entry<VehicleOwner, Transponder> entry : transponderMap.entrySet()) {
      if (transponder.getUniqueId().equals(entry.getValue().getUniqueId())) {
        return true;
      }
    }
    return false;
  }

  /**
   * Accessor method for the current transponders.
   *
   * @return the current transponders
   */
  public Map<VehicleOwner, Transponder> getTransponderMap() {
    return transponderMap;
  }

  /**
   * Accessor method for the transponder assigned to the given vehicle.
   *
   * @param vehicle the given vehicle
   * @return the transponder assigned to the given vehicle
   */
  public Transponder getVehicleTransponder(Vehicle vehicle) {
    return transponderMap.get(vehicle.getVehicleOwner());
  }


  /**
   * Accessor method for the current highways.
   *
   * @return the current highways
   */
  public List<Highway> getHighways() {
    return highways;
  }

  /**
   * Accessor method for the travelRecordMap.
   *
   * @return the current the travelRecordMap
   */
  public Map<Vehicle, TravelRecord> getTravelRecordMap() {
    return travelRecordMap;
  }

  /**
   * Simulate customers for a simulation.
   *
   * @param numCustomers the number of customers to simulate
   * @postcondition Customers have been generated and assigned to random vehicles, and
   *                corresponding transponders have been mounted. Also, the customer's
   *                VehicleTravelRecord object has been created
   */
  public void simulateCustomers(int numCustomers) {
    this.numCustomers = numCustomers;
    for (int i = 0; i < numCustomers; i++) {
      String name = "VehicleOwner" + (i + 1);
      VehicleOwner vehicleOwner = new VehicleOwner();
      vehicleOwner.setName(name);
      int numVehicles = 1 + new Random().nextInt(2);
      while (numVehicles > 0) {
        Vehicle vehicle = vehicleOwner.getRandomVehicle();
        vehicle.assignOwner(vehicleOwner);
        Transponder transponder = registerVehicle(vehicle);
        vehicle.mountTransponder(transponder);
        createTravelRecord(vehicle);
        numVehicles--;
      }
    }
  }

  /**
   * Create travel record for given vehicle.
   *
   * @param vehicle the given vehicle
   * @postcondition travel record history obkect has been created for the given vehicle
   */
  private void createTravelRecord(Vehicle vehicle) {
    travelRecord = new TravelRecord();
    travelRecordMap.put(vehicle, travelRecord);
  }

  /**
   * Simulate a highway network.
   *
   * @param numHighways the number of highways to simulate
   * @postcondition a highway network has been created
   */
  public void simulateHighwayNetwork(int numHighways) {
    for (int i = 0; i < numHighways; i++) {
      String name = "hw" + (i + 1);
      int distance = 100 + random.nextInt(numHighways);
      Location location = new Location(i + 1, i + 2);
      Highway highway = new Highway(name, distance, location, false);
      highway.setTollgates();
      highways.add(highway);
    }
  }

  /**
   * Simulate vehicles traveling through electronic toll collections.
   *
   * @postcondition A simulation fo an electronic toll collection was completed
   */
  public void simulateVehicleTravel(int months) {
    Highway highway;
    int randomHighway;
    int speed = 60;
    int tollsTraveled = 0;
    numMonths = months;

    for (int month = 0; month < numMonths; month++) {
      for (int i = 0; i < 3; i++) {
        randomHighway = random.nextInt(highways.size() - 1);
        highway = highways.get(randomHighway);
        for (VehicleOwner vehicleOwner : transponderMap.keySet()) {
          for (Vehicle vehicle : vehicleOwner.getCustomerVehicles()) {
            totalTollsTraveled += enterHighway(vehicle, highway, speed);
          }
        }
      }
    }
  }

  /**
   * Helper method for simulation an electronic toll collection.
   *
   * @param vehicle the current vehicle entering a random highway
   * @param highway the random highway
   * @param speed the speed of the current vehicle
   * @return number of tolls traveled by given vehicle
   */
  private int enterHighway(Vehicle vehicle, Highway highway, int speed) {

    List<Tollgate> tollGates = highway.getTollgates();

    for (int i = 0; i < tollGates.size(); i++) {
      int markerLocation = tollGates.get(i).getMarker();
      int hh = markerLocation / speed;
      int mm = markerLocation % speed;

      Calendar calendar = Calendar.getInstance();
      int year = calendar.get(Calendar.YEAR);
      int month = calendar.get(Calendar.MONTH);
      int day = calendar.get(Calendar.DAY_OF_MONTH);

      SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm");
      try {
        Date date = format.parse(year + "/" + month + "/" + day + " " + hh + ":" + mm);
        if (travelRecordMap.get(vehicle) != null) {
          travelRecord = travelRecordMap.get(vehicle);
          travelRecord.setTimestamp(date);
        }
      } catch (Exception e) {
        System.out.println(e.getMessage());
      }
    }
    return tollGates.size();
  }

  /**
   * Accessor method for number of customers.
   *
   * @return number of customers
   */
  public int getNumCustomers() {
    return numCustomers;
  }

  /**
   * Accessor method for number of months of highway travel.
   *
   * @return number of customers
   */
  public int getNumMonths() {
    return numMonths;
  }

  /**
   * Accessor method for total tolls traveled.
   *
   * @return the number of total tolls traveled
   */
  public int getTotalTollsTraveled() {
    return totalTollsTraveled;
  }

  /**
   * Method to accept visitor.
   *
   * @param visitor the object that will visit this object
   * @postcondition visitor has visited... Perform your Magic!
   */
  public void accept(Visitor visitor) {
    visitor.visit(this);
  }
}
