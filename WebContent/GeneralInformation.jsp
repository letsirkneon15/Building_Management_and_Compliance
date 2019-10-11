
<!-- Horizontal Form -->
<div class="row">
	<div class="col-xs-12">
		<form action="${pageContext.request.contextPath}/Tabs?action=editTabs&tab=GenInfo" method="post" 
			class="form-horizontal">
			<div class="form-group">
				<label for="buildingName" class="col-xs-2">Name of Building</label>
				<div class="col-xs-7">
					<input type="text" class="form-control" id="buildingName" name="buildingName"
						value="${bHeader.buildingName}" />
				</div>
			</div>

			<div class="form-group">
				<label for="address" class="col-xs-2">Address</label>
				<div class="col-xs-7">
					<input type="text" class="form-control" id="address" name="address"
						value="${bHeader.address}" />
				</div>
				<c:if test="${not empty genInfoTab.tabUpd}">
				<div class="col-xs-3">
					<button type="submit" class="btn btn-primary" name="button" value="updateBuilding"><h5><span class="glyphicon glyphicon-edit"></span><b> Update Building</b></h5></button>
				</div>
				</c:if>
			</div>

			<div class="form-group">
				<label for="responsibleOffice" class="col-xs-2">Responsible
					Office</label>
				<div class="col-xs-7">
					<input type="text" class="form-control" id="responsibleOffice" name="responsibleOffice"
						value="${bHeader.responsibleOffice}" />
				</div>
				<c:if test="${not empty genInfoTab.tabDlt}">
				<div class="col-xs-3">
					<button type="button" class="btn btn-primary" name="button" value="deleteBuilding"
					 data-toggle="modal" data-target="#deleteGenInfo" data-id="dltLink${bHIndex.index}"
					 data-buildingid="${bHeader.buildingID}"><h5><span class="glyphicon glyphicon-trash"></span><b> Delete Building &nbsp;</b></h5></button>
				</div>		
				</c:if>		
			</div>

			<div class="form-group">
				<label for="client" class="col-xs-2">Client</label>
				<div class="col-xs-7">
					<input type="text" class="form-control" id="client" name="client"
						value="${bHeader.client}" />
				</div>
			</div>

			<div class="form-group">
				<label for="projectNumber" class="col-xs-2">Project Number</label>
				<div class="col-xs-7">
					<input type="text" class="form-control" id="projectNumber" name="projectNumber"
						value="${bHeader.projectNumber}" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="buildingInformation" class="col-xs-2">Building Information</label>
				<div class="col-xs-7">
					<input type="text" class="form-control" id="buildingInformation" name="buildingInformation"
						value="${bHeader.buildingInformation}" />
				</div>
			</div>

			<div class="form-group">
				<label for="csNumber" class="col-xs-2">CS Number</label>
				<div class="col-xs-7">
					<input type="text" class="form-control" id="csNumber" name="csNumber"
						value="${bHeader.csNumber}" />
				</div>
			</div>
			
			<div class="form-group">
				<label for="legalDescription" class="col-xs-2">Legal Description</label>
				<div class="col-xs-7">
					<input type="text" class="form-control" id="legalDescription" name="legalDescription"
						value="${bHeader.legalDescription}" />
				</div>
			</div>		
			
			<div class="form-group">
				<label for="maxOccupants" class="col-xs-2">Max Occupants</label>
				<div class="col-xs-7">
					<input type="text" class="form-control" id="maxOccupants" name="maxOccupants"
						value="${bHeader.maxOccupants}" />
				</div>
			</div>		
			
			<div class="form-group">
				<label for="fireHazardCategory" class="col-xs-2">Fire Hazard Category</label>
				<div class="col-xs-7">
					<select class="form-control" id="fireHazardCategory"
											name="fireHazardCategory"  data-selected="${bHeader.fireHazardCategory}">
						<c:forEach var="fireHazCat" items="${fireHazCatList}">
							<option value="${fireHazCat}">${fireHazCat}</option>
						</c:forEach>
					</select>
				</div>
			</div>		
			
			<div class="form-group">
				<label for="yearBuilt" class="col-xs-2">Year Built</label>
				<div class="col-xs-7">
					<input type="text" class="form-control" id="yearBuilt" name="yearBuilt"
						value="${bHeader.yearBuilt}" />
				</div>
			</div>		
			
			<div class="form-group">
				<label for="intendedLife" class="col-xs-2">Intended Life</label>
				<div class="col-xs-7">
					<input type="text" class="form-control" id="intendedLife" name="intendedLife"
						value="${bHeader.intendedLife}" />
				</div>
			</div>								
			
			<div class="form-group">
				<label for="bwofAnniversary" class="col-xs-2">BWOF Anniversary</label>
				<div class="col-xs-7">
					<input type="text" class="form-control" id="bwofAnniversary" name="bwofAnniversary"
						value="${bHeader.bwofAnniversary}" />
				</div>
			</div>		
			
			<div class="form-group">
				<label for="asbestosPresent" class="col-xs-2">Asbestos Present</label>
				<div class="col-xs-7">
					<select class="form-control" id="asbestosPresent"
											name="asbestosPresent"  data-selected="${bHeader.asbestosPresent}">
						<c:forEach var="yesNo" items="${yesNoList}">
							<option value="${yesNo}">${yesNo}</option>
						</c:forEach>
					</select>
				</div>
			</div>		
			
			<div class="form-group">
				<label for="nbsPercent" class="col-xs-2">NBS %</label>
				<div class="col-xs-7">
					<input type="text" class="form-control" id="nbsPercent" name="nbsPercent"
						value="${bHeader.nbsPercentage}" />
				</div>
				<input type="hidden" class="form-control" id="buildingID"
						name="buildingID" value="${bHeader.buildingID}"/>
			</div>				
						
		</form>
	</div>
</div>

<!--START- Delete (MODAL)-->
<div class="modal fade" id="deleteGenInfo" role="dialog">
	<div class="modal-dialog" style="width: 50%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>General Information - Delete Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to delete record -->
			<form
				action="${pageContext.request.contextPath}/Tabs?action=dltTabs&tab=GenInfo"
				method="post">
				<div class="modal-body bgColorWhite">
					<p>Are you sure you wish to delete one record?</p>
				</div>
			    <input class="form-control"
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