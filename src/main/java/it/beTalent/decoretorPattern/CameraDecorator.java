package it.beTalent.decoretorPattern;

public abstract class CameraDecorator implements Camera {

    protected Camera camera;

    public CameraDecorator(Camera camera) {
        this.camera = camera;
    }

    @Override
    public void enableFeatures(){
        camera.enableFeatures();
    }
}
