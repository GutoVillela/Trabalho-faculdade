
package BLL;

import DAL.TipoEquipamentoDAL; // IMPORTAÇÃO DA CLASSE DAL RESPECTIVA Á ESTA
import java.util.List;

public class TipoEquipamentoBLL {
    
    private int codigo;
    private String tipo;
    private boolean ativo;
    
    private TipoEquipamentoDAL teDAL = new TipoEquipamentoDAL();

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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
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
    
    // MÉTODOS
    public boolean Cadastrar(){
        if(teDAL.Cadastrar(this)){
            return true;
        }
        else{
            return false;
        }
    }
    
    public List<TipoEquipamentoBLL> Consultar(){
        return teDAL.Consultar();
    }
    
}
