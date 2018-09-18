package br.edu.Insper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {
	private Connection connection = null;
	public DAO() {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/projeto1", "root", "02039855oioioi9");
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void adicionaUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuarios " + 
				"(nome,email,senha) values(?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alteraUsuario(Usuario usuario) {
		String sql = "UPDATE usuarios SET " + 
				"nome=?, email=?, senha=? WHERE id_usuario=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1,  usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.setInt(4, usuario.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeUsuario(Integer idUsuario) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM usuarios WHERE id_usuario=?");
			stmt.setLong(1, idUsuario);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Usuario> getListaUsuarios() {
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		PreparedStatement stmt;
		String sql = "SELECT * FROM usuarios";
		try {
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rs.getInt("id_usuario"));
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuarios.add(usuario);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public void adicionaMural(Mural mural) {
		String sql = "INSERT INTO murais " + 
				"(id_usuario, nome) values(?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, mural.getIdUsuario());
			stmt.setString(2, mural.getNome());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alteraMural(Mural mural) {
		String sql = "UPDATE murais SET " + 
				"nome=?, ultima_mod=?, estilo=? WHERE id_mural=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, mural.getNome());
			stmt.setTimestamp(2, mural.getUltimaMod());
			stmt.setString(3, mural.getEstilo());
			stmt.setInt(4, mural.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alteraDataMural(Mural mural) {
		String sql = "UPDATE murais SET " + 
				"ultima_mod=? WHERE id_mural=?";
		PreparedStatement stmt;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setTimestamp(1, mural.getUltimaMod());
			stmt.setInt(2, mural.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void removeMural(Integer idMural) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM murais WHERE id_mural=?");
			stmt.setLong(1, idMural);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getNomeMural(int id_mural) {
		String nomeMural = null;

		PreparedStatement stmt;
		String sql = "SELECT * FROM murais WHERE " + "id_mural=?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id_mural);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				nomeMural = rs.getString("nome");
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return nomeMural;
	}
	
	public ArrayList<Mural> getListaMurais(int id_usuario) {
		ArrayList<Mural> murais = new ArrayList<Mural>();
		
		PreparedStatement stmt;
		String sql = "SELECT * FROM murais WHERE " + "id_usuario=?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id_usuario);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Mural mural = new Mural();
				mural.setId(rs.getInt("id_mural"));
				mural.setNome(rs.getString("nome"));
				mural.setDataCriacao(rs.getTimestamp("data_criacao"));
				mural.setUltimaMod(rs.getTimestamp("ultima_mod"));
				mural.setEstilo(rs.getString("estilo"));
				mural.setIdUsuario(rs.getInt("id_usuario"));
				murais.add(mural);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return murais;
	}
	

	public void adicionaNota(Nota nota) {
		String sql = "INSERT INTO notas " + 
				"(tipo, conteudo, id_mural) VALUES (?,?,?)";

		try {
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, nota.getTipo());
			stmt.setString(2, nota.getConteudo());
			stmt.setInt(3, nota.getIdMural());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alteraNota(Nota nota) {
		String sql = "UPDATE notas SET " + 
				"tipo=?, conteudo=? WHERE id_nota=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			System.out.println(nota.getId());
			stmt.setString(1, nota.getTipo());
			stmt.setString(2, nota.getConteudo());
			stmt.setInt(3, nota.getId());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Nota> getListaNotas(int id_mural) {
		ArrayList<Nota> notas = new ArrayList<Nota>();

		PreparedStatement stmt;
		String sql = "SELECT * FROM notas WHERE " + "id_mural=?";
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id_mural);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Nota nota = new Nota();
				nota.setId(rs.getInt("id_nota"));
				nota.setTipo(rs.getString("tipo"));
				nota.setConteudo(rs.getString("conteudo"));
				nota.setIdMural(rs.getInt("id_mural"));
				notas.add(nota);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notas;
	}
	
	
	
	public void removeNota(Integer idNota) {
		try {
			PreparedStatement stmt = connection.prepareStatement("DELETE FROM notas WHERE id_nota=?");
			stmt.setLong(1, idNota);
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
