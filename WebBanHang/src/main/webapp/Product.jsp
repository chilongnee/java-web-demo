<%@page import="Service.ProductService"%>
<%@page import="Models.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sản phẩm</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container mt-5">
        <h1 class="mb-4">Danh sách sản phẩm</h1>
        <div class="mb-4">
            <a href="AddProduct.jsp" class="btn btn-primary p-2">Thêm sản phẩm</a>
            <form class="d-inline-block float-end" action="Product.jsp" method="get">
                <input type="text" name="search" class="form-control d-inline-block" style="width: auto; display: inline-block;" placeholder="Tìm kiếm sản phẩm">
                <button type="submit" class="btn btn-secondary">Tìm kiếm</button>
            </form>
        </div>
        <table class="table table-bordered mt-3">
            <thead>
                <tr>
                    <th scope="col">Hình ảnh sản phẩm</th>
                    <th scope="col">Mã sản phẩm</th>
                    <th scope="col">Tên sản phẩm</th>
                    <th scope="col">Giá sản phẩm</th>
                    <th scope="col">Số lượng trong kho</th>
                    <th scope="col">Chức năng</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ProductService productService = new ProductService();
                    ArrayList<Product> listProduct = null;
                    String searchQuery = request.getParameter("search");

                    if (searchQuery != null && !searchQuery.trim().isEmpty()) {
                        listProduct = productService.searchProductsByName(searchQuery);
                    } else {
                        listProduct = productService.selectAllProduct();
                    }

                    if (listProduct != null) {
                        for (Product sp : listProduct) {
                %>
                <tr>
                    <td><img src="<%= sp.getImage() %>" width="100"></td>
                    <td><%= sp.getId() %></td>
                    <td><%= sp.getName() %></td>
                    <td><%= sp.getPrice() %></td>
                    <td><%= sp.getQuantity() %></td>
                    <td>
                        <a href="editProduct?id=<%= sp.getId() %>" class="btn btn-warning btn-sm">Sửa</a>
                        <button class="btn btn-danger btn-sm" onclick="confirmDelete(<%= sp.getId() %>)">Xóa</button>
                    </td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="6" class="text-center">Không có sản phẩm nào.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
    <div class="modal fade" id="confirmDeleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Xác nhận xóa</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Bạn có chắc chắn muốn xóa sản phẩm này không?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Hủy</button>
                    <button type="button" class="btn btn-danger" id="deleteButton">Xóa</button>
                </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
    <script>
        let deleteId;
        function confirmDelete(id) {
            deleteId = id;
            var myModal = new bootstrap.Modal(document.getElementById('confirmDeleteModal'), {});
            myModal.show();
        }

        document.getElementById('deleteButton').addEventListener('click', function() {
            window.location.href = 'deleteProduct?id=' + deleteId;
        });
    </script>
</body>
</html>
