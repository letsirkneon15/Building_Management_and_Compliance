<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- DataTables -->
<div class="card shadow mb-4">
	
	<div class="card-body">
	<button type="button" class="btn btn-primary"
			data-toggle="modal" data-target="#crtSeismicResilience">
			<h5>
				<span class="glyphicon glyphicon-plus-sign"></span><b> Add
					Seismic Resilience</b>
			</h5>
		</button>
		<br> <br>
		<div class="table-responsive">
			<table class="table table-bordered table-hover table-striped table-condensed" id="dataTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Name</th>
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
					<c:forEach var="b" items="${seismicArr}" varStatus="bIndex">
						<tr>
							<td>${b.name }</td>
							<td>${b.attachment }</td>
							<td>${b.type }</td>
							<td>${b.uploadedBy }</td>
							<td>${b.lastUploadedBy }</td>
							<td></td>
							
							<td><a href="#downloadCloud" data-toggle="modal"
								data-id="downloadLink${bIndex.index}"
								data-buildingid="${b.buildingID}"><img
									src='images/download_cloud.png' height=15 width=15></a></td>
							
							<td><a href="#editSeismicResilience" data-toggle="modal"
								data-id="edtLink${bIndex.index}" data-recordid="${b.recordID}" data-buildingid="${b.buildingID}"
								data-name="${b.name}" data-attachment="${b.attachment}" data-type="${b.type}" data-uploadedby="${b.uploadedBy}" 
								data-lastuploadedby="${b.lastUploadedBy}">
								<img src='images/edit.jpg' height=15 width=15></a></td>
							
							<td><a href="#deleteSeismicResilience" data-toggle="modal"
								data-id="dltLink${bIndex.index}" data-recordid="${b.recordID}"
								data-buildingid="${b.buildingID}">
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


<!--START- Create Record (MODAL)-->
<div class="modal fade" id="crtSeismicResilience" role="dialog">
  <div class="modal-dialog" style="width: 100%">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h4 class="modal-title" align="left"><b>Seismic Resilience - Create New Record</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to create record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=crtSeismicResilience" method="post">
         <div class="modal-body bgColorWhite">
         	<div class="table-responsive" style="width:100%">
         	 <div class="well">
     				
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Name  -->
     				<div class="col-sm-6">
     					<label for="name">Name:</label>
     					<input class="form-control" name = "crtSRName" id="crtSRName" type="text" value="${crtSRName}">
     				</div>
     				<!-- Attachment -->
     				<div class="col-sm-6">
     					<label for="attachment">Attachment:</label>
     					<input class="form-control" name="crtSRAttachment" id="crtSRAttachment" type="text" value="${crtSRAttachment}"> 	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Type  -->
     				<div class="col-sm-6">
     					<label for="type">Type:</label>
     					<input class="form-control" name="crtSRType" id="crtSRType" type="text" value="${crtSRType}">	
     				</div>
     				<!-- Uploaded By  -->
 					<div class="col-sm-6">
 						<label for="uploadedBy">Uploaded By:</label>
     					<input class="form-control" name="crtSRUploadedBy" id="crtSRUploadedBy" type="text" value="${crtSRUploadedBy}" readOnly>	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Last Uploaded -->
     				<div class="col-sm-6">
     					<label for="lastUploadedBy">Last Uploaded:</label>
     					<input class="form-control" name="crtSRLastUploadedBy" id="crtSRLastUploadedBy" type="text" value="${crtSRLastUploadedBy}" readOnly>    
     				</div>			
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<input class="form-control" name="crtSRRecordID" id="crtSRRecordID" type="hidden" value="${crtSRRecordID}">
        			<input class="form-control" name="crtSRBuildingID" id="crtSRBuildingID" type="hidden" value="${crtSRBuildingID}">
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
<div class="modal fade" id="editSeismicResilience" role="dialog">
  <div class="modal-dialog" style="width: 100%">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h4 class="modal-title" align="left"><b>Seismic Resilience - Update Record</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to edit record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=editSeismicResilience" method="post">
         <div class="modal-body bgColorWhite">
         	<div class="table-responsive" style="width:100%">
         	 <div class="well">
     				
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Name  -->
     				<div class="col-sm-6">
     					<label for="name">Name:</label>
     					<input class="form-control" name = "edtSRName" id="edtSRName" type="text" value="">
     				</div>
     				<!-- Attachment -->
     				<div class="col-sm-6">
     					<label for="attachment">Attachment:</label>
     					<input class="form-control" name="edtSRAttachment" id="edtSRAttachment" type="text" value=""> 	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Type  -->
     				<div class="col-sm-6">
     					<label for="type">Type:</label>
     					<input class="form-control" name="edtSRType" id="edtSRType" type="text" value="">	
     				</div>
     				<!-- Uploaded By  -->
 					<div class="col-sm-6">
 						<label for="uploadedBy">Uploaded By:</label>
     					<input class="form-control" name="edtSRUploadedBy" id="edtSRUploadedBy" type="text" value="" readOnly>	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Last Uploaded -->
     				<div class="col-sm-6">
     					<label for="lastUploadedBy">Last Uploaded:</label>
     					<input class="form-control" name="edtSRLastUploadedBy" id="edtSRLastUploadedBy" type="text" value="" readOnly>    
     				</div>			
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<input class="form-control" name="edtSRRecordID" id="edtSRRecordID" type="hidden" value="">
        			<input class="form-control" name="edtSRBuildingID" id="edtSRBuildingID" type="hidden" value="">
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
<div class="modal fade" id="deleteSeismicResilience" role="dialog">
  <div class="modal-dialog" style="width: 50%">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h4 class="modal-title" align="left"><b>Seismic Resilience - Delete Record</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to delete record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=dltSeismicResilience" method="post">
         <div class="modal-body bgColorWhite">
         	<p> Are you sure you wish to delete one record? </p>
         </div>
         <input class="form-control" name="dltSRRecordID" id="dltSRRecordID" type="hidden" value="">
         <input class="form-control" name="dltSRBuildingID" id="dltSRBuildingID" type="hidden" value="">
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

