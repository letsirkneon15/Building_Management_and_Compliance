
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered table-hover table-striped table-condensed" id="hazardRegisterTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Identified Hazard</th>
						<th>Risk Assessment</th>
						<th>Controls</th>
						<th>Level of Controls</th>
						<th>Residual Risk Assessment</th>
						<th class="sorting_asc_disabled sorting_desc_disabled"></th>
           			  	<th class="sorting_asc_disabled sorting_desc_disabled"></th> 
           			  	<th class="sorting_asc_disabled sorting_desc_disabled"></th> 
					</tr>
				</thead>

				<!-- Start Rows -->
				<tbody>
					<d:forEach var="b" items="${hazRegisterArr}" varStatus="bIndex">
						<tr>
							<td>${b.identifiedHazard }</td>
							<td>${b.initialRiskAssessment }</td>
							<td>${b.controls }</td>
							<td>${b.levelOfControl }</td>
							<td>${b.residualRiskAssessment }</td>	
											
							<td><a href="#downloadCloud" data-toggle="modal"
								data-id="downloadLink${bIndex.index}"
								data-buildingID="${b.buildingID}"><img
									src='images/download_cloud.png' height=15 width=15></a></td>
							
							<td><a href="#editHazardRegister" data-toggle="modal"
								data-id="edtLink${bIndex.index}" data-recordID="${b.recordID}" data-buildingID="${b.buildingID}" 
								data-identifiedHazard="${b.identifiedHazard}" data-initialRiskAssessment="${b.initialRiskAssessment}" 
								data-controls="${b.controls}" data-ulevelOfControl="${b.levelOfControl}" 
								data-residualRiskAssessment="${b.residualRiskAssessment}">
								<img src='images/edit.jpg' height=15 width=15></a></td>
							
							<td><a href="#deleteRecords" data-toggle="modal"
								data-id="dltLink${bIndex.index}" data-recordID="${b.recordID}"
								data-buildingID="${b.buildingID}">
								<img src='images/delete.jpg' height=15 width=15></a></td>	
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
<div class="modal fade" id="editHazardRegister" role="dialog">
  <div class="modal-dialog" style="width: 100%">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h4 class="modal-title" align="left"><b>Hazard Register - Update Record</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to edit record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=editHazardRegister" method="post">
         <div class="modal-body bgColorWhite">
         	<div class="table-responsive" style="width:100%">
         	 <div class="well">
     				
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Identified Hazard  -->
     				<div class="col-sm-6">
     					<label for="identifiedHazard">Identified Hazard:</label>
     					<input class="form-control" name = "edtHRIdentifiedHazard" id="edtHRIdentifiedHazard" type="text" value="">
     				</div>
     				<!-- Initial Risk Assessment -->
     				<div class="col-sm-6">
     					<label for="initialRiskAssessment">Initial Risk Assessment:</label>
     					<input class="form-control" name="edtHRInitialRiskAssessment" id="edtHRInitialRiskAssessment" type="text" value=""> 	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Controls  -->
     				<div class="col-sm-6">
     					<label for="controls">Controls:</label>
     					<input class="form-control" name="edtHRControls" id="edtHRControls" type="text" value="">	
     				</div>
     				<!-- Level of Control  -->
 					<div class="col-sm-6">
 						<label for="levelOfControl">Level of Control:</label>
     					<input class="form-control" name="edtHRLevelOfControly" id="edtHRLevelOfControl" type="text" value="" readOnly>	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Residual Risk Assessment -->
     				<div class="col-sm-6">
     					<label for="residualRiskAssessment">Residual Risk Assessment:</label>
     					<input class="form-control" name="edtHRResidualRiskAssessment" id="edtHRResidualRiskAssessment" type="text" value="" readOnly>    
     				</div>			
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<input class="form-control" name="edtHRRecordID" id="edtGRecordID" type="hidden" value="">
        			<input class="form-control" name="edtHRBuildingID" id="edtGBuildingID" type="hidden" value="">
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
<div class="modal fade" id="deleteRecords" role="dialog">
  <div class="modal-dialog" style="width: 50%">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h4 class="modal-title" align="left"><b>Hazard Register - Delete Record</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to edit record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=dltHazardRegister" method="post">
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

