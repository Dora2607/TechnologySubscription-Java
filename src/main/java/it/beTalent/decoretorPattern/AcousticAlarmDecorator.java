package it.beTalent.decoretorPattern;

public class AcousticAlarmDecorator extends CameraDecorator{
    public AcousticAlarmDecorator(Camera camera) {
        super(camera);
    }

    @Override
    public void enableFeatures(){
        super.enableFeatures();
        System.out.println("L'allarme acustico è attivo");
    }
}
