package view;

import java.util.Random;
import javax.swing.*;

public class Movimento {
    private int[] Posicoes = new int[]{80, 240, 400, 560, 720};
    //Chame no inicio de cada rodada pra gerar a posição X do lixo de forma aleatoria
    void setInitialPosition(JLabel label){
        Random random = new Random();
        int valor = Posicoes[random.nextInt(5)]-25; //Gera um número aleatorio entre 0 e 5 e multiplica por 10 pra pegar a posição certa
        if(valor == 0)
            valor = 80;
        label.setBounds(valor, 0, 50,50);
    }
    //Chame no evento keypress da seta pra DIREITA, ele vai receber a atual posição X do lixo e vai retornar a nova posição dele
    void WalkRight(JLabel label){
        if(label.getX() >= 640) {
        }else{
            label.setBounds(label.getX() + 160, label.getY(), 50,50);
        }
    }
    //Chame no evento keypress da seta pra ESQUERDA, ele vai receber a atual posição X do lixo e vai retornar a nova posição dele
    void WalkLeft(JLabel label){
        if(label.getX() <= 80) {
        }else{
            label.setBounds(label.getX() - 160, label.getY(), 50,50);
        }
    }
    void FallLixo(JLabel label){
        label.setBounds(label.getX(), label.getY() + 1, 50, 50);
    }

}
