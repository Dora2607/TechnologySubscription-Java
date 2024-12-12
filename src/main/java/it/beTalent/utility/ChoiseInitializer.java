package it.beTalent.utility;

import it.beTalent.decoretorPattern.*;
import it.beTalent.entity.User;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChoiseInitializer {

    public static String choiseCameraType(Scanner scan)  {

        while (true){
            System.out.println("Scegli il tipo di telecamera:");
            System.out.println("Digita 1: Telecamera da appartamento");
            System.out.println("Digita 2: Telecamera da esterno");
            System.out.println("Digita 3: Telecamera da sotterraneo");

            //verifica che l'input è un numero
            if(!scan.hasNextInt()){
                System.out.println("Input non valido. Per favore, inserisci un numero.");
                scan.next();
                continue;
            }
            int choise = scan.nextInt();

            return switch (choise) {
                case 1 -> "da appartamento";
                case 2 -> "da esterno";
                case 3 -> "da sotterraneo";
                default -> throw new IllegalArgumentException("Scelta non valida");
            };
        }


    }

    public static String choiseSubscription(Scanner scan) throws InputMismatchException {

        while (true) {
            System.out.println("Scegli il tipo di abbonamento:");
            System.out.println("Digita 1: Abbonamento Silver");
            System.out.println("Digita 2: Abbonamento Gold");
            System.out.println("Digita 3: Abbonamento Platinum");

            if(!scan.hasNextInt()){
                System.out.println("Input non valido. Per favore, inserisci un numero.");
                scan.next();
                continue;
            }
            int choise = scan.nextInt();

            return switch (choise) {
                case 1 -> "Abbonamento Silver";
                case 2 -> "Abbonamento Gold";
                case 3 -> "Abbonamento Platinum";
                default -> throw new IllegalArgumentException("Scelta non valida");
            };
        }

    }

    //numero di feature da aggiungere a seconda dell'abbonamento

    public static int setMaxFeatures(String subscriptionPlan)  {

        System.out.println("Hai diritto a un numero di funzionalità pari a: ");
        System.out.println("Abbonamento Silver: una sola funzionalità.");
        System.out.println("Abbonamento Gold: due funzionalità.");
        System.out.println("Abbonamento Platinum: tre funzionalità.");

        return switch (subscriptionPlan) {
            case "Abbonamento Silver" -> 1;
            case "Abbonamento Gold" -> 2;
            case "Abbonamento Platinum" -> 3;
            default -> throw new IllegalArgumentException("Scelta non valida");
        };

    }

    public static String choiseFeatures(Scanner scan) throws InputMismatchException {

        while (true) {
            System.out.println("Scegli il tipo di funzionalità della camera:");
            System.out.println("Digita 1: filtro notturno");
            System.out.println("Digita 2: sensore di movimento");
            System.out.println("Digita 3: allarme acustico");

            if (!scan.hasNextInt()) {
                System.out.println("Input non valido. Per favore, inserisci un numero.");
                scan.next();
                continue;
            }
            int choise = scan.nextInt();

            return switch (choise) {
                case 1 -> "filtro notturno";
                case 2 -> "sensore di movimento";
                case 3 -> "allarme acustico";
                default -> throw new IllegalArgumentException("Scelta non valida");
            };

        }
    }


    public static Camera getCamera(User user) {
        Camera camera = new BasicCamera(user.getCameraType());

        for(String feature: user.getFeatures()){
            switch (feature){
                case "filtro notturno":
                    camera = new NightFilterDecorator(camera);
                    break;

                case "sensore di movimento":
                    camera = new MotionSensorDecorator(camera);
                    break;

                case "allarme acustico":
                    camera = new AcousticAlarmDecorator(camera);
                    break;
            }
        }
        return camera;
    }



}
