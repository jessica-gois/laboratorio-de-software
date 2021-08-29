package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import db.Database;
import model.domain.Cartao;
import model.domain.EntidadeDominio;

public class CartaoDAO implements IDAO {

	public String salvar(EntidadeDominio entityDomain) {
		Cartao cartao = (Cartao) entityDomain;
		System.out.println(cartao.getId());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = Database.conectarBD();

			st = conn.prepareStatement(
					"INSERT INTO cartoes " + "(numero, nomeImpresso, bandeira, codigoSeguranca, preferencial) "
					+ "VALUES " + "(?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

			st.setString(1, cartao.getNumero());
			st.setString(2, cartao.getNomeImpresso());
			st.setString(3, cartao.getBandeira().getDescricao());
			st.setString(4, cartao.getCodigoSeguranca());
			st.setBoolean(5, cartao.getPreferencial());
			int rowsAffected = st.executeUpdate();

			System.out.println("Done! Rows affected: " + rowsAffected);
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return "Erro ao salvar";
		}

	}
//
//	public String alterar(EntityDomain entityDomain) {
//		Product product = (Product) entityDomain;
//		System.out.println(product.getIdProduct());
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Connection conn = null;
//		PreparedStatement st = null;
//		try {
//			conn = Database.conectarBD();
//
//			st = conn.prepareStatement("UPDATE product " + "SET nameProduct = ? ," + "dateProduct = ? ,"
//					+ "priceProduct=? ," + "quantityProduct=? ," + "statusProduct=? " + "WHERE " + "(idProduct=?)");
//
//			st.setString(1, product.getNameProduct());
//			st.setDate(2, new java.sql.Date(sdf.parse("2020-07-04").getTime()));
//			st.setDouble(3, product.getPriceProduct());
//			st.setInt(4, product.getQuantityProduct());
//			st.setBoolean(5, true);
//			st.setInt(6, product.getIdProduct());
//
//			int rowsAffected = st.executeUpdate();
//
//			System.out.println("Done! Rows affected: " + rowsAffected);
//			return null;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "Erro ao alterar";
//		}
//
//	}
//
//	public String excluir(EntityDomain entityDomain) {
//		Product product = (Product) entityDomain;
//		System.out.println(product.getIdProduct());
//		Connection conn = null;
//		PreparedStatement st = null;
//		try {
//			conn = Database.conectarBD();
//
//			st = conn.prepareStatement("DELETE FROM product " + "WHERE " + "idProduct = ?");
//			st.setInt(1, product.getIdProduct());
//
//			int rowsAffected = st.executeUpdate();
//			System.out.println("Done! Rows affected: " + rowsAffected);
//			return null;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return "Erro ao excluir";
//		}
//
//	}
//
//	private String pesquisarAuxiliar(EntityDomain entity) {
//		if (entity.getSearch().equals("id")) {
//			return "select * from product  WHERE idProduct=?";
//		} else {
//			return "select * from product";
//		}
//	}
//
//	private PreparedStatement executarPesquisa(Product product, String sql) throws SQLException {
//		PreparedStatement st = Database.conectarBD().prepareStatement(sql);
//		if (product.getSearch().equals("id")) {
//			st.setInt(1, product.getIdProduct());
//		}
//		return st;
//	}
//
//	public List<Product> consultar(EntityDomain entity) {
//		Product product = (Product) entity;
//		List <Product> products = new ArrayList();
//		System.out.println(product.getIdProduct());
//		Connection conn = null;
//		PreparedStatement st = null;
//		try {
//			String sql = pesquisarAuxiliar(product);
//			st = executarPesquisa(product, sql);
//			
//			ResultSet rs = st.executeQuery();
//			while (rs.next()){
//				Product productAux = new Product();	
//				productAux.setIdProduct(rs.getInt("idProduct"));
//				productAux.setNameProduct(rs.getString("nameProduct"));
//				productAux.setDateProduct(rs.getDate("dateProduct"));
//				productAux.setPriceProduct(rs.getDouble("priceProduct"));
//				productAux.setQuantityProduct(rs.getInt("quantityProduct"));
//				productAux.setStatusProduct(rs.getBoolean("statusProduct"));
//				products.add(productAux);
//				
//			}
//			
//			return products;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//
//	}
	// return ProductMock.FindAll();
	// return (List<EntityDomain>) findAll;

	@Override
	public String alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
