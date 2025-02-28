<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form:form method="post" modelAttribute="employee" cssClass="col-md-10">
<div class="col-md-10" id="empId">
    <form:hidden path="id" id="employeeId" class="form-control"/>
    <div class="tab-pane tabbable-custom" id="tab_2_1_id">
        <ul class="nav nav-tabs">
            <li class="nav-item"><a href="#" class="nav-link active">Personal Detail</a></li>
        </ul>
        <div class="tab-content tab-Class1">
            <div class="tab-pane active" id="tab_2_1">
                <div class="form-body">

                    <div class="row">
                        <div class="col-md-6">

                            <div class="form-group">
                                <label class="control-label col-md-4" for="name">Name<span class="required">*</span></label>
                                <div class="col-md-8">
                                    <form:input path="name" id="name" class="form-control"/>
                                </div>
                            </div>

                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label col-md-4">Email</label>
                                <div class="col-md-8">
                                    <form:input path="email" id="email" class="form-control"/>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label col-md-4">Gender<span class="required">*</span></label>
                                <div class="col-md-8">
                                    <form:select path="gender" class="form-control">
                                        <form:option value="M">Male</form:option>
                                        <form:option value="F">Female</form:option>
                                    </form:select>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label class="control-label col-md-4">Place of Birth</label>
                                <div class="col-md-8">
                                    <form:input path="placeOfBirth" id="placeOfBirth" class="form-control"/>
                                </div>
                            </div>
                        </div>
                    </div>



                    <div class="accordion accordion-toggle-arrow" id="accordion2">
                        <div class="card">
                            <div class="card-header">
                                <div class="card-title py-3 collapsed" data-toggle="collapse" data-target="#collapseOne1">
                                    Address
                                </div>
                            </div>
                        </div>
                    </div>
                    <br>
                    <div class="accordion accordion-toggle-arrow" id="accordion1">
                        <div class="card">
                            <div class="card-header">
                                <div class="card-title py-3 collapsed" data-toggle="collapse" data-target="#collapseOne2">
                                    Emergency Address
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="form-actions fluid">
        <div class="row justify-content-between ml-2">
            <div class="col-md-4 col-sm-4">
                <button type="submit" id="employeeSaveButton" class="btn btn-success allowed ml-2">Save</button>
                <a href="${pageContext.request.contextPath}/" class="btn btn-secondary allowed">Close</a>
            </div>
        </div>
    </div>
</div>

</form:form>