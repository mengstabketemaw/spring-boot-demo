<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table thin-table table-bordered table-hover dataTable no-footer" id=employeeList_tbl role=grid aria-describedby=employeeList_tbl_info style=width:1592px>
    <thead>
    <tr role=row>
        <th class="h6 sorting_disabled" rowspan=1 colspan=1 aria-label=" x" style=width:101px><span
                id=checkedEmpDisp></span> <a href=# id=chkEmpClr title=clear style=display:none>x</a>
        <th class=sorting_asc tabindex=0 aria-controls=employeeList_tbl rowspan=1 colspan=1 aria-sort=ascending
            aria-label="Name: activate to sort column descending" style=width:232px>Name
        <th class=sorting tabindex=0 aria-controls=employeeList_tbl rowspan=1 colspan=1
            aria-label="Employee Id: activate to sort column ascending" style=width:319px>Email
        <th class=sorting tabindex=0 aria-controls=employeeList_tbl rowspan=1 colspan=1
            aria-label="Department: activate to sort column ascending" style=width:333px>Gender
        <th class=sorting tabindex=0 aria-controls=employeeList_tbl rowspan=1 colspan=1
            aria-label="Status: activate to sort column ascending" style=width:207px>Place Of birth
        <th class="details-control sorting_disabled" rowspan=1 colspan=1 aria-label style=width:170px>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${allemplist}">
        <tr>
            <td>
                <div class="checker">
                    <div class="ckEmpLst w-auto">
                        <input type="checkbox" name="checkBoxDep" class="checkboxInput no-sort" value="false">
                    </div>
                </div>
            </td>
            <td>${employee.name}</td>
            <td>${employee.email}</td>
            <td>${employee.gender}</td>
            <td class="editVw du_hand">${employee.placeOfBirth}</td>
            <td>
                <a href="employee/${employee.id}" class="label label-lg label-inline my-1 btn-secondary">Update</a>
                <a href="deleteEmployee/${employee.id}" class="label label-lg label-inline my-1 btn-danger">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

