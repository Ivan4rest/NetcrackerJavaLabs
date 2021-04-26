import org.apache.log4j.Logger;

import java.util.PriorityQueue;
import java.util.Random;

public class ClientGenerator extends Thread{

    private static Logger logger = Logger.getLogger(ClientGenerator.class);

    private final int CLIENTS_PER_MINUTE = 5000;
    private final int SERVICE_TIME = 5000;

    private final PriorityQueue<Client> clients;

    public ClientGenerator() {
        this.clients = new PriorityQueue<Client>();
    }

    public PriorityQueue<Client> getClients() {
        synchronized (clients){
            return clients;
        }
    }

    @Override
    public void run() {
        Random rnd = new Random();
        while(true){
            try {
                sleep(rnd.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (clients){
                Random random = new Random();
                Client client = new Client(random.nextBoolean() ? OperationType.PUT_MONEY : OperationType.WITHDRAW_MONEY, random.nextInt(CLIENTS_PER_MINUTE) + 1, random.nextInt(SERVICE_TIME));
                clients.add(client);
                logger.info("Пришел новый клиент: " + client.hashCode());
            }
        }
    }
}
