
package BLL;

import DAL.EquipamentoManutencaoDAL; // IMPORTAÇÃO DA RESPECTIVA 

public class EquipamentoManutencaoBLL {
    
    private int codigo;
    private String nome;
    private TipoEquipamentoBLL tipo;
    private boolean ativo;
    
    private EquipamentoManutencaoDAL emDAL = new EquipamentoManutencaoDAL();

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
     * @return the tipo
     */
    public TipoEquipamentoBLL getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoEquipamentoBLL tipo) {
        this.tipo = tipo;
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
    
    //MÉTODOS
    
    public boolean Cadastrar(){
        if (emDAL.Cadastrar(this)) {
            return true;
        }
        else{
            return false;
        }
    }
    
}
