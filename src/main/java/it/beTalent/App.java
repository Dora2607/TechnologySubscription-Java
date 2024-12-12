package it.beTalent;

import it.beTalent.decoretorPattern.*;
import it.beTalent.entity.User;
import it.beTalent.utility.ChoiseInitializer;

import java.util.InputMismatchException;
import java.util.Scanner;

import static it.beTalent.entity.User.*;
import static it.beTalent.utility.ChoiseInitializer.getCamera;

public class App
{
    public static <camera> void main(String[] args ) {

        Scanner scan = new Scanner(System.in);
        String cameraType = "";
        String subscriptionPlan = "";
        int maxFeatures=0;



        try{
            cameraType = ChoiseInitializer.choiseCameraType(scan);
        }catch (IllegalArgumentException e) {
            System.out.println("Scelta non valida. Per favore, riprova.");
            cameraType = ChoiseInitializer.choiseCameraType(scan);
        }

        try{
            subscriptionPlan = ChoiseInitializer.choiseSubscription(scan);
        }catch (IllegalArgumentException e) {
            System.out.println("Scelta non valida. Per favore, riprova.");
            subscriptionPlan = ChoiseInitializer.choiseSubscription(scan);
        }

        maxFeatures = ChoiseInitializer.setMaxFeatures(subscriptionPlan);

        User.UserBuilder userBuilder = User.UserBuilder.anUser()
                .cameraType(cameraType)
                .subscriptionPlan(subscriptionPlan);

        for(int i=0; i< maxFeatures; i++){
            String feature ="";
            try {
                feature = ChoiseInitializer.choiseFeatures(scan);
            }catch (IllegalArgumentException e) {
                System.out.println("Scelta non valida. Per favore, riprova.");
                feature = ChoiseInitializer.choiseFeatures(scan);
            }
            userBuilder.addFeature(feature);
        }

        User user = userBuilder.build();
        System.out.println(user);

        Camera camera = getCamera(user);
        camera.enableFeatures();


    }

}
