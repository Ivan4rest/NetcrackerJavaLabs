import org.apache.log4j.Logger;

import java.util.PriorityQueue;

public class Teller extends Thread{
    private static Logger logger = Logger.getLogger(Teller.class);
    private final PriorityQueue<Client> clients;
    private final BankCash bankCash;
    private Client client;

    public Teller(BankCash bankCash) {
        super();
        this.clients = new PriorityQueue<Client>();
        this.bankCash = bankCash;
        this.client = null;
    }

    public PriorityQueue<Client> getClients() {
        return clients;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        while (true){
            startService();
        }
    }

    public synchronized void addToQueue(Client c){
        clients.add(c);
        if(client == null)
            notify();
        logger.info("Размер очереди: " + clients.size());
    }

    private synchronized void startService(){
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        service();
    }

    private void service(){
        synchronized (bankCash) {
            client = clients.peek();
            logger.info("Начато обслуживание клиента: " + client.hashCode());
            if(client.getOperationType() == OperationType.PUT_MONEY){
                bankCash.putMoney(client.getOperationAmount());
                logger.info("Внесение у клиента: " + client.hashCode());
                logger.info("Баланс кассы: " + bankCash.getCash());
            }
            else if(client.getOperationType() == OperationType.WITHDRAW_MONEY){
                while(!bankCash.withdrawMoney(client.getOperationAmount())) {
                    clients.poll();
                }
                logger.info("Списание у клиента: " + client.hashCode());
                logger.info("Баланс кассы: " + bankCash.getCash());
            }
        }
        try {
            sleep(client.getServiceTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        client = null;
        if(clients.size() > 0)
            service();
    }
}
