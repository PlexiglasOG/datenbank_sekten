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

    public void MitgliedSekteZuordnen(int pMIID, int pSEID){

    }

    // Suche-Methoden
    public void mitgliedSuchen(String pMIID, String pSEHAID, String pVorname, String pName, String pGeburtsdatum, String pBekehrungsdatum, String pSterbedatum, String pOrderBy, String pLimit){
        String[] array = {pMIID, pSEHAID, pVorname, pName, pGeburtsdatum, pBekehrungsdatum, pSterbedatum};
        String[] atribute = {"MIID", "SEHAID", "Vorname", "Name", "Geburtsdatum", "Bekehrungsdatum", "Sterbedatum"};
        suchen("Mitglied", array, atribute, pOrderBy, pLimit);
    }
    
    public void predigerSuchen(String pPEID, String pMIID, String pSEHAID, String pVorname, String pName, String pGeburtsdatum, String pBekehrungsdatum, String pSterbedatum, String pOrderBy, String pLimit){
        String[] array = {pPEID, pMIID, pSEHAID, pVorname, pName, pGeburtsdatum, pBekehrungsdatum, pSterbedatum};
        String[] atribute = {"PEID", "MIID", "SEHAID", "Vorname", "Name", "Geburtsdatum", "Bekehrungsdatum", "Sterbedatum"};
        suchen("Mitglied, Prediger", array, atribute, pOrderBy, pLimit);
    }
    
    public void sekteSuchen(String pSEID, String pName, String pGründer, String pApokalypsedatum, String pGlaubenssatz, String pEntstehungsjahr, String pZusatzinformationen, String pMitgliederanzahlDE, String pOrderBy, String pLimit){
        String[] array = {pSEID, pName, pGründer, pApokalypsedatum, pGlaubenssatz, pEntstehungsjahr, pZusatzinformationen, pMitgliederanzahlDE};
        String[] atribute = {"SEID", "Name", "Gründer", "Apokalypsedatum", "Glaubenssatz", "Entstehungsjahr", "Zusatzinformationen", "MitgliederanzahlDE"};
        suchen("Sekte", array, atribute, pOrderBy, pLimit);
    }
    
    public void sektenhausSuchen(String pAdresse, String pName, String pPEID, String pOrderBy, String pLimit){
        String[] array = {pAdresse, pName, pPEID};
        String[] atribute = {"Adresse", "Name", "PEID"};
        suchen("Sektenhaus", array, atribute, pOrderBy, pLimit);    
    }
    
    public void istTEilVonSuchen(String pSEID, String pMIID,String pOrderBy, String pLimit){
        //String[] array = {pSEID, pMIID};
        //String[] atribute = {SEID, MIID};
        //suchen("istTeilVon", array, atribute, pOrderBy, pLimit);    
    }
    
    // Hilfsmethoden 
    public void suchen(String pTabelle, String[] pArray, String[] pAtribute, String pOrderBy, String pLimit){
        String queryBedinungen = "";
        String auszugebeneAtribute = "";
        String orderBy = "";
        String selectAll = "";
        if(!pOrderBy.equals(" ")){
            orderBy = " order by " + pOrderBy;
        }
        String limit = "";
         if(!pLimit.equals(" ")){
            limit = " limit " + pLimit;
        }
        for(int i=0; i<pArray.length; i++){
            if(!pArray[i].equals(" ")){
                if(!queryBedinungen.equals("")){
                    queryBedinungen = queryBedinungen + " And ";
                }
                queryBedinungen = queryBedinungen + pAtribute[i] + " = " + "\""  + pArray[i] + "\"" ;
            } else{
                if(!auszugebeneAtribute.equals("")){
                    auszugebeneAtribute = auszugebeneAtribute + ", ";
                }
                auszugebeneAtribute = auszugebeneAtribute + pAtribute[i];
            }
        }
        if(!queryBedinungen.equals("")){
           selectAll = "*";
        }
        String auftrag= "Select " + selectAll + auszugebeneAtribute + " from " + pTabelle + " where " + queryBedinungen + orderBy + limit;
        sqlBefehlAusfuehren(auftrag);
        aktuelleFehlermeldung();
    }
}