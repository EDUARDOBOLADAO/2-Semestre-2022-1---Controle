/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jdbc.ConnectorFactory;
import modelo.Funcionarios;
import java.util.List;
import modelo.WebServiceCep;
import visao.FrmLogin;
import visao.FrmMenu;

/**
 *
 * @author Geral
 */
public class FuncionariosDAO {

    private Connection con;

    public FuncionariosDAO() {
        this.con = new ConnectorFactory().getConnection();
    }

    //Método Cadastrar Funcionario
    public void cadastrarFuncionario(Funcionarios obj) {
        try {
            //1 Passo criar o comando sql
            String sql = "insert into tb_funcionarios (nome,rg,cpf,email,senha,cargo,nivel_acesso,telefone,celular,cep,endereco,numero,complemento,bairro,cidade,estado) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            //2 - Conectar  ao Banco e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());

            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());

            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());

            //3° Passo excutar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Successo!");

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Errado: " + erro);
        }

    }

//Metodo AlterarFuncionario
    public void alterarFuncionario(Funcionarios obj) {
        try {

//1 passo - criar o comando sql
            String sql = "update tb_funcionarios set nome=?, rg=?, cpf=?, email=?, senha=?, cargo=?, nivel_acesso=?, telefone=?, celular=?, cep=?, "
                    + "endereco=?, numero=?,complemento=?,bairro=?,cidade=?, estado=? where id =?";

//2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());
            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());

            stmt.setInt(17, obj.getId());

//3 passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

    //Metodo Listar Todos Funcionarios
    public List<Funcionarios> listarFuncionarios() {
        try {

//1 passo criar a lista
            List<Funcionarios> lista = new ArrayList<>();

//2 passo - criar o sql , organizar e executar.
            String sql = "select * from tb_funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionarios obj = new Funcionarios();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }

//metodo consulta Funcionario por Nome
    public Funcionarios consultaPorNome(String nome) {
        try {
//1 passo - criar o sql , organizar e executar.
            String sql = "select * from tb_funcionarios where nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            Funcionarios obj = new Funcionarios();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Funcioario não encontrado!");
            return null;
        }
    }

// Metodo ExcluirFuncionario
    public void excluirFuncionarios(Funcionarios obj) {
        try {

//1 passo - criar o comando sql
            String sql = "delete from tb_funcionarios where id = ?";

//2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

//3 passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }
//metodo busca Funcionario por Cpf

    public Funcionarios buscaporcpf(String cpf) {
        try {
//1 passo - criar o sql , organizar e executar.
            String sql = "select * from tb_funcionarios where cpf = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);

            ResultSet rs = stmt.executeQuery();
            Funcionarios obj = new Funcionarios();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
            }

            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Funcionario não encontrado!");
            return null;
        }
    }

//Metodo buscarFuncionarioPorNome - retorna uma lista
    public List<Funcionarios> buscaFuncionarioPorNome(String nome) {
        try {

//1 passo criar a lista
            List<Funcionarios> lista = new ArrayList<>();

//2 passo - criar o sql , organizar e executar.
            String sql = "select * from tb_funcionarios where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionarios obj = new Funcionarios();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }
    }

    public Funcionarios buscaCep(String cep) {

        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);

        Funcionarios obj = new Funcionarios();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());

            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }

    public void excluirFuncionario(Funcionarios obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //Metodo efetuarLogin
    public void efetuarLogin(String email, String senha) {
        try {
//passo 1 - SQL
            String sql = "select * from tb_funcionarios where email = ? and senha = ?";

            PreparedStatement stmt = con.prepareCall(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
//Usuario Logou

//Caso o usuario seja do tipo Administrador
                if (rs.getString("nivel_acesso").equals("Administrador")) {
                    JOptionPane.showMessageDialog(null, "Seja bem ao Sistema!");
                    FrmMenu telaMenu = new FrmMenu();
                    telaMenu.usuariologado = rs.getString("nome");
                    telaMenu.setVisible(true);
                } else if (rs.getString("nivel_acesso").equals("Usuário")) {
                    JOptionPane.showMessageDialog(null, "Seja bem ao Sistema!");
                    FrmMenu telaMenu = new FrmMenu();
                    telaMenu.usuariologado = rs.getString("nome");
                    telaMenu.setVisible(true);
//Desabilitar os menus
                    telaMenu.jMnItmPosicaoDia.setEnabled(false);
                    telaMenu.jMnItmControleVendas.setEnabled(false);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Dados incorretos!");
                new FrmLogin().setVisible(true);
            }
        } catch (Exception e) {
//Erro de login

        }
    }
}
