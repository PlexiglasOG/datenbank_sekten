
public class Verwaltung {

    DatabaseConnector meinConnector;

    public Verwaltung(){
        /**Ein Objekt der Klasse DatabaseConnector wird erstellt.
         *SQLite verlangt als einzige Angabe den Namen der Datei!
         *Die anderen Angaben sind irrelevant.
         */  
        meinConnector = new DatabaseConnector("", 0, "Schuldaten.db", "", "");
    }

    public void aktuelleFehlermeldung(){
        /**
         *Zur Sicherheit sollten wir sehr häufig die Fehlermeldungen der Datenbank prüfen.
         */
        System.out.println(meinConnector.getErrorMessage());
        /**
         *Das Ergebnis wird auf der Konsole angezeigt.
         */
    }

    public void sqlBefehlAusfuehren(String sqlBefehl){
        meinConnector.executeStatement(sqlBefehl);  //Die Methode executeStatement der Klasse DatabaseConnector wird ausgeführt. Der sql-Befehl wird als String übergeben.

        for (int i=0; i<meinConnector.getCurrentQueryResult().getRowCount(); i=i+1) {               //verschachtelte for-Schleifen, die das 'QueryResult' auslesen.

            for (int j=0; j<meinConnector.getCurrentQueryResult().getColumnCount(); j=j+1) {
                System.out.print(meinConnector.getCurrentQueryResult().getData()[i][j]+" ");

            }
            System.out.println();
        }
    }

    public void alleSchuelerinnenAusgeben(){        //Nur, um zu sehen, wie es geht...
        String auftrag="select * from Schueler where Geschlecht='w'";
        sqlBefehlAusfuehren(auftrag);
    }

    /**
     * Alle nicht implementierten Methoden müssen geschrieben werden!
     */

    public void alleSchuelerAusgeben(){         //diesmal männlich

    }

    public void alleSchuelerNichtAusHanauAusgeben(){

    }
    
    public void alleLehrerDieEnglischOderMatheUnterrichtenAusgeben(){
        
    }
    
     public void alleLKsAusgeben(){
        
    }
    
    public void klassenListeAusgeben(String pK){        //Als Parameter pK könnte zum Beispiel "9b" übergeben werden. Dann soll die Klassenliste dder 9b ausgegeben werden. 
        
    }
    
    public void schuelerEinfuegenTest()      //Nur, um zu sehen, wie es geht...
    {
        String auftrag="INSERT INTO 'Schueler' ('SID', 'Vorname', 'Name', 'Geburtsdatum', 'Geschlecht','Wohnort','PLZ','Strasse','Hausnummer','Bezeichnung') VALUES (NULL, 'Felix', 'Finster', '2000-02-14','m','Bonn', 53177,'Siebenmorgenweg',34,'Q1')";
        meinConnector.executeStatement(auftrag);
        aktuelleFehlermeldung();
    }

    public void schuelerEinfuegen(String pV, String pN, String pGD, String pG, String pW, int pLZ, String pS,int pH, String pK )     //Alle Parameter übergeben
    {
        String auftrag="INSERT INTO 'Schueler' ('SID', 'Vorname', 'Name', 'Geburtsdatum', 'Geschlecht','Wohnort','PLZ','Strasse','Hausnummer','Bezeichnung') VALUES (NULL, '"+pV+"', '"+pN+"', '"+pGD+"','"+pG+"','"+pW+"', "+pLZ+",'"+pS+"',"+pH+",'"+pK+"')";
        meinConnector.executeStatement(auftrag);
        aktuelleFehlermeldung();
    }

    public void lehrerEinfuegen()   //Parameter übergeben
    {

    }

    public void kursAnlegen()   //Parameter übergeben
    {

    }

    public void kursZuweisen()  //Parameter übergeben (KID und SID)
    {

    }

    public void KurslisteAusgeben() //Parameter KID übergeben
    {

    }

    public void KursgroeßeAusgeben() //Parameter KID übergeben
    {

    }

    public void schuelerVor2000GeborenAusgeben(){        //schwer...

    }

    //und noch viele eigene Methoden schreiben ...
}

