
package BLL;

import DAL.CopiaParaAlugarDAL;
import java.util.List;

public class CopiaParaAlugarBLL {
    
    private int codigo;
    private TituloBLL titulo;
    private PlataformaBLL plataforma;
    private int quantidade;
    private boolean ativo;
    
    private CopiaParaAlugarDAL cpaDAL = new CopiaParaAlugarDAL();

    public CopiaParaAlugarBLL() {
        this.plataforma = new PlataformaBLL();
        this.titulo = new TituloBLL();
    }
    
    // MÉTODOS
    public boolean Cadastrar() {
        return cpaDAL.Cadastrar(this);
    }
    
    /**
     * @return Retorna todas as copias para alugar cadastradas no banco de dados.
     * Preenche inclusive todas as informações do Título e da Plataforma relacionados à cada cópia.
     */
    public List<CopiaParaAlugarBLL> Consultar(){
        return cpaDAL.Consultar();
    }

    // ENCAPSULAMENTOS
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

    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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
