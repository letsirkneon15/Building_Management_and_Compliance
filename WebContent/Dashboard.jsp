<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
              <div class="table-responsive">
                <table class="table table-bordered table-hover table-striped table-condensed" id="dashboardTable" width="100%" cellspacing="0">
                  <thead>
                    <tr>
                      <th>Building</th>
                      <th>Address</th>
                      <th>Owner</th>
                      <th>Client</th>
                      <th>Project#</th>
                      <th>CS#</th>
                      <th>BWOF Expires</th>
                      <th class="sorting_asc_disabled sorting_desc_disabled"></th>
           			  <th class="sorting_asc_disabled sorting_desc_disabled"></th>   
                    </tr>
                  </thead>
                  
                  <!-- Start Rows -->
                  <tbody>
                   	<c:forEach var="b" items="${bHeaderArr}" varStatus="bIndex">        
       		 		<tr class="table-row" data-href="${pageContext.request.contextPath}/Tabs?action=tabContents&buildingID=${b.buildingID}"
       		 			data-id="tabLink${bIndex.index}" data-buildingID="${b.buildingID}">
           				<td>${b.buildingName }</td>
          				<td>${b.address }</td>
          				<td>${b.owner}</td>
           				<td>${b.client }</td>
           				<td>${b.projectNumber }</td>
           				<td>${b.csNumber }</td>
           				<td>${b.bwofAnniversary }</td>      
	      				<td><a href="#editRecord" data-toggle="modal" data-id="edtLink${bIndex.index}"
	       					data-buildingID="${b.buildingID}"><img src='images/edit.jpg' height=15 width=15></a>
	       				</td> 	
	       				<%-- <td><a href="" id="dltLink${hsIndex.index}"><img src='images/delete.jpg' height=15 width=15></a> --%>
	       				<td><a href="#deleteRecord" data-toggle="modal" data-id="dltLink${bIndex.index}"
	       					data-buildingID="${b.buildingID}"><img src='images/delete.jpg' height=15 width=15></a>
	       				</td>           
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


