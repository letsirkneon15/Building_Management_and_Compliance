<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">Reports</h1>
	</div>

	<!-- Report Selection -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Report Selection</h6>
		</div>

		<div class="panel-group">
			<form action="${pageContext.request.contextPath}/Reports?action=preview"
				method="post">
				<div class="panel-default">
					<div class="panel-body">
						<!-- Building Name -->
						<div class="col-sm-4">
							<label for="buildingName">Name of Building:</label> <input
								class="form-control" type="text" id="buildingName"
								name="buildingName" value="${buildingName}">
						</div>

						<!-- Client -->
						<div class="col-sm-4">
							<label for="client">Client:</label> <input class="form-control"
								type="text" id="client" name="client" value="${client}">
						</div>
					</div>
				</div>

				<div class="panel-default">
					<div class="panel-body">
						<!-- AsbestosPresent -->
						<div class="col-sm-4">
							<label for="asbestosPresent">Asbestos Present:</label> <select
								class="form-control" id="asbestosPresent" name="asbestosPresent" data-selected="${asbestosPresent}">
								<c:forEach var="yesNo" items="${yesNoList}">
									<option value="${yesNo}">${yesNo}</option>
								</c:forEach>
							</select>
						</div>

						<!-- Report Format -->
						<div class="col-sm-4">
							<label for="reportFormat">Report Format:</label> <select
								class="form-control" id="reportFormat" name="reportFormat" data-selected="${reportFormat}">
								<c:forEach var="reportFormat" items="${reportFormatList}">
									<option value="${reportFormat}">${reportFormat}</option>
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
								value="preview">
								<span class="glyphicon glyphicon-search"></span> Preview
							</button>
							<button type="submit" class="btn btn-primary" name="button"
								value="download" data-toggle="modal">
								<span class="glyphicon glyphicon-download"></span> Download to
								Excel
							</button>
						</div>

					</div>
				</div>
			</form>
		</div>
	</div>

</div> <!-- End of Main Content -->

<!--START- Download to Excel (MODAL)-->
<c:if test = "${button=='download'}">
<div class="modal fade show in" id="downloadToExcel" role="dialog">
  <div class="modal-dialog" style="width: 50%">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header bg-primary">
          <h4 class="modal-title" align="left"><b>Building Management & Compliance - Download to Excel File</b></h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
	
		<!-- Create a Form to download record -->
		<form action="${pageContext.request.contextPath}/Reports?action=download" method="post">
         <div class="modal-body bgColorWhite">
         	<p> The excel file will be created in C:/bmcs/downloads with filename format as: 
         		userID_ReportFormat_timestamp.xlsx </p>
         </div>
         <input class="form-control" name="buildingName" id="buildingName" type="hidden" value="${buildingName}">
         <input class="form-control" name="client" id="client" type="hidden" value="${client}">
         <input class="form-control" name="asbestosPresent" id="asbestosPresent" type="hidden" value="${asbestosPresent}">
         <input class="form-control" name="reportFormat" id="reportFormat" type="hidden" value="${reportFormat}">
         <div class="modal-footer">
  		 <!-- Submit Button -->
     	 <button type="submit" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-ok"></span> OK </button>
        </div>
        </form>
	  </div>		     
  </div>
</div>	 
<!--END- Download to Excel (MODAL)-->
</c:if>


