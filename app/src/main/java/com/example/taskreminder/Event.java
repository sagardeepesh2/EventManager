package com.example.taskreminder;

public class Event {
    private int id;
    private String event;
    private String date;
    private String eventty;

    public Event(){}
    
    public int getID(){ return id;}
    public void setID(int id){this.id=id;}
    public String getEvent(){return event;}
    public void setEvent(String event){ this.event=event;}
    public String getDate(){return date;}
    public void setDate(String date){ this.date=date;}
    public void setEventty(String eventty){this.eventty=eventty;}
    public String getEventty(){return eventty;}
}
