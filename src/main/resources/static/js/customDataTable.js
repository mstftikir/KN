$(document).ready(function () {
    $('#dtContactList').DataTable({
        pagingType: "first_last_numbers",
        responsive: true,
        processing: true,
        ajax: "api/v1/contacts",
        columns: [
            {
                data: "url",
                render: function (data) {
                    return '<img src="' + data + '" class="img-fluid" alt="' + data + '"/>';
                }
            },
            {data: "name"}
        ]
    });
    $('.dataTables_length').addClass('bs-select');
});