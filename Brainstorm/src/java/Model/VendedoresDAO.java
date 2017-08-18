package Model;
import Model.Conexao;
import java.sql.*;

public class VendedoresDAO {
    
    private String nome;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;
    private String celular;
    private String cep;
    
    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public String getEndereco() 
    {
        return endereco;
    }

    public void setEndereco(String endereco) 
    {
        this.endereco = endereco;
    }

    public String getBairro() 
    {
        return bairro;
    }

    public void setBairro(String bairro) 
    {
        this.bairro = bairro;
    }

    public String getCidade() 
    {
        return cidade;
    }

    public void setCidade(String cidade) 
    {
        this.cidade = cidade;
    }

    public String getEstado() 
    {
        return estado;
    }

    public void setEstado(String estado) 
    {
        this.estado = estado;
    }

    public String getTelefone() 
    {
        return telefone;
    }

    public void setTelefone(String telefone) 
    {
        this.telefone = telefone;
    }

    public String getCelular() 
    {
        return celular;
    }

    public void setCelular(String celular) 
    {
        this.celular = celular;
    }

    public String getCep() 
    {
        return cep;
    }

    public void setCep(String cep) 
    {
        this.cep = cep;
    }
    
    public VendedoresDAO(String nome, String endereco, String bairro, String cidade, String estado, String telefone, String celular, String cep)
    {
       this.nome = nome; 
       this.endereco = endereco;
       this.bairro = bairro;
       this.cidade = cidade;
       this.estado = estado;
       this.telefone = telefone;
       this.celular = celular;
       this.cep = cep;
    }
    
    public boolean inserirVendedor()
    {
       boolean retorno = false;
       Conexao conexao = new Conexao();
       Connection conn = conexao.getConexao(); //faz conexão com o banco de dados
       
       if(conn != null)
       {
          PreparedStatement p;
          try
          {
             p = conn.prepareStatement("insert into vendedores (Nome,Endereco,Bairro,Cidade,Estado,Telefone,Celular,CEP) values (?,?,?,?,?,?,?,?)");
             //seta os campos da query SQL
             p.setString(1,getNome());
             p.setString(2,getEndereco());
             p.setString(3,getBairro());
             p.setString(4,getCidade());
             p.setString(5,getEstado());
             p.setString(6,getTelefone());
             p.setString(7,getCelular());
             p.setString(8,getCep());
             
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
    
    public void alterarVendedor()
    {
        
    }
        
    public void excluirVendedor()
    {
    
    }
    
    public void consultarVendedor()
    {
        
    } 
}
