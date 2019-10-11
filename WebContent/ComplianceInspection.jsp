
<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body">
	<c:if test="${not empty comInsTab.tabCrt}">
	<div align="right">
		<button type="button" class="btn btn-primary"
			data-toggle="modal" data-target="#crtCInspection" data-id="crtLink${bIndex.index}" data-buildingid="${buildingID}">
			<h5>
				<span class="glyphicon glyphicon-plus-sign"></span><b> Add Compliance Inspection</b>
			</h5>
		</button>
		<br> <br>
	</div>
	</c:if>
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
						<c:if test="${not empty comInsTab.tabUpd}">
           			  		<th class="sorting_asc_disabled sorting_desc_disabled"></th> 
           			  	</c:if>
           			  	<c:if test="${not empty comInsTab.tabDlt}">
           			  		<th class="sorting_asc_disabled sorting_desc_disabled"></th> 
           			  	</c:if>
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
							<td><a href="${pageContext.request.contextPath}/FileDownload?fileName=${b.image }" target="_top">${b.image }</a></td>
							
							<c:if test="${not empty comInsTab.tabUpd}">
							<td><a href="#editCInspection" data-toggle="modal"
								data-id="edtLink${bIndex.index}" data-recordid="${b.recordID}" data-buildingID="${b.buildingID}"
								data-inspectiondate="${b.inspectionDate}" data-finding="${b.finding}" data-description="${b.description}"
								data-inspectionstatus="${b.inspectionStatus}" data-image="${b.image}"><img src='images/edit.jpg' height=15 width=15></a></td>
							</c:if>
							
							<c:if test="${not empty comInsTab.tabDlt}">
							<td><a href="#deleteCInspection" data-toggle="modal"
								data-id="dltLink${bIndex.index}" data-recordid="${b.recordID}"
								data-buildingID="${b.buildingID}"><img src='images/delete.jpg' height=15 width=15></a></td>
							</c:if>
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
			<form onsubmit="return uploadAttachment('crtCInspection')"
			action="${pageContext.request.contextPath}/Tabs?action=crtTabs&tab=ComIns" method="post">
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
										<input class="form-control" name = "crtCIFinding" id="crtCIFinding" type="text" value="${crtCIFinding}">
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
  									<div class="col-sm-12">
     				  				<label>Image:</label>	
     				  				<div class="custom-file">
    									<input type="file" class="custom-file-input" accept="image/*" name="crtCIImage" id="crtCIImage" value="${crtCIImage}">
    									<label class="custom-file-label" for="customFile" id="crtCIImageLbl"></label>
  					  				</div>
  									</div>
									<input class="form-control" name="buildingID" id="buildingID" type="hidden" value="">
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
			<form onsubmit="return uploadAttachment('editCInspection')"
			action="${pageContext.request.contextPath}/Tabs?action=editTabs&tab=ComIns" method="post">
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
  									<div class="col-sm-12">
     				  				<label>Image:</label>	
     				  				<div class="custom-file">
    									<input type="file" class="custom-file-input" accept="image/*" name="edtCIImage" id="edtCIImage" value="">
    									<label class="custom-file-label" for="customFile" id="edtCIImageLbl"></label>
    									<input class="form-control" name="oldImage" id="oldImage" type="hidden" value=""> 
  					  				</div>
  									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<input class="form-control" name="edtCIRecordID" id="edtCIRecordID" type="hidden" value="">
									<input class="form-control" name="buildingID" id="buildingID" type="hidden" value="">
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
<div class="modal fade" id="deleteCInspection" role="dialog">
	<div class="modal-dialog" style="width: 50%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left"><b>Compliance Inspection - Delete Record</b></h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to delete record -->
			<form action="${pageContext.request.contextPath}/Tabs?action=dltTabs&tab=ComIns" method="post">
				<div class="modal-body bgColorWhite">
					<p> Are you sure you wish to delete one record? </p>
				</div>
				<input class="form-control" name="dltCIRecordID" id="dltCIRecordID" type="hidden" value="">
				<input class="form-control" name="buildingID" id="buildingID" type="hidden" value="">
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