package edu.geography.states.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import lombok.*;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
//import lombok.ToString;

import java.time.LocalDate;


@AllArgsConstructor
@EqualsAndHashCode
//@Getter
//@Setter
@NoArgsConstructor
//@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class City {
    private String zipCode;

    private String name;

    private String stateCode;

    private String airportCode;

    private LocalDate incorporatedDate;

    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public LocalDate getIncorporatedDate() {
        return incorporatedDate;
    }

    public void setIncorporatedDate(LocalDate incorporatedDate) {
        this.incorporatedDate = incorporatedDate;
    }

    public String getAirportCode() {
        return airportCode;
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String toString() {
        return "{" +
                    "\"zipCode\": \"" + this.getZipCode() + "\"," +
                    "\"name\": \"" + this.getName() + "\"," +
                    "\"stateCode\": \"" + this.getStateCode() + "\"," +
                    "\"airportCode\": \"" + this.getAirportCode() + "\"," +
                    "\"incorporatedDate\": \"" + this.getIncorporatedDate() + "\"," +
                    "\"nickName\": \"" + this.getNickName() + "\"," +
                "}";

    }
    /*
        "zipCode": "01601",
    "name": "Worcester",
    "stateCode": "MA",
    "airportCode": "ORH",
    "incorporatedDate": "1722-06-14",
    "nickName": null

        {
        "zipCode": "72712",
        "name": "Bentonville",
        "stateCode": "AR",
        "airportCode": "XNA",
        "incorporatedDate": "1873-04-03",
        "nickName": null
    }
    */
}
