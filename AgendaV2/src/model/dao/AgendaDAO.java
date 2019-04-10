package model.dao;

import java.sql.Connection;
import conexao.ConnectionFactory;
import dao.Exception;
import dao.String;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.bean.Agenda;

public class AgendaDAO {
    public int create(Agenda a){
         
        String sqlInsert = "INSERT INTO cliente(nome,endereco,tel,email) VALUES (?, ?, ?, ?)";

        
        try (Connection con = ConnectionFactory.getConnection();
        	PreparedStatement stm = con.prepareStatement(sqlInsert);) {
            stm.setString(1, a.getNome());
            stm.setString(2, a.getEndereco());
            stm.setInt(3, a.getTel());
            stm.setString(4, a.getEmail());
            stm.execute();
            
            String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = con.prepareStatement(sqlQuery);
					ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					a.setId_cliente(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
            
        	}catch (SQLException e) {
    			e.printStackTrace();
    		}
        
        return a.getId_cliente();
        
    }
            
  
    
    
    public void delete(int id){
        
        String sqlDelete = "DELETE FROM cliente WHERE id_cliente = ?";
        
        try (Connection con = ConnectionFactory.getConnection();
            	PreparedStatement stm = con.prepareStatement(sqlDelete);) {
            stm.setInt(1, id);
            stm.execute();
            
            
        } catch(Exception e) {
        	e.printStackTrace();
        }
    }
    
    public void update(Agenda a){
        
        String sqlUpdate = 
        "UPDATE cliente SET nome=?, endereco=?, tel=?,email=? WHERE id_cliente=?";
        
        try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement stm = con.prepareStatement(sqlUpdate);) {
            stm.setString(1, a.getNome());
            stm.setString(2, a.getEndereco());
            stm.setInt(3, a.getTel());
            stm.setString(4, a.getEmail());
            stm.setInt(5, a.getId_cliente());
            
            stm.execute();
        } catch (Exception e) {
        	e.printStackTrace();
        }

    }
    
    public Agenda read(int id_cliente){
        
        String sqlSelect = "SELECT nome, endereco, tel, email FROM cliente where id_cliente = ? ";
        
        Agenda agenda = new Agenda();
        agenda.setId_cliente(id_cliente);
        
        try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement stm = con.prepareStatement(sqlSelect);) {
           stm.setInt(1, agenda.getId_cliente());
           try (ResultSet rs = stm.executeQuery();){
        	   if (rs.next()) {
        		   agenda.setNome(rs.getString("nome"));
        		   agenda.setEndereco(rs.getString("endereco"));
        		   agenda.setTel(rs.getInt("tel"));
        		   agenda.setEmail(rs.getString("email"));
        	   } else {
        		   agenda.setId_cliente(-1);
        		   agenda.setNome(null);
        		   agenda.setEndereco(null);
        		   agenda.setTel(-1);
        		   agenda.setEmail(null);
        	   }
           } catch(Exception e) {
        	   e.printStackTrace();
           }
        } catch (SQLException e1) {
        	System.out.print(e1.getStackTrace());
        }
        
        return agenda;
    }
    
//    public List<Agenda> read() throws SQLException {
//        Connection con = ConnectionFactory.getConnection();
//        
//        PreparedStatement stm = null;
//        ResultSet rs = null;
//        String sqlInsert = "SELECT * FROM cliente";
//        
//        ArrayList<Agenda> lista = new ArrayList<Agenda>();
//        
//        try {
//            stm = con.prepareStatement(sqlInsert);
//            rs = stm.executeQuery();
//            
//            while (rs.next()) {
//               Agenda agenda = new Agenda();
//               
//               agenda.setId_cliente(rs.getInt("id_cliente"));
//               agenda.setNome(rs.getString("nome"));
//               agenda.setEndereco(rs.getString("endereco"));
//               agenda.setTel(rs.getInt("tel"));
//               agenda.setEmail(rs.getString("email"));
//               lista.add(agenda);
//            }
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//            try {
//                con.rollback();
//            } catch (Exception e1) {
//                System.out.print(e1.getStackTrace());
//            }
//        }
//        return lista;
//    }
    
}
