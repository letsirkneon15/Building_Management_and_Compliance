
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-striped table-bordered dt-responsive nowrap" id="hazardousSubstancesTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
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
					<d:forEach var="b" items="${asbestosArr}" varStatus="bIndex">
						<tr>
							<td>${b.productName }</td>
							<td>${b.unNumber }</td>
							<td>${b.approvalNumber }</td>
							<td>${b.groupStandard }</td>
							<td>${b.hazardClassification }</td>
							<td>${b.currentSDSAvailable }</td>
							<td>${b.specificStorage }</td>
							<td>${b.segregationRequirements }</td>
							<td>${b.containerSize }</td>
							<td>${b.openCloseContainerNumber }</td>
							<td>${b.gasLiquidSolid }</td>				
							<td>${b.location }</td>		
							<td>${b.maximumLikelyAmount }</td>									
							<td><a href="#downloadCloud" data-toggle="modal"
								data-id="downloadLink${bIndex.index}"
								data-buildingId="${b.buildingId}"><img
									src='images/download_cloud.png' height=15 width=15></a></td>
							<td><a href="#editRecord" data-toggle="modal"
								data-id="edtLink${bIndex.index}"
								data-buildingId="${b.buildingId}"><img src='images/edit.jpg'
									height=15 width=15></a></td>
							<%-- <td><a href="" id="dltLink${hsIndex.index}"><img src='images/delete.jpg' height=15 width=15></a> --%>
							<td><a href="#deleteRecord" data-toggle="modal"
								data-id="dltLink${bIndex.index}"
								data-buildingId="${b.buildingId}"><img
									src='images/delete.jpg' height=15 width=15></a></td>
						</tr>
					</d:forEach>
				</tbody>
				<!-- End Rows -->

			</table>
		</div>
	</div>
</div>
<!-- End of DataTables -->

