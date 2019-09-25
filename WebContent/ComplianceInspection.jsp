
<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body">
	
	<div align="right">
		<button type="button" class="btn btn-primary"
			data-toggle="modal" data-target="#crtContacts">
			<h5>
				<span class="glyphicon glyphicon-plus-sign"></span><b> Add
					Compliance Inspection</b>
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

<!--START- Edit Record (MODAL)-->
<div class="modal fade" id="editContacts" role="dialog">
	<div class="modal-dialog" style="width: 100%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left"><b>Building Contacts - Update Record</b></h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to edit record -->
			<form action="${pageContext.request.contextPath}/Tabs?action=editContacts" method="post">
				<div class="modal-body bgColorWhite">
					<div class="table-responsive" style="width:100%">
						<div class="well">

							<div class="panel-default">
								<div class="panel-body">
									<!-- Name  -->
									<div class="col-sm-6">
										<label for="name">Name:</label>
										<input class="form-control" name = "edtCName" id="edtCName" type="text" value="">
									</div>

									<!-- Type  -->
									<div class="col-sm-6">
										<label for="type">Type:</label>
										<input class="form-control" name = "edtCType" id="edtCType" type="text" value="">
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Company -->
									<div class="col-sm-6">
										<label for="company">Company:</label>
										<input class="form-control" name="edtCCompany" id="edtCCompany" type="text" value="">
									</div>

									<!-- Phone Number  -->
									<div class="col-sm-6">
										<label for="phoneNumber">Phone Number:</label>
										<input class="form-control" name="edtCPhoneNumber" id="edtCPhoneNumber" type="text" value="">
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Fax Number  -->
									<div class="col-sm-6">
										<label for="faxNumber">Fax Number:</label>
										<input class="form-control" name="edtCFaxNumber" id="edtCFaxNumber" type="text" value="">
									</div>

									<!-- Mobile Number -->
									<div class="col-sm-6">
										<label for="mobileNumber">Mobile Number:</label>
										<input class="form-control" name="edtCMobileNumber" id="edtCMobileNumber" type="text" value="">
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Email Address  -->
									<div class="col-sm-6">
										<label for="emailAdd">Email Address:</label>
										<input class="form-control" name="edtCEmailAdd" id="edtCEmailAdd" type="text" value="">
									</div>

									<input class="form-control" name="edtCRecordID" id="edtCRecordID" type="hidden" value="">
									<input class="form-control" name="edtCBuildingID" id="edtCBuildingID" type="hidden" value="">
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
<div class="modal fade" id="deleteContacts" role="dialog">
	<div class="modal-dialog" style="width: 50%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left"><b>Building Contacts - Delete Record</b></h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to delete record -->
			<form action="${pageContext.request.contextPath}/Tabs?action=dltContacts" method="post">
				<div class="modal-body bgColorWhite">
					<p> Are you sure you wish to delete one record? </p>
				</div>
				<input class="form-control" name="dltCRecordID" id="dltCRecordID" type="hidden" value="">
				<input class="form-control" name="dltCBuildingID" id="dltCBuildingID" type="hidden" value="">
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