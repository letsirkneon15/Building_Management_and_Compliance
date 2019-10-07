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

<title>Create Account</title>

<!-- Custom fonts for this template-->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body class="bg-gradient-primary">

	<div class="container">

		<div class="card o-hidden border-0 shadow-lg my-5">
			<div class="card-body p-0">
				<!-- Nested Row within Card Body -->
				<div class="row">
					<div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
					<div class="col-lg-7">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
							</div>
							<form name="createAccount" class="user" onsubmit="return validateForm()"
								action="${pageContext.request.contextPath}/CreateAccount?action=signup"
								method="post">
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="text" class="form-control form-control-user"
											name="firstName" id="firstName" placeholder="First Name" required>
									</div>
									<div class="col-sm-6">
										<input type="text" class="form-control form-control-user"
											name="lastName" id="lastName" placeholder="Last Name" required>
									</div>
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										name="companyName" id="companyName" placeholder="Company Name">
								</div>

								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										name="companyAddress" id="companyAddress"
										placeholder="Company Address">
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										name="contactNum" id="contactNum" placeholder="Contact Number" required>
								</div>
								<div class="form-group">
									<input type="email" class="form-control form-control-user"
										name="email" id="email" placeholder="Email Address" required>
								</div>
								<div class="form-group row">
									<div class="col-sm-6 mb-3 mb-sm-0">
										<input type="password" class="form-control form-control-user"
											name="password" id="password" placeholder="Password" required>
									</div>
									<div class="col-sm-6">
										<input type="password" class="form-control form-control-user"
											name="repeatPassword" id="repeatPassword"
											placeholder="Confirm Password" required>
									</div>
								</div>
								
								<c:if test="${not empty errorMsg}">
									<div class="alert alert-danger" role="alert" style="font-size:14px">
  										${errorMsg}
									</div>			
								</c:if>
								
								<button type="submit" class="btn btn-primary btn-user btn-block" name="button"
								value="registered" data-toggle="modal">
								 Register Account
								</button>

							</form>
							<hr>

							<div class="text-center">
								<a href="ForgotPassword.jsp" style="font-size: 12px">Forgot
									Password?</a>
							</div>
							<div class="text-center">
								<a href="${pageContext.request.contextPath}/Login"
									style="font-size: 12px">Already have an account? Login!</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!--START- Create User Account Info (MODAL)-->
	<c:if test = "${button=='registered'}">
		<div class="modal fade show in" id="registered" role="dialog">
		<div class="modal-dialog" style="width: 50%">
				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header bg-primary">
						<h4 class="modal-title" align="left">
							<b>User Account Creation</b>
						</h4>
						<button type="button" class="close" data-dismiss="modal">&times;</button>
					</div>

					<!-- Create a Form to inform user that the User Account registration is successful -->
					<form
						action="${pageContext.request.contextPath}/CreateAccount?action=registered"
						method="post">
						<div class="modal-body bgColorWhite">
							<p>Hi ${firstName}, you have successfully created an account. Your user name is <b>${userID}
							</b>. You will be redirected to Dashboard.</p>
						</div>
						<input class="form-control" name="userID" id="userID"
							type="hidden" value="${userID}">
						<div class="modal-footer">
							<!-- Submit Button -->
							<button type="submit" class="btn btn-primary"
								data-dismiss="modal">
								<span class="glyphicon glyphicon-ok"></span> OK
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		</c:if>
	<!--END- Create User Account Info (MODAL)-->

	<!-- Bootstrap core JavaScript-->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

	<!-- Core plugin JavaScript-->
	<script src="vendor/jquery-easing/jquery.easing.min.js"></script>

	<!-- Custom scripts for all pages-->
	<script src="js/sb-admin-2.min.js"></script>

</body>

<script type="text/javascript">

function validateForm() {
	  var password = document.forms["createAccount"]["password"].value;
	  var repeatPassword = document.forms["createAccount"]["repeatPassword"].value;
	  
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

</html>
