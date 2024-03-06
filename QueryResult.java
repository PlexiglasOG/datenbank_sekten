public class QueryResult{
    private String[][] data;
    private String[] columnNames;
    private String[] columnTypes;

    //Konstruktor
    QueryResult(String[][] pData, String[] pColumnNames, String[] pColumnTypes){
        data = pData;
        columnNames = pColumnNames;   
        columnTypes = pColumnTypes;
    }

    //Getter-Methoden:
    
    // Gibt die Daten der Zeilen
    public String[][] getData(){
        return data;
    }

    // Gibt die Namen der Spalten
    public String[] getColumnNames(){
        return columnNames;
    }
    
    // Gibt die Datentypen der Spalten    
    public String[] getColumnTypes(){
        return columnTypes;
    }

    // Gibt die Anzahl der Zeilen
    public int getRowCount(){
        if (data != null )
            return data.length;
        else 
            return 0;
    }

    // Gibt Anzahl der Spalten der Methoden 
    public int getColumnCount(){
        if (data != null && data.length > 0 && data[0] != null)
            return data[0].length;
        else
            return 0;
    }

}