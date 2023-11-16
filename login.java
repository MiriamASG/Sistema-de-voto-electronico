package elecciones;

import Clases.conectar;
import static elecciones.Elecciones.contraseña;
import static elecciones.Elecciones.url;
import static elecciones.Elecciones.usuario;
import java.sql.*;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.JOptionPane;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.LocalTime;

public class login extends javax.swing.JFrame {

    private static boolean VotacionesCerradas = false;
    private Connection miConnection;

    public login() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.jLabel6.setVisible(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usertext = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passtext = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 51, 0));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setText("INICIAR SESION");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 180, 30));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elecciones/fotos/icons8_customer_32px_1.png"))); // NOI18N
        jLabel2.setText("Usuario");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        usertext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usertextActionPerformed(evt);
            }
        });
        jPanel1.add(usertext, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 184, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elecciones/fotos/icons8_Key_32px.png"))); // NOI18N
        jLabel3.setText("Contraseña");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));
        jPanel1.add(passtext, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, 184, -1));

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 10)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 51, 0));
        jLabel6.setText("SE PERMITEN SOLO 6 CARACTERES");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elecciones/fotos/ICONS,personita.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 90, 80));

        jButton1.setBackground(new java.awt.Color(204, 51, 0));
        jButton1.setText("INGRESAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 320, 160, -1));

        jButton2.setBackground(new java.awt.Color(255, 51, 0));
        jButton2.setText("MOSTRAR RESULTADOS");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int cont = 0;
        String usu = usertext.getText();
        String pass = passtext.getText();
        String conectarpresi = "select Usuario,Pass from presidentes_demesa where Usuario =? and Pass=?";
        if (usu.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos completos");
            return;
        }
        try {
            conectar conec = new conectar();
            PreparedStatement ps = conec.getConnection().prepareStatement(conectarpresi);
            ps.setString(1, usu);
            ps.setString(2, pass);
            ResultSet usua = ps.executeQuery();//resultSet es un tipo de dato que realiza la consulta
            //ejecutarConsulta//
            if (usua.next()) {
                System.out.println("Usuario correcto");
                Elecciones elec = new Elecciones();
                elec.setVisible(true);
                this.dispose();
            } 
            else {
                System.out.println("Usuario incorrecto");
                JOptionPane.showMessageDialog(null, "Usuario incorrecto");
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public boolean areVotesEnabled() {
        ZoneId argentinaZone = ZoneId.of("America/Argentina/Buenos_Aires");
        ZonedDateTime nowInArgentina = ZonedDateTime.now(argentinaZone);
        ZonedDateTime sixPMInArgentina = nowInArgentina.with(LocalTime.of(18, 0));
        return nowInArgentina.isBefore(sixPMInArgentina);
    }
    private void usertextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usertextActionPerformed
    }//GEN-LAST:event_usertextActionPerformed
        private void CerrarVotacion() {
        String sqlCierre = "UPDATE presidentes_demesa SET Hora_cierre = NOW(), Cierre_Mesa = 1";

        try ( Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            conexion.setAutoCommit(false);
            try {
                try {
                    PreparedStatement preparedStatementCierre = conexion.prepareStatement(sqlCierre);
                    preparedStatementCierre.executeUpdate();
                } catch (SQLException e) {
                }
                conexion.commit();
                Incidencias.MostrarIncidencia("", "CIERRE DE MESA EXITOSO");
                JOptionPane.showMessageDialog(this, "Cierre de votacion exitoso.");
            } 
            catch (SQLException e) {
                conexion.rollback();
                JOptionPane.showMessageDialog(this, "Error en el proceso de cierre de mesa: " + e.getMessage());
                Incidencias.MostrarIncidencia("", "Error durante el cierre de mesa");
            } 
            finally {
                conexion.setAutoCommit(true);
            }
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error al cierre de votacion: " + e.getMessage());
            Incidencias.MostrarIncidencia("", "ERROR AL CERRAR VOTACIONES");
        }
    }
    private void CalcularEstadisticas() {
        String sqlEstadisticas = "SELECT Nombre, votos FROM presidentes";
        String sqlTotal = "SELECT SUM(votos) as total FROM presidentes";
        String user = usertext.getText();

        try ( Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            PreparedStatement preparedStatementEstadisticas = conexion.prepareStatement(sqlEstadisticas);
            PreparedStatement preparedStatementTotal = conexion.prepareStatement(sqlTotal);

            // Obtener el total de votos
            ResultSet resultSetTotal = preparedStatementTotal.executeQuery();
            resultSetTotal.next();
            int totalVotos = resultSetTotal.getInt("total");

            // Obtener votos por candidato
            ResultSet resultSet = preparedStatementEstadisticas.executeQuery();
            StringBuilder estadisticas = new StringBuilder("Porcentaje de votos por candidato: \n");

            while (resultSet.next()) {
                String candidato = resultSet.getString("Nombre");
                int votosRecibidos = resultSet.getInt("votos");
                double porcentaje = (double) votosRecibidos / totalVotos * 100;

                estadisticas.append(candidato)
                        .append(": ")
                        .append(votosRecibidos)
                        .append(" votos (")
                        .append(String.format("%.2f%%", porcentaje))
                        .append(")\n");
            }

            // Muestra los resultados en un mensaje
            JOptionPane.showMessageDialog(null, estadisticas.toString(), "Resultados de la votación", JOptionPane.INFORMATION_MESSAGE);

        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener estadísticas: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            Incidencias.MostrarIncidencia(user, "ERROR AL OBTENER ESTADÍSTICAS");
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        VotacionesCerradas = true;
        CerrarVotacion();
        CalcularEstadisticas();

        String user = usertext.getText();
        Incidencias.MostrarIncidencia(user, "MUESTRA LAS ESTADISTICAS");
        System.exit(0);
                                                

    }//GEN-LAST:event_jButton2ActionPerformed

    private void Conectar() {
        String ip = "localhost";
        String puerto = "3307";
        String baseDedatos = "tienda";//camelqueis
        String usuario = "root";
        String password = "";

        try//tipo de funcion que intenta hacer algo//al estilo while
        {
            miConnection = null;
            Class.forName("com.mysql.jdbc.Driver");//con esto activo el Drive descargado
            miConnection = DriverManager.getConnection("jdbc:mysql://" + ip + ":" + puerto + "/" + baseDedatos, usuario, password);

            if (miConnection != null) {
                System.out.println("Conexion exitosa");
                verificarDatos();
            }
        } 
        catch (ClassNotFoundException | SQLException e)//si la funcion try falla, pasa a realizar lo que esta dentro del catch
        {
            //"Exception" es un tipo de dato/variable que muestra los errores generales
            System.out.println("Errores: " + e); //el mas e es la variable en donde se guardo todos los errores
        }
    }
    private void verificarDatos() {
        String datos = "SELECT id, nombre FROM Prueba";
        try {
            PreparedStatement variable = null;
        }
        catch (Exception e) {
            System.out.println("Error al desconectar");
        }
    }
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                login ventanaLogin = new login();
                if (VotacionesCerradas) {
                    ventanaLogin.CalcularEstadisticas();
                    System.exit(0);
                } 
                else {
                    ventanaLogin.setVisible(true);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField passtext;
    private javax.swing.JTextField usertext;
    // End of variables declaration//GEN-END:variables
}
