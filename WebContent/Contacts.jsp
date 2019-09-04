
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-striped table-bordered dt-responsive nowrap" id="contactsTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Name</th>
						<th>Type</th>
						<th>Company</th>
						<th>Phone</th>
						<th>Fax</th>
						<th>Mobile</th>
						<th>Email Address</th>
					</tr>
				</thead>

				<!-- Start Rows -->
				<tbody>
					<d:forEach var="b" items="${asbestosArr}" varStatus="bIndex">
						<tr>
							<td>${b.name }</td>
							<td>${b.type }</td>
							<td>${b.company }</td>
							<td>${b.phoneNumber }</td>
							<td>${b.faxNumber }</td>
							<td>${b.mobileNumber }</td>
							<td>${b.emailAdd }</td>
							
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
					</d:forEach>
				</tbody>
				<!-- End Rows -->

			</table>
		</div>
	</div>
</div>
<!-- End of DataTables -->

