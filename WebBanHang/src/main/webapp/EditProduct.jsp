<%@page import="Models.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa sản phẩm</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<h1 class="mb-4">Chỉnh sửa sản phẩm</h1>
		<form action="editProduct" method="post">
		<%
			Product product = (Product) request.getAttribute("product");
			if (product != null) {
		%>
			<input type="hidden" name="id" value="<%= product.getId() %>">
			<div class="mb-3">
				<label for="name" class="form-label">Tên sản phẩm:</label>
				<input type="text" class="form-control" id="name" name="name" value="<%= product.getName() %>">
			</div>
			<div class="mb-3">
				<label for="price" class="form-label">Giá sản phẩm:</label>
				<input type="number" class="form-control" id="price" name="price" value="<%= product.getPrice() %>">
			</div>
			<div class="mb-3">
				<label for="quantity" class="form-label">Số lượng:</label>
				<input type="number" class="form-control" id="quantity" name="quantity" value="<%= product.getQuantity() %>">
			</div>
			<div class="mb-3">
				<label for="image" class="form-label">Link hình ảnh:</label>
				<input type="text" class="form-control" id="image" name="image" value="<%= product.getImage() %>">
			</div>
			<button type="submit" class="btn btn-primary">Lưu</button>
		<%
			} else {
		%>
			<p>Không tìm thấy sản phẩm.</p>
		<%
			}
		%>
		</form>
	</div>
</body>
</html>
