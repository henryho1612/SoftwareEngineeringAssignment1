package vn.edu.rmit.common.model;

import java.util.*;
/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 11/23/13
 * Time: 2:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Customer {

    private String name;
    private String dob;
    int gender;
    private String address;
    private Date visitedDay;
    private String iCDCode;
    private String additionalICDCode;
    private String outcome;
    private String typeOfTreatment;
    private List<Service> services;
    private List<Drug> drugs;

    public Customer (String name, String dob, int gender, String address, Date visitedDay, String iCDCode, String additionalICDCode, String outcome, String typeOfTreatment, List<Service> services, List<Drug> drugs) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.visitedDay = visitedDay;
        this.iCDCode = iCDCode;
        this.additionalICDCode = additionalICDCode;
        this.outcome = outcome;
        this.typeOfTreatment = typeOfTreatment;
        this.services = services;
        this.drugs = drugs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getVisitedDay() {
        return visitedDay;
    }

    public void setVisitedDay(Date visitedDay) {
        this.visitedDay = visitedDay;
    }

    public String getiCDCode() {
        return iCDCode;
    }

    public void setiCDCode(String iCDCode) {
        this.iCDCode = iCDCode;
    }

    public String getAdditionalICDCode() {
        return additionalICDCode;
    }

    public void setAdditionalICDCode(String additionalICDCode) {
        this.additionalICDCode = additionalICDCode;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getTypeOfTreatment() {
        return typeOfTreatment;
    }

    public void setTypeOfTreatment(String typeOfTreatment) {
        this.typeOfTreatment = typeOfTreatment;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }
}
