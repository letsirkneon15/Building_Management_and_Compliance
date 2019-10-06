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
						<div id="GenInfo" class="tab-pane fade in active">
							<!-- Include GeneralInformation.jsp -->
							<%@ include file="GeneralInformation.jsp"%>
						</div>
						<!-- End General Information Tab-->
						
						<!-- Start Contacts Tab-->
						<div id="Contacts" class="tab-pane">
							<!-- Include Contacts.jsp -->
							<%@ include file="Contacts.jsp"%>
						</div>
						<!-- End Contacts Tab-->

						<!-- Start Building WOF Tab-->
						<div id="WOF" class="tab-pane">
							<!-- Include BuildingWOF.jsp -->
							<%@ include file="BuildingWOF.jsp"%>
						</div>
						<!-- End Building WOF Tab-->						
						
						<!-- Start Consent Tab-->
						<div id="Consent" class="tab-pane">
							<!-- Include Consent.jsp -->
							<%@ include file="BuildingConsent.jsp"%>
						</div>
						<!-- End Consent Tab-->	
						
						<!-- Start Asbestos Tab-->
						<div id="Asbestos" class="tab-pane">
							<!-- Include Asbestos.jsp -->
							<%@ include file="Asbestos.jsp"%>
						</div>
						<!-- End Asbestos Tab-->	
						
						<!-- Start Electrical Tab-->
						<div id="Electrical" class="tab-pane">
							<!-- Include Electrical.jsp -->
							<%@ include file="Electrical.jsp"%>
						</div>
						<!-- End Electrical Tab-->
						
						<!-- Start Gas Tab-->
						<div id="Gas" class="tab-pane">
							<!-- Include Gas.jsp -->
							<%@ include file="Gas.jsp"%>
						</div>
						<!-- End Gas Tab-->
						
						<!-- Start Fire Tab-->
						<div id="Fire" class="tab-pane">
							<!-- Include Fire.jsp -->
							<%@ include file="Fire.jsp"%>
						</div>
						<!-- End Fire Tab-->
						
						<!-- Start Hazardous Substances Tab-->
						<div id="HazSubs" class="tab-pane">
							<!-- Include HazardousSubstances.jsp -->
							<%@ include file="HazardousSubstances.jsp"%>
						</div>
						<!-- End Hazardous Substances Tab-->	
						
						<!-- Start Hazard Register Tab-->
						<div id="HazReg" class="tab-pane">
							<!-- Include HazardRegister.jsp -->
							<%@ include file="HazardRegister.jsp"%>
						</div>
						<!-- End Hazard Register Tab-->	
		
						<!-- Start Seismic Resilience Tab-->
						<div id="Seismic" class="tab-pane">
							<!-- Include SeismicResilience.jsp -->
							<%@ include file="SeismicResilience.jsp"%>
						</div>
						<!-- End Seismic Resilience Tab-->	
						
						<!-- Start Resource Consent Tab-->
						<div id="ResourceConsent" class="tab-pane">
							<!-- Include ResourceConsent.jsp -->
							<%@ include file="ResourceConsent.jsp"%>
						</div>
						<!-- End Resource Consent Tab-->	
						
						<!-- Start Compliance Inspection Tab-->
						<div id="ComIns" class="tab-pane">
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
    $('#fireTable').DataTable();
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
    $('#contentsTable').DataTable();
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

activeTab("${tabName}");

function activeTab(tab){
    $('.nav-tabs a[href="#' + tab + '"]').tab('show');
};

/**************** For Drop Down Default Value ********************************/

$("select[data-selected]").each(function() {
    var selected = $(this).data("selected");
    $("select[data-selected='" + selected + "'] option[value='" + selected + "']").attr("selected", "selected");
})

/**************** Upload Attachment/Image ********************************/

$(".custom-file-input").on("change", function() {
	  var fileName = $(this).val().split("\\").pop();
	  $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
});

/**************** CREATE MODALS HERE ************************************/

$('#crtContacts').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#crtWof').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#crtConsent').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#crtAsbestos').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#crtElectrical').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#crtGas').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#crtFire').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#crtHazardSubstance').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#crtHazardRegister').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#crtSeismicResilience').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#crtResourceConsent').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#crtCInspection').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});


/**************** EDIT MODALS HERE **************************************/

$('#editContacts').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');
    var recordid = $(e.relatedTarget).data('recordid');
    var name = $(e.relatedTarget).data('name');
    var type = $(e.relatedTarget).data('type');
    var company = $(e.relatedTarget).data('company');
    var phonenumber = $(e.relatedTarget).data('phonenumber');
    var faxnumber = $(e.relatedTarget).data('faxnumber');
    var mobilenumber = $(e.relatedTarget).data('mobilenumber');
    var emailadd = $(e.relatedTarget).data('emailadd');
    
    $(e.currentTarget).find('input[name="edtCRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
    $(e.currentTarget).find('input[name="edtCName"]').val(name);
    $(e.currentTarget).find('select[name="edtCType"]').val(type);
    $(e.currentTarget).find('input[name="edtCCompany"]').val(company);
    $(e.currentTarget).find('input[name="edtCPhoneNumber"]').val(phonenumber);
    $(e.currentTarget).find('input[name="edtCFaxNumber"]').val(faxnumber);
    $(e.currentTarget).find('input[name="edtCMobileNumber"]').val(mobilenumber);
    $(e.currentTarget).find('input[name="edtCEmailAdd"]').val(emailadd);

});

$('#editWof').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');
    var recordid = $(e.relatedTarget).data('recordid');
    var name = $(e.relatedTarget).data('name');
    var titledyear = $(e.relatedTarget).data('titledyear');
    var attachment = $(e.relatedTarget).data('attachment');
    var type = $(e.relatedTarget).data('type');
    var uploadedby = $(e.relatedTarget).data('uploadedby');
    var lastuploadedby = $(e.relatedTarget).data('lastuploadedby');

    $(e.currentTarget).find('input[name="edtWRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
    $(e.currentTarget).find('input[name="edtWName"]').val(name);
    $(e.currentTarget).find('input[name="edtWTitledYear"]').val(titledyear);
    $(e.currentTarget).find('label[id="edtWAttachmentLbl"]').text(attachment);
    $(e.currentTarget).find('input[name="oldAttachment"]').val(attachment);
    $(e.currentTarget).find('select[name="edtWType"]').val(type);
    $(e.currentTarget).find('input[name="edtWUploadedBy"]').val(uploadedby);
    $(e.currentTarget).find('input[name="edtWLastUploadedBy"]').val(lastuploadedby);

});

$('#editConsent').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');
    var recordid = $(e.relatedTarget).data('recordid');
    var name = $(e.relatedTarget).data('name');
    var consentnumber = $(e.relatedTarget).data('consentnumber');
    var attachment = $(e.relatedTarget).data('attachment');
    var type = $(e.relatedTarget).data('type');
    var uploadedby = $(e.relatedTarget).data('uploadedby');
    var lastuploadedby = $(e.relatedTarget).data('lastuploadedby');

    $(e.currentTarget).find('input[name="edtCSRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
    $(e.currentTarget).find('input[name="edtCSName"]').val(name);
    $(e.currentTarget).find('input[name="edtCSConsentNumber"]').val(consentnumber);
    $(e.currentTarget).find('label[id="edtCSAttachmentLbl"]').text(attachment);
    $(e.currentTarget).find('input[name="oldAttachment"]').val(attachment);
    $(e.currentTarget).find('select[name="edtCSType"]').val(type);
    $(e.currentTarget).find('input[name="edtCSUploadedBy"]').val(uploadedby);
    $(e.currentTarget).find('input[name="edtCSLastUploadedBy"]').val(lastuploadedby);

});

$('#editAsbestos').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');
    var recordid = $(e.relatedTarget).data('recordid');
    var name = $(e.relatedTarget).data('name');
    var attachment = $(e.relatedTarget).data('attachment');
    var type = $(e.relatedTarget).data('type');
    var uploadedby = $(e.relatedTarget).data('uploadedby');
    var lastuploadedby = $(e.relatedTarget).data('lastuploadedby');

    $(e.currentTarget).find('input[name="edtARecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
    $(e.currentTarget).find('input[name="edtAName"]').val(name);
    $(e.currentTarget).find('label[id="edtAAttachmentLbl"]').text(attachment);
    $(e.currentTarget).find('input[name="oldAttachment"]').val(attachment);
    $(e.currentTarget).find('select[name="edtAType"]').val(type);
    $(e.currentTarget).find('input[name="edtAUploadedBy"]').val(uploadedby);
    $(e.currentTarget).find('input[name="edtALastUploadedBy"]').val(lastuploadedby);
});

$('#editElectrical').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');
    var recordid = $(e.relatedTarget).data('recordid');
    var name = $(e.relatedTarget).data('name');
    var attachment = $(e.relatedTarget).data('attachment');
    var type = $(e.relatedTarget).data('type');
    var uploadedby = $(e.relatedTarget).data('uploadedby');
    var lastuploadedby = $(e.relatedTarget).data('lastuploadedby');

    $(e.currentTarget).find('input[name="edtERecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
    $(e.currentTarget).find('input[name="edtEName"]').val(name);
    $(e.currentTarget).find('label[id="edtEAttachmentLbl"]').text(attachment);
    $(e.currentTarget).find('input[name="oldAttachment"]').val(attachment);
    $(e.currentTarget).find('select[name="edtEType"]').val(type);
    $(e.currentTarget).find('input[name="edtEUploadedBy"]').val(uploadedby);
    $(e.currentTarget).find('input[name="edtELastUploadedBy"]').val(lastuploadedby);
});

$('#editGas').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');
    var recordid = $(e.relatedTarget).data('recordid');
    var name = $(e.relatedTarget).data('name');
    var attachment = $(e.relatedTarget).data('attachment');
    var type = $(e.relatedTarget).data('type');
    var uploadedby = $(e.relatedTarget).data('uploadedby');
    var lastuploadedby = $(e.relatedTarget).data('lastuploadedby');

    $(e.currentTarget).find('input[name="edtGRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
    $(e.currentTarget).find('input[name="edtGName"]').val(name);
    $(e.currentTarget).find('label[id="edtGAttachmentLbl"]').text(attachment);
    $(e.currentTarget).find('input[name="oldAttachment"]').val(attachment);
    $(e.currentTarget).find('select[name="edtGType"]').val(type);
    $(e.currentTarget).find('input[name="edtGUploadedBy"]').val(uploadedby);
    $(e.currentTarget).find('input[name="edtGLastUploadedBy"]').val(lastuploadedby);
});

$('#editFire').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');
    var recordid = $(e.relatedTarget).data('recordid');
    var name = $(e.relatedTarget).data('name');
    var attachment = $(e.relatedTarget).data('attachment');
    var type = $(e.relatedTarget).data('type');
    var uploadedby = $(e.relatedTarget).data('uploadedby');
    var lastuploadedby = $(e.relatedTarget).data('lastuploadedby');

    $(e.currentTarget).find('input[name="edtFRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
    $(e.currentTarget).find('input[name="edtFName"]').val(name);
    $(e.currentTarget).find('label[id="edtFAttachmentLbl"]').text(attachment);
    $(e.currentTarget).find('input[name="oldAttachment"]').val(attachment);
    $(e.currentTarget).find('select[name="edtFType"]').val(type);
    $(e.currentTarget).find('input[name="edtFUploadedBy"]').val(uploadedby);
    $(e.currentTarget).find('input[name="edtFLastUploadedBy"]').val(lastuploadedby);
});

$('#editHazardSubstance').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');
    var recordid = $(e.relatedTarget).data('recordid');
    var productname = $(e.relatedTarget).data('productname');
    var unnumber = $(e.relatedTarget).data('unnumber');
    var approvalnumber = $(e.relatedTarget).data('approvalnumber');
    var groupstandard = $(e.relatedTarget).data('groupstandard');
    var hazardclassification = $(e.relatedTarget).data('hazardclassification');
    var currentsdsavailable = $(e.relatedTarget).data('currentsdsavailable');
    var specificstorage = $(e.relatedTarget).data('specificstorage');
    var segregationrequirements = $(e.relatedTarget).data('segregationrequirements');
    var containersize = $(e.relatedTarget).data('containersize');
    var openclosecontainer = $(e.relatedTarget).data('openclosecontainer');
    var gasliquidsolid = $(e.relatedTarget).data('gasliquidsolid');
    var location = $(e.relatedTarget).data('location');
    var maximumlikelyamount = $(e.relatedTarget).data('maximumlikelyamount');

    $(e.currentTarget).find('input[name="edtHSRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
    $(e.currentTarget).find('input[name="edtHSProductName"]').val(productname);
    $(e.currentTarget).find('input[name="edtHSUnNumber"]').val(unnumber);
    $(e.currentTarget).find('input[name="edtHSApprovalNumber"]').val(approvalnumber);
    $(e.currentTarget).find('input[name="edtHSGroupStandard"]').val(groupstandard);
    $(e.currentTarget).find('input[name="edtHSHazardClassification"]').val(hazardclassification);
    $(e.currentTarget).find('input[name="edtHSCurrentSDSAvailable"]').val(currentsdsavailable);
    $(e.currentTarget).find('input[name="edtHSSpecificStorage"]').val(specificstorage);
    $(e.currentTarget).find('input[name="edtHSSegregationRequirements"]').val(segregationrequirements);
    $(e.currentTarget).find('input[name="edtHSContainerSize"]').val(containersize);
    $(e.currentTarget).find('input[name="edtHSOpenCloseContainer"]').val(openclosecontainer);
    $(e.currentTarget).find('input[name="edtHSGasLiquidSolid"]').val(gasliquidsolid);
    $(e.currentTarget).find('input[name="edtHSLocation"]').val(location);
    $(e.currentTarget).find('input[name="edtHSMaximumLikelyAmount"]').val(maximumlikelyamount);
});

$('#editHazardRegister').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');
    var recordid = $(e.relatedTarget).data('recordid');
    var identifiedhazard = $(e.relatedTarget).data('identifiedhazard');
    var initialriskassessment = $(e.relatedTarget).data('initialriskassessment');
    var controls = $(e.relatedTarget).data('controls');
    var levelofcontrol = $(e.relatedTarget).data('levelofcontrol');
    var residualriskassessment = $(e.relatedTarget).data('residualriskassessment');

    $(e.currentTarget).find('input[name="edtHRRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
    $(e.currentTarget).find('input[name="edtHRIdentifiedHazard"]').val(identifiedhazard);
    $(e.currentTarget).find('select[name="edtHRInitialRiskAssessment"]').val(initialriskassessment);
    $(e.currentTarget).find('input[name="edtHRControls"]').val(controls);
    $(e.currentTarget).find('select[name="edtHRLevelOfControl"]').val(levelofcontrol);
    $(e.currentTarget).find('select[name="edtHRResidualRiskAssessment"]').val(residualriskassessment);
});

$('#editSeismicResilience').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');
    var recordid = $(e.relatedTarget).data('recordid');
    var name = $(e.relatedTarget).data('name');
    var attachment = $(e.relatedTarget).data('attachment');
    var type = $(e.relatedTarget).data('type');
    var uploadedby = $(e.relatedTarget).data('uploadedby');
    var lastuploadedby = $(e.relatedTarget).data('lastuploadedby');

    $(e.currentTarget).find('input[name="edtSRRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
    $(e.currentTarget).find('input[name="edtSRName"]').val(name);
    $(e.currentTarget).find('label[id="edtSRAttachmentLbl"]').text(attachment);
    $(e.currentTarget).find('input[name="oldAttachment"]').val(attachment);
    $(e.currentTarget).find('select[name="edtSRType"]').val(type);
    $(e.currentTarget).find('input[name="edtSRUploadedBy"]').val(uploadedby);
    $(e.currentTarget).find('input[name="edtSRLastUploadedBy"]').val(lastuploadedby);
});

$('#editResourceConsent').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');
    var recordid = $(e.relatedTarget).data('recordid');
    var name = $(e.relatedTarget).data('name');
    var attachment = $(e.relatedTarget).data('attachment');
    var type = $(e.relatedTarget).data('type');
    var uploadedby = $(e.relatedTarget).data('uploadedby');
    var lastuploadedby = $(e.relatedTarget).data('lastuploadedby');

    $(e.currentTarget).find('input[name="edtRCRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
    $(e.currentTarget).find('input[name="edtRCName"]').val(name);
    $(e.currentTarget).find('label[id="edtRCAttachmentLbl"]').text(attachment);
    $(e.currentTarget).find('input[name="oldAttachment"]').val(attachment);
    $(e.currentTarget).find('select[name="edtRCType"]').val(type);
    $(e.currentTarget).find('input[name="edtRCUploadedBy"]').val(uploadedby);
    $(e.currentTarget).find('input[name="edtRCLastUploadedBy"]').val(lastuploadedby);
});

$('#editCInspection').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');
    var recordid = $(e.relatedTarget).data('recordid');
    var inspectiondate = $(e.relatedTarget).data('inspectiondate');
    var finding = $(e.relatedTarget).data('finding');
    var description = $(e.relatedTarget).data('description');
    var inspectionstatus = $(e.relatedTarget).data('inspectionstatus');
    var image = $(e.relatedTarget).data('image');

    $(e.currentTarget).find('input[name="edtCIRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
    $(e.currentTarget).find('input[name="edtCIInspectionDate"]').val(inspectiondate);
    $(e.currentTarget).find('input[name="edtCIFinding"]').val(finding);
    $(e.currentTarget).find('input[name="edtCIDescription"]').val(description);
    $(e.currentTarget).find('input[name="edtCIInspectionStat"]').val(inspectionstatus);
    $(e.currentTarget).find('label[id="edtCIImageLbl"]').text(image);
    $(e.currentTarget).find('input[name="oldImage"]').val(image);
});

/**************** DELETE MODALS HERE **************************************/

$('#deleteGenInfo').on('show.bs.modal', function(e) {
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#deleteContacts').on('show.bs.modal', function(e) {
    var recordid = $(e.relatedTarget).data('recordid');
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="dltCRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#deleteWof').on('show.bs.modal', function(e) {
    var recordid = $(e.relatedTarget).data('recordid');
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="dltWRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#deleteConsent').on('show.bs.modal', function(e) {
    var recordid = $(e.relatedTarget).data('recordid');
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="dltCSRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#deleteAsbestos').on('show.bs.modal', function(e) {
    var recordid = $(e.relatedTarget).data('recordid');
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="dltARecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#deleteElectrical').on('show.bs.modal', function(e) {
    var recordid = $(e.relatedTarget).data('recordid');
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="dltERecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#deleteGas').on('show.bs.modal', function(e) {
    var recordid = $(e.relatedTarget).data('recordid');
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="dltGRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#deleteFire').on('show.bs.modal', function(e) {
    var recordid = $(e.relatedTarget).data('recordid');
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="dltFRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#deleteHazardSubstance').on('show.bs.modal', function(e) {
    var recordid = $(e.relatedTarget).data('recordid');
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="dltHSRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#deleteHazardRegister').on('show.bs.modal', function(e) {
    var recordid = $(e.relatedTarget).data('recordid');
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="dltHRRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#deleteSeismicResilience').on('show.bs.modal', function(e) {
    var recordid = $(e.relatedTarget).data('recordid');
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="dltSRRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#deleteResourceConsent').on('show.bs.modal', function(e) {
    var recordid = $(e.relatedTarget).data('recordid');
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="dltRCRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});

$('#deleteCInspection').on('show.bs.modal', function(e) {
    var recordid = $(e.relatedTarget).data('recordid');
    var buildingid = $(e.relatedTarget).data('buildingid');

    $(e.currentTarget).find('input[name="dltCIRecordID"]').val(recordid);
    $(e.currentTarget).find('input[name="buildingID"]').val(buildingid);
});
                      
</script>

</body>
</html>

