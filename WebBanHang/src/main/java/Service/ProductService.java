package Service;

import java.util.ArrayList;

import Dao.ProductDAO;
import Models.Product;

public class ProductService {
	private ProductDAO productDAO;
	
    public ProductService() {
        this.productDAO = new ProductDAO();
    }

    // Lấy tất cả sản phẩm
    public ArrayList<Product> selectAllProduct() {
        return productDAO.selectAllProduct();
    }

    // Lấy sản phẩm theo ID
    public Product selectProductById(int id) {
        return productDAO.selectProductById(id);
    }

    // Thêm sản phẩm
    public boolean insertProduct(Product product) {
        if (product != null && product.getName() != null && product.getPrice() > 0 && product.getQuantity() >= 0) {
            return productDAO.insertProduct(product) > 0;
        }
        return false;
    }

    // Cập nhật sản phẩm
    public boolean updateProduct(Product product) {
        if (product != null && product.getId() > 0 && product.getName() != null && product.getPrice() > 0 && product.getQuantity() >= 0) {
            return productDAO.updateProduct(product) > 0;
        }
        return false;
    }

    // Xóa sản phẩm
    public boolean deleteProduct(int id) {
        if (id > 0) {
            return productDAO.deleteProduct(id) > 0;
        }
        return false;
    }

    // Tìm kiếm sản phẩm theo tên
    public ArrayList<Product> searchProductsByName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            return productDAO.searchProductsByName(name);
        }
        return new ArrayList<>();
    }
	
}
