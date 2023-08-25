package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.X;

public class XDAO extends DAO {
	
	public XDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}
	
	
	public boolean insert(X x) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "INSERT INTO X (id, nome) "
				       + "VALUES ("+x.getId()+ ", '" + x.getNome() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public X get(int id) {
		X x = null;
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM X WHERE id=" + id;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 x = new X(rs.getInt("id"), rs.getString("nome"));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return x;
	}
	
	
	public List<X> get() {
		return get("");
	}

	
	public List<X> getOrderById() {
		return get("id");		
	}
	
	
	public List<X> getOrderByNome() {
		return get("nome");		
	}
	
	private List<X> get(String orderBy) {	
	
		List<X> x = new ArrayList<X>();
		
		try {
			Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM X" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	X xx = new X(rs.getInt("id"), rs.getString("nome"));
	            x.add(xx);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return x;
	}
	
	
	public boolean update(X x) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "UPDATE X SET nome = '" + x.getNome() + " WHERE codigo = " + x.getId();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int id) {
		boolean status = false;
		try {  
			Statement st = conexao.createStatement();
			String sql = "DELETE FROM X WHERE id = " + id;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
}