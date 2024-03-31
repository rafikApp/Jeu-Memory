
import java.awt.Frame;
import java.io.File;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author rharm
 */
public class AjouPersoDlg extends javax.swing.JDialog {

    
    private Personnage p;
    private boolean ok;
    
    /**
     * Creates new form AjouPersoDlg
     */
    public AjouPersoDlg(Frame parent, boolean modal) {
        super(parent,modal);
        initComponents();
        MPhoto.setText("ATTENTION: Un fichier.jpg avec le nom du persoonnage doit exister dans le repetoire src/memory/img du projet.");
        p=null;
        ok=false;
    }
    
    public boolean getOk(){
        return this.ok;
    }
     
    public Personnage getPerso(){
        return this.p;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Famille = new javax.swing.JTextField();
        Nom = new javax.swing.JTextField();
        Valeur = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        MPhoto = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        Annuler = new javax.swing.JButton();
        Valider = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Saisie d'un nouveau personnage ");
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setLayout(new java.awt.GridLayout(1, 2));

        jPanel4.setLayout(new java.awt.GridLayout(4, 0));

        jLabel2.setText("Famille ?");
        jPanel4.add(jLabel2);

        jLabel3.setText("Nom ?");
        jPanel4.add(jLabel3);

        jLabel4.setText("Valeur ?");
        jPanel4.add(jLabel4);

        jLabel5.setText("Photo :");
        jPanel4.add(jLabel5);

        jPanel2.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(4, 0));
        jPanel5.add(Famille);
        jPanel5.add(Nom);
        jPanel5.add(Valeur);

        MPhoto.setColumns(20);
        MPhoto.setRows(5);
        jScrollPane1.setViewportView(MPhoto);

        jPanel5.add(jScrollPane1);

        jPanel2.add(jPanel5);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.GridLayout(1, 2));

        Annuler.setText("Annuler");
        Annuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnnulerActionPerformed(evt);
            }
        });
        jPanel3.add(Annuler);

        Valider.setText("Valider");
        Valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ValiderActionPerformed(evt);
            }
        });
        jPanel3.add(Valider);

        getContentPane().add(jPanel3, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnnulerActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_AnnulerActionPerformed

    private void ValiderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ValiderActionPerformed
        // TODO add your handling code here:
        String fam = Famille.getText();
        String n = Nom.getText();
        int v= Integer.parseInt(Valeur.getText());
        MPhoto.setText("");
        String fich = new File("").getAbsolutePath()+"/src/memory/img/"+n+".jpg";
        File f = new File(fich);
        if(!f.isFile())
            MPhoto.setText("ATTENTION le fichier "+fich+"n'existe pas");
        else
        {
           this.p = new Personnage(fam,n,v);
           this.ok=true;
           this.setVisible(false);
           this.dispose();
        }
            
        
    }//GEN-LAST:event_ValiderActionPerformed

    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AjouPersoDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AjouPersoDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AjouPersoDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AjouPersoDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
             //new AjouPersoDlg(Frame parent, boolean modal).setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Annuler;
    private javax.swing.JTextField Famille;
    private javax.swing.JTextArea MPhoto;
    private javax.swing.JTextField Nom;
    private javax.swing.JTextField Valeur;
    private javax.swing.JButton Valider;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
