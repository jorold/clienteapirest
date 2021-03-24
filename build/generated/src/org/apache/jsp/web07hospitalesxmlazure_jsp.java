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
      out.write("                    <label>Id hospital</label>\n");
      out.write("                    <input type=\"text\" id=\"cajahospital\" class=\"form-control\"/>\n");
      out.write("                    <button type=\"button\" class=\"btn btn-info\" id=\"botonbuscarhospital\">\n");
      out.write("                        Buscar Hospital\n");
      out.write("                    </button>\n");
      out.write("                    <table class=\"table table-info\" id=\"tablahospitales\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Nombre</th>\n");
      out.write("                                <th>Direccion</th>\n");
      out.write("                                <th>Teléfono</th>\n");
      out.write("                                <th>Camas</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody></tbody>\n");
      out.write("                    </table>\n");
      out.write("                    <div id=\"hospital\"></div>\n");
      out.write("                </div>\n");
      out.write("            </main>\n");
      out.write("        </section>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "includes/webfooter.jsp", out, false);
      out.write("\n");
      out.write("        <script>\n");
      out.write("            var url = \"https://apihospitalesxml.azurewebsites.net/\";\n");
      out.write("            $(document).ready(function(){\n");
      out.write("                $.ajax({\n");
      out.write("                    url: url + \"api/hospitales\",\n");
      out.write("                    type: \"GET\",\n");
      out.write("                    dataType: \"xml\",\n");
      out.write("                    success: function(data){\n");
      out.write("                        var hospitales = $(data).find(\"Hospital\");\n");
      out.write("                        var html = \"\";\n");
      out.write("                        hospitales.each(function(){\n");
      out.write("                            var nombre = $(this).find(\"Nombre\").text();\n");
      out.write("                            var direccion = $(this).find(\"Direccion\").text();\n");
      out.write("                            var telefono = $(this).find(\"Telefono\").text();\n");
      out.write("                            var camas = $(this).find(\"Camas\").text();\n");
      out.write("                            html += \"<tr>\";\n");
      out.write("                            html += \"<td>\" + nombre + \"</td>\";\n");
      out.write("                            html += \"<td>\" + direccion + \"</td>\";\n");
      out.write("                            html += \"<td>\" + telefono + \"</td>\";\n");
      out.write("                            html += \"<td>\" + camas + \"</td>\";\n");
      out.write("                            html += \"</tr>\";\n");
      out.write("                        });\n");
      out.write("                        $(\"#tablahospitales tbody\").html(html);\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                $(\"#botonbuscarhospital\").click(function(){\n");
      out.write("                    var id = $(\"#cajahospital\").val();\n");
      out.write("                    var request = \"api/hospitales/\" + id;\n");
      out.write("                    $.ajax({\n");
      out.write("                        url: url + request,\n");
      out.write("                        type: \"GET\",\n");
      out.write("                        dataType: \"xml\",\n");
      out.write("                        success: function(data){\n");
      out.write("                            var hospital = $(data).find(\"Hospital\").first();\n");
      out.write("                            var html = \"<h1>\" + $(hospital).find(\"Nombre\").text() + \", \" + $(hospital).find(\"Direccion\").text() + \"</h1>\";\n");
      out.write("                            $(\"#hospital\").html(html);\n");
      out.write("                        }\n");
      out.write("                    });\n");
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
