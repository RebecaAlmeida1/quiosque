package br.com.senai.sp.cadastrocliente.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.senai.sp.cadastrocliente.model.Cliente;

public class ClienteDao {
	private Connection conexao;

	public ClienteDao() {
		conexao = ConnectionFactory.conectar();
	}

	public void inserir(Cliente cliente) {
		String sql = "insert into tb_cliente(nome,data_nascimento,genero,endereco,telefone,email,produto)"
				+ "values(?,?,?,?,?,?,?)";
		PreparedStatement stmt;
		try {

			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setDate(2, new Date(cliente.getDataNascimento().getTimeInMillis()));
			stmt.setInt(3, cliente.getGenero());
			stmt.setString(4, cliente.getEndereco());
			stmt.setString(5, cliente.getTelefone());
			stmt.setString(6, cliente.getEmail());
			stmt.setString(7, cliente.getProduto());
			stmt.execute();

		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}
	
	
//public List<Calendar> calendar(){
	//String data = "select * from tb_cliente order by data_cadas 123";
	//PreparedStatement stmt; 
	//List<Calendar> estatistica = new ArrayList<Calendar>();
	
//	try {
		//stmt= conexao.prepareStatement(data);
	//ResultSet res = stmt.executeQuery();
	//while (res.next()) {
	//	Cliente = new Cliente();
	//	Calendar calendar = new Calendar.getInstance();
	//	Date semana = res.getDate("data_cadas");
	//	lista.add(c);
		
	
	
	

	public List<Cliente> listar() {
		String sql = "select * from tb_cliente order by nome asc";
		PreparedStatement stmt;
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cliente c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				Calendar nascimento = Calendar.getInstance();
				Date nascDb = rs.getDate("data_nascimento");
				c.setDataNascimento(nascimento);
				nascimento.setTimeInMillis(nascDb.getTime());
				c.setGenero(rs.getInt("genero"));
				c.setEndereco(rs.getString("endereco"));
				c.setTelefone(rs.getString("telefone"));
				c.setEmail(rs.getString("email"));
				c.setProduto(rs.getString("produto"));

				lista.add(c);

			}
			rs.close();
			stmt.close();
			conexao.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void excluir(long idCliente) {
		String sql = "delete from tb_cliente where id = ?";
		PreparedStatement stmt;

		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, idCliente);
			stmt.execute();
			stmt.close();
			return;
		} catch (Exception e) {

		}

	}

	public void alterar(Cliente cliente) {
		String sql = "upddate tb_cliente set nome=?,data_nascimento=?,genero=?,endereco=?,telefone=?,email=?,produto=?,data_cadastro=?,periodo=?) where id = ?";
		PreparedStatement stmt;
		try {

			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setDate(2, new Date(cliente.getDataNascimento().getTimeInMillis()));
			stmt.setInt(3, cliente.getGenero());
			stmt.setString(4, cliente.getEndereco());
			stmt.setString(5, cliente.getTelefone());
			stmt.setString(6, cliente.getEmail());
			stmt.setString(7, cliente.getProduto());

			stmt.execute();

		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

	public Cliente buscar(long idCliente){
		String sql = "select * from tb_cliente where id =?";
		PreparedStatement stmt;
		Cliente c = null;
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, idCliente);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				 c = new Cliente();
				c.setId(rs.getLong("id"));
				c.setNome(rs.getString("nome"));
				Calendar nascimento = Calendar.getInstance();
				Date nascDb = rs.getDate("data_nascimento");
				c.setDataNascimento(nascimento);
				nascimento.setTimeInMillis(nascDb.getTime());
				c.setGenero(rs.getInt("genero"));
				c.setEndereco(rs.getString("endereco"));
				c.setTelefone(rs.getString("telefone"));
				c.setEmail(rs.getString("email"));
				c.setProduto(rs.getString("produto"));

			}
			rs.close();
			stmt.close();
			conexao.close();
			return c;
		} catch (Exception e) {
			throw new RuntimeException(e);

		}
	}

}