import java.util.*;
public class Verwaltung {
    DatabaseConnector connector;
    Random r = new Random();

    public Verwaltung(){
        connector = new DatabaseConnector("", 0, "Datenbank.db", "", "");
    }

    public void aktuelleFehlermeldung(){
        System.out.println(connector.getErrorMessage());
    }

    public void sqlBefehlAusfuehren(String sqlBefehl){
        connector.executeStatement(sqlBefehl);
        // für die Darstellung des Ergebnisses in einer Tabbellenform
        for (int i=0; i<connector.getCurrentQueryResult().getRowCount(); i=i+1) {          

            for (int j=0; j<connector.getCurrentQueryResult().getColumnCount(); j=j+1) {
                System.out.print(connector.getCurrentQueryResult().getData()[i][j]+" ");

            }
            System.out.println();
        }
    }

    public void alleSchuelerinnenAusgeben(){       
        String auftrag="select * from Schueler where Geschlecht='w'";
        sqlBefehlAusfuehren(auftrag);
    }

    public void alleSchuelerAusgeben(){     
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
        connector.executeStatement(auftrag);
        aktuelleFehlermeldung();
    }

    public void schuelerEinfuegen(String pV, String pN, String pGD, String pG, String pW, int pLZ, String pS,int pH, String pK )     //Alle Parameter übergeben
    {
        String auftrag="INSERT INTO 'Schueler' ('SID', 'Vorname', 'Name', 'Geburtsdatum', 'Geschlecht','Wohnort','PLZ','Strasse','Hausnummer','Bezeichnung') VALUES (NULL, '"+pV+"', '"+pN+"', '"+pGD+"','"+pG+"','"+pW+"', "+pLZ+",'"+pS+"',"+pH+",'"+pK+"')";
        connector.executeStatement(auftrag);
        aktuelleFehlermeldung();
    }
    
    public void sekteEinfuegen(String pN, String pG, String pAD, String pGS, int pEJ, String pZS,int pMA )     //Alle Parameter übergeben
    {
        String auftrag="INSERT INTO 'Sekte' ('SEID', 'Name', 'Gründer', 'Apokalypsedatum', 'Glaubenssatz','Entstehungsjahr','Zusatzinformation','MitgliederanzahlDE') VALUES (NULL, '"+pN+"', '"+pG+"', '"+pAD+"','"+pGS+"','"+pEJ+"','"+pZS+"', "+pMA+",)";
        connector.executeStatement(auftrag);
        aktuelleFehlermeldung();
    }
    
    public void lehrerEinfuegen(){

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
}

