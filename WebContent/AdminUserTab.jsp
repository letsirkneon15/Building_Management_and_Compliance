
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Selection -->
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Selection</h6>
	</div>
	<div class="panel-group">
		<form
			action="${pageContext.request.contextPath}/Admin?action=showTabs&tab=UserTab"
			method="post">
			<div class="panel-default">
				<div class="panel-body">
					<!-- User ID -->
					<div class="col-sm-4">
						<label>User ID:</label> <select class="form-control" id="auserID"
							name="auserID" data-selected="${auserID}">
							<c:forEach var="b" items="${userArr}">
								<option value="${b.userID}">${b.userID}</option>
							</c:forEach>
						</select>
					</div>
					
					<!-- Tab Name -->
					<div class="col-sm-4">
						<label>User ID:</label> <select class="form-control" id="tabID"
							name="tabID" data-selected="${userTab[1]}">
							<c:forEach var="userTab" items="${userTabArr}">
								<option value="${userTab[0]},${userTab[1]}">${userTab[1]}</option>
							</c:forEach>
						</select>
					</div>

				</div>
			</div>

			<div class="panel-default">
				<div class="panel-body">
					<!-- Button -->
					<div class="card-header py-3">
						<button type="submit" class="btn btn-primary" name="button"
							value="search">
							<span class="glyphicon glyphicon-search"></span> Search
						</button>
					</div>
				</div>
			</div>
		</form>
	</div>
</div>

<!-- Search Results -->
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Tabs
			Registered for User ID: ${auserID}</h6>
	</div>
	<form
		action="${pageContext.request.contextPath}/Admin?action=editTabs&tab=UserTab"
		method="post">
		<div class="panel-default">
			<div class="panel-body">
			
			<div class="table-responsive">
			<table
				class="table table-bordered table-hover table-striped table-condensed"
				width="100%" cellspacing="0">
				<thead>
					<tr align="center">
						<th>Tab Name</th>
						<th rowspan="3">Segments</th>
					</tr>
				</thead>

				<!-- Start Rows -->
				<tbody>
					<d:forEach var="b" items="${aUserTabArr}" varStatus="bIndex">
						<tr>
							<td>${b.name }</td>
							<td>${b.attachment }</td>
							<td>${b.type }</td>
							<td>${b.uploadedBy }</td>
							<td>${b.lastUploadedBy }</td>

							<td align="center"><a href="#editAsbestos"
								data-toggle="modal" data-id="edtLink${bIndex.index}"
								data-recordid="${b.recordID}" data-buildingid="${b.buildingID}"
								data-name="${b.name}" data-attachment="${b.attachment}"
								data-type="${b.type}" data-uploadedby="${b.uploadedBy}"
								data-lastuploadedby="${b.lastUploadedBy}"> <img
									src='images/edit.jpg' height=15 width=15></a></td>

							<td align="center"><a href="#deleteAsbestos"
								data-toggle="modal" data-id="dltLink${bIndex.index}"
								data-recordid="${b.recordID}" data-buildingid="${b.buildingID}"><img
									src='images/delete.jpg' height=15 width=15></a></td>

						</tr>
					</d:forEach>
				</tbody>
				<!-- End Rows -->

			</table>
		</div>
			
				<c:forEach var="b" items="${aUserBuildArr}" varStatus="bIndex">
					<div class="col-sm-4">
						<input type="checkbox" name="userBuildList" id="${b.buildingID}"
							value="${b.buildingID}" data-checked="${b.status}">
						${b.buildingName}
					</div>
					<input type="hidden" id="auserID" name="auserID" value="${auserID}">
				</c:forEach>
			</div>
		</div>
		<div class="panel-default">
			<div class="panel-body">
				<!-- Button -->
				<div class="card-header py-3">
					<c:if test="${not empty errorMsg}">
						<div class="alert alert-danger" role="alert"
							style="font-size: 14px">${errorMsg}</div>
					</c:if>

					<c:if test="${not empty successMsg}">
						<div class="alert alert-success" role="alert"
							style="font-size: 14px">${successMsg}</div>
					</c:if>

					<button type="submit" class="btn btn-primary" name="button"
						value="update">
						<span class="glyphicon glyphicon-edit"></span> Update
					</button>
				</div>
			</div>
		</div>
	</form>
</div>
