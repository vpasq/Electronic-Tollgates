package electronictollcollection.etcsystem;

import java.util.Random;

public class Transponder {

  private String transponderId;

  /**
   * Construct a transponder.
   *
   * @postcondition a new transponder has been constructed with a unique ID
   */
  public Transponder() {
    generateId();
  }

  /**
   * Helper method to generate a unique ID.
   *
   * @postcondition a unique ID has been created for this transponder
   */
  private void generateId() {
    int random = 100 + new Random().nextInt(1000);
    transponderId = "id" + random;
  }

  /**
   * Accessor method for the unique ID for this transponder.
   */
  public String getUniqueId() {
    return transponderId;
  }
}
