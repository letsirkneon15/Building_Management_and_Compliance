<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Building Management and Compliance</title>

  <!-- Custom fonts for this template-->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

  <!-- Custom styles for this template-->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <link href="css/sb-admin-2.min.css" rel="stylesheet">

</head>

<body id="page-top">

	<!-- Include Header.jsp -->
	<%@ include file="Header.jsp" %>
	

	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<div class="d-sm-flex align-items-center justify-content-between mb-4">
    		<h1 class="h3 mb-0 text-gray-800">Name of the building</h1>
		</div>

  		<div class="card shadow mb-4">
   		<div class="card-header py-3">
         	
         	<!-- Include TabMenu.jsp -->
			<%@ include file="TabMenu.jsp" %>
			

			<!--  Tab Content -->
			<div class="card-body">
				<div class="tab-content">
   					
   					<div id="generalInformation" class="tab-pane fade in active">
   					 
   					 <!-- Horizontal Form -->
      				<div class="row">
       					<div class="col-xs-6">
          				<form class="form-horizontal">
            				<div class="form-group">
             				 	<label for="buildingName" class="col-xs-8">Name of Building</label>
             				 	<div class="col-xs-10">
          					 		<input type="text" class="form-control" id="buildingName" placeholder="Building Name" 
          					 		value="${buildingName}"/>
          			   			</div>
           					 </div>
           					 
           					 <div class="form-group">
             				 	<label for="address" class="col-xs-8">Address</label>
             				 	<div class="col-xs-10">
          					 		<input type="text" class="form-control" id="address" placeholder="Address" 
          					 		value = "${address}"/>
          			   			</div>
           					 </div>
           					 
           					 <div class="form-group">
             				 	<label for="responsibleOffice" class="col-xs-8">Responsible Office</label>
             				 	<div class="col-xs-10">
          					 		<input type="text" class="form-control" id="address" placeholder="Responsible Office" 
          					 		value = "${address}"/>
          			   			</div>
           					 </div>
           					 
   					 	</form>
   					 	</div>
   					</div>
   					
   					</div>
   					<!-- End General Information Tab-->
   						
    			</div>
    			<!-- End Card-Body -->
    		</div>
			<!-- End Tab Content -->
			
    	</div>
  		</div>
	</div>
	<!--  End Page Content -->


	<!-- Include Footer.jsp -->
	<%@ include file="Footer.jsp" %>

</body>
</html>