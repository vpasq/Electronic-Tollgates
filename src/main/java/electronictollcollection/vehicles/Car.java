package electronictollcollection.vehicles;

public class Car extends Vehicle {

  /**
   * Construct a car.
   *
   * @param type the type of this car
   * @param year the year of manufacture of this car
   * @param weight the weight of this car
   */
  public Car(String type, String model, String year, Weight weight) {
    super(type, model, year, weight, Vehicle.getBasePrice());
  }
}
