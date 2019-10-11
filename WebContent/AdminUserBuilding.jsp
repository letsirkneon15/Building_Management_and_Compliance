
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Selection -->
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Selection</h6>
	</div>
	<div class="panel-group">
		<form
			action="${pageContext.request.contextPath}/Admin?action=showTabs&tab=UserBuilding"
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
		<h6 class="m-0 font-weight-bold text-primary">Buildings
			Registered for User ID: ${auserID}</h6>
	</div>
	<form
		action="${pageContext.request.contextPath}/Admin?action=editTabs&tab=UserBuilding"
		method="post">
		<div class="panel-default">
			<div class="panel-body">
			<p class="text-danger"><input type="checkbox" class="checkAllBuildings" name="checkAllBuildings" id="checkAllBuildings"
			value="checkAllBuildings">Please check/uncheck to select/deselect all buildings.</p>
				<c:forEach var="b" items="${aUserBuildArr}" varStatus="bIndex">
					<div class="col-sm-4">
						<input type="checkbox" name="userBuildList" id="${b.buildingID}"
							value="${b.buildingID}" data-checked="${b.status}">
						${b.buildingName}
					</div>
				</c:forEach>
				<input type="hidden" id="auserID" name="auserID" value="${auserID}">
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
