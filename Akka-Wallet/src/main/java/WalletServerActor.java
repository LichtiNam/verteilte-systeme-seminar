import akka.actor.UntypedActor;
import events.*;

/**
 * Created by dennish on 15/05/15.
 */
public class WalletServerActor extends UntypedActor {

  private Wallet wallet;

  public WalletServerActor() {
    this.wallet = new Wallet();
  }

  @Override
  public void onReceive(Object messages) {
    MoneyEvent moneyEvent = (MoneyEvent) messages;
    if (messages instanceof AddMoneyEvent) {
      messageToConsole();
      wallet.addMoney(moneyEvent.getEuro(), moneyEvent.getCent());
      messageToConsole();
    }
    if (messages instanceof RemoveMoneyEvent) {
      messageToConsole();
      try {
        wallet.removeMoney(moneyEvent.getEuro(), moneyEvent.getCent());
      } catch (NotEnoughMoneyException e) {
        getSender().tell(e.getMessage());
      }
      messageToConsole();
    }
    if (messages instanceof AddEuroEvent) {
      messageToConsole();
      wallet.addEuro(moneyEvent.getEuro());
      messageToConsole();
    }
    if (messages instanceof RemoveEuroEvent) {
      messageToConsole();
      try {
        wallet.removeEuro(moneyEvent.getEuro());
      } catch (NotEnoughMoneyException e) {
        getSender().tell(e.getMessage());
      }
      messageToConsole();
    }
    if (messages instanceof AddCentEvent) {
      messageToConsole();
      wallet.addCent(moneyEvent.getCent());
      messageToConsole();
    }
    if (messages instanceof RemoveCentEvent) {
      messageToConsole();
      try {
        wallet.removeCent(moneyEvent.getCent());
      } catch (NotEnoughMoneyException e) {
        getSender().tell(e.getMessage());
      }
      messageToConsole();
    }
  }

  private void messageToConsole() {
    System.out.printf("%s %10d,%02d Euro\n", "Money amount", wallet.getEuro(), wallet.getCent());
  }
}
