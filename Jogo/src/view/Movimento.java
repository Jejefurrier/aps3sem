package view;

import java.util.Random;

public class Movimento {

    //Chame no inicio de cada rodada pra gerar a posição X do lixo de forma aleatoria
    float[] setInitialPosition(){
        Random random = new Random();
        int y = (random.nextInt(6) * 80); //Gera um número aleatorio entre 0 e 6 e multiplica por 10 pra pegar a posição certa
        float[] newPosition = new float[2]; //instancia um novo float pro return
        newPosition[0] = 0;
        newPosition[1] = y;
        return newPosition;
    }
    //Chame no evento keypress da seta pra DIREITA, ele vai receber a atual posição X do lixo e vai retornar a nova posição dele
    int WalkRight(int xPosition){
        if(xPosition >=800)
        {
            return xPosition;
        }// 0-9 PRIMEIRA COLUNA 10-19 SEGUNDA COLUNA, 20-29 TERCEIRA, 30-39 QUARTA 40-49 QUINTA 50-59
        return xPosition + 160;
    }
    //Chame no evento keypress da seta pra ESQUERDA, ele vai receber a atual posição X do lixo e vai retornar a nova posição dele
    int WalkLeft(int xPosition){
        if(xPosition <=0)
        {
            return xPosition;
        }// 0-9 PRIMEIRA COLUNA 10-19 SEGUNDA COLUNA, 20-29 TERCEIRA, 30-39 QUARTA 40-49 QUINTA 50-59
        return xPosition - 160;
    }
}
