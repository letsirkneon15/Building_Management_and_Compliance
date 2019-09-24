
<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body">
		<div class="table-responsive">
			<table id="complianceInspectionTable" class="table table-bordered table-hover table-striped table-condensed" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Date</th>
						<th>Finding</th>
						<th>Descriptions</th>
						<th>Status</th>
						<th>Image File</th>
						<th>Actions</th>
						<th class="sorting_asc_disabled sorting_desc_disabled"></th>
           			  	<th class="sorting_asc_disabled sorting_desc_disabled"></th> 
           			  	<th class="sorting_asc_disabled sorting_desc_disabled"></th> 
					</tr>
				</thead>

				<!-- Start Rows -->
				<tbody>
					<c:forEach var="b" items="${complianceInspectionArr}" varStatus="bIndex">
						<tr>
							<td>${b.inspectionDate }</td>
							<td>${b.finding }</td>
							<td>${b.description }</td>
							<td>${b.inspectionStatus }</td>
							<td>${b.image }</td>
							<td> </td>
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
					</c:forEach>
				</tbody>
				<!-- End Rows -->

			</table>
		</div>
	</div>
</div>
<!-- End of DataTables -->

