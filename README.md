# NovenyfajtaKiserletElemzo
Data analisys of plant yield trials
Telepítési információk:

1. Rendszerkövetelmények
Minimális hardver: 
-	legalább 1 GHz sebességű processzor
-	2 GB RAM
-	20 GB lemezterület
-	kijelző: 800*600
-	Internet kapcsolat 100 Mbit sebesség
Ajánlott hardver konfiguráció:
-	több magos processzor
-	8 GB RAM
-	120 GB SSD lemezmeghajtó
-	HDMI kompatibilis kijelző
-	Internet kapcsolat 1Gbit sebesség

Szoftver követelmények:
•	Windows (32 vagy 64-bit) ajánlott: Windows 10 és Windows 11,
•	Linux (32 vagy 64-bit), Java futtató környezetet (JRE) Java 8, vagy annál újabb (8.-17.)
	Az operációs rendszer beállítása: Nyelv: magyar, Területi beállítások: magyar

2.	A Java futtató környezet telepítése

Windows operációs rendszer esetében nem kell a programot telepíteni.
A program könyvtára tartalmazza a Java futtató környezetet, így önálló működésre képes.

Más operációs rendszerek esetében ellenőrizzük, hogy a JRE kiadás Java 8 legyen (legalább 1.8.0.).
A JRE verzió ellenőrzéséhez adjuk ki a "java -version" parancsot Windows parancssorban, vagy Linux terminál ablakban.
Ha a gépünkön nincs JRE, vagy az Java 8-nál régebbi (pl. Java 7), akkor töltsük le az operációs rendszerünknek megfelelőt
az Internetről. A legjobb felhasználói élményt a Java 8 – 311. verzió biztosítja.

A telepítés előtt célszerű az összes futó alkalmazás bezárása.

Bővebb technikai információ angol nyelven: https://www.java.com/en/download/manual.jsp

Támogatott más operációs rendszerek:
MAC OS X
x64 DMG telepítő	83,64 MB	jre-8u311-macosx-x64.dmg


LINUX
x64 RPM csomag telepítő	59,14 MB	jre-8u311-linux-x64.rpm
x64 tömörített archív	89,34 MB	jre-8u311-linux-x64.tar.gz


3.	A program telepítése és indítása

i)	Windows operációs rendszer esetében:
1.	Az adathordozóról a számítógép merevlemezére másoljuk tetszőleges helyre a NövényfajtaKísérletElemző könyvtárat.
	Keressük meg a könyvtárban a „NövényfajtaKísérletElemző.exe” fájlt, amely ikonja egy kombájnt ábrázol.
2.	Az ikonra dupla kattintással elindul a program
3.	Sikertelen indítás, vagy hiba esetén parancssorból is elindítható a program.
	Ebben az esetben rendelkezzünk a gépen legalább Java 8 futtató környezettel.
	A könyvtárban adjuk ki a parancsot: "java -jar NövényFajtaKísérletElemző.jar"

ii)	Linux
1.	Az adathordozóról a számítógép merevlemezére másoljuk tetszőleges helyre a NövényfajtaKísérletElemző könyvtárat (pl: /home/).
2.	Linux terminál ablakban a könyvtárban adjuk ki a következő parancsot:
	"java -jar NövényFajtaKísérletElemző.jar"
3.	"Wine" programmal is elindíthatjuk a NövényfajtaKísérletElemző.exe fájlt

********************************************************************************************************

OKJ Vizsgafeladat
Dr. Szlávik Szabolcs

e-mail: szabolcsszlavik@gmail.com
https://www.szlavikszabolcs.hu

Szeged, 2021-11-04
