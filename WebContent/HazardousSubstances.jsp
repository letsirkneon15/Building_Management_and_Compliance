
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body">
		<div class="table-responsive">
			<table class="table table-bordered table-hover table-striped table-condensed" id="hazardousSubstancesTable" width="100%"
				cellspacing="0">
				<thead>
					<tr>
						<th>Product Name</th>
						<th>UN Number</th>
						<th>Approval Number</th>
						<th>Group Standard Name</th>
						<th>Hazard Classification</th>
						<th>SDS</th>
						<th>Storage and Segregation Requirements</th>
						<th>Container Size</th>
						<th>Open or Close Container</th>
						<th>Gas, Liquid or Solid</th>
						<th>Location</th>
						<th>Maximum Likely Amount</th>
						<th class="sorting_asc_disabled sorting_desc_disabled"></th>
           			  	<th class="sorting_asc_disabled sorting_desc_disabled"></th> 
           			  	<th class="sorting_asc_disabled sorting_desc_disabled"></th> 
					</tr>
				</thead>

				<!-- Start Rows -->
				<tbody>
					<d:forEach var="b" items="${hazSubstancesArr}" varStatus="bIndex">
						<tr>
							<td>${b.productName }</td>
							<td>${b.unNumber }</td>
							<td>${b.approvalNumber }</td>
							<td>${b.groupStandard }</td>
							<td>${b.hazardClassification }</td>
							<td>${b.currentSDSAvailable }</td>
							<td>${b.specificStorage} / ${b.segregationRequirements}</td>
							<td>${b.containerSize }</td>
							<td>${b.openCloseContainerNumber }</td>
							<td>${b.gasLiquidSolid }</td>				
							<td>${b.location }</td>		
							<td>${b.maximumLikelyAmount }</td>	
															
							<td><a href="#downloadCloud" data-toggle="modal"
								data-id="downloadLink${bIndex.index}"
								data-buildingID="${b.buildingID}"><img
									src='images/download_cloud.png' height=15 width=15></a></td>
							
							<td><a href="#editHazardSubstance" data-toggle="modal"
								data-id="edtLink${bIndex.index}" data-recordID="${b.recordID}" data-buildingID="${b.buildingID}" 
								data-productName="${b.productName}" data-unNumber="${b.unNumber}" data-approvalNumber="${b.approvalNumber}" data-groupStandard="${b.groupStandard}" 
								data-hazardClassification="${b.hazardClassification}" data-currentSDSAvailable="${b.currentSDSAvailable}" 
								data-specificStorage="${b.specificStorage}" data-segregationRequirements="${b.segregationRequirements}" 
								data-containerSize="${b.containerSize}" data-openCloseContainerNumber="${b.openCloseContainerNumber}" 
								data-gasLiquidSolid="${b.gasLiquidSolid}" data-location="${b.location}" 
								data-maximumLikelyAmount="${b.maximumLikelyAmount}">
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
<div class="modal fade" id="editHazardSubstance" role="dialog">
  <div class="modal-dialog" style="width: 100%">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h4 class="modal-title" align="left"><b>Hazardous Substances - Update Record</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to edit record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=editHazardSubstance" method="post">
         <div class="modal-body bgColorWhite">
         	<div class="table-responsive" style="width:100%">
         	 <div class="well">
     				
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Product Name  -->
     				<div class="col-sm-4">
     					<label for="productName">Product Name:</label>
     					<input class="form-control" name = "edtHSProductName" id="edtHSProductName" type="text" value="">
     				</div>
     				<!-- UN Number -->
     				<div class="col-sm-4">
     					<label for="unNumber">UN Number:</label>
     					<input class="form-control" name="edtHSUnNumber" id="edtHSUnNumber" type="text" value=""> 	
     				</div>
     				<!-- Approval Number -->
     				<div class="col-sm-4">
     					<label for="approvalNumber">Approval Number:</label>
     					<input class="form-control" name="edtHSApprovalNumber" id="edtHSApprovalNumber" type="text" value=""> 	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Group Standard Name  -->
     				<div class="col-sm-4">
     					<label for="groupStandard">Group Standard Name:</label>
     					<input class="form-control" name="edtHSGroupStandard" id="edtHSGroupStandard" type="text" value="">	
     				</div>
     				<!-- Hazard Classification  -->
 					<div class="col-sm-4">
 						<label for="hazardClassification">Hazard Classification:</label>
     					<input class="form-control" name="edtHSHazardClassification" id="edtHSHazardClassification" type="text" value="">	
     				</div>
     				<!-- Current SDS Available  -->
 					<div class="col-sm-4">
 						<label for="currentSDSAvailable">Current SDS Available:</label>
     					<input class="form-control" name="edtHSCurrentSDSAvailable" id="edtHSCurrentSDSAvailable" type="text" value="">	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Specific Storage  -->
     				<div class="col-sm-4">
     					<label for="specificStorage">Specific Storage:</label>
     					<input class="form-control" name="edtHSSpecificStorage" id="edtHSSpecificStorage" type="text" value="">	
     				</div>
     				<!-- Segregation Requirements  -->
 					<div class="col-sm-4">
 						<label for="segregationRequirements">Segregation Requirements:</label>
     					<input class="form-control" name="edtHSSegregationRequirements" id="edtHSSegregationRequirements" type="text" value="">	
     				</div>
     				<!-- Container Size  -->
 					<div class="col-sm-4">
 						<label for="containerSize">Container Size:</label>
     					<input class="form-control" name="edtHSContainerSize" id="edtHSContainerSize" type="text" value="">	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Open or Close Container  -->
     				<div class="col-sm-4">
     					<label for="openCloseContainer">Open or Close Container:</label>
     					<input class="form-control" name="edtHSOpenCloseContainer" id="edtHSOpenCloseContainer" type="text" value="">	
     				</div>
     				<!-- Gas, Liquid or Solid  -->
 					<div class="col-sm-4">
 						<label for="gasLiquidSolid">Gas, Liquid or Solid:</label>
     					<input class="form-control" name="edtHSGasLiquidSolid" id="edtHSGasLiquidSolid" type="text" value="">	
     				</div>
     				<!-- Location  -->
 					<div class="col-sm-4">
 						<label for="location">Location:</label>
     					<input class="form-control" name="edtHSLocation" id="edtHSLocation" type="text" value="">	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Maximum Likely Amount  -->
     				<div class="col-sm-4">
     					<label for="maximumLikelyAmount">Maximum Likely Amount:</label>
     					<input class="form-control" name="edtHSMaximumLikelyAmount" id="edtHSMaximumLikelyAmount" type="text" value="">	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<input class="form-control" name="edtHSRecordID" id="edtHSRecordID" type="hidden" value="">
        			<input class="form-control" name="edtHSBuildingID" id="edtHSBuildingID" type="hidden" value="">
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
          <h4 class="modal-title" align="left"><b>Hazardous Substances - Delete Record</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to edit record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=dltHazardSubstance" method="post">
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



