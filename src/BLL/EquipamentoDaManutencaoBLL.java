
package BLL;

public class EquipamentoDaManutencaoBLL extends EquipamentoDoClienteBLL{
    
    private String defeito;
    private float orcamento;

    /**
     * @return the defeito
     */
    public String getDefeito() {
        return defeito;
    }

    /**
     * @param defeito the defeito to set
     */
    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }

    /**
     * @return the orcamento
     */
    public float getOrcamento() {
        return orcamento;
    }

    /**
     * @param orcamento the orcamento to set
     */
    public void setOrcamento(float orcamento) {
        this.orcamento = orcamento;
    }
    
}
