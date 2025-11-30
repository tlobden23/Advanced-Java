package edu.bhcc;

public class Log {
    private String timeStamp;
    private String message;

    public Log(String timeStamp, String message) {
        this.timeStamp = timeStamp;
        this.message = message;
    }


    public String getTimeStamp() {
        return timeStamp;
    }

    public String getMessage() {
        return message;
    }
}
