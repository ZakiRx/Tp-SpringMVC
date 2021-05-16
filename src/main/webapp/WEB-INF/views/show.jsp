

<%@ include file="header.jsp"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
	<div class="container">
		<h2>Edit Produit : ${produit.name}</h2>

		<div class="row">
			<div class="col-md-6 mx-auto">
				<form:form action="/produit/edit" method="post" modelAttribute="produit">
				<input name="id" type="hidden" value="${produit.id}">
					
					<div class="form-group">
					<label>Name</label>
						<form:input  path="name" cssClass="form-control mb-2"/>
					<label>Description</label>
						<form:textarea path="description" rows="5" cols="15" cssClass="form-control mb-2"/>
						<label>Price</label>
						<form:input path="price" cssClass="form-control mb-2" placeholder="Price Product" />
						
						 <label>Categories</label>

							 	<c:forEach items="${categories}" var="category">
								  <div>
								   <input type="checkbox" name="categories" id="${category.id}"   value="${category.id}"> <label for="${category.id}">${category.name}</label>
								  </div>
								</c:forEach>

							<button class="btn btn-primary mb-2" type="submit">save</button>
					</div>
				</form:form>
				<form action="delete/${produit.id}" method="post" onsubmit="return confirm('Are you sure ?')">
							 <button type="submit"  class="btn border border-danger text-danger">delete</button>
				</form>
			</div>

		</div>

	</div>
</body>
</html>