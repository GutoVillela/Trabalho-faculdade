
package BLL;

public class CopiaParaAlugarBLL {
    
    private int codigo;
    private TituloBLL titulo;
    private PlataformaBLL plataforma;
    private int quantidade;
    private boolean ativo;

    public CopiaParaAlugarBLL() {
        this.plataforma = new PlataformaBLL();
        this.titulo = new TituloBLL();
    }
    
}
