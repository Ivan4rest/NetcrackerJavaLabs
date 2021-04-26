public class Client implements Comparable<Client>{

    private OperationType operationType;

    private int operationAmount;

    private int serviceTime;

    public Client(OperationType operationType, int operationAmount, int serviceTime) {
        this.operationType = operationType;
        this.operationAmount = operationAmount;
        this.serviceTime = serviceTime;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public int getOperationAmount() {
        return operationAmount;
    }

    public void setOperationAmount(int operationAmount) {
        this.operationAmount = operationAmount;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(int serviceTime) {
        this.serviceTime = serviceTime;
    }

    @Override
    public int compareTo(Client o) {
        return 0;
    }
}
