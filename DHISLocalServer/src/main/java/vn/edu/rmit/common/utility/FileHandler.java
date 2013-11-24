package vn.edu.rmit.common.utility;

import org.json.simple.parser.*;
import org.json.simple.*;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 11/23/13
 * Time: 1:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileHandler {

    JSONParser parser;
    Object nObject;
    JSONObject jsonObject;
    JSONArray jsonArray;
    String data;

    public FileHandler(String data) {
        this.data = data;
    }

    public void insertValueFromJson() {
        try {
            parser = new JSONParser();
            nObject = parser.parse(data);
            jsonObject = (JSONObject) nObject;

            String name = (String) jsonObject.get("Name");
            System.out.println(name);
            String dob = (String) jsonObject.get("DOB");
            System.out.println(dob);
            String gender = (String) jsonObject.get("Gender");
            System.out.println(gender);
            String address = (String) jsonObject.get("Address");
            System.out.println(address);
            String dateOfVisit = (String) jsonObject.get("DateOfVisit");
            System.out.println(dateOfVisit);
            String icdCode = (String) jsonObject.get("ICDCode");
            System.out.println(icdCode);
            String additionalICDCode = (String) jsonObject.get("AdditionalICDCode");
            System.out.println(additionalICDCode);
            String dateOfDischarge = (String) jsonObject.get("DateOfDischarge");
            System.out.println(dateOfDischarge);
            String outcome = (String) jsonObject.get("Outcome");
            System.out.println(outcome);
            String typeOfTreatment = (String) jsonObject.get("TypeOfTreatment");
            System.out.println(typeOfTreatment);

            jsonArray = (JSONArray)jsonObject.get("ListOfServices");
            for (int i = 0; i < jsonArray.size(); i++)
            {
                nObject = parser.parse(jsonArray.get(i).toString());
                JSONObject jObject = (JSONObject) nObject;
                System.out.println("--------"+i+"--------");
                String labTest = (String) jObject.get("LabTest");
                System.out.println(labTest);
                String imageDiagnosis = (String) jObject.get("ImageDiagnosis");
                System.out.println(imageDiagnosis);
                String surgery = (String) jObject.get("Surgery");
                System.out.println(surgery);
                String mirrorSurgery = (String) jObject.get("MirrorSurgery");
                System.out.println(mirrorSurgery);
            }

            jsonArray = (JSONArray)jsonObject.get("ListOfDrug");
            for (int i = 0; i < jsonArray.size(); i++)
            {
                nObject = parser.parse(jsonArray.get(i).toString());
                JSONObject jObject = (JSONObject) nObject;
                System.out.println("D--------"+i+"--------");
                String drugName = (String) jObject.get("DrugName");
                System.out.println(drugName);
                int quality = Integer.parseInt(jObject.get("Quality").toString());
                System.out.println(quality);
                int length = Integer.parseInt(jObject.get("Length").toString());
                System.out.println(length);
            }

        } catch (ParseException parseException) {
            System.out.println("Invalid Json String");
        }
    }
}
