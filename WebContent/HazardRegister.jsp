
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>


<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body">
		<c:if test="${not empty hazRegTab.tabCrt}">
		<div align="right">
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#crtHazardRegister" data-id="crtLink${bIndex.index}"
				data-buildingid="${buildingID}">
				<h5>
					<span class="glyphicon glyphicon-plus-sign"></span><b> Add
						Hazard Register</b>
				</h5>
			</button>
			<br> <br>
		</div>
		</c:if>
		<div class="table-responsive">
			<table
				class="table table-bordered table-hover table-striped table-condensed"
				id="hazardRegisterTable" width="100%" cellspacing="0">
				<thead>
					<tr align="center">
						<th>Identified Hazard</th>
						<th>Risk Assessment</th>
						<th>Controls</th>
						<th>Level of Controls</th>
						<th>Residual Risk Assessment</th>
						<c:if test="${not empty hazRegTab.tabUpd}">
							<th class="sorting_asc_disabled sorting_desc_disabled"></th>
						</c:if>
						<c:if test="${not empty hazRegTab.tabDlt}">
							<th class="sorting_asc_disabled sorting_desc_disabled"></th>
						</c:if>
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

							<c:if test="${not empty hazRegTab.tabUpd}">
							<td align="center"><a href="#editHazardRegister"
								data-toggle="modal" data-id="edtLink${bIndex.index}"
								data-recordid="${b.recordID}" data-buildingid="${b.buildingID}"
								data-identifiedhazard="${b.identifiedHazard}"
								data-initialriskassessment="${b.initialRiskAssessment}"
								data-controls="${b.controls}"
								data-levelofcontrol="${b.levelOfControl}"
								data-residualriskassessment="${b.residualRiskAssessment}"> <img
									src='images/edit.jpg' height=15 width=15></a></td>
							</c:if>

							<c:if test="${not empty hazRegTab.tabDlt}">
							<td align="center"><a href="#deleteHazardRegister"
								data-toggle="modal" data-id="dltLink${bIndex.index}"
								data-recordid="${b.recordID}" data-buildingid="${b.buildingID}">
									<img src='images/delete.jpg' height=15 width=15>
							</a></td>
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
<div class="modal fade" id="crtHazardRegister" role="dialog">
	<div class="modal-dialog" style="width: 100%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>Hazard Register - Create New Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to create record -->
			<form
				action="${pageContext.request.contextPath}/Tabs?action=crtTabs&tab=HazReg"
				method="post">
				<div class="modal-body bgColorWhite">
					<div class="table-responsive" style="width: 100%">
						<div class="well">

							<div class="panel-default">
								<div class="panel-body">
									<!-- Identified Hazard  -->
									<div class="col-sm-6">
										<label for="identifiedHazard">Identified Hazard:</label> <input
											class="form-control" name="crtHRIdentifiedHazard"
											id="crtHRIdentifiedHazard" type="text"
											value="${crtHRIdentifiedHazard}">
									</div>
									<!-- Initial Risk Assessment -->
									<div class="col-sm-6">
										<label for="initialRiskAssessment">Initial Risk
											Assessment:</label> <select class="form-control"
											id="crtHRInitialRiskAssessment"
											name="crtHRInitialRiskAssessment">
											<d:forEach var="hrRiskAssess" items="${hrRiskAssessList}">
												<option value="${hrRiskAssess}">${hrRiskAssess}</option>
											</d:forEach>
										</select>
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Controls  -->
									<div class="col-sm-6">
										<label for="controls">Controls:</label> <input
											class="form-control" name="crtHRControls" id="crtHRControls"
											type="text" value="${crtHRControls}">
									</div>
									<!-- Level of Control  -->
									<div class="col-sm-6">
										<label for="levelOfControl">Level of Control:</label> 
										<select class="form-control"
											id="crtHRLevelOfControl"
											name="crtHRLevelOfControl">
											<d:forEach var="levelOfControls" items="${levelOfControlsList}">
												<option value="${levelOfControls}">${levelOfControls}</option>
											</d:forEach>
										</select>
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Residual Risk Assessment -->
									<div class="col-sm-6">
										<label for="residualRiskAssessment">Residual Risk
											Assessment:</label> <select class="form-control"
											id="crtHRResidualRiskAssessment"
											name="crtHRResidualRiskAssessment">
											<d:forEach var="hrRiskAssess" items="${hrRiskAssessList}">
												<option value="${hrRiskAssess}">${hrRiskAssess}</option>
											</d:forEach>
										</select>
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
<div class="modal fade" id="editHazardRegister" role="dialog">
	<div class="modal-dialog" style="width: 100%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>Hazard Register - Update Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to edit record -->
			<form
				action="${pageContext.request.contextPath}/Tabs?action=editTabs&tab=HazReg"
				method="post">
				<div class="modal-body bgColorWhite">
					<div class="table-responsive" style="width: 100%">
						<div class="well">

							<div class="panel-default">
								<div class="panel-body">
									<!-- Identified Hazard  -->
									<div class="col-sm-6">
										<label for="identifiedHazard">Identified Hazard:</label> <input
											class="form-control" name="edtHRIdentifiedHazard"
											id="edtHRIdentifiedHazard" type="text" value="">
									</div>
									<!-- Initial Risk Assessment -->
									<div class="col-sm-6">
										<label for="initialRiskAssessment">Initial Risk
											Assessment:</label> <select class="form-control"
											id="edtHRInitialRiskAssessment"
											name="edtHRInitialRiskAssessment">
											<d:forEach var="hrRiskAssess" items="${hrRiskAssessList}">
												<option value="${hrRiskAssess}">${hrRiskAssess}</option>
											</d:forEach>
										</select>
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Controls  -->
									<div class="col-sm-6">
										<label for="controls">Controls:</label> <input
											class="form-control" name="edtHRControls" id="edtHRControls"
											type="text" value="">
									</div>
									<!-- Level of Control  -->
									<div class="col-sm-6">
										<label for="levelOfControl">Level of Control:</label> 
										<select class="form-control"
											id="edtHRLevelOfControl"
											name="edtHRLevelOfControl">
											<d:forEach var="levelOfControls" items="${levelOfControlsList}">
												<option value="${levelOfControls}">${levelOfControls}</option>
											</d:forEach>
										</select>
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Residual Risk Assessment -->
									<div class="col-sm-6">
										<label for="residualRiskAssessment">Residual Risk
											Assessment:</label> <select class="form-control"
											id="edtHRResidualRiskAssessment"
											name="edtHRResidualRiskAssessment">
											<d:forEach var="hrRiskAssess" items="${hrRiskAssessList}">
												<option value="${hrRiskAssess}">${hrRiskAssess}</option>
											</d:forEach>
										</select>
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<input class="form-control" name="edtHRRecordID"
										id="edtGRecordID" type="hidden" value=""> <input
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
<div class="modal fade" id="deleteHazardRegister" role="dialog">
	<div class="modal-dialog" style="width: 50%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>Hazard Register - Delete Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to delete record -->
			<form
				action="${pageContext.request.contextPath}/Tabs?action=dltTabs&tab=HazReg"
				method="post">
				<div class="modal-body bgColorWhite">
					<p>Are you sure you wish to delete one record?</p>
				</div>
				<input class="form-control" name="dltHRRecordID" id="dltHRRecordID"
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

