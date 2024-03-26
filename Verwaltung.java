import java.util.*;
public class Verwaltung {
    DatabaseConnector connector ;
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
    
    // Ausgabe-Methoden:
    public void alleSektenAusgeben(){       
        String auftrag="select * from Sekte";
        sqlBefehlAusfuehren(auftrag);
    }

    public void alleMitgliederAusgeben(){       
        String auftrag="select * From Mitglied";
        sqlBefehlAusfuehren(auftrag);
    }
    
    public void allePredigerAusgeben(){       
        String auftrag="select * from Prediger";
        sqlBefehlAusfuehren(auftrag);
    }
    
    public int gibIDvonMitglied(String pName, String pVorname){
        String auftrag = "select MIID from Mitglied where Name = "+pName+" AND Vorname = "+pVorname;
        return 1;
    }
    // Einfüge-Methoden
    public void mitgliedEinfuegen(int pSEHAID, String pVorname, String pName, String pGeburtsdatum, String pBekehrungsdatum, String pSterbedatum){
        String auftrag="INSERT INTO 'Mitglied' ('MIID', 'SEHAID', 'Vorname', 'Name', 'Geburtsdatum','Bekehrungsdatum','Sterbedatum') VALUES (NULL, '"+pSEHAID+"', '"+pVorname+"', '"+pName+"', '"+pGeburtsdatum+"','"+pBekehrungsdatum+"','"+pSterbedatum+"')";
        connector.executeStatement(auftrag);
        aktuelleFehlermeldung();
    }

    public void sekteEinfuegen(String pN, String pG, String pAD, String pGS, int pEJ, String pZS,int pMA )     //Alle Parameter übergeben
    {
        String auftrag="INSERT INTO 'Sekte' ('SEID', 'Name', 'Gründer', 'Apokalypsedatum', 'Glaubenssatz','Entstehungsjahr','Zusatzinformationen','MitgliederanzahlDE') VALUES (NULL, '"+pN+"', '"+pG+"', '"+pAD+"','"+pGS+"','"+pEJ+"','"+pZS+"', '"+pMA+"')";
        connector.executeStatement(auftrag);
        aktuelleFehlermeldung();
    }
    
    public void predigerEinfuegen(int pMIID )     //Alle Parameter übergeben
    {
        String auftrag="INSERT INTO 'Prediger' ('PEID', 'MIID') VALUES (NULL, '"+pMIID+"')";
        connector.executeStatement(auftrag);
        aktuelleFehlermeldung();
    }
    
    public void sektenhausEinfuegen(String pAdresse, String pName, int pPEID )     //Alle Parameter übergeben
    {
        String auftrag="INSERT INTO 'Sektenhaus' ('SEHAID', 'Adresse','Name','PEID') VALUES (NULL,'"+pAdresse+"','"+pName+"','"+pPEID+"')";
        connector.executeStatement(auftrag);
        aktuelleFehlermeldung();
    }

    // Suche-Methoden
    
}