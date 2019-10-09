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
						<label>Tab Name:</label> <select class="form-control" id="atabID"
							name="atabID" data-selected="${atabID}">
							<option value="ALL">ALL Tabs</option>
							<c:forEach var="tab" items="${tabList}">
							 	<c:if test="${not empty tab.tabID}">
									<option value="${tab.tabID}">${tab.tabDescription}</option>
								</c:if>
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
		<p class="text-danger"><input type="checkbox" class="checkAllTabs" name="checkAllTabs" id="checkAllTabs"
			value="checkAllTabs">Please check/uncheck to select/deselect all tab segments.</p>
		<div class="table-responsive">
			<table
				class="table table-bordered table-hover table-striped table-condensed"
				id="userTabTable" width="100%" cellspacing="0">
				<thead>
					<tr align="center">
						<th>Tab ID</th>
						<th>Tab Description</th>
						<th>Tab Segments</th>
					</tr>
				</thead>

				<!-- Start Rows -->
				<tbody>
					<c:forEach var="b" items="${aUserTabArr}" varStatus="bIndex">
						<c:if test="${not empty b.tabID}">
						<tr>
							<td>${b.tabID }</td>
							<td>${b.tabDescription }</td>
							<td>
									<div class="col-sm-5">
										<input type="checkbox" name="${b.tabID }" id="${b.tabDsp}"
										value="DSP" data-checkedtab="${b.tabDsp}">
										Display
									</div>
									<div class="col-sm-5">
										<input type="checkbox" name="${b.tabID }" id="${b.tabCrt}"
										value="CRT" data-checkedtab="${b.tabCrt}">
										Create
									</div>
									<div class="col-sm-5">
										<input type="checkbox" name="${b.tabID }" id="${b.tabUpd}"
										value="UPD" data-checkedtab="${b.tabUpd}">
										Update
									</div>
									<div class="col-sm-5">
										<input type="checkbox" name="${b.tabID }" id="${b.tabDlt}"
										value="DLT" data-checkedtab="${b.tabDlt}">
										Delete
									</div>				
							</td>			
						</tr>
						</c:if>
					</c:forEach>
				</tbody>
				<!-- End Rows -->
			</table>
		</div>
		</div>
		</div>
		<input type="hidden" id="auserID" name="auserID" value="${auserID}">
		<input type="hidden" id="atabID" name="atabID" value="${atabID}">
		
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

