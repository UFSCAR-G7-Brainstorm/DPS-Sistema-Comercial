package Model;
import java.sql.*;

public class Conexao {
    
    private Connection conexao; //Usada para estabelecer uma conexao com o banco de dados
    
    public Conexao()
    {
       conexao = null;
       try
       {
          Class.forName("com.mysql.jdbc.Driver").newInstance(); //Define que usara um driver JDBC para conexao com banco de dados MySQL
	  conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/brainstorm?autoReconnect=true", "root", "123456"); //Faz a conexao com o banco de dados
       }
       catch (Exception excecao)
       {
          System.err.println("Erro ao tentar acesso com o banco: " + excecao.getMessage());
       }
    }
     
    // Esta funcao retorna uma conexao estabelecida com o banco de dados
    // @return conexao - A conexao estabelecida com o banco de dados 
    public Connection getConexao()
    {
      return conexao;
    }
       
    // Este procedimento fecha a conexao com o banco de dados 
    public void fecharConexao()
    {
       try
       {
          if( getConexao()!= null)
          {
             if(!conexao.isClosed()) 
                getConexao().close();
          }
       }
       catch (Exception excecao)
       {
           System.err.println("Erro ao fechar a conexao com o banco: " + excecao.getMessage());
       }
    } 
}
