package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class web05departamentosxml_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                    <h1>Departamentos XML</h1>\n");
      out.write("                    <select class=\"form-control\" id=\"selectdepartamentos\"></select>\n");
      out.write("                    <button class=\"btn btn-info\" id=\"botonbuscar\" type=\"button\">\n");
      out.write("                        Buscar departamento\n");
      out.write("                    </button>\n");
      out.write("                    <div id=\"departamento\"></div>\n");
      out.write("                    <ul class=\"list-group\" id=\"departamentos\"></ul>\n");
      out.write("                </div>\n");
      out.write("            </main>\n");
      out.write("        </section>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "includes/webfooter.jsp", out, false);
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function(){\n");
      out.write("                cargarDepartamentos();\n");
      out.write("                $.ajax({\n");
      out.write("                    url: \"documents/departamentosatributos.xml\",\n");
      out.write("                    type: \"GET\",\n");
      out.write("                    dataType: \"xml\",\n");
      out.write("                    success: function(data){\n");
      out.write("                        var departamentos = $(data).find(\"DEPT\");\n");
      out.write("                        var html = \"\";\n");
      out.write("                        departamentos.each(function(){\n");
      out.write("                            var num = $(this).attr(\"DEPT_NO\");\n");
      out.write("                            html += \"<option value='\" + num + \"'>\" + num + \"</option>\";\n");
      out.write("                        });\n");
      out.write("                        $(\"#selectdepartamentos\").html(html);\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                //$(\"#botonbuscar\").click(function(){ se puede obviar el boton y que pinte el departamento que elijamos en el select\n");
      out.write("                $(\"#selectdepartamentos\").change(function(){\n");
      out.write("                    var numero = $(\"#selectdepartamentos\").val();\n");
      out.write("                    var filtro = \"DEPT[DEPT_NO=\" + numero + \"]\";\n");
      out.write("                    $.ajax({\n");
      out.write("                       url: \"documents/departamentosatributos.xml\",\n");
      out.write("                       type: \"GET\",\n");
      out.write("                       dataType: \"xml\",\n");
      out.write("                       success: function(data){\n");
      out.write("                           var departamento = $(data).find(filtro).first();\n");
      out.write("                           var nombre = $(departamento).find(\"DNOMBRE\").text();\n");
      out.write("                           var localidad = $(departamento).find(\"LOC\").text();\n");
      out.write("                           $(\"#departamento\").html(\"<h1>\" + nombre + \", \" + localidad + \"</h1>\");\n");
      out.write("                       }\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            function cargarDepartamentos(){\n");
      out.write("                $.ajax({\n");
      out.write("                    url: \"documents/departamentosatributos.xml\",\n");
      out.write("                    type: \"GET\",\n");
      out.write("                    dataType: \"xml\",\n");
      out.write("                    success: function(data){\n");
      out.write("                        var departamentos = $(data).find(\"DEPT\");\n");
      out.write("                        var html = \"\";\n");
      out.write("                        departamentos.each(function(){\n");
      out.write("                            var nombre = $(this).find(\"DNOMBRE\").text();\n");
      out.write("                            var localidad = $(this).find(\"LOC\").text();\n");
      out.write("                            html += \"<li class='list-group-item'>\" + nombre + \", \" + localidad + \"</li>\";\n");
      out.write("                        });\n");
      out.write("                        $(\"#departamentos\").html(html);\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            }\n");
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
