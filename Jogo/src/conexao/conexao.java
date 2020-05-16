package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author vini_
 */
public class conexao {
    private Connection conexao;
    private Statement stmt = null;
    private ResultSet resultSet = null;
    private PreparedStatement stmtprep = null;
    
    protected boolean conectar(){
        /* Conecta ao banco */
        try{
            String url = "jdbc:sqlite:bd/bd_jogo.db";
            
            this.conexao = DriverManager.getConnection(url);
        }catch(SQLException e){
            System.out.println("Falha ao conectar ao servidor. " + e);
        }
        System.out.println("Conectou");
        return true;
    }
    
    public boolean desconectar(){
        /* Fecha tudo que pode estar aberto, para não comprometer performance*/
        try{
            if(this.resultSet != null){
              if(this.resultSet.isClosed() == false){
                this.resultSet.close();
              }  
            }
            if(this.stmt != null){
              if(this.stmt.isClosed() == false){
                this.stmt.close();
              }  
            }
            if(this.stmtprep != null){
              if(this.stmtprep.isClosed() == false){
                this.stmtprep.close();
              }  
            }
            if(this.conexao != null){
              if(this.conexao.isClosed() == false){
                this.conexao.close();
              }
            }
            
        }catch(SQLException e){
            System.out.println("Falha ao conectar ao servidor. " + e);
        }
        System.out.println("Desconectou");
        return true;
    }
    
    protected Statement criarStatement(){
        /* Cria o statement que não recebe parametro */
        try{
            boolean conectou = this.conectar();
            if(conectou){
                return this.conexao.createStatement();
            }
            return null;
        }catch(SQLException e){
            System.out.println("Falha ao conectar ao servidor. " + e);
            return null;
        }
    }
    
    protected PreparedStatement criarStatementPrep(String sql){
        /* Cria o statement que irá receber parametros */
        try{
            boolean conectou = this.conectar();
            if(conectou){
                return this.conexao.prepareStatement(sql);
            }
            return null;
        }catch(SQLException e){
            System.out.println("Falha ao conectar ao servidor. " + e);
            return null;
        }
    }
    
    public boolean inserirRanking(String nome, int pontuacao){
        /* Método que irá inserir a pontuação do jogador ao final de seu jogo */
        String sql = "INSERT INTO ranking (nome, pontuacao) VALUES (?,?);";
        this.stmtprep = this.criarStatementPrep(sql);
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
}
