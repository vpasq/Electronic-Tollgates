package electronictollcollection.customers;

import electronictollcollection.etcsystem.EtcSystem;

public interface Visitor {

  /**
   * Visitor method to calculate toll costs.
   *
   * @param etc the object to visit.
   * @postcondition toll costs were calculated.
   */
  void visit(EtcSystem etc);
}
