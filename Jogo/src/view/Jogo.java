package view;

import conexao.conexaostmt;

public class Jogo {
    protected String NomeJogador;
    protected int Pontuacao;
    protected int Nivel = 1;

    public Jogo (){
    }

    public void SalvarPartida(){
        conexaostmt con = new conexaostmt();
        con.inserirRanking(NomeJogador, Pontuacao);
    }

    public int GetNivel()
    {
        return Nivel;
    }

    public void AddNivel()
    {
        Nivel++;
    }
    public void SetName(String Name){
        NomeJogador = Name;
    }

}
