package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Time;

public class TimeDAO extends DAO {
    
    public TimeDAO() {
        super();
        conectar();
    }

    public void finalize() {
        close();
    }
    
    public boolean insert(Time time) {
        boolean status = false;
        try {  
            Statement st = conexao.createStatement();
            String sql = "INSERT INTO time (codigo, nome, torcida, titulos) "
                       + "VALUES (" + time.getCodigo() + ", '" + time.getNome() + "', "  
                       + time.getTorcida() + ", " + time.getTitulos() + ");";
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException u) {  
            throw new RuntimeException(u);
        }
        return status;
    }

    public Time get(int codigo) {
        Time time = null;
        
        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM time WHERE codigo = " + codigo;
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);    
            if (rs.next()) {            
                time = new Time(rs.getInt("codigo"), rs.getString("nome"), rs.getInt("torcida"), rs.getInt("titulos"));
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return time;
    }

    public List<Time> get() {
        return get("");
    }

    public List<Time> getOrderByCodigo() {
      return get("codigo");		
    }

    private List<Time> get(String orderBy) {    
        List<Time> times = new ArrayList<>();
        
        try {
            Statement st = conexao.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            String sql = "SELECT * FROM time" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
            System.out.println(sql);
            ResultSet rs = st.executeQuery(sql);               
            while (rs.next()) {                
                Time t = new Time(rs.getInt("codigo"), rs.getString("nome"), rs.getInt("torcida"), rs.getInt("titulos"));
                times.add(t);
            }
            st.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return times;
    }

    public boolean update(Time time) {
        boolean status = false;
        try {  
            Statement st = conexao.createStatement();
            String sql = "UPDATE time SET nome = '" + time.getNome() + "', torcida = "  
                       + time.getTorcida() + ", titulos = " + time.getTitulos() 
                       + " WHERE codigo = " + time.getCodigo();
            System.out.println(sql);
            st.executeUpdate(sql);
            st.close();
            status = true;
        } catch (SQLException u) {  
            throw new RuntimeException(u);
        }
        return status;
    }

    public boolean delete(int codigo) {
        boolean status = false;
        try {  
            Statement st = conexao.createStatement();
            String sql = "DELETE FROM time WHERE codigo = " + codigo;
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
