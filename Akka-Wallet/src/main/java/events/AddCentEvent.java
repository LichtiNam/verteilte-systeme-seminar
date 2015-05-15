package events;

/**
 * Created by dennish on 15/05/15.
 */
public class AddCentEvent extends MoneyEvent {

  public AddCentEvent(int cent) {
    super(0, cent);
  }
}
