import hu.szlavikszabolcs.controller.PlantBreedingController;

import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        startApp();
    }

    public static void startApp(){
        PlantBreedingController controller = new PlantBreedingController();
        controller.startDesktop();

    }


}
