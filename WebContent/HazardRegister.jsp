
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered table-hover table-striped table-condensed" id="hazardRegisterTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Identified Hazard</th>
						<th>Risk Assessment</th>
						<th>Controls</th>
						<th>Level of Controls</th>
						<th>Residual Risk Assessment</th>
					</tr>
				</thead>

				<!-- Start Rows -->
				<tbody>
					<d:forEach var="b" items="${hazRegisterArr}" varStatus="bIndex">
						<tr>
							<td>${b.identifiedHazard }</td>
							<td>${b.identifiedHazard }</td>
							<td>${b.controls }</td>
							<td>${b.levelOfControl }</td>
							<td>${b.residualRiskAssessment }</td>					
							<td><a href="#downloadCloud" data-toggle="modal"
								data-id="downloadLink${bIndex.index}"
								data-buildingID="${b.buildingID}"><img
									src='images/download_cloud.png' height=15 width=15></a></td>
							<td><a href="#editRecord" data-toggle="modal"
								data-id="edtLink${bIndex.index}"
								data-buildingID="${b.buildingID}"><img src='images/edit.jpg'
									height=15 width=15></a></td>
							<%-- <td><a href="" id="dltLink${hsIndex.index}"><img src='images/delete.jpg' height=15 width=15></a> --%>
							<td><a href="#deleteRecord" data-toggle="modal"
								data-id="dltLink${bIndex.index}"
								data-buildingID="${b.buildingID}"><img
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

