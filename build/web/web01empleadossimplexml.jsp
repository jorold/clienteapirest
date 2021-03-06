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
                    <h1>Empleados XML</h1>
                    <button type="button" class="btn btn-info" id="botoncargar">Cargar empleados XML</button>
                    <ul class="list-group" id="listaempleados">
                        
                    </ul>
                </div>
            </main>
        </section>
        <jsp:include page="includes/webfooter.jsp"/>
        <script>
            $(document).ready(function(){
                $("#botoncargar").click(function(){
                   //comenzamos la lectura del documento
                   $.get("documents/empleados.xml", function(data){
                       //data es el documento xml
                       var apellidos = $(data).find("APELLIDO");
                       //para recorrer todos lo apellidos se utilizan bucles each
                       var html = "";
                       apellidos.each(function(){
                           //this hace referencia a cada etiqueta xml del documento
                           //para recuperar su contenido se utiliza text
                           var apellido = $(this).text();
                           html += "<li class='list-group-item'>" + apellido + "</li>";
                       });
                       $("#listaempleados").html(html);
                   });
                });
            });
        </script>
    </body>
</html>
