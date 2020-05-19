/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vini_
 */
public class conexaostmt extends conexao{
    public boolean inserirRanking(String nome, int pontuacao){
        /* Método que irá inserir a pontuação do jogador ao final de seu jogo */
        String sql = "INSERT INTO ranking (nome, pontuacao) VALUES (?,?);";
        this.stmtprep = this.criarStatement(sql);
        try{
            this.stmtprep.setString(1, nome);
            this.stmtprep.setInt(2, pontuacao);
            int inseriu = this.stmtprep.executeUpdate();
            if(inseriu == 1){
                System.out.println("Inserido!");
                return true;
            }else{
                System.out.println("Não Inserido!");
                return false;
            }
        }catch(SQLException e){
            System.out.println("Falha ao conectar ao servidor. " + e);
            return false;
        }
    }
    
    public ResultSet getRanking(){
        /* Método para listar as pontuações dos jogadores */
        this.resultSet = null;
        this.stmt = null;
        try {
            String sql = "SELECT nome, pontuacao FROM ranking ORDER BY pontuacao desc;";
            this.stmt = this.criarStatement();
            this.resultSet = stmt.executeQuery(sql);
            return this.resultSet;
        } catch (SQLException e) {
            System.out.println("Falha ao conectar ao servidor. " + e);
            return null;
        }
    }
    
    public ResultSet getImg(int id){
        /* Método para selecionar uma imagem */
        this.resultSet = null;
        this.stmt = null;
        try {
            String sql = "SELECT nome, pontuacao FROM ranking WHERE id = ? ORDER BY pontuacao desc;";
            this.stmtprep = this.criarStatement(sql);
            this.stmtprep.setInt(1, id);
            this.resultSet = stmtprep.executeQuery();
            return this.resultSet;
        } catch (SQLException e) {
            System.out.println("Falha ao conectar ao servidor. " + e);
            return null;
        }
    }
}
