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

    private List<Customer> customers = new ArrayList<>();
    private String name;
    private String dob;
    int gender;
    private String address;
    private String visitedDay;
    private String iCDCode;
    private String additionalICDCode;
    private String dateOfDischarge;
    private String outcome;
    private String typeOfTreatment;
    private List<Service> services;
    private List<Drug> drugs;

    public Customer(){}

    public Customer (String name, String dob, int gender, String address, String visitedDay, String iCDCode, String additionalICDCode, String dateOfDischarge, String outcome, String typeOfTreatment, List<Service> services, List<Drug> drugs) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        this.visitedDay = visitedDay;
        this.iCDCode = iCDCode;
        this.additionalICDCode = additionalICDCode;
        this.dateOfDischarge = dateOfDischarge;
        this.outcome = outcome;
        this.typeOfTreatment = typeOfTreatment;
        this.services = services;
        this.drugs = drugs;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public int getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getVisitedDay() {
        return visitedDay;
    }

    public String getiCDCode() {
        return iCDCode;
    }

    public String getAdditionalICDCode() {
        return additionalICDCode;
    }

    public String getDateOfDischarge() {
        return dateOfDischarge;
    }

    public String getOutcome() {
        return outcome;
    }

    public String getTypeOfTreatment() {
        return typeOfTreatment;
    }

    public List<Service> getServices() {
        return services;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    @Override
    public String toString()
    {
        return name + "\n" + dob + "\n" + gender + "\n" + address + "\n" + visitedDay + "\n" +
                iCDCode + "\n" + additionalICDCode + "\n" + getDateOfDischarge() + "\n" +
                outcome + "\n" + typeOfTreatment + "\n" + services.get(0).toString() + "\n" + drugs.get(0).toString();
    }
}
