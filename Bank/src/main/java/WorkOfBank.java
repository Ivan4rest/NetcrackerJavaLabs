import org.apache.log4j.Logger;

public class WorkOfBank {
    private static Logger logger = Logger.getLogger(WorkOfBank.class);
    private static final int N = 4;

    public static void main(String[] args){
        logger.info("Банк открылся");

        int min;

        Teller[] tellers = new Teller[N];

        BankCash bankCash = new BankCash(500000);

        ClientGenerator generator = new ClientGenerator();
        generator.start();

        for(int i=0; i<tellers.length; i++){
            tellers[i] = new Teller(bankCash);
            tellers[i].start();
        }

        while(true) {
            if (!generator.getClients().isEmpty()) {
                min = 0;
                for (int i = 1; i < tellers.length; i++) {
                    if (tellers[i].getClients().size() < tellers[min].getClients().size())
                        min = i;
                    logger.info("Размер очереди " + i + " кассира: " + tellers[i].getClients().size());
                }
                tellers[min].addToQueue(generator.getClients().peek());
                generator.getClients().poll();
            }
        }
    }
}
