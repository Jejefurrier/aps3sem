/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author vini_
 */
public class Principal extends JFrame {

    view.Movimento mov = new view.Movimento();
    Lixos lixos = new Lixos();
    boolean cair = true;

    ImageIcon fundo = new ImageIcon(getClass().getResource("/imgs/resources/Lixeiras.jpg"));
    JLabel bg = new JLabel(fundo);
    ImageIcon lixo = null;
    JLabel obj_lixo = new JLabel(lixo);
    Jogo jogo = new Jogo("KLEBERSON");

    String SelectedLixo;
    /** Creates new form Principal */
    public Principal() {
        lixos.SetImage(obj_lixo);
        bg.setBounds(0, 350, 800, 500);
        //obj_lixo.setBounds(100, 0, 50, 50);
        add(bg);
        add(obj_lixo);
        initComponents();
        GenerateNewTrash();
        mov.setInitialPosition(obj_lixo);

    }
    
    public void Control(){

        addKeyListener(new KeyListener(){
            @Override
            public void keyTyped(KeyEvent e){
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == 39){
                    mov.WalkRight(obj_lixo);
                }
                if(e.getKeyCode() == 37){
                    mov.WalkLeft(obj_lixo);
                }
                //obj_lixo.setBounds(x, y, 50, 50);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        });
    }
    
    public class Mover extends Thread{
        public void run(){
            if(cair){
                //cair = false;
                while(cair){
                    try{
                        sleep(10);
                        if(obj_lixo.getY() > 500){//pega se o objeto que ta caindo ta na altura das lixeiras
                            if(RightTrash(obj_lixo.getX(), 1)){ // SUBSTITUI O 1 PELO TIPO DO LIXO E VE SE AS POSIÇÕES DO LIXO TA CERTO



                                mov.setInitialPosition(obj_lixo);
                                
                                lixos.SetImage(obj_lixo);


    
                                //obj_lixo.setIcon(lixo);
                                jogo.Pontuacao++;
                            }else{
                                cair = false;

                            }


                        }
                    }catch(Exception e)
                    {
                        System.out.println("Erro ao mover elemento");
                    }
                    mov.FallLixo(obj_lixo);
                    //y+=1;
                    //obj_lixo.setBounds(x, y, 50, 50);
                }   
            }
            
        }
    }

    

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    public void GenerateNewTrash(){
        new Mover().start();
        Control();
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    public boolean RightTrash(int posX, int tipoLixo){

        if(posX < 50){
            return tipoLixo == 1;
        }
        if(posX >= 51 && posX< 100){
            return tipoLixo == 2;
        }
        if(posX >= 101 && posX < 150 ){
            return tipoLixo == 3;
        }
        if(posX >= 151 && posX < 200 ){
            return tipoLixo == 4;
        }
        if(posX >= 201 && posX < 250 ){
            return tipoLixo == 5;
        }


        return false;

    }

}
