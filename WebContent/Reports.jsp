<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
  
  <!-- DataTable -->
  <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

<style>
    .table-row{cursor: pointer;}
</style>
  
</head>

<body id="page-top">

	<!-- Include Header.jsp -->
	<%@ include file="Header.jsp" %>

	<!-- Include ReportsSelection.jsp -->
	<%@ include file="ReportsSelection.jsp" %>

	<!-- Include ReportsPreview.jsp -->
	<%@ include file="ReportsPreview.jsp" %>

	<!-- Include Footer.jsp -->
	<%@ include file="Footer.jsp" %>
	
<!-- Java Script function for Pagination -->
<script type="text/javascript">

/**************** For Data Table and Pagination ********************************/

$(document).ready(function() {
    $('#reportsTable').DataTable();
});

$(".nav-tabs a").click(function(){
    $(this).tab('show');
});

/**************** For Drop Down Default Value ********************************/

$("select[data-selected]").each(function() {
    var selected = $(this).data("selected");
    $("select[data-selected='" + selected + "'] option[value='" + selected + "']").attr("selected", "selected");
})

</script>

</body>

</html>
