/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kayttoliittyma;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import muistio.tiedosto.TiedostoWelho;
import muistio.viinimuistio.Viini;

/**
 *
 * @author Sonja
 */
public class TiedostoWelhonHakuKuuntelija implements ActionListener {

    private TiedostoWelho tw;
    private ButtonGroup buttonGroup;
    private JTextField hakusanaKentta;

    public TiedostoWelhonHakuKuuntelija(TiedostoWelho tw, ButtonGroup buttonGroup, JTextField hakusanaKentta) {
        this.tw = tw;
        this.buttonGroup = buttonGroup;
        this.hakusanaKentta = hakusanaKentta;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            JFrame frame = new JFrame("Haun tulokset");
            frame.setPreferredSize(new Dimension(700, 500));
            frame.pack();
            frame.setVisible(true);
            luoHakutulos(frame.getContentPane());
        } catch (Exception ex) {
            Logger.getLogger(TiedostoWelhonHakuKuuntelija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void luoHakutulos(Container container) throws Exception {
        String valittu = "";
        for (Enumeration<AbstractButton> euhg = buttonGroup.getElements(); euhg.hasMoreElements();) {
            AbstractButton button = euhg.nextElement();
            if (button.isSelected()) {
                valittu += button.getText();
                switch (valittu) {
                    case "Nimi":
                        {                            
                            GridLayout layout = new GridLayout(4, 1);
                            container.setLayout(layout);
                            JLabel teksti = new JLabel("Tulokset:");
                            container.add(teksti);
                            String tulokset = "";
                            String vali = "---------------";
                            for (Viini v : tw.lueViinit().haeNimenMukaan(hakusanaKentta.getText())) {
                                tulokset += vali+"\n"+v.toString() + "\n" +
                                v.stringArvostelut()+ vali;                                
                            }
                            JTextArea tulos = new JTextArea(tulokset);
                            tulos.setEditable(false);
                            JScrollPane scroll = new JScrollPane(tulos);
                            container.add(scroll);
                            break;
                        }
                    case "Maa":
                        {
                            GridLayout layout = new GridLayout(4, 1);
                            container.setLayout(layout);
                            JLabel teksti = new JLabel("Tulokset:");
                            container.add(teksti);
                            List<Viini> haut = tw.lueViinit().haeMaanMukaan(hakusanaKentta.getText().toString());
                            String tulokset = "";
                            String vali = "---------------";
                            for (Viini v : haut) {
                                tulokset += vali+"\n"+v.toString() + "\n"+
                                        v.stringArvostelut()+vali;
                            }
                            JTextArea tulos = new JTextArea(tulokset);
                            tulos.setEditable(false);
                            JScrollPane scroll = new JScrollPane(tulos);
                            container.add(scroll);
                            break;
                        }
                    case "Hae kaikki valkoviinit":
                        {
                            GridLayout layout = new GridLayout(4, 1);
                            container.setLayout(layout);
                            JLabel teksti = new JLabel("Tulokset:");
                            container.add(teksti);
                            List<Viini> haut = tw.lueViinit().haeTyypinMukaan("valkoviini");
                            String tulokset = "";
                            for (Viini v : haut) {
                                tulokset += v.toString();
                            }
                            JTextArea tulos = new JTextArea(tulokset);
                            tulos.setEditable(false);
                            JScrollPane scroll = new JScrollPane(tulos);
                            container.add(scroll);
                            break;
                        } 
                    case "Hae kaikki punaviinit":
                        {
                            GridLayout layout = new GridLayout(4, 1);
                            container.setLayout(layout);
                            JLabel teksti = new JLabel("Tulokset:");
                            container.add(teksti);
                            List<Viini> haut = tw.lueViinit().haeTyypinMukaan("punaviini");
                            String tulokset = "";
                            for (Viini v : haut) {
                                tulokset += v.toString();
                            }
                            JTextArea tulos = new JTextArea(tulokset);
                            tulos.setEditable(false);
                            JScrollPane scroll = new JScrollPane(tulos);
                            container.add(scroll);
                            break;
                        }
                }
            }

        }
    }
     
     }

