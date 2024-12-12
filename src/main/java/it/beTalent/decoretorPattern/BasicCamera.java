package it.beTalent.decoretorPattern;

public class BasicCamera implements Camera {

    private String CameraType;

    public BasicCamera(String cameraType) {
        CameraType = cameraType;
    }


    public String getCameraType() {
        return CameraType;
    }

    public void setCameraType(String cameraType) {
        CameraType = cameraType;
    }

    @Override
    public void enableFeatures() {
        System.out.println("Telecamera "+getCameraType()+ " è attiva." );
    }



}
