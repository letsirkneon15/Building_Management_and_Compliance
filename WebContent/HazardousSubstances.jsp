
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body" >
	<c:if test="${not empty hazSubsTab.tabCrt}">
		<div align="right">
	<button type="button" class="btn btn-primary"
			data-toggle="modal" data-target="#crtHazardSubstance" data-id="crtLink${bIndex.index}" data-buildingid="${buildingID}">
			<h5>
				<span class="glyphicon glyphicon-plus-sign"></span><b> Add
					Hazard Substance</b>
			</h5>
		</button>
		<br> <br></div>
	</c:if>
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
						<c:if test="${not empty hazSubsTab.tabUpd}">
							<th class="sorting_asc_disabled sorting_desc_disabled"></th>
						</c:if>
						<c:if test="${not empty hazSubsTab.tabDlt}">
           			  		<th class="sorting_asc_disabled sorting_desc_disabled"></th> 
           			  	</c:if>
					</tr>
				</thead>

				<!-- Start Rows -->
				<tbody>
					<d:forEach var="b" items="${hazSubstancesArr}" varStatus="bIndex">
						<tr align="center">
							<td>${b.productName }</td>
							<td>${b.unNumber }</td>
							<td>${b.approvalNumber }</td>
							<td>${b.groupStandard }</td>
							<td>${b.hazardClassification }</td>
							<td>${b.currentSDSAvailable }</td>
							<td>${b.specificStorage} / ${b.segregationRequirements}</td>
							<td>${b.containerSize }</td>
							<td>${b.openCloseContainer }</td>
							<td>${b.gasLiquidSolid }</td>				
							<td>${b.location }</td>		
							<td>${b.maximumLikelyAmount }</td>	
															
							<c:if test="${not empty hazSubsTab.tabUpd}">
							<td align="center"><a href="#editHazardSubstance" data-toggle="modal"
								data-id="edtLink${bIndex.index}" data-recordid="${b.recordID}" data-buildingid="${b.buildingID}" 
								data-productname="${b.productName}" data-unnumber="${b.unNumber}" data-approvalnumber="${b.approvalNumber}" data-groupstandard="${b.groupStandard}" 
								data-hazardclassification="${b.hazardClassification}" data-currentsdsavailable="${b.currentSDSAvailable}" 
								data-specificstorage="${b.specificStorage}" data-segregationrequirements="${b.segregationRequirements}" 
								data-containersize="${b.containerSize}" data-openclosecontainer="${b.openCloseContainer}" 
								data-gasliquidsolid="${b.gasLiquidSolid}" data-location="${b.location}" 
								data-maximumlikelyamount="${b.maximumLikelyAmount}">
								<img src='images/edit.jpg' height=15 width=15></a></td>
							</c:if>
							
							<c:if test="${not empty hazSubsTab.tabDlt}">
							<td align="center"><a href="#deleteHazardSubstance" data-toggle="modal"
								data-id="dltLink${bIndex.index}" data-recordid="${b.recordID}"
								data-buildingid="${b.buildingID}">
								<img src='images/delete.jpg' height=15 width=15></a></td>	
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
<div class="modal fade bd-example-modal-lg" id="crtHazardSubstance" role="dialog">
  <div class="modal-dialog modal-lg" style="width: 100%">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h4 class="modal-title" align="left"><b>Hazardous Substances - Create New Record</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to create record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=crtTabs&tab=HazSubs" method="post">
         <div class="modal-body bgColorWhite">
         	<div class="table-responsive" style="width:100%">
         	 <div class="well">
     				
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Product Name  -->
     				<div class="col-sm-4">
     					<label for="productName">Product Name:</label>
     					<input class="form-control" name = "crtHSProductName" id="crtHSProductName" type="text" value="${crtHSProductName}">
     				</div>
     				<!-- UN Number -->
     				<div class="col-sm-4">
     					<label for="unNumber">UN Number:</label>
     					<input class="form-control" name="crtHSUnNumber" id="crtHSUnNumber" type="text" value="${crtHSUnNumber}"> 	
     				</div>
     				<!-- Approval Number -->
     				<div class="col-sm-4">
     					<label for="approvalNumber">Approval Number:</label>
     					<input class="form-control" name="crtHSApprovalNumber" id="crtHSApprovalNumber" type="text" value="${crtHSApprovalNumber}"> 	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Group Standard Name  -->
     				<div class="col-sm-4">
     					<label for="groupStandard">Group Standard Name:</label>
     					<input class="form-control" name="crtHSGroupStandard" id="crtHSGroupStandard" type="text" value="${crtHSGroupStandard}">	
     				</div>
     				<!-- Hazard Classification  -->
 					<div class="col-sm-4">
 						<label for="hazardClassification">Hazard Classification:</label>
     					<input class="form-control" name="crtHSHazardClassification" id="crtHSHazardClassification" type="text" value="${crtHSHazardClassification}">	
     				</div>
     				<!-- Current SDS Available  -->
 					<div class="col-sm-4">
 						<label for="currentSDSAvailable">Current SDS Available:</label>
     					<input class="form-control" name="crtHSCurrentSDSAvailable" id="crtHSCurrentSDSAvailable" type="text" value="${crtHSCurrentSDSAvailable}">	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Specific Storage  -->
     				<div class="col-sm-4">
     					<label for="specificStorage">Specific Storage:</label>
     					<input class="form-control" name="crtHSSpecificStorage" id="crtHSSpecificStorage" type="text" value="${crtHSSpecificStorage}">	
     				</div>
     				<!-- Segregation Requirements  -->
 					<div class="col-sm-4">
 						<label for="segregationRequirements">Segregation Requirements:</label>
     					<input class="form-control" name="crtHSSegregationRequirements" id="crtHSSegregationRequirements" type="text" value="${crtHSSegregationRequirements}">	
     				</div>
     				<!-- Container Size  -->
 					<div class="col-sm-4">
 						<label for="containerSize">Container Size:</label>
     					<input class="form-control" name="crtHSContainerSize" id="crtHSContainerSize" type="text" value="${crtHSContainerSize}">	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Open or Close Container  -->
     				<div class="col-sm-4">
     					<label for="openCloseContainer">Open or Close Container:</label>
     					<input class="form-control" name="crtHSOpenCloseContainer" id="crtHSOpenCloseContainer" type="text" value="${crtHSOpenCloseContainer}">	
     				</div>
     				<!-- Gas, Liquid or Solid  -->
 					<div class="col-sm-4">
 						<label for="gasLiquidSolid">Gas, Liquid or Solid:</label>
     					<input class="form-control" name="crtHSGasLiquidSolid" id="crtHSGasLiquidSolid" type="text" value="${crtHSGasLiquidSolid}">	
     				</div>
     				<!-- Location  -->
 					<div class="col-sm-4">
 						<label for="location">Location:</label>
     					<input class="form-control" name="crtHSLocation" id="crtHSLocation" type="text" value="${crtHSLocation}">	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
     				<!-- Maximum Likely Amount  -->
     				<div class="col-sm-4">
     					<label for="maximumLikelyAmount">Maximum Likely Amount:</label>
     					<input class="form-control" name="crtHSMaximumLikelyAmount" id="crtHSMaximumLikelyAmount" type="text" value="${crtHSMaximumLikelyAmount}">	
     				</div>
     			</div>
     			</div>
     			
     			<div class="panel-default">
  				<div class="panel-body">
        			<input class="form-control" name="buildingID" id="buildingID" type="hidden" value="">
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
<div class="modal fade bd-example-modal-lg" id="editHazardSubstance" role="dialog">
  <div class="modal-dialog modal-lg" style="width: 100%">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h4 class="modal-title" align="left"><b>Hazardous Substances - Update Record</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to edit record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=editTabs&tab=HazSubs" method="post">
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
        			<input class="form-control" name="buildingID" id="buildingID" type="hidden" value="">
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
<div class="modal fade" id="deleteHazardSubstance" role="dialog">
  <div class="modal-dialog" style="width: 50%">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h4 class="modal-title" align="left"><b>Hazardous Substances - Delete Record</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to delete record -->
		<form action="${pageContext.request.contextPath}/Tabs?action=dltTabs&tab=HazSubs" method="post">
         <div class="modal-body bgColorWhite">
         	<p> Are you sure you wish to delete one record? </p>
         </div>
         <input class="form-control" name="dltHSRecordID" id="dltHSRecordID" type="hidden" value="">
         <input class="form-control" name="buildingID" id="buildingID" type="hidden" value="">
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



