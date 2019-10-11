
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- DataTables -->
<div class="card shadow mb-4">
	<div class="card-body">
		<div align="right">
			<button type="button" class="btn btn-primary" data-toggle="modal"
				data-target="#crtUser" data-id="crtLink${bIndex.index}"
				data-userid="${userID}">
				<h5>
					<span class="glyphicon glyphicon-plus-sign"></span><b> Add New
						User</b>
				</h5>
			</button>
			<br> <br>
		</div>
		<div class="table-responsive">
			<table
				class="table table-bordered table-hover table-striped table-condensed"
				id="userTable" width="100%" cellspacing="0">
				<thead>
					<tr align="center">
						<th>User ID</th>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Contact Number</th>
						<th>Email</th>
						<th>Company Name</th>
						<th>Company Address</th>
						<th>Password</th>
						<th>User Role</th>

						<th class="sorting_asc_disabled sorting_desc_disabled"></th>
						<th class="sorting_asc_disabled sorting_desc_disabled"></th>
					</tr>
				</thead>

				<!-- Start Rows -->
				<tbody>
					<c:forEach var="b" items="${userArr}" varStatus="bIndex">
						<tr>
							<td>${b.userID }</td>
							<td>${b.name.split(',')[1].trim() }</td>
							<td>${b.name.split(',')[0].trim() }</td>
							<td>${b.contactNum }</td>
							<td>${b.emailAdd }</td>
							<td>${b.companyName }</td>
							<td>${b.companyAddress }</td>
							<td>${b.password }</td>
							<td>${b.role }</td>

							<td align="center"><a href="#editUser" data-toggle="modal"
								data-id="edtLink${bIndex.index}" data-auserid="${b.userID}"
								data-firstname="${b.name.split(',')[1].trim()}"
								data-lastname="${b.name.split(',')[0].trim()}"
								data-contactnum="${b.contactNum}" data-emailadd="${b.emailAdd}"
								data-companyname="${b.companyName}"
								data-companyaddress="${b.companyAddress}" 
								data-password="${b.password}" data-userrole="${b.role}"> <img src='images/edit.jpg'
									height=15 width=15></a></td>

							<td align="center"><a href="#deleteUser"
								data-toggle="modal" data-id="dltLink${bIndex.index}"
								data-auserid="${b.userID}"> <img src='images/delete.jpg'
									height=15 width=15>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
				<!-- End Rows -->
			</table>
		</div>
	</div>
</div>
<!-- End of DataTables -->

<!--START- Create Record (MODAL)-->
<div class="modal fade" id="crtUser" role="dialog">
	<div class="modal-dialog" style="width: 100%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>User Account - Create a New Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to create record -->
			<form
				action="${pageContext.request.contextPath}/Admin?action=crtTabs&tab=UserAccount"
				method="post">
				<div class="modal-body bgColorWhite">
					<div class="table-responsive" style="width: 100%">
						<div class="well">

							<div class="panel-default">
								<div class="panel-body">
									<!-- First Name  -->
									<div class="col-sm-6">
										<label>First Name:</label> <input class="form-control"
											name="crtFirstName" id="crtFirstName" type="text"
											value="${crtFirstName}">
									</div>

									<!-- Last Name  -->
									<div class="col-sm-6">
										<label>Last Name:</label> <input class="form-control"
											name="crtLastName" id="crtLastName" type="text"
											value="${crtLastName}">
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Contact Number  -->
									<div class="col-sm-6">
										<label>Phone Number:</label> <input class="form-control"
											name="crtContactNum" id="crtContactNum" type="text"
											value="${crtContactNum}">
									</div>

									<!-- Email Address  -->
									<div class="col-sm-6">
										<label>Email Address:</label> <input class="form-control"
											name="crtEmail" id="crtEmail" type="text" value="${crtEmail}">
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Company Name -->
									<div class="col-sm-6">
										<label>Company Name:</label> <input class="form-control"
											name="crtCompanyName" id="crtCompanyName" type="text"
											value="${crtCompanyName}">
									</div>

									<!-- Company Address  -->
									<div class="col-sm-6">
										<label>Company Address:</label> <input class="form-control"
											name="crtCompanyAddress" id="crtCompanyAddress" type="text"
											value="${crtCompanyAddress}">
									</div>
								</div>
							</div>
							
							<div class="panel-default">
								<div class="panel-body">
									<!-- User Role -->
									<div class="col-sm-6">
										<label>User Role:</label> 
										<select class="form-control" id="crtRole" name="crtRole">
			  							<c:forEach var="userRole" items="${roleList}">
  			     							<option value="${userRole}">${userRole}</option>
	   		  							</c:forEach>
	      							</select>
									</div>
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
<div class="modal fade" id="editUser" role="dialog">
	<div class="modal-dialog" style="width: 100%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>User Account - Update Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to edit record -->
			<form
				action="${pageContext.request.contextPath}/Admin?action=editTabs&tab=UserAccount"
				method="post">
				<div class="modal-body bgColorWhite">
					<div class="table-responsive" style="width: 100%">
						<div class="well">

							<div class="panel-default">
								<div class="panel-body">
									<!-- First Name  -->
									<div class="col-sm-6">
										<label>First Name:</label> <input class="form-control"
											name="edtFirstName" id="edtFirstName" type="text" value="">
									</div>

									<!-- Last Name  -->
									<div class="col-sm-6">
										<label>Last Name:</label> <input class="form-control"
											name="edtLastName" id="edtLastName" type="text" value="">
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Contact Number  -->
									<div class="col-sm-6">
										<label>Phone Number:</label> <input class="form-control"
											name="edtContactNum" id="edtContactNum" type="text" value="">
									</div>
									<!-- Email Address  -->
									<div class="col-sm-6">
										<label>Email Address:</label> <input class="form-control"
											name="edtEmail" id="edtEmail" type="text" value="">
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- Company Name -->
									<div class="col-sm-6">
										<label>Company Name:</label> <input class="form-control"
											name="edtCompanyName" id="edtCompanyName" type="text"
											value="">
									</div>

									<!-- Company Address  -->
									<div class="col-sm-6">
										<label>Company Address:</label> <input class="form-control"
											name="edtCompanyAddress" id="edtCompanyAddress" type="text"
											value="">
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- User ID -->
									<div class="col-sm-6">
										<label>User ID:</label> <input class="form-control"
											name="edtUserID" id="edtUserID" type="text" value="" readOnly>
									</div>

									<!-- Password  -->
									<div class="col-sm-6">
										<label>Password:</label> <input class="form-control"
											name="edtPassword" id="edtPassword" type="text"
											value="${edtPassword}">
									</div>
								</div>
							</div>

							<div class="panel-default">
								<div class="panel-body">
									<!-- User Role -->
									<div class="col-sm-6">
										<label>User Role:</label> 
										<select class="form-control" id="edtRole" name="edtRole">
			  							<c:forEach var="userRole" items="${roleList}">
  			     							<option value="${userRole}">${userRole}</option>
	   		  							</c:forEach>
	      							</select>
									</div>
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
<div class="modal fade" id="deleteUser" role="dialog">
	<div class="modal-dialog" style="width: 50%">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<h4 class="modal-title" align="left">
					<b>User Account - Delete Record</b>
				</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
			</div>

			<!-- Create a Form to delete record -->
			<form
				action="${pageContext.request.contextPath}/Admin?action=dltTabs&tab=UserAccount"
				method="post">
				<div class="modal-body bgColorWhite">
					<p>Are you sure you wish to delete one record?</p>
				</div>
				<input class="form-control" name="auserID" id="auserID"
					type="hidden" value="">
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

<!--START- User Account Info Successful Creation Info (MODAL)-->
<c:if test="${not empty userMsg}">
	<div class="modal fade show in" id="create" role="dialog">
		<div class="modal-dialog" style="width: 50%">
			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<h4 class="modal-title" align="left">
						<b>User Account Creation</b>
					</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Create a Form to inform user that the User Account registration is successful -->
				<form>
					<div class="modal-body bgColorWhite">
						<p>${userMsg}</p>
					</div>
					<div class="modal-footer">
						<!-- Submit Button -->
						<button type="submit" class="btn btn-primary" data-dismiss="modal">
							<span class="glyphicon glyphicon-ok"></span> OK
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</c:if>
<!--END- Create User Account Info (MODAL)-->