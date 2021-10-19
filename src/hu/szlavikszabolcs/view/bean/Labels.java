package hu.szlavikszabolcs.view.bean;

import javax.swing.*;

public class Labels {
    //labels for Login
    public static final String enter = "Belépés a programba";
    public static final String userName = "Felhasználónév:";
    public static final String passWord = "Jelszó:";
    public static final String loginError = "Nem megfelelő felhasználónév/jelszó";
    public static final String failToPass = "Hibás belépés! Viszontlátásra!";
    public static final String emptyField = "Valamelyik mező üres!";
    public static final String noHTML = "Nincs web kapcsolat, vagy a weboldal nem található!";
    public static final String noImageIcon = "Az ikonhoz tartozó kép fájl nem található!";

    //labels for JFileChooser
    public static final String open = "Megnyitás";
    public static final String approveButtonToolTipText = "A kiválasztott fájl megnyitása";

    //labels for Menu
    public static final String menuPoint = "File";
    public static final String menuItem = "Fajtakísérlet eredményének betöltése";
    public static final String menuItem2 = "Kilépés";

    public static final String menuPoint2 = "Számítások";
    public static final String menuItem3 = "Terméseredmények számítása";

    public static final String menuPoint3 = "Adatbázis";
    public static final String menuItem4 = "Adatbázis megjelenítése";

    public static final String menuPoint4 = "Beállítások";

    public static final String menuPoint5 = "Súgó";
    public static final String menuItem5 = "Összefoglaló statisztika";
    public static final String menuItem6 = "Segítség";
    public static final String menuItem7 = "Névjegy";


    //labels for computed yield
    public static final String error = "Hiba!";
    public static final String noDataError = "Hiba! Nem olvastál be adatokat!";
    public static final String numberFormatnoError = "Hiba! Nem megfelelő számokat adtál meg!";
    public static final String getPlotSize = "<html>A parcella területe (m<sup>2</sup>)</html>";
    public static final String getMoistureToSet = "Mekkora nedvességre egalizáljuk a termést?";
    public static final String input = "Bevitel";
    public static final String saveYieldsToDatabase = "A kísérlet adatainak mentése az adatbázisba";
    public static final String informationCalculateSummaryStatistics = "<html>Az összefoglaló statisztika menüpont aktív!<br>A Számítások -> Terméseredmények számítása menüpont inaktív</html>";

    //labels for statistics
    public static final String saveToExcel = "Eremények mentése Excel fájlba";
    public static final String fileWriteToExcelSuccess = "A Statisztika.xlsx fájl írása sikeresen megtörtént!";

    //database management
    public static final String loginToDatabase = "Belépés az adatbázisba";
    public static final String dataUploadSuccess = "Az adatok feltöltése sikeresenen megtörtént!";
    public static final String cancel = "Mégsem";
    public static final String ok = "Rendben";

    //file management
    public static final String columnNumberError = "Az oszlopok száma nem megfelelő!";
    public static final String columnLabelError = "Az oszlop fejlécek nem megfelelőek!";
    public static final String fileDataLoadSuccess = "<html>Az adatok beolvasása sikeresen megtörtént!<br>A Számítások -> Terméseredmények számítása menüpont aktív<br>A Fájl -> Fajtakísérleti eredmények betöltése menüpont inaktív</html>";

    //configuration
    public static final String configFileNotFound = "A konfigurációs fájl nem található! Viszontlátásra!";
    public static final String writeIOException = "Írási hiba!";
    public static final String saveConfig = "A beállítások mentése";
    public static final String configDialogTitle = "Beállítások";
    public static final String userEntrance = "<html><strong><u>Belépési azonosító</u></strong></html>";
    public static final String databaseDetails = "<html><strong><u>Adatbázis azonosítók</u></strong></html>";
    public static final String databaseLink = "Adatbázis url (pl.: jdbc:mysql://localhost:3306/mydatabase)";
    public static final String databaseUser = "Adatbázis felhasználónév";
    public static final String databasePassWord = "Adatbázis jelszó";

    //about
    public static final String aboutOKJ = "OKJ Vizsgafeladat";
    public static final String aboutSzabolcs = "Dr. Szlávik Szabolcs";
    public static final String mail = "szabolcsszlavik@gmail.com";
    public static final String urlSzabolcs = "https://www.szlavikszabolcs.hu";
    public static final String urlSzabolcsUnderLine = "<html><u>https://www.szlavikszabolcs.hu</u></html>";
    public static final String aboutSzeged = "Szeged, 2021.";
    public static final String aboutWebler = "Köszönet, a Webler Oktatóstudió részére!";
    public static final String urlWebler = "https://webler.hu";
    public static final String urlWeblerUnderLine = "<html><u>https://webler.hu</u></html>";
    public static final String card = "Névjegy";
    public static final String information = "Információ";
    public static final String spacer = "***";
}
