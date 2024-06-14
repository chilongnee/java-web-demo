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
 * Servlet implementation class C_EditProduct
 */
@WebServlet("/editProduct")
public class C_EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_EditProduct() {
        super();
        this.productService = new ProductService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.selectProductById(id);

        if (product != null) {
            request.setAttribute("product", product);
            request.getRequestDispatcher("EditProduct.jsp").forward(request, response);
        } else {
            response.getWriter().println("Không tìm thấy sản phẩm.");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    try {
	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        double price = Double.parseDouble(request.getParameter("price"));
	        int quantity = Integer.parseInt(request.getParameter("quantity"));
	        String image = request.getParameter("image");
	        
	        Product product = new Product(id, name, price, quantity, image);
	        boolean result = productService.updateProduct(product);

	        if (result) {
	            response.sendRedirect("Product.jsp");
	        } else {
	            response.getWriter().println("Không thể cập nhật sản phẩm.");
	        }
	    } catch (Exception e) {
			// TODO: handle exception
	    	e.printStackTrace();
		}
	}

}
