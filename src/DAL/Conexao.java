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
    public final static String mensagemDeErroCriacaoBanco = "BANCO NÃO FOI GERADO!";
    public final static String mensagemDeErroCriacaoTabelas = "BANCO CRIADO MAS TABELAS NÃO CONSEGUIRAM SER GERADAS!";
    public final static String mensagemDeErroConexaoComServidor = "ERRO AO SE CONECTAR COM O SERVIDOR!";

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

            this.url = "jdbc:mysql://localhost:3306";
            conexao = DriverManager.getConnection(url, user, password); // RETORNAR CONEXÃO USANDO ENDERECO DO BANCO, USUARIO E SENHA
            System.out.println("CONEXÃO BEM SUCEDIDA COM O SERVIDOR");
            return conexao; // RETORNAR A CONEXAO PREENCHIDA

        } catch (ClassNotFoundException | SQLException erro) {

            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            this.erro = mensagemDeErroConexaoComServidor;
            return null;
        }
    }

    public boolean GerarBanco() {

        // TRATAMENTO DE ERROS
        try {
            String comandoSQL = "CREATE DATABASE BD_LJ;";

            //PREPARAR COMANDO PARA EXECUÇÃO
            Connection conexaoComServidor = ConectarComServidor();

            // PROSSEGUIR SOMENTE SE CONEXÃO NÃO FOR NULA
            if (conexaoComServidor != null) {
                Statement query = conexaoComServidor.prepareStatement(comandoSQL);

                //EXECUTAR COMANDO
                query.executeUpdate(comandoSQL);

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                }

                //CRIAR PROCEDURE
                CriarDeclararProcedureQueCriaTabelas();

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
                }

                return ChamarProcedure();
            }
            else{
                return false;
            }

        } catch (SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + "\n" + erro);
            setErro(mensagemDeErroCriacaoBanco);
            return false;
        }

    }

    private boolean CriarDeclararProcedureQueCriaTabelas() {
        // CRIAR COMANDO SQL
        String comandoSQL = "CREATE PROCEDURE BD_LJ.GerarTabelas ()\n"
                + "\n"
                + "	BEGIN\n"
                + "\n"
                + "-- CRIAÇÃO DAS TABELAS\n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Telefones(\n"
                + "	codigo int auto_increment,\n"
                + "    ddd char(2),\n"
                + "    numero char(9) not null,\n"
                + "	ativo bit,\n"
                + "    primary key (codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Paises (\n"
                + "  codigo int NOT NULL AUTO_INCREMENT,\n"
                + "  paisPt varchar(50) NOT NULL,\n"
                + "  paisEn varchar(50) NOT NULL,\n"
                + "  PRIMARY KEY (codigo)\n"
                + ");\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Estados (\n"
                + "    codigo   INT		  NOT NULL AUTO_INCREMENT,\n"
                + "    CodigoUf INT          NOT NULL,\n"
                + "    Nome     VARCHAR (50) NOT NULL,\n"
                + "    Uf       CHAR 	 (2)  NOT NULL,\n"
                + "    Pais	 INT		  NOT NULL,\n"
                + "    PRIMARY KEY (codigo),\n"
                + "    foreign key (Pais) references Paises (codigo)\n"
                + ");\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Cidades(\n"
                + "	codigo 	 INT 		  NOT NULL AUTO_INCREMENT,\n"
                + "	CodigoCidade INT		  NOT NULL,\n"
                + "	Nome 	 VARCHAR(255) NOT NULL,\n"
                + "    Estado	int	NOT NULL,\n"
                + "	PRIMARY KEY (codigo),\n"
                + "    FOREIGN KEY (Estado) references Estados(codigo)\n"
                + ");\n"
                + "\n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Bairros (\n"
                + "  codigo 	 INT 		  NOT NULL AUTO_INCREMENT,\n"
                + "  CodigoBairro CHAR(10)	  NOT NULL,\n"
                + "  Nome 	 VARCHAR(255) NOT NULL,\n"
                + "  Cidade	INT NOT NULL,\n"
                + "  PRIMARY KEY (codigo),\n"
                + "  Foreign Key (Cidade) references Cidades (codigo)\n"
                + ");\n"
                + "/*\n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Enderecos(\n"
                + "	codigo int auto_increment,\n"
                + "    Logradouro VARCHAR (255),\n"
                + "    Numero VARCHAR (20),\n"
                + "	CEP Varchar (20),\n"
                + "    bairro int not null,\n"
                + "	ativo bit,\n"
                + "    Primary key (codigo),\n"
                + "    foreign key (bairro) references Bairros (codigo)\n"
                + "    );\n"
                + "	*/\n"
                + "	\n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Enderecos(\n"
                + "	codigo int auto_increment,\n"
                + "    Logradouro VARCHAR (255),\n"
                + "    Numero VARCHAR (20),\n"
                + "	CEP Varchar (20),\n"
                + "    bairro VARCHAR (255),\n"
                + "	CIDADE VARCHAR (255),\n"
                + "	estado VARCHAR (255),\n"
                + "	PAIS VARCHAR (255),\n"
                + "	ativo bit,\n"
                + "    Primary key (codigo)\n"
                + "    );\n"
                + "\n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Clientes(\n"
                + "	codigo int auto_increment,\n"
                + "    ativo bit,\n"
                + "    endereco int,\n"
                + "    email varchar (50),\n"
                + "    primary key (codigo),\n"
                + "    foreign key (endereco) references Enderecos (codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Pessoa_fisica(\n"
                + "	codigo int,\n"
                + "    nome varchar (50) not null,\n"
                + "    cpf char (11),\n"
                + "    primary key (codigo),\n"
                + "    foreign key (codigo) references Clientes(codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Pessoa_juridica(\n"
                + "	codigo int,\n"
                + "    razao_social varchar (50) not null,\n"
                + "    cnpj char (14),\n"
                + "    primary key (codigo),\n"
                + "    foreign key (codigo) references Clientes(codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Clientes_tem_telefones(\n"
                + "	cliente int,\n"
                + "    telefone int,\n"
                + "    primary key(cliente, telefone),\n"
                + "    foreign key (cliente) references Clientes (codigo),\n"
                + "    foreign key (telefone) references Telefones (codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Permissoes(\n"
                + "	codigo int auto_increment,\n"
                + "    \n"
                + "    pode_cadastrar_FORNECEDOR bit,\n"
                + "    pode_consultar_FORNECEDOR bit,\n"
                + "    pode_alterar_FORNECEDOR bit,\n"
                + "    pode_desligar_FORNECEDOR bit,\n"
                + "    \n"
                + "    pode_cadastrar_CLIENTE bit,\n"
                + "    pode_consultar_CLIENTE bit,\n"
                + "    pode_alterar_CLIENTE bit,\n"
                + "    pode_desligar_CLIENTE bit,\n"
                + "    \n"
                + "    pode_cadastrar_COD_CADASTRO bit,\n"
                + "    pode_consultar_COD_CADASTRO bit,\n"
                + "    pode_alterar_COD_CADASTRO bit,\n"
                + "    pode_desligar_COD_CADASTRO bit,\n"
                + "    \n"
                + "    pode_cadastrar_VENDA bit,\n"
                + "    pode_consultar_VENDA bit,\n"
                + "    pode_alterar_VENDA bit,\n"
                + "    pode_desligar_VENDA bit,\n"
                + "    \n"
                + "    pode_cadastrar_PROMOCAO bit,\n"
                + "    pode_consultar_PROMOCAO bit,\n"
                + "    pode_alterar_PROMOCAO bit,\n"
                + "    pode_desligar_PROMOCAO bit,\n"
                + "    \n"
                + "    pode_cadastrar_ALUGUEL bit,\n"
                + "    pode_consultar_ALUGUEL bit,\n"
                + "    pode_alterar_ALUGUEL bit,\n"
                + "    pode_desligar_ALUGUEL bit,\n"
                + "    \n"
                + "    pode_cadastrar_PRODUTO bit,\n"
                + "    pode_consultar_PRODUTO bit,\n"
                + "    pode_alterar_PRODUTO bit,\n"
                + "    pode_desligar_PRODUTO bit,\n"
                + "    \n"
                + "    pode_cadastrar_EQUIPAMENTO bit,\n"
                + "    pode_consultar_EQUIPAMENTO bit,\n"
                + "    pode_alterar_EQUIPAMENTO bit,\n"
                + "    pode_desligar_EQUIPAMENTO bit,\n"
                + "    \n"
                + "    pode_cadastrar_MANUTENCAO bit,\n"
                + "    pode_consultar_MANUTENCAO bit,\n"
                + "    pode_alterar_MANUTENCAO bit,\n"
                + "    pode_desligar_MANUTENCAO bit,\n"
                + "    \n"
                + "    pode_cadastrar_CARGO bit,\n"
                + "    pode_consultar_CARGO bit,\n"
                + "    pode_alterar_CARGO bit,\n"
                + "    pode_desligar_CARGO bit,\n"
                + "    \n"
                + "    pode_cadastrar_FUNCIONARIO bit,\n"
                + "    pode_consultar_FUNCIONARIO bit,\n"
                + "    pode_alterar_FUNCIONARIO bit,\n"
                + "    pode_desligar_FUNCIONARIO bit,\n"
                + "    \n"
                + "    pode_gerar_BACKUP bit,\n"
                + "    pode_restaurar_BACKUP bit,\n"
                + "    \n"
                + "    pode_gerar_RELATORIO bit,\n"
                + "    \n"
                + "	ativo bit,\n"
                + "    \n"
                + "    primary key (codigo)\n"
                + "	\n"
                + "    );\n"
                + "	\n"
                + "\n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Cargos(\n"
                + "	codigo int auto_increment,\n"
                + "    cargo varchar (30) not null,\n"
                + "    salario decimal (15,2) not null,\n"
                + "    permissao int not null,\n"
                + "	ativo bit,\n"
                + "    primary key (codigo),\n"
                + "    foreign key (permissao) references Permissoes (codigo)\n"
                + "    );\n"
                + "        \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Codigos_de_cadastro(\n"
                + "    codigo_De_Cadastro varchar (20) not null,\n"
                + "    utilizado bit not null,\n"
                + "	cargo int not null,\n"
                + "    ativo bit,\n"
                + "    primary key (codigo_De_Cadastro),\n"
                + "	foreign key (cargo) references Cargos (codigo)\n"
                + "    );\n"
                + "	\n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Credenciais_de_acesso(\n"
                + "	usuario varchar(20) not null,\n"
                + "    senha varchar (20) not null,\n"
                + "    cod_cadastro varchar (20) not null,\n"
                + "    primary key (usuario),\n"
                + "    foreign key (cod_cadastro) references Codigos_de_cadastro (codigo_De_Cadastro)\n"
                + "    );\n"
                + "\n"
                + "\n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Funcionarios(\n"
                + "	codigo int auto_increment,\n"
                + "    nome varchar (50) not null,\n"
                + "    cpf char (11),\n"
                + "    email varchar (50),\n"
                + "    endereco int,\n"
                + "    cargo int not null,\n"
                + "    login varchar(20) not null,\n"
                + "	ativo bit,\n"
                + "    primary key (codigo),\n"
                + "    foreign key (endereco) references Enderecos (codigo),\n"
                + "    foreign key (cargo) references Cargos (codigo),\n"
                + "    foreign key (login) references Credenciais_de_acesso (usuario)\n"
                + "    );\n"
                + "	\n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Funcionarios_tem_telefones(\n"
                + "	funcionario int,\n"
                + "    telefone int,\n"
                + "	email int,\n"
                + "    primary key(funcionario, telefone),\n"
                + "    foreign key (funcionario) references Funcionarios (codigo),\n"
                + "    foreign key (telefone) references Telefones (codigo)\n"
                + "    );\n"
                + "\n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Titulos(\n"
                + "	codigo INT auto_increment,\n"
                + "    NOME VARCHAR (50) NOT NULL,\n"
                + "    SINOPSE VARCHAR(1000),\n"
                + "    ATIVO BIT,\n"
                + "    primary key(codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Plataformas(\n"
                + "	codigo INT auto_increment,\n"
                + "    Plataforma VARCHAR(20) NOT NULL,\n"
                + "	ativo bit,\n"
                + "    primary key(codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Copias_para_alugar(\n"
                + "	codigo INT auto_increment,\n"
                + "    titulo int not null,\n"
                + "    plataforma int not null,\n"
                + "    quantidade int not null,\n"
                + "    ativo bit,\n"
                + "    primary key (codigo),\n"
                + "    foreign key (titulo) references Titulos (codigo),\n"
                + "    foreign key (plataforma) references Plataformas (codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Alugueis(\n"
                + "	codigo INT auto_increment,\n"
                + "    horario_inicio datetime not null,\n"
                + "    duracao time not null,\n"
                + "    ativo bit,\n"
                + "    CLIENTE int not null,\n"
                + "    primary key (codigo),\n"
                + "    foreign key (CLiente) references Clientes (codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Copias_do_aluguel(\n"
                + "	copia int,\n"
                + "    aluguel int,\n"
                + "	quantidade_alugada int,\n"
                + "    primary key (copia, aluguel),\n"
                + "    foreign key (copia) references Copias_para_alugar (codigo),\n"
                + "    foreign key (aluguel) references Alugueis (codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Tipos_equipamentos( -- ESTA É UMA TABELA AUXILIAR PARA CADASTRAR OS TIPOS DE EQUIPAMENTO\n"
                + "		codigo int auto_increment,\n"
                + "        tipo varchar(20) not null,\n"
                + "		ativo bit,\n"
                + "        primary key(codigo)\n"
                + "        );\n"
                + "\n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Equipamentos_da_loja(\n"
                + "	codigo int auto_increment,\n"
                + "    tipo int not null,\n"
                + "    nome varchar (20) not null,\n"
                + "    valor_por_hora decimal (15,2) not null,\n"
                + "    ativo bit,\n"
                + "    primary key (codigo),\n"
                + "    foreign key (tipo) references Tipos_Equipamentos (codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Equipamentos_do_aluguel( -- ESTA ERA UMA ENTIDADE ASSOCIATIVA ENTRE ALUGUÉIS E EQUIPAMENTOS DA LOJA\n"
                + "	equipamento int,\n"
                + "    aluguel int,\n"
                + "    valor_cobrado_por_hora decimal(15,2) not null,\n"
                + "    primary key (equipamento, aluguel),\n"
                + "    foreign key (equipamento) references Equipamentos_da_loja (codigo),\n"
                + "    foreign key (aluguel) references Alugueis (codigo)\n"
                + "    );\n"
                + "        \n"
                + "\n"
                + "\n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Produtos(\n"
                + "	codigo int auto_increment,\n"
                + "    nome varchar (100) not null,\n"
                + "    quantidade int not null,\n"
                + "    preco decimal (15,2) not null,\n"
                + "	ativo bit,\n"
                + "    primary key (codigo)\n"
                + "    );\n"
                + "	\n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Promocoes(\n"
                + "	codigo int auto_increment,\n"
                + "	nome_promocao varchar (20) not null,\n"
                + "	descricao varchar(1000),\n"
                + "	primary key (codigo)\n"
                + "	\n"
                + ");\n"
                + "	\n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Kits_promocionais(\n"
                + "	promocao int not null,\n"
                + "    produto int not null,\n"
                + "    preco decimal (15,2) not null,\n"
                + "	ativo bit,\n"
                + "    primary key (promocao, produto),\n"
                + "    foreign key (promocao) references Promocoes (codigo),\n"
                + "    foreign key (produto) references Produtos (codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Copias_para_vender(\n"
                + "	codigo INT auto_increment,\n"
                + "    titulo int not null,\n"
                + "    plataforma int not null,\n"
                + "    primary key (codigo),\n"
                + "    foreign key (codigo) references Produtos (codigo),\n"
                + "    foreign key (titulo) references Titulos (codigo),\n"
                + "    foreign key (plataforma) references Plataformas (codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Tipos_acessorio(\n"
                + "	codigo int auto_increment,\n"
                + "    nome varchar (20) not null,\n"
                + "	ativo bit,\n"
                + "    primary key (codigo)\n"
                + "    );\n"
                + "\n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Acessorios(\n"
                + "	codigo int auto_increment,\n"
                + "    tipo int not null,\n"
                + "    primary key (codigo),\n"
                + "    foreign key (codigo) references Produtos (codigo),\n"
                + "    foreign key (tipo) references Tipos_acessorio (codigo)\n"
                + "    );\n"
                + "\n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Fornecedores(\n"
                + "	codigo int auto_increment,\n"
                + "    Razao_social varchar (50) not null,\n"
                + "    cnpj char (14),\n"
                + "    endereco int,\n"
                + "	email varchar (50),\n"
                + "	ativo bit,\n"
                + "    primary key (codigo),\n"
                + "    foreign key (endereco) references Enderecos (codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Fornecedores_tem_telefones(\n"
                + "	fornecedor int,\n"
                + "    telefone int,\n"
                + "    primary key(fornecedor, telefone),\n"
                + "    foreign key (fornecedor) references Fornecedores (codigo),\n"
                + "    foreign key (telefone) references Telefones (codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Fornecimentos(\n"
                + "	fornecedor int,\n"
                + "    produto int,\n"
                + "    duracao_garantia date,\n"
                + "    preco decimal (15,2) not null,\n"
                + "    quantidade_fornecida int not null,\n"
                + "    primary key (fornecedor, produto),\n"
                + "    foreign key (fornecedor) references Fornecedores (codigo),\n"
                + "    foreign key (produto) references Produtos (codigo)\n"
                + "    );\n"
                + "\n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Vendas(\n"
                + "	codigo int auto_increment,\n"
                + "    cliente int,\n"
                + "    data_da_venda datetime not null,\n"
                + "    ativo bit,\n"
                + "    primary key (codigo),\n"
                + "    foreign key (cliente) references Clientes (codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Itens_da_venda(\n"
                + "	venda int not null,\n"
                + "    produto int not null,\n"
                + "    preco_cobrado decimal (15,2) not null,\n"
                + "	quantidade_comprada int not null,\n"
                + "    primary key (venda, produto),\n"
                + "    foreign key (venda) references Vendas (codigo),\n"
                + "    foreign key (produto) references Produtos (codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Equipamentos_do_cliente(\n"
                + "	codigo int auto_increment,\n"
                + "    nome varchar (30) not null,\n"
                + "    tipo int not null,\n"
                + "    cliente int not null,\n"
                + "    ativo bit,\n"
                + "    primary key (codigo),\n"
                + "    foreign key (tipo) references Tipos_Equipamentos (codigo),\n"
                + "    foreign key (cliente) references Clientes (codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Manutencoes(\n"
                + "	codigo int auto_increment,\n"
                + "    valor decimal (15,2) not null,\n"
                + "    data_manutencao datetime not null,\n"
                + "    parecer_tecnico varchar (255),\n"
                + "    cliente int,\n"
                + "    tecnico_responsavel int not null,\n"
                + "    ativo bit,\n"
                + "    primary key (codigo),\n"
                + "    foreign key (cliente) references Clientes (codigo),\n"
                + "    foreign key (tecnico_responsavel) references Funcionarios (codigo)\n"
                + "    );	\n"
                + "\n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Tipos_manutencoes(\n"
                + "	codigo int auto_increment,\n"
                + "    tipo_manutencao varchar (25) not null,\n"
                + "	ativo bit,\n"
                + "    primary key (codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Manutencoes_tem_tipos(\n"
                + "	manutencao int,\n"
                + "    tipo int,\n"
                + "    primary key (manutencao, tipo),\n"
                + "	foreign key (manutencao) references Manutencoes (codigo),\n"
                + "	foreign key (tipo) references Tipos_manutencoes (codigo)\n"
                + "    );\n"
                + "    \n"
                + "CREATE TABLE IF NOT EXISTS BD_LJ.Equipamentos_da_manutencao(\n"
                + "	equipamento int,\n"
                + "    manutencao int,\n"
                + "    defeito varchar (255),\n"
                + "    orcamento decimal (15,2),\n"
                + "    primary key (equipamento, manutencao),\n"
                + "    foreign key (equipamento) references Equipamentos_do_cliente(codigo),\n"
                + "    foreign key (manutencao) references Manutencoes(codigo)\n"
                + "    );\n"
                + "    \n"
                + "-- CRIAÇÃO DO PRIMEIRO USUÁRIO PARA ACESSAR O SISTEMA\n"
                + "INSERT INTO BD_LJ.Permissoes (\n"
                + "                 \n"
                + "                 	pode_cadastrar_FORNECEDOR, \n"
                + "                 	pode_consultar_FORNECEDOR,\n"
                + "                     pode_alterar_FORNECEDOR,\n"
                + "                     pode_desligar_FORNECEDOR,\n"
                + "                     \n"
                + "                     pode_cadastrar_CLIENTE,\n"
                + "                     pode_consultar_CLIENTE,\n"
                + "                     pode_alterar_CLIENTE,\n"
                + "                     pode_desligar_CLIENTE,\n"
                + "                     \n"
                + "                     pode_cadastrar_COD_CADASTRO,\n"
                + "                     pode_consultar_COD_CADASTRO,\n"
                + "                     pode_alterar_COD_CADASTRO,\n"
                + "                     pode_desligar_COD_CADASTRO,\n"
                + "                     \n"
                + "                     pode_cadastrar_VENDA,\n"
                + "                     pode_consultar_VENDA,\n"
                + "                     pode_alterar_VENDA,\n"
                + "                     pode_desligar_VENDA,\n"
                + "                     \n"
                + "                     pode_cadastrar_PROMOCAO,\n"
                + "                     pode_consultar_PROMOCAO,\n"
                + "                     pode_alterar_PROMOCAO,\n"
                + "                     pode_desligar_PROMOCAO,\n"
                + "                     \n"
                + "                     pode_cadastrar_ALUGUEL,\n"
                + "                     pode_consultar_ALUGUEL,\n"
                + "                     pode_alterar_ALUGUEL,\n"
                + "                     pode_desligar_ALUGUEL,\n"
                + "                     \n"
                + "                     pode_cadastrar_PRODUTO,\n"
                + "                     pode_consultar_PRODUTO,\n"
                + "                     pode_alterar_PRODUTO,\n"
                + "                     pode_desligar_PRODUTO,\n"
                + "                     \n"
                + "                     pode_cadastrar_EQUIPAMENTO,\n"
                + "                     pode_consultar_EQUIPAMENTO,\n"
                + "                     pode_alterar_EQUIPAMENTO,\n"
                + "                     pode_desligar_EQUIPAMENTO,\n"
                + "                     \n"
                + "                     pode_cadastrar_MANUTENCAO,\n"
                + "                     pode_consultar_MANUTENCAO,\n"
                + "                     pode_alterar_MANUTENCAO,\n"
                + "                     pode_desligar_MANUTENCAO,\n"
                + "                     \n"
                + "                     pode_cadastrar_CARGO,\n"
                + "                     pode_consultar_CARGO,\n"
                + "                     pode_alterar_CARGO,\n"
                + "                     pode_desligar_CARGO,\n"
                + "                     \n"
                + "                     pode_cadastrar_FUNCIONARIO,\n"
                + "                     pode_consultar_FUNCIONARIO,\n"
                + "                     pode_alterar_FUNCIONARIO,\n"
                + "                     pode_desligar_FUNCIONARIO,\n"
                + "                     \n"
                + "                     pode_gerar_BACKUP,\n"
                + "                     pode_restaurar_BACKUP,\n"
                + "                     \n"
                + "                     pode_gerar_RELATORIO,\n"
                + "                     \n"
                + "                 	ativo) VALUES (1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1);\n"
                + "                    \n"
                + "INSERT INTO BD_LJ.Cargos (cargo, salario, permissao, ativo) VALUES ('Administrador', 0.0, 1, 1);\n"
                + "\n"
                + "INSERT INTO BD_LJ.Codigos_de_cadastro (codigo_De_Cadastro, utilizado, cargo, ativo) VALUES ('1234', 1, 1, 1);\n"
                + "\n"
                + "INSERT INTO BD_LJ.Credenciais_de_acesso (usuario, senha, cod_cadastro) VALUES ('admin', 'admin', '1234');"
                + "END";

// TRATAMENTO DE ERROS
        try {

            // PREPARAR COMANDO PARA EXXECUTAR
            PreparedStatement pQuery = Conectar().prepareStatement(comandoSQL);
            pQuery.execute();

            //SE TUDO DER CERTO, RETORNAR TRUE
            return true;

        } catch (SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " NO MÉTODO 'CRIAR STATEMENT' \n" + erro);
            return false;
        }
    }

    private boolean ChamarProcedure() {
        // CRIAR COMANDO SQL
        String comandoSQL = "CALL BD_LJ.GerarTabelas();";

        // TRATAMENTO DE ERROS
        try {

            // PREPARAR COMANDO PARA EXXECUTAR
            PreparedStatement pQuery = Conectar().prepareStatement(comandoSQL);
            pQuery.execute();

            System.out.println("BANCO DE DADOS CRIADO COM SUCESSO!");

            //SE TUDO DER CERTO, RETORNAR TRUE
            return true;

        } catch (SQLException erro) {
            System.out.println("DEU ERRO EM " + this.getClass().getCanonicalName() + " NO MÉTODO 'ChamarProcedure' \n" + erro);
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

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}