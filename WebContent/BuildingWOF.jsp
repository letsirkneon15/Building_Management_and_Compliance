


<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body">
		<c:if test="${not empty wofTab.tabCrt}">
		<div align="right">
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#crtWof" data-id="crtLink${bIndex.index}"
				data-buildingid="${buildingID}">
				<h5>
					<span class="glyphicon glyphicon-plus-sign"></span><b> Add
						Building WOF</b>
				</h5>
			</button>
			<br>
			<br>
		</div>
		</c:if>
		<div class="table-responsive">
			<table id="wofTable"
				class="table table-bordered table-hover table-striped table-condensed"
				width="100%" cellspacing="0">
				<thead>
					<tr align="center">
						<th>Name</th>
						<th>Titled Year</th>
						<th>Attachment</th>
						<th>Type</th>
						<th>Uploaded By</th>
						<th>Last Uploaded</th>
						<c:if test="${not empty wofTab.tabUpd}">
							<th class="sorting_asc_disabled sorting_desc_disabled"></th>
						</c:if>
						<c:if test="${not empty wofTab.tabDlt}">
							<th class="sorting_asc_disabled sorting_desc_disabled"></th>
						</c:if>
					</tr>
				</thead>

				<!-- Start Rows -->
				<tbody>
					<c:forEach var="b" items="${buildingWOFArr}" varStatus="bIndex">
						<tr>
							<td>${b.name }</td>
							<td>${b.titledYear }</td>
							<td><a href="${pageContext.request.contextPath}/FileDownload?fileName=${b.attachment }" target="_top">${b.attachment }</a></td>
							<td>${b.type }</td>
							<td>${b.uploadedBy }</td>
							<td>${b.lastUploadedBy }</td>

							<c:if test="${not empty wofTab.tabUpd}">
							<td align="center"><a href="#editWof" data-toggle="modal"
								data-id="edtLink${bIndex.index}" data-recordid="${b.recordID}"
								data-buildingid="${b.buildingID}" data-name="${b.name}"
								data-titledyear="${b.titledYear}"
								data-attachment="${b.attachment}" data-type="${b.type}"
								data-uploadedby="${b.uploadedBy}"
								data-lastuploadedby="${b.lastUploadedBy}"> <img
									src='images/edit.jpg' height="15" width="15" alt=""></a></td>
							</c:if>
	
							<c:if test="${not empty wofTab.tabDlt}">
							<td align="center"><a href="#deleteWof" data-toggle="modal"
								data-id="dltLink${bIndex.index}" data-recordid="${b.recordID}"
								data-buildingid="${b.buildingID}"> <img
									src='images/delete.jpg' height="15" width="15" alt=""></a></td>
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
<div class="modal fade" id="crtWof" role="dialog">
	<div class="modal-dialog" style="width: 100%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>Building WOF - Create New Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to create record -->
			<form onsubmit="return uploadAttachment('crtWof')"
				action="${pageContext.request.contextPath}/Tabs?action=crtTabs&amp;tab=WOF"
				method="post" class="form-group">
				<div class="modal-body bgColorWhite">
					<div class="table-responsive" style="width: 100%">
						<div class="well">

							<div class="panel-default">
								<div class="panel-body">
									<!-- Name  -->
									<div class="col-sm-6">
										<label for="name">Name:</label> <input class="form-control"
											name="crtWName" id="crtWName" type="text" value="${crtWName}">
									</div>

									<!-- Titled Year  -->
									<div class="col-sm-6">
										<label for="titledYear">Titled Year:</label> <input
											class="form-control" name="crtWTitledYear"
											id="crtWTitledYear" type="text" value="${crtWTitledYear}">
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
												name="crtWAttachment" id="crtWAttachment"
												value="${crtWAttachment}"> <label
												class="custom-file-label" for="customFile"
												id="crtWAttachmentLbl"></label>
										</div>
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Type  -->
									<div class="col-sm-6">
										<label for="type">Type:</label> 
										<select class="form-control" id="crtWType" name="crtWType">
			  								<c:forEach var="wType" items="${wTypeList}">			  								
  			     								<option value="${wType}">${wType}</option>
	   		  								</c:forEach>
	      								</select>
	
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
<div class="modal fade" id="editWof" role="dialog">
	<div class="modal-dialog" style="width: 100%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>Building WOF - Update Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to edit record -->
			<form onsubmit="return uploadAttachment('editWof')"
				action="${pageContext.request.contextPath}/Tabs?action=editTabs&amp;tab=WOF"
				method="post" class="form-group">
				<div class="modal-body bgColorWhite">
					<div class="table-responsive" style="width: 100%">
						<div class="well">

							<div class="panel-default">
								<div class="panel-body">
									<!-- Name  -->
									<div class="col-sm-6">
										<label for="name">Name:</label> <input class="form-control"
											name="edtWName" id="edtWName" type="text" value="">
									</div>

									<!-- Titled Year  -->
									<div class="col-sm-6">
										<label for="titledYear">Titled Year:</label> <input
											class="form-control" name="edtWTitledYear"
											id="edtWTitledYear" type="text" value="">
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
												name="edtWAttachment" id="edtWAttachment" value="">
											<label class="custom-file-label" for="customFile"
												id="edtWAttachmentLbl"></label>
											<input class="form-control" name="oldAttachment"
												id="oldAttachment" type="hidden" value=""> 
										</div>
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Type  -->
									<div class="col-sm-6">
										<label for="type">Type:</label> 
										<select class="form-control" id="edtWType" name="edtWType">
			  								<c:forEach var="wType" items="${wTypeList}">			  								
  			     								<option value="${wType}">${wType}</option>
	   		  								</c:forEach>
	      								</select>
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Uploaded By  -->
									<div class="col-sm-6">
									<label>Uploaded By:</label>
										<input class="form-control" name="edtWUploadedBy"
											id="edtWUploadedBy" type="text" value="" readOnly>
									</div>

									<!-- Last Uploaded -->
									<div class="col-sm-6">
									<label>Last Uploaded:</label>
										<input class="form-control" name="edtWLastUploadedBy"
											id="edtWLastUploadedBy" type="text" value="" readOnly>
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<input class="form-control" name="edtWRecordID"
										id="edtWRecordID" type="hidden" value=""> <input
										class="form-control" name="buildingID" id="buildingID"
										type="hidden" value="">
								</div>
							</div>

						</div>
					</div>
				</div>
				<div class="modal-footer">
					<!-- Submit Button -->
					<button type="submit" class="btn btn-primary" id="btnUpdate">
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
<div class="modal fade" id="deleteWof" role="dialog">
	<div class="modal-dialog" style="width: 50%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>Building WOF - Delete Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to delete record -->
			<form
				action="${pageContext.request.contextPath}/Tabs?action=dltTabs&amp;tab=WOF"
				method="post">
				<div class="modal-body bgColorWhite">
					<p>Are you sure you wish to delete one record?</p>
				</div>
				<input class="form-control" name="dltWRecordID" id="dltWRecordID"
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

