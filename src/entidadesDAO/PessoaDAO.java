/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidadesDAO;

import InterfaceDAO.InterfacePessoaDAO;
import controler.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Josiel e Andreza
 */
public class PessoaDAO extends ConectionDAO implements InterfacePessoaDAO {

    
    @Override
    public void criar(Pessoa pessoa) {

        String SQL;
        SQL = "INSERT INTO pessoa (cpf,gerente_Login,pnome,rg,rua,numero,bairro,cep,tipoPessoa,telefone,cidade)"
                + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        conectar(SQL);
        try {
            pstm.setString(1, pessoa.getCpf());
            pstm.setString(2, pessoa.getGerenteLogin());
            pstm.setString(3, pessoa.getPnome());
            pstm.setInt(4, pessoa.getRg());
            pstm.setString(5, pessoa.getRua());
            pstm.setInt(6, pessoa.getNumero());
            pstm.setString(7, pessoa.getBairro());
            pstm.setString(8, pessoa.getCep());
            pstm.setString(9, pessoa.getTipoPessoa());
            pstm.setString(10, pessoa.getTelefone());
            pstm.setString(11, pessoa.getCidade());
            pstm.execute();
            pstm.close();

        } catch (SQLException ex) {
            imprimeErro("Erro ao Cadastrar uma Pessoa", ex.getMessage());
        }
    }

    @Override
    public Pessoa buscar(String cpf, String tipo) {

        String buscarPessoa = "SELECT * FROM pessoa WHERE cpf = '" + cpf +
                "' AND TipoPessoa = '" + tipo + "'"; //busca apenas uma pessoa pelo CPF
        ResultSet result;
        Pessoa pessoa = new Pessoa();
        conectar(buscarPessoa);
        try {
            result = pstm.executeQuery();
            while (result.next()) {
                pessoa.setCpf(result.getString("CPF"));
                pessoa.setRg(result.getInt("RG"));
                pessoa.setGerenteLogin(result.getString("Gerente_login"));
                pessoa.setCep(result.getString("CEP"));
                pessoa.setRua(result.getString("Rua"));
                pessoa.setBairro(result.getString("Bairro"));
                pessoa.setTelefone(result.getString("Telefone"));
                pessoa.setNumero(result.getInt("Numero"));
                pessoa.setPnome(result.getString("PNome"));
                pessoa.setTipoPessoa(result.getString("TipoPessoa"));
                pessoa.setCidade(result.getString("cidade"));

            }
        } catch (SQLException ex) {
            //System.err.println("CPF De Pessoa nao confere com dados do banco");
            imprimeErro("Erro ao Buscar uma Pessoa", ex.getMessage());
        }
        fechar();
        return pessoa;
    }

    //Atualiza uma determinada pessoa
    @Override
    public void atualizar(Pessoa pessoa) {

        String atualizar = "UPDATE pessoa SET "
                + "gerente_Login = ?,"
                + "pnome = ?,"
                + "RG = ?,"
                + "Rua = ?,"
                + "Numero = ?,"
                + "Bairro = ?,"
                + "CEP = ?,"
                + "TipoPessoa = ?,"
                + "Telefone = ?,"
                + "Cidade = ? "
                + "WHERE CPF = ?";

        conectar(atualizar);
        try {
            pstm.setString(1, pessoa.getGerenteLogin());
            pstm.setString(2, pessoa.getPnome());
            pstm.setInt(3, pessoa.getRg());
            pstm.setString(4, pessoa.getRua());
            pstm.setInt(5, pessoa.getNumero());
            pstm.setString(6, pessoa.getBairro());
            pstm.setString(7, pessoa.getCep());
            pstm.setString(8, pessoa.getTipoPessoa());
            pstm.setString(9, pessoa.getTelefone());
            pstm.setString(10, pessoa.getCidade());
            pstm.setString(11, pessoa.getCpf());

            pstm.executeUpdate();

            System.out.println("Pessoa atualizada");
            fechar();

        } catch (SQLException ex) {
            imprimeErro("Erro ao Atualizar Pessoas", ex.getMessage());
        }
    }

    //REMOVE UMA PESSOA DO BANCO DE DADOS
    @Override
    public void remover(Pessoa pessoa) {

        String sql = "DELETE FROM pessoa WHERE CPF = ?";
        conectar(sql);

        try {
            pstm.setString(1, pessoa.getCpf());
            pstm.execute();
            pstm.close();
            System.out.println("Pessoa removida com sucesso");
        } catch (SQLException ex) {
            imprimeErro("Erro ao Remover Pessoas", ex.getMessage());
        }
    }

    @Override
    public ArrayList<Pessoa> buscarPessoas(String tipo) {

            String sql = "SELECT * FROM pessoa WHERE TipoPessoa = '"+ tipo + "'";
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        ResultSet result;
        conectar(sql);
        
        try {
            result = pstm.executeQuery();
            while (result.next()) {
                Pessoa pessoa = new Pessoa();
                // pega todos os atributos da pessoa  
                pessoa.setPnome(result.getString("PNome"));
                pessoa.setBairro(result.getString("Bairro"));
                pessoa.setCep(result.getString("CEP"));
                pessoa.setNumero(result.getInt("Numero"));
                pessoa.setRua(result.getString("Rua"));
                pessoa.setCpf(result.getString("CPF"));
                pessoa.setRg(result.getInt("RG"));
                pessoa.setTelefone(result.getString("Telefone"));
                pessoa.setCidade(result.getString("cidade"));

                pessoas.add(pessoa);
            }
            return pessoas;

        } catch (SQLException ex) {
            imprimeErro("Erro ao Buscar Pessoas", ex.getMessage());
        }
        return null;

    }
    
    
    public ArrayList<Pessoa> buscarPessoaNome(String nome) {

        String sql = "SELECT * FROM pessoa WHERE pnome LIKE '" + nome + "'";
        ArrayList<Pessoa> pessoas = new ArrayList<>();
        ResultSet result;

        try {
            conectar(sql);
            result = pstm.executeQuery();
            while (result.next()) {
                Pessoa pessoa = new Pessoa();
                // pega todos os atributos da pessoa  
                pessoa.setPnome(result.getString("PNome"));
                pessoa.setBairro(result.getString("Bairro"));
                pessoa.setCep(result.getString("CEP"));
                pessoa.setNumero(result.getInt("Numero"));
                pessoa.setRua(result.getString("Rua"));
                pessoa.setCpf(result.getString("CPF"));
                pessoa.setRg(result.getInt("RG"));
                pessoa.setTelefone(result.getString("Telefone"));
                pessoa.setCidade(result.getString("cidade"));

                pessoas.add(pessoa);
            }
            return pessoas;

        } catch (SQLException ex) {
            imprimeErro("Erro ao Buscar Pessoas", ex.getMessage());
        }
        return null;

    }
}