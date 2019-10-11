<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
				<h6 class="m-0 font-weight-bold text-primary">${userAccnt.name}:
					Profile</h6>
			</div>

			<div class="card-body">
				<form name="userAccountUpdate" class="user" onsubmit="return validateForm()" method="post"
					action="${pageContext.request.contextPath}/User?action=edtAccount">

					<div class="card mb-4">
						<div class="card-header">Contact Information</div>
						<div class="card-body">

							<div class="panel-default">
								<div class="panel-body">
									<div class="row">
										<div class="input-group">
											<div class="col-sm-2">
												<label for="contactNum" class="cols-sm-2 control-label">Contact
													Number&nbsp;</label>
											</div>
											<div class="col-sm-7">
												<input type="text" class="form-control" name="contactNum"
													id="contactNum" value="${userAccnt.contactNum}" />
											</div>
										</div>

										<div class="input-group">
											<div class="col-sm-2">
												<label for="email" class="cols-sm-2 control-label">Email
													Address&nbsp;</label>
											</div>
											<div class="col-sm-7">
												<input type="text" class="form-control" name="email"
													id="email" value="${userAccnt.emailAdd}" />
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>


					<div class="card mb-4">
						<div class="card-header">General Information</div>
						<div class="card-body">

							<div class="panel-default">
								<div class="panel-body">
									<div class="row">
										<div class="input-group">
											<div class="col-sm-2">
												<label for="name" class="cols-sm-2 control-label">First
													Name &nbsp;</label>
											</div>
											<div class="col-sm-7">
												<input type="text" class="form-control" name="firstName"
													id="firstName" value="${userAccnt.name.split(',')[1].trim()}" />
											</div>
										</div>

										<div class="input-group">
											<div class="col-sm-2">
												<label for="name" class="cols-sm-2 control-label">Last
													Name &nbsp;</label>
											</div>
											<div class="col-sm-7">
												<input type="text" class="form-control" name="lastName"
													id="lastName" value="${userAccnt.name.split(',')[0].trim()}" />
											</div>
										</div>

										<div class="input-group">
											<div class="col-sm-2">
												<label for="companyName" class="cols-sm-2 control-label">Company
													Name&nbsp;</label>
											</div>
											<div class="col-sm-7">
												<input type="text" class="form-control" name="companyName"
													id="companyName" value="${userAccnt.companyName}" />
											</div>
										</div>

										<div class="input-group">
											<div class="col-sm-2">
												<label for="companyAddress" class="cols-sm-2 control-label">Company
													Address&nbsp;</label>
											</div>
											<div class="col-sm-7">
												<input type="text" class="form-control" name="companyAddress"
													id="companyAddress" value="${userAccnt.companyAddress}" />
											</div>
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>
					
					<div class="card mb-4">
						<div class="card-header">Login Information</div>
						<div class="card-body">

							<div class="panel-default">
								<div class="panel-body">
									<div class="row">
									
										<div class="input-group">
											<div class="col-sm-2">
												<label for="userID" class="cols-sm-2 control-label">User ID&nbsp;</label>
											</div>
											<div class="col-sm-7">
												<label for="userID" class="cols-sm-2 control-label"> ${userID} </label>
											</div>
										</div>
									
										<div class="input-group">
											<div class="col-sm-2">
												<label for="password" class="cols-sm-2 control-label">Password&nbsp;</label>
											</div>
											<div class="col-sm-7">
												<input type="password" class="form-control" name="password"
													id="password" value="${userAccnt.password}" />
											</div>
										</div>

										<div class="input-group">
											<div class="col-sm-2">
												<label for="confirm" class="cols-sm-2 control-label">Confirm
													Password&nbsp;</label>
											</div>
											<div class="col-sm-7">
												<input type="password" class="form-control" name="confirm"
													id="confirm" value="${userAccnt.password}" />
											</div>
										</div>
										<input type="hidden" class="form-control" name="role"
													id="role" value="${userAccnt.role}" />
									
									</div>
								</div>
							</div>
						</div>
					</div>
					
						<div class="panel-default">
							<div class="panel-body">
								<div class="col-sm-12" align="center">
								
								<c:if test="${not empty errorMsg}">
									<div class="alert alert-danger" role="alert" style="font-size:14px">
  										${errorMsg}
									</div>			
								</c:if>
								
								<c:if test="${not empty successMsg}">
									<div class="alert alert-success" role="alert" style="font-size:14px">
  										${successMsg}
									</div>			
								</c:if>
								
									<div class="form-group w-25">
										<button  type="submit" class="btn btn-primary btn-user btn-block" name="button"
								value="update">Update</button>
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

<!-- Java Script for password Validation -->
<script type="text/javascript">
function validateForm() {
	  var password = document.forms["userAccountUpdare"]["password"].value;
	  var repeatPassword = document.forms["userAccountUpdate"]["confirm"].value;
	  
	  if (password.includes(' ', 0)) {
		  alert("Password cannot include space.");
		  return false;
	  }else if (password.length < 8) {
		  alert("Password length must be equal or greater than 8 characters.");
		  return false;
	  }else if (! password.match( "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}$" )) {
	  	  alert("Password must have at least one upper case letter, at least one lower case letter, at least one digit");
	  	  return false;
	  }else if (password != repeatPassword) {
	    alert("Password must be equal with Repeat Password.");
	    return false;
	  }
}

</script>

</body>

</html>

