package com.company;

import java.util.ArrayList;

public class Event {

    private
        String eventName;
        String eventDescription;
        String eventDate;
        int duration;
        enum EventType {Weekly, Monthly, Yearly};
        EventType eventType;
        ArrayList <Person> ParticipantsAndOrganizersList;

    public Event() {
    }

    public Event(String eventName, String eventDescription, String eventDate,
                 int duration, EventType eventType) {
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventDate = eventDate;
        this.eventType = eventType;
        ParticipantsAndOrganizersList = new ArrayList <Person>();
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", eventDescription='" + eventDescription + '\'' +
                ", eventDate='" + eventDate + '\'' +
                ", duration=" + duration +
                ", eventType=" + eventType +
                ", ParticipantsAndOrganizersList=" + ParticipantsAndOrganizersList +
                '}';
    }

    public void displayAll() {  //  type casting
        for (int i=0;i<ParticipantsAndOrganizersList.size();i++) {
            if (ParticipantsAndOrganizersList.get(i) instanceof Participant)
                ((Participant) ParticipantsAndOrganizersList.get(i)).displayAll();
            if (ParticipantsAndOrganizersList.get(i) instanceof EventOrganizers)
                ((EventOrganizers) ParticipantsAndOrganizersList.get(i)).displayAll();
        }
    }

    public void addPerson(Person p) {
        ParticipantsAndOrganizersList.add(p);
    }




    public void removePerson(int pIndex) {


        ParticipantsAndOrganizersList.remove(pIndex);
    }

    public int getNumberOfPersons() {
        return ParticipantsAndOrganizersList.size();
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public ArrayList<Person> getParticipantsAndOrganizersList() {
        return ParticipantsAndOrganizersList;
    }

    public void setParticipantsAndOrganizersList(ArrayList<Person> participantsAndOrganizersList) {
        ParticipantsAndOrganizersList = participantsAndOrganizersList;
    }
}
