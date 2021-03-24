<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="includes/webhead.jsp"/>
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="includes/webmenu.jsp"/>
        <section>
            <main role="main" class="container">
                <div class="starter-template">
                    <h1>Api Hospitales Azure</h1>
                    <label>Id hospital</label>
                    <input type="text" id="cajahospital" class="form-control"/>
                    <button type="button" class="btn btn-info" id="botonbuscarhospital">
                        Buscar Hospital
                    </button>
                    <table class="table table-info" id="tablahospitales">
                        <thead>
                            <tr>
                                <th>Nombre</th>
                                <th>Direccion</th>
                                <th>Teléfono</th>
                                <th>Camas</th>
                            </tr>
                        </thead>
                        <tbody></tbody>
                    </table>
                    <div id="hospital"></div>
                </div>
            </main>
        </section>
        <jsp:include page="includes/webfooter.jsp"/>
        <script>
            var url = "https://apihospitalesxml.azurewebsites.net/";
            $(document).ready(function(){
                $.ajax({
                    url: url + "api/hospitales",
                    type: "GET",
                    dataType: "xml",
                    success: function(data){
                        var hospitales = $(data).find("Hospital");
                        var html = "";
                        hospitales.each(function(){
                            var nombre = $(this).find("Nombre").text();
                            var direccion = $(this).find("Direccion").text();
                            var telefono = $(this).find("Telefono").text();
                            var camas = $(this).find("Camas").text();
                            html += "<tr>";
                            html += "<td>" + nombre + "</td>";
                            html += "<td>" + direccion + "</td>";
                            html += "<td>" + telefono + "</td>";
                            html += "<td>" + camas + "</td>";
                            html += "</tr>";
                        });
                        $("#tablahospitales tbody").html(html);
                    }
                });
                $("#botonbuscarhospital").click(function(){
                    var id = $("#cajahospital").val();
                    var request = "api/hospitales/" + id;
                    $.ajax({
                        url: url + request,
                        type: "GET",
                        dataType: "xml",
                        success: function(data){
                            var hospital = $(data).find("Hospital").first();
                            var html = "<h1>" + $(hospital).find("Nombre").text() + ", " + $(hospital).find("Direccion").text() + "</h1>";
                            $("#hospital").html(html);
                        }
                    });
                });
            });
        </script>
    </body>
</html>
