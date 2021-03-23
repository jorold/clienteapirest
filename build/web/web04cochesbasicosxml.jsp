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
                    <ul class="list-group" id="listamarca">
                        
                    </ul>
                    <button class="btn btn-info" type="button" id="ajaxcoches">
                        Mostrar coches ajax
                    </button>
                    <ul class="list-group" id="ajaxlistamarca">
                        
                    </ul>
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
                       $("#listamarca").html(html);
                    });
                });
            });
        </script>
    </body>
</html>
