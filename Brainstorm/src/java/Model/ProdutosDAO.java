package Model;
import Model.Conexao;
import java.sql.*;

public class ProdutosDAO {
    
    private String nome;
    private String unidade;
    private String valor;
    
    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getUnidade() 
    {
        return unidade;
    }

    public void setUnidade(String unidade) 
    {
        this.unidade = unidade;
    }

    public String getValor() 
    {
        return valor;
    }

    public void setValor(String valor) 
    {
        this.valor = valor;
    }
    
    public ProdutosDAO(String nome, String unidade, String valor)
    {
       this.nome = nome; 
       this.unidade = unidade;
       this.valor = valor;
    }
    
    public boolean inserirProdutos()
    {
       boolean retorno = false;
       Conexao conexao = new Conexao();
       Connection conn = conexao.getConexao(); //faz conexão com o banco de dados
       
       if(conn != null)
       {
          PreparedStatement p;
          try
          {
             p = conn.prepareStatement("insert into produto (Nome,unidade,valor) values (?,?,?)");
             //seta os campos da query SQL
             p.setString(1,getNome());
             p.setString(2,getUnidade());
             p.setString(3,getValor());
             
             if(p.executeUpdate() > 0)  //Executa a query e se conseguir gravar no banco atribui true no retorno
                retorno = true;
          }
          catch(SQLException ex)
          {
             System.err.println("Falha na operação: " + ex.getMessage());
          }
          finally
          {
             conexao.fecharConexao(); //fecha a conexão com o banco de dados
          }
       }
       return retorno;
    }
    
    public void alterarProdutos()
    {
        
    }
        
    public void excluirProdutos()
    {
    
    }
    
    public void consultarProdutos()
    {
        
    } 
}

