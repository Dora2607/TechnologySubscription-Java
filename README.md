# Technology Subscription 

Questo progetto è un'applicazione Java per gestire le telecamere e le loro funzionalità in base al tipo di abbonamento scelto dall'utente. 
Il progetto è stato sviluppato utilizzando Maven come strumento di build.

## Struttura del Progetto

Il progetto è composto da diverse classi, ciascuna con un ruolo specifico:

- `App`: Punto di ingresso principale del programma.
- `ChoiseInitializer`: Classe che gestisce le scelte dell'utente riguardo il tipo di telecamera, il piano di abbonamento e le funzionalità.
- `User`: Classe che rappresenta l'utente e le sue scelte.
- `Camera`: Interfaccia che definisce il comportamento delle telecamere.
- `BasicCamera`: Classe che implementa l'interfaccia Camera e rappresenta una telecamera di base.
- `CameraDecorator`: Classe astratta che implementa l'interfaccia Camera e aggiunge funzionalità alle telecamere.
- `NightFilterDecorator`: Classe che aggiunge il filtro notturno alla telecamera.
- `MotionSensorDecorator`: Classe che aggiunge il sensore di movimento alla telecamera.
- `AcousticAlarmDecorator`: Classe che aggiunge l'allarme acustico alla telecamera.

## Requisiti

- JDK 8 o superiore
- Maven

## Installazione

1. Clona il repository:
    ```sh
    git clone https://github.com/Dora2607/TechnologySubscription-Java.git
    ```
2. Naviga nella directory del progetto:
    ```sh
    cd technologySubscription
    ```
3. Costruisci il progetto utilizzando Maven:
    ```sh
    mvn clean install
    ```

## Decorator Pattern

Il Decorator Pattern è stato utilizzato per aggiungere dinamicamente funzionalità alle telecamere in base al piano di abbonamento scelto dall'utente.
Questo pattern permette di estendere le funzionalità degli oggetti in modo flessibile e modulare. Nel progetto:

    - L'interfaccia Camera definisce il comportamento comune delle telecamere.

    - La classe BasicCamera implementa l'interfaccia Camera e rappresenta una telecamera di base.

    - La classe astratta CameraDecorator estende l'interfaccia Camera e serve come base per i decorator concreti.

    - I decorator concreti (NightFilterDecorator, MotionSensorDecorator, AcousticAlarmDecorator) estendono CameraDecorator e aggiungono funzionalità specifiche alle telecamere.

## Utilizzo 
Al lancio dell'applicazione, viene visualizzato un menu con le seguenti funzionalità:

1. Scegli il tipo di telecamera (appartamento, esterno, sotterraneo).

2. Scegli il piano di abbonamento (Silver, Gold, Platinum).

3. Aggiungi le funzionalità alla telecamera in base al piano di abbonamento scelto (filtro notturno, sensore di movimento, allarme acustico).

4. Abilita le funzionalità della telecamera.