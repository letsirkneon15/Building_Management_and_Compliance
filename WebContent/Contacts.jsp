
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body">
		<c:if test="${not empty contactsTab.tabCrt}">
		<div align="right">	
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#crtContacts" data-id="crtLink${bIndex.index}"
				data-buildingid="${buildingID}">
				<h5>
					<span class="glyphicon glyphicon-plus-sign"></span><b> Add
						Contacts</b>
				</h5>
			</button>
			<br> <br>
		</div>
		</c:if>
		<div class="table-responsive">
			<table
				class="table table-bordered table-hover table-striped table-condensed"
				id="contentsTable" width="100%" cellspacing="0">
				<thead>
					<tr align="center">
						<th>Name</th>
						<th>Type</th>
						<th>Company</th>
						<th>Phone</th>
						<th>Fax</th>
						<th>Mobile</th>
						<th>Email Address</th>
						<c:if test="${not empty contactsTab.tabUpd}">
							<th class="sorting_asc_disabled sorting_desc_disabled"></th>
						</c:if>
						<c:if test="${not empty contactsTab.tabDlt}">
							<th class="sorting_asc_disabled sorting_desc_disabled"></th>
						</c:if>
					</tr>
				</thead>

				<!-- Start Rows -->
				<tbody>
					<d:forEach var="b" items="${contactsArr}" varStatus="bIndex">
						<tr>
							<td>${b.name }</td>
							<td>${b.type }</td>
							<td>${b.company }</td>
							<td>${b.phoneNumber }</td>
							<td>${b.faxNumber }</td>
							<td>${b.mobileNumber }</td>
							<td>${b.emailAdd }</td>

							<c:if test="${not empty contactsTab.tabUpd}">
							<td align="center"><a href="#editContacts"
								data-toggle="modal" data-id="edtLink${bIndex.index}"
								data-buildingid="${b.buildingID}" data-recordid="${b.recordID}"
								data-name="${b.name}" data-type="${b.type}"
								data-company="${b.company}" data-phonenumber="${b.phoneNumber}"
								data-faxnumber="${b.faxNumber}"
								data-mobilenumber="${b.mobileNumber}"
								data-emailadd="${b.emailAdd}"> <img src='images/edit.jpg'
									height=15 width=15></a></td>
							</c:if>
							<c:if test="${not empty contactsTab.tabDlt}">
							<td align="center"><a href="#deleteContacts"
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
<div class="modal fade" id="crtContacts" role="dialog">
	<div class="modal-dialog" style="width: 100%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>Building Contacts - Create a New Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to create record -->
			<form
				action="${pageContext.request.contextPath}/Tabs?action=crtTabs&tab=Contacts"
				method="post">
				<div class="modal-body bgColorWhite">
					<div class="table-responsive" style="width: 100%">
						<div class="well">

							<div class="panel-default">
								<div class="panel-body">
									<!-- Name  -->
									<div class="col-sm-6">
										<label for="name">Name:</label> <input class="form-control"
											name="crtCName" id="crtCName" type="text" value="${crtCName}">
									</div>

									<!-- Type  -->
									<div class="col-sm-6">
									<label for="type">Type:</label> 
									<select class="form-control" id="crtCType" name="crtCType">
			  							<d:forEach var="cType" items="${cTypeList}">
  			     							<option value="${cType}">${cType}</option>
	   		  							</d:forEach>
	      							</select>
									</div>
									
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Company -->
									<div class="col-sm-6">
										<label for="company">Company:</label> <input
											class="form-control" name="crtCCompany" id="crtCCompany"
											type="text" value="${crtCCompany}">
									</div>

									<!-- Phone Number  -->
									<div class="col-sm-6">
										<label for="phoneNumber">Phone Number:</label> <input
											class="form-control" name="crtCPhoneNumber"
											id="crtCPhoneNumber" type="text" value="${crtCPhoneNumber}">
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Fax Number  -->
									<div class="col-sm-6">
										<label for="faxNumber">Fax Number:</label> <input
											class="form-control" name="crtCFaxNumber" id="crtCFaxNumber"
											type="text" value="${crtCFaxNumber}">
									</div>

									<!-- Mobile Number -->
									<div class="col-sm-6">
										<label for="mobileNumber">Mobile Number:</label> <input
											class="form-control" name="crtCMobileNumber"
											id="crtCMobileNumber" type="text" value="${crtCMobileNumber}">
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Email Address  -->
									<div class="col-sm-6">
										<label for="emailAdd">Email Address:</label> <input
											class="form-control" name="crtCEmailAdd" id="crtCEmailAdd"
											type="text" value="${crtCEmailAdd}">
									</div>
									<input class="form-control" name="buildingID"
										id="buildingID" type="hidden" value="">
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
<div class="modal fade" id="editContacts" role="dialog">
	<div class="modal-dialog" style="width: 100%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>Building Contacts - Update Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to edit record -->
			<form
				action="${pageContext.request.contextPath}/Tabs?action=editTabs&tab=Contacts"
				method="post">
				<div class="modal-body bgColorWhite">
					<div class="table-responsive" style="width: 100%">
						<div class="well">

							<div class="panel-default">
								<div class="panel-body">
									<!-- Name  -->
									<div class="col-sm-6">
										<label for="name">Name:</label> <input class="form-control"
											name="edtCName" id="edtCName" type="text" value="">
									</div>

									<!-- Type  -->
									<div class="col-sm-6">
										<label for="type">Type:</label> 
										<select class="form-control" id="edtCType" name="edtCType">
			  								<d:forEach var="cType" items="${cTypeList}">			  								
  			     								<option value="${cType}">${cType}</option>
	   		  								</d:forEach>
	      								</select>
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Company -->
									<div class="col-sm-6">
										<label for="company">Company:</label> <input
											class="form-control" name="edtCCompany" id="edtCCompany"
											type="text" value="">
									</div>

									<!-- Phone Number  -->
									<div class="col-sm-6">
										<label for="phoneNumber">Phone Number:</label> <input
											class="form-control" name="edtCPhoneNumber"
											id="edtCPhoneNumber" type="text" value="">
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Fax Number  -->
									<div class="col-sm-6">
										<label for="faxNumber">Fax Number:</label> <input
											class="form-control" name="edtCFaxNumber" id="edtCFaxNumber"
											type="text" value="">
									</div>

									<!-- Mobile Number -->
									<div class="col-sm-6">
										<label for="mobileNumber">Mobile Number:</label> <input
											class="form-control" name="edtCMobileNumber"
											id="edtCMobileNumber" type="text" value="">
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Email Address  -->
									<div class="col-sm-6">
										<label for="emailAdd">Email Address:</label> <input
											class="form-control" name="edtCEmailAdd" id="edtCEmailAdd"
											type="text" value="">
									</div>

									<input class="form-control" name="edtCRecordID"
										id="edtCRecordID" type="hidden" value=""> 
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
<div class="modal fade" id="deleteContacts" role="dialog">
	<div class="modal-dialog" style="width: 50%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>Building Contacts - Delete Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to delete record -->
			<form
				action="${pageContext.request.contextPath}/Tabs?action=dltTabs&tab=Contacts"
				method="post">
				<div class="modal-body bgColorWhite">
					<p>Are you sure you wish to delete one record?</p>
				</div>
				<input class="form-control" name="dltCRecordID" id="dltCRecordID"
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