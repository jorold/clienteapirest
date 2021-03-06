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
                    <h1>Departamentos XML</h1>
                    <select class="form-control" id="selectdepartamentos"></select>
                    <button class="btn btn-info" id="botonbuscar" type="button">
                        Buscar departamento
                    </button>
                    <div id="departamento"></div>
                    <ul class="list-group" id="departamentos"></ul>
                </div>
            </main>
        </section>
        <jsp:include page="includes/webfooter.jsp"/>
        <script>
            $(document).ready(function(){
                cargarDepartamentos();
                $.ajax({
                    url: "documents/departamentosatributos.xml",
                    type: "GET",
                    dataType: "xml",
                    success: function(data){
                        var departamentos = $(data).find("DEPT");
                        var html = "";
                        departamentos.each(function(){
                            var num = $(this).attr("DEPT_NO");
                            html += "<option value='" + num + "'>" + num + "</option>";
                        });
                        $("#selectdepartamentos").html(html);
                    }
                });
                //$("#botonbuscar").click(function(){ se puede obviar el boton y que pinte el departamento que elijamos en el select
                $("#selectdepartamentos").change(function(){
                    var numero = $("#selectdepartamentos").val();
                    var filtro = "DEPT[DEPT_NO=" + numero + "]";
                    $.ajax({
                       url: "documents/departamentosatributos.xml",
                       type: "GET",
                       dataType: "xml",
                       success: function(data){
                           var departamento = $(data).find(filtro).first();
                           var nombre = $(departamento).find("DNOMBRE").text();
                           var localidad = $(departamento).find("LOC").text();
                           $("#departamento").html("<h1>" + nombre + ", " + localidad + "</h1>");
                       }
                    });
                });
            });
            
            function cargarDepartamentos(){
                $.ajax({
                    url: "documents/departamentosatributos.xml",
                    type: "GET",
                    dataType: "xml",
                    success: function(data){
                        var departamentos = $(data).find("DEPT");
                        var html = "";
                        departamentos.each(function(){
                            var nombre = $(this).find("DNOMBRE").text();
                            var localidad = $(this).find("LOC").text();
                            html += "<li class='list-group-item'>" + nombre + ", " + localidad + "</li>";
                        });
                        $("#departamentos").html(html);
                    }
                });
            }
        </script>
    </body>
</html>
