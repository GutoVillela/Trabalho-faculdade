
package BLL;

import DAL.PlataformaDAL;
import java.util.List;

public class PlataformaBLL {
    
    private int codigo;
    private String plataforma;
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
     * @return the plataforma
     */
    public String getPlataforma() {
        return plataforma;
    }

    /**
     * @param plataforma the plataforma to set
     */
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
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
    
    /**
     * @return Retorna uma lista com todas as plataformas cadastradas no banco de dados.
     */
    public List<PlataformaBLL> Consultar(){
        PlataformaDAL pDAL = new PlataformaDAL();
        return pDAL.Consultar();
    }
    
    /**
     * @return Retorna TRUE se o cadastro for efetuado com sucesso, e FALSE caso não seja.
     */
    public boolean Cadastrar(){
        PlataformaDAL pDAL = new PlataformaDAL();
        
        if (pDAL.Cadastrar(this)) {
            return true;
        }
        else{
            return false;
        } 
    }
    
}
