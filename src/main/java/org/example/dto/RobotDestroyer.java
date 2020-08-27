package org.example.dto;

import org.example.annotation.CustomDateFormat;
import org.example.annotation.JsonValue;

import java.time.LocalDate;

public class RobotDestroyer {


    @JsonValue(name = "number")
    String serial;
    @JsonValue(name = "model")
    String productOwner;
    @JsonValue(name = "killcam")
    Long fragCounter;
    @CustomDateFormat(format = "dd-MMM-yy")
    LocalDate dateRelease;
    LocalDate dateFrag;

    public RobotDestroyer() {
    }

    public RobotDestroyer(String serial, String productOwner, Long fragCounter, LocalDate dateRelease, LocalDate dateFrag) {
        this.serial = serial;
        this.productOwner = productOwner;
        this.fragCounter = fragCounter;
        this.dateRelease = dateRelease;
        this.dateFrag = dateFrag;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getProductOwner() {
        return productOwner;
    }

    public void setProductOwner(String productOwner) {
        this.productOwner = productOwner;
    }

    public Long getFragCounter() {
        return fragCounter;
    }

    public void setFragCounter(Long fragCounter) {
        this.fragCounter = fragCounter;
    }

    public LocalDate getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(LocalDate dateRelease) {
        this.dateRelease = dateRelease;
    }

    public LocalDate getDateFrag() {
        return dateFrag;
    }

    public void setDateFrag(LocalDate dateFrag) {
        this.dateFrag = dateFrag;
    }
}
