
package BLL;

import DAL.TipoAcessorioDAL;
import java.util.List;

public class TipoAcessorioBLL {
    
    private int codigo;
    private String nome;
    private boolean ativo;
    
    private TipoAcessorioDAL taDAL = new TipoAcessorioDAL();

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
    public List<TipoAcessorioBLL> Consultar(){
        return taDAL.Consultar();
    }

    public boolean Cadastrar() {
        return taDAL.Cadastrar(this);
    }
    
}
