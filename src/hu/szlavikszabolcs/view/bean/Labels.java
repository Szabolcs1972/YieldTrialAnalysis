package hu.szlavikszabolcs.view.bean;

public class Labels {
    //labels for Login
    public static final String enter = "Enter to the app";
    public static final String userName = "Username:";
    public static final String passWord = "Password:";
    public static final String loginError = "Invalid username/password";
    public static final String failToPass = "Unsuccessfull enter! Good-bye!";
    public static final String emptyField = "You have empty field";
    public static final String noHTML = "Connection lost or the website doesn't exists!";
    public static final String noImageIcon = "Icon file doesn't exists!";

    //labels for JFileChooser
    public static final String open = "Open";
    public static final String approveButtonToolTipText = "Open file";

    //labels for Menu
    public static final String menuPoint = "File";
    public static final String menuItem = "Load yield trial data";
    public static final String menuItem2 = "Exit";

    public static final String menuPoint2 = "Calculation";
    public static final String menuItem3 = "Yield calculation";

    public static final String menuPoint3 = "Database";
    public static final String menuItem4 = "Show database";

    public static final String menuPoint4 = "Settings";

    public static final String menuPoint5 = "Information";
    public static final String menuItem5 = "Summary statistics";
    public static final String menuItem6 = "Help";
    public static final String menuItem7 = "Name card";


    //labels for computed yield
    public static final String error = "Error!";
    public static final String noDataError = "Error! Data hasn't been loaded!";
    public static final String numberFormatnoError = "Error! You have entered wrong numbers!";
    public static final String numberValueError = "Error! Plot size is greater then 0, moisture should be between 0 and 100%";
    public static final String getPlotSize = "<html>Plot size (m<sup>2</sup>)</html>";
    public static final String getMoistureToSet = "Set moisture level to adjust the yields!";
    public static final String input = "Input";
    public static final String saveYieldsToDatabase = "Save to database";
    public static final String informationCalculateSummaryStatistics = "<html>Summary statistics has been activated<br>Yield calculation de-activated</html>";

    //labels for statistics
    public static final String saveToExcel = "Save results to Excel";
    public static final String fileWriteToExcelSuccess = "Statistics.xlsx has been saved!";

    //database management
    public static final String loginToDatabase = "Enter to the database";
    public static final String dataUploadSuccess = "Data upload successfull!";
    public static final String cancel = "Cancel";
    public static final String ok = "OK";

    //file management
    public static final String columnNumberError = "Number of the columns are not correct!";
    public static final String columnLabelError = "The heading names of the columns are not right!";
    public static final String standardValueError = "<html>Checks should be marked as 1 or 0 (Yes/No)!<br> Restart the app!</html>";
    public static final String nameValueError = "<html>The field of variety name cannot be empty<br> Restart the app!</html>";
    public static final String plotWeightValueError = "<html>Plot weight should be greater than 0!<br> Restart the app!</html>";
    public static final String moistureValueError = "<html>Moisture should be greater than 0!<br> Restart the app!</html>";

    public static final String fileDataLoadSuccess = "<html>Data loading success!<br>Calculations -> Yield calculation has been activated<br>File -> File loading de-activated</html>";
    public static final String fileDataLoadFailure = "<html>Data load error! Restart the app!</html>";

    //configuration

    public static final String warning = "Warning!";
    public static final String configFileNotFound = "I cannot find the configuration file! Good-bye!";
    public static final String writeIOException = "Write error!";
    public static final String saveConfig = "Save settings";
    public static final String configDialogTitle = "Settings";
    public static final String userEntrance = "<html><strong><u>User login</u></strong></html>";
    public static final String databaseDetails = "<html><strong><u>Identifiers for database</u></strong></html>";
    public static final String databaseLink = "Database url";
    public static final String databaseUser = "Database username";
    public static final String databasePassWord = "Database password";
    public static final String emptyConfigFields = "Except the database password, all field must be filled!";

    //about
    public static final String homeURL = "https://www.szlavikszabolcs.hu/YieldTrialAnalysis/UserManual.htm";
    public static final String aboutOKJ = "Software for programmer exam";
    public static final String aboutSzabolcs = "Dr. Szlávik Szabolcs";
    public static final String mail = "szabolcsszlavik@gmail.com";
    public static final String urlSzabolcs = "https://www.szlavikszabolcs.hu";
    public static final String urlSzabolcsUnderLine = "<html><u>https://www.szlavikszabolcs.hu</u></html>";
    public static final String aboutSzeged = "Szeged, 2021.";
    public static final String aboutCC0 = "Yield Trial Analysis, Licence: CC0 1.0";
    public static final String urlCC0 = "https://creativecommons.org/publicdomain/zero/1.0/legalcode";
    public static final String aboutPOI = "Apache POI 5.0.0, License: Apache 2.0";
    public static final String urlPOI = "http://www.apache.org/licenses/LICENSE-2.0.txt";

    public static final String aboutMySQLConnector = "MySQL Connector/J 8.0.26, License: GPL 2.0 with FOSS exception";
    public static final String urlFOSS = "https://oss.oracle.com/licenses/universal-foss-exception/";
    public static final String urlGPL = "https://www.gnu.org/licenses/old-licenses/gpl-2.0.html";

    public static final String aboutLaunch4j = "Launch4j 3.14, License: BSD-3-Clause, MIT License";
    public static final String urlBSD3 = "https://opensource.org/licenses/BSD-3-Clause/";
    public static final String urlMIT = "https://opensource.org/licenses/mit-license.html";

    public static final String aboutOracle = "<html><span style=color:red>ORACLE</span> Java</html>";
    public static final String urlJava = "http://java.com/licensereadme";

    public static final String aboutWebler = "Special thanks to Webler Oktatóstudió";
    public static final String urlWebler = "https://webler.hu";
    public static final String urlWeblerUnderLine = "<html><u>https://webler.hu</u></html>";
    public static final String card = "Name Card";
    public static final String information = "Information";
    public static final String spacer = "***";
    public static final String IOError = "I/O error!";
    public static final String urlSyntaxError = "URL malformation error";
}
