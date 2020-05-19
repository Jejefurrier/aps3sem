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
    protected Statement stmt = null;
    protected ResultSet resultSet = null;
    protected PreparedStatement stmtprep = null;
    
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
    
    protected PreparedStatement criarStatement(String sql){
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
}
