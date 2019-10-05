<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Report Preview -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Report Preview</h6>
		</div>

		<!-- DataTables -->
		<div class="card-body">
			<div class="table-responsive">
				<table
					class="table table-bordered table-hover table-striped table-condensed"
					id="reportsTable" width="100%" cellspacing="0">

					<!-- START - Building General Information -->
					<c:if
						test="${reportFormat == 'Building General Information' || reportFormat == 'BWOF Anniversary Current vs Expired'}">

						<thead>
							<tr>
								<th>Name of Building</th>
								<th>Address</th>
								<th>Responsible Office</th>
								<th>Client</th>
								<th>Project#</th>
								<th>Building Information</th>
								<th>CS#</th>
								<th>Legal Description</th>
								<th>Max Occupants</th>
								<th>Fire Hazard Category</th>
								<th>Year Built</th>
								<th>Intended Life</th>
								<th>BWOF Expires</th>
								<th>Asbestos Present</th>
								<th>NBS %</th>
							</tr>
						</thead>

						<!-- Start Rows -->
						<tbody>
							<c:forEach var="b" items="${bGenInfo}" varStatus="bIndex">
								<tr class="table-row">
									<td>${b.buildingName }</td>
									<td>${b.address }</td>
									<td>${b.responsibleOffice }</td>
									<td>${b.client }</td>
									<td>${b.projectNumber }</td>
									<td>${b.buildingInformation }</td>
									<td>${b.csNumber }</td>
									<td>${b.legalDescription}</td>
									<td>${b.maxOccupants}</td>
									<td>${b.fireHazardCategory}</td>
									<td>${b.yearBuilt}</td>
									<td>${b.intendedLife}</td>
									<td>${b.bwofAnniversary }</td>
									<td>${b.asbestosPresent }</td>
									<td>${b.nbsPercentage }</td>
								</tr>
							</c:forEach>
						</tbody>

					</c:if>
					<!-- END - Building General Information -->

<!-- ******************************************************************************************************************* -->

					<!-- START - Building General Information + Asbestos -->
					<c:if
						test="${reportFormat == 'Asbestos'}">

						<thead>
							<tr>
								<th>Name of Building</th>
								<th>Address</th>
								<th>Responsible Office</th>
								<th>Client</th>
								<th>Project#</th>
								<th>Building Information</th>
								<th>CS#</th>
								<th>Legal Description</th>
								<th>Max Occupants</th>
								<th>Fire Hazard Category</th>
								<th>Year Built</th>
								<th>Intended Life</th>
								<th>BWOF Expires</th>
								<th>Asbestos Present</th>
								<th>NBS %</th>
								<th>Asbestos Name</th>
								<th>Attachment</th>
								<th>Type</th>
								<th>Uploaded By</th>
								<th>Last Uploaded</th>
							</tr>
						</thead>

						<!-- Start Rows -->
						<tbody>
							<c:forEach var="b" items="${bGenInfoAsbestos}" varStatus="bIndex">
								<tr class="table-row">
									<td>${b.buildingName }</td>
									<td>${b.address }</td>
									<td>${b.responsibleOffice }</td>
									<td>${b.client }</td>
									<td>${b.projectNumber }</td>
									<td>${b.buildingInformation }</td>
									<td>${b.csNumber }</td>
									<td>${b.legalDescription}</td>
									<td>${b.maxOccupants}</td>
									<td>${b.fireHazardCategory}</td>
									<td>${b.yearBuilt}</td>
									<td>${b.intendedLife}</td>
									<td>${b.bwofAnniversary }</td>
									<td>${b.asbestosPresent }</td>
									<td>${b.nbsPercentage }</td>
								 	<td>${b.name }</td>
									<td>${b.attachment }</td>
									<td>${b.type }</td>
									<td>${b.uploadedBy }</td>
									<td>${b.lastUploadedBy }</td>
								</tr>
							</c:forEach>
						</tbody>

					</c:if>
					<!-- END - Building General Information + Asbestos -->

<!-- ******************************************************************************************************************* -->

					<!-- START - Building General Information + Hazardous Substances -->
					<c:if
						test="${reportFormat == 'Hazardous Substance'}">

						<thead>
							<tr>
								<th>Name of Building</th>
								<th>Address</th>
								<th>Responsible Office</th>
								<th>Client</th>
								<th>Project#</th>
								<th>Building Information</th>
								<th>CS#</th>
								<th>Legal Description</th>
								<th>Max Occupants</th>
								<th>Fire Hazard Category</th>
								<th>Year Built</th>
								<th>Intended Life</th>
								<th>BWOF Expires</th>
								<th>Asbestos Present</th>
								<th>NBS %</th>
								<th>Product Name</th>
								<th>UN Number</th>
								<th>Approval Number</th>
								<th>Group Standard Name</th>
								<th>Hazard Classification</th>
								<th>SDS</th>
								<th>Storage and Segregation Requirements</th>
								<th>Container Size</th>
								<th>Open or Close Container</th>
								<th>Gas, Liquid or Solid</th>
								<th>Location</th>
								<th>Maximum Likely Amount</th>
							</tr>
						</thead>

						<!-- Start Rows -->
						<tbody>
							<c:forEach var="b" items="${bGenInfoHazardSubstance}" varStatus="bIndex">
								<tr class="table-row">
									<td>${b.buildingName }</td>
									<td>${b.address }</td>
									<td>${b.responsibleOffice }</td>
									<td>${b.client }</td>
									<td>${b.projectNumber }</td>
									<td>${b.buildingInformation }</td>
									<td>${b.csNumber }</td>
									<td>${b.legalDescription}</td>
									<td>${b.maxOccupants}</td>
									<td>${b.fireHazardCategory}</td>
									<td>${b.yearBuilt}</td>
									<td>${b.intendedLife}</td>
									<td>${b.bwofAnniversary }</td>
									<td>${b.asbestosPresent }</td>
									<td>${b.nbsPercentage }</td>
									<td>${b.productName }</td>
									<td>${b.unNumber }</td>
									<td>${b.approvalNumber }</td>
									<td>${b.groupStandard }</td>
									<td>${b.hazardClassification }</td>
									<td>${b.currentSDSAvailable }</td>
									<td>${b.specificStorage} / ${b.segregationRequirements}</td>
									<td>${b.containerSize }</td>
									<td>${b.openCloseContainer }</td>
									<td>${b.gasLiquidSolid }</td>				
									<td>${b.location }</td>		
									<td>${b.maximumLikelyAmount }</td>
								</tr>
							</c:forEach>
						</tbody>

					</c:if>
					<!-- END - Building General Information + Hazardous Substances -->
					
				</table>
			</div>
		</div>

	</div>
	<!-- End of Report Preview -->

</div>
<!-- End of Main Content -->


