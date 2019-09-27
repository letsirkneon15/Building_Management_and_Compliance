
<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body">
	<div align="right">
		<button type="button" class="btn btn-primary"
			data-toggle="modal" data-target="#crtCInspection">
			<h5>
				<span class="glyphicon glyphicon-plus-sign"></span><b> Add Compliance Inspection</b>
			</h5>
		</button>
		<br> <br>
	</div>
	
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
							<td align="center"><a href="#editCInspection" data-toggle="modal"
								data-id="edtLink${bIndex.index}"
								data-buildingID="${b.buildingID}"><img src='images/edit.jpg'
									height=15 width=15></a></td>
							<%-- <td><a href="" id="dltLink${hsIndex.index}"><img src='images/delete.jpg' height=15 width=15></a> --%>
							<td align="center"><a href="#deleteСInspection" data-toggle="modal"
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

<!--START- Create Record (MODAL)-->
<div class="modal fade" id="crtCInspection" role="dialog">
	<div class="modal-dialog" style="width: 100%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left"><b>Compliance Inspection - Create a New Record</b></h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to edit record -->
			<form action="${pageContext.request.contextPath}/Tabs?action=crtCInspection" method="post">
				<div class="modal-body bgColorWhite">
					<div class="table-responsive" style="width:100%">
						<div class="well">

							<div class="panel-default">
								<div class="panel-body">
									<!-- Date  -->
									<div class="col-sm-6">
										<label for="date">Date:</label>
										<input class="form-control" name = "crtCIInspectionDate" id="crtCIInspectionDate" type="date" value="${crtCIInspectionDate}">
									</div>

									<!-- Finding  -->
									<div class="col-sm-6">
										<label for="finding">Finding:</label>
										<input class="form-control" name = "crtCIFinding" id="crtСIFinding" type="text" value="${crtCIFinding}">
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Description -->
									<div class="col-sm-6">
										<label for="description">Description:</label>
										<input class="form-control" name="crtCIDescription" id="crtCIDescription" type="text" value="${crtCIDescription}">
									</div>

									<!-- Inspection Status  -->
									<div class="col-sm-6">
										<label for="inspectionStatus">Inspection Status:</label>
										<input class="form-control" name="crtCIInspectionStat" id="crtCIInspectionStat" type="text" value="${crtCIInspectionStat}">
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Image  -->
									<div class="col-sm-6">
										<label for="image">Image:</label>
										<input class="form-control" name="crtCIImage" id="crtCIImage" type="text" value="${crtCIImage}">
									</div>
									<input class="form-control" name="crtCIBuildingID" id="crtCIBuildingID" type="hidden" value="${crtCIBuildingID}">
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<!-- Submit Button -->
					<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-edit"></span> Create </button>
					<button type="button" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!--END- Create Record (MODAL)-->

<!--START- Edit Record (MODAL)-->
<div class="modal fade" id="editCInspection" role="dialog">
	<div class="modal-dialog" style="width: 100%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left"><b>Compliance Inspection - Update Record</b></h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to edit record -->
			<form action="${pageContext.request.contextPath}/Tabs?action=editCInspection" method="post">
				<div class="modal-body bgColorWhite">
					<div class="table-responsive" style="width:100%">
						<div class="well">

							<div class="panel-default">
								<div class="panel-body">
									<!-- Date  -->
									<div class="col-sm-6">
										<label for="date">Date:</label>
										<input class="form-control" name = "edtCIInspectionDate" id="edtCIInspectionDate" type="date" value="">
									</div>

									<!-- Finding  -->
									<div class="col-sm-6">
										<label for="finding">Finding:</label>
										<input class="form-control" name = "edtCIFinding" id="edtCIFinding" type="text" value="">
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Description -->
									<div class="col-sm-6">
										<label for="description">Description:</label>
										<input class="form-control" name="edtCIDescription" id="edtCIDescription" type="text" value="">
									</div>

									<!-- Inspection Status  -->
									<div class="col-sm-6">
										<label for="inspectionStatus">Inspection Status:</label>
										<input class="form-control" name="edtCIInspectionStat" id="edtCIInspectionStat" type="text" value="">
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Image  -->
									<div class="col-sm-6">
										<label for="image">Image:</label>
										<input class="form-control" name="edtCIImage" id="edtCIImage" type="text" value="">
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<input class="form-control" name="edtCIRecordID" id="edtCIRecordID" type="hidden" value="">
									<input class="form-control" name="edtCIBuildingID" id="edtCIBuildingID" type="hidden" value="">
								</div>
							</div>

						</div>
					</div>
				</div>
				<div class="modal-footer">
					<!-- Submit Button -->
					<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-edit"></span> Update</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!--END- Edit Record (MODAL)-->

<!--START- Delete (MODAL)-->
<div class="modal fade" id="deleteСInspection" role="dialog">
	<div class="modal-dialog" style="width: 50%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left"><b>Compliance Inspection - Delete Record</b></h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to delete record -->
			<form action="${pageContext.request.contextPath}/Tabs?action=dltCInspection" method="post">
				<div class="modal-body bgColorWhite">
					<p> Are you sure you wish to delete one record? </p>
				</div>
				<input class="form-control" name="dltCIRecordID" id="dltCIRecordID" type="hidden" value="">
				<input class="form-control" name="dltСIBuildingID" id="dltCIBuildingID" type="hidden" value="">
				<div class="modal-footer">
					<!-- Submit Button -->
					<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-edit"></span> Delete</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-eye-close"></span> Close</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!--END- Delete Record (MODAL)-->