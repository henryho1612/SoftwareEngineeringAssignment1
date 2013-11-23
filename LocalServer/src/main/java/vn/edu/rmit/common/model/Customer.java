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
}
