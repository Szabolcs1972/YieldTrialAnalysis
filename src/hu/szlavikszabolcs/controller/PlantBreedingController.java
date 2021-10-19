package hu.szlavikszabolcs.controller;

import hu.szlavikszabolcs.model.PlantBreedingDAO;
import hu.szlavikszabolcs.model.PlantBreedingDAOImpl;
import hu.szlavikszabolcs.view.PlantBreedingGUI;

import java.util.Locale;

public class PlantBreedingController {
    public PlantBreedingDAO dao = new PlantBreedingDAOImpl();

    public void startDesktop(){

        PlantBreedingGUI gui = new PlantBreedingGUI(this);
        //System.out.println("Lokalizáció: " + Locale.getDefault());
        gui.startGUI();


    }


}
