package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class web02hospitalatributosxml_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                    <h1>Hospital XML Atributos</h1>\n");
      out.write("                    <button type=\"button\" id=\"botonhospitales\" class=\"btn btn-success\">\n");
      out.write("                        Cargar hospitales\n");
      out.write("                    </button>\n");
      out.write("                    <table class=\"table table-bordered\" id=\"tablahospitales\">\n");
      out.write("                        <thead>\n");
      out.write("                            <tr>\n");
      out.write("                                <th>Nombre</th>\n");
      out.write("                                <th>Dirección</th>\n");
      out.write("                                <th>Teléfono</th>\n");
      out.write("                                <th>Camas</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody></tbody>\n");
      out.write("                    </table>\n");
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
      out.write("                       var hospitales = $(data).find(\"HOSPITAL\");\n");
      out.write("                       var html = \"\";\n");
      out.write("                       hospitales.each(function(){\n");
      out.write("                          html += \"<tr>\";\n");
      out.write("                          html += \"<td>\" + $(this).attr(\"NOMBRE\") + \"</td>\";\n");
      out.write("                          html += \"<td>\" + $(this).attr(\"DIRECCION\") + \"</td>\";\n");
      out.write("                          html += \"<td>\" + $(this).attr(\"TELEFONO\") + \"</td>\";\n");
      out.write("                          html += \"<td>\" + $(this).attr(\"NUM_CAMA\") + \"</td>\";\n");
      out.write("                          html += \"</tr>\";\n");
      out.write("                       });\n");
      out.write("                       $(\"#tablahospitales tbody\").html(html);\n");
      out.write("                   });\n");
      out.write("                });\n");
      out.write("            }); \n");
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
