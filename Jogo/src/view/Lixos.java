package view;

import java.util.Random;
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


public class Lixos {
    String Imagem;
    int tipo;
    ImageIcon img;
    String[] ListaDeLixo = new String[]{ "casca_de_banana", "colher", "copo_plastico", "copo_vidro", "envelope", "garrafa_plastica", "garrafa_vidro", "isopor", "latas", "maça", "maçaneta", "mentos", "Ovo", "papel", "papelao", "pote_plastico", "pote_vidro", "prato_vidro", "sache_de_cha", "sacola_plastica", "tampa_garrafa", "tubo_de_cobre"};

    public void SetImage(JLabel label){
        img = new ImageIcon(getClass().getResource("/imgs/resources/"+ GenerateRandomTrash() +".png"));
        label.setIcon(img);
    }

    public String GenerateRandomTrash(){
        Random random = new Random();
        return ListaDeLixo[random.nextInt(22)];
    }

    public void GetTipo(){
        
    }


}
