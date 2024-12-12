package it.beTalent.decoretorPattern;

public class MotionSensorDecorator extends CameraDecorator{
    public MotionSensorDecorator(Camera camera) {
        super(camera);
    }
    @Override
    public void enableFeatures(){
        super.enableFeatures();
        System.out.println("Il sensore di movimento è attivo.");
    }
}
