package events;

/**
 * Created by dennish on 15/05/15.
 */
public class AddEuroEvent extends MoneyEvent {

  public AddEuroEvent(int euro) {
    super(euro, 0);
  }
}
