<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- DataTables -->
<div class="card shadow mb-4">

	<div class="card-body">
		<c:if test="${not empty seismicTab.tabCrt}">
		<div align="right">
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#crtSeismicResilience" data-id="crtLink${bIndex.index}"
				data-buildingid="${buildingID}">
				<h5>
					<span class="glyphicon glyphicon-plus-sign"></span><b> Add
						Seismic Resilience</b>
				</h5>
			</button>
			<br> <br>
		</div>
		</c:if>
		<div class="table-responsive">
			<table
				class="table table-bordered table-hover table-striped table-condensed"
				id="dataTable" width="100%" cellspacing="0">
				<thead>
					<tr align="center">
						<th>Name</th>
						<th>Attachment</th>
						<th>Type</th>
						<th>Uploaded By</th>
						<th>Last Uploaded</th>
						<c:if test="${not empty seismicTab.tabUpd}">
							<th class="sorting_asc_disabled sorting_desc_disabled"></th>
						</c:if>
						<c:if test="${not empty seismicTab.tabDlt}">
							<th class="sorting_asc_disabled sorting_desc_disabled"></th>
						</c:if>
					</tr>
				</thead>

				<!-- Start Rows -->
				<tbody>
					<c:forEach var="b" items="${seismicArr}" varStatus="bIndex">
						<tr>
							<td>${b.name }</td>
							<td><a href="${pageContext.request.contextPath}/FileDownload?fileName=${b.attachment }" target="_top">${b.attachment }</a></td>
							<td>${b.type }</td>
							<td>${b.uploadedBy }</td>
							<td>${b.lastUploadedBy }</td>

							<c:if test="${not empty seismicTab.tabUpd}">
							<td align="center"><a href="#editSeismicResilience"
								data-toggle="modal" data-id="edtLink${bIndex.index}"
								data-recordid="${b.recordID}" data-buildingid="${b.buildingID}"
								data-name="${b.name}" data-attachment="${b.attachment}"
								data-type="${b.type}" data-uploadedby="${b.uploadedBy}"
								data-lastuploadedby="${b.lastUploadedBy}"> <img
									src='images/edit.jpg' height=15 width=15></a></td>
							</c:if>
							
							<c:if test="${not empty seismicTab.tabDlt}">
							<td align="center"><a href="#deleteSeismicResilience"
								data-toggle="modal" data-id="dltLink${bIndex.index}"
								data-recordid="${b.recordID}" data-buildingid="${b.buildingID}">
									<img src='images/delete.jpg' height=15 width=15>
							</a></td>
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
<div class="modal fade" id="crtSeismicResilience" role="dialog">
	<div class="modal-dialog" style="width: 100%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>Seismic Resilience - Create New Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to create record -->
			<form onsubmit="return uploadAttachment('crtSeismicResilience')"
				action="${pageContext.request.contextPath}/Tabs?action=crtTabs&tab=Seismic"
				method="post">
				<div class="modal-body bgColorWhite">
					<div class="table-responsive" style="width: 100%">
						<div class="well">

							<div class="panel-default">
								<div class="panel-body">
									<!-- Name  -->
									<div class="col-sm-6">
										<label for="name">Name:</label> <input class="form-control"
											name="crtSRName" id="crtSRName" type="text"
											value="${crtSRName}">
									</div>

									<!-- Type  -->
									<div class="col-sm-6">
										<label for="type">Type:</label> <select class="form-control"
											id="crtSRType" name="crtSRType">
											<c:forEach var="sType" items="${sTypeList}">
												<option value="${sType}">${sType}</option>
											</c:forEach>
										</select>
									</div>

								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<div class="col-sm-12">
										<!-- Attachment -->
										<label>Attachment:</label>
										<div class="custom-file">
											<input type="file" class="custom-file-input"
												name="crtSRAttachment" id="crtSRAttachment"
												value="${crtSRAttachment}"> <label
												class="custom-file-label" for="customFile"
												id="crtSRAttachmentLbl"></label>
										</div>
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<input class="form-control" name="buildingID" id="buildingID"
										type="hidden" value="">
								</div>
							</div>

						</div>
					</div>
				</div>
				<div class="modal-footer">
					<!-- Submit Button -->
					<button type="submit" class="btn btn-primary">
						<span class="glyphicon glyphicon-edit"></span> Create
					</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">
						<span class="glyphicon glyphicon-remove"></span> Cancel
					</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!--END- Create Record (MODAL)-->


<!--START- Edit Record (MODAL)-->
<div class="modal fade" id="editSeismicResilience" role="dialog">
	<div class="modal-dialog" style="width: 100%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>Seismic Resilience - Update Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to edit record -->
			<form onsubmit="return uploadAttachment('editSeismicResilience')"
				action="${pageContext.request.contextPath}/Tabs?action=editTabs&tab=Seismic"
				method="post">
				<div class="modal-body bgColorWhite">
					<div class="table-responsive" style="width: 100%">
						<div class="well">

							<div class="panel-default">
								<div class="panel-body">
									<!-- Name  -->
									<div class="col-sm-6">
										<label for="name">Name:</label> <input class="form-control"
											name="edtSRName" id="edtSRName" type="text" value="">
									</div>

									<!-- Type  -->
									<div class="col-sm-6">
										<label for="type">Type:</label> <select class="form-control"
											id="edtSRType" name="edtSRType">
											<c:forEach var="sType" items="${sTypeList}">
												<option value="${sType}">${sType}</option>
											</c:forEach>
										</select>
									</div>

								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<div class="col-sm-12">
										<!-- Attachment -->
										<label>Attachment:</label>
										<div class="custom-file">
											<input type="file" class="custom-file-input"
												name="edtSRAttachment" id="edtSRAttachment" value="">
											<label class="custom-file-label" for="customFile"
												id="edtSRAttachmentLbl"></label>
											<input class="form-control" name="oldAttachment" id="oldAttachment" type="hidden" value=""> 
										</div>
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Uploaded By  -->
									<div class="col-sm-6">
									<label>Uploaded By:</label>
										<input class="form-control" name="edtSRUploadedBy"
											id="edtSRUploadedBy" type="text" value="" readOnly>
									</div>

									<!-- Last Uploaded -->
									<div class="col-sm-6">
									<label>Last Uploaded:</label>
										<input class="form-control" name="edtSRLastUploadedBy"
											id="edtSRLastUploadedBy" type="text" value="" readOnly>
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<input class="form-control" name="edtSRRecordID"
										id="edtSRRecordID" type="hidden" value=""> <input
										class="form-control" name="buildingID" id="buildingID"
										type="hidden" value="">
								</div>
							</div>

						</div>
					</div>
				</div>
				<div class="modal-footer">
					<!-- Submit Button -->
					<button type="submit" class="btn btn-primary">
						<span class="glyphicon glyphicon-edit"></span> Update
					</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">
						<span class="glyphicon glyphicon-remove"></span> Cancel
					</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!--END- Edit Record (MODAL)-->

<!--START- Delete (MODAL)-->
<div class="modal fade" id="deleteSeismicResilience" role="dialog">
	<div class="modal-dialog" style="width: 50%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>Seismic Resilience - Delete Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to delete record -->
			<form
				action="${pageContext.request.contextPath}/Tabs?action=dltTabs&tab=Seismic"
				method="post">
				<div class="modal-body bgColorWhite">
					<p>Are you sure you wish to delete one record?</p>
				</div>
				<input class="form-control" name="dltSRRecordID" id="dltSRRecordID"
					type="hidden" value=""> <input class="form-control"
					name="buildingID" id="buildingID" type="hidden" value="">
				<div class="modal-footer">
					<!-- Submit Button -->
					<button type="submit" class="btn btn-primary">
						<span class="glyphicon glyphicon-edit"></span> Delete
					</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal">
						<span class="glyphicon glyphicon-eye-close"></span> Close
					</button>
				</div>
			</form>
		</div>
	</div>
</div>
<!--END- Delete Record (MODAL)-->

