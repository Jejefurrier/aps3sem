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

public class Movimento {

    //Chame no inicio de cada rodada pra gerar a posição X do lixo de forma aleatoria
    void setInitialPosition(JLabel label){
        Random random = new Random();
        int valor = random.nextInt(5) * 85; //Gera um número aleatorio entre 0 e 5 e multiplica por 10 pra pegar a posição certa
        System.out.println("Numero aleatorio " + valor);
        if(valor == 0)
            valor = 80;
        label.setBounds(valor, 0, 50,50);
    }
    //Chame no evento keypress da seta pra DIREITA, ele vai receber a atual posição X do lixo e vai retornar a nova posição dele
    void WalkRight(JLabel label){
        if(label.getX() >= 640) {
        }else{
            label.setBounds(label.getX() + 1, label.getY(), 50,50);
        }
        System.out.println(label.getX());
    }
    //Chame no evento keypress da seta pra ESQUERDA, ele vai receber a atual posição X do lixo e vai retornar a nova posição dele
    void WalkLeft(JLabel label){
        if(label.getX() <= 80) {
        }else{
            label.setBounds(label.getX() - 1, label.getY(), 50,50);
        }
        System.out.println(label.getX());
    }
    void FallLixo(JLabel label){
        label.setBounds(label.getX(), label.getY() + 1, 50, 50);
    }

}
