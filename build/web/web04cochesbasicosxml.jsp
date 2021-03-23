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
                    <h1>Coches básicos XML</h1>
                    <button class="btn btn-success" type="button" id="getcoches">
                        Mostrar coches get
                    </button>
                    <ul class="list-group" id="coches">
                        
                    </ul>
                    <button class="btn btn-info" type="button" id="ajaxcoches">
                        Mostrar coches ajax
                    </button><br/>
                    <label>Introduzca dato: </label>
                    <input type="text" id="cajamarca" class="form-control"/>
                    <button class="btn btn-dark" type="button" id="buscarcoches">
                        Mostrar coches ajax
                    </button>
                </div>
            </main>
        </section>
        <jsp:include page="includes/webfooter.jsp"/>
        <script>
            $(document).ready(function(){
                $("#getcoches").click(function(){
                    $.get("documents/coches_basicos.xml", function(data){
                       var marca = $(data).find("MARCA");
                       var html = "";
                       marca.each(function(){
                           var marca = $(this).text();
                           html += "<li class='list-group-item'>" + marca + "</li>";
                       });
                       $("#coches").html(html);
                    });
                });
                $("#ajaxcoches").click(function(){
                    $.ajax({
                        url: "documents/coches_basicos.xml",
                        type: "GET",
                        dataType: "xml",
                        success: function(data){
                            var coches = $(data).find("MARCA");
                            var html = "";
                            coches.each(function(){
                                html += "<li class='list-group-item'>" + $(this).text() + "</li>";
                            });
                            $("#coches").html(html);
                        }
                    });
                });
                $("#buscarcoches").click(function() {
                    var marca = $("#cajamarca").val();
                    var filtro = "MARCA:contains(" + marca + ")";
                    $.ajax({
                       url: "documents/coches_basicos.xml",
                       method: "GET", 
                       dataType: "xml", 
                       success: function(data){
                           var coches = $(data).find(filtro);
                           var html = "";
                           coches.each(function() {
                              html += "<li class='list-group-item list-group-item-primary'>" 
                              + $(this).text() + "</li>";
                           });
                           $("#coches").html(html);
                       }
                    });
                });
            });
        </script>
    </body>
</html>
