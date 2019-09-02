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

</head>

<body id="page-top">

	<!-- Include Header.jsp -->
	<%@ include file="Header.jsp"%>


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

						<!-- Start General Information Tab-->
						<div id="generalInformation" class="tab-pane active">

							<!-- Include GeneralInformation.jsp -->
							<%@ include file="GeneralInformation.jsp"%>

						</div>
						<!-- End General Information Tab-->
						
						<!-- Start Electrical Tab-->
						<div id="electrical" class="tab-pane">

							<!-- Include Electrical.jsp -->
							<%@ include file="Electrical.jsp"%>

						</div>
						<!-- End Electrical Tab-->
						
						<!-- Start Gas Tab-->
						<div id="gas" class="tab-pane">

							<!-- Include Gas.jsp -->
							<%@ include file="Gas.jsp"%>

						</div>
						<!-- End Gas Tab-->

					</div>
					<!-- End Tab Content -->
					
				</div>
				<!-- End Card-Body -->

			</div>
		</div>
	</div>
	<!--  End Page Content -->


	<!-- Include Footer.jsp -->
	<%@ include file="Footer.jsp"%>

</body>
</html>