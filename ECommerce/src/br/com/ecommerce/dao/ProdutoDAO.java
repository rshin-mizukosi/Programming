package br.com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ecommerce.bean.Produto;
import br.com.ecommerce.factory.ConnectionFactory;

public class ProdutoDAO {
	Connection conn = null;
	
	public ProdutoDAO() {
		try {
			conn = ConnectionFactory.getConnection();
		} catch(SQLException e) { }
	}
	
	public void insere(Produto p) {
		String sql = "INSERT INTO Produtos (ID, Nome, Preco) VALUES (?,?,?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, p.getId());
			stmt.setString(2, p.getNome());
			stmt.setDouble(3, p.getPreco());
			
			stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally { }
	}
	
	public Produto getByID(Integer id) {
		String sql = "SELECT ID, Nome, Preco FROM Produtos WHERE ID = ?";
		
		Produto p = null;
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				p = new Produto();
				p.setId(rs.getInt("ID"));
				p.setNome(rs.getString("Nome"));
				p.setPreco(rs.getDouble("Preco"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		finally { }
		
		return p;
	}
}
