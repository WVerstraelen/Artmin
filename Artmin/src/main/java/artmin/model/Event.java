/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artmin.model;

import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Rei
 */

@Entity
@Table(name="events")
public class Event {
    //    Attributen
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "artistID", nullable=false)
    private Long artistID;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Artist artist;
    
    @NotEmpty
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "todoAck", nullable = true)
    private boolean todoAck;
    
    @Column(name = "dateCalendar", nullable = true)
    private LocalDateTime dateCalendar;
    
    @Column(name = "dateActStart", nullable = true)
    private LocalDateTime dateActStart;
    
    @Column(name = "dateActEnd", nullable = true)
    private LocalDateTime dateActEnd;
    
    @Column(name = "dateAck", nullable = true)
    private boolean dateAck;
    
    @Column(name = "confirmedAck", nullable = true)
    private boolean confirmedAck;
    
    @Column(name = "locationID", nullable = true)
    private Long locationID;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private EventLocation locations;
    
    @Column(name = "locationAck", nullable = true)
    private boolean locationAck;
    
    @Column(name = "clientID", nullable = true)
    private Long clientID;
    
    @ManyToOne(fetch = FetchType.LAZY)
    private Client clients;
    
    @Column(name = "clientAck", nullable = true)
    private boolean clientAck;
    
    @Column(name = "crowdQty", nullable = true)
    private int crowdQty;
    
    @Column(name = "crowdsAvgAge", nullable = true)
    private int crowdsAvgAge;
    
    @Column(name = "crowdInformation", nullable = true)
    private String crowdInformation;
    
    @Column(name = "crowdAck", nullable = true)
    private boolean crowdAck;
    
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="eventID")
    private Set<Note> notes;
    
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="eventID")
    private Set<Payment> payments;
    
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="eventID")
    private Set<Todo> todos;
    
//    Properties

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArtistID() {
        return artistID;
    }

    public void setArtistID(Long artistID) {
        this.artistID = artistID;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTodoAck() {
        return todoAck;
    }

    public void setTodoAck(boolean todoAck) {
        this.todoAck = todoAck;
    }

    public LocalDateTime getDateCalendar() {
        return dateCalendar;
    }

    public void setDateCalendar(LocalDateTime dateCalendar) {
        this.dateCalendar = dateCalendar;
    }

    public LocalDateTime getDateActStart() {
        return dateActStart;
    }

    public void setDateActStart(LocalDateTime dateActStart) {
        this.dateActStart = dateActStart;
    }

    public LocalDateTime getDateActEnd() {
        return dateActEnd;
    }

    public void setDateActEnd(LocalDateTime dateActEnd) {
        this.dateActEnd = dateActEnd;
    }

    public boolean isDateAck() {
        return dateAck;
    }

    public void setDateAck(boolean dateAck) {
        this.dateAck = dateAck;
    }

    public boolean isConfirmedAck() {
        return confirmedAck;
    }

    public void setConfirmedAck(boolean confirmedAck) {
        this.confirmedAck = confirmedAck;
    }

    public Long getLocationID() {
        return locationID;
    }

    public void setLocationID(Long locationID) {
        this.locationID = locationID;
    }

    public EventLocation getLocations() {
        return locations;
    }

    public void setLocations(EventLocation locations) {
        this.locations = locations;
    }

    public boolean isLocationAck() {
        return locationAck;
    }

    public void setLocationAck(boolean locationAck) {
        this.locationAck = locationAck;
    }

    public Long getClientID() {
        return clientID;
    }

    public void setClientID(Long clientID) {
        this.clientID = clientID;
    }

    public Client getClients() {
        return clients;
    }

    public void setClients(Client clients) {
        this.clients = clients;
    }

    public boolean isClientAck() {
        return clientAck;
    }

    public void setClientAck(boolean clientAck) {
        this.clientAck = clientAck;
    }

    public int getCrowdQty() {
        return crowdQty;
    }

    public void setCrowdQty(int crowdQty) {
        this.crowdQty = crowdQty;
    }

    public int getCrowdsAvgAge() {
        return crowdsAvgAge;
    }

    public void setCrowdsAvgAge(int crowdsAvgAge) {
        this.crowdsAvgAge = crowdsAvgAge;
    }

    public String getCrowdInformation() {
        return crowdInformation;
    }

    public void setCrowdInformation(String crowdInformation) {
        this.crowdInformation = crowdInformation;
    }

    public boolean isCrowdAck() {
        return crowdAck;
    }

    public void setCrowdAck(boolean crowdAck) {
        this.crowdAck = crowdAck;
    }

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    public Set<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    public Set<Todo> getTodos() {
        return todos;
    }

    public void setTodos(Set<Todo> todos) {
        this.todos = todos;
    }

    
    
//    Methodes
    
    @Override
    public int hashCode() {
        final int prime = 31;
        long result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return (int)result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Event))
            return false;
        Event other = (Event) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "Event [id=" + id + ", name=" + name + "]";
    }
}
