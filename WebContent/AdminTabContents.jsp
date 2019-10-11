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
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

<!-- Custom style for browse files -->
<link href="css/open-iconic-bootstrap.css" rel="stylesheet" type="text/css">

</head>

<body id="page-top">

	<!-- Include Header.jsp -->
	<%@ include file="Header.jsp"%>


	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<div class="d-sm-flex align-items-center justify-content-between mb-4">
			<h1 class="h3 mb-0 text-gray-800">Administrative Options</h1>
		</div>

		<div class="card shadow mb-4">
			<div class="card-header py-3">

				<!-- Include AdminTabMenu.jsp -->
				<%@ include file="AdminTabMenu.jsp"%>


				<!--  Tab Content -->
				<div class="card-body">
					<div class="tab-content" id="nav-tabContent">

						<!-- Start Admin-User Account Tab-->
						<div id="UserAccount" class="tab-pane fade in active">
							<!-- Include AdminUserAccount.jsp -->
							<%@ include file="AdminUserAccount.jsp"%>
						</div>
						<!-- End Admin-User Account Tab-->
						
						<!-- Start "Admin-User-Tab" Tab-->
						<div id="UserTab" class="tab-pane">
							<!-- Include AdminUserTab.jsp -->
							<%@ include file="AdminUserTab.jsp"%>
						</div>
						<!-- End "Admin-User-Tab" Tab-->

						<!-- Start Admin User-Building Tab-->
						<div id="UserBuilding" class="tab-pane">
							<!-- Include AdminUserBuilding.jsp -->
							<%@ include file="AdminUserBuilding.jsp"%>
						</div>
						<!-- End Admin User-Building Tab-->						

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

<!-- Java Script function for Pagination -->
<script type="text/javascript">

$(document).ready(function() {
    $('#userTable').DataTable();
} );

$(document).ready(function() {
    $('#userTabTable').DataTable();
} );

$(".nav-tabs a").click(function(){
    $(this).tab('show'); 
});

activeTab("${tabName}");

function activeTab(tab){
    $('.nav-tabs a[href="#' + tab + '"]').tab('show');
};

/**************** For Drop Down Default Value ****************************/

$("select[data-selected]").each(function() {
    var selected = $(this).data("selected");
    $("select[data-selected='" + selected + "'] option[value='" + selected + "']").attr("selected", "selected");
})

/**************** For Check boxes Default Checked Value ****************************/

$("input[data-checked]").each(function() {
    var checked = $(this).data("checked");
    if(checked != 'D'){
    	$("input[data-checked='" + checked + "']").attr('checked', true);
    }
})

/**************** For Check boxes Default Checked Value - User Tab ****************************/

$("input[data-checkedtab]").each(function() {
    var checkedtab = $(this).data("checkedtab");
    $("input[data-checkedtab='" + checkedtab + "']").attr('checked', false);
    if(checkedtab.trim() != '' && checkedtab != null && checkedtab != 'D'){
    	$("input[data-checkedtab='" + checkedtab + "']").attr('checked', true);
    }
})

/**************** User - Tab Select/Deselect all tab Segments ****************************/

$('.checkAllTabs').click(function() {
    if ($(this).is(':checked')) {
        $('div input').attr('checked', true);
    } else {
        $('div input').attr('checked', false);
    }
});

/**************** User - Tab Select/Deselect all Buildings ****************************/

$('.checkAllBuildings').click(function() {
    if ($(this).is(':checked')) {
        $('div input').attr('checked', true);
    } else {
        $('div input').attr('checked', false);
    }
});

/**************** CREATE MODALS HERE ************************************/

$('#crtUser').on('show.bs.modal', function(e) {
    var userid = $(e.relatedTarget).data('userid');

    $(e.currentTarget).find('input[name="userID"]').val(userid);
});

/**************** EDIT MODALS HERE **************************************/

$('#editUser').on('show.bs.modal', function(e) {
	var auserid = $(e.relatedTarget).data('auserid');
    var firstname = $(e.relatedTarget).data('firstname');
    var lastname = $(e.relatedTarget).data('lastname');
    var contactnum = $(e.relatedTarget).data('contactnum');
    var emailadd = $(e.relatedTarget).data('emailadd');
    var companyname = $(e.relatedTarget).data('companyname');
    var companyaddress = $(e.relatedTarget).data('companyaddress');
    var emailadd = $(e.relatedTarget).data('emailadd');
    var password = $(e.relatedTarget).data('password');
    var userrole = $(e.relatedTarget).data('userrole');
    
    $(e.currentTarget).find('input[name="edtUserID"]').val(auserid);
    $(e.currentTarget).find('input[name="edtFirstName"]').val(firstname);
    $(e.currentTarget).find('input[name="edtLastName"]').val(lastname);
    $(e.currentTarget).find('input[name="edtContactNum"]').val(contactnum);
    $(e.currentTarget).find('input[name="edtEmail"]').val(emailadd);
    $(e.currentTarget).find('input[name="edtCompanyName"]').val(companyname);
    $(e.currentTarget).find('input[name="edtCompanyAddress"]').val(companyaddress);
    $(e.currentTarget).find('input[name="edtEmail"]').val(emailadd);
    $(e.currentTarget).find('input[name="edtPassword"]').val(password);
    $(e.currentTarget).find('select[name="edtRole"]').val(userrole);

});

/**************** DELETE MODALS HERE **************************************/

$('#deleteUser').on('show.bs.modal', function(e) {
	 var auserid = $(e.relatedTarget).data('auserid');

	 $(e.currentTarget).find('input[name="auserID"]').val(auserid);
});

</script>

</body>
</html>

