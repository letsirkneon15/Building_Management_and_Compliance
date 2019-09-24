
<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body">
		<div class="table-responsive">
			<table id="wofTable" class="table table-bordered table-hover table-striped table-condensed" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Name</th>
						<th>Titled Year</th>
						<th>Attachment</th>
						<th>Type</th>
						<th>Uploaded By</th>
						<th>Last Uploaded</th>
						<th>Actions</th>
						<th class="sorting_asc_disabled sorting_desc_disabled"></th>
           			  	<th class="sorting_asc_disabled sorting_desc_disabled"></th> 
           			  	<th class="sorting_asc_disabled sorting_desc_disabled"></th> 
					</tr>
				</thead>

				<!-- Start Rows -->
				<tbody>
					<c:forEach var="b" items="${buildingWOFArr}" varStatus="bIndex">
						<tr>
							<td>${b.name }</td>
							<td>${b.titledYear }</td>
							<td>${b.attachment }</td>
							<td>${b.type }</td>
							<td>${b.uploadedBy }</td>
							<td>${b.lastUploadedBy }</td>
							<td></td>
							<td><a href="#downloadCloud" data-toggle="modal"
								data-id="downloadLink${bIndex.index}"
								data-buildingid="${b.buildingID}"><img
									src='images/download_cloud.png' height=15 width=15></a></td>
							
							<td><a href="#editWof" data-toggle="modal"
								data-id="edtLink${bIndex.index}" data-recordid="${b.recordID}" data-buildingid="${b.buildingID}"
								data-name="${b.name}" data-titledyear="${b.titledYear}" data-attachment="${b.attachment}"
								data-type="${b.type}" data-uploadedby="${b.uploadedBy}" data-lastuploadedby="${b.lastUploadedBy}">
								<img src='images/edit.jpg' height=15 width=15></a></td>
														
							<td><a href="#deleteWof" data-toggle="modal"
								data-id="dltLink${bIndex.index}" data-recordid="${b.recordID}" data-buildingid="${b.buildingID}">
								<img src='images/delete.jpg' height=15 width=15></a></td>
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
<div class="modal fade" id="editWof" role="dialog">
  <div class="modal-dialog" style="width: 100%">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h4 class="modal-title" align="left"><b>Building WOF - Update Record</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to edit record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=editWof" method="post">
         <div class="modal-body bgColorWhite">
         	<div class="table-responsive" style="width:100%">
         	 <div class="well">
     				
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Name  -->
     				<div class="col-sm-6">
     					<label for="name">Name:</label>
     					<input class="form-control" name = "edtWName" id="edtWName" type="text" value="">
     				</div>
     				
     				<!-- Titled Year  -->
     				<div class="col-sm-6">
 						<label for="titledYear">Titled Year:</label>
     					<input class="form-control" name = "edtWTitledYear" id="edtWTitledYear" type="text" value="">
    				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Attachment -->
     				<div class="col-sm-6">
     					<label for="attachment">Attachment:</label>
     					<input class="form-control" name="edtWAttachment" id="edtWAttachment" type="text" value=""> 	
     				</div>
     	
     				<!-- Type  -->
     				<div class="col-sm-6">
     					<label for="type">Type:</label>
     					<input class="form-control" name="edtWType" id="edtWType" type="text" value="">	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
 					<!-- Uploaded By  -->
 					<div class="col-sm-6">
 						<label for="uploadedBy">Uploaded By:</label>
     					<input class="form-control" name="edtWUploadedBy" id="edtWUploadedBy" type="text" value="" readOnly>	
     				</div>
     				
     				<!-- Last Uploaded -->
     				<div class="col-sm-6">
     					<label for="lastUploadedBy">Last Uploaded:</label>
     					<input class="form-control" name="edtWLastUploadedBy" id="edtWLastUploadedBy" type="text" value="" readOnly>    
     				</div>			
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<input class="form-control" name="edtWRecordID" id="edtWRecordID" type="hidden" value="">
        			<input class="form-control" name="edtWBuildingID" id="edtWBuildingID" type="hidden" value="">
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
<div class="modal fade" id="deleteWof" role="dialog">
  <div class="modal-dialog" style="width: 50%">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h4 class="modal-title" align="left"><b>Building WOF - Delete Record</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to delete record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=dltWof" method="post">
         <div class="modal-body bgColorWhite">
         	<p> Are you sure you wish to delete one record? </p>
         </div>
         <input class="form-control" name="dltWRecordID" id="dltWRecordID" type="hidden" value="">
         <input class="form-control" name="dltWBuildingID" id="dltWBuildingID" type="hidden" value="">
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

