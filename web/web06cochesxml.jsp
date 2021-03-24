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
                    <h1>Coches XML</h1>
                    <label>Seleccione una marca</label>
                    <select class="form-control" id="selectcoches"></select>
                    <div id="cocheseleccionado"></div>
                </div>
            </main>
        </section>
        <jsp:include page="includes/webfooter.jsp"/>
        <script>
            $(document).ready(function(){
                $.ajax({
                    url: "documents/coches.xml",
                    type: "GET",
                    dataType: "xml",
                    success: function(data){
                        var coches = $(data).find("coche");
                        var html = "";
                        coches.each(function(){
                            var id = $(this).find("idcoche").text();
                            var marca = $(this).find("marca").text();
                            html += "<option value='" + id + "'>" + marca + "</option>";
                        });
                        $("#selectcoches").html(html);
                    }
                });
                $("#selectcoches").change(function(){
                    var id = $("#selectcoches").val();
                    var filtro = "idcoche:contains(" + id + ")";
                    $.ajax({
                        url: "documents/coches.xml",
                        type: "GET",
                        dataType: "xml",
                        success: function(data){
                            var elementoidcoche = $(data).find(filtro).first();
                            //tenemos el idcoche que es el primer elemento de la etiqueta coche
                            //para sacar los datos necesitamos la etiqueta coche por lo que 
                            //tenemos que subir un nivel para recuperar todos los datos del coche
                            //que contiene la etiqueta coche
                            //para subir necesitamos usar parent()
                            var coche = $(elementoidcoche).parent();
                            var marca = $(coche).find("marca").text()
                            + " " + $(coche).find("modelo").text();
                            var imagen = $(coche).find("imagen").text();
                            var html = "<h1 style='color:red'>"
                            + marca + "</h1>";
                            html += "<img src='" + imagen 
                                    + "' style='width:400px;height:300px;'/>";
                            $("#cocheseleccionado").html(html);
                        }
                    });
                });
            });
        </script>
    </body>
</html>

