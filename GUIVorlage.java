import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GUIVorlage extends JFrame {
    // Anfang Attribute
    private Verwaltung verwaltung;
    private int m=1;
    
    // Buttons
    // Operator-Buttons
    private JButton einfuegenButton = new JButton(); // Einfüge-Button
    private JButton loescheButtton = new JButton(); // Lösche-Button
    private JButton sucheButton = new JButton(); // Suche-button
    private JButton maskeLeerenButton = new JButton(); // Maske-Leeren
    
    // Menü-Buttons
    private JButton mitdliederMenueButton = new JButton();    //Mitdlieder Menü-Button
    private JButton sektenMenueButton = new JButton();    //Sekten Menü-Button
    private JButton predigerMenueButton = new JButton();    //Prediger Menü-Button
    private JButton sektenhausMenueButton = new JButton();    //Sektenhaus Menü-Button
    
    // Labels
    private JLabel l1 = new JLabel();
    private JLabel l2 = new JLabel();
    private JLabel l3 = new JLabel();
    private JLabel l4 = new JLabel();
    private JLabel l5 = new JLabel();
    private JLabel l6 = new JLabel();
    private JLabel l7 = new JLabel();
    private JLabel l8 = new JLabel();
    private JLabel l9 = new JLabel();
    
    // Textfelder
    private JTextField t1 = new JTextField();
    private JTextField t2 = new JTextField();
    private JTextField t3 = new JTextField();
    private JTextField t5 = new JTextField();
    private JTextField t6 = new JTextField();
    private JTextField t4 = new JTextField();
    private JTextField t7 = new JTextField();
    private JTextField t8 = new JTextField();
    private JTextField t9 = new JTextField();
    private JTextArea textfeld;
    
    // Ende Attribute
    public GUIVorlage(){
        // Frame-Initialisierung
        super("Sekten-Verwaltung");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        int frameWidth = 600; 
        int frameHeight = 460;
        setSize(frameWidth, frameHeight);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (d.width - getSize().width) / 2;
        int y = (d.height - getSize().height) / 2;
        setLocation(x, y);
        Container cp = getContentPane();
        cp.setLayout(null);

        //Verwaltung/Datenbank
        verwaltung = new Verwaltung();

        // /* Erzeugung eines neuen Menü-Dialoges (EXPERIMENTELL) */
        // JDialog meinJDialog = new JDialog();
        // meinJDialog.setTitle("Schulverwaltung - Menü");
        // // Wir setzen die Breite auf 600 und die Höhe 600 Pixel
        // meinJDialog.setSize(600,600);
        // // Zur Veranschaulichung erstellen wir hier eine Border
        // Border bo = new LineBorder(Color.black);
        // // Erstellung einer Menüleiste
        // JMenuBar bar = new JMenuBar();
        // // Wir setzen unsere Umrandung für unsere JMenuBar
        // bar.setBorder(bo);
        // // Erzeugung eines Objektes der Klasse JMenu
        // JMenu menu = new JMenu("Schüler einfügen");
        // // Menü wird der Menüleiste hinzugefügt
        // bar.add(menu);
        // JMenu menu2 = new JMenu("Lehrer einfügen");
        // // Menü wird der Menüleiste hinzugefügt
        // bar.add(menu2);
        // menu2.addActionListener(new ActionListener() {
        // public void actionPerformed(ActionEvent evt) {
        // menu2_ActionPerformed(evt);
        // }
        // });
        // JMenu menu3 = new JMenu("Kurs anlegen");
        // // Menü wird der Menüleiste hinzugefügt
        // bar.add(menu3);
        // JMenu menu4 = new JMenu("Kurs zuweisen");
        // // Menü wird der Menüleiste hinzugefügt
        // bar.add(menu4);
        // JMenu menu5 = new JMenu("Kursinfo");
        // // Menü wird der Menüleiste hinzugefügt
        // bar.add(menu5);
        // // Menüleiste wird für den Dialog gesetzt
        // meinJDialog.setJMenuBar(bar);
        // // Wir lassen unseren Dialog anzeigen
        // meinJDialog.setVisible(true);

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
        // Mitglieder Menü-Button
        mitdliederMenueButton.setBounds(10, 380, 115, 33);
        mitdliederMenueButton.setText("Mitglieder");
        mitdliederMenueButton.setMargin(new Insets(2, 2, 2, 2));
        mitdliederMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    menue1_ActionPerformed(evt);
                }
            });
        mitdliederMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));
        cp.add(mitdliederMenueButton);
        
        // Sekten Menü-Button
        sektenMenueButton.setBounds(130, 380, 115, 33);
        sektenMenueButton.setText("Sekten");
        sektenMenueButton.setMargin(new Insets(2, 2, 2, 2));
        sektenMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    menue2_ActionPerformed(evt);
                }
            });
        sektenMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));
        cp.add(sektenMenueButton);
        
        // Prediger Menü-Button
        predigerMenueButton.setBounds(250, 380, 115, 33);
        predigerMenueButton.setText("Prediger");
        predigerMenueButton.setMargin(new Insets(2, 2, 2, 2));
        predigerMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    menue3_ActionPerformed(evt);
                }
            });
        predigerMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));
        cp.add(predigerMenueButton);
        
        // Sektenhaus Menü-Button
        sektenhausMenueButton.setBounds(370, 380, 115, 33);
        sektenhausMenueButton.setText("Sektenhaus");
        sektenhausMenueButton.setMargin(new Insets(2, 2, 2, 2));
        sektenhausMenueButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    menue4_ActionPerformed(evt);
                }
            });
        sektenhausMenueButton.setFont(new Font("Dialog", Font.PLAIN, 13));
        cp.add(sektenhausMenueButton);
        
        // Operator-Buttons
        // Einfügen-Button
        einfuegenButton.setBounds(400, 10, 115, 33);
        einfuegenButton.setText("Einfügen");
        einfuegenButton.setMargin(new Insets(2, 2, 2, 2));
        einfuegenButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    einfuegenButton_ActionPerformed(evt);
                }
            });
        einfuegenButton.setFont(new Font("Dialog", Font.PLAIN, 13));
        cp.add(einfuegenButton);
        
        // Lösche-Button
        loescheButtton.setBounds(400, 50, 115, 33);
        loescheButtton.setText("Löschen");
        loescheButtton.setMargin(new Insets(2, 2, 2, 2));
        loescheButtton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    loescheButtton_ActionPerformed(evt);
                }
            });
        loescheButtton.setFont(new Font("Dialog", Font.PLAIN, 13));
        cp.add(loescheButtton);
        
        // Suche-Button
        sucheButton.setBounds(400, 90, 115, 33);
        sucheButton.setText("Suchen");
        sucheButton.setMargin(new Insets(2, 2, 2, 2));
        sucheButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    sucheButton_ActionPerformed(evt);
                }
            });
        sucheButton.setFont(new Font("Dialog", Font.PLAIN, 13));
        cp.add(sucheButton);
        
        // MaskeLeeren-Button
        maskeLeerenButton.setBounds(400, 130, 115, 33);
        maskeLeerenButton.setText("Maske leeren");
        maskeLeerenButton.setMargin(new Insets(2, 2, 2, 2));
        maskeLeerenButton.addActionListener(new ActionListener() { 
                public void actionPerformed(ActionEvent evt) { 
                    maskeLeerenButton_ActionPerformed(evt);
                }
            });
        maskeLeerenButton.setFont(new Font("Arial", Font.PLAIN, 14));
        cp.add(maskeLeerenButton);
        
        l1.setBounds(10, 10, 130, 23);
        l1.setText("Name:");
        l1.setFont(new Font("Arial", Font.PLAIN, 17));
        cp.add(l1);
        l2.setBounds(10, 50, 95, 23);
        l2.setText("Vorname:");
        l2.setFont(new Font("Arial", Font.PLAIN, 17));
        cp.add(l2);
        t1.setBounds(150, 10, 230, 30);
        t1.setText("");
        t1.setFont(new Font("Arial", Font.PLAIN, 17));
        cp.add(t1);
        t2.setBounds(150, 50, 230, 30);
        t2.setText("");
        t2.setFont(new Font("Arial", Font.PLAIN, 17));
        cp.add(t2);
        l3.setBounds(10, 90, 95, 23);
        l3.setText("Strasse:");
        l3.setFont(new Font("Arial", Font.PLAIN, 17));
        cp.add(l3);
        l4.setBounds(10, 130, 130, 23);
        l4.setText("Hausnummer:");
        l4.setFont(new Font("Arial", Font.PLAIN, 17));
        cp.add(l4); 
        l5.setBounds(10, 170, 130, 23);
        l5.setText("PLZ:");
        l5.setFont(new Font("Arial", Font.PLAIN, 17));
        cp.add(l5); 
        l6.setBounds(10, 210, 95, 23);
        l6.setText("Ort:");
        l6.setFont(new Font("Arial", Font.PLAIN, 17));
        cp.add(l6);
        l7.setBounds(10, 250, 130, 23);
        l7.setText("Geburtsdatum:");
        l7.setFont(new Font("Arial", Font.PLAIN, 17));
        cp.add(l7);
        l8.setBounds(10, 290, 120, 23);
        l8.setText("Geschlecht:");
        l8.setFont(new Font("Arial", Font.PLAIN, 17));
        cp.add(l8);
        l9.setBounds(10, 330, 130, 23);
        l9.setText("Klasse/Stufe:");
        l9.setFont(new Font("Arial", Font.PLAIN, 17));
        cp.add(l9);
        t3.setBounds(150, 90, 230, 30);
        t3.setText("");
        t3.setFont(new Font("Arial", Font.PLAIN, 17));
        cp.add(t3);
        t4.setBounds(150, 130, 230, 30);
        t4.setText("");
        t4.setFont(new Font("Arial", Font.PLAIN, 17));
        cp.add(t4);
        t5.setBounds(150, 170, 230, 30);
        t5.setText("");
        t5.setFont(new Font("Arial", Font.PLAIN, 17));
        cp.add(t5);

        t6.setBounds(150, 210, 230, 30);
        t6.setText("");
        t6.setFont(new Font("Arial", Font.PLAIN, 17));
        cp.add(t6);
        t7.setBounds(150, 250, 230, 30);
        t7.setText("");
        t7.setFont(new Font("Arial", Font.PLAIN, 17));
        cp.add(t7);
        t8.setBounds(150, 290, 230, 30);
        t8.setText("");
        t8.setFont(new Font("Arial", Font.PLAIN, 17));
        cp.add(t8);
        t9.setBounds(150, 330, 230, 30);
        t9.setText("");
        t9.setFont(new Font("Arial", Font.PLAIN, 17));
        cp.add(t9);
        // Ende Komponenten

        setResizable(false);
        setVisible(true);

    }

    // Anfang Methoden
    public void  menue1_ActionPerformed(ActionEvent evt){
        m=1;
        l1.setText("Name:");
        l2.setText("Vorname:");
        l3.setText("Strasse:");
        l4.setText("Hausnummer:");
        l5.setText("PLZ:");
        l6.setText("Ort:");
        l7.setText("Geburtsdatum:");
        l8.setText("Geschlecht:");
        l9.setText("Klasse/Stufe:");
    }

    public void  menue2_ActionPerformed(ActionEvent evt){
        m=2;
        l1.setText("Name:");
        l2.setText("Vorname:");
        l3.setText("Fach 1:");
        l4.setText("Fach 2:");
        l5.setText("");
        l6.setText("");
        l7.setText("");
        l8.setText("");
        l9.setText("");
    }

      public void  menue3_ActionPerformed(ActionEvent evt){
        m=3;
        l1.setText("Kursname:");
        l2.setText("Fach:");
        l3.setText("Art:");
        l4.setText("Lehrer:");
        l5.setText("");
        l6.setText("");
        l7.setText("");
        l8.setText("");
        l9.setText("");
    }
    
    public void  menue4_ActionPerformed(ActionEvent evt){
        m=4;
        l1.setText("Kursname:");
        l2.setText("Fach:");
        l3.setText("Art:");
        l4.setText("Lehrer:");
        l5.setText("");
        l6.setText("");
        l7.setText("");
        l8.setText("");
        l9.setText("");
    }
    
    public void einfuegenButton_ActionPerformed(ActionEvent evt) {
       
    }

    public void loescheButtton_ActionPerformed(ActionEvent evt) {
        
    }

    public void sucheButton_ActionPerformed(ActionEvent evt) {

    }

    public void maskeLeerenButton_ActionPerformed(ActionEvent evt) {
        maskeLeeren();
    }

    private void maskeLeeren() {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
        t4.setText("");
        t9.setText("");
        t5.setText("");
    }
}