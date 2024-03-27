import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.border.*;
public class GUIVorlage extends JFrame {
    private Verwaltung verwaltung;
    private int m=1;

    // Buttons -> [0]=Mitglied, [1]=Sekte, [2]=Sektenhaus, [3]=Prediger, [4]=isTeilVon, [5]=Menü
    
    //Menü
    // Menü-Buttons
    private JButton[] menue = {new JButton(),  new JButton(),  new JButton(),  new JButton(), new JButton(), new JButton()};
    
    //Untermenü
    // Einfüge-Menü-Buttons
    private JButton[] einfuegeMenue = {new JButton(),  new JButton(),  new JButton(),  new JButton()};
    // Suche-Menü-Buttons 
    private JButton[] sucheMenue = {new JButton(),  new JButton(),  new JButton(),  new JButton()};
    // Bearbeiten-Menü-Buttons
    private JButton[] bearbeiteMenue = {new JButton(),  new JButton(),  new JButton(),  new JButton()};
    // Loeschen-Menü-Buttons
    private JButton[] loescheMenue = {new JButton(),  new JButton(),  new JButton(),  new JButton()};
    
    // Operator-Buttons 
    //Einfügen
    private JButton[] einfuegen = { new JButton(),  new JButton(),  new JButton(),  new JButton()};
    //Löschen
    private JButton[] loeschen = { new JButton(),  new JButton(),  new JButton(),  new JButton()};
    //Suchen
    private JButton[] suchen = { new JButton(),  new JButton(),  new JButton(),  new JButton()};
    //Bearbeiten
    private JButton[] bearbeiten = { new JButton(),  new JButton(),  new JButton(),  new JButton()};
    
    private JButton maskeLeerenButton = new JButton(); // Maske-Leeren
    private JButton queryAbschickenButton = new JButton(); // Query abschicken 
    
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
        
        setEinstellungenEinfuegen();
        setEinstellungenLoeschenButtons();
        setEinstellungenBearbeitenButtons();
        setEinstellungenSuchenButtons();
        setEinstellungenOperatorButtons();
        
        setEinstellungenEinfuegeOperatorButtons();
        setEinstellungenSuchenOperatorButtons();
        setEinstellungenLoeschenOperatorButtons();
        setEinstellungenBearbeitenOperatorButtons();

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
        menuePerformed(menue[0], einfuegeMenue[0], sucheMenue[0], bearbeiteMenue[0], loescheMenue[0]);
    }

    public void sektenMenue_ActionPerformed(ActionEvent evt) {
        menuePerformed(menue[1], einfuegeMenue[1], sucheMenue[1], bearbeiteMenue[1], loescheMenue[1]);
    }

    public void predigerMenue_ActionPerformed(ActionEvent evt) {
        menuePerformed(menue[3], einfuegeMenue[3], sucheMenue[3], bearbeiteMenue[3], loescheMenue[3]);
    }

    public void sektenhausMenue_ActionPerformed(ActionEvent evt) {
        menuePerformed(menue[2], einfuegeMenue[2], sucheMenue[2], bearbeiteMenue[2], loescheMenue[2]);
    }

    public void sekteBuchenMenue_ActionPerformed(ActionEvent evt) {
        removeAllUnterMenues();
        removeAllEinfuegeButtons();
        removeAllLabelsAndTextfields();
        removeAllLabelsAndTextfields();
        setBackgroundcolorMenueButtonsGray();
        menue[4].setBackground(Color.GREEN);

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
        menue[5].setBackground(Color.GREEN);

        setResizable(false);
        setVisible(true);
    }

    // Einfügen-Menü-ActionPerformed
    public void mitgliederEinfuegeMenue_ActionPerformed(ActionEvent evt){
        String[] array = {"Name:", "Vorname:", "Geburtsdatum:", "Bekehrungsdatum:", "Sterbedatum:", "Sektenhaus-ID:"};
        einfuegeMenueButtonPerformed(array, einfuegeMenue[0], einfuegen[0]);
    }

    public void sektenEinfuegeMenue_ActionPerformed(ActionEvent evt){
        String[] array = {"Name:", "Gründer:", "Apokalipsedatum:", "Glaubenssatz:", "Entstehungsjahr:", "Zusatzinformationen:", "Mitgliederzahl:"};
        einfuegeMenueButtonPerformed(array, einfuegeMenue[1], einfuegen[1]);
    }

    public void predigerEinfuegeMenue_ActionPerformed(ActionEvent evt){
        String[] array = {"Mitglieder-ID:"};
        einfuegeMenueButtonPerformed(array, einfuegeMenue[3], einfuegen[3]);
    }

    public void sektenhausEinfuegeMenue_ActionPerformed(ActionEvent evt){
        String[] array = {"Name:", "Adresse:", "Sektenhaus-PredigerID:"};
        einfuegeMenueButtonPerformed(array, einfuegeMenue[2], einfuegen[2]);
    }

    // Suchen-Menü-ActionPerformed
    public void mitgliederSuchenMenueButton_ActionPerformed(ActionEvent evt){
        String[] array = {"Mitglieder-ID: ", "Name:", "Vorname:", "Geburtsdatum:", "Bekehrungsdatum:", "Sterbedatum:", "Sektenhaus-ID:"};
        suchenMenueButtonPerformed(array, sucheMenue[0], suchen[0]);
    }

    public void sektenSuchenMenueButton_ActionPerformed(ActionEvent evt){
        String[] array = {"Sekten-ID: ", "Name:", "Gründer:", "Apokalipsedatum:", "Glaubenssatz:", "Entstehungsjahr:", "Zusatzinformationen:", "Mitgliederzahl:"};
        suchenMenueButtonPerformed(array, sucheMenue[1], suchen[1]);
    }

    public void predigerSuchenMenueButton_ActionPerformed(ActionEvent evt){
        String[] array = {"Mitglieder-ID: ", "Prediger-ID: "};
        suchenMenueButtonPerformed(array, sucheMenue[3], suchen[3]);
    }

    public void sektenhausSuchenMenueButton_ActionPerformed(ActionEvent evt){
        String[] array = {"Sektenhaus-ID: ", "Name:", "Adresse:", "Sektenhaus-PredigerID:"};
        suchenMenueButtonPerformed(array, sucheMenue[2], suchen[2]);
    }

    // Bearbeiten-Menü-ActionPerformed
    public void mitgliederBearbeitenMenue_ActionPerformed(ActionEvent evt){
        String[] array = {};
        bearbeitenMenueButtonPerformed(array, bearbeiteMenue[0], bearbeiten[0]);
    }

    public void sektenBearbeitenMenue_ActionPerformed(ActionEvent evt){
        String[] array = {};
        bearbeitenMenueButtonPerformed(array, bearbeiteMenue[1], bearbeiten[1]);
    }

    public void predigerBearbeitenMenue_ActionPerformed(ActionEvent evt){
       String[] array = {};
        bearbeitenMenueButtonPerformed(array, bearbeiteMenue[3], bearbeiten[3]);
    }

    public void sektenhausBearbeitenMenue_ActionPerformed(ActionEvent evt){
        String[] array = {};
        bearbeitenMenueButtonPerformed(array, bearbeiteMenue[2], bearbeiten[2]);
    }

    // Loeschen-Menü-ActionPerformed
    public void mitgliederLoeschenMenue_ActionPerformed(ActionEvent evt){
         String[] array = {};
        loeschenMenueButtonPerformed(array, loescheMenue[0], loeschen[0]);
    }

    public void sektenLoeschenMenue_ActionPerformed(ActionEvent evt){
         String[] array = {};
        loeschenMenueButtonPerformed(array, loescheMenue[1], loeschen[1]);
    }

    public void predigerLoeschenMenue_ActionPerformed(ActionEvent evt){
         String[] array = {};
        loeschenMenueButtonPerformed(array, loescheMenue[3], loeschen[3]);
    }

    public void sektenhausLoeschenMenue_ActionPerformed(ActionEvent evt){
         String[] array = {};
        loeschenMenueButtonPerformed(array, loescheMenue[2], loeschen[2]);
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
        removeAllOperatorButton();
        cp.add(pEinfuegeButton);
        for(int i=0; i<pArray.length; i++){
            addLabel(i, pArray[i]);
        }
        addTextfields(pArray.length);
        setResizable(false);
        setVisible(true);
    }

    public void loeschenMenueButtonPerformed(String[] pArray, JButton pButton, JButton pLoescheButton){
        removeAllLabelsAndTextfields();
        setBackgroundcolorUnterMenuesGray();
        pButton.setBackground(Color.GREEN);
        removeAllOperatorButton();
        cp.add(pLoescheButton);
        for(int i=0; i<pArray.length; i++){
            addLabel(i, pArray[i]);
        }
        addTextfields(pArray.length);
        setResizable(false);
        setVisible(true);
    }

    public void suchenMenueButtonPerformed(String[] pArray, JButton pButton, JButton pSucheButton){
        removeAllLabelsAndTextfields();
        setBackgroundcolorUnterMenuesGray();
        pButton.setBackground(Color.GREEN);
        removeAllOperatorButton();
        cp.add(pSucheButton);
        for(int i=0; i<pArray.length; i++){
            addLabel(i, pArray[i]);
        }
        addTextfields(pArray.length);
        setResizable(false);
        setVisible(true);
    }

    public void bearbeitenMenueButtonPerformed(String[] pArray, JButton pButton, JButton pBearbeiteButton){
        removeAllLabelsAndTextfields();
        setBackgroundcolorUnterMenuesGray();
        pButton.setBackground(Color.GREEN);
        removeAllOperatorButton();
        cp.add(pBearbeiteButton);
        for(int i=0; i<pArray.length; i++){
            addLabel(i, pArray[i]);
        }
        addTextfields(pArray.length);
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
    
    public void removeAllOperatorButton(){
        removeAllEinfuegeButtons();
        removeAllLoescheButtons();
        removeAllSuchenButtons();
        removeAllBearbeitenButtons();
    }
    
    public void removeAllEinfuegeButtons(){
        for(int i=0; i<einfuegen.length; i++){
            cp.remove(einfuegen[i]);
        }
        cp.remove(queryAbschickenButton);
    }
    
    public void removeAllLoescheButtons(){
        for(int i=0; i<loeschen.length; i++){
            cp.remove(loeschen[i]);
        }
    }
    
    public void removeAllSuchenButtons(){
        for(int i=0; i<suchen.length; i++){
            cp.remove(suchen[i]);
        }
    }
    
    public void removeAllBearbeitenButtons(){
        for(int i=0; i<bearbeiten.length; i++){
            cp.remove(bearbeiten[i]);
        }
    }
  
    public void removeAllEinfuegeMenues(){
         for(int i=0; i<einfuegeMenue.length; i++){
            cp.remove(einfuegeMenue[i]);
        }
    }

    public void removeAllSucheMenues(){
         for(int i=0; i<sucheMenue.length; i++){
            cp.remove(sucheMenue[i]);
        }
    }

    public void removeAllBearbeitenMenues(){
         for(int i=0; i<bearbeiteMenue.length; i++){
            cp.remove(bearbeiteMenue[i]);
        }
    }

    public void removeAllLoeschenMenues(){
         for(int i=0; i<loescheMenue.length; i++){
            cp.remove(loescheMenue[i]);
        }
    }

    public void removeAllUnterMenues(){
        removeAllSucheMenues();
        removeAllEinfuegeMenues();
        removeAllBearbeitenMenues();
        removeAllLoeschenMenues();
    }

    public void setBackgroundcolorMenueButtonsGray(){
        for(int i=0; i<menue.length; i++){
            menue[i].setBackground(Color.GRAY);
        }
    }

    public void setBackgroundcolorUnterMenuesGray(){
        setBackgroundcolorEinfuegeButtonsGray();
        setBackroundcolorSucheButtonsGray();
        setBackroundcolorBearbeitenButtonsGray();
        setBackroundcolorLoeschenButtonsGray();
    }

    public void setBackgroundcolorEinfuegeButtonsGray(){
        for(int i=0; i<einfuegeMenue.length; i++){
            einfuegeMenue[i].setBackground(Color.GRAY);
        }
    }

    public void setBackroundcolorSucheButtonsGray(){
        for(int i=0; i<sucheMenue.length; i++){
            sucheMenue[i].setBackground(Color.GRAY);
        }
    }

    public void setBackroundcolorBearbeitenButtonsGray(){
        for(int i=0; i<bearbeiteMenue.length; i++){
            bearbeiteMenue[i].setBackground(Color.GRAY);
        }
    }

    public void setBackroundcolorLoeschenButtonsGray(){
        for(int i=0; i<loescheMenue.length; i++){
            loescheMenue[i].setBackground(Color.GRAY);
        }
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
        String[] array = {"Mitglieder", "Sekten", "Prediger", "Sektenhäuser", "SekteBuchen", "SQL-Befehl"};
        for(int i=0; i<menue.length; i++){
            int size = (100*i);
            setButton(array[i], menue[i], (0+size), 0, 100, 30, true);
        }
        menue[0].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    mitgliederMenue_ActionPerformed(evt);
                }
            });
        menue[1].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenMenue_ActionPerformed(evt);
                }
            });
        menue[3].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    predigerMenue_ActionPerformed(evt);
                }
            });
        menue[2].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenhausMenue_ActionPerformed(evt);
                }
            });
        menue[4].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sekteBuchenMenue_ActionPerformed(evt);
                }
            });
        menue[5].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sqlBefehlMenue_ActionPerformed(evt);
                }
            });
    }

    public void setEinstellungenEinfuegen(){
        // Einfüge-Menü-Buttons
        String[] array = {"Mitglied einfügen", "Sekte einfügen", "Prediger einfügen", "Sektenhaus einfügen"};
        for(int i=0; i<einfuegeMenue.length; i++){
            setButton(array[i], einfuegeMenue[i], 0, 30, 150, 30, false);
        }
        einfuegeMenue[0].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    mitgliederEinfuegeMenue_ActionPerformed(evt);
                }
            });
        einfuegeMenue[1].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenEinfuegeMenue_ActionPerformed(evt);
                }
            });
        einfuegeMenue[3].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    predigerEinfuegeMenue_ActionPerformed(evt);
                }
            });
        einfuegeMenue[2].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenhausEinfuegeMenue_ActionPerformed(evt);
                }
            });
    }

    public void setEinstellungenSuchenButtons(){
        // Suche-Menü-Buttons
        String[] array = {"Mitglied suchen", "Sekte suchen", "Prediger suchen", "Sektenhaus suchen"};
        for(int i=0; i<sucheMenue.length; i++){
            setButton(array[i], sucheMenue[i], 150, 30, 150, 30, false);
        }
        sucheMenue[0].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    mitgliederSuchenMenueButton_ActionPerformed(evt);
                }
            });
        sucheMenue[1].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenSuchenMenueButton_ActionPerformed(evt);
                }
            });
        sucheMenue[3].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    predigerSuchenMenueButton_ActionPerformed(evt);
                }
            });
        sucheMenue[2].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenhausSuchenMenueButton_ActionPerformed(evt);
                }
            });
    }

    public void setEinstellungenBearbeitenButtons(){
        // Bearbeiten-Menü-Buttons
        String[] array = {"Mitglied bearbeiten", "Sekte bearbeiten", "Prediger bearbeiten", "Sektenhaus bearbeiten"};
        for(int i=0; i<bearbeiteMenue.length; i++){
            setButton(array[i], bearbeiteMenue[i], 300, 30, 150, 30, false);
        }
        bearbeiteMenue[0].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    mitgliederBearbeitenMenue_ActionPerformed(evt);
                }
            });
        bearbeiteMenue[1].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenBearbeitenMenue_ActionPerformed(evt);
                }
            });
        bearbeiteMenue[2].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenhausBearbeitenMenue_ActionPerformed(evt);
                }
            }); 
        bearbeiteMenue[3].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    predigerBearbeitenMenue_ActionPerformed(evt);
                }
            });
    }

    public void setEinstellungenLoeschenButtons(){
        // Löschen-Menü-Buttons
        String[] array = {"Mitglied löschen", "Sekte löschen", "Prediger löschen", "Sektenhaus löschen"};
        for(int i=0; i<loescheMenue.length; i++){
            setButton(array[i], loescheMenue[i], 450, 30, 150, 30, false);
        }
        loescheMenue[0].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    mitgliederLoeschenMenue_ActionPerformed(evt);
                }
            });
        loescheMenue[1].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenLoeschenMenue_ActionPerformed(evt);
                }
            });
        loescheMenue[2].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenhausLoeschenMenue_ActionPerformed(evt);
                }
            }); 
        loescheMenue[3].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    predigerLoeschenMenue_ActionPerformed(evt);
                }
            });
    }

    public void setEinstellungenOperatorButtons(){
        // Operator-Buttons
        setButton("Maske leeren", maskeLeerenButton, 470, 420, 100, 30, true);
        maskeLeerenButton.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    maskeLeerenButton_ActionPerformed(evt);
                }
            });
        setButton("Query Abschicken", queryAbschickenButton, 360, 420, 100, 30, false);
        queryAbschickenButton.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    queryAbschickenButton_ActionPerformed(evt);
                }
            });
    }

    public void setEinstellungenEinfuegeOperatorButtons(){
        // Einfüge-Button 
        for(int i=0; i<einfuegen.length; i++){
            setButton("Einfügen", einfuegen[i], 360, 420, 100, 30, false);
        }
        einfuegen[0].addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    einfuegeButtonM_ActionPerformed(evt);
                }
            });
        einfuegen[1].addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    einfuegeButtonS_ActionPerformed(evt);
                }
            });
        einfuegen[2].addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    einfuegeButtonSH_ActionPerformed(evt);
                }
            });;
        einfuegen[3].addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    einfuegeButtonP_ActionPerformed(evt);
                }
            });
    }
    
    public void setEinstellungenSuchenOperatorButtons(){
        // Suchen-Button 
        for(int i=0; i<suchen.length; i++){
            setButton("Suchen", suchen[i], 360, 420, 100, 30, false);
        }
        suchen[0].addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    mitgliederSuchenMenueButton_ActionPerformed(evt);
                }
            });
        suchen[1].addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    sektenSuchenMenueButton_ActionPerformed(evt);
                }
            });
        suchen[2].addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    sektenhausSuchenMenueButton_ActionPerformed(evt);
                }
            });;
        suchen[3].addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    predigerSuchenMenueButton_ActionPerformed(evt);
                }
            });
    }
    
    public void setEinstellungenBearbeitenOperatorButtons(){
        // Bearbiten-Button 
        for(int i=0; i<bearbeiten.length; i++){
            setButton("Bearbeiten", bearbeiten[i], 360, 420, 100, 30, false);
        }
        bearbeiten[0].addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    mitgliederBearbeitenMenue_ActionPerformed(evt);
                }
            });
        bearbeiten[1].addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    sektenBearbeitenMenue_ActionPerformed(evt);
                }
            });
        bearbeiten[2].addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    sektenhausBearbeitenMenue_ActionPerformed(evt);
                }
            });;
        bearbeiten[3].addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    predigerBearbeitenMenue_ActionPerformed(evt);
                }
            });
    }
    
    public void setEinstellungenLoeschenOperatorButtons(){
        // Löschen-Button 
        for(int i=0; i<loeschen.length; i++){
            setButton("Löschen", loeschen[i], 360, 420, 100, 30, false);
        }
        loeschen[0].addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    mitgliederLoeschenMenue_ActionPerformed(evt);
                }
            });
        loeschen[1].addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    sektenLoeschenMenue_ActionPerformed(evt);
                }
            });
        loeschen[2].addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    sektenhausLoeschenMenue_ActionPerformed(evt);
                }
            });;
        loeschen[3].addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    predigerLoeschenMenue_ActionPerformed(evt);
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