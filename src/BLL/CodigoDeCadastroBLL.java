package BLL;

import DAL.CodigoDeCadastroDAL; // IMPORTAÇÃO DA RESPECTIVA CLASSE DAL

public class CodigoDeCadastroBLL {
    
    public static int qtdDeCodigosPreGerados = 0; // ESTE ATRIBUTO CONTA A QUANTIDADE DE CÓDIGOS QUE FORAM GERADOS MAS NÃO FORAM INCLUÍDOS NO BANCO DE DADOS AINDA
    
    private String codigoDeCadastro;
    private boolean utilizado;
    private CargoBLL cargo;
    private boolean ativo;
    
    private CodigoDeCadastroDAL ccDAL = new CodigoDeCadastroDAL();

    public CodigoDeCadastroBLL() {
        this.cargo = new CargoBLL();
    }

    /**
     * @return the codigoDeCadastro
     */
    public String getCodigoDeCadastro() {
        return codigoDeCadastro;
    }

    /**
     * @param codigoDeCadastro the codigoDeCadastro to set
     */
    public void setCodigoDeCadastro(String codigoDeCadastro) {
        this.codigoDeCadastro = codigoDeCadastro;
    }

    /**
     * @return the utilizado
     */
    public boolean isUtilizado() {
        return utilizado;
    }

    /**
     * @param utilizado the utilizado to set
     */
    public void setUtilizado(boolean utilizado) {
        this.utilizado = utilizado;
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

    /**
     * @return the cargo
     */
    public CargoBLL getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(CargoBLL cargo) {
        this.cargo = cargo;
    }
    
    // MÉTODOS
    public boolean Cadastrar(){
        return ccDAL.Cadastrar(this);
    }
    
    /**
     *
     * @return Retorna o próximo código atrelado ao cargo específico.
     */
    public String GerarProximo(){
        
        CodigoDeCadastroBLL.qtdDeCodigosPreGerados++; // QUANDO ESTE MÉTODO FOI ACESSADO, INCREMENTAR A VARIÁVEL QUE CONTA OS CÓDIGOS GERADOS
        return String.valueOf(ccDAL.QuantidadeDeCodigosCadastradosEmUmCargo(this)+ CodigoDeCadastroBLL.qtdDeCodigosPreGerados);
        
    }
    
    /**
     *
     * @param codigoDoCargo O código do cargo a ser pesquisado.
     * @return Retorna o próximo código atrelado ao cargo específico.
     */
    public String GerarProximo(int codigoDoCargo){
        this.cargo.setCodigo(codigoDoCargo);
        CodigoDeCadastroBLL.qtdDeCodigosPreGerados++; // QUANDO ESTE MÉTODO FOI ACESSADO, INCREMENTAR A VARIÁVEL QUE CONTA OS CÓDIGOS GERADOS
        return String.valueOf(ccDAL.QuantidadeDeCodigosCadastradosEmUmCargo(this)+ CodigoDeCadastroBLL.qtdDeCodigosPreGerados);
        
    }
    
    public void ResetarCodigos(){
        CodigoDeCadastroBLL.qtdDeCodigosPreGerados = 0;
    }
    
    /**
     *
     * @return Retorna a quantidade de códigos de cadastro associados ao cargo em 'cargo.getCodigo()'. 
     * Para atribuir o cargo, antes de usar esse método, utilize 'cargo.setCodigo'.
     * 
     */
    public int QuantidadeDeCodigosCadastradosEmUmCargo(){
        return ccDAL.QuantidadeDeCodigosCadastradosEmUmCargo(this);
    }
    
    /**
     *
     * @param codigoDoCargo O código do cargo a ser pesquisado.
     * @return Retorna a quantidade de códigos de cadastro associados ao cargo.
     */
    public int QuantidadeDeCodigosCadastradosEmUmCargo(int codigoDoCargo){
        this.cargo.setCodigo(codigoDoCargo);
        return ccDAL.QuantidadeDeCodigosCadastradosEmUmCargo(this);
    }
    
}
