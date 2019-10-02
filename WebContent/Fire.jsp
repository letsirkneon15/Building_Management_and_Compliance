
<!-- DataTables -->
<div class="card shadow mb-4">
    <div class="card-body" >
        <div align="right">
            <button type="button" class="btn btn-primary"
                    data-toggle="modal" data-target="#crtFire" data-id="crtLink${bIndex.index}" data-buildingid="${buildingID}">
                <h5>
                    <span class="glyphicon glyphicon-plus-sign"></span><b> Add Fire</b>
                </h5>
            </button>
            <br> <br> </div>
        <div class="table-responsive">
            <table class="table table-bordered table-hover table-striped table-condensed" id="fireTable" width="100%"
                   cellspacing="0">
                <thead>
                <tr align="center">
                    <th>Name</th>
                    <th>Attachment</th>
                    <th>Type</th>
                    <th>Uploaded By</th>
                    <th>Last Uploaded</th>
                    <th class="sorting_asc_disabled sorting_desc_disabled"></th>
                    <th class="sorting_asc_disabled sorting_desc_disabled"></th>
                </tr>
                </thead>

                <!-- Start Rows -->
                <tbody>
                <c:forEach var="b" items="${fireArr}" varStatus="bIndex">
                    <tr>
                        <td>${b.name }</td>
                        <td>${b.attachment }</td>
                        <td>${b.type }</td>
                        <td>${b.uploadedBy }</td>
                        <td>${b.lastUploadedBy }</td>

                        <td align="center"><a href="#editFire" data-toggle="modal"
                                              data-id="edtLink${bIndex.index}" data-recordid="${b.recordID}" data-buildingid="${b.buildingID}"
                                              data-name="${b.name}" data-attachment="${b.attachment}" data-type="${b.type}" data-uploadedby="${b.uploadedBy}"
                                              data-lastuploadedby="${b.lastUploadedBy}">
                            <img src='images/edit.jpg' height=15 width=15></a></td>

                        <td align="center"><a href="#deleteFire" data-toggle="modal"
                                              data-id="dltLink${bIndex.index}" data-recordid="${b.recordID}"
                                              data-buildingid="${b.buildingID}">
                            <img src='images/delete.jpg' height=15 width=15></a></td>
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
<div class="modal fade" id="crtFire" role="dialog">
    <div class="modal-dialog" style="width: 100%">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header bg-primary">
                <h4 class="modal-title" align="left"><b>Fire - Create New Record</b></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Create a Form to create record -->
            <form action="${pageContext.request.contextPath}/Tabs?action=crtTabs&tab=Fire" method="post">
                <div class="modal-body bgColorWhite">
                    <div class="table-responsive" style="width:100%">
                        <div class="well">

                            <div class="panel-default">
                                <div class="panel-body">
                                    <!-- Name  -->
                                    <div class="col-sm-6">
                                        <label for="name">Name:</label>
                                        <input class="form-control" name = "crtFName" id="crtFName" type="text" value="${crtFName}">
                                    </div>
                                    <!-- Attachment -->
                                    <div class="col-sm-6">
                                        <label for="attachment">Attachment:</label>
                                        <input class="form-control" name="crtFAttachment" id="crtFAttachment" type="file" value="${crtFAttachment}">
                                    </div>
                                </div>
                            </div>

                            <div class="panel-default">
                                <div class="panel-body">
                                    <!-- Type  -->
                                    <div class="col-sm-6">
                                        <label for="type">Type:</label>
                                        <input class="form-control" name="crtFType" id="crtFType" type="text" value="${crtFType}">
                                    </div>
                                    <!-- Uploaded By  -->
                                    <div class="col-sm-6">

                                        <input class="form-control" name="crtFUploadedBy" id="crtFUploadedBy" type="hidden" type="text" value="${crtFUploadedBy}" readOnly>
                                    </div>
                                </div>
                            </div>

                            <div class="panel-default">
                                <div class="panel-body">
                                    <!-- Last Uploaded -->
                                    <div class="col-sm-6">

                                        <input class="form-control" name="crtFLastUploadedBy" id="crtFLastUploadedBy" type="hidden" type="text" value="${crtFLastUploadedBy}" readOnly>
                                    </div>
                                </div>
                            </div>

                            <div class="panel-default">
                                <div class="panel-body">
                                    <input class="form-control" name="buildingID" id="buildingID" type="hidden" value="">
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <!-- Submit Button -->
                    <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-edit"></span> Create</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!--END- Create Record (MODAL)-->


<!--START- Edit Record (MODAL)-->
<div class="modal fade" id="editFire" role="dialog">
    <div class="modal-dialog" style="width: 100%">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header bg-primary">
                <h4 class="modal-title" align="left"><b>Fire - Update Record</b></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Create a Form to edit record -->
            <form action="${pageContext.request.contextPath}/Tabs?action=editTabs&tab=Fire" method="post">
                <div class="modal-body bgColorWhite">
                    <div class="table-responsive" style="width:100%">
                        <div class="well">

                            <div class="panel-default">
                                <div class="panel-body">
                                    <!-- Name  -->
                                    <div class="col-sm-6">
                                        <label for="name">Name:</label>
                                        <input class="form-control" name = "edtFName" id="edtFName" type="text" value="">
                                    </div>
                                    <!-- Attachment -->
                                    <div class="col-sm-6">
                                        <label for="attachment">Attachment:</label>
                                        <input class="form-control" name="edtFAttachment" id="edtFAttachment" type="text" value="">
                                    </div>
                                </div>
                            </div>

                            <div class="panel-default">
                                <div class="panel-body">
                                    <!-- Type  -->
                                    <div class="col-sm-6">
                                        <label for="type">Type:</label>
                                        <input class="form-control" name="edtFType" id="edtFType" type="text" value="">
                                    </div>
                                    <!-- Uploaded By  -->
                                    <div class="col-sm-6">

                                        <input class="form-control" name="edtFUploadedBy" id="edtFUploadedBy" type="hidden" type="text" value="" readOnly>
                                    </div>
                                </div>
                            </div>

                            <div class="panel-default">
                                <div class="panel-body">
                                    <!-- Last Uploaded -->
                                    <div class="col-sm-6">

                                        <input class="form-control" name="edtFLastUploadedBy" id="edtFLastUploadedBy" type="hidden" type="text" value="" readOnly>
                                    </div>
                                </div>
                            </div>

                            <div class="panel-default">
                                <div class="panel-body">
                                    <input class="form-control" name="edtFRecordID" id="edtFRecordID" type="hidden" value="">
                                    <input class="form-control" name="buildingID" id="buildingID" type="hidden" value="">
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <!-- Submit Button -->
                    <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-edit"></span> Update</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-remove"></span> Cancel</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!--END- Edit Record (MODAL)-->

<!--START- Delete (MODAL)-->
<div class="modal fade" id="deleteFire" role="dialog">
    <div class="modal-dialog" style="width: 50%">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header bg-primary">
                <h4 class="modal-title" align="left"><b>Fire - Delete Record</b></h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <!-- Create a Form to delete record -->
            <form action="${pageContext.request.contextPath}/Tabs?action=dltTabs&tab=Fire" method="post">
                <div class="modal-body bgColorWhite">
                    <p> Are you sure you wish to delete one record? </p>
                </div>
                <input class="form-control" name="dltFRecordID" id="dltFRecordID" type="hidden" value="">
                <input class="form-control" name="buildingID" id="buildingID" type="hidden" value="">
                <div class="modal-footer">
                    <!-- Submit Button -->
                    <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-edit"></span> Delete</button>
                    <button type="button" class="btn btn-primary" data-dismiss="modal"><span class="glyphicon glyphicon-eye-close"></span> Close</button>
                </div>
            </form>
        </div>
    </div>
</div>
<!--END- Delete Record (MODAL)-->
