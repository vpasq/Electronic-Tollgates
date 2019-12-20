package electronictollcollection.customers;

import electronictollcollection.etcsystem.EtcSystem;
import electronictollcollection.etcsystem.Transponder;
import electronictollcollection.vehicles.Vehicle;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;

public class TollCostVisitor implements Visitor {

  /**
   * Visits EtcSystem to calculate total toll prices for all customer vehicles.
   *
   * @param etc the object that is being visited
   * @postcondition total toll prices have been calculated and displayed for all customers
   */
  public void visit(EtcSystem etc) {

    Map<VehicleOwner, Transponder> transponderMap = etc.getTransponderMap();
    Map<Vehicle, TravelRecord> travelRecordMap = etc.getTravelRecordMap();

    System.out.printf("%n%s%n%d %s %,d %s%n", "Total Tolls Traveled:", etc.getNumCustomers(),
        "vehicles =", etc.getTotalTollsTraveled(), "tolls");

    for (Map.Entry<VehicleOwner, Transponder> entry : transponderMap.entrySet()) {

      VehicleOwner vehicleOwner = entry.getKey();
      int numVehicles = vehicleOwner.getCustomerVehicles().size();

      System.out.printf("%n%s%n", "----------------------------------");
      System.out.printf("%-15s %s%n", "Customer:", vehicleOwner.getName());
      System.out.printf("%-15s %s%n", "NumVehicles:", numVehicles);
      System.out.printf("%-15s %s%n", "MonthsOfTravel:", etc.getNumMonths());

      double totalPrice = 0;
      for (Vehicle vehicle : vehicleOwner.getCustomerVehicles()) {
        double price;
        int numTimeStamps = travelRecordMap.get(vehicle).getTimestamps().size();
        price = vehicle.getTollPrice() * numTimeStamps;
        totalPrice += price;
        System.out.println();
        System.out.println(vehicle);
        System.out.println("-------");
        System.out.printf("%s $%,.2f%n", "Subtotal =", price);
        System.out.println();
      }
      System.out.printf("%-15s $%,.2f%n%n%n", "TOTAL TOLL PRICE = ", totalPrice);
    }

  }
}
