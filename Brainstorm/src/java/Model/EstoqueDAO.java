package Model;
import Model.Conexao;
import java.sql.*;

public class EstoqueDAO {
    
    private int quantidade;
    private int estMinimo;
    
    public int getQuantidade() 
    {
        return quantidade;
    }

    public void setQuantidade(int quantidade) 
    {
        this.quantidade = quantidade;
    }

    public int getEstMinimo() 
    {
        return estMinimo;
    }

    public void setEstMinimo(int estMinimo) 
    {
        this.estMinimo = estMinimo;
    }
    
    public EstoqueDAO(int quantidade, int estMinimo)
    {
       this.quantidade = quantidade; 
       this.estMinimo = estMinimo;
    }
    
    public boolean inserirEstoque()
    {
       boolean retorno = false;
       Conexao conexao = new Conexao();
       Connection conn = conexao.getConexao(); //faz conexão com o banco de dados
       
       if(conn != null)
       {
          PreparedStatement p;
          try
          {
             p = conn.prepareStatement("insert into estoque (Quantidade,estMinimo) values (?,?)");
             //seta os campos da query SQL
             p.setInt(1,getQuantidade());
             p.setInt(2,getEstMinimo());
             
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
    
    public void alterarEstoque()
    {
        
    }
        
    public void excluirEstoque()
    {
    
    }
    
    public void consultarEstoque()
    {
        
    } 
}


