import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javax.swing.border.*;
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

    // Textfelder
    private JTextField t1 = new JTextField();
    private JTextField t2 = new JTextField();
    private JTextField t3 = new JTextField();
    private JTextField t4 = new JTextField();
    private JTextField t5 = new JTextField();
    private JTextField t6 = new JTextField();

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
                    mitgliederMenue_ActionPerformed(evt);
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
                    sektenMenue_ActionPerformed(evt);
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
                    predigerMenue_ActionPerformed(evt);
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
                    sektenhausMenue_ActionPerformed(evt);
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

        //Textfelder
        t1.setBounds(150, 10, 230, 30);
        t1.setText("");
        t1.setFont(new Font("Arial", Font.PLAIN, 17));
        t2.setBounds(150, 50, 230, 30);
        t2.setText("");
        t2.setFont(new Font("Arial", Font.PLAIN, 17));
        t3.setBounds(150, 90, 230, 30);
        t3.setText("");
        t3.setFont(new Font("Arial", Font.PLAIN, 17));
        t4.setBounds(150, 130, 230, 30);
        t4.setText("");
        t4.setFont(new Font("Arial", Font.PLAIN, 17));
        t5.setBounds(150, 170, 230, 30);
        t5.setText("");
        t5.setFont(new Font("Arial", Font.PLAIN, 17));
        t6.setBounds(150, 210, 230, 30);
        t6.setText("");
        t6.setFont(new Font("Arial", Font.PLAIN, 17));

        //Label
        l1.setBounds(10, 10, 130, 23);
        l1.setFont(new Font("Arial", Font.PLAIN, 17));
        l2.setBounds(10, 50, 95, 23);
        l2.setFont(new Font("Arial", Font.PLAIN, 17));
        l3.setBounds(10, 90, 95, 23);
        l3.setFont(new Font("Arial", Font.PLAIN, 17));
        l4.setBounds(10, 130, 130, 23);
        l4.setFont(new Font("Arial", Font.PLAIN, 17));
        l5.setBounds(10, 170, 130, 23);
        l5.setFont(new Font("Arial", Font.PLAIN, 17));
        l6.setBounds(10, 210, 130, 23);
        l6.setFont(new Font("Arial", Font.PLAIN, 17));  

        setResizable(false);
        setVisible(true);
    }

    // Anfang Methoden
    public void  mitgliederMenue_ActionPerformed(ActionEvent evt){
        m=1;
        Container cp = getContentPane();
        //Label einfügen 
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
        l6.setText("Mitglieder-ID:");
        cp.add(l6);  

        //Textfelder einfügen
        cp.add(t1);
        cp.add(t2);
        cp.add(t3);
        cp.add(t4);
        cp.add(t5);
        cp.add(t6);

        setResizable(false);
        setVisible(true);
    }

    public void  sektenMenue_ActionPerformed(ActionEvent evt){
        m=2;
        Container cp = getContentPane();
        //Label einfügen
        l1.setText("Name:");
        cp.add(l1);
        l2.setText("Gründer:");
        cp.add(l2);
        l3.setText("Apokalipsedatum:");
        cp.add(l3);
        l4.setText("Glaubenssatz:");
        cp.add(l4); 
        l5.setText("Mitglieder-ID:");
        cp.add(l5); 

        //Label, die überflüssig sind entfernen
        cp.remove(l6);

        //Textfelder einfügen
        cp.add(t1);
        cp.add(t2);
        cp.add(t3);
        cp.add(t4);
        cp.add(t5);

        //Textfelder, die überflüssig sind entfernen
        cp.remove(t6);  

        setResizable(false);
        setVisible(true);
    }

    public void  predigerMenue_ActionPerformed(ActionEvent evt){
        m=3;
        Container cp = getContentPane();
        //Label
        l1.setText("Prediger-ID:");
        cp.add(l1);

        //Label, die überflüssig sind entfernen
        cp.remove(l2);
        cp.remove(l3);
        cp.remove(l4);
        cp.remove(l5);
        cp.remove(l6);

        //Textfelder einfügen
        cp.add(t1);

        //Textfelder, die überflüssig sind entfernen
        cp.remove(t2);
        cp.remove(t3);
        cp.remove(t4);
        cp.remove(t5);
        cp.remove(t6);

        setResizable(false);
        setVisible(true);
    }

    public void  sektenhausMenue_ActionPerformed(ActionEvent evt){
        m=4;
        Container cp = getContentPane();

        //Label
        l1.setText("Name:");
        cp.add(l1);
        l2.setText("Adresse:");
        cp.add(l2);
        l3.setText("Sektenhaus-ID:");
        cp.add(l3);
        
        //Label, die überflüssig sind entfernen
        cp.remove(l4);
        cp.remove(l5);
        cp.remove(l6);

        //Textfelder einfügen
        cp.add(t1);
        cp.add(t2);
        cp.add(t3);

        //Textfelder, die überflüssig sind entfernen
        cp.remove(t4);
        cp.remove(t5);
        cp.remove(t6);

        setResizable(false);
        setVisible(true);
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
        t4.setText("");
        t5.setText("");
        t6.setText("");
    }
}