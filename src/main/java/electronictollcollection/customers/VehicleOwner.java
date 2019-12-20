package electronictollcollection.customers;

import electronictollcollection.vehicles.CarStyle;
import electronictollcollection.vehicles.CarWithTrailerStyle;
import electronictollcollection.vehicles.TaxiStyle;
import electronictollcollection.vehicles.TruckStyle;
import electronictollcollection.vehicles.VanStyle;
import electronictollcollection.vehicles.VehicleStore;
import electronictollcollection.vehicles.Vehicle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VehicleOwner {
  private List<Vehicle> customerVehicles;
  private String name;


  /**
   * Construct a VehicleOwner.
   */
  public VehicleOwner() {
    customerVehicles = new ArrayList<>();
  }

  /**
   * Create a random vehicle.
   *
   * @return a random vehicle
   */
  public Vehicle getRandomVehicle() {
    Vehicle vehicle;
    VehicleStore rv;
    int randomVehicle = 1 + new Random().nextInt(5);
    switch (randomVehicle) {
      case 1:
        int randomCarStyle = 1 + new Random().nextInt(5);
        rv = new CarStyle();
        vehicle = rv.orderVehicle(randomCarStyle);
        customerVehicles.add(vehicle);
        break;
      case 2:
        int randomVanStyle = 1 + new Random().nextInt(5);
        rv = new VanStyle();
        vehicle = rv.createVehicle(randomVanStyle);
        customerVehicles.add(vehicle);
        break;
      case 3:
        int randomTaxiStyle = 1 + new Random().nextInt(5);
        rv = new TaxiStyle();
        vehicle = rv.createVehicle(randomTaxiStyle);
        customerVehicles.add(vehicle);
        break;
      case 4:
        int randomCarWithTrailerStyle = 1 + new Random().nextInt(5);
        rv = new CarWithTrailerStyle();
        vehicle = rv.createVehicle(randomCarWithTrailerStyle);
        customerVehicles.add(vehicle);
        break;
      case 5:
        int randomTruckStyle = 1 + new Random().nextInt(5);
        rv = new TruckStyle();
        vehicle = rv.createVehicle(randomTruckStyle);
        customerVehicles.add(vehicle);
        break;
      default:
        throw new IllegalArgumentException("Invalid Random Value.");
    }
    return vehicle;
  }

  /**
   * Modifier method to set vehicle owner's name.
   *
   * @param name the vehicle owner's name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Accessor method for vehicle owner's name.
   *
   * @return the vehicle owner's name
   */
  public String getName() {
    return name;
  }

  /**
   * Accessor method for customerVehicles list.
   *
   * @return the current list of this owner's vehicles
   */
  public List<Vehicle> getCustomerVehicles() {
    return customerVehicles;
  }

  /**
   * Format this object's state for display.
   *
   * @return a formatted string for this objects state
   */
  @Override
  public String toString() {
    String str = String.format("%n%s %s %s %s%n%s%n",
        getName(),
        "has the following",
        getCustomerVehicles().size(),
        "vehicle(s):",
        "*********************************************");
    for (Vehicle v : customerVehicles) {
      str = str.concat(v.toString() + "\n");
    }
    return str;
  }


}
