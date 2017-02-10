package br.com.contatos.model;
import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUsuarioDao {

	private Connection connection;
	
	@Autowired
	public JdbcUsuarioDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
//	public Boolean existeUsuario(Usuario usuario){
//		String sql = "select * from usuarios where usuario = ? and senha = ?";
//		
//		PreparedStatement stmt;
//		try {
//			stmt = connection.prepareStatement(sql);
//			stmt.setString(1, usuario.getUsuario());
//			stmt.setString(2, usuario.getSenha());
//			ResultSet rs = stmt.executeQuery();
//
//			return rs.first();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return false;
//	}
	
	public Boolean existeUsuario(Usuario usuario){
	
		return true;
	}
}
