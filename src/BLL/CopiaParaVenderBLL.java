
package BLL;

import DAL.CopiaParaVenderDAL;

public class CopiaParaVenderBLL extends ProdutoBLL{
    
    private TituloBLL titulo;
    private PlataformaBLL plataforma;
    
    private CopiaParaVenderDAL cpvDAL = new CopiaParaVenderDAL(); 
    
    public CopiaParaVenderBLL() {
        this.titulo = new TituloBLL();
        this.plataforma = new PlataformaBLL();
    }

    /**
     * @return the titulo
     */
    public TituloBLL getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(TituloBLL titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the plataforma
     */
    public PlataformaBLL getPlataforma() {
        return plataforma;
    }

    /**
     * @param plataforma the plataforma to set
     */
    public void setPlataforma(PlataformaBLL plataforma) {
        this.plataforma = plataforma;
    }

    // MÉTODOS
    
    public boolean Cadastrar(){
        super.Cadastrar();
        this.setCodigo(super.RecuperarUltimaChavePrimaria());
        return cpvDAL.Cadastrar(this);
    }
    
    
}
