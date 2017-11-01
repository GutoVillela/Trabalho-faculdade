
package BLL;

import DAL.AcessorioDAL;

public class AcessorioBLL extends ProdutoBLL {
    
    private TipoAcessorioBLL tipo;
    
    private AcessorioDAL aDAL = new AcessorioDAL();

    //CONSTRUTOR
    public AcessorioBLL() {
        this.tipo = new TipoAcessorioBLL();
    }
    
    //MÉTODOS
    public boolean Cadastrar(){
        super.Cadastrar();
        this.setCodigo(super.RecuperarUltimaChavePrimaria());
        return aDAL.Cadastrar(this);
        
    }
    
    /**
     * @return the tipo
     */
    public TipoAcessorioBLL getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(TipoAcessorioBLL tipo) {
        this.tipo = tipo;
    }
    
}
