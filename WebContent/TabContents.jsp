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

</head>

<body id="page-top">

	<!-- Include Header.jsp -->
	<%@ include file="Header.jsp"%>


	<!-- Begin Page Content -->
	<div class="container-fluid">

		<!-- Page Heading -->
		<div class="d-sm-flex align-items-center justify-content-between mb-4">
			<h1 class="h3 mb-0 text-gray-800">${bHeader.buildingName}</h1>
		</div>

		<div class="card shadow mb-4">
			<div class="card-header py-3">

				<!-- Include TabMenu.jsp -->
				<%@ include file="TabMenu.jsp"%>


				<!--  Tab Content -->
				<div class="card-body">
					<div class="tab-content" id="nav-tabContent">

						<!-- Start General Information Tab-->
						<div id="generalInformation" class="tab-pane fade in active">
							<!-- Include GeneralInformation.jsp -->
							<%@ include file="GeneralInformation.jsp"%>
						</div>
						<!-- End General Information Tab-->
						
						<!-- Start Contacts Tab-->
						<div id="contacts" class="tab-pane">
							<!-- Include Contacts.jsp -->
							<%@ include file="Contacts.jsp"%>
						</div>
						<!-- End Contacts Tab-->

						<!-- Start Building WOF Tab-->
						<div id="wof" class="tab-pane">
							<!-- Include BuildingWOF.jsp -->
							<%@ include file="BuildingWOF.jsp"%>
						</div>
						<!-- End Building WOF Tab-->						
						
						<!-- Start Consent Tab-->
						<div id="consent" class="tab-pane">
							<!-- Include Consent.jsp -->
							<%@ include file="BuildingConsent.jsp"%>
						</div>
						<!-- End Consent Tab-->	
						
						<!-- Start Asbestos Tab-->
						<div id="asbestos" class="tab-pane">
							<!-- Include Asbestos.jsp -->
							<%@ include file="Asbestos.jsp"%>
						</div>
						<!-- End Asbestos Tab-->	
						
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
						
						<!-- Start Hazardous Substances Tab-->
						<div id="hazardousSubstances" class="tab-pane">
							<!-- Include HazardousSubstances.jsp -->
							<%@ include file="HazardousSubstances.jsp"%>
						</div>
						<!-- End Hazardous Substances Tab-->	
						
						<!-- Start Hazard Register Tab-->
						<div id="hazardRegister" class="tab-pane">
							<!-- Include HazardRegister.jsp -->
							<%@ include file="HazardRegister.jsp"%>
						</div>
						<!-- End Hazard Register Tab-->	
		
						<!-- Start Seismic Resilience Tab-->
						<div id="seismicResilience" class="tab-pane">
							<!-- Include SeismicResilience.jsp -->
							<%@ include file="SeismicResilience.jsp"%>
						</div>
						<!-- End Seismic Resilience Tab-->	
						
						<!-- Start Resource Consent Tab-->
						<div id="resourceConsent" class="tab-pane">
							<!-- Include ResourceConsent.jsp -->
							<%@ include file="ResourceConsent.jsp"%>
						</div>
						<!-- End Resource Consent Tab-->	
						
						<!-- Start Compliance Inspection Tab-->
						<div id="complianceInspection" class="tab-pane">
							<!-- Include ComplianceInspection.jsp -->
							<%@ include file="ComplianceInspection.jsp"%>
						</div>
						<!-- End Compliance Inspection Tab-->	

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
    $('#datatable').DataTable();
} );

$(document).ready(function() {
    $('#electricalTable').DataTable();
} );

$(document).ready(function() {
    $('#wofTable').DataTable();
} );

$(document).ready(function() {
    $('#gasTable').DataTable();
} );

$(document).ready(function() {
    $('#consentTable').DataTable();
} );

$(document).ready(function() {
    $('#asbestosTable').DataTable();
} );

$(document).ready(function() {
    $('#complianceInspectionTable').DataTable();
} );

$(document).ready(function() {
    $('#resourceConsentTable').DataTable();
} );

$(document).ready(function() {
    $('#contactsTable').DataTable();
} );

$(document).ready(function() {
    $('#hazardRegisterTable').DataTable();
} );

$(document).ready(function() {
    $('#hazardousSubstancesTable').DataTable();
} );

$(".nav-tabs a").click(function(){
    $(this).tab('show');
});

$('#editContacts').on('show.bs.modal', function(e) {
    var buildingID = $(e.relatedTarget).data('buildingID');
    var recordID = $(e.relatedTarget).data('recordID');
    var name = $(e.relatedTarget).data('name');
    var type = $(e.relatedTarget).data('type');
    var company = $(e.relatedTarget).data('company');
    var phoneNumber = $(e.relatedTarget).data('phoneNumber');
    var faxNumber = $(e.relatedTarget).data('faxNumber');
    var mobileNumber = $(e.relatedTarget).data('mobileNumber');
    var emailAdd = $(e.relatedTarget).data('emailAdd');

    $(e.currentTarget).find('input[name="edtCRecordID"]').val(recordID);
    $(e.currentTarget).find('input[name="edtCBuildingID"]').val(buildingID);
    $(e.currentTarget).find('input[name="edtCName"]').val(name);
    $(e.currentTarget).find('input[name="edtCType"]').val(type);
    $(e.currentTarget).find('input[name="edtCCompany"]').val(company);
    $(e.currentTarget).find('input[name="edtCPhoneNumber"]').val(phoneNumber);
    $(e.currentTarget).find('input[name="edtCFaxNumber"]').val(faxNumber);
    $(e.currentTarget).find('input[name="edtCMobileNumber"]').val(mobileNumber);
    $(e.currentTarget).find('input[name="edtCEmailAdd"]').val(emailAdd);

});

$('#editWof').on('show.bs.modal', function(e) {
    var buildingID = $(e.relatedTarget).data('buildingID');
    var recordID = $(e.relatedTarget).data('recordID');
    var name = $(e.relatedTarget).data('name');
    var titledYear = $(e.relatedTarget).data('titledYear');
    var attachment = $(e.relatedTarget).data('attachment');
    var type = $(e.relatedTarget).data('type');
    var uploadedBy = $(e.relatedTarget).data('uploadedBy');
    var lastUploadedBy = $(e.relatedTarget).data('lastUploadedBy');

    $(e.currentTarget).find('input[name="edtWRecordID"]').val(recordID);
    $(e.currentTarget).find('input[name="edtWBuildingID"]').val(buildingID);
    $(e.currentTarget).find('input[name="edtWName"]').val(name);
    $(e.currentTarget).find('input[name="edtWTitledYear"]').val(titledYear);
    $(e.currentTarget).find('input[name="edtWAttachment"]').val(attachment);
    $(e.currentTarget).find('input[name="edtWType"]').val(type);
    $(e.currentTarget).find('input[name="edtWUploadedBy"]').val(uploadedBy);
    $(e.currentTarget).find('input[name="edtWLastUploadedBy"]').val(lastUploadedBy);

});

$('#editConsent').on('show.bs.modal', function(e) {
    var buildingID = $(e.relatedTarget).data('buildingID');
    var recordID = $(e.relatedTarget).data('recordID');
    var name = $(e.relatedTarget).data('name');
    var consentNumber = $(e.relatedTarget).data('consentNumber');
    var attachment = $(e.relatedTarget).data('attachment');
    var type = $(e.relatedTarget).data('type');
    var uploadedBy = $(e.relatedTarget).data('uploadedBy');
    var lastUploadedBy = $(e.relatedTarget).data('lastUploadedBy');

    $(e.currentTarget).find('input[name="edtCSRecordID"]').val(recordID);
    $(e.currentTarget).find('input[name="edtCSBuildingID"]').val(buildingID);
    $(e.currentTarget).find('input[name="edtCSName"]').val(name);
    $(e.currentTarget).find('input[name="edtCSConsentNumber"]').val(consentNumber);
    $(e.currentTarget).find('input[name="edtCSAttachment"]').val(attachment);
    $(e.currentTarget).find('input[name="edtCSType"]').val(type);
    $(e.currentTarget).find('input[name="edtCSUploadedBy"]').val(uploadedBy);
    $(e.currentTarget).find('input[name="edtCSLastUploadedBy"]').val(lastUploadedBy);

});

$('#editAsbestos').on('show.bs.modal', function(e) {
    var buildingID = $(e.relatedTarget).data('buildingID');
    var recordID = $(e.relatedTarget).data('recordID');
    var name = $(e.relatedTarget).data('name');
    var attachment = $(e.relatedTarget).data('attachment');
    var type = $(e.relatedTarget).data('type');
    var uploadedBy = $(e.relatedTarget).data('uploadedBy');
    var lastUploadedBy = $(e.relatedTarget).data('lastUploadedBy');

    $(e.currentTarget).find('input[name="edtARecordID"]').val(recordID);
    $(e.currentTarget).find('input[name="edtABuildingID"]').val(buildingID);
    $(e.currentTarget).find('input[name="edtAName"]').val(name);
    $(e.currentTarget).find('input[name="edtAAttachment"]').val(attachment);
    $(e.currentTarget).find('input[name="edtAType"]').val(type);
    $(e.currentTarget).find('input[name="edtAUploadedBy"]').val(uploadedBy);
    $(e.currentTarget).find('input[name="edtALastUploadedBy"]').val(lastUploadedBy);
});

$('#editElectrical').on('show.bs.modal', function(e) {
    var buildingID = $(e.relatedTarget).data('buildingID');
    var recordID = $(e.relatedTarget).data('recordID');
    var name = $(e.relatedTarget).data('name');
    var attachment = $(e.relatedTarget).data('attachment');
    var type = $(e.relatedTarget).data('type');
    var uploadedBy = $(e.relatedTarget).data('uploadedBy');
    var lastUploadedBy = $(e.relatedTarget).data('lastUploadedBy');

    $(e.currentTarget).find('input[name="edtERecordID"]').val(recordID);
    $(e.currentTarget).find('input[name="edtEBuildingID"]').val(buildingID);
    $(e.currentTarget).find('input[name="edtEName"]').val(name);
    $(e.currentTarget).find('input[name="edtEAttachment"]').val(attachment);
    $(e.currentTarget).find('input[name="edtEType"]').val(type);
    $(e.currentTarget).find('input[name="edtEUploadedBy"]').val(uploadedBy);
    $(e.currentTarget).find('input[name="edtELastUploadedBy"]').val(lastUploadedBy);
});

$('#editGas').on('show.bs.modal', function(e) {
    var buildingID = $(e.relatedTarget).data('buildingID');
    var recordID = $(e.relatedTarget).data('recordID');
    var name = $(e.relatedTarget).data('name');
    var attachment = $(e.relatedTarget).data('attachment');
    var type = $(e.relatedTarget).data('type');
    var uploadedBy = $(e.relatedTarget).data('uploadedBy');
    var lastUploadedBy = $(e.relatedTarget).data('lastUploadedBy');

    $(e.currentTarget).find('input[name="edtGRecordID"]').val(recordID);
    $(e.currentTarget).find('input[name="edtGBuildingID"]').val(buildingID);
    $(e.currentTarget).find('input[name="edtGName"]').val(name);
    $(e.currentTarget).find('input[name="edtGAttachment"]').val(attachment);
    $(e.currentTarget).find('input[name="edtGType"]').val(type);
    $(e.currentTarget).find('input[name="edtGUploadedBy"]').val(uploadedBy);
    $(e.currentTarget).find('input[name="edtGLastUploadedBy"]').val(lastUploadedBy);
});

$('#editHazardSubstance').on('show.bs.modal', function(e) {
    var buildingID = $(e.relatedTarget).data('buildingID');
    var recordID = $(e.relatedTarget).data('recordID');
    var productName = $(e.relatedTarget).data('productName');
    var unNumber = $(e.relatedTarget).data('unNumber');
    var approvalNumber = $(e.relatedTarget).data('approvalNumber');
    var groupStandard = $(e.relatedTarget).data('groupStandard');
    var hazardClassification = $(e.relatedTarget).data('hazardClassification');
    var currentSDSAvailable = $(e.relatedTarget).data('currentSDSAvailable');
    var specificStorage = $(e.relatedTarget).data('specificStorage');
    var segregationRequirements = $(e.relatedTarget).data('segregationRequirements');
    var containerSize = $(e.relatedTarget).data('containerSize');
    var openCloseContainer = $(e.relatedTarget).data('openCloseContainer');
    var gasLiquidSolid = $(e.relatedTarget).data('gasLiquidSolid');
    var location = $(e.relatedTarget).data('location');
    var maximumLikelyAmount = $(e.relatedTarget).data('maximumLikelyAmount');

    $(e.currentTarget).find('input[name="edtHSRecordID"]').val(recordID);
    $(e.currentTarget).find('input[name="edtHSBuildingID"]').val(buildingID);
    $(e.currentTarget).find('input[name="edtHSProductName"]').val(productName);
    $(e.currentTarget).find('input[name="edtHSUnNumber"]').val(unNumber);
    $(e.currentTarget).find('input[name="edtHSApprovalNumber"]').val(approvalNumber);
    $(e.currentTarget).find('input[name="edtHSGroupStandard"]').val(groupStandard);
    $(e.currentTarget).find('input[name="edtHSHazardClassification"]').val(hazardClassification);
    $(e.currentTarget).find('input[name="edtHSCurrentSDSAvailable"]').val(currentSDSAvailable);
    $(e.currentTarget).find('input[name="edtHSSpecificStorage"]').val(specificStorage);
    $(e.currentTarget).find('input[name="edtHSSegregationRequirements"]').val(segregationRequirements);
    $(e.currentTarget).find('input[name="edtHSContainerSize"]').val(containerSize);
    $(e.currentTarget).find('input[name="edtHSOpenCloseContainer"]').val(openCloseContainer);
    $(e.currentTarget).find('input[name="edtHSGasLiquidSolid"]').val(gasLiquidSolid);
    $(e.currentTarget).find('input[name="edtHSLocation"]').val(location);
    $(e.currentTarget).find('input[name="edtHSMaximumLikelyAmount"]').val(maximumLikelyAmount);
});

$('#editHazardRegister').on('show.bs.modal', function(e) {
    var buildingID = $(e.relatedTarget).data('buildingID');
    var recordID = $(e.relatedTarget).data('recordID');
    var identifiedHazard = $(e.relatedTarget).data('identifiedHazard');
    var initialRiskAssessment = $(e.relatedTarget).data('initialRiskAssessment');
    var controls = $(e.relatedTarget).data('controls');
    var levelOfControl = $(e.relatedTarget).data('levelOfControl');
    var residualRiskAssessment = $(e.relatedTarget).data('residualRiskAssessment');

    $(e.currentTarget).find('input[name="edtHRRecordID"]').val(recordID);
    $(e.currentTarget).find('input[name="edtHRBuildingID"]').val(buildingID);
    $(e.currentTarget).find('input[name="edtHRidentifiedHazard"]').val(identifiedHazard);
    $(e.currentTarget).find('input[name="edtHRInitialRiskAssessment"]').val(initialRiskAssessment);
    $(e.currentTarget).find('input[name="edtHRControls"]').val(controls);
    $(e.currentTarget).find('input[name="edtHRLevelOfControl"]').val(levelOfControl);
    $(e.currentTarget).find('input[name="edtHRResidualRiskAssessment"]').val(residualRiskAssessment);
});

$('#editSeismicResilience').on('show.bs.modal', function(e) {
    var buildingID = $(e.relatedTarget).data('buildingID');
    var recordID = $(e.relatedTarget).data('recordID');
    var name = $(e.relatedTarget).data('name');
    var attachment = $(e.relatedTarget).data('attachment');
    var type = $(e.relatedTarget).data('type');
    var uploadedBy = $(e.relatedTarget).data('uploadedBy');
    var lastUploadedBy = $(e.relatedTarget).data('lastUploadedBy');

    $(e.currentTarget).find('input[name="edtSRRecordID"]').val(recordID);
    $(e.currentTarget).find('input[name="edtSRBuildingID"]').val(buildingID);
    $(e.currentTarget).find('input[name="edtSRName"]').val(name);
    $(e.currentTarget).find('input[name="edtSRAttachment"]').val(attachment);
    $(e.currentTarget).find('input[name="edtSRType"]').val(type);
    $(e.currentTarget).find('input[name="edtSRUploadedBy"]').val(uploadedBy);
    $(e.currentTarget).find('input[name="edtSRLastUploadedBy"]').val(lastUploadedBy);
});

$('#editResourceConsent').on('show.bs.modal', function(e) {
    var buildingID = $(e.relatedTarget).data('buildingID');
    var recordID = $(e.relatedTarget).data('recordID');
    var name = $(e.relatedTarget).data('name');
    var attachment = $(e.relatedTarget).data('attachment');
    var type = $(e.relatedTarget).data('type');
    var uploadedBy = $(e.relatedTarget).data('uploadedBy');
    var lastUploadedBy = $(e.relatedTarget).data('lastUploadedBy');

    $(e.currentTarget).find('input[name="edtRCRecordID"]').val(recordID);
    $(e.currentTarget).find('input[name="edtRCBuildingID"]').val(buildingID);
    $(e.currentTarget).find('input[name="edtRCName"]').val(name);
    $(e.currentTarget).find('input[name="edtRCAttachment"]').val(attachment);
    $(e.currentTarget).find('input[name="edtRCType"]').val(type);
    $(e.currentTarget).find('input[name="edtRCUploadedBy"]').val(uploadedBy);
    $(e.currentTarget).find('input[name="edtRCLastUploadedBy"]').val(lastUploadedBy);
});

$('#deleteRecords').on('show.bs.modal', function(e) {
    var recordID = $(e.relatedTarget).data('recordID');
    var buildingID = $(e.relatedTarget).data('buildingID');

    $(e.currentTarget).find('input[name="dltRecordID"]').val(recordID);
    $(e.currentTarget).find('input[name="dltBuildingID"]').val(buildingID);

});

</script>

</body>
</html>

