/* 
CLASSE QUE GERENCIA CONEXÃO COM BANCO DE DADOS, CRIAÇÃO DO BANCO DE DADOS E DAS TABELAS.
 */
package DAL;

import java.sql.*; // BIBLIOTECA IMPORTADA PARA TRABALHAR COM BANCO DE DADOS
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    //CONEXAO
    private Connection conexao;
    private String erro;
    private final String mensagemDeErroCriacaoBanco = "BANCO NÃO FOI GERADO!";
    private final String mensagemDeErroCriacaoTabelas = "BANCO CRIADO MAS TABELAS NÃO CONSEGUIRAM SER GERADAS!";

    //ATRIBUTOS PARA CONEXÃO
    private String driver = "com.mysql.jdbc.Driver"; // ESTA LINHA CHAMA O DRIVER
    private String url = "jdbc:mysql://localhost:3306/BD_LJ"; // ESTE É O ENDEREÇO DO BANCO DE DADOS (VAI SER UTILIZADO PARA RECUPERAR UMA STRING DE CONEXÃO MAIS A FRENTE)
    private String user = "root"; // USUÁRIO DO BANCO
    private String password = ""; // ESTA É A SENHA PARA CONECTAR COM O BANCO DE DADOS

    public Connection Conectar() {
        conexao = null; // INICIAR UMA CONEXAO VAZIA

        try {
            Class.forName(driver);

            conexao = DriverManager.getConnection(url, user, password); // RETORNAR CONEXÃO USANDO ENDERECO DO BANCO, USUARIO E SENHA
            System.out.println("CONEXÃO BEM SUCEDIDA COM O BANCO DE DADOS");
            return conexao; // RETORNAR A CONEXAO PREENCHIDA
        } catch (ClassNotFoundException | SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return null;
        }
    }

    public Connection ConectarComServidor() {
        conexao = null; // INICIAR UMA CONEXAO VAZIA

        try {
            
            Class.forName(driver);
                
            url = "jdbc:mysql://localhost:3306";
            conexao = DriverManager.getConnection(url, user, password); // RETORNAR CONEXÃO USANDO ENDERECO DO BANCO, USUARIO E SENHA
            System.out.println("CONEXÃO BEM SUCEDIDA COM O SERVIDOR");
            return conexao; // RETORNAR A CONEXAO PREENCHIDA
            
        } catch (ClassNotFoundException | SQLException erro) {
            
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            return null;
        }
    }

    public boolean GerarBanco() {

        // TRATAMENTO DE ERROS
        try {
            String comandoSQL = "CREATE DATABASE BD_LJ;";

            //PREPARAR COMANDO PARA EXECUÇÃO
            Statement query = ConectarComServidor().prepareStatement(comandoSQL);

            //EXECUTAR COMANDO
            query.executeUpdate(comandoSQL);
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // CRIAÇÃO DAS TABELAS
            
            if(GerarTabelas()){
                //SE TUDO DER CERTO, RETORNAR TRUE
                return true;
            }
            else{
                // SE A CRIAÇÃO DAS TABELAS FALHAR, RETORNAR FALSE
                setErro(mensagemDeErroCriacaoTabelas);
                return false;
            }

            

        } catch (SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            setErro(mensagemDeErroCriacaoBanco);
            return false;
        }

    }
    
    public boolean GerarTabelas(){
        // CRIAR COMANDO SQL
        String comandoSQL = "CREATE TABLE Telefones("
                    + "	codigo int auto_increment,"
                    + "    ddd char(2),"
                    + "    numero char(9) not null,"
                    + "	ativo bit,"
                    + "    primary key (codigo)"
                    + "    );"
                    + "CREATE TABLE Paises ("
                    + "  codigo int NOT NULL AUTO_INCREMENT,"
                    + "  paisPt varchar(50) NOT NULL,"
                    + "  paisEn varchar(50) NOT NULL,"
                    + "  PRIMARY KEY (codigo)"
                    + ");"
                    + "CREATE TABLE Estados ("
                    + "    codigo   INT		  NOT NULL AUTO_INCREMENT,"
                    + "    CodigoUf INT          NOT NULL,"
                    + "    Nome     VARCHAR (50) NOT NULL,"
                    + "    Uf       CHAR 	 (2)  NOT NULL,"
                    + "    Pais	 INT		  NOT NULL,"
                    + "    PRIMARY KEY (codigo),"
                    + "    foreign key (Pais) references Paises (codigo)"
                    + ");"
                    + "    "
                    + "CREATE TABLE Cidades("
                    + "	codigo 	 INT 		  NOT NULL AUTO_INCREMENT,"
                    + "	CodigoCidade INT		  NOT NULL,"
                    + "	Nome 	 VARCHAR(255) NOT NULL,"
                    + "    Estado	int	NOT NULL,"
                    + "	PRIMARY KEY (codigo),"
                    + "    FOREIGN KEY (Estado) references Estados(codigo)"
                    + ");"
                    + ""
                    + "CREATE TABLE Bairros ("
                    + "  codigo 	 INT 		  NOT NULL AUTO_INCREMENT,"
                    + "  CodigoBairro CHAR(10)	  NOT NULL,"
                    + "  Nome 	 VARCHAR(255) NOT NULL,"
                    + "  Cidade	INT NOT NULL,"
                    + "  PRIMARY KEY (codigo),"
                    + "  Foreign Key (Cidade) references Cidades (codigo)"
                    + ");"
                    + ""
                    + "CREATE TABLE Enderecos("
                    + "	codigo int auto_increment,"
                    + "    Logradouro VARCHAR (255),"
                    + "    Numero VARCHAR (20),"
                    + "	CEP Varchar (20),"
                    + "    bairro int not null,"
                    + "	ativo bit,"
                    + "    Primary key (codigo),"
                    + "    foreign key (bairro) references Bairros (codigo)"
                    + "    );"
                    + ""
                    + "CREATE TABLE Clientes("
                    + "	codigo int auto_increment,"
                    + "    ativo bit,"
                    + "    endereco int,"
                    + "    email varchar (50),"
                    + "    primary key (codigo),"
                    + "    foreign key (endereco) references Enderecos (codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Pessoa_fisica("
                    + "	codigo int,"
                    + "    nome varchar (50) not null,"
                    + "    cpf char (11),"
                    + "    primary key (codigo),"
                    + "    foreign key (codigo) references Clientes(codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Pessoa_jurudica("
                    + "	codigo int,"
                    + "    razao_social varchar (50) not null,"
                    + "    cnpj char (14),"
                    + "    primary key (codigo),"
                    + "    foreign key (codigo) references Clientes(codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Clientes_tem_telefones("
                    + "	cliente int,"
                    + "    telefone int,"
                    + "    primary key(cliente, telefone),"
                    + "    foreign key (cliente) references Clientes (codigo),"
                    + "    foreign key (telefone) references Telefones (codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Permissoes("
                    + "	codigo int auto_increment,"
                    + "    "
                    + "    pode_cadastrar_FORNECEDOR bit,"
                    + "    pode_consultar_FORNECEDOR bit,"
                    + "    pode_alterar_FORNECEDOR bit,"
                    + "    pode_desligar_FORNECEDOR bit,"
                    + "    "
                    + "    pode_cadastrar_CLIENTE bit,"
                    + "    pode_consultar_CLIENTE bit,"
                    + "    pode_alterar_CLIENTE bit,"
                    + "    pode_desligar_CLIENTE bit,"
                    + "    "
                    + "    pode_cadastrar_COD_CADASTRO bit,"
                    + "    pode_consultar_COD_CADASTRO bit,"
                    + "    pode_alterar_COD_CADASTRO bit,"
                    + "    pode_desligar_COD_CADASTRO bit,"
                    + "    "
                    + "    pode_cadastrar_VENDA bit,"
                    + "    pode_consultar_VENDA bit,"
                    + "    pode_alterar_VENDA bit,"
                    + "    pode_desligar_VENDA bit,"
                    + "    "
                    + "    pode_cadastrar_PROMOCAO bit,"
                    + "    pode_consultar_PROMOCAO bit,"
                    + "    pode_alterar_PROMOCAO bit,"
                    + "    pode_desligar_PROMOCAO bit,"
                    + "    "
                    + "    pode_cadastrar_ALUGUEL bit,"
                    + "    pode_consultar_ALUGUEL bit,"
                    + "    pode_alterar_ALUGUEL bit,"
                    + "    pode_desligar_ALUGUEL bit,"
                    + "    "
                    + "    pode_cadastrar_PRODUTO bit,"
                    + "    pode_consultar_PRODUTO bit,"
                    + "    pode_alterar_PRODUTO bit,"
                    + "    pode_desligar_PRODUTO bit,"
                    + "    "
                    + "    pode_cadastrar_EQUIPAMENTO bit,"
                    + "    pode_consultar_EQUIPAMENTO bit,"
                    + "    pode_alterar_EQUIPAMENTO bit,"
                    + "    pode_desligar_EQUIPAMENTO bit,"
                    + "    "
                    + "    pode_cadastrar_MANUTENCAO bit,"
                    + "    pode_consultar_MANUTENCAO bit,"
                    + "    pode_alterar_MANUTENCAO bit,"
                    + "    pode_desligar_MANUTENCAO bit,"
                    + "    "
                    + "    pode_cadastrar_CARGO bit,"
                    + "    pode_consultar_CARGO bit,"
                    + "    pode_alterar_CARGO bit,"
                    + "    pode_desligar_CARGO bit,"
                    + "    "
                    + "    pode_cadastrar_FUNCIONARIO bit,"
                    + "    pode_consultar_FUNCIONARIO bit,"
                    + "    pode_alterar_FUNCIONARIO bit,"
                    + "    pode_desligar_FUNCIONARIO bit,"
                    + "    "
                    + "    pode_gerar_BACKUP bit,"
                    + "    pode_restaurar_BACKUP bit,"
                    + "    "
                    + "    pode_gerar_RELATORIO bit,"
                    + "    "
                    + "	ativo bit,"
                    + "    "
                    + "    primary key (codigo)"
                    + "    );"
                    + "	"
                    + ""
                    + "CREATE TABLE Cargos("
                    + "	codigo int auto_increment,"
                    + "    cargo varchar (30) not null,"
                    + "    salario decimal (15,2) not null,"
                    + "    permissao int not null,"
                    + "	ativo bit,"
                    + "    primary key (codigo),"
                    + "    foreign key (permissao) references Permissoes (codigo)"
                    + "    );"
                    + "        "
                    + "CREATE TABLE Codigos_de_cadastro("
                    + "    codigo_De_Cadastro varchar (20) not null,"
                    + "    utilizado bit not null,"
                    + "    ativo bit,"
                    + "    primary key (codigo_De_Cadastro)"
                    + "    );"
                    + "	"
                    + "CREATE TABLE Credenciais_de_acesso("
                    + "	usuario varchar(20) not null,"
                    + "    senha varchar (20) not null,"
                    + "    cod_cadastro varchar (20) not null,"
                    + "    primary key (usuario),"
                    + "    foreign key (cod_cadastro) references Codigos_de_cadastro (codigo_De_Cadastro)"
                    + "    );"
                    + ""
                    + ""
                    + "CREATE TABLE Funcionarios("
                    + "	codigo int auto_increment,"
                    + "    nome varchar (50) not null,"
                    + "    cpf char (11),"
                    + "    email varchar (50),"
                    + "    endereco int,"
                    + "    cargo int not null,"
                    + "    login varchar(20) not null,"
                    + "	ativo bit,"
                    + "    primary key (codigo),"
                    + "    foreign key (endereco) references Enderecos (codigo),"
                    + "    foreign key (cargo) references Cargos (codigo),"
                    + "    foreign key (login) references Credenciais_de_acesso (usuario)"
                    + "    );"
                    + "	"
                    + "CREATE TABLE Funcionarios_tem_telefones("
                    + "	funcionario int,"
                    + "    telefone int,"
                    + "	email int,"
                    + "    primary key(funcionario, telefone),"
                    + "    foreign key (funcionario) references Funcionarios (codigo),"
                    + "    foreign key (telefone) references Telefones (codigo)"
                    + "    );"
                    + ""
                    + "CREATE TABLE Titulos("
                    + "	codigo INT auto_increment,"
                    + "    NOME VARCHAR (50) NOT NULL,"
                    + "    SINOPSE VARCHAR(1000),"
                    + "    ATIVO BIT,"
                    + "    primary key(codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Plataformas("
                    + "	codigo INT auto_increment,"
                    + "    Plataforma VARCHAR(20) NOT NULL,"
                    + "	ativo bit,"
                    + "    primary key(codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Copias_para_alugar("
                    + "	codigo INT auto_increment,"
                    + "    titulo int not null,"
                    + "    plataforma int not null,"
                    + "    quantidade int not null,"
                    + "    ativo bit,"
                    + "    primary key (codigo),"
                    + "    foreign key (titulo) references Titulos (codigo),"
                    + "    foreign key (plataforma) references Plataformas (codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Alugueis("
                    + "	codigo INT auto_increment,"
                    + "    horario_inicio datetime not null,"
                    + "    duracao time not null,"
                    + "    ativo bit,"
                    + "    CLIENTE int not null,"
                    + "    primary key (codigo),"
                    + "    foreign key (CLiente) references Clientes (codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Copias_do_aluguel("
                    + "	copia int,"
                    + "    aluguel int,"
                    + "    primary key (copia, aluguel),"
                    + "    foreign key (copia) references Copias_para_alugar (codigo),"
                    + "    foreign key (aluguel) references Alugueis (codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Tipos_equipamentos( -- ESTA É UMA TABELA AUXILIAR PARA CADASTRAR OS TIPOS DE EQUIPAMENTO"
                    + "		codigo int auto_increment,"
                    + "        tipo varchar(20) not null,"
                    + "		ativo bit,"
                    + "        primary key(codigo)"
                    + "        );"
                    + ""
                    + "CREATE TABLE Equipamentos_da_loja("
                    + "	codigo int auto_increment,"
                    + "    tipo int not null,"
                    + "    nome varchar (20) not null,"
                    + "    valor_por_hora decimal (15,2) not null,"
                    + "    ativo bit,"
                    + "    primary key (codigo),"
                    + "    foreign key (tipo) references Tipos_Equipamentos (codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Equipamentos_do_aluguel( -- ESTA ERA UMA ENTIDADE ASSOCIATIVA ENTRE ALUGUÉIS E EQUIPAMENTOS DA LOJA"
                    + "	equipamento int,"
                    + "    aluguel int,"
                    + "    valor_cobrado_por_hora decimal(15,2) not null,"
                    + "    primary key (equipamento, aluguel),"
                    + "    foreign key (equipamento) references Equipamentos_da_loja (codigo),"
                    + "    foreign key (aluguel) references Alugueis (codigo)"
                    + "    );"
                    + "        "
                    + ""
                    + ""
                    + "CREATE TABLE Produtos("
                    + "	codigo int auto_increment,"
                    + "    nome varchar (25) not null,"
                    + "    quantidade int not null,"
                    + "    preco decimal (15,2) not null,"
                    + "	ativo bit,"
                    + "    primary key (codigo)"
                    + "    );"
                    + "	"
                    + "CREATE TABLE Kits_promocionais("
                    + "	produto1 int not null,"
                    + "    produto2 int not null,"
                    + "    preco decimal (15,2) not null,"
                    + "	ativo bit,"
                    + "    primary key (produto1, produto2),"
                    + "    foreign key (produto1) references Produtos (codigo),"
                    + "    foreign key (produto2) references Produtos (codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Copias_para_vender("
                    + "	codigo INT auto_increment,"
                    + "    titulo int not null,"
                    + "    plataforma int not null,"
                    + "    quantidade int not null,"
                    + "    primary key (codigo),"
                    + "    foreign key (codigo) references Produtos (codigo),"
                    + "    foreign key (titulo) references Titulos (codigo),"
                    + "    foreign key (plataforma) references Plataformas (codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Tipos_acessorio("
                    + "	codigo int auto_increment,"
                    + "    nome varchar (20) not null,"
                    + "	ativo bit,"
                    + "    primary key (codigo)"
                    + "    );"
                    + ""
                    + "CREATE TABLE Acessorios("
                    + "	codigo int auto_increment,"
                    + "    tipo int not null,"
                    + "    primary key (codigo),"
                    + "    foreign key (codigo) references Produtos (codigo),"
                    + "    foreign key (tipo) references Tipos_acessorio (codigo)"
                    + "    );"
                    + ""
                    + "CREATE TABLE Fornecedores("
                    + "	codigo int auto_increment,"
                    + "    Razao_social varchar (50) not null,"
                    + "    cnpj char (14),"
                    + "    endereco int,"
                    + "	email varchar (50),"
                    + "	ativo bit,"
                    + "    primary key (codigo),"
                    + "    foreign key (endereco) references Enderecos (codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Fornecedores_tem_telefones("
                    + "	fornecedor int,"
                    + "    telefone int,"
                    + "    primary key(fornecedor, telefone),"
                    + "    foreign key (fornecedor) references Fornecedores (codigo),"
                    + "    foreign key (telefone) references Telefones (codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Fornecimentos("
                    + "	fornecedor int,"
                    + "    produto int,"
                    + "    duracao_garantia date,"
                    + "    preco decimal (15,2) not null,"
                    + "    quantidade_fornecida int not null,"
                    + "    primary key (fornecedor, produto),"
                    + "    foreign key (fornecedor) references Fornecedores (codigo),"
                    + "    foreign key (produto) references Produtos (codigo)"
                    + "    );"
                    + ""
                    + "CREATE TABLE Vendas("
                    + "	codigo int auto_increment,"
                    + "    cliente int not null,"
                    + "    data_da_venda datetime not null,"
                    + "    ativo bit,"
                    + "    primary key (codigo),"
                    + "    foreign key (cliente) references Clientes (codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Itens_da_venda("
                    + "	venda int not null,"
                    + "    produto int not null,"
                    + "    preco decimal (15,2) not null,"
                    + "    primary key (venda, produto),"
                    + "    foreign key (venda) references Vendas (codigo),"
                    + "    foreign key (produto) references Produtos (codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Equipamentos_manutencao("
                    + "	codigo int auto_increment,"
                    + "    nome varchar (30) not null,"
                    + "    tipo int not null,"
                    + "    ativo bit,"
                    + "    primary key (codigo),"
                    + "    foreign key (tipo) references Tipos_Equipamentos (codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Manutencoes("
                    + "	codigo int auto_increment,"
                    + "    valor decimal (15,2) not null,"
                    + "    data_manutencao datetime not null,"
                    + "    parecer_tecnico varchar (255),"
                    + "    cliente int not null,"
                    + "    tecnico_responsavel int not null,"
                    + "    ativo bit,"
                    + "    primary key (codigo),"
                    + "    foreign key (cliente) references Clientes (codigo),"
                    + "    foreign key (tecnico_responsavel) references Funcionarios (codigo)"
                    + "    );	"
                    + ""
                    + "CREATE TABLE Tipos_manutencoes("
                    + "	codigo int auto_increment,"
                    + "    tipo_manutencao varchar (25) not null,"
                    + "	ativo bit,"
                    + "    primary key (codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Manutencoes_tem_tipos("
                    + "	manutencao int,"
                    + "    tipo int,"
                    + "    primary key (manutencao, tipo),"
                    + "	foreign key (manutencao) references Manutencoes (codigo),"
                    + "	foreign key (tipo) references Tipos_manutencoes (codigo)"
                    + "    );"
                    + "    "
                    + "CREATE TABLE Equipamentos_da_manutencao("
                    + "	equipamento int,"
                    + "    manutencao int,"
                    + "    defeito varchar (255),"
                    + "    orcamento decimal (15,2),"
                    + "    primary key (equipamento, manutencao),"
                    + "    foreign key (equipamento) references Equipamentos_manutencao(codigo),"
                    + "    foreign key (manutencao) references Manutencoes(codigo)"
                    + "    );";
        
        // TRATAMENTO DE ERROS
        try {
            PreparedStatement pQuery = Conectar().prepareStatement(comandoSQL);
            pQuery.execute();
            /*
            //PREPARAR COMANDO PARA EXECUÇÃO
            Statement query = Conectar().prepareStatement(comandoSQL);
            
            //EXECUTAR COMANDO
            query.executeUpdate(comandoSQL);
                */
            //SE TUDO DER CERTO, RETORNAR TRUE
            return true;

        } catch (SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " NO MÉTODO 'GERAR TABELAS' \n" + erro);
            return false;
        }
    }

    /**
     * @return the erro
     */
    public String getErro() {
        return erro;
    }

    /**
     * @param erro the erro to set
     */
    public void setErro(String erro) {
        this.erro = erro;
    }
}
