<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">Buildings</h1>
	</div>

	<!-- DataTables -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">All buildings</h6>
		</div>

		<div class="card-body">

			<c:if test="${not empty genInfoTab.tabCrt}">
				<div align="right">
					<button type="button" class="btn btn-primary" data-toggle="modal"
						data-target="#crtGenInfo" data-id="crtLink${bIndex.index}">
						<h5>
							<span class="glyphicon glyphicon-plus-sign"></span><b> Add
								New Building</b>
						</h5>
					</button>
					<br> <br>
				</div>
			</c:if>

			<div class="table-responsive">
				<table
					class="table table-bordered table-hover table-striped table-condensed"
					id="dashboardTable" width="100%" cellspacing="0">
					<thead>
						<tr>
							<th>Building</th>
							<th>Address</th>
							<th>Owner</th>
							<th>Client</th>
							<th>Project#</th>
							<th>CS#</th>
							<th>BWOF Expires</th>
						</tr>
					</thead>

					<!-- Start Rows -->
					<tbody>
						<c:forEach var="b" items="${bHeaderArr}" varStatus="bIndex">
							<tr class="table-row"
								data-href="${pageContext.request.contextPath}/Tabs?action=tabContents&buildingID=${b.buildingID}"
								data-id="tabLink${bIndex.index}"
								data-buildingID="${b.buildingID}">
								<td>${b.buildingName }</td>
								<td>${b.address }</td>
								<td>${b.owner}</td>
								<td>${b.client }</td>
								<td>${b.projectNumber }</td>
								<td>${b.csNumber }</td>
								<td>${b.bwofAnniversary }</td>
							</tr>
						</c:forEach>
					</tbody>
					<!-- End Rows -->

				</table>
			</div>
		</div>
	</div>
	<!-- End of DataTables -->
</div>
<!-- End of Main Content -->

<!--START- Create Record (MODAL)-->
<div class="modal fade bd-example-modal-lg" id="crtGenInfo" role="dialog">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>Buildings - Create New Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to create record -->
			<form
				action="${pageContext.request.contextPath}/BuildingController?action=crtBuildings"
				method="post">
				<div class="modal-body bgColorWhite">
					<div class="table-responsive">
						<div class="well">

							<div class="panel-default">
								<div class="panel-body">
									<!-- Building Name -->
									<div class="col-sm-4">
										<label for="buildingName">Name of
											Building:</label> <input type="text" class="form-control"
											id="buildingName" name="buildingName" value="${buildingName}" />
									</div>
									<!-- Address -->
									<div class="col-sm-4">
										<label for="address">Address:</label> <input
											type="text" class="form-control" id="address" name="address"
											value="${address}" />
									</div>
									<!-- Responsible Office -->
									<div class="col-sm-4">
										<label for="responsibleOffice">Responsible
											Office:</label> <input type="text" class="form-control"
											id="responsibleOffice" name="responsibleOffice"
											value="${responsibleOffice}" />
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Client  -->
									<div class="col-sm-4">
										<label for="client">Client:</label> <input
											type="text" class="form-control" id="client" name="client"
											value="${client}" />
									</div>
									<!-- Project Number  -->
									<div class="col-sm-4">
										<label for="projectNumber">Project
											Number:</label> <input type="text" class="form-control"
											id="projectNumber" name="projectNumber"
											value="${projectNumber}" />
									</div>
									<!-- Building Information  -->
									<div class="col-sm-4">
										<label for="buildingInformation">Building
											Information:</label> <input type="text" class="form-control"
											id="buildingInformation" name="buildingInformation"
											value="${buildingInformation}" />
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- CS Number  -->
									<div class="col-sm-4">
										<label for="csNumber">CS Number:</label> <input
											type="text" class="form-control" id="csNumber"
											name="csNumber" value="${csNumber}" />
									</div>
									<!-- Legal Descriptiion  -->
									<div class="col-sm-4">
										<label for="legalDescription">Legal
											Description:</label> <input type="text" class="form-control"
											id="legalDescription" name="legalDescription"
											value="${legalDescription}" />

									</div>
									<!-- Max Occupants  -->
									<div class="col-sm-4">
										<label for="maxOccupants">Max
											Occupants:</label> <input type="text" class="form-control"
											id="maxOccupants" name="maxOccupants" value="${maxOccupants}" />
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Fire Hazard Category  -->
									<div class="col-sm-4">
										<label for="fireHazardCategory">Fire
											Hazard Category:</label> <select class="form-control"
											id="fireHazardCategory" name="fireHazardCategory"
											data-selected="${fireHazardCategory}">
											<c:forEach var="fireHazCat" items="${fireHazCatList}">
												<option value="${fireHazCat}">${fireHazCat}</option>
											</c:forEach>
										</select>
									</div>
									<!-- Year Built  -->
									<div class="col-sm-4">
										<label for="yearBuilt">Year Built:</label> <input
											type="text" class="form-control" id="yearBuilt"
											name="yearBuilt" value="${yearBuilt}" />
									</div>
									<!-- Intended Life -->
									<div class="col-sm-4">
										<label for="intendedLife">Intended
											Life:</label> <input type="text" class="form-control"
											id="intendedLife" name="intendedLife" value="${intendedLife}" />
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- BWOF Anniversary  -->
									<div class="col-sm-4">
										<label for="bwofAnniversary">BWOF
											Anniversary:</label> <input type="text" class="form-control"
											id="bwofAnniversary" name="bwofAnniversary"
											value="${bwofAnniversary}" />
									</div>
									<!-- Asbestos Present -->
									<div class="col-sm-4">
										<label for="asbestosPresent">Asbestos
											Present:</label> <select class="form-control" id="asbestosPresent"
											name="asbestosPresent" data-selected="${asbestosPresent}">
											<c:forEach var="yesNo" items="${yesNoList}">
												<option value="${yesNo}">${yesNo}</option>
											</c:forEach>
										</select>
									</div>
									<!-- NBS Percent  -->
									<div class="col-sm-4">
										<label for="nbsPercent">NBS %:</label> <input
											type="text" class="form-control" id="nbsPercent"
											name="nbsPercent" value="${nbsPercentage}" />
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

