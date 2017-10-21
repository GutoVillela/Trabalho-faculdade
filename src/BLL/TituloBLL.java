/*
 * CLASSE BLL PARA GERENCIAR TÍTULOS DOS JOGOS
 */
package BLL;

import DAL.TituloDAL; // IMPORTAR CLASSE DAL CORRESPONDENTE
import java.util.List;

public class TituloBLL {
    
    private int codigo;
    private String nome;
    private String sinopse;
    private boolean ativo;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the sinopse
     */
    public String getSinopse() {
        return sinopse;
    }

    /**
     * @param sinopse the sinopse to set
     */
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    /**
     * @return the ativo
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    // MÉTODOS
    
    /**
     * @return Retorna TRUE se o cadastro for efetuado com sucesso, e FALSE caso não seja.
     */
    public boolean Cadastrar(){
        TituloDAL tDAL = new TituloDAL();
        
        if (tDAL.Cadastrar(this)) {
            return true;
        }
        else{
            return false;
        } 
    }
    
    /**
     * @return Retorna uma lista com todos os títulos cadastrados no banco de dados.
     */
    public List<TituloBLL> Consultar(){
        TituloDAL tDAL = new TituloDAL();
        return tDAL.Consultar();
    }
}
