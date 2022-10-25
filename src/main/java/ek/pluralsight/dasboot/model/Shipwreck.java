package ek.pluralsight.dasboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Shipwreck {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String description;
    String ship_condition;
    int depth;
    double latitude;
    double longtitude;
    int yearDiscovered;

    public Shipwreck() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return ship_condition;
    }

    public void setCondition(String condition) {
        this.ship_condition = condition;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public int getYearDiscovered() {
        return yearDiscovered;
    }

    public void setYearDiscovered(int yearDiscovered) {
        this.yearDiscovered = yearDiscovered;
    }

    public Shipwreck(long id, String name, String description, String condition, int depth, double latitude, double longtitude, int yearDiscovered) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.ship_condition = condition;
        this.depth = depth;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.yearDiscovered = yearDiscovered;
    }
}
