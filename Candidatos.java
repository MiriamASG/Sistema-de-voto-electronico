package elecciones;

import Clases.conectar;
import java.sql.Connection;
import javax.swing.ButtonGroup;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Candidatos extends javax.swing.JFrame {
    private static conectar con;
    public static final String driver = "com.mysql.jdbc.Driver";
    public static final String url = "jdbc:mysql://localhost:3307/tienda";
    public static final String usuario = "root";
    public static final String contraseña = "";
    ButtonGroup grupoBotones; 
    private String candidatoSeleccionado;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelCandidato;
    private javax.swing.JLabel labelLista;
    private static int dniVotante;
   
     public int convertirDNANumero(String dni) {
    try {  
        return Integer.parseInt(dni);
    } 
    catch (NumberFormatException e) {
        return -1; // Valor inválido
    }
}
    public static int getDocument()
    {
        return dniVotante;
    }
    public static void setDocument(int dni)
    {
        dniVotante = dni;
    }
    public Candidatos() {
        initComponents();
        this.setLocationRelativeTo(null);
        grupoBotones = new ButtonGroup();
            grupoBotones.add(milei);
            grupoBotones.add(jRadioButton8);
            grupoBotones.add(jRadioButton9);
            grupoBotones.add(jRadioButton10);
            grupoBotones.add(jRadioButton11);
            grupoBotones.add(jRadioButton12);
            
            labelNombre = new javax.swing.JLabel();
            labelCandidato = new javax.swing.JLabel();
            labelLista = new javax.swing.JLabel();
    }
    
    private void cargarDatosCandidato(int candidatoId) {
    try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
        String consulta = "SELECT NOMBRE, CANDIDATO, LISTA FROM presidente WHERE ID = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(consulta)) {
            preparedStatement.setInt(1, candidatoId);
            try (ResultSet resultado = preparedStatement.executeQuery()) {
                if (resultado.next()) {
                    String nombre = resultado.getString("NOMBRE");
                    String candidato = resultado.getString("CANDIDATO");
                    String lista = resultado.getString("LISTA");

                    // ETIQUETAS
                    labelNombre.setText("NOMBRE: " + nombre);
                    labelCandidato.setText("CANDIDATO: " + candidato);
                    labelLista.setText("LISTA: " + lista);
                }
            }
        }
    }
    catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al cargar datos desde la base de datos: " + e.getMessage());
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        milei = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jRadioButton9 = new javax.swing.JRadioButton();
        jRadioButton10 = new javax.swing.JRadioButton();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        votebotton1 = new javax.swing.JButton();

        jLabel1.setText("Elecciones 2023");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Candidatos a Presidente");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 60, -1, -1));

        jLabel9.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 51, 0));
        jLabel9.setText("Elecciones 2023");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        milei.setBackground(new java.awt.Color(255, 255, 255));
        milei.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        milei.setForeground(new java.awt.Color(0, 0, 0));
        milei.setText("Javier Milei");
        milei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mileiActionPerformed(evt);
            }
        });
        jPanel1.add(milei, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        jRadioButton8.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton8.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jRadioButton8.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton8.setText("Sergio Massa");
        jPanel1.add(jRadioButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jRadioButton9.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton9.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jRadioButton9.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton9.setText("Patricia Bullrich");
        jPanel1.add(jRadioButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, 21));

        jRadioButton10.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton10.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jRadioButton10.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton10.setText("Juan Schiaretti");
        jPanel1.add(jRadioButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jRadioButton11.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton11.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jRadioButton11.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton11.setText("Myriam Bregman");
        jRadioButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton11ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        jRadioButton12.setBackground(new java.awt.Color(255, 255, 255));
        jRadioButton12.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jRadioButton12.setForeground(new java.awt.Color(0, 0, 0));
        jRadioButton12.setText("Voto en blanco");
        jRadioButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, 150, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(51, 51, 51));
        jLabel10.setText("Libertad Avanza");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Unión por la Patria");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(51, 51, 51));
        jLabel12.setText("Juntos por el Cambio");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(51, 51, 51));
        jLabel13.setText("Hacemos por nuestro país");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(51, 51, 51));
        jLabel14.setText("Frente de Izquierda");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 410, -1, -1));

        votebotton1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        votebotton1.setForeground(new java.awt.Color(255, 51, 0));
        votebotton1.setText("Votar");
        votebotton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                votebotton1ActionPerformed(evt);
            }
        });
        jPanel1.add(votebotton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 510, 110, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String obtenerCandidatoSeleccionado() {
    if (milei.isSelected()) {
        return milei.getText();
    }
    else if (jRadioButton8.isSelected()) {
        return jRadioButton8.getText();
    }
    else if (jRadioButton9.isSelected()) {
        return jRadioButton9.getText();
    }
    else if (jRadioButton10.isSelected()) {
        return jRadioButton10.getText();
    }
    else if (jRadioButton11.isSelected()) {
        return jRadioButton11.getText();
    }
    else if (jRadioButton12.isSelected()) {
        return jRadioButton12.getText();
    }
    return null; //SI NO SE SELECCIONA EL CANDIDATO.
}
    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here: 
    }//GEN-LAST:event_formWindowActivated

    private void mileiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mileiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mileiActionPerformed

    private void votebotton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_votebotton1ActionPerformed
    if(milei.isSelected()||jRadioButton8.isSelected()||jRadioButton9.isSelected()||jRadioButton10.isSelected()||jRadioButton11.isSelected()||jRadioButton12.isSelected()){  
           JOptionPane.showMessageDialog(this, "Usted voto exitosamente a " + obtenerCandidatoSeleccionado()); 
           Elecciones elecc=new Elecciones();
           elecc.setVisible(true);
           this.dispose();
    }
    else{
            JOptionPane.showMessageDialog(this, "Seleccione una opcion.");
            System.out.println("Seleccionar candidato");
            return;
    }
             String obtenerVotos = "SELECT votos FROM Presidentes WHERE Nombre = ?";
             String consulta = "UPDATE Presidentes SET votos = ? WHERE Nombre = ?";
             String votado="UPDATE Persona SET voto=? where Dni=?";
             int cantidadVotos = 0;
               conectar con = new conectar();
         try{
             PreparedStatement ps = con.getConnection().prepareStatement(obtenerVotos);
             ps.setString(1, obtenerCandidatoSeleccionado());
             ResultSet rs = ps.executeQuery();
             if (rs.next())
             {cantidadVotos = rs.getInt(1);
             }
         }
         catch(Exception e){
             System.out.println("Error al votar!"); 
         }
         try{
             PreparedStatement ps = con.getConnection().prepareStatement(consulta);
             ps.setInt(1, cantidadVotos + 1);
             ps.setString(2, obtenerCandidatoSeleccionado());
             ps.executeUpdate();
         }
         catch(Exception e){System.out.println("Error al votar!");
         }
         try{
             PreparedStatement ps = con.getConnection().prepareStatement(votado);
             ps.setInt(1, 1);
             ps.setInt(2, dniVotante);
             ps.executeUpdate();
         }
         catch(Exception e){
             System.out.println(e);
         }   
    }//GEN-LAST:event_votebotton1ActionPerformed

    private void jRadioButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton12ActionPerformed
        // TODO add your handling code here: 
    }//GEN-LAST:event_jRadioButton12ActionPerformed

    private void jRadioButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton11ActionPerformed

    private int obtenerIdCandidato(String nombreCandidato) {
    int idCandidato = -1;

    try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
        String sql = "SELECT ID FROM presidente WHERE NOMBRE = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1, nombreCandidato);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    idCandidato = resultSet.getInt("ID");
                }
            }
        }
    }
    catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage());
    }
    return idCandidato;
}      
    private void registrarVotoEnBaseDeDatos() {

    try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
        String sql = "INSERT INTO votacion (DNI, CANDIDATO, FECHA_HORA) VALUES (?, ?, NOW())";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, dniVotante);
            preparedStatement.setString(2, candidatoSeleccionado);

            int filasAfectadas = preparedStatement.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(this, "¡Voto registrado con éxito!");
            } 
            else {
                JOptionPane.showMessageDialog(this, "Error al registrar el voto.");
            }
        }
    } 
    catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos: " + e.getMessage());
    }
}
    public static void main2(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } 
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Candidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Candidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Candidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } 
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Candidatos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Candidatos().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton10;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JRadioButton jRadioButton9;
    private javax.swing.JRadioButton milei;
    private javax.swing.JButton votebotton1;
    // End of variables declaration//GEN-END:variables
}
