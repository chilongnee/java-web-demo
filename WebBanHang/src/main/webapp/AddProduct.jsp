<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm sản phẩm</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<div class="container mt-5">
		<h1 class="mb-4">Thêm sản phẩm mới</h1>
		<form action="themSanPham" method="post">
			<div class="mb-3">
				<label for="name" class="form-label">Tên sản phẩm</label>
				<input type="text" class="form-control" id="name" name="name" required>
			</div>
			<div class="mb-3">
				<label for="price" class="form-label">Giá sản phẩm</label>
				<input type="number" step="0.01" class="form-control" id="price" name="price" required>
			</div>
			<div class="mb-3">
				<label for="quantity" class="form-label">Số lượng trong kho</label>
				<input type="number" class="form-control" id="quantity" name="quantity" required>
			</div>
			<div class="mb-3">
				<label for="image" class="form-label">Hình ảnh sản phẩm</label>
				<input type="text" class="form-control" id="image" name="image" required>
			</div>
			<button type="submit" class="btn btn-primary">Thêm sản phẩm</button>
		</form>
	</div>
</body>
</html>
