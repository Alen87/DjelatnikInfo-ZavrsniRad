/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package djelatnikinfo.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import djelatnikinfo.controller.ObradaDjelatnik;
import djelatnikinfo.controller.ObradaEdukacija;
import djelatnikinfo.model.Djelatnik;
import djelatnikinfo.model.DjelatnikEdukacija;
import djelatnikinfo.model.Edukacija;
import djelatnikinfo.util.AppException;
import djelatnikinfo.util.Pomocno;
import java.awt.event.KeyEvent;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Alen
 */
public class ProzorEdukacija extends javax.swing.JFrame {

    private ObradaEdukacija obrada;
    private ObradaDjelatnik obradaDjelatnik;

    /**
     * Creates new form ProzorEdukacija
     */
    public ProzorEdukacija() {
        initComponents();
        obrada = new ObradaEdukacija();
        obradaDjelatnik = new ObradaDjelatnik();
        postavke();
        ucitaj();

    }

    private void postavke() {

        setTitle(Pomocno.NAZIV_APLIKACIJE + " " + " Edukacije");
        prilagodiDatePicker();

        lstDjelatniciNaEdukaciji.setModel(new DefaultListModel<>());

    }

    private void ucitaj() {

        lstEntiteti.setModel(new DjelatnikListModel<>(obrada.read()));

    }

    private void prilagodiDatePicker() {
        DatePickerSettings dps = new DatePickerSettings(new Locale("hr", "HR"));
        dps.setFormatForDatesCommonEra(Pomocno.FORMAT_DATUMA);
        dps.setTranslationClear("Ocisti");
        dps.setTranslationToday("Danas");
        dpDatum.setSettings(dps);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstEntiteti = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txtNaziv = new javax.swing.JTextField();
        dpDatum = new com.github.lgooddatepicker.components.DatePicker();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtVoditeljEdukacije = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtTrajanjeEdukacije = new javax.swing.JTextField();
        btnDodaj = new javax.swing.JButton();
        btnPromjeni = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstDjelatniciNaEdukaciji = new javax.swing.JList<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taOcijena = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstDjelatniciUBazi = new javax.swing.JList<>();
        txtUvjet = new javax.swing.JTextField();
        btnTraziDjelatnika = new javax.swing.JButton();
        btnDodajDjelatnike = new javax.swing.JButton();
        btnObrisiDjelatnike = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstEntiteti.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstEntiteti.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEntitetiValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstEntiteti);

        jLabel1.setText("Naziv");

        jLabel2.setText("Datum");

        jLabel3.setText("Voditelj edukacije");

        jLabel4.setText("Trajanje edukacije (min)");

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        btnPromjeni.setText("Promjeni");
        btnPromjeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromjeniActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        lstDjelatniciNaEdukaciji.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lstDjelatniciNaEdukacijiKeyPressed(evt);
            }
        });
        lstDjelatniciNaEdukaciji.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDjelatniciNaEdukacijiValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstDjelatniciNaEdukaciji);

        jLabel5.setText("    Djelatnici na  edukaciji");

        taOcijena.setColumns(20);
        taOcijena.setRows(5);
        taOcijena.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                taOcijenaKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(taOcijena);

        jLabel6.setText("Ocijena djelatnika");

        jLabel7.setText("Djelatnici u bazi");

        lstDjelatniciUBazi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstDjelatniciUBaziMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(lstDjelatniciUBazi);

        txtUvjet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUvjetKeyPressed(evt);
            }
        });

        btnTraziDjelatnika.setText("Traži");
        btnTraziDjelatnika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziDjelatnikaActionPerformed(evt);
            }
        });

        btnDodajDjelatnike.setText("<");
        btnDodajDjelatnike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajDjelatnikeActionPerformed(evt);
            }
        });

        btnObrisiDjelatnike.setText(">");
        btnObrisiDjelatnike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiDjelatnikeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(txtNaziv, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(txtVoditeljEdukacije)
                                .addComponent(jLabel4)
                                .addComponent(txtTrajanjeEdukacije, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dpDatum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btnDodaj)
                        .addGap(18, 18, 18)
                        .addComponent(btnPromjeni, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnObrisi)))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDodajDjelatnike, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                            .addComponent(btnObrisiDjelatnike, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnTraziDjelatnika, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNaziv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dpDatum, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtVoditeljEdukacije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel4)
                                .addGap(12, 12, 12)
                                .addComponent(txtTrajanjeEdukacije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnDodaj)
                                    .addComponent(btnPromjeni)
                                    .addComponent(btnObrisi)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtUvjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTraziDjelatnika))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(btnDodajDjelatnike)
                                        .addGap(40, 40, 40)
                                        .addComponent(btnObrisiDjelatnike)))))
                        .addContainerGap(145, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstEntitetiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEntitetiValueChanged
        if (evt.getValueIsAdjusting() || lstEntiteti.getSelectedValue() == null) {
            return;
        }

        obrada.setEntitet(lstEntiteti.getSelectedValue());

        popuniView();
    }//GEN-LAST:event_lstEntitetiValueChanged

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        obrada.setEntitet(new Edukacija());
        popuniModel();

        try {
            obrada.create();
            ucitaj();
        } catch (AppException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }


    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnPromjeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromjeniActionPerformed
        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(rootPane, "Prvo  odaberite  stavku za  promjenu");
            return;
        }

        popuniModel();

        try {
            obrada.update();

            ucitaj();
        } catch (AppException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }
    }//GEN-LAST:event_btnPromjeniActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        if (obrada.getEntitet() == null) {
            JOptionPane.showMessageDialog(rootPane, "Prvo odaberite stavku  za brisanje");
            return;
        }

        popuniModel();

        try {
            obrada.delete();
            pocistiView();
            ucitaj();
        } catch (AppException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getPoruka());
        }


    }//GEN-LAST:event_btnObrisiActionPerformed

    private void pocistiView() {
        txtNaziv.setText("");
        dpDatum.setDate(null);
        txtVoditeljEdukacije.setText("");
        txtTrajanjeEdukacije.setText("");
        taOcijena.setText("");

    }


    private void lstDjelatniciNaEdukacijiValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDjelatniciNaEdukacijiValueChanged
        if (evt.getValueIsAdjusting()
                || lstDjelatniciNaEdukaciji.getSelectedValue() == null) {
            return;
        }

        taOcijena.setText(lstDjelatniciNaEdukaciji.getSelectedValue().getOcijena());

    }//GEN-LAST:event_lstDjelatniciNaEdukacijiValueChanged

    private void taOcijenaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taOcijenaKeyTyped
        if (lstDjelatniciNaEdukaciji.getSelectedValue() == null) {
            return;
        }

        var s = taOcijena.getText() + evt.getKeyChar();
        s = s.replace((char) 22, (char) 0);

        lstDjelatniciNaEdukaciji.getSelectedValue().setOcijena(s);

    }//GEN-LAST:event_taOcijenaKeyTyped

    private void btnTraziDjelatnikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziDjelatnikaActionPerformed

        List<Djelatnik>djelatnici = obradaDjelatnik.read(txtUvjet.getText().trim());
        
        lstDjelatniciUBazi.setModel(new DjelatnikListModel<>(djelatnici));
        
        if(djelatnici.isEmpty()){
           txtUvjet.requestFocus();
           return;
        }
        
        

        try {
            lstDjelatniciUBazi.setSelectedIndex(0);
        } catch (Exception e) {
            
        }
         lstDjelatniciNaEdukaciji.requestFocus();
    }//GEN-LAST:event_btnTraziDjelatnikaActionPerformed

    private void btnDodajDjelatnikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajDjelatnikeActionPerformed

        DefaultListModel<DjelatnikEdukacija> m = (DefaultListModel<DjelatnikEdukacija>) lstDjelatniciNaEdukaciji.getModel();

        for (Djelatnik d : lstDjelatniciUBazi.getSelectedValuesList()) {

            m.addElement(kreirajDjelatnikeNaEdukacijama(obrada.getEntitet(), d, ""));

        }

        lstDjelatniciNaEdukaciji.repaint();

    }//GEN-LAST:event_btnDodajDjelatnikeActionPerformed

    private DjelatnikEdukacija kreirajDjelatnikeNaEdukacijama(Edukacija e, Djelatnik d, String n) {
        DjelatnikEdukacija de = new DjelatnikEdukacija();
        de.setEdukacija(e);
        de.setDjelatnik(d);
        de.setOcijena(n);

        return de;
    }


    private void btnObrisiDjelatnikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiDjelatnikeActionPerformed

        DefaultListModel<DjelatnikEdukacija> m = (DefaultListModel<DjelatnikEdukacija>) lstDjelatniciNaEdukaciji.getModel();

        for (DjelatnikEdukacija de : lstDjelatniciNaEdukaciji.getSelectedValuesList()) {

            m.removeElement(de);

        }

        lstDjelatniciNaEdukaciji.repaint();


    }//GEN-LAST:event_btnObrisiDjelatnikeActionPerformed

    private void lstDjelatniciUBaziMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstDjelatniciUBaziMouseClicked

        if (evt.getClickCount() != 2) {
            return;
        }

        dodajDjelatnikeNaEdukaciju();

    }//GEN-LAST:event_lstDjelatniciUBaziMouseClicked

    private void dodajDjelatnikeNaEdukaciju() {
        
        if(lstDjelatniciUBazi.getSelectedValue()== null){
            return;
        }
        
        
        DefaultListModel<DjelatnikEdukacija> djelatniciNaEdukacijama = (DefaultListModel<DjelatnikEdukacija>) lstDjelatniciNaEdukaciji.getModel();

       
        for (int i = 0; i < djelatniciNaEdukacijama.getSize(); i++) {

            if (djelatniciNaEdukacijama.get(i).getDjelatnik().getSifra().equals(lstDjelatniciUBazi.getSelectedValue().getSifra())) {
                JOptionPane.showMessageDialog(rootPane, "Djelatnik je već  dodan na edukaciju");
                return;

            }

        }

        DefaultListModel<DjelatnikEdukacija> m = (DefaultListModel<DjelatnikEdukacija>) lstDjelatniciNaEdukaciji.getModel();
        m.addElement(kreirajDjelatnikeNaEdukacijama(obrada.getEntitet(), lstDjelatniciUBazi.getSelectedValue(), ""));
        txtUvjet.requestFocus();
        txtUvjet.selectAll();

    }


    private void txtUvjetKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjetKeyPressed
        if (evt.getKeyCode() != KeyEvent.VK_ENTER) {

            return;
        }

        btnTraziDjelatnikaActionPerformed(null);
       

    }//GEN-LAST:event_txtUvjetKeyPressed

    private void lstDjelatniciNaEdukacijiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lstDjelatniciNaEdukacijiKeyPressed
        if (evt.getKeyCode() != KeyEvent.VK_ENTER) {
            return;
        }

        dodajDjelatnikeNaEdukaciju();
    }//GEN-LAST:event_lstDjelatniciNaEdukacijiKeyPressed

    private void popuniModel() {
        var d = obrada.getEntitet();
        d.setNaziv(txtNaziv.getText());
        d.setDatum(dpDatum.getDate() != null
                ? Date.from(dpDatum.getDate()
                        .atStartOfDay()
                        .atZone(ZoneId.systemDefault())
                        .toInstant()
                ) : null
        );

        d.setVoditeljEdukacije(txtVoditeljEdukacije.getText());
        try {
            d.setTrajanjeEdukacijeMin(Integer.parseInt(txtTrajanjeEdukacije.getText()));
        } catch (Exception e) {

        }
        try {
            d.setTrajanjeEdukacijeMin(Integer.parseInt(txtTrajanjeEdukacije.getText()));
        } catch (Exception e) {
            d.setTrajanjeEdukacijeMin(0);
        }

        DefaultListModel<DjelatnikEdukacija> m = (DefaultListModel<DjelatnikEdukacija>) lstDjelatniciNaEdukaciji.getModel();

        List<DjelatnikEdukacija> noviDjelatniciNaEdukacijama = new ArrayList<>();
        for (int i = 0; i < m.getSize(); i++) {
            noviDjelatniciNaEdukacijama.add(m.getElementAt(i));
        }
        obrada.setNoviDjelatniciNaEdukacijama(noviDjelatniciNaEdukacijama);
    }

    private void popuniView() {
        var d = obrada.getEntitet();
        txtNaziv.setText(d.getNaziv());
        Pomocno.postaviDatum(dpDatum, d.getDatum());
        txtVoditeljEdukacije.setText(d.getVoditeljEdukacije());
        txtTrajanjeEdukacije.setText(String.valueOf(d.getTrajanjeEdukacijeMin()));

        lstDjelatniciNaEdukaciji.setModel(new DjelatnikListModel<>(d.getDjelatniciNaEdukacijama()));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnDodajDjelatnike;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnObrisiDjelatnike;
    private javax.swing.JButton btnPromjeni;
    private javax.swing.JButton btnTraziDjelatnika;
    private com.github.lgooddatepicker.components.DatePicker dpDatum;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JList<DjelatnikEdukacija> lstDjelatniciNaEdukaciji;
    private javax.swing.JList<Djelatnik> lstDjelatniciUBazi;
    private javax.swing.JList<Edukacija> lstEntiteti;
    private javax.swing.JTextArea taOcijena;
    private javax.swing.JTextField txtNaziv;
    private javax.swing.JTextField txtTrajanjeEdukacije;
    private javax.swing.JTextField txtUvjet;
    private javax.swing.JTextField txtVoditeljEdukacije;
    // End of variables declaration//GEN-END:variables

}
