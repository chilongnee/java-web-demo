package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Product;
import Service.ProductService;

/**
 * Servlet implementation class C_InsertProduct
 */
@WebServlet("/themSanPham")
public class C_AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_AddProduct() {
        super();
        this.productService = new ProductService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        String name = request.getParameter("name"); // đều trả về String
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String image = request.getParameter("image");
        
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setImage(image);
        
        
        productService.insertProduct(product);
        // Chuyển trang lại
        response.sendRedirect("Product.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
