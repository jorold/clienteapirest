package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class web04cochesbasicosxml_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("                    <h1>Coches básicos XML</h1>\n");
      out.write("                    <button class=\"btn btn-success\" type=\"button\" id=\"getcoches\">\n");
      out.write("                        Mostrar coches get\n");
      out.write("                    </button>\n");
      out.write("                    <ul class=\"list-group\" id=\"coches\">\n");
      out.write("                        \n");
      out.write("                    </ul>\n");
      out.write("                    <button class=\"btn btn-info\" type=\"button\" id=\"ajaxcoches\">\n");
      out.write("                        Mostrar coches ajax\n");
      out.write("                    </button><br/>\n");
      out.write("                    <label>Introduzca dato: </label>\n");
      out.write("                    <input type=\"text\" id=\"cajamarca\" class=\"form-control\"/>\n");
      out.write("                    <button class=\"btn btn-dark\" type=\"button\" id=\"buscarcoches\">\n");
      out.write("                        Mostrar coches ajax\n");
      out.write("                    </button>\n");
      out.write("                </div>\n");
      out.write("            </main>\n");
      out.write("        </section>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "includes/webfooter.jsp", out, false);
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function(){\n");
      out.write("                $(\"#getcoches\").click(function(){\n");
      out.write("                    $.get(\"documents/coches_basicos.xml\", function(data){\n");
      out.write("                       var marca = $(data).find(\"MARCA\");\n");
      out.write("                       var html = \"\";\n");
      out.write("                       marca.each(function(){\n");
      out.write("                           var marca = $(this).text();\n");
      out.write("                           html += \"<li class='list-group-item'>\" + marca + \"</li>\";\n");
      out.write("                       });\n");
      out.write("                       $(\"#coches\").html(html);\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("                $(\"#ajaxcoches\").click(function(){\n");
      out.write("                    $.ajax({\n");
      out.write("                        url: \"documents/coches_basicos.xml\",\n");
      out.write("                        type: \"GET\",\n");
      out.write("                        dataType: \"xml\",\n");
      out.write("                        success: function(data){\n");
      out.write("                            var coches = $(data).find(\"MARCA\");\n");
      out.write("                            var html = \"\";\n");
      out.write("                            coches.each(function(){\n");
      out.write("                                html += \"<li class='list-group-item'>\" + $(this).text() + \"</li>\";\n");
      out.write("                            });\n");
      out.write("                            $(\"#coches\").html(html);\n");
      out.write("                        }\n");
      out.write("                    });\n");
      out.write("                });\n");
      out.write("                $(\"#buscarcoches\").click(function() {\n");
      out.write("                    var marca = $(\"#cajamarca\").val();\n");
      out.write("                    var filtro = \"MARCA:contains(\" + marca + \")\";\n");
      out.write("                    $.ajax({\n");
      out.write("                       url: \"documents/coches_basicos.xml\",\n");
      out.write("                       method: \"GET\", \n");
      out.write("                       dataType: \"xml\", \n");
      out.write("                       success: function(data){\n");
      out.write("                           var coches = $(data).find(filtro);\n");
      out.write("                           var html = \"\";\n");
      out.write("                           coches.each(function() {\n");
      out.write("                              html += \"<li class='list-group-item list-group-item-primary'>\" \n");
      out.write("                              + $(this).text() + \"</li>\";\n");
      out.write("                           });\n");
      out.write("                           $(\"#coches\").html(html);\n");
      out.write("                       }\n");
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
