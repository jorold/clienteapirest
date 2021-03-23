package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class web03busquedadocumentosxml_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                    <h1>Búsqueda documentos XML</h1>\n");
      out.write("                    <label>Introduzca código hospital</label>\n");
      out.write("                    <input type=\"text\" id=\"cajacodigo\" class=\"form-control\"/>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-info\" id=\"botonhospitales\">Buscar hospital atributo</button>\n");
      out.write("                    <hr/>\n");
      out.write("                    <label>Introduzca apellido</label>\n");
      out.write("                    <input type=\"text\" id=\"cajaapellido\" class=\"form-control\"/>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-danger\" id=\"botonempleados\">Buscar empleados tag</button>\n");
      out.write("                    <div id=\"hospital\"></div>\n");
      out.write("                    <div id=\"empleados\"></div>\n");
      out.write("                </div>\n");
      out.write("            </main>\n");
      out.write("        </section>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "includes/webfooter.jsp", out, false);
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function(){\n");
      out.write("                $(\"#botonhospitales\").click(function(){\n");
      out.write("                   $.get(\"documents/hospital_atributos.xml\", function(data){\n");
      out.write("                       //dentro de estos datos hay que extraer los que sean de un determinado hospital\n");
      out.write("                       var codigo = $(\"#cajacodigo\").val();\n");
      out.write("                       var filtro = \"HOSPITAL[HOSPITAL_COD=\" + codigo + \"]\";\n");
      out.write("                       //para buscar dentro de data se usa find\n");
      out.write("                       //aunque busquemos solo un dato siempre devuelve un conjunto\n");
      out.write("                       var hospitales = $(data).find(filtro);\n");
      out.write("                       if(hospitales.length == 0){\n");
      out.write("                           $(\"#hospital\").html(\"<h1 style='color:red'>No existen hospitales</h1>\");\n");
      out.write("                       }else{\n");
      out.write("                           var hospital = hospitales.first();\n");
      out.write("                           $(\"#hospital\").html(\"<h1>Nombre: \"\n");
      out.write("                                   + hospital.attr(\"NOMBRE\")\n");
      out.write("                                   + \", Dirección: \"\n");
      out.write("                                   + hospital.attr(\"DIRECCION\")\n");
      out.write("                                   + \"</h1>\");\n");
      out.write("                       }\n");
      out.write("                   });\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("            $(document).ready(function(){\n");
      out.write("                $(\"#botonempleados\").click(function(){\n");
      out.write("                   //con ajax\n");
      out.write("                   $.ajax({\n");
      out.write("                       url: \"documents/empleados.xml\",\n");
      out.write("                       method: \"GET\",\n");
      out.write("                       dataType: \"xml\",\n");
      out.write("                       success: function(data){\n");
      out.write("                           var ape = $(\"#cajaapellido\").val();\n");
      out.write("                           var filtro = \"APELLIDO:contains(\" + ape + \")\";\n");
      out.write("                           var empleados = $(data).find(filtro);\n");
      out.write("                           var html = \"\";\n");
      out.write("                           empleados.each(function(){\n");
      out.write("                              html += \"<h1>\" + $(this).text() + \"</h1>\"; \n");
      out.write("                           });\n");
      out.write("                           $(\"#empleados\").html(html);\n");
      out.write("                       }\n");
      out.write("                   });\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
