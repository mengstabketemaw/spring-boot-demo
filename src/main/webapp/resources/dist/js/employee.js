var EmployeeWizard = function() {
    return {
         init: function () {
            $('#employeeSaveButton').click(function(e) {
                e.preventDefault();

                var formData = {
                    id: $('#employeeId').val(),
                    name: $('#name').val(),
                    email: $('#email').val(),
                    gender: $('#gender').val()
                };


                $.ajax({
                    type: 'POST',
                    url: '/demo/employee',
                    data: formData,
                    success: function(response) {
                        location.href = '/demo';
                    },
                    error: function(xhr, status, error) {
                        console.log('An error occurred: ' + error);
                    }
                });
            });
         }
    }
}

EmployeeWizard().init();