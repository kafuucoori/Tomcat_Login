var ids = document.getElementsByName('ids');

function query() {
    document.queryForm.submit();
}

function checkAll() {

    for (var i = 0; i < ids.length; i++) {
        ids[i].checked = true;
    }

}

function reverseCheck() {

    for (var i = 0; i < ids.length; i++) {
        ids[i].checked = false;
    }

}

function deleteAll() {

    var con = confirm("是否全部删除？");
    var newIds = new Array();
    var j = 0;

    if (con == true) {

        for (var i = 0; i < ids.length; i++) {
            if (ids[i].checked) {
                newIds[j] = ids[i].value;
                j++;
            }
        }

        if (newIds.length > 0) {
            location.href = "/Tomcat_Login/checkboxdel?ids=" + newIds;
        }

    }

}