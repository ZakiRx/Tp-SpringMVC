

<%@ include file="header.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container">
	<h2>New Product</h2>

	<div class="row">
		<div class="col-md-6 mx-auto">
			<form:form action="/produit/save" method="post"
				modelAttribute="produit">
				<div class="form-group">
					<label>Name</label>
					<form:input path="name" cssClass="form-control" />
					<label>Description</label>
					<form:textarea path="description" cssClass="form-control" />
					<label>Price</label>
					<form:input path="price" cssClass="form-control" />
					<label>Categories</label>
					<div class="categories">
						<form:checkboxes itemValue="id"
							cssClass="form-check-input mt-2 ml-3" itemLabel="name"
							element="div" path="categories" items="${categories}" />
					</div>

					<button class="btn btn-success mt-3" type="submit">Add</button>
				</div>

				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#newCat">New Category</button>
				<!-- Modal -->
				<div class="modal fade" id="newCat" tabindex="-1" role="dialog"
					aria-labelledby="exampleModalLabel" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body">
								<label for="nameCat">Name Category</label> <input id="nameCat"
									type="text" class="form-control">
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary new-cat">Add
									Category</button>
							</div>
						</div>
					</div>
				</div>
			</form:form>

		</div>

	</div>

</div>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"
	integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script type="text/javascript">
	$(".new-cat").click(function(e) {
		e.preventDefault();
		let category = $("#nameCat").val();
		console.log(category);
		$.ajax({
			type : 'POST',
			contentType : 'application/json',
			data : JSON.stringify(category),
			dataType : 'json',
			url : "/api/category/save",
			success : function(response) {
				
				//get last id
				let idcat= parseInt($(".categories div").last().find("input").val())+1;
				
				$(".modal").append("<p class='alert alert-success w-25'>Category Added </p>");
				$(".categories").append("<div><input id="+idcat+" type='checkbox' class='form-check-input mt-2 ml-3' name='categories' value="+idcat+" /><label for="+idcat+">"+response.name+"</label></div>");
			}
		});

	});
</script>
</body>
</html>