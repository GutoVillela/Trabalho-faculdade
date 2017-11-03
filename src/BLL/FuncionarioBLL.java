
package BLL;

import DAL.FuncionarioDAL;
import java.util.LinkedList;
import java.util.List;

public class FuncionarioBLL {
    
    private int codigo;
    private String nome;
    private String cpf;
    private String email;
    private EnderecoBLL endereco;
    private CargoBLL cargo;
    private CredencialDeAcessoBLL login;
    private List<TelefoneBLL> telefones;
    
    private FuncionarioDAL fDAL = new FuncionarioDAL();
    
    private boolean ativo;

    public FuncionarioBLL() {
        //INICIALIZAR TODOS OS OBJETOS
        endereco = new EnderecoBLL();
        cargo = new CargoBLL();
        login = new CredencialDeAcessoBLL();
        this.telefones = new LinkedList<>();
    }

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
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the endereco
     */
    public EnderecoBLL getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(EnderecoBLL endereco) {
        this.endereco = endereco;
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

    /**
     * @return the login
     */
    public CredencialDeAcessoBLL getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(CredencialDeAcessoBLL login) {
        this.login = login;
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
     * @return the telefones
     */
    public List<TelefoneBLL> getTelefones() {
        return telefones;
    }

    /**
     * @param telefones the telefones to set
     */
    public void setTelefones(List<TelefoneBLL> telefones) {
        this.telefones = telefones;
    }
    
    // MÉTODOS
    public boolean Cadastrar(){
        
        // CADASTRAR ENDEREÇO E RECUPERAR CHAVE CADASTRADA
        boolean deuCertoEndereco = endereco.Cadastrar();
        this.endereco.setCodigo(endereco.RecuperarUltimaChavePrimaria());
        
        // CADASTRAR LOGIN
        boolean deuCertoLogin = login.Cadastrar();
        
        // RETORNAR SE TODOS DERAM CERTO
        return deuCertoEndereco && deuCertoLogin && fDAL.Cadastrar(this); // O IDEAL É CADASTRAR O ENDEREÇO, AS CREDENCIAIS DE ACESSO E DEPOIS ELE MESMO
    }
    
    public List<FuncionarioBLL> Consultar (){
        return fDAL.Consultar();
    }
    
    public List<FuncionarioBLL> ConsultarPorNome (String nome){
        return fDAL.ConsultarPorNome(nome);
    }
    
    public List<FuncionarioBLL> ConsultarPorCpf (String cpf){
        return fDAL.ConsultarPorCpf(cpf);
    }
    
    public List<FuncionarioBLL> ConsultarPorEmail (String email){
        return fDAL.ConsultarPorEmail(email);
    }
    
    public List<FuncionarioBLL> ConsultarPorEndereco (){
        return fDAL.ConsultarPorEndereco(endereco);
    }
    
    public List<FuncionarioBLL> ConsultarPorUsuario (String usuario){
        return fDAL.ConsultarPorUsuario(usuario);
    }
    
    public List<FuncionarioBLL> ConsultarPorCargo (String cargo){
        return fDAL.ConsultarPorCargo(cargo);
    }
}
