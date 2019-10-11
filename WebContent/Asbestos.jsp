
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body">
		<c:if test="${not empty asbestosTab.tabCrt}">
		<div align="right">
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#crtAsbestos" data-id="crtLink${bIndex.index}"
				data-buildingid="${buildingID}">
				<h5>
					<span class="glyphicon glyphicon-plus-sign"></span><b> Add
						Asbestos</b>
				</h5>
			</button>
			<br> <br>
		</div>
		</c:if>
		<div class="table-responsive">
			<table
				class="table table-bordered table-hover table-striped table-condensed"
				id="asbestosTable" width="100%" cellspacing="0">
				<thead>
					<tr align="center">
						<th>Name</th>
						<th>Attachment</th>
						<th>Type</th>
						<th>Uploaded By</th>
						<th>Last Uploaded</th>
						<c:if test="${not empty asbestosTab.tabUpd}">
							<th class="sorting_asc_disabled sorting_desc_disabled"></th>
						</c:if>
						<c:if test="${not empty asbestosTab.tabDlt}">
							<th class="sorting_asc_disabled sorting_desc_disabled"></th>
						</c:if>
					</tr>
				</thead>

				<!-- Start Rows -->
				<tbody>
					<d:forEach var="b" items="${asbestosArr}" varStatus="bIndex">
						<tr>
							<td>${b.name }</td>
							<td><a href="${pageContext.request.contextPath}/FileDownload?fileName=${b.attachment }" target="_top">${b.attachment }</a></td>
							<td>${b.type }</td>
							<td>${b.uploadedBy }</td>
							<td>${b.lastUploadedBy }</td>
	
							<c:if test="${not empty asbestosTab.tabUpd}">
							<td align="center"><a href="#editAsbestos"
								data-toggle="modal" data-id="edtLink${bIndex.index}"
								data-recordid="${b.recordID}" data-buildingid="${b.buildingID}"
								data-name="${b.name}" data-attachment="${b.attachment}"
								data-type="${b.type}" data-uploadedby="${b.uploadedBy}"
								data-lastuploadedby="${b.lastUploadedBy}"> <img
									src='images/edit.jpg' height=15 width=15></a></td>
							</c:if>

							<c:if test="${not empty asbestosTab.tabDlt}">
							<td align="center"><a href="#deleteAsbestos"
								data-toggle="modal" data-id="dltLink${bIndex.index}"
								data-recordid="${b.recordID}" data-buildingid="${b.buildingID}"><img
									src='images/delete.jpg' height=15 width=15></a></td>
							</c:if>

						</tr>
					</d:forEach>
				</tbody>
				<!-- End Rows -->

			</table>
		</div>
	</div>
</div>
<!-- End of DataTables -->

<!--START- Create Record (MODAL)-->
<div class="modal fade" id="crtAsbestos" role="dialog">
	<div class="modal-dialog" style="width: 100%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>Asbestos - Create New Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to create record -->
			<form onsubmit="return uploadAttachment('crtAsbestos')"
				action="${pageContext.request.contextPath}/Tabs?action=crtTabs&tab=Asbestos"
				method="post">
				<div class="modal-body bgColorWhite">
					<div class="table-responsive" style="width: 100%">
						<div class="well">

							<div class="panel-default">
								<div class="panel-body">
									<!-- Name  -->
									<div class="col-sm-6">
										<label for="name">Name:</label> <input class="form-control"
											name="crtAName" id="crtAName" type="text" value="${crtAName}">
									</div>
									
									<!-- Type  -->
									<div class="col-sm-6">
										<label for="type">Type:</label> 
										<select class="form-control" id="crtAType" name="crtAType">
			  								<d:forEach var="aType" items="${aTypeList}">			  								
  			     								<option value="${aType}">${aType}</option>
	   		  								</d:forEach>
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
    									<input type="file" class="custom-file-input" name="crtAAttachment" id="crtAAttachment" value="${crtAAttachment}">
    									<label class="custom-file-label" for="customFile" id="crtAAttachmentLbl"></label>
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
<div class="modal fade" id="editAsbestos" role="dialog">
	<div class="modal-dialog" style="width: 100%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>Asbestos - Update Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to edit record -->
			<form onsubmit="return uploadAttachment('editAsbestos')"
				action="${pageContext.request.contextPath}/Tabs?action=editTabs&tab=Asbestos"
				method="post">
				<div class="modal-body bgColorWhite">
					<div class="table-responsive" style="width: 100%">
						<div class="well">

							<div class="panel-default">
								<div class="panel-body">
									<!-- Name  -->
									<div class="col-sm-6">
										<label for="name">Name:</label> <input class="form-control"
											name="edtAName" id="edtAName" type="text" value="">
									</div>
									
									<!-- Type  -->
									<div class="col-sm-6">
										<label for="type">Type:</label> 
										<select class="form-control" id="edtAType" name="edtAType">
			  								<d:forEach var="aType" items="${aTypeList}">			  								
  			     								<option value="${aType}">${aType}</option>
	   		  								</d:forEach>
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
    									<input type="file" class="custom-file-input" name="edtAAttachment" id="edtAAttachment" value="">
    									<label class="custom-file-label" for="customFile" id="edtAAttachmentLbl"></label>
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
										<input
											class="form-control" name="edtAUploadedBy"
											id="edtAUploadedBy" type="text" value="" readOnly>
									</div>
									
									<!-- Last Uploaded -->
									<div class="col-sm-6">
									<label>Last Uploaded:</label>
									<input
											class="form-control" name="edtALastUploadedBy"
											id="edtALastUploadedBy" type="text" value="" readOnly>
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<input class="form-control" name="edtARecordID"
										id="edtARecordID" type="hidden" value=""> <input
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
<div class="modal fade" id="deleteAsbestos" role="dialog">
	<div class="modal-dialog" style="width: 50%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>Asbestos - Delete Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to delete record -->
			<form
				action="${pageContext.request.contextPath}/Tabs?action=dltTabs&tab=Asbestos"
				method="post">
				<div class="modal-body bgColorWhite">
					<p>Are you sure you wish to delete one record?</p>
				</div>
				<input class="form-control" name="dltARecordID" id="dltARecordID"
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