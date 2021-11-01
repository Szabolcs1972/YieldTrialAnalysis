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
    public static final String numberValueError = "Hiba! A parcella területe > 0 legyen, a nedvesség pedig > 0, és < 100 %!";
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
    public static final String standardValueError = "<html>A standard fajták jelölése 0, vagy 1!<br> Indítsd újra a programot!</html>";
    public static final String nameValueError = "<html>A fajtanév mező nem lehet üres!<br> Indítsd újra a programot!</html>";
    public static final String plotWeightValueError = "<html>A parcella tömeg 0-nál nagyobb szám legyen!<br> Indítsd újra a programot!</html>";
    public static final String moistureValueError = "<html>A minta nedvessége 0-nál nagyobb szám legyen!<br> Indítsd újra a programot!</html>";

    public static final String fileDataLoadSuccess = "<html>Az adatok beolvasása sikeresen megtörtént!<br>A Számítások -> Terméseredmények számítása menüpont aktív<br>A Fájl -> Fajtakísérleti eredmények betöltése menüpont inaktív</html>";
    public static final String fileDataLoadFailure = "<html>Hiba lépett fel az adatok betöltése során! Indítsd újra a programot!</html>";

    //configuration

    public static final String warning = "Figyelmeztetés!";
    public static final String configFileNotFound = "A konfigurációs fájl nem található! Viszontlátásra!";
    public static final String writeIOException = "Írási hiba!";
    public static final String saveConfig = "A beállítások mentése";
    public static final String configDialogTitle = "Beállítások";
    public static final String userEntrance = "<html><strong><u>Belépési azonosító</u></strong></html>";
    public static final String databaseDetails = "<html><strong><u>Adatbázis azonosítók</u></strong></html>";
    public static final String databaseLink = "Adatbázis url";
    public static final String databaseUser = "Adatbázis felhasználónév";
    public static final String databasePassWord = "Adatbázis jelszó";
    public static final String emptyConfigFields = "Az adatbázis jelszó kivételével, a mezők nem lehetnek üresek!";

    //about
    public static final String aboutOKJ = "OKJ Vizsgafeladat";
    public static final String aboutSzabolcs = "Dr. Szlávik Szabolcs";
    public static final String mail = "szabolcsszlavik@gmail.com";
    public static final String urlSzabolcs = "https://www.szlavikszabolcs.hu";
    public static final String urlSzabolcsUnderLine = "<html><u>https://www.szlavikszabolcs.hu</u></html>";
    public static final String aboutSzeged = "Szeged, 2021.";
    public static final String aboutCC0 = "Növényfajta kísérlet elemző, Licensz: CC0 1.0 Univerzális - Közkincs nyilatkozat";
    public static final String urlCC0 = "https://creativecommons.org/publicdomain/zero/1.0/legalcode";
    public static final String aboutPOI = "Apache POI 5.0.0, License: Apache 2.0";
    public static final String urlPOI = "http://www.apache.org/licenses/LICENSE-2.0.txt";

    public static final String aboutMySQLConnector = "MySQL Connector/J 8.0.26, License: GPL 2.0 with FOSS exception";
    public static final String urlFOSS = "https://oss.oracle.com/licenses/universal-foss-exception/";
    public static final String urlGPL = "https://www.gnu.org/licenses/old-licenses/gpl-2.0.html";

    public static final String aboutLaunch4j = "Launch4j 3.14, License: BSD-3-Clause, MIT License";
    public static final String urlBSD3 = "https://opensource.org/licenses/BSD-3-Clause/";
    public static final String urlMIT = "https://opensource.org/licenses/mit-license.html";

    public static final String aboutWebler = "Köszönet, a Webler Oktatóstudió részére!";
    public static final String urlWebler = "https://webler.hu";
    public static final String urlWeblerUnderLine = "<html><u>https://webler.hu</u></html>";
    public static final String card = "Névjegy";
    public static final String information = "Információ";
    public static final String spacer = "***";
    public static final String IOError = "Általános bemeneti/kimeneti hiba lépett fel!";
    public static final String urlSyntaxError = "A weboldal címzése nem megfelelő!";
}
