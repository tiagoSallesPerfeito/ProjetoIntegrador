
import br.edu.imepac.util.ConexaoBancoDeDados;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Matheus Carrasco
 */
public class MainTeste {
    
    public static void main(String[] args) throws SQLException{
        ConexaoBancoDeDados bd = new ConexaoBancoDeDados();
        
        bd.abrirConexao();
    }    
}
