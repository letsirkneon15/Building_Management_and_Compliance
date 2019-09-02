<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">All buildings</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Name</th>
						<th>Attachment</th>
						<th>Type</th>
						<th>Uploaded By</th>
						<th>Last Uploaded</th>
						<th>Actions</th>
					</tr>
				</thead>

				<!-- Start Rows -->
				<tbody>
					<c:forEach var="b" items="${asbestosArr}" varStatus="bIndex">
						<tr>
							<td>${b.name }</td>
							<td>${b.attachment }</td>
							<td>${b.type }</td>
							<td>${b.uploadedBy }</td>
							<td>${b.lastUploadedBy }</td>
							<td><a href="#downloadCloud" data-toggle="modal"
								data-id="downloadLink${bIndex.index}"
								data-buildingId="${b.buildingId}"><img
									src='images/download_cloud.png' height=15 width=15></a></td>
							<td><a href="#editRecord" data-toggle="modal"
								data-id="edtLink${bIndex.index}"
								data-buildingId="${b.buildingId}"><img src='images/edit.jpg'
									height=15 width=15></a></td>
							<%-- <td><a href="" id="dltLink${hsIndex.index}"><img src='images/delete.jpg' height=15 width=15></a> --%>
							<td><a href="#deleteRecord" data-toggle="modal"
								data-id="dltLink${bIndex.index}"
								data-buildingId="${b.buildingId}"><img
									src='images/delete.jpg' height=15 width=15></a></td>
						</tr>
					</c:forEach>
				</tbody>
				<!-- End Rows -->

			</table>
		</div>
	</div>
</div>
<!-- End of DataTables -->

