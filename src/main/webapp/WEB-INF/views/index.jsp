
<%@ include file="header.jsp"  %>
	<div class="container">
		<h2 class="text-center">Products</h2>
		
		<a href="new" class="btn btn-info mb-3">New Product</a>
		<div class="row">
			<c:forEach items="${produits}" var="produit">
				<div class="col-md-4 mb-3">
					<div class="card shadow">
					    <div class="p-2">
					    <img class="card-img-top" src="https://picsum.photos/seed/picsum/200/150" alt="${produit.name}">
					    </div>
						<div class="card-body">
							<h5 class="card-title">${produit.name}</h5>
							<p class="card-text">${produit.description}</p>
							<span class="h5">${produit.price}</span> <a href="${produit.id}" class="btn btn-primary">edit</a>
						</div>
					</div>

				</div>
			</c:forEach>


		</div>
	</div>


</body>
</html>