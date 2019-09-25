
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body" align="right">
	<button type="button" class="btn btn-primary"
			data-toggle="modal" data-target="#crtAsbestos">
			<h5>
				<span class="glyphicon glyphicon-plus-sign"></span><b> Add
					Asbestos</b>
			</h5>
		</button>
		<br> <br>
		<div class="table-responsive">
			<table class="table table-bordered table-hover table-striped table-condensed" id="asbestosTable" width="100%"
				cellspacing="0">
				<thead>
					<tr align="center">
						<th>Name</th>
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
					<d:forEach var="b" items="${asbestosArr}" varStatus="bIndex">
						<tr>
							<td>${b.name }</td>
							<td>${b.attachment }</td>
							<td>${b.type }</td>
							<td>${b.uploadedBy }</td>
							<td>${b.lastUploadedBy }</td>
							
							<td align="center"><a href="#editAsbestos" data-toggle="modal"
								data-id="edtLink${bIndex.index}" data-recordid="${b.recordID}" data-buildingid="${b.buildingID}"
								data-name="${b.name}" data-attachment="${b.attachment}" data-type="${b.type}" data-uploadedby="${b.uploadedBy}" 
								data-lastuploadedby="${b.lastUploadedBy}">
								<img src='images/edit.jpg' height=15 width=15></a></td>
							
							<td align="center"><a href="#deleteAsbestos" data-toggle="modal"
								data-id="dltLink${bIndex.index}" data-recordid="${b.recordID}"
								data-buildingid="${b.buildingID}"><img
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

<!--START- Create Record (MODAL)-->
<div class="modal fade" id="crtAsbestos" role="dialog">
  <div class="modal-dialog" style="width: 100%">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h4 class="modal-title" align="left"><b>Asbestos - Create New Record</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to create record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=crtAsbestos" method="post">
         <div class="modal-body bgColorWhite">
         	<div class="table-responsive" style="width:100%">
         	 <div class="well">
     				
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Name  -->
     				<div class="col-sm-6">
     					<label for="name">Name:</label>
     					<input class="form-control" name = "crtAName" id="crtAName" type="text" value="${crtAName}">
     				</div>
     				<!-- Attachment -->
     				<div class="col-sm-6">
     					<label for="attachment">Attachment:</label>
     					<input class="form-control" name="crtAAttachment" id="crtAAttachment" type="text" value="${crtAAttachment}"> 	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Type  -->
     				<div class="col-sm-6">
     					<label for="type">Type:</label>
     					<input class="form-control" name="crtAType" id="crtAType" type="text" value="${crtAType}">	
     				</div>
     				<!-- Uploaded By  -->
 					<div class="col-sm-6">
 						<label for="uploadedBy">Uploaded By:</label>
     					<input class="form-control" name="crtAUploadedBy" id="crtAUploadedBy" type="text" value="${crtAUploadedBy}" readOnly>	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Last Uploaded -->
     				<div class="col-sm-6">
     					<label for="lastUploadedBy">Last Uploaded:</label>
     					<input class="form-control" name="crtALastUploadedBy" id="crtALastUploadedBy" type="text" value="${crtALastUploadedBy}" readOnly>    
     				</div>			
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<input class="form-control" name="crtARecordID" id="crtARecordID" type="hidden" value="${crtARecordID}">
        			<input class="form-control" name="crtABuildingID" id="crtABuildingID" type="hidden" value="${crtABuildingID}">
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
<div class="modal fade" id="editAsbestos" role="dialog">
  <div class="modal-dialog" style="width: 100%">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h4 class="modal-title" align="left"><b>Asbestos - Update Record</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to edit record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=editAsbestos" method="post">
         <div class="modal-body bgColorWhite">
         	<div class="table-responsive" style="width:100%">
         	 <div class="well">
     				
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Name  -->
     				<div class="col-sm-6">
     					<label for="name">Name:</label>
     					<input class="form-control" name = "edtAName" id="edtAName" type="text" value="">
     				</div>
     				<!-- Attachment -->
     				<div class="col-sm-6">
     					<label for="attachment">Attachment:</label>
     					<input class="form-control" name="edtAAttachment" id="edtAAttachment" type="text" value=""> 	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Type  -->
     				<div class="col-sm-6">
     					<label for="type">Type:</label>
     					<input class="form-control" name="edtAType" id="edtAType" type="text" value="">	
     				</div>
     				<!-- Uploaded By  -->
 					<div class="col-sm-6">
 						<label for="uploadedBy">Uploaded By:</label>
     					<input class="form-control" name="edtAUploadedBy" id="edtAUploadedBy" type="text" value="" readOnly>	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Last Uploaded -->
     				<div class="col-sm-6">
     					<label for="lastUploadedBy">Last Uploaded:</label>
     					<input class="form-control" name="edtALastUploadedBy" id="edtALastUploadedBy" type="text" value="" readOnly>    
     				</div>			
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<input class="form-control" name="edtARecordID" id="edtARecordID" type="hidden" value="">
        			<input class="form-control" name="edtABuildingID" id="edtABuildingID" type="hidden" value="">
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
<div class="modal fade" id="deleteAsbestos" role="dialog">
  <div class="modal-dialog" style="width: 50%">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h4 class="modal-title" align="left"><b>Asbestos - Delete Record</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to delete record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=dltAsbestos" method="post">
         <div class="modal-body bgColorWhite">
         	<p> Are you sure you wish to delete one record? </p>
         </div>
         <input class="form-control" name="dltARecordID" id="dltARecordID" type="hidden" value="">
         <input class="form-control" name="dltABuildingID" id="dltABuildingID" type="hidden" value="">
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

