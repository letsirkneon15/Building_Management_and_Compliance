
<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body">
		<div align="right">
	<button type="button" class="btn btn-primary"
			data-toggle="modal" data-target="#crtConsent">
			<h5>
				<span class="glyphicon glyphicon-plus-sign"></span><b> Add
					Building Consent</b>
			</h5>
		</button>
		<br> <br> </div>
		<div class="table-responsive">
			<table class="table table-bordered table-hover table-striped table-condensed" id="consentTable" width="100%"
				cellspacing="0">
				<thead>
					<tr align="center">
						<th>Name</th>
						<th>Building Consent Number</th>
						<th>Attachment</th>
						<th>Type</th>
						<th>Uploaded By</th>
						<th>Last Uploaded</th>
						<th class="sorting_asc_disabled sorting_desc_disabled"></th>
           			  	<th class="sorting_asc_disabled sorting_desc_disabled"></th> 
           			  	<th class="sorting_asc_disabled sorting_desc_disabled"></th> 
					</tr>
				</thead>

				<!-- Start Rows -->
				<tbody>
					<c:forEach var="b" items="${buildingConsentArr}" varStatus="bIndex">
						<tr>
							<td>${b.name }</td>
							<td>${b.consentNumber }</td>
							<td>${b.attachment }</td>
							<td>${b.type }</td>
							<td>${b.uploadedBy }</td>
							<td>${b.lastUploadedBy }</td>
							
							<td align="center"><a href="#editConsent" data-toggle="modal"
								data-id="edtLink${bIndex.index}" data-recordid="${b.recordID}" data-buildingid="${b.buildingID}" 
								data-name="${b.name}" data-consentnumber="${b.consentNumber}" data-attachment="${b.attachment}"
								data-type="${b.type}" data-uploadedby="${b.uploadedBy}" data-lastuploadedby="${b.lastUploadedBy}">
								<img src='images/edit.jpg' height=15 width=15></a></td>
							
							<td align="center"><a href="#deleteConsent" data-toggle="modal"
								data-id="dltLink${bIndex.index}" data-recordid="${b.recordID}"
								data-buildingid="${b.buildingID}"><img
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
<div class="modal fade" id="crtConsent" role="dialog">
  <div class="modal-dialog" style="width: 100%">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h4 class="modal-title" align="left"><b>Building Consent - Create New Record</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to create record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=crtConsent" method="post">
         <div class="modal-body bgColorWhite">
         	<div class="table-responsive" style="width:100%">
         	 <div class="well">
     				
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Name  -->
     				<div class="col-sm-6">
     					<label for="name">Name:</label>
     					<input class="form-control" name = "crtCSName" id="crtCSName" type="text" value="${crtCSName}">
     				</div>
     				
     				<!-- Consent Number  -->
     				<div class="col-sm-6">
 						<label for="consentNumber">Consent Number:</label>
     					<input class="form-control" name = "crtCSConsentNumber" id="crtCSConsentNumber" type="text" value="${crtCSConsentNumber}">
    				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Attachment -->
     				<div class="col-sm-6">
     					<label for="attachment">Attachment:</label>
     					<input class="form-control" name="crtCSAttachment" id="crtCSAttachment" type="text" value="${crtCSAttachment}"> 	
     				</div>
     	
     				<!-- Type  -->
     				<div class="col-sm-6">
     					<label for="type">Type:</label>
     					<input class="form-control" name="crtCSType" id="crtCSType" type="text" value="${crtCSType}">	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
 					<!-- Uploaded By  -->
 					<div class="col-sm-6">
 						<label for="uploadedBy">Uploaded By:</label>
     					<input class="form-control" name="crtCSUploadedBy" id="crtCSUploadedBy" type="text" value="${crtCSUploadedBy}" readOnly>	
     				</div>
     				
     				<!-- Last Uploaded -->
     				<div class="col-sm-6">
     					<label for="lastUploadedBy">Last Uploaded:</label>
     					<input class="form-control" name="crtCSLastUploadedBy" id="crtCSLastUploadedBy" type="text" value="${crtCSLastUploadedBy}" readOnly>    
     				</div>			
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<input class="form-control" name="crtCSRecordID" id="crtCSRecordID" type="hidden" value="${crtCSRecordID}">
        			<input class="form-control" name="crtCSBuildingID" id="crtCSBuildingID" type="hidden" value="${crtCSBuildingID}">
     			</div>
     			</div>
     						
  	 		  </div>		
        	</div>
        	</div>
        	<div class="modal-footer">
  					<!-- Submit Button -->
         			<button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-edit"></span> Create</button>
					<button type="button" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
        	</div>
        </form>
	  </div>		     
  </div>
</div>	 
<!--END- Create Record (MODAL)-->


<!--START- Edit Record (MODAL)-->
<div class="modal fade" id="editConsent" role="dialog">
  <div class="modal-dialog" style="width: 100%">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h4 class="modal-title" align="left"><b>Building Consent - Update Record</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to edit record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=editConsent" method="post">
         <div class="modal-body bgColorWhite">
         	<div class="table-responsive" style="width:100%">
         	 <div class="well">
     				
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Name  -->
     				<div class="col-sm-6">
     					<label for="name">Name:</label>
     					<input class="form-control" name = "edtCSName" id="edtCSName" type="text" value="">
     				</div>
     				
     				<!-- Consent Number  -->
     				<div class="col-sm-6">
 						<label for="consentNumber">Consent Number:</label>
     					<input class="form-control" name = "edtCSConsentNumber" id="edtCSConsentNumber" type="text" value="">
    				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Attachment -->
     				<div class="col-sm-6">
     					<label for="attachment">Attachment:</label>
     					<input class="form-control" name="edtCSAttachment" id="edtCSAttachment" type="text" value=""> 	
     				</div>
     	
     				<!-- Type  -->
     				<div class="col-sm-6">
     					<label for="type">Type:</label>
     					<input class="form-control" name="edtCSType" id="edtCSType" type="text" value="">	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
 					<!-- Uploaded By  -->
 					<div class="col-sm-6">
 						<label for="uploadedBy">Uploaded By:</label>
     					<input class="form-control" name="edtCSUploadedBy" id="edtCSUploadedBy" type="text" value="" readOnly>	
     				</div>
     				
     				<!-- Last Uploaded -->
     				<div class="col-sm-6">
     					<label for="lastUploadedBy">Last Uploaded:</label>
     					<input class="form-control" name="edtCSLastUploadedBy" id="edtCSLastUploadedBy" type="text" value="" readOnly>    
     				</div>			
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<input class="form-control" name="edtCSRecordID" id="edtCSRecordID" type="hidden" value="">
        			<input class="form-control" name="edtCSBuildingID" id="edtCSBuildingID" type="hidden" value="">
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
<div class="modal fade" id="deleteConsent" role="dialog">
  <div class="modal-dialog" style="width: 50%">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h4 class="modal-title" align="left"><b>Building Consent - Delete Record</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to delete record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=dltConsent" method="post">
         <div class="modal-body bgColorWhite">
         	<p> Are you sure you wish to delete one record? </p>
         </div>
         <input class="form-control" name="dltCSRecordID" id="dltCSRecordID" type="hidden" value="">
         <input class="form-control" name="dltCSBuildingID" id="dltCSBuildingID" type="hidden" value="">
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

