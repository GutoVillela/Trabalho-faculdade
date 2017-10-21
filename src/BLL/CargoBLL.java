package BLL;

import DAL.CargoDAL;

public class CargoBLL {
    
    private int codigo;
    private String cargo;
    private float salario;
    private PermissaoBLL permissao;
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
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @return the salario
     */
    public float getSalario() {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(float salario) {
        this.salario = salario;
    }

    /**
     * @return the permissao
     */
    public PermissaoBLL getPermissao() {
        return permissao;
    }

    /**
     * @param permissao the permissao to set
     */
    public void setPermissao(PermissaoBLL permissao) {
        this.permissao = permissao;
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
    
    private CargoDAL cDAL = new CargoDAL();
    
    // MÉTODOS
    public boolean Cadastrar(){
        
        if (cDAL.Cadastrar(this)) {
            return true;
        }
        else{
            return false;
        }
        
    }
    
}
