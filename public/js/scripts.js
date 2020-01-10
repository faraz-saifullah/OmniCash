$(document).ready(function () {
  $("#allUsers").click(function () {
    $.ajax({
      type: 'get',
      url: '/app/users/',
      dataType: 'json',
      contentType: "application/json",
      success: function (data) {
        $("merror").append(JSON.stringify(data));
        console.log(data);
        // window.location = "/app/users";
      }
    });
  });

  var uuId,uuName,uuEmail,uuPass;
  $("#viewUser").click(function () {
    $.ajax({
      type: 'get',
      url: '/app/profile',
      dataType: 'json',
      contentType: "application/json",
      success: function (data) {
        $("#u_id").text(data.id);
        $("#u_name").text(data.name);
        $("#u_email").text(data.email);
        $("#u_password").text(data.password);
      }
    }); 
  });

  $("#viewUser1").click(function () {
    $.ajax({
      type: 'get',
      url: '/app/profile',
      dataType: 'json',
      contentType: "application/json",
      success: function (data) {
        uuId = data.id;
        uuName = data.name;
        uuEmail = data.email;
        uuPass = data.Pass;
        $("#uu_id").text(data.id);
        $("#uu_name").text(data.name);
        $("#uu_email").text(data.email);
        $("#uu_password").text(data.password);
      }
    }); 
  });

  $("#updateUser").click(function () {
    // alert("=============");
    console.log("==================");
    var id = $("#uu_id").text();
    console.log(id);
    var data = {
      name: $("#uu_name").text(),
      email: $("#uu_email").text(),
      password: $("#uu_password").text()
    }
    console.log(data);
    $.ajax({
      type: 'PUT',
      url: '/app/users/'+id,
      contentType: 'application/json',
      data: JSON.stringify(data),
    }).done(function () {
      alert("Profile Updated!");
    });
  });

  $("#deleteUser").click(function () {
    var id = $("#userId1").val();
    console.log(id);
    var link = '/app/users/' + id;
    $.ajax({
      type: 'delete',
      url: link,
      dataType: 'json',
      contentType: "application/json",
      success: function (data) {
        console.log(data);
        window.location = '/home';
      }
    });
  });

  $("#submitUser").click(function () {
    var id = $("#userId").val();
    var link = '/app/users/' + id;
    $.ajax({
      type: 'get',
      url: link,
      dataType: 'json',
      contentType: "application/json",
      success: function (data) {
        console.log(data);
        window.location = link;
      }
    });
  });

})