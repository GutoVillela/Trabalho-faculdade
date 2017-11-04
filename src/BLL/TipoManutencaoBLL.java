package BLL;

import DAL.TipoManutencaoDAL;
import java.util.List;

public class TipoManutencaoBLL {
    
    private int codigo;
    private String tipoManutencao;
    private boolean ativo;
    
    private TipoManutencaoDAL tmDAL = new TipoManutencaoDAL();

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }
    
    // MÉTODOS
    public boolean Cadastrar(){
        return tmDAL.Cadastrar(this);
    }
    
    /**
     * @return Retorna uma lista com todos os tipos de manutenção cadastrados.
     */
    public List<TipoManutencaoBLL> Consultar(){
        return tmDAL.Consultar();
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the tipoManutencao
     */
    public String getTipoManutencao() {
        return tipoManutencao;
    }

    /**
     * @param tipoManutencao the tipoManutencao to set
     */
    public void setTipoManutencao(String tipoManutencao) {
        this.tipoManutencao = tipoManutencao;
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
    
}
