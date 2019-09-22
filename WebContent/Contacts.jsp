
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered table-hover table-striped table-condensed" id="contactsTable" width="100%" cellspacing="0">
				<thead>
					<tr>
						<th>Name</th>
						<th>Type</th>
						<th>Company</th>
						<th>Phone</th>
						<th>Fax</th>
						<th>Mobile</th>
						<th>Email Address</th>
						<th class="sorting_asc_disabled sorting_desc_disabled"></th>
           			  	<th class="sorting_asc_disabled sorting_desc_disabled"></th> 
           			  	<th class="sorting_asc_disabled sorting_desc_disabled"></th> 
					</tr>
				</thead>

				<!-- Start Rows -->
				<tbody>
					<d:forEach var="b" items="${contactsArr}" varStatus="bIndex">
						<tr>
							<td>${b.name }</td>
							<td>${b.type }</td>
							<td>${b.company }</td>
							<td>${b.phoneNumber }</td>
							<td>${b.faxNumber }</td>
							<td>${b.mobileNumber }</td>
							<td>${b.emailAdd }</td>
							
							<td><a href="#downloadCloud" data-toggle="modal"
								data-id="downloadLink${bIndex.index}"
								data-buildingID="${b.buildingID}"><img
									src='images/download_cloud.png' height=15 width=15></a></td>
									
							<td><a href="#editContacts" data-toggle="modal"
								data-id="edtLink${bIndex.index}"
								data-buildingID="${b.buildingID}" data-recodID="${b.recordID}" data-name="${b.name}"
								data-type="${b.type}" data-company="${b.company}" data-phoneNumber="${b.phoneNumber}"
								data-faxNumber="${b.faxNumber}" data-mobileNumber="${b.mobileNumber}" 
								data-emailAdd="${b.emailAdd}"> <img src='images/edit.jpg'	height=15 width=15></a></td>

							<td><a href="#deleteContacts" data-toggle="modal"
								data-id="dltLink${bIndex.index}"
								data-recordID="${b.recordID}" data-buildingID="${b.buildingID}"><img
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
     					<input class="form-control" name = "edtName" id="edtName" type="text" value="">
     				</div>
     				
     				<!-- Type  -->
     				<div class="col-sm-6">
 						<label for="type">Type:</label>
     					<input class="form-control" name = "edtType" id="edtType" type="text" value="">
    				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Company -->
     				<div class="col-sm-6">
     					<label for="company">Company:</label>
     					<input class="form-control" name="edtCompany" id="edtCompany" type="text" value="">  	
     				</div>
     	
     				<!-- Phone Number  -->
     				<div class="col-sm-6">
     					<label for="phoneNumber">Phone Number:</label>
     					<input class="form-control" name="edtPhoneNumber" id="edtPhoneNumber" type="text" value="">	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
 					<!-- Fax Number  -->
 					<div class="col-sm-6">
 						<label for="faxNumber">Fax Number:</label>
     					<input class="form-control" name="edtFaxNumber" id="edtFaxNumber" type="text" value="">	
     				</div>
     				
     				<!-- Mobile Number -->
     				<div class="col-sm-6">
     					<label for="mobileNumber">Mobile Number:</label>
     					<input class="form-control" name="edtMobileNumber" id="edtMobileNumber" type="text" value="">    
     				</div>			
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Email Address  -->
     				<div class="col-sm-6">
     					<label for="emailAdd">Email Address:</label>
     					<input class="form-control" name="edtEmailAdd" id="edtEmailAdd" type="text" value="">
     				</div>	
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
	
		<!-- Create a Form to edit record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=dltContacts" method="post">
         <div class="modal-body bgColorWhite">
         	<p> Are you sure you wish to delete one record? </p>
         </div>
         <input class="form-control" name="dltRecordID" id="dltRecordID" type="hidden" value="">
         <input class="form-control" name="dltBuildingID" id="dltBuildingID" type="hidden" value="">
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
