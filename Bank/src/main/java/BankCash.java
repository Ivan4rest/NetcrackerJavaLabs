import org.apache.log4j.Logger;

public class BankCash {
    private static Logger logger = Logger.getLogger(BankCash.class);

    private int cash;

    public BankCash(int cash) {
        this.cash = cash;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void putMoney(int sum){
        if(sum >= 0){
            this.cash += sum;
            logger.info("Касса пополнена на: " + sum);
        }
    }

    public boolean withdrawMoney(int sum){
        if(this.cash >= sum){
            this.cash -= sum;
            logger.info("Из кассы взято: " + sum);
            return true;
        }
        else {
            logger.warn("В кассе недостаточно средств для сниятия: " + sum);
            return false;
        }
    }
}
