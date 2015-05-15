/**
 * Created by dennish on 15/05/15.
 */
public class Wallet {

  private int euro;
  private int cent;

  public Wallet() {
    this.euro = 0;
    this.cent = 0;
  }

  public Wallet(int euro, int cent) {
    addMoney(euro, cent);
  }

  public int getEuro() {
    return euro;
  }

  public int getCent() {
    return cent;
  }

  public void addEuro(int euro) {
    this.euro += euro;
  }

  public void addCent(int cent) {
    int totalCent = this.cent + cent;
    this.euro += totalCent / 100;
    this.cent = totalCent % 100;
  }

  public void addMoney(int euro, int cent) {
    addEuro(euro);
    addCent(cent);
  }

  public void removeCent(int cents) throws Exception {
    int totalMoneyInCent = euro * 100 + cent;
    if (totalMoneyInCent < cents) {
      throw new Exception();
    }
    euro = 0;
    cent = 0;
    addCent(totalMoneyInCent - cents);
  }

  public void removeEuro(int euros) throws Exception {
    if (euro < euros) {
      throw new Exception();
    }
    euro -= euros;
  }

  public void removeMoney(int euros, int cents) throws Exception {
    removeEuro(euros);
    removeCent(cents);
  }
}
