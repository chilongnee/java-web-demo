package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import Util.JDBCUtil;
import Models.Product;

public class ProductDAO {
	// FUNCTION HIỂN THỊ TOÀN BỘ SẢN PHẨM
	public ArrayList<Product> selectAllProduct() {
		ArrayList<Product> result = new ArrayList<Product>();
		try {
			// Kết nối với DTB
			Connection conn = JDBCUtil.getConnection();
			
			// Tạo đối tượng Statement
			String sql = "SELECT * FROM product";
			PreparedStatement st = conn.prepareStatement(sql);
			
			// Thực thi câu lệnh SQL
			ResultSet rs = st.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				double price = rs.getDouble("price");
				int quantity = rs.getInt("quantity");
				String image = rs.getString("image");
				
				Product product = new Product(id, name, price, quantity, image);
				result.add(product);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	// FUNCTION LẤY SẢN PHẨM THEO ID
	public Product selectProductById(int id) {
	    Product product = null;
	    try {
	        Connection conn = JDBCUtil.getConnection();
	        String sql = "SELECT * FROM product WHERE id = ?";
	        PreparedStatement st = conn.prepareStatement(sql);
	        st.setInt(1, id);
	        ResultSet rs = st.executeQuery();
	        
	        if (rs.next()) {
	            String name = rs.getString("name");
	            double price = rs.getDouble("price");
	            int quantity = rs.getInt("quantity");
	            String image = rs.getString("image");
	            
	            product = new Product(id, name, price, quantity, image);
	        }
	        JDBCUtil.closeConnection(conn);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return product;
	}
	
	// FUNCTION THÊM SẢN PHẨM
	public int insertProduct(Product product) {
		int result = 0;
		try {
			// Kết nối với DTB
			Connection conn = JDBCUtil.getConnection();
			
			// Tạo đối tượng Statement
			String sql = "INSERT INTO product(name, price, quantity, image) VALUES (?, ?, ?, ?)";
			
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, product.getName());
			st.setDouble(2, product.getPrice());
			st.setInt(3, product.getQuantity());
			st.setString(4, product.getImage());
			
			// Thực thi câu lệnh SQL
			result = st.executeUpdate();
			
			// Đóng kết nối
			JDBCUtil.closeConnection(conn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	// FUNCTION XÓA SẢN PHẨM
	public int deleteProduct(int id) {
	    int result = 0;
	    try {
	        Connection conn = JDBCUtil.getConnection();
	        String sql = "DELETE FROM product WHERE id = ?";
	        PreparedStatement st = conn.prepareStatement(sql);
	        st.setInt(1, id);

	        result = st.executeUpdate();
	        JDBCUtil.closeConnection(conn);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return result;
	}

	
	// FUNCTION CẬP NHẬT SẢN PHẨM
	public int updateProduct(Product product) {
		int result = 0;
		try {
			// Kết nối với DTB
			Connection conn = JDBCUtil.getConnection();
			
			// Tạo đối tượng Statement
			String sql = "UPDATE product SET name = ?, price = ?, quantity = ?, image = ? WHERE id = ?";
			
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, product.getName());
			st.setDouble(2, product.getPrice());
			st.setInt(3, product.getQuantity());
			st.setString(4, product.getImage());
			st.setInt(5, product.getId());
			
			// Thực thi câu lệnh SQL
			result = st.executeUpdate();
			
			// Đóng kết nối
			JDBCUtil.closeConnection(conn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	// FUNCTION TÌM KIẾM SẢN PHẨM THEO TÊN
	public ArrayList<Product> searchProductsByName(String name) {
	    ArrayList<Product> products = new ArrayList<>();
	    try {
	    	// Kết nối với DTB
	        Connection conn = JDBCUtil.getConnection();
	        
	        // Tạo đối tượng Statement
	        String sql = "SELECT * FROM product WHERE name LIKE ?";
	        PreparedStatement st = conn.prepareStatement(sql);
	        st.setString(1, "%" + name + "%");
	        ResultSet rs = st.executeQuery();
	        
	        while (rs.next()) {
	            int id = rs.getInt("id");
	            String productName = rs.getString("name");
	            double price = rs.getDouble("price");
	            int quantity = rs.getInt("quantity");
	            String image = rs.getString("image");
	            
	            Product product = new Product(id, productName, price, quantity, image);
	            products.add(product);
	        }
	        // Đóng kết nối
	        JDBCUtil.closeConnection(conn);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return products;
	}
}
