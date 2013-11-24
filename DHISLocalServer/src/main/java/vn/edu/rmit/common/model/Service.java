package vn.edu.rmit.common.model;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 11/23/13
 * Time: 2:50 PM
 * To change this template use File | Settings | File Templates.
 */
public class Service {

    String labTest;
    String imageDiagnosis;
    String surgery;
    String mirrorSurgery;

    public Service (String labTest, String imageDiagnosis, String surgery, String mirrorSurgery)
    {
        this.labTest = labTest;
        this.imageDiagnosis = imageDiagnosis;
        this.surgery = surgery;
        this.mirrorSurgery = mirrorSurgery;
    }

    public String getLabTest() {
        return labTest;
    }

    public String getImageDiagnosis() {
        return imageDiagnosis;
    }

    public String getSurgery() {
        return surgery;
    }

    public String getMirrorSurgery() {
        return mirrorSurgery;
    }

    @Override
    public String toString()
    {
        return  labTest + "-" + imageDiagnosis + "-" + surgery + "-" + mirrorSurgery;
    }
}
