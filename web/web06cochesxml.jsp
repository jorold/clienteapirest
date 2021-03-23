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
                
            });
        </script>
    </body>
</html>

