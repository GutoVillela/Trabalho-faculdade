package BLL;

import DAL.CodigoDeCadastroDAL; // IMPORTAÇÃO DA RESPECTIVA CLASSE DAL
import java.util.List;
import java.util.Random;

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
    public boolean Cadastrar() {
        return ccDAL.Cadastrar(this);
    }

    /**
     *
     * @return Retorna o próximo código atrelado ao cargo específico.
     */
    public String GerarProximo() {

        //return String.valueOf(ccDAL.QuantidadeDeCodigosCadastradosEmUmCargo(this) + CodigoDeCadastroBLL.qtdDeCodigosPreGerados);

        CodigoDeCadastroBLL.qtdDeCodigosPreGerados++; // QUANDO ESTE MÉTODO FOI ACESSADO, INCREMENTAR A VARIÁVEL QUE CONTA OS CÓDIGOS GERADOS
        
        // CRIAR UM OBJETO RAMDOM E UMA STRING PARA GUARDAR O CÓDIGO DE CADASTRO GERADO AQUI
        Random rdm = new Random();
        String codigoGerado = String.valueOf(ccDAL.QuantidadeDeCodigosCadastradosEmUmCargo(this) + CodigoDeCadastroBLL.qtdDeCodigosPreGerados);
        
        //GERAR UM VETOR COM OS POSSÍVEIS CARACTERES
        String[] caracteres = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "a", "b", "c", "d", "e", "f"};
        // PREENCHER TODO O CÓDIGO DE CADASTRO
        do {
            if(codigoGerado.length() == 4 || codigoGerado.length() == 9 ||codigoGerado.length() == 14 ){
                codigoGerado += "-"; // ADICIONAR UM TRAÇO NOS ÍNDICES 4, 9 E 14, PARA GERAR ESTE FORMATO = xxxx-xxxx-xxxx-xxxxx
            }
            else{
                codigoGerado += caracteres[rdm.nextInt(caracteres.length)]; // SENÃO RANDOMIZAR UM CARACTERE DENTRO DO ÍNDICE DO VETOR
            }
            
        } while (codigoGerado.length() < 20); // REPETIR ESTE PROCESSO ENQUANTO O CÓDIGO ESTIVER COM MENOS DE 20 CARACTERES

        //return String.valueOf(ccDAL.QuantidadeDeCodigosCadastradosEmUmCargo(this) + CodigoDeCadastroBLL.qtdDeCodigosPreGerados);
        
        return codigoGerado;

    }

    /**
     *
     * @param codigoDoCargo O código do cargo a ser pesquisado.
     * @return Retorna o próximo código atrelado ao cargo específico.
     */
    public String GerarProximo(int codigoDoCargo) {
        this.cargo.setCodigo(codigoDoCargo);
        
        return GerarProximo();

    }

    public void ResetarCodigos() {
        CodigoDeCadastroBLL.qtdDeCodigosPreGerados = 0;
    }

    /**
     *
     * @return Retorna a quantidade de códigos de cadastro associados ao cargo
     * em 'cargo.getCodigo()'. Para atribuir o cargo, antes de usar esse método,
     * utilize 'cargo.setCodigo'.
     *
     */
    public int QuantidadeDeCodigosCadastradosEmUmCargo() {
        return ccDAL.QuantidadeDeCodigosCadastradosEmUmCargo(this);
    }

    /**
     *
     * @param listaACadastrar Uma lista de códigos de cadastros a serem
     * incluídas no banco de dados.
     * @return Cadastra uma lista de códigos de cadastro. Se todos derem certo,
     * retorna true. Senão, retorna false.
     *
     */
    public boolean Cadastrar(List<CodigoDeCadastroBLL> listaACadastrar) {
        boolean deuCerto = true;

        for (int i = 0; i < listaACadastrar.size(); i++) {
            if (!listaACadastrar.get(i).Cadastrar()) {
                deuCerto = false;
            }
        }

        return deuCerto;

    }

    /**
     *
     * @param codigoDoCargo O código do cargo a ser pesquisado.
     * @return Retorna a quantidade de códigos de cadastro associados ao cargo.
     */
    public int QuantidadeDeCodigosCadastradosEmUmCargo(int codigoDoCargo) {
        this.cargo.setCodigo(codigoDoCargo);
        return ccDAL.QuantidadeDeCodigosCadastradosEmUmCargo(this);
    }
    
    public  boolean Validar(){
        return ccDAL.Validar(this);
    }

}
