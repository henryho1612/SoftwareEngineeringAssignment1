package vn.edu.rmit.common.utility;

import org.json.simple.parser.*;
import org.json.simple.*;
import org.json.simple.parser.ParseException;
import vn.edu.rmit.common.model.Customer;
import vn.edu.rmit.common.model.Drug;
import vn.edu.rmit.common.model.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 11/23/13
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileHandler {

    Customer customer = new Customer();
    JSONParser parser;
    Object nObject;
    JSONObject jsonObject;
    String data;

    public FileHandler(String data) {
        this.data = data;
    }

    public void insertValueFromJson() {
        try {
            parser = new JSONParser();
            nObject = parser.parse(data);
            if (nObject instanceof JSONObject) {
                jsonObject = (JSONObject) nObject;
                setCustomer();
            } else {
                JSONArray jsonOuterArray = (JSONArray) nObject;

                for (int i = 0; i < jsonOuterArray.size(); i++)
                {
                    nObject = parser.parse(jsonOuterArray.get(i).toString());
                    jsonObject = (JSONObject) nObject;
                    setCustomer();
                }
            }

        } catch (ParseException parseException) {
            System.out.println("Invalid JSON Format");
        }
    }

    private String dateChecker(String dateString)
    {
        String []dateArr = dateString.split("/");

        if (dateArr.length != 3)
        {
            System.out.println("There should be day, month and year.\nFormat: dd/mm/yyyy");
            return null;
        }

        int day = Integer.parseInt(dateArr[0]);
        int month = Integer.parseInt(dateArr[1]);
        int year = Integer.parseInt(dateArr[2]);

        if (month < 1 || month > 12)
        {
            System.out.println("Month should not be greater than 12 or less than 1");
            return null;
        }

        if ((day < 1 || day > 31) && (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12))
        {
            System.out.println("There are 31 days for month " + month);
            return null;
        }
        else if ((day < 1 || day > 30) && (month == 4 || month == 6 || month == 9 || month == 11))
        {
            System.out.println("There are 30 days for month " + month);
            return null;
        }
        else if ((day < 1 || day > 29) && (month == 2))
        {
            System.out.println("There are 29 days for month " + month);
            return null;
        }

        return year+"/"+month+"/"+day;
    }

    private void setCustomer() throws ParseException
    {
        String name = (String) jsonObject.get("Name");
        String dob = dateChecker((String) jsonObject.get("DOB"));
        String genderString = (String) jsonObject.get("Gender");
        int gender = 0;
        if (genderString.toLowerCase().equals("male"))
        {
            gender = 1;
        }
        String address = (String) jsonObject.get("Address");
        String dateOfVisit = dateChecker((String) jsonObject.get("DateOfVisit"));
        String icdCode = (String) jsonObject.get("ICDCode");
        String additionalICDCode = (String) jsonObject.get("AdditionalICDCode");
        String dateOfDischarge = dateChecker((String) jsonObject.get("DateOfDischarge"));
        String outcome = (String) jsonObject.get("Outcome");
        String typeOfTreatment = (String) jsonObject.get("TypeOfTreatment");

        List<Service> services = new ArrayList<>();
        JSONArray jsonArray = (JSONArray) jsonObject.get("ListOfServices");
        for (int i = 0; i < jsonArray.size(); i++) {
            nObject = parser.parse(jsonArray.get(i).toString());
            JSONObject jObject = (JSONObject) nObject;
            String labTest = (String) jObject.get("LabTest");
            String imageDiagnosis = (String) jObject.get("ImageDiagnosis");
            String surgery = (String) jObject.get("Surgery");
            String mirrorSurgery = (String) jObject.get("MirrorSurgery");
            services.add(new Service(labTest, imageDiagnosis, surgery, mirrorSurgery));
        }

        List<Drug> drugs = new ArrayList<>();
        jsonArray = (JSONArray) jsonObject.get("ListOfDrug");
        for (int i = 0; i < jsonArray.size(); i++) {
            nObject = parser.parse(jsonArray.get(i).toString());
            JSONObject jObject = (JSONObject) nObject;
            String drugName = (String) jObject.get("DrugName");
            int quality = Integer.parseInt(jObject.get("Quality").toString());
            int length = Integer.parseInt(jObject.get("Length").toString());
            drugs.add(new Drug(drugName, quality, length));
        }

        if (dob != null && dateOfDischarge != null && dateOfVisit != null)
        {
            Customer newCustomer = new Customer(name, dob, gender, address, dateOfVisit, icdCode, additionalICDCode, dateOfDischarge, outcome, typeOfTreatment, services, drugs);
            customer.getCustomers().add(newCustomer);
//            System.out.println(customer.getCustomers().get(0).toString());
        }
    }
}