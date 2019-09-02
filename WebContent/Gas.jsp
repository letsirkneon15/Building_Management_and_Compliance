<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<<<<<<< HEAD
=======
<!DOCTYPE html>
<html lang="en">
>>>>>>> refs/remotes/origin/master


<<<<<<< HEAD
<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">All buildings</h6>
=======
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Building Management and Compliance</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">


<!-- Custom styles for this template-->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

</head>

<!-- Include Header.jsp -->
<%@ include file="Header.jsp"%>

<body id="page-top">


	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<div class="d-sm-flex align-items-center justify-content-between mb-4">
			<h1 class="h3 mb-0 text-gray-800">Name of the building</h1>
		</div>

		<div class="card shadow mb-4">
			<div class="card-header py-3">

				<!-- Include TabMenu.jsp -->
				<%@ include file="TabMenu.jsp"%>


				<!--  Tab Content -->
				<div class="card-body">
					<div class="tab-content">

						<div id="gas" class="tab-pane active">


							<!-- DataTables -->
							<div class="card shadow mb-4">
								<div class="card-header py-3">
									<h6 class="m-0 font-weight-bold text-primary">All
										buildings</h6>
								</div>
								<div class="card-body">
									<div class="table-responsive">
										<table class="table table-bordered" id="dataTable"
											width="100%" cellspacing="0">
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
												<c:forEach var="b" items="${buildiArr}" varStatus="bIndex">
													<tr>
														<td>${b.name }</td>
														<td>${b.attachment }</td>
														<td>${b.type }</td>
														<td>${b.uploadedBy }</td>
														<td>${b.lastUploadedBy }</td>
														<td><a href="#download" data-toggle="modal"
															data-id="edtLink${bIndex.index}"
															data-buildingId="${b.buildingId}"><img
																src='images/download_cloud.png' height=15 width=15></a></td>
														<td><a href="#editRecord" data-toggle="modal"
															data-id="edtLink${bIndex.index}"
															data-buildingId="${b.buildingId}"><img
																src='images/edit.jpg' height=15 width=15></a></td>
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

						</div>
						<!-- End GAS Tab-->

					</div>
					<!-- End Card-Body -->
				</div>
				<!-- End Tab Content -->

			</div>
		</div>
>>>>>>> refs/remotes/origin/master
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
						<th>Download</th>
					</tr>
				</thead>

<<<<<<< HEAD
				<!-- Start Rows -->
				<tbody>
					<c:forEach var="b" items="${buildingArr}" varStatus="bIndex">
						<tr>
							<td>${b.name }</td>
							<td>${b.attachment }</td>
							<td>${b.type }</td>
							<td>${b.uploadedBy }</td>
							<td>${b.lastUploaded }</td>
							<td>${b.download }</td>
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
=======
	<!-- Include Footer.jsp -->
	<%@ include file="Footer.jsp"%>
>>>>>>> refs/remotes/origin/master

			</table>
		</div>
		<!-- End of DataTables -->