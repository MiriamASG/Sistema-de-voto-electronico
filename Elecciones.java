package elecciones;

import Clases.conectar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import javax.swing.ButtonGroup;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.DriverManager;

public class Elecciones extends javax.swing.JFrame {
    private static conectar con;
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3307/tienda";
    public static final String usuario = "root";
    public static final String contraseña = "";
    public boolean votoRegistrado;
    private boolean xx;
    
    private Candidatos candidatosFrame;
    
    public Elecciones() {    
    initComponents();
    this.setLocationRelativeTo(null);
    //this.candidatosFrame = new Candidatos(0);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField3 = new javax.swing.JTextField();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        jPanel1 = new javax.swing.JPanel();
        textelecc1 = new javax.swing.JLabel();
        textpadron1 = new javax.swing.JLabel();
        DNItext1 = new javax.swing.JLabel();
        consultelecc1 = new javax.swing.JButton();
        textareaDNI1 = new javax.swing.JTextField();
        name1 = new javax.swing.JLabel();
        lastname1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        disabledshowlastname1 = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        disableshowname1 = new javax.swing.JTextPane();
        eleccsig1 = new javax.swing.JButton();

        jTextField3.setText("jTextField2");

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textelecc1.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        textelecc1.setForeground(new java.awt.Color(255, 51, 0));
        textelecc1.setText("ELECCIONES 2023");
        jPanel1.add(textelecc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 250, -1));

        textpadron1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        textpadron1.setForeground(new java.awt.Color(255, 51, 0));
        textpadron1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elecciones/fotos/icons8_Search_32px_2.png"))); // NOI18N
        textpadron1.setText("Consulta de Padrón");
        jPanel1.add(textpadron1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        DNItext1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        DNItext1.setForeground(new java.awt.Color(255, 51, 0));
        DNItext1.setText("DNI");
        jPanel1.add(DNItext1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 94, -1, -1));

        consultelecc1.setForeground(new java.awt.Color(255, 51, 0));
        consultelecc1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elecciones/fotos/icons8_Search_32px_2.png"))); // NOI18N
        consultelecc1.setText("Consultar");
        consultelecc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultelecc1ActionPerformed(evt);
            }
        });
        jPanel1.add(consultelecc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        textareaDNI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textareaDNI1ActionPerformed(evt);
            }
        });
        jPanel1.add(textareaDNI1, new org.netbeans.lib.awtextra.AbsoluteConstraints(172, 90, 140, 30));

        name1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        name1.setForeground(new java.awt.Color(255, 51, 0));
        name1.setText("Nombre");
        jPanel1.add(name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 150, -1, -1));

        lastname1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lastname1.setForeground(new java.awt.Color(255, 51, 0));
        lastname1.setText("Apellido");
        jPanel1.add(lastname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 202, -1, -1));

        disabledshowlastname1.setBackground(new java.awt.Color(204, 204, 204));
        disabledshowlastname1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane3.setViewportView(disabledshowlastname1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, 180, 30));

        disableshowname1.setEditable(false);
        disableshowname1.setBackground(new java.awt.Color(204, 204, 204));
        disableshowname1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane4.setViewportView(disableshowname1);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 150, 180, 30));

        eleccsig1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        eleccsig1.setForeground(new java.awt.Color(255, 102, 0));
        eleccsig1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elecciones/fotos/icons8_Next_page_64px_1.png"))); // NOI18N
        eleccsig1.setText("Siguiente");
        eleccsig1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eleccsig1ActionPerformed(evt);
            }
        });
        jPanel1.add(eleccsig1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 170, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 580, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void registrarVotoenBaseDeDatos() {
    try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
        String sql = "INSERT INTO padron (VOTO) VALUES (true)";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setBoolean(1, votoRegistrado);
            
            if (votoRegistrado == true) {
                JOptionPane.showMessageDialog(this, "Comienza a votar!");  
            } 
            else {
                JOptionPane.showMessageDialog(this, "Error al registrar el voto.");
            }
        }
    }
    catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "No se registró voto en base de datos:" + e.getMessage());
    }
}
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void consultelecc1ActionPerformed(java.awt.event.ActionEvent evt) {                                              
        String yaVoto="SELECT VOTO FROM persona WHERE DNI=?"; 
        String elecc="SELECT NOMBRE, APELLIDO, VOTO FROM persona WHERE DNI = ?";
        String dniIngresado = textareaDNI1.getText();
        
        if(dniIngresado.isEmpty()){
        JOptionPane.showMessageDialog(null, "Ingrese un DNI");
        return;
        }
        try{
        conectar con = new conectar();
        PreparedStatement ps = con.getConnection().prepareStatement(yaVoto);
        ps.setString(1, dniIngresado);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {   
            if(rs.getInt(1)==1){
            this.xx=true;
            }
        }
        }
        catch(Exception e){  
        }

     try {
        conectar con = new conectar();
        PreparedStatement ps = con.getConnection().prepareStatement(elecc);
        ps.setString(1, dniIngresado);
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            String nombreEncontrado = rs.getString("nombre");
            String apellidoEncontrado = rs.getString("apellido");
            
            disableshowname1.setText(nombreEncontrado);
            disabledshowlastname1.setText(apellidoEncontrado);    
        } 
        else {
            JOptionPane.showMessageDialog(null, "No se encontraron registros con el DNI ingresado.");
        }
    } 
     catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + e.getMessage());
    }
    }                                             

    private void textareaDNI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textareaDNI1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textareaDNI1ActionPerformed

    private void eleccsig1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eleccsig1ActionPerformed
        // TODO add your handling code here:
                           
        if(this.xx){
            JOptionPane.showMessageDialog(null, "El usuario encontrado ya voto");
            return;
        }
        else
        {
                Candidatos cand=new Candidatos();
                           cand.setVisible(true);
                           this.dispose();
                Candidatos.setDocument(Integer.parseInt(textareaDNI1.getText()));
        }
    }//GEN-LAST:event_eleccsig1ActionPerformed

    public static void main1(String args[]) {
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
            java.util.logging.Logger.getLogger(Elecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Elecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Elecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Elecciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Elecciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel DNItext1;
    private javax.swing.JButton consultelecc1;
    private javax.swing.JTextPane disabledshowlastname1;
    private javax.swing.JTextPane disableshowname1;
    private javax.swing.JButton eleccsig1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lastname1;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JLabel name1;
    private javax.swing.JTextField textareaDNI1;
    private javax.swing.JLabel textelecc1;
    private javax.swing.JLabel textpadron1;
    // End of variables declaration//GEN-END:variables
}
