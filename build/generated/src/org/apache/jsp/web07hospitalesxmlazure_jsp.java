package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class web07hospitalesxmlazure_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "includes/webhead.jsp", out, false);
      out.write("\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "includes/webmenu.jsp", out, false);
      out.write("\n");
      out.write("        <section>\n");
      out.write("            <main role=\"main\" class=\"container\">\n");
      out.write("                <div class=\"starter-template\">\n");
      out.write("                    <h1>Api Hospitales Azure</h1>\n");
      out.write("                    <label>Id Hospital</label>\n");
      out.write("                    <input type=\"text\" id=\"cajahospital\"\n");
      out.write("                           class=\"form-control\"/>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-info\" id=\"botonbuscarhospital\">\n");
      out.write("                        Buscar Hospital\n");
      out.write("                    </button>\n");
      out.write("                    <hr/>\n");
      out.write("                    <div id=\"divbotones\">\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-warning\"\n");
      out.write("                            id=\"botondoctores\" value=\"22\">\n");
      out.write("                        Doctores La Paz\n");
      out.write("                    </button>\n");
      out.write("                    <table class=\"table table-info\" id=\"tablahospitales\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Nombre</th>\n");
      out.write("                                <th>Dirección</th>\n");
      out.write("                                <th>Teléfono</th>\n");
      out.write("                                <th>Camas</th>\n");
      out.write("                                <th></th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody></tbody>\n");
      out.write("                    </table>\n");
      out.write("                    <div id=\"hospital\"></div>\n");
      out.write("                    <ul class=\"list-group\" id=\"doctores\"></ul>\n");
      out.write("                </div>\n");
      out.write("            </main><!-- /.container -->            \n");
      out.write("        </section>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "includes/webfooter.jsp", out, false);
      out.write("\n");
      out.write("        <script>\n");
      out.write("            var url = \"https://apihospitalesxml.azurewebsites.net/\";\n");
      out.write("            $(document).ready(function(){\n");
      out.write("                //LAS PETICIONES SEGUIRAN SIENDO MEDIANTE URL\n");
      out.write("                //PERO LA URL SUELE SER LA MISMA PARA TODAS LAS PETICIONES\n");
      out.write("                //LO QUE CAMBIA ES EL REQUEST, ES DECIR, LOS DATOS QUE\n");
      out.write("                //DESEAMOS RECUPERAR.\n");
      out.write("                //NORMALMENTE, SE DECLARA LA URL A NIVEL DE SCRIPT\n");
      out.write("                //PARA TODOS LOS METODOS\n");
      out.write("                $.ajax({\n");
      out.write("                    url: url + \"api/hospitales\",\n");
      out.write("                    type: \"GET\",\n");
      out.write("                    dataType: \"xml\", \n");
      out.write("                    success: function(data){\n");
      out.write("                        var hospitales = $(data).find(\"Hospital\");\n");
      out.write("                        var html = \"\";\n");
      out.write("                        hospitales.each(function(){\n");
      out.write("                            var nombre = $(this).find(\"Nombre\").text();\n");
      out.write("                            var direccion = $(this).find(\"Direccion\").text();\n");
      out.write("                            var tlf = $(this).find(\"Telefono\").text();\n");
      out.write("                            var camas = $(this).find(\"Camas\").text();\n");
      out.write("                            html += \"<tr>\";\n");
      out.write("                            html += \"<td>\" + nombre + \"</td>\";\n");
      out.write("                            html += \"<td>\" + direccion + \"</td>\";\n");
      out.write("                            html += \"<td>\" + tlf + \"</td>\";\n");
      out.write("                            html += \"<td>\" + camas + \"</td>\";\n");
      out.write("                            html += \"<td>\";\n");
      out.write("                            //SI DESEAMOS QUE CONTROLES DIBUJADOS DINAMICAMENTE TENGAN\n");
      out.write("                            //EVENTOS, DEBEMOS GENERAR CONTROLES CON JQUERY\n");
      out.write("                            //NO HACIENDO UN STRING, QUE ES LO QUE HEMOS HECHO ANTES.\n");
      out.write("                            //PARA CREAR CONTROLES, SE UTILIZA LA SIGUIENTE SINTAXIS:\n");
      out.write("                            //var control = $(\"<TAG>\")\n");
      out.write("                            var boton = $(\"<button>\");\n");
      out.write("                            //AL CONTROL, PODEMOS AGREGAR TODO LO QUE DESEEMOS\n");
      out.write("                            //UNA CLASE DE ESTILO\n");
      out.write("                            boton.addClass(\"btn btn-success\");\n");
      out.write("                            //PODEMOS AGREGAR UN TEXTO\n");
      out.write("                            boton.text(\"Doctores de \" + nombre);\n");
      out.write("                            //UN VALUE\n");
      out.write("                            boton.val($(this).find(\"IdHospital\").text());\n");
      out.write("                            //PERO, LO QUE LE FALTA AL BOTON ES UNA ACCION (click)\n");
      out.write("                            boton.click(function()  {\n");
      out.write("                               //ACCIONES\n");
      out.write("                               //QUE QUEREMOS HACER CUANDO PULSEMOS UN BOTON??\n");
      out.write("                               //MOSTRAR LOS DOCTORES...DE UN HOSPITAL\n");
      out.write("                               var idhospital = $(this).val();\n");
      out.write("                               //PARA NO TENER TANTO CODIGO EN UN MISMO SITIO\n");
      out.write("                               //PODEMOS CREAR UNA FUNCION QUE DIBUJARA LOS DOCTORES\n");
      out.write("                               mostrarDoctoresHospital(idhospital);\n");
      out.write("                            });\n");
      out.write("                            //DIBUJAR EL BOTON EN ALGUN LUGAR, SE REALIZA MEDIANTE\n");
      out.write("                            // Parent.append(control);\n");
      out.write("                            $(\"#divbotones\").append(boton);\n");
      out.write("                            //LA RAZON PORQUE NO DIBUJA EL BOTON EN LA TABLA\n");
      out.write("                            //1) AÑADE EL BOTON A LA TABLA\n");
      out.write("                            //$(\"#tablahospitales tbody\").append(boton);\n");
      out.write("                            html += \"</td>\";\n");
      out.write("                            html += \"</tr>\";\n");
      out.write("                        });\n");
      out.write("                        //2) QUE HACEMOS EN LA SIGUIENTE LINEA????\n");
      out.write("                        //ESTA LINEA PONE EL CONTENIDO HTML DENTRO DE LA TABLA\n");
      out.write("                        //CON LO CUAL, QUITA LOS BOTONES...\n");
      out.write("                        $(\"#tablahospitales tbody\").html(html);\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                $(\"#botonbuscarhospital\").click(function(){\n");
      out.write("                    var id = $(\"#cajahospital\").val();\n");
      out.write("                    //ANTES, HEMOS ESTADO LEYENDO TODOS LOS DATOS DE LOS\n");
      out.write("                    //ELEMENTOS, BUSCANDO COINCIDENCIAS.\n");
      out.write("                    //ESO NO ESTA MAL, PERO EN LOS SERVICIOS (SI LO TIENEN)\n");
      out.write("                    //SUELEN EXISTIR METODOS DE BUSQUEDA\n");
      out.write("                    //SI LO TIENEN, LO MEJOR ES LLAMARLOS Y SINO, COMO LO \n");
      out.write("                    //HEMOS REALIZADO ANTES, BUSCANDO EN LOS DOCUMENTOS.\n");
      out.write("                    var request = \"api/hospitales/\" + id;\n");
      out.write("                    $.ajax({\n");
      out.write("                       url: url + request,\n");
      out.write("                       type: \"GET\",\n");
      out.write("                       dataType: \"xml\",\n");
      out.write("                       success: function(data){\n");
      out.write("                           var hospital = $(data).find(\"Hospital\").first();\n");
      out.write("                           var html = \"<h1 style='color:red'>\"\n");
      out.write("                           + $(hospital).find(\"Nombre\").text() \n");
      out.write("                           + \", \" \n");
      out.write("                           + $(hospital).find(\"Direccion\").text()\n");
      out.write("                           + \"</h1>\";\n");
      out.write("                           $(\"#hospital\").html(html);\n");
      out.write("                       }\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("                \n");
      out.write("                $(\"#botondoctores\").click(function() {\n");
      out.write("                   //NECESITAMOS EL CODIGO DE HOSPITAL\n");
      out.write("                   //RECUPERAMOS EL CODIGO DEL BOTON PULSADO\n");
      out.write("                   var idhospital = $(this).val();\n");
      out.write("                   //NECESITAMOS SABER LA PETICION DONDE ESTARAN LOS DOCTORES\n");
      out.write("                   var request = \"api/doctoreshospital/\" + idhospital;\n");
      out.write("                   $.ajax({\n");
      out.write("                      url: url + request,\n");
      out.write("                      type: \"GET\",\n");
      out.write("                      dataType: \"xml\",\n");
      out.write("                      success: function(data){\n");
      out.write("                          var doctores = $(data).find(\"Doctor\");\n");
      out.write("                          var html = \"\";\n");
      out.write("                          doctores.each(function() {\n");
      out.write("                             html += \"<li class='list-group-item'>\" \n");
      out.write("                             + $(this).find(\"Apellido\").text() + \"</li>\";\n");
      out.write("                          });\n");
      out.write("                          $(\"#doctores\").html(html);\n");
      out.write("                      }\n");
      out.write("                   });\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            function mostrarDoctoresHospital(idhospital){\n");
      out.write("                //NECESITAMOS SABER LA PETICION DONDE ESTARAN LOS DOCTORES\n");
      out.write("                   var request = \"api/doctoreshospital/\" + idhospital;\n");
      out.write("                   $.ajax({\n");
      out.write("                      url: url + request,\n");
      out.write("                      type: \"GET\",\n");
      out.write("                      dataType: \"xml\",\n");
      out.write("                      success: function(data){\n");
      out.write("                          var doctores = $(data).find(\"Doctor\");\n");
      out.write("                          var html = \"\";\n");
      out.write("                          doctores.each(function() {\n");
      out.write("                             html += \"<li class='list-group-item'>\" \n");
      out.write("                             + $(this).find(\"Apellido\").text() + \"</li>\";\n");
      out.write("                          });\n");
      out.write("                          $(\"#doctores\").html(html);\n");
      out.write("                      }\n");
      out.write("                   });\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
