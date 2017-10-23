/*
    CLASSE BLL PARA GERENCIAR CREDENCIAIS DE ACESSO DE TODOS OS USUÁRIOS DO SISTEMA
 */
package BLL;

import DAL.CredencialDeAcessoDAL; // IMPORTAR A CLASSE DAL CORRESPONDETE À ESTE CLASSE

public class CredencialDeAcessoBLL {
    private String usuario;
    private String senha;
    private CodigoDeCadastroBLL codCadastro;
    
    private CredencialDeAcessoDAL cDAL = new CredencialDeAcessoDAL();

    public CredencialDeAcessoBLL() {
        this.codCadastro = new CodigoDeCadastroBLL();
    }
    
    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the codCadastro
     */
    public CodigoDeCadastroBLL getCodCadastro() {
        return codCadastro;
    }

    /**
     * @param codCadastro the codCadastro to set
     */
    public void setCodCadastro(CodigoDeCadastroBLL codCadastro) {
        this.codCadastro = codCadastro;
    }
    
    
    //MÉTODOS
    public boolean  Validar(){ // ESTE MÉTODO VALIDA O LOGIN DO USUÁRIO E VERIRICA SE O MESMO ESTÁ ATIVO
        
        if (cDAL.Validar(this)) {
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public boolean Cadastrar(){
        return cDAL.Cadastrar(this);
    }
    
}
