package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class AbstractDAO implements IDAO{
	protected Connection conn = null;
	protected PreparedStatement st = null;
	
	public void inicializarConexao() {
		conn = null;
		st = null;
	}
	
	public void setaParametrosQuery (PreparedStatement st, Object... elementos) throws SQLException {
	    int posicaoParametro = 1;
	    
	    for (Object parametro : elementos) {
	        if(parametro instanceof String) {
	        	st.setString(posicaoParametro,(String) parametro);
	        } 
	        if(parametro instanceof Integer) {
	        	st.setInt(posicaoParametro,(Integer) parametro);
	        }
	        if(parametro instanceof Boolean) {
	        	st.setBoolean(posicaoParametro,(Boolean) parametro);
	        }
			if (parametro instanceof Date) {
				Date data = (Date) parametro;
				st.setDate(posicaoParametro, new java.sql.Date(data.getTime()));
			}
	        posicaoParametro++;
	    }
	}
}
