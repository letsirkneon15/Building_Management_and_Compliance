<!DOCTYPE html>
<html lang="en">

<head>

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

<!-- DataTable -->
<link href="vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">

<style>
.table-row {
	cursor: pointer;
}
</style>

</head>

<body id="page-top">

	<!-- Include Header.jsp -->
	<%@ include file="Header.jsp"%>

	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- My Profile -->
		<div class="card shadow mb-4">
			<div class="card-header py-3">
				<h6 class="m-0 font-weight-bold text-primary">My Profile</h6>
			</div>

			<div class="card-body">
				<form class="form-vertical" method="post"
					action="${pageContext.request.contextPath}/User?action=edtAccnt">

					<div class="panel-default">
						<div class="panel-body">
							<div class="col-sm-6">
								<div class="input-group">
									<label for="name" class="cols-sm-2 control-label">First
										Name &nbsp;</label> <input type="text" class="form-control"
										name="firstName" id="firstName" placeholder="Enter First Name" />
								</div>
							</div>
							<div class="col-sm-6">
								<div class="input-group">
									<label for="name" class="cols-sm-2 control-label">Last
										Name &nbsp;</label> <input type="text" class="form-control"
										name="lastName" id="lastName" placeholder="Enter Last Name" />
								</div>
							</div>
						</div>
					</div>

					<div class="panel-default">
						<div class="panel-body">
							<div class="col-sm-6">
								<div class="input-group">
									<label for="companyName" class="cols-sm-2 control-label">Company
										Name&nbsp;</label> <input type="text" class="form-control" name="name"
										id="companyName" placeholder="Enter Company Name" />
								</div>
							</div>
							<div class="col-sm-6">
								<div class="input-group">
									<label for="companyAddress" class="cols-sm-2 control-label">Company
										Address&nbsp;</label> <input type="text" class="form-control"
										name="username" id="companyAddress"
										placeholder="Enter Company Address" />
								</div>
							</div>
						</div>
					</div>

					<div class="panel-default">
						<div class="panel-body">
							<div class="col-sm-6">
								<div class="input-group">
									<label for="contactNum" class="cols-sm-2 control-label">Contact
										Number&nbsp;</label> <input type="text" class="form-control"
										name="name" id="contactNum" placeholder="Enter Contact Number" />
								</div>
							</div>
							<div class="col-sm-6">
								<div class="input-group">
									<label for="email" class="cols-sm-2 control-label">Email
										Address&nbsp;</label> <input type="text" class="form-control"
										name="email" id="email" placeholder="Enter Email" />
								</div>
							</div>
						</div>
					</div>

					<div class="panel-default">
						<div class="panel-body">
							<div class="col-sm-6">
								<div class="input-group">
									<label for="password" class="cols-sm-2 control-label">Password&nbsp;</label>
									<input type="password" class="form-control" name="password"
										id="password" placeholder="Enter Password" />
								</div>
							</div>
							<div class="col-sm-6">
								<div class="input-group">
									<label for="confirm" class="cols-sm-2 control-label">Confirm
										Password&nbsp;</label> <input type="password" class="form-control"
										name="confirm" id="confirm" placeholder="Confirm Password" />
								</div>
							</div>
						</div>
					</div>

					<div class="panel-default">
					<div class="panel-body">
						<div class="col-sm-12">
					<div class="form-group w-25">
						<button type="button"
							class="btn btn-primary btn-lg btn-block login-button">Update</button>
					</div>
					</div>
					</div>
					</div>
				</form>
			</div>
		</div>
		<!-- End of DataTables -->
	</div>
	<!-- Include Footer.jsp -->
	<%@ include file="Footer.jsp"%>

	<!-- Java Script function for Pagination -->
	<script type="text/javascript">
		
	</script>

</body>

</html>

