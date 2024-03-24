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

    // Menü-Buttons
    private JButton mitgliederMenueButton = new JButton();    //Mitdlieder Menü-Button
    private JButton sektenMenueButton = new JButton();    //Sekten Menü-Button
    private JButton predigerMenueButton = new JButton();    //Prediger Menü-Button
    private JButton sektenhausMenueButton = new JButton();    //Sektenhaus Menü-Button

    // Einfüge-Menü-Buttons
    private JButton mitgliederEinfuegeMenueButton = new JButton();    //Mitdlieder Einfüge-Menü-Button
    private JButton sektenEinfuegeMenueButton = new JButton();    //Sekten Einfüge-Menü-Button
    private JButton predigerEinfuegeMenueButton = new JButton();    //Prediger Einfüge-Menü-Button
    private JButton sektenhausEinfuegeMenueButton = new JButton();    //Sektenhaus Einfüge-Button

    // Labels
    private JLabel l1 = new JLabel();
    private JLabel l2 = new JLabel();
    private JLabel l3 = new JLabel();
    private JLabel l4 = new JLabel();
    private JLabel l5 = new JLabel();
    private JLabel l6 = new JLabel();
    private JLabel l7 = new JLabel();

    // Textfelder
    private JTextField t1 = new JTextField();
    private JTextField t2 = new JTextField();
    private JTextField t3 = new JTextField();
    private JTextField t4 = new JTextField();
    private JTextField t5 = new JTextField();
    private JTextField t6 = new JTextField();
    private JTextField t7 = new JTextField();

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
        Container cp = getContentPane();
        cp.setLayout(null);

        //Verwaltung/Datenbank
        verwaltung = new Verwaltung();

        // Anfang Komponenten
        JTextArea textfeld = new JTextArea(5, 30);
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

        // Einfüge-Buttons
        // Mitglieder Einfüge-Button
        mitgliederEinfuegeMenueButton.setBounds(0, 30, 200, 30);
        mitgliederEinfuegeMenueButton.setText("Mitglied einfügen");
        mitgliederEinfuegeMenueButton.setMargin(new Insets(2, 2, 2, 2));
        mitgliederEinfuegeMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    mitgliederEinfuegeMenueButton_ActionPerformed(evt);
                }
            });
        mitgliederEinfuegeMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));

        // Sekten Einfüge-Button
        sektenEinfuegeMenueButton.setBounds(0, 30, 200, 30);
        sektenEinfuegeMenueButton.setText("Sekte einfügen");
        sektenEinfuegeMenueButton.setMargin(new Insets(2, 2, 2, 2));
        sektenEinfuegeMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenEinfuegeMenueButton_ActionPerformed(evt);
                }
            });
        sektenEinfuegeMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));

        // Prediger Einfüge-Button
        predigerEinfuegeMenueButton.setBounds(0, 30, 200, 30);
        predigerEinfuegeMenueButton.setText("Prediger einfügen");
        predigerEinfuegeMenueButton.setMargin(new Insets(2, 2, 2, 2));
        predigerEinfuegeMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    predigerEinfuegeMenueButton_ActionPerformed(evt);
                }
            });
        predigerEinfuegeMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));

        // Sektenhaus Einfüge-Button
        sektenhausEinfuegeMenueButton.setBounds(0, 30, 200, 30);
        sektenhausEinfuegeMenueButton.setText("Sektenhaus einfügen");
        sektenhausEinfuegeMenueButton.setMargin(new Insets(2, 2, 2, 2));
        sektenhausEinfuegeMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sektenhausEinfuegeMenueButton_ActionPerformed(evt);
                }
            });
        sektenhausEinfuegeMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));

        // Operator-Buttons
        // MaskeLeeren-Button
        maskeLeerenButton.setBounds(450, 300, 100, 30);
        maskeLeerenButton.setText("Maske leeren");
        maskeLeerenButton.setMargin(new Insets(2, 2, 2, 2));
        maskeLeerenButton.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    maskeLeerenButton_ActionPerformed(evt);
                }
            });
        maskeLeerenButton.setFont(new Font("Arial", Font.PLAIN, 14));
        cp.add(maskeLeerenButton);

        // Einfüge-Button Mitglied
        einfuegenButtonM.setBounds(450, 350, 100, 30);
        einfuegenButtonM.setText("Einfügen");
        einfuegenButtonM.setMargin(new Insets(2, 2, 2, 2));
        einfuegenButtonM.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    einfuegeButtonM_ActionPerformed(evt);
                }
            });
        einfuegenButtonM.setFont(new Font("Arial", Font.PLAIN, 14));

        // Einfüge-Button Sekte
        einfuegenButtonS.setBounds(450, 350, 100, 30);
        einfuegenButtonS.setText("Einfügen");
        einfuegenButtonS.setMargin(new Insets(2, 2, 2, 2));
        einfuegenButtonS.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    einfuegeButtonS_ActionPerformed(evt);
                }
            });
        einfuegenButtonS.setFont(new Font("Arial", Font.PLAIN, 14));

        // Einfüge-Button Sektenhaus
        einfuegenButtonSH.setBounds(450, 350, 100, 30);
        einfuegenButtonSH.setText("Einfügen");
        einfuegenButtonSH.setMargin(new Insets(2, 2, 2, 2));
        einfuegenButtonSH.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    einfuegeButtonSH_ActionPerformed(evt);
                }
            });
        einfuegenButtonSH.setFont(new Font("Arial", Font.PLAIN, 14));

        // Einfüge-Button Prediger
        einfuegenButtonP.setBounds(450, 350, 100, 30);
        einfuegenButtonP.setText("Einfügen");
        einfuegenButtonP.setMargin(new Insets(2, 2, 2, 2));
        einfuegenButtonP.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    einfuegeButtonP_ActionPerformed(evt);
                }
            });
        einfuegenButtonP.setFont(new Font("Arial", Font.PLAIN, 14));

        //Textfelder
        t1.setBounds(150, 100, 230, 30);
        t1.setText("");
        t1.setFont(new Font("Arial", Font.PLAIN, 17));
        t2.setBounds(150, 140, 230, 30);
        t2.setText("");
        t2.setFont(new Font("Arial", Font.PLAIN, 17));
        t3.setBounds(150, 180, 230, 30);
        t3.setText("");
        t3.setFont(new Font("Arial", Font.PLAIN, 17));
        t4.setBounds(150, 220, 230, 30);
        t4.setText("");
        t4.setFont(new Font("Arial", Font.PLAIN, 17));
        t5.setBounds(150, 260, 230, 30);
        t5.setText("");
        t5.setFont(new Font("Arial", Font.PLAIN, 17));
        t6.setBounds(150, 300, 230, 30);
        t6.setText("");
        t6.setFont(new Font("Arial", Font.PLAIN, 17));
        t7.setBounds(150, 340, 230, 30);
        t7.setText("");
        t7.setFont(new Font("Arial", Font.PLAIN, 17));

        //Label
        l1.setBounds(10, 100, 130, 23);
        l1.setFont(new Font("Arial", Font.PLAIN, 17));
        l2.setBounds(10, 140, 95, 23);
        l2.setFont(new Font("Arial", Font.PLAIN, 17));
        l3.setBounds(10, 180, 95, 23);
        l3.setFont(new Font("Arial", Font.PLAIN, 17));
        l4.setBounds(10, 220, 130, 23);
        l4.setFont(new Font("Arial", Font.PLAIN, 17));
        l5.setBounds(10, 260, 130, 23);
        l5.setFont(new Font("Arial", Font.PLAIN, 17));
        l6.setBounds(10, 300, 130, 23);
        l6.setFont(new Font("Arial", Font.PLAIN, 17)); 
        l7.setBounds(10, 340, 130, 23);
        l7.setFont(new Font("Arial", Font.PLAIN, 17)); 

        setResizable(false);
        setVisible(true);
    }

    // Anfang Methoden
    public void mitgliederEinfuegeMenueButton_ActionPerformed(ActionEvent evt){
        m=1;
        Container cp = getContentPane();
        removeAllLabelsAndTextfields();
        setBackgroundcolorEinfuegeButtonsGray();
        mitgliederEinfuegeMenueButton.setBackground(Color.GREEN);
        removeAllEinfuegeButtons();
        cp.add(einfuegenButtonM);
        l1.setText("Name:");
        cp.add(l1);
        l2.setText("Vorname:");
        cp.add(l2);
        l3.setText("Geburtsdatum:");
        cp.add(l3);
        l4.setText("Bekehrungsdatum:");
        cp.add(l4); 
        l5.setText("Sterbedatum:");
        cp.add(l5); 
        l6.setText("Sektenhaus-ID:");
        cp.add(l6);  
        l7.setText("Sekten-ID:");
        cp.add(l7);  

        cp.add(t1);
        cp.add(t2);
        cp.add(t3);
        cp.add(t4);
        cp.add(t5);
        cp.add(t6);
        cp.add(t7);

        setResizable(false);
        setVisible(true);
    }

    public void sektenEinfuegeMenueButton_ActionPerformed(ActionEvent evt){
        m=2;
        Container cp = getContentPane();
        removeAllLabelsAndTextfields();
        setBackgroundcolorEinfuegeButtonsGray();
        sektenEinfuegeMenueButton.setBackground(Color.GREEN);
        removeAllEinfuegeButtons();
        cp.add(einfuegenButtonS);
        
        l1.setText("Name:");
        cp.add(l1);
        l2.setText("Gründer:");
        cp.add(l2);
        l3.setText("Apokalipsedatum:");
        cp.add(l3);
        l4.setText("Glaubenssatz:");
        cp.add(l4); 
        l5.setText("Entstehungsjahr:");
        cp.add(l5); 
        l6.setText("Zusatzinformationen:");
        cp.add(l6); 
        l7.setText("Mitgliederzahl:");
        cp.add(l7); 

        cp.add(t1);
        cp.add(t2);
        cp.add(t3);
        cp.add(t4);
        cp.add(t5);
        cp.add(t6);
        cp.add(t7);
        setResizable(false);
        setVisible(true);
    }

    public void predigerEinfuegeMenueButton_ActionPerformed(ActionEvent evt){
        m=3;
        Container cp = getContentPane();
        removeAllLabelsAndTextfields();
        setBackgroundcolorEinfuegeButtonsGray();
        predigerEinfuegeMenueButton.setBackground(Color.GREEN);
        removeAllEinfuegeButtons();
        cp.add(einfuegenButtonP);
        l1.setText("Mitglieder-ID:");
        cp.add(l1);
        cp.add(t1);
        setResizable(false);
        setVisible(true);
    }

    public void sektenhausEinfuegeMenueButton_ActionPerformed(ActionEvent evt){
        m=4;
        Container cp = getContentPane();
        removeAllLabelsAndTextfields();
        setBackgroundcolorEinfuegeButtonsGray();
        sektenhausEinfuegeMenueButton.setBackground(Color.GREEN);
        removeAllEinfuegeButtons();
        cp.add(einfuegenButtonSH);
        l1.setText("Name:");
        cp.add(l1);
        l2.setText("Adresse:");
        cp.add(l2);
        l3.setText("Sektenhaus-PredigerID:");
        cp.add(l3);
        cp.add(t1);
        cp.add(t2);
        cp.add(t3);
        setResizable(false);
        setVisible(true);
    }

    public void mitgliederMenue_ActionPerformed(ActionEvent evt) {
        Container cp = getContentPane();
        removeAllEinfuegeMenues();
        cp.add(mitgliederEinfuegeMenueButton);
        setBackgroundcolorMenueButtonsGray();
        mitgliederMenueButton.setBackground(Color.GREEN);
        setResizable(false);
        setVisible(true);
    }

    public void sektenMenue_ActionPerformed(ActionEvent evt) {
        Container cp = getContentPane();
        removeAllEinfuegeMenues();
        cp.add(sektenEinfuegeMenueButton);
        setBackgroundcolorMenueButtonsGray();
        sektenMenueButton.setBackground(Color.GREEN);
        setResizable(false);
        setVisible(true);
    }

    public void predigerMenue_ActionPerformed(ActionEvent evt) {
        Container cp = getContentPane();
        removeAllEinfuegeMenues();
        cp.add(predigerEinfuegeMenueButton);
        setBackgroundcolorMenueButtonsGray();
        predigerMenueButton.setBackground(Color.GREEN);
        setResizable(false);
        setVisible(true);
    }

    public void sektenhausMenue_ActionPerformed(ActionEvent evt) {
        Container cp = getContentPane();
        removeAllEinfuegeMenues();
        cp.add(sektenhausEinfuegeMenueButton);
        setBackgroundcolorMenueButtonsGray();
        sektenhausMenueButton.setBackground(Color.GREEN);
        setResizable(false);
        setVisible(true);
    }

    public void einfuegeButtonM_ActionPerformed(ActionEvent evt) {
        int sektenhausID = Integer.parseInt(t6.getText());
        String name = t1.getText();
        String vorname = t2.getText();
        String gebDat = t3.getText();
        String bekDat = t4.getText();
        String sterbDat = t5.getText();
        int sektenID = Integer.parseInt(t7.getText());
        verwaltung.mitgliedEinfuegen(sektenhausID, name, vorname, gebDat, bekDat, sterbDat, sektenID);
    }
    
    public void einfuegeButtonS_ActionPerformed(ActionEvent evt) {
        String name = t1.getText();
        String gruender = t2.getText();
        String apoDat =  t3.getText();
        String glaubenssatz =  t4.getText();
        int entJahr =  Integer.parseInt(t5.getText());
        String zusatzInfo =  t6.getText();
        int mitgliederZahl =  Integer.parseInt(t7.getText());
        verwaltung.sekteEinfuegen(name, gruender, apoDat, glaubenssatz, entJahr, zusatzInfo, mitgliederZahl);
    }
    
    public void einfuegeButtonSH_ActionPerformed(ActionEvent evt) {
        String adresse = t2.getText();
        String name = t1.getText();
        int predigerID =  Integer.parseInt(t3.getText());
        verwaltung.sektenhausEinfuegen(adresse, name, predigerID);
    }
    
    public void einfuegeButtonP_ActionPerformed(ActionEvent evt) {
        int mitgliederID = Integer.parseInt(t1.getText());
        verwaltung.predigerEinfuegen(mitgliederID);
    }

    public void maskeLeerenButton_ActionPerformed(ActionEvent evt) {
        maskeLeeren();
    }

    public void removeAllLabelsAndTextfields(){
        Container cp = getContentPane();
        cp.remove(l1);
        cp.remove(l2);
        cp.remove(l3);
        cp.remove(l4);
        cp.remove(l5);
        cp.remove(l6);
        cp.remove(l7);

        cp.remove(t1);
        cp.remove(t2);
        cp.remove(t3);
        cp.remove(t4);
        cp.remove(t5);
        cp.remove(t6);
        cp.remove(t7);
    }
    
    public void removeAllEinfuegeButtons(){
        Container cp = getContentPane();
        cp.remove(einfuegenButtonP);
        cp.remove(einfuegenButtonM);
        cp.remove(einfuegenButtonSH);
        cp.remove(einfuegenButtonS);
    }
    
    public void removeAllEinfuegeMenues(){
        Container cp = getContentPane();
        cp.remove(mitgliederEinfuegeMenueButton);
        cp.remove(sektenEinfuegeMenueButton);
        cp.remove(predigerEinfuegeMenueButton);
        cp.remove(sektenhausEinfuegeMenueButton);
    }

    public void setBackgroundcolorMenueButtonsGray(){
        mitgliederMenueButton.setBackground(Color.GRAY);
        sektenMenueButton.setBackground(Color.GRAY);
        sektenhausMenueButton.setBackground(Color.GRAY);
        predigerMenueButton.setBackground(Color.GRAY);
    }

    public void setBackgroundcolorEinfuegeButtonsGray(){
        mitgliederEinfuegeMenueButton.setBackground(Color.GRAY);
        sektenEinfuegeMenueButton.setBackground(Color.GRAY);
        sektenhausEinfuegeMenueButton.setBackground(Color.GRAY);
        predigerEinfuegeMenueButton.setBackground(Color.GRAY);
    }

    private void maskeLeeren() {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
    }
}