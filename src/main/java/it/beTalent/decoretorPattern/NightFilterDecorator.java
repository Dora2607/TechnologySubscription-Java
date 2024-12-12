package it.beTalent.decoretorPattern;

public class NightFilterDecorator extends CameraDecorator{

    public NightFilterDecorator(Camera camera) {
        super(camera);
    }
    @Override
    public void enableFeatures(){
        super.enableFeatures();
        System.out.println("Filtro notturno è attivo.");
    }
}
