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
    private JButton mitgliederMenueButton = new JButton();    //Mitdlieder Menü-Button
    private JButton sektenMenueButton = new JButton();    //Sekten Menü-Button
    private JButton predigerMenueButton = new JButton();    //Prediger Menü-Button
    private JButton sektenhausMenueButton = new JButton();    //Sektenhaus Menü-Button
    private JButton sqlBefehlMenueButton = new JButton(); //SQL-Befehl Menü-Button   
    
    // Einfüge-Menü-Buttons
    private JButton mitgliederEinfuegeMenueButton = new JButton();    //Mitdlieder Einfüge-Menü-Button
    private JButton sektenEinfuegeMenueButton = new JButton();    //Sekten Einfüge-Menü-Button
    private JButton predigerEinfuegeMenueButton = new JButton();    //Prediger Einfüge-Menü-Button
    private JButton sektenhausEinfuegeMenueButton = new JButton();    //Sektenhaus Einfüge-Button
    
    // Suche-Menü-Buttons 
    private JButton mitgliederSucheMenueButton = new JButton();    //Mitdlieder Suche-Menü-Button
    private JButton sektenSucheMenueButton = new JButton();    //Sekten Suche-Menü-Button
    private JButton predigerSucheMenueButton = new JButton();    //Prediger Suche-Menü-Button
    private JButton sektenhausSucheMenueButton = new JButton();    //Sektenhaus Suche-Button
    
    // Labels
    private JLabel[] labels = {new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel(), new JLabel()};
    
    // Textfelder
    private JTextField[] textfields = {new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField(), new JTextField()};
    
    Container cp = getContentPane();

    // Ende Attribute
    public GUIVorlage(){
        // Frame-Initialisierung
        super("Sekten-Verwaltung");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 600; 
        int frameHeight = 500;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        cp.setLayout(null);

        //Verwaltung/Datenbank
        verwaltung = new Verwaltung();

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

        // Menü-Buttons 

        // Mitlieder-Menü
        mitgliederMenueButton.setBounds(0, 0, 100, 30);
        mitgliederMenueButton.setText("Mitglieder");
        mitgliederMenueButton.setMargin(new Insets(2, 2, 2, 2));
        mitgliederMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    mitgliederMenue_ActionPerformed(evt);
                }
            });
        mitgliederMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));
        cp.add(mitgliederMenueButton);

        // Sekten-Menü
        sektenMenueButton.setBounds(100, 0, 100, 30);
        sektenMenueButton.setText("Sekten");
        sektenMenueButton.setMargin(new Insets(2, 2, 2, 2));
        sektenMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenMenue_ActionPerformed(evt);
                }
            });
        sektenMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));
        cp.add(sektenMenueButton);

        // Prediger-Menü
        predigerMenueButton.setBounds(200, 0, 100, 30);
        predigerMenueButton.setText("Prediger");
        predigerMenueButton.setMargin(new Insets(2, 2, 2, 2));
        predigerMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    predigerMenue_ActionPerformed(evt);
                }
            });
        predigerMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));
        cp.add(predigerMenueButton);

        // Sektenhaus-Menü
        sektenhausMenueButton.setBounds(300, 0, 100, 30);
        sektenhausMenueButton.setText("Sektenhäuser");
        sektenhausMenueButton.setMargin(new Insets(2, 2, 2, 2));
        sektenhausMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenhausMenue_ActionPerformed(evt);
                }
            });
        sektenhausMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));
        cp.add(sektenhausMenueButton);
        
        // sqlBefehl-Menü
        sqlBefehlMenueButton.setBounds(400, 0, 100, 30);
        sqlBefehlMenueButton.setText("SQL-Befehl");
        sqlBefehlMenueButton.setMargin(new Insets(2, 2, 2, 2));
        sqlBefehlMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sqlBefehlMenue_ActionPerformed(evt);
                }
            });
        sqlBefehlMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));
        cp.add(sqlBefehlMenueButton);

        // Einfüge-Menü-Buttons
        // Mitglieder Einfüge-Menü-Button
        mitgliederEinfuegeMenueButton.setBounds(0, 30, 150, 30);
        mitgliederEinfuegeMenueButton.setText("Mitglied einfügen");
        mitgliederEinfuegeMenueButton.setMargin(new Insets(2, 2, 2, 2));
        mitgliederEinfuegeMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    mitgliederEinfuegeMenueButton_ActionPerformed(evt);
                }
            });
        mitgliederEinfuegeMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));

        // Sekten Einfüge-Menü-Button
        sektenEinfuegeMenueButton.setBounds(0, 30, 150, 30);
        sektenEinfuegeMenueButton.setText("Sekte einfügen");
        sektenEinfuegeMenueButton.setMargin(new Insets(2, 2, 2, 2));
        sektenEinfuegeMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenEinfuegeMenueButton_ActionPerformed(evt);
                }
            });
        sektenEinfuegeMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));

        // Prediger Einfüge-Menü-Button
        predigerEinfuegeMenueButton.setBounds(0, 30, 150, 30);
        predigerEinfuegeMenueButton.setText("Prediger einfügen");
        predigerEinfuegeMenueButton.setMargin(new Insets(2, 2, 2, 2));
        predigerEinfuegeMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    predigerEinfuegeMenueButton_ActionPerformed(evt);
                }
            });
        predigerEinfuegeMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));

        // Sektenhaus Einfüge-Menü-Button
        sektenhausEinfuegeMenueButton.setBounds(0, 30, 150, 30);
        sektenhausEinfuegeMenueButton.setText("Sektenhaus einfügen");
        sektenhausEinfuegeMenueButton.setMargin(new Insets(2, 2, 2, 2));
        sektenhausEinfuegeMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenhausEinfuegeMenueButton_ActionPerformed(evt);
                }
            });
        sektenhausEinfuegeMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));
        
        // Suche-Menü-Buttons
        // Mitglieder Suche-Menü-Button
        mitgliederSucheMenueButton.setBounds(150, 30, 150, 30);
        mitgliederSucheMenueButton.setText("Mitglied suchen");
        mitgliederSucheMenueButton.setMargin(new Insets(2, 2, 2, 2));
        mitgliederSucheMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    mitgliederEinfuegeMenueButton_ActionPerformed(evt);
                }
            });
        mitgliederSucheMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));
        
        // Sekten Suche-Menü-Button
        sektenSucheMenueButton.setBounds(150, 30, 150, 30);
        sektenSucheMenueButton.setText("Sekte suchen");
        sektenSucheMenueButton.setMargin(new Insets(2, 2, 2, 2));
        sektenSucheMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenEinfuegeMenueButton_ActionPerformed(evt);
                }
            });
        sektenSucheMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));
        
        // Prediger Suche-Menü-Button
        predigerSucheMenueButton.setBounds(150, 30, 150, 30);
        predigerSucheMenueButton.setText("Prediger suchen");
        predigerSucheMenueButton.setMargin(new Insets(2, 2, 2, 2));
        predigerSucheMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    predigerEinfuegeMenueButton_ActionPerformed(evt);
                }
            });
        predigerSucheMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));
        
        // Sektenhaus Suche-Menü-Button
        sektenhausSucheMenueButton.setBounds(150, 30, 150, 30);
        sektenhausSucheMenueButton.setText("Sektenhaus suchen");
        sektenhausSucheMenueButton.setMargin(new Insets(2, 2, 2, 2));
        sektenhausSucheMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenhausEinfuegeMenueButton_ActionPerformed(evt);
                }
            });
        sektenhausSucheMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));


        // Operator-Buttons
        // MaskeLeeren-Button
        maskeLeerenButton.setBounds(450, 400, 100, 30);
        maskeLeerenButton.setText("Maske leeren");
        maskeLeerenButton.setMargin(new Insets(2, 2, 2, 2));
        maskeLeerenButton.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    maskeLeerenButton_ActionPerformed(evt);
                }
            });
        maskeLeerenButton.setFont(new Font("Arial", Font.PLAIN, 14));
        cp.add(maskeLeerenButton);
        
        // QueryAbschicken-Button
        queryAbschickenButton.setBounds(450, 340, 100, 30);
        queryAbschickenButton.setText("Query Abschicken");
        queryAbschickenButton.setMargin(new Insets(2, 2, 2, 2));
        queryAbschickenButton.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    queryAbschickenButton_ActionPerformed(evt);
                }
            });
        queryAbschickenButton.setFont(new Font("Arial", Font.PLAIN, 14));

        // Einfüge-Button Mitglied
        einfuegenButtonM.setBounds(450, 340, 100, 30);
        einfuegenButtonM.setText("Einfügen");
        einfuegenButtonM.setMargin(new Insets(2, 2, 2, 2));
        einfuegenButtonM.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    einfuegeButtonM_ActionPerformed(evt);
                }
            });
        einfuegenButtonM.setFont(new Font("Arial", Font.PLAIN, 14));

        // Einfüge-Button Sekte
        einfuegenButtonS.setBounds(450, 340, 100, 30);
        einfuegenButtonS.setText("Einfügen");
        einfuegenButtonS.setMargin(new Insets(2, 2, 2, 2));
        einfuegenButtonS.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    einfuegeButtonS_ActionPerformed(evt);
                }
            });
        einfuegenButtonS.setFont(new Font("Arial", Font.PLAIN, 14));

        // Einfüge-Button Sektenhaus
        einfuegenButtonSH.setBounds(450, 340, 100, 30);
        einfuegenButtonSH.setText("Einfügen");
        einfuegenButtonSH.setMargin(new Insets(2, 2, 2, 2));
        einfuegenButtonSH.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    einfuegeButtonSH_ActionPerformed(evt);
                }
            });
        einfuegenButtonSH.setFont(new Font("Arial", Font.PLAIN, 14));

        // Einfüge-Button Prediger
        einfuegenButtonP.setBounds(450, 340, 100, 30);
        einfuegenButtonP.setText("Einfügen");
        einfuegenButtonP.setMargin(new Insets(2, 2, 2, 2));
        einfuegenButtonP.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    einfuegeButtonP_ActionPerformed(evt);
                }
            });
        einfuegenButtonP.setFont(new Font("Arial", Font.PLAIN, 14));

        //Textfelder
        for(int i=0; i<textfields.length; i++){
            int hight = 100+(i*40);
            textfields[i].setBounds(150, hight, 230, 30);
            textfields[i].setText("");
            textfields[i].setFont(new Font("Arial", Font.PLAIN, 17));
        }
        //Label
         for(int i=0; i<labels.length; i++){
            int hight = 100+(i*40);
            labels[i].setBounds(10, hight, 150, 30);
            labels[i].setText("");
            labels[i].setFont(new Font("Arial", Font.PLAIN, 17));
        }
        
        setBackgroundcolorMenueButtonsGray();
        setBackgroundcolorUnterMenuesGray();

        setResizable(false);
        setVisible(true);
    }

    // Anfang Methoden
    public void mitgliederEinfuegeMenueButton_ActionPerformed(ActionEvent evt){
        m=1;
        removeAllLabelsAndTextfields();
        setBackgroundcolorUnterMenuesGray();
        mitgliederEinfuegeMenueButton.setBackground(Color.GREEN);
        removeAllEinfuegeButtons();
        cp.add(einfuegenButtonM);
        addLabel(0, "Name:");
        addLabel(1, "Vorname:");
        addLabel(2, "Geburtsdatum:");
        addLabel(3, "Bekehrungsdatum:");
        addLabel(4, "Sterbedatum:");
        addLabel(5, "Sektenhaus-ID:"); 
        addTextfields(6);
        setResizable(false);
        setVisible(true);
    }

    public void sektenEinfuegeMenueButton_ActionPerformed(ActionEvent evt){
        m=2;
        removeAllLabelsAndTextfields();
        setBackgroundcolorUnterMenuesGray();
        sektenEinfuegeMenueButton.setBackground(Color.GREEN);
        removeAllEinfuegeButtons();
        cp.add(einfuegenButtonS);
        addLabel(0, "Name:");
        addLabel(1, "Gründer:");
        addLabel(2, "Apokalipsedatum:");
        addLabel(3, "Glaubenssatz:");
        addLabel(4, "Entstehungsjahr:");
        addLabel(5, "Zusatzinformationen:"); 
        addLabel(6, "Mitgliederzahl:"); 
        addTextfields(7);
        setResizable(false);
        setVisible(true);
    }

    public void predigerEinfuegeMenueButton_ActionPerformed(ActionEvent evt){
        m=3;
        removeAllLabelsAndTextfields();
        setBackgroundcolorUnterMenuesGray();
        predigerEinfuegeMenueButton.setBackground(Color.GREEN);
        removeAllEinfuegeButtons();
        cp.add(einfuegenButtonP);
        addLabel(0, "Mitglieder-ID:");
        addTextfields(1);
        setResizable(false);
        setVisible(true);
    }

    public void sektenhausEinfuegeMenueButton_ActionPerformed(ActionEvent evt){
        m=4;
        removeAllLabelsAndTextfields();
        setBackgroundcolorUnterMenuesGray();
        sektenhausEinfuegeMenueButton.setBackground(Color.GREEN);
        removeAllEinfuegeButtons();
        cp.add(einfuegenButtonSH);
        addLabel(0, "Name:");
        addLabel(1, "Adresse:");
        addLabel(2, "Sektenhaus-PredigerID:");
        addTextfields(3);
        setResizable(false);
        setVisible(true);
    }

    public void mitgliederMenue_ActionPerformed(ActionEvent evt) {
        removeAllUnterMenues();
        removeAllLabelsAndTextfields();
        cp.add(mitgliederEinfuegeMenueButton);
        cp.add(mitgliederSucheMenueButton);
        setBackgroundcolorMenueButtonsGray();
        mitgliederMenueButton.setBackground(Color.GREEN);
        setResizable(false);
        setVisible(true);
    }

    public void sektenMenue_ActionPerformed(ActionEvent evt) {
        removeAllUnterMenues();
        removeAllLabelsAndTextfields();
        cp.add(sektenEinfuegeMenueButton);
        cp.add(sektenSucheMenueButton);
        setBackgroundcolorMenueButtonsGray();
        sektenMenueButton.setBackground(Color.GREEN);
        setResizable(false);
        setVisible(true);
    }

    public void predigerMenue_ActionPerformed(ActionEvent evt) {
        removeAllUnterMenues();
        removeAllLabelsAndTextfields();
        cp.add(predigerEinfuegeMenueButton);
        cp.add(predigerSucheMenueButton);
        setBackgroundcolorMenueButtonsGray();
        predigerMenueButton.setBackground(Color.GREEN);
        setResizable(false);
        setVisible(true);
    }

    public void sektenhausMenue_ActionPerformed(ActionEvent evt) {
        removeAllUnterMenues();
        removeAllLabelsAndTextfields();
        cp.add(sektenhausEinfuegeMenueButton);
        cp.add(sektenhausSucheMenueButton);
        setBackgroundcolorMenueButtonsGray();
        sektenhausMenueButton.setBackground(Color.GREEN);
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
    
    public void removeAllUnterMenues(){
         removeAllSucheMenues();
         removeAllEinfuegeMenues();
    }
    
    public void setBackgroundcolorMenueButtonsGray(){
        mitgliederMenueButton.setBackground(Color.GRAY);
        sektenMenueButton.setBackground(Color.GRAY);
        sektenhausMenueButton.setBackground(Color.GRAY);
        predigerMenueButton.setBackground(Color.GRAY);
        sqlBefehlMenueButton.setBackground(Color.GRAY);
    }
    
    public void setBackgroundcolorUnterMenuesGray(){
        setBackgroundcolorEinfuegeButtonsGray();
        setBackroundcolorSucheButtonsGray();
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
    
    public void addTextfields(int pAnzahl){
        for(int i=0;i<pAnzahl;i++){
           cp.add(textfields[i]);
        }
    }
    
    public void addLabel(int pLabel, String pText){
        labels[pLabel].setText(pText);
        cp.add(labels[pLabel]);
    }
    
    public void setButton(String pName, JButton pButton, int pKoordinate1, int pKoordinate2, int pKoordinate3, int pKoordinate4){
        pButton.setBounds(pKoordinate1, pKoordinate2, pKoordinate3, pKoordinate4);
        pButton.setText(pName);
        pButton.setMargin(new Insets(2, 2, 2, 2));
        pButton.setFont(new Font("Dialog", Font.PLAIN, 13));
    }
    
    public void maskeLeeren() {
        for(int i=0;i<textfields.length;i++){
           textfields[i].setText("");
        }
    }
}