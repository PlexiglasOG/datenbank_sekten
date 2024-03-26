import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.border.*;
public class GUIVorlage extends JFrame {
    // Anfang Attribute
    private Verwaltung verwaltung;
    private int m=1;

    // Buttons
    // Operator-Buttons Einfügen
    private JButton einfuegenButtonM = new JButton(); // Einfüge-Button Mitglied
    private JButton einfuegenButtonS = new JButton(); // Einfüge-Button Sekte
    private JButton einfuegenButtonSH = new JButton(); // Einfüge-Button Sektenhaus
    private JButton einfuegenButtonP = new JButton(); // Einfüge-Button Prediger

    private JButton maskeLeerenButton = new JButton(); // Maske-Leeren
    private JButton queryAbschickenButton = new JButton(); // Query abschicken 

    // Menü-Buttons
    private JButton mitgliederMenueButton = new JButton();    //Mitglieder Menü-Button
    private JButton sektenMenueButton = new JButton();    //Sekten Menü-Button
    private JButton predigerMenueButton = new JButton();    //Prediger Menü-Button
    private JButton sektenhausMenueButton = new JButton();    //Sektenhaus Menü-Button
    private JButton sqlBefehlMenueButton = new JButton(); //SQL-Befehl Menü-Button  
    private JButton sekteBuchenMenueButton = new JButton(); //"SekteBuchen" Menü-Button   

    // Einfüge-Menü-Buttons
    private JButton mitgliederEinfuegeMenueButton = new JButton();    //Mitglieder Einfüge-Menü-Button
    private JButton sektenEinfuegeMenueButton = new JButton();    //Sekten Einfüge-Menü-Button
    private JButton predigerEinfuegeMenueButton = new JButton();    //Prediger Einfüge-Menü-Button
    private JButton sektenhausEinfuegeMenueButton = new JButton();    //Sektenhaus Einfüge-Button

    // Suche-Menü-Buttons 
    private JButton mitgliederSucheMenueButton = new JButton();    //Mitglieder Suche-Menü-Button
    private JButton sektenSucheMenueButton = new JButton();    //Sekten Suche-Menü-Button
    private JButton predigerSucheMenueButton = new JButton();    //Prediger Suche-Menü-Button
    private JButton sektenhausSucheMenueButton = new JButton();    //Sektenhaus Suche-Button

    // Bearbeiten-Menü-Buttons
    private JButton mitgliederBearbeitenMenueButton = new JButton();    //Mitglieder Bearbeiten-Menü-Button
    private JButton sektenBearbeitenMenueButton = new JButton();    //Sekten Bearbeiten-Menü-Button
    private JButton predigerBearbeitenMenueButton = new JButton();    //Prediger Bearbeiten-Menü-Button
    private JButton sektenhausBearbeitenMenueButton = new JButton();    //Sektenhaus Bearbeiten-Button

    // Loeschen-Menü-Buttons
    private JButton mitgliederLoeschenMenueButton = new JButton();    //Mitglieder Loeschen-Menü-Button
    private JButton sektenLoeschenMenueButton = new JButton();    //Sekten Loeschen-Menü-Button
    private JButton predigerLoeschenMenueButton = new JButton();    //Prediger Loeschen-Menü-Button
    private JButton sektenhausLoeschenMenueButton = new JButton();    //Sektenhaus Loeschen-Button

    // Labels
    private JLabel[] labels = {new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel()};
    // Textfelder
    private JTextField[] textfields = {new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField()};

    Container cp = getContentPane();

    public GUIVorlage(){
        super("Sekten-Verwaltung");
        frameInitialisieren();
        verwaltung = new Verwaltung();
        setEinstellungenMenueButtons();
        setEinstellungenEinfuegenButtons();
        setEinstellungenLoeschenButtons();
        setEinstellungenBearbeitenButtons();
        setEinstellungenSuchenButtons();
        setEinstellungenOperatorButtons();
        setEinstellungenEinfuegeOperatorButtons();

        // Anfang Komponenten
        JTextArea textfeld = new JTextArea(450, 30);
        textfeld.setText("Lorem ipsum dolor sit amet");
        //Zeilenumbruch wird eingeschaltet
        textfeld.setLineWrap(true);
        //Zeilenumbrüche erfolgen nur nach ganzen Wörtern
        textfeld.setWrapStyleWord(true);

        //Ein JScrollPane, der das Textfeld beinhaltet, wird erzeugt
        JScrollPane scrollpane = new JScrollPane(textfeld); 
        cp.add(scrollpane);
        cp.add(textfeld);
        textfeld.paste();

        setEinstellungenTextfelderUndLabels();
        
        setBackgroundcolorMenueButtonsGray();
        setBackgroundcolorUnterMenuesGray();

        setResizable(false);
        setVisible(true);
    }

    public void mitgliederMenue_ActionPerformed(ActionEvent evt) {
        menuePerformed(mitgliederMenueButton, mitgliederEinfuegeMenueButton, mitgliederSucheMenueButton, mitgliederBearbeitenMenueButton, mitgliederLoeschenMenueButton);
    }

    public void sektenMenue_ActionPerformed(ActionEvent evt) {
        menuePerformed(sektenMenueButton, sektenEinfuegeMenueButton, sektenSucheMenueButton, sektenBearbeitenMenueButton, sektenLoeschenMenueButton);
    }

    public void predigerMenue_ActionPerformed(ActionEvent evt) {
        menuePerformed(predigerMenueButton, predigerEinfuegeMenueButton, predigerSucheMenueButton, predigerBearbeitenMenueButton, predigerLoeschenMenueButton);
    }

    public void sektenhausMenue_ActionPerformed(ActionEvent evt) {
        menuePerformed(sektenhausMenueButton, sektenhausEinfuegeMenueButton, sektenhausSucheMenueButton, sektenhausBearbeitenMenueButton, sektenhausLoeschenMenueButton);
    }

    public void sekteBuchenMenue_ActionPerformed(ActionEvent evt) {
        removeAllUnterMenues();
        removeAllEinfuegeButtons();
        removeAllLabelsAndTextfields();
        removeAllLabelsAndTextfields();
        setBackgroundcolorMenueButtonsGray();
        sekteBuchenMenueButton.setBackground(Color.GREEN);

        setResizable(false);
        setVisible(true);
    }

    public void sqlBefehlMenue_ActionPerformed(ActionEvent evt) {
        removeAllUnterMenues();
        removeAllEinfuegeButtons();
        removeAllLabelsAndTextfields();
        cp.add(queryAbschickenButton);
        removeAllLabelsAndTextfields();
        addLabel(0, "SQL-Befehl:");
        addTextfields(1);
        setBackgroundcolorMenueButtonsGray();
        sqlBefehlMenueButton.setBackground(Color.GREEN);

        setResizable(false);
        setVisible(true);
    }
    
    // Einfügen-Menü-ActionPerformed
    public void mitgliederEinfuegeMenueButton_ActionPerformed(ActionEvent evt){
        String[] array = {"Name:", "Vorname:", "Geburtsdatum:", "Bekehrungsdatum:", "Sterbedatum:", "Sektenhaus-ID:"};
        einfuegeMenueButtonPerformed(array, mitgliederEinfuegeMenueButton, einfuegenButtonM);
    }

    public void sektenEinfuegeMenueButton_ActionPerformed(ActionEvent evt){
        String[] array = {"Name:", "Gründer:", "Apokalipsedatum:", "Glaubenssatz:", "Entstehungsjahr:", "Zusatzinformationen:", "Mitgliederzahl:"};
        einfuegeMenueButtonPerformed(array, sektenEinfuegeMenueButton, einfuegenButtonS);
    }

    public void predigerEinfuegeMenueButton_ActionPerformed(ActionEvent evt){
        String[] array = {"Mitglieder-ID:"};
        einfuegeMenueButtonPerformed(array, predigerEinfuegeMenueButton, einfuegenButtonP);
    }

    public void sektenhausEinfuegeMenueButton_ActionPerformed(ActionEvent evt){
        String[] array = {"Name:", "Adresse:", "Sektenhaus-PredigerID:"};
        einfuegeMenueButtonPerformed(array, sektenhausEinfuegeMenueButton, einfuegenButtonSH);
    }
    
    // Suchen-Menü-ActionPerformed
    public void mitgliederSuchenMenueButton_ActionPerformed(ActionEvent evt){
        suchenMenueButtonPerformed(mitgliederSucheMenueButton);
    }

    public void sektenSuchenMenueButton_ActionPerformed(ActionEvent evt){
        suchenMenueButtonPerformed(sektenSucheMenueButton);
    }

    public void predigerSuchenMenueButton_ActionPerformed(ActionEvent evt){
        suchenMenueButtonPerformed(predigerSucheMenueButton);
    }

    public void sektenhausSuchenMenueButton_ActionPerformed(ActionEvent evt){
        suchenMenueButtonPerformed(sektenhausSucheMenueButton);
    }
    
    // Bearbeiten-Menü-ActionPerformed
    public void mitgliederBearbeitenMenueButton_ActionPerformed(ActionEvent evt){
        bearbeitenMenueButtonPerformed(mitgliederBearbeitenMenueButton);
    }

    public void sektenBearbeitenMenueButton_ActionPerformed(ActionEvent evt){
        bearbeitenMenueButtonPerformed(sektenBearbeitenMenueButton);
    }

    public void predigerBearbeitenMenueButton_ActionPerformed(ActionEvent evt){
        bearbeitenMenueButtonPerformed(predigerBearbeitenMenueButton);
    }

    public void sektenhausBearbeitenMenueButton_ActionPerformed(ActionEvent evt){
        bearbeitenMenueButtonPerformed(sektenhausBearbeitenMenueButton);
    }
    
    // Loeschen-Menü-ActionPerformed
    public void mitgliederLoeschenMenueButton_ActionPerformed(ActionEvent evt){
        loeschenMenueButtonPerformed(mitgliederLoeschenMenueButton);
    }

    public void sektenLoeschenMenueButton_ActionPerformed(ActionEvent evt){
        loeschenMenueButtonPerformed(sektenLoeschenMenueButton);
    }

    public void predigerLoeschenMenueButton_ActionPerformed(ActionEvent evt){
        loeschenMenueButtonPerformed(predigerLoeschenMenueButton);
    }

    public void sektenhausLoeschenMenueButton_ActionPerformed(ActionEvent evt){
        loeschenMenueButtonPerformed(sektenhausLoeschenMenueButton);
    }
    
    // Einfüge-Operator-Button-ActionPerformed
    public void einfuegeButtonM_ActionPerformed(ActionEvent evt) {
        int sektenhausID = Integer.parseInt(textfields[5].getText());
        String name = textfields[0].getText();
        String vorname = textfields[1].getText();
        String gebDat = textfields[2].getText();
        String bekDat = textfields[3].getText();
        String sterbDat = textfields[4].getText();
        int sektenID = Integer.parseInt(textfields[6].getText());
        verwaltung.mitgliedEinfuegen(sektenhausID, name, vorname, gebDat, bekDat, sterbDat);
    }

    public void einfuegeButtonS_ActionPerformed(ActionEvent evt) {
        String name = textfields[0].getText();
        String gruender = textfields[1].getText();
        String apoDat =  textfields[2].getText();
        String glaubenssatz =  textfields[3].getText();
        int entJahr =  Integer.parseInt(textfields[4].getText());
        String zusatzInfo =  textfields[5].getText();
        int mitgliederZahl =  Integer.parseInt(textfields[6].getText());
        verwaltung.sekteEinfuegen(name, gruender, apoDat, glaubenssatz, entJahr, zusatzInfo, mitgliederZahl);
    }

    public void queryAbschickenButton_ActionPerformed(ActionEvent evt) {
        String query = textfields[0].getText();
        verwaltung.sqlBefehlAusfuehren(query);
    }

    public void einfuegeButtonSH_ActionPerformed(ActionEvent evt) {
        String adresse = textfields[1].getText();
        String name = textfields[0].getText();
        int predigerID =  Integer.parseInt(textfields[2].getText());
        verwaltung.sektenhausEinfuegen(adresse, name, predigerID);
    }

    public void einfuegeButtonP_ActionPerformed(ActionEvent evt) {
        int mitgliederID = Integer.parseInt(textfields[0].getText());
        verwaltung.predigerEinfuegen(mitgliederID);
    }

    public void maskeLeerenButton_ActionPerformed(ActionEvent evt) {
        maskeLeeren();
    }

    // Hilfsmethoden
    public void einfuegeMenueButtonPerformed(String[] pArray, JButton pButton, JButton pEinfuegeButton){
        removeAllLabelsAndTextfields();
        setBackgroundcolorUnterMenuesGray();
        pButton.setBackground(Color.GREEN);
        removeAllEinfuegeButtons();
        cp.add(pEinfuegeButton);
        for(int i=0; i<pArray.length; i++){
            addLabel(i, pArray[i]);
        }
        addTextfields(pArray.length);
        setResizable(false);
        setVisible(true);
    }
    
    public void loeschenMenueButtonPerformed(JButton pButton){
        removeAllLabelsAndTextfields();
        setBackgroundcolorUnterMenuesGray();
        pButton.setBackground(Color.GREEN);
        removeAllEinfuegeButtons();
        setResizable(false);
        setVisible(true);
    }
    
    public void suchenMenueButtonPerformed(JButton pButton){
        removeAllLabelsAndTextfields();
        setBackgroundcolorUnterMenuesGray();
        pButton.setBackground(Color.GREEN);
        removeAllEinfuegeButtons();
        setResizable(false);
        setVisible(true);
    }
    
    public void bearbeitenMenueButtonPerformed(JButton pButton){
        removeAllLabelsAndTextfields();
        setBackgroundcolorUnterMenuesGray();
        pButton.setBackground(Color.GREEN);
        removeAllEinfuegeButtons();
        setResizable(false);
        setVisible(true);
    }
    
    public void menuePerformed(JButton pButton, JButton pEinfuegeButton, JButton pSucheButton, JButton pBearbeitenButton, JButton pLoeschenButton){
        removeAllUnterMenues();
        removeAllLabelsAndTextfields();
        cp.add(pEinfuegeButton);
        cp.add(pSucheButton);
        cp.add(pBearbeitenButton);
        cp.add(pLoeschenButton);
        setBackgroundcolorMenueButtonsGray();
        pButton.setBackground(Color.GREEN);
        setResizable(false);
        setVisible(true);
    }

    public void removeAllLabelsAndTextfields(){
        for(int i=0; i<labels.length; i++){
            cp.remove(labels[i]);
        }
        for(int i=0; i<textfields.length; i++){
            cp.remove(textfields[i]);
        }
    }

    public void removeAllEinfuegeButtons(){
        cp.remove(einfuegenButtonP);
        cp.remove(einfuegenButtonM);
        cp.remove(einfuegenButtonSH);
        cp.remove(einfuegenButtonS);
        cp.remove(queryAbschickenButton);
    }

    public void removeAllEinfuegeMenues(){
        cp.remove(mitgliederEinfuegeMenueButton);
        cp.remove(sektenEinfuegeMenueButton);
        cp.remove(predigerEinfuegeMenueButton);
        cp.remove(sektenhausEinfuegeMenueButton);
    }

    public void removeAllSucheMenues(){
        cp.remove(mitgliederSucheMenueButton);
        cp.remove(sektenSucheMenueButton);
        cp.remove(predigerSucheMenueButton);
        cp.remove(sektenhausSucheMenueButton);
    }

    public void removeAllBearbeitenMenues(){
        cp.remove(mitgliederBearbeitenMenueButton);
        cp.remove(sektenBearbeitenMenueButton);
        cp.remove(predigerBearbeitenMenueButton);
        cp.remove(sektenhausBearbeitenMenueButton);
    }
    
    public void removeAllLoeschenMenues(){
        cp.remove(mitgliederLoeschenMenueButton);
        cp.remove(sektenLoeschenMenueButton);
        cp.remove(predigerLoeschenMenueButton);
        cp.remove(sektenhausLoeschenMenueButton);
    }

    public void removeAllUnterMenues(){
        removeAllSucheMenues();
        removeAllEinfuegeMenues();
        removeAllBearbeitenMenues();
        removeAllLoeschenMenues();
    }

    public void setBackgroundcolorMenueButtonsGray(){
        mitgliederMenueButton.setBackground(Color.GRAY);
        sektenMenueButton.setBackground(Color.GRAY);
        sektenhausMenueButton.setBackground(Color.GRAY);
        predigerMenueButton.setBackground(Color.GRAY);
        sqlBefehlMenueButton.setBackground(Color.GRAY);
        sekteBuchenMenueButton.setBackground(Color.GRAY);
    }

    public void setBackgroundcolorUnterMenuesGray(){
        setBackgroundcolorEinfuegeButtonsGray();
        setBackroundcolorSucheButtonsGray();
        setBackroundcolorBearbeitenButtonsGray();
        setBackroundcolorLoeschenButtonsGray();
    }

    public void setBackgroundcolorEinfuegeButtonsGray(){
        mitgliederEinfuegeMenueButton.setBackground(Color.GRAY);
        sektenEinfuegeMenueButton.setBackground(Color.GRAY);
        sektenhausEinfuegeMenueButton.setBackground(Color.GRAY);
        predigerEinfuegeMenueButton.setBackground(Color.GRAY);
    }

    public void setBackroundcolorSucheButtonsGray(){
        mitgliederSucheMenueButton.setBackground(Color.GRAY);
        sektenSucheMenueButton.setBackground(Color.GRAY);
        sektenhausSucheMenueButton.setBackground(Color.GRAY);
        predigerSucheMenueButton.setBackground(Color.GRAY);
    }

    public void setBackroundcolorBearbeitenButtonsGray(){
        mitgliederBearbeitenMenueButton.setBackground(Color.GRAY);
        sektenBearbeitenMenueButton.setBackground(Color.GRAY);
        sektenhausBearbeitenMenueButton.setBackground(Color.GRAY);
        predigerBearbeitenMenueButton.setBackground(Color.GRAY);
    }

    public void setBackroundcolorLoeschenButtonsGray(){
        mitgliederLoeschenMenueButton.setBackground(Color.GRAY);
        sektenLoeschenMenueButton.setBackground(Color.GRAY);
        sektenhausLoeschenMenueButton.setBackground(Color.GRAY);
        predigerLoeschenMenueButton.setBackground(Color.GRAY);
    }

    public void addTextfields(int pAnzahl){
        for(int i=0;i<pAnzahl;i++){
            cp.add(textfields[i]);
        }
    }

    public void addLabel(int pLabel, String pText){
        labels[pLabel].setText(pText);
        cp.add(labels[pLabel]);
    }

    public void setButton(String pName, JButton pButton, int pKoordinate1, int pKoordinate2, int pKoordinate3, int pKoordinate4, boolean pHinzufuegen){
        pButton.setBounds(pKoordinate1, pKoordinate2, pKoordinate3, pKoordinate4);
        pButton.setText(pName);
        pButton.setMargin(new Insets(2, 2, 2, 2));
        pButton.setFont(new Font("Dialog", Font.PLAIN, 13));
        if(pHinzufuegen){
            cp.add(pButton);
        }
    }

    public void maskeLeeren() {
        for(int i=0;i<textfields.length;i++){
            textfields[i].setText("");
        }
    }

    // Einstellungen Buttons setzen

    public void setEinstellungenMenueButtons(){
        // Menü-Buttons 
        setButton("Mitglieder", mitgliederMenueButton, 0, 0, 100, 30, true);
        mitgliederMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    mitgliederMenue_ActionPerformed(evt);
                }
            });
        setButton("Sekten", sektenMenueButton, 100, 0, 100, 30, true);
        sektenMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenMenue_ActionPerformed(evt);
                }
            });
        setButton("Prediger", predigerMenueButton, 200, 0, 100, 30, true);
        predigerMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    predigerMenue_ActionPerformed(evt);
                }
            });
        setButton("Sektenhäuser", sektenhausMenueButton, 300, 0, 100, 30, true);
        sektenhausMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenhausMenue_ActionPerformed(evt);
                }
            });
        setButton("SekteBuchen", sekteBuchenMenueButton, 400, 0, 100, 30, true);
        sekteBuchenMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sekteBuchenMenue_ActionPerformed(evt);
                }
            });
        setButton("SQL-Befehl", sqlBefehlMenueButton, 500, 0, 100, 30, true);
        sqlBefehlMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sqlBefehlMenue_ActionPerformed(evt);
                }
            });
    }

    public void setEinstellungenEinfuegenButtons(){
        // Einfüge-Menü-Buttons
        setButton("Mitglied einfügen", mitgliederEinfuegeMenueButton, 0, 30, 150, 30, false);
        mitgliederEinfuegeMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    mitgliederEinfuegeMenueButton_ActionPerformed(evt);
                }
            });
        setButton("Sekte einfügen", sektenEinfuegeMenueButton, 0, 30, 150, 30, false);
        sektenEinfuegeMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenEinfuegeMenueButton_ActionPerformed(evt);
                }
            });
        setButton("Prediger einfügen", predigerEinfuegeMenueButton, 0, 30, 150, 30, false);
        predigerEinfuegeMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    predigerEinfuegeMenueButton_ActionPerformed(evt);
                }
            });
        setButton("Sektenhaus einfügen", sektenhausEinfuegeMenueButton, 0, 30, 150, 30, false);
        sektenhausEinfuegeMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenhausEinfuegeMenueButton_ActionPerformed(evt);
                }
            });

    }

    public void setEinstellungenSuchenButtons(){
        // Suche-Menü-Buttons
        setButton("Mitglied suchen", mitgliederSucheMenueButton, 150, 30, 150, 30, false);
        mitgliederSucheMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    mitgliederSuchenMenueButton_ActionPerformed(evt);
                }
            });
        setButton("Sekte suchen", sektenSucheMenueButton, 150, 30, 150, 30, false);
        sektenSucheMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenSuchenMenueButton_ActionPerformed(evt);
                }
            });
        setButton("Prediger suchen", predigerSucheMenueButton, 150, 30, 150, 30, false);
        predigerSucheMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    predigerSuchenMenueButton_ActionPerformed(evt);
                }
            });
        setButton("Sektenhaus suchen", sektenhausSucheMenueButton, 150, 30, 150, 30, false);
        sektenhausSucheMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenhausSuchenMenueButton_ActionPerformed(evt);
                }
            });

    }

    public void setEinstellungenBearbeitenButtons(){
        // Bearbeiten-Menü-Buttons
        setButton("Mitglied Bearbeiten", mitgliederBearbeitenMenueButton, 300, 30, 150, 30, false);
        mitgliederBearbeitenMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    mitgliederBearbeitenMenueButton_ActionPerformed(evt);
                }
            });
        setButton("Sekte Bearbeiten", sektenBearbeitenMenueButton, 300, 30, 150, 30, false);
        sektenBearbeitenMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenBearbeitenMenueButton_ActionPerformed(evt);
                }
            });
        setButton("Sektenhaus Bearbeiten", sektenhausBearbeitenMenueButton, 300, 30, 150, 30, false);
        sektenhausBearbeitenMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenhausBearbeitenMenueButton_ActionPerformed(evt);
                }
            }); 
        setButton("Prediger Bearbeiten", predigerBearbeitenMenueButton, 300, 30, 150, 30, false);
        predigerBearbeitenMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    predigerBearbeitenMenueButton_ActionPerformed(evt);
                }
            });
    }

    public void setEinstellungenLoeschenButtons(){
        // Löschen-Menü-Buttons
        setButton("Mitglied Löschen", mitgliederLoeschenMenueButton, 450, 30, 150, 30, false);
        mitgliederLoeschenMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    mitgliederLoeschenMenueButton_ActionPerformed(evt);
                }
            });
        setButton("Sekte Löschen", sektenLoeschenMenueButton, 450, 30, 150, 30, false);
        sektenLoeschenMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenLoeschenMenueButton_ActionPerformed(evt);
                }
            });
        setButton("Sektenhaus Löschen", sektenhausLoeschenMenueButton, 450, 30, 150, 30, false);
        sektenhausLoeschenMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenhausLoeschenMenueButton_ActionPerformed(evt);
                }
            }); 
        setButton("Prediger Löschen", predigerLoeschenMenueButton, 450, 30, 150, 30, false);
        predigerLoeschenMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    predigerLoeschenMenueButton_ActionPerformed(evt);
                }
            });
    }

    public void setEinstellungenOperatorButtons(){
        // Operator-Buttons
        setButton("Maske leeren", maskeLeerenButton, 450, 400, 100, 30, true);
        maskeLeerenButton.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    maskeLeerenButton_ActionPerformed(evt);
                }
            });
        setButton("Query Abschicken", queryAbschickenButton, 450, 340, 100, 30, false);
        queryAbschickenButton.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    queryAbschickenButton_ActionPerformed(evt);
                }
            });
    }

    public void setEinstellungenEinfuegeOperatorButtons(){
        // Einfüge-Button Mitglied
        setButton("Einfügen", einfuegenButtonM, 450, 340, 100, 30, false);
        einfuegenButtonM.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    einfuegeButtonM_ActionPerformed(evt);
                }
            });
        // Einfüge-Button Sekte
        setButton("Einfügen", einfuegenButtonS, 450, 340, 100, 30, false);
        einfuegenButtonS.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    einfuegeButtonS_ActionPerformed(evt);
                }
            });
        // Einfüge-Button Sektenhaus
        setButton("Einfügen", einfuegenButtonSH, 450, 340, 100, 30, false);
        einfuegenButtonSH.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    einfuegeButtonSH_ActionPerformed(evt);
                }
            });
        // Einfüge-Button Prediger
        setButton("Einfügen", einfuegenButtonP, 450, 340, 100, 30, false);
        einfuegenButtonP.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    einfuegeButtonP_ActionPerformed(evt);
                }
            });
    }

    public void frameInitialisieren(){
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 600; 
        int frameHeight = 500;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        cp.setLayout(null);
    }

    public void setEinstellungenTextfelderUndLabels(){
        // Einstellungen Textfelder setzen 
        for(int i=0; i<textfields.length; i++){
            int hight = 100+(i*40);
            textfields[i].setBounds(150, hight, 230, 30);
            textfields[i].setText("");
            textfields[i].setFont(new Font("Arial", Font.PLAIN, 17));
        }
        // Einstellungen Label setzen
        for(int i=0; i<labels.length; i++){
            int hight = 100+(i*40);
            labels[i].setBounds(10, hight, 150, 30);
            labels[i].setText("");
            labels[i].setFont(new Font("Arial", Font.PLAIN, 17));
        }
    }
}