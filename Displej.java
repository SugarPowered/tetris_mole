import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.sound.sampled.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;

public class Displej extends JFrame implements ActionListener{
    private JButton playTlacitko = new JButton("Play");
    private JButton exitTlacitko = new JButton("Exit");
    private JLabel label = new JLabel();
    private Container c;
    private Hudba hudbaHrajMenu = new Hudba();
    
    public Displej() throws UnsupportedAudioFileException, IOException, LineUnavailableException{
        //pri pridávaní tlačítok, textu, atď, to bude robiť tak
        //ako keď by sme písali (z ľava do prava)
        setLayout(new FlowLayout());
        //s týmto príkazom môžem presúvať ľubovolne objekty na obrazovke
        setLayout(null);
        //nastavý veľkosť okna
        setSize(600, 600);
        //nastavenie farby pozadia okna
        getContentPane().setBackground(Color.BLACK);
        //nastavý názov "programu"
        setTitle("Tetris");
        //nastavenie okna do stredu obrazovky
        setLocationRelativeTo(null);
        //zatvorenie a vypnutie programu cez krížik v pravo hore
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        //vykreslenie obrázku
        this.c = getContentPane();
        this.label.setIcon(new ImageIcon("logo.png"));
        this.label.setBounds(200, 60, 200, 200);
        c.add(this.label);
        
        //nastavenie polohy tlačítok
        //najprv súradnice na obrazovke, potom rozmery tlačítka
        this.playTlacitko.setBounds(250, 275, 100, 50);
        add(playTlacitko);
        this.playTlacitko.addActionListener(this);
        
        this.exitTlacitko.setBounds(250, 350, 100, 50);
        add(exitTlacitko);
        this.exitTlacitko.addActionListener(this);
        
        //hranie hudby
        this.hudbaHrajMenu.hudbaMenu();
        
        //nastavenie vyditeľnosti okna
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.playTlacitko) {
            //this.playTlacitko.setVisible(false);
            //provizorne umiestnenie exit tlačitka, zmeniť podľa hracej plochy
            //this.exitTlacitko.setBounds(375, 350, 75, 50);
           
            //this.label.setVisible(false);
            //this.exitTlacitko.setVisible(false);
            //getContentPane().removeAll();
            //getContentPane().repaint();
            Platno platno = new Platno("Tetris", 290, 500, Color.white).dajPlatno();
        } else if (e.getSource() == this.exitTlacitko) {
            System.exit(1);
        }
    }
    
    
}
