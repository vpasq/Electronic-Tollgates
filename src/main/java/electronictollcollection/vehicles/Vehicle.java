package electronictollcollection.vehicles;

import electronictollcollection.customers.VehicleOwner;
import electronictollcollection.etcsystem.Transponder;

public abstract class Vehicle {

  enum Weight { STANDARD, DYNAMIC }

  private static final double BASE_PRICE = 2.00;
  private double tollPrice;
  private String type;
  private String model;
  private String year;
  private Weight weight;
  private Transponder transponder;
  private VehicleOwner vehicleOwner;

  /**
   * Initialize the base fields for this vehicle.
   *
   * @param type the type of this vehicle
   * @param year the year of manufacture of this vehicle
   * @param weight the weight of this vehicle
   * @param tollPrice the price for the toll for this vehicle
   */
  public Vehicle(String type, String model, String year, Weight weight, double tollPrice) {
    this.type = type;
    this.model = model;
    this.year = year;
    this.weight = weight;
    this.tollPrice = tollPrice;
  }

  /**
   * Accessor method for the basePrice toll for this vehicle.
   *
   * @return the base price for the toll for this vehicle
   */
  public static double getBasePrice() {
    return BASE_PRICE;
  }

  /**
   * Accessor method for the type of this vehicle.
   *
   * @return the type of this vehicle
   */
  public String getType() {
    return type;
  }

  /**
   * Accessor method for the year of manufacture for this vehicle.
   *
   * @return the year of manufacture for this vehicle
   */
  public String getYear() {
    return year;
  }

  /**
   * Accessor method for the transponder assigned to this vehicle.
   *
   * @return the transponder assigned to this vehicle
   */
  public Transponder getTransponder() {
    return transponder;
  }

  /**
   * Modifier method to set a transponder to this vehicle.
   *
   * @param transponder the transponder to set to this vehicle
   */
  public void mountTransponder(Transponder transponder) {
    this.transponder = transponder;
  }

  /**
   * Modifier method to assign an owner to this vehicle.
   *
   * @param vehicleOwner the owner to assign to this vehicle
   */
  public void assignOwner(VehicleOwner vehicleOwner) {
    this.vehicleOwner = vehicleOwner;
  }

  /**
   * Accessor method for this vehicle's owner.
   *
   * @return this vehicle's owner
   */
  public VehicleOwner getVehicleOwner() {
    return vehicleOwner;
  }

  /**
   * Accessor method for the weight of this vehicle.
   *
   * @return the weight of this vehicle
   */
  public Weight getWeight() {
    return weight;
  }


  /**
   * Accessor method for this vehicle's tollprice.
   *
   * @return this vehicle's tollprice
   */
  public double getTollPrice() {
    return tollPrice;
  }

  /**
   * Accessor method for this vehicle's model.
   *
   * @return this vehicle's model
   */
  public String getModel() {
    return model;
  }

  /**
   * Format this object's state for display.
   *
   * @return a formatted string for this objects state
   */
  @Override
  public String toString() {
    return String.format("%-17s %s%n%-17s %s%n%-17s %s%n%-17s %s%n%-17s "
            +  "%s%n%-17s $%.2f%n%-17s %s",
        "Owner:", getVehicleOwner().getName(),
        "Type:", getType(),
        "Year:", getYear(),
        "Model;", getModel(),
        "Weight:", getWeight(),
        "Toll Base Price:", getTollPrice(),
        "Transponder  ID:", getTransponder().getUniqueId());
  }

}
