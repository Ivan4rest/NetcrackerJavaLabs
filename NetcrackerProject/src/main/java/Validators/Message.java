package Validators;

import java.util.List;

public class Message {
    /**
     * Value of message
     */
    private String text;

    /**
     * Status of message
     */
    private Status status;

    /**
     * Constructor by default set status NORMAL and text ""
     */
    public Message() {
        this.status = Status.NORMAL;
        this.text = "";
    }

    /**
     * Constructor by default set text ""
     * @param status
     */
    public Message(Status status) {
        this.status = status;
        this.text = "";
    }

    /**
     * Constructor
     * @param message
     * @param status
     */
    public Message(String message, Status status) {
        this.text = message;
        this.status = status;
    }

    /**
     * Constructor set message from list of messages
     * @param messages
     */
    public Message(List<Message> messages) {
        this();
        for (int i = 0; i < messages.size(); i++) {
            setText(messages.get(i).getText() + "\n");
            if((messages.get(i).getStatus() == Status.WARNING) && (getStatus() != Status.ERROR)){
                setStatus(Status.WARNING);
            }
            else if(messages.get(i).getStatus() == Status.ERROR){
                setStatus(Status.ERROR);
            }
        }
    }

    /**
     * Getter for message
     * @return
     */
    public String getText() {
        return text;
    }

    /**
     * Setter for message
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Getter for status
     * @return
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Setter for status
     * @param status
     */
    public void setStatus(Status status) {
        this.status = status;
    }
}
