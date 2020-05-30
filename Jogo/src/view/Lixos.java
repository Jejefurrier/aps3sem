package view;

import conexao.conexaostmt;
import java.util.Random;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;


public class Lixos {
    String Imagem;
    int tipo;
    ImageIcon img;
    conexaostmt conexao = new conexaostmt();
    String[] ListaDeLixo = new String[]{ "casca_de_banana", "colher", "copo_plastico", "copo_vidro", "envelope", "garrafa_plastica", "garrafa_vidro", "isopor", "latas", "maça", "maçaneta", "mentos", "Ovo", "papel", "papelao", "pote_plastico", "pote_vidro", "prato_vidro", "sache_de_cha", "sacola_plastica", "tampa_garrafa", "tubo_de_cobre"};

    public void SetImage(JLabel label){
        img = new ImageIcon(getClass().getResource(GenerateRandomTrash()));
        label.setIcon(img);
    }

    public String GenerateRandomTrash(){
        Random random = new Random();
        ResultSet result = conexao.getImg(random.nextInt(22)+1);
            
        try {
            while(result.next()){
                Imagem = result.getString("caminho");
                tipo = result.getInt("tipo");
            } 
        } catch (SQLException ex) {
            System.out.println("Erro ao consumir resultado. " + ex);
                 
        }
        return Imagem;
    }

    public int GetTipo(){
        return this.tipo;
    }


}
