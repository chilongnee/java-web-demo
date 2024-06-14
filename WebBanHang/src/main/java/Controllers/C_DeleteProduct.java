package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Service.ProductService;

/**
 * Servlet implementation class C_DeleteProduct
 */
@WebServlet("/deleteProduct")
public class C_DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService productService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public C_DeleteProduct() {
        super();
        this.productService = new ProductService();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean result = productService.deleteProduct(id);

            if (result) {
                response.sendRedirect("Product.jsp");
            } else {
                response.getWriter().println("Không thể xóa sản phẩm.");
            }
        } catch (NumberFormatException e) {
            response.getWriter().println("Lỗi định dạng số: " + e.getMessage());
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
