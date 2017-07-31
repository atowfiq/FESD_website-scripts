/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-07-28 17:22:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SingleCompound_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Compound </title>\r\n");
      out.write("\r\n");
      out.write(" <link rel=\"stylesheet\" href=\"css/ChemDoodleWeb.css\" type=\"text/css\">\r\n");
      out.write(" <script type=\"text/javascript\" src=\"js/ChemDoodleWeb.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js\"></script>\r\n");
      out.write("<!-- Latest compiled and minified JavaScript -->\r\n");
      out.write("<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js\" integrity=\"sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<script src=\"js/jquery.tmpl.js\" type=\"text/javascript\"></script> \r\n");
      out.write("<script src=\"https://cdn.plot.ly/plotly-latest.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("$(document).ready(function(){\r\n");
      out.write("\t$.get('SingleCompoundServlet', {\r\n");
      out.write("\t\tId: ");
      out.print(request.getParameter("Id"));
      out.write(" \r\n");
      out.write("\t\t }, function(compound) { \r\n");
      out.write("\t\t\t compound.BSExists=true;\r\n");
      out.write("\t\t\t Compound= compound;\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\tLoadCif(compound.Cif); \r\n");
      out.write("\t\t//\t$(\"#cifViz\").html(new String(compound.Cif));\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t\t $(\"#CompoundName\").text(compound.Formula);\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t \r\n");
      out.write("\t\t//\t $(\"#CompoundDetailsContent\").html('');\t\t\t\r\n");
      out.write("\t\t\t$(\"#CompoundDetailsTemplate\").tmpl(compound).appendTo(\"#CompoundDetailsContent\");\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("});\r\n");
      out.write("function LoadCif(cif)\r\n");
      out.write("{\r\n");
      out.write("\tvar MAZfile = cif;// you can change the 1s here to generate a supercell\r\n");
      out.write("\tvar maz = ChemDoodle.readCIF(MAZfile, 1, 1, 1);\r\n");
      out.write("\r\n");
      out.write("\t//setup component\r\n");
      out.write("\tvar crystalTransformer = new ChemDoodle.TransformCanvas3D('mol-canvas', 500, 500);\r\n");
      out.write("\t// set the atom/bond representation to 'Ball and Stick', although other representations are also useful for zeolites\r\n");
      out.write("\tcrystalTransformer.specs.set3DRepresentation('Ball and Stick');\r\n");
      out.write("\t// set the background color to black\r\n");
      out.write("\tcrystalTransformer.specs.backgroundColor = '#000000';\r\n");
      out.write("\t// declare an orthographic perspective to more easily see the zeolite pattern\r\n");
      out.write("\tcrystalTransformer.specs.projectionPerspective_3D = false;\r\n");
      out.write("\t// set the line widths for the unit cell to be 1.5 pixels\r\n");
      out.write("\tcrystalTransformer.specs.crystals_unitCellLineWidth = 1.5;\r\n");
      out.write("\t// set the unit cell line color to white\r\n");
      out.write("\tcrystalTransformer.specs.shapes_color = 'white';\r\n");
      out.write("\t// set the unit cell line width to 2\r\n");
      out.write("\tcrystalTransformer.specs.shapes_lineWidth = 2;\r\n");
      out.write("\tcrystalTransformer.specs.atoms_displayLabels_3D = true;\r\n");
      out.write("\r\n");
      out.write("\t \r\n");
      out.write("\r\n");
      out.write("\t  \r\n");
      out.write("\t  crystalTransformer.loadContent([maz.molecule], [maz.unitCell]);\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function ViewCIF()\r\n");
      out.write("{\r\n");
      out.write("\tvar s = Compound.Cif.replace(/(?:\\r\\n|\\r|\\n)/g, '<br />');\r\n");
      out.write("\t$('#CompoundFormula').text(Compound.Formula);\t\r\n");
      out.write("\r\n");
      out.write("\t$('#CifModal').modal();\t\r\n");
      out.write("\t$('#content').html(s);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("function DownloadCIF()\r\n");
      out.write("{\r\n");
      out.write("\tvar downloadId;\t\r\n");
      out.write("\tif(Compound.Source ='cod')\r\n");
      out.write("\t\tdownloadId = Compound.CodID;\r\n");
      out.write("\telse\r\n");
      out.write("\t\tdownloadId =  Compound.ICSDID;\r\n");
      out.write("\twindow.location = 'CIFServlet?downloadId='+downloadId+\"&source=\"+Compound.Source;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function ViewCompoundProperties(propType)\r\n");
      out.write("{\r\n");
      out.write("\t$('#CompoundFormulaName').text(Compound.Formula);\t\r\n");
      out.write("\r\n");
      out.write("\tvar src = '../static/View/';\r\n");
      out.write("\tvar srcId = '';\r\n");
      out.write("\tif (Compound.Source=='cod')\r\n");
      out.write("\t\tsrcId  = Compound.CodID;\r\n");
      out.write("\telse \r\n");
      out.write("\t\tsrcId  = Compound.ICSDID;\r\n");
      out.write("\tif(propType=='dos1'){\r\n");
      out.write("\t\tsrc = src + 'dos/'+Compound.Source+'/'+srcId+'100.png';\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\tif(propType=='dos2'){\t\t\r\n");
      out.write("\t\tsrc = src + 'dos/'+Compound.Source+'/'+srcId+'200.png';\r\n");
      out.write("\t}\r\n");
      out.write("\tif(propType=='dos3'){\r\n");
      out.write("\t\tsrc = src + 'dos/'+Compound.Source+'/'+srcId+'300.png';\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\telse if(propType=='bs')\r\n");
      out.write("\t{\r\n");
      out.write("\t//\tsrc = src + 'bandstructure/'+Compound.Source+'/'+srcId+'.spaghetti_ps00.png';\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(propType=='fs')\r\n");
      out.write("\t{\r\n");
      out.write("\t\tsrc = '';\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\telse if(propType=='hf')\r\n");
      out.write("\t{\r\n");
      out.write("\t\tsrc = 'DataImage/hf.png';\r\n");
      out.write("\t\t\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t$('#Viewer').modal();\t\r\n");
      out.write("//\t$('#ViewerContent').html(propType);\r\n");
      out.write("     $('#imagepreview').attr('src', src);   \r\n");
      out.write("     $('#Viewer').modal('show');\r\n");
      out.write("     //$('#Viewer').on('shown.bs.modal', function () {\r\n");
      out.write("    \t//GetBandstructures(Compound.Id);\r\n");
      out.write("    \t//alert('hello');\r\n");
      out.write("    \t//});\r\n");
      out.write("     GetBandstructures(Compound.Id);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script id=\"CompoundDetailsTemplate\"  type=\"text/x-jquery-tmpl\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<td>\r\n");
      out.write("<table class=\"table table-striped\">\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td><strong>Source</strong></td>\t\r\n");
      out.write("\t<td>{{html Source}} - {{if Source == \"cod\"}}{{html CodID}}\r\n");
      out.write("{{/if}}\r\n");
      out.write("{{if Source == \"icsd\"}}{{html ICSDID}}\r\n");
      out.write("{{/if}}\r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td><strong>Formula</strong></td>\t\r\n");
      out.write("\t<td>{{html Formula}}</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td><strong>Space Group</strong></td>\r\n");
      out.write("\t\t<td>{{html SpaceGroup}}</td>\r\n");
      out.write("\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td><strong>Crystal System</strong></td>\r\n");
      out.write("\t\t<td>{{html CrystalSystem}}</td>\r\n");
      out.write("\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td><strong>Space Group Name</strong></td>\r\n");
      out.write("\t\t<td>{{html SpaceGroupName}}</td>\r\n");
      out.write("\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td><strong>Space Group Name Hall</strong></td>\r\n");
      out.write("\t\t<td>{{html SymmetrySpaceGroupNameHall}}</td>\r\n");
      out.write("\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td><strong>Cell Angle Alpha</strong></td>\r\n");
      out.write("\t\t<td>{{html CellAngleAlpha}}</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td><strong>Cell Length A</strong></td>\r\n");
      out.write("\t\t<td>{{html CellLengthA}}</td>\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td><strong>Cell Length B</strong></td>\r\n");
      out.write("\t\t<td>{{html CellLengthB}}</td>\r\n");
      out.write("\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td><strong>Cell Length C</strong></td>\r\n");
      out.write("\t\t<td>{{html CellLengthC}}</td>\r\n");
      out.write("\r\n");
      out.write("</tr>\r\n");
      out.write("<tr>\r\n");
      out.write("\t<td><strong>Volume</strong></td>\r\n");
      out.write("\t\t<td>{{html CellVolume}}</td>\r\n");
      out.write("\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("{{if BSExists}}\r\n");
      out.write("<tr>\r\n");
      out.write("<td><strong>BandStructure</strong></td>\r\n");
      out.write("<td><button style=\"width:180px;\" class=\"btn btn-secondary\" onclick=\"ViewCompoundProperties('bs')\">BandStructure</button></td>\r\n");
      out.write("</tr>\r\n");
      out.write("{{/if}}\t \r\n");
      out.write("\r\n");
      out.write("{{if Dos1Exists}}\r\n");
      out.write("<tr>\r\n");
      out.write("<td><strong>Dos 1</strong></td>\r\n");
      out.write("<td><button style=\"width:180px;\" class=\"btn btn-secondary\" onclick=\"ViewCompoundProperties('dos1')\">Dos 1</button></td>\r\n");
      out.write("</tr>\r\n");
      out.write("{{/if}}\t \r\n");
      out.write("\r\n");
      out.write("{{if Dos2Exists}}\r\n");
      out.write("<tr>\r\n");
      out.write("<td><strong>Dos 2</strong></td>\r\n");
      out.write("<td><button style=\"width:180px;\" class=\"btn btn-secondary\" onclick=\"ViewCompoundProperties('dos2')\">Dos 2</button></td>\r\n");
      out.write("</tr>\r\n");
      out.write("{{/if}}\r\n");
      out.write("{{if Dos3Exists}}\r\n");
      out.write("<tr>\r\n");
      out.write("<td><strong>Dos 3</strong></td>\r\n");
      out.write("<td><button style=\"width:180px;\" class=\"btn btn-secondary\" onclick=\"ViewCompoundProperties('dos3')\">Dos 3</button></td>\r\n");
      out.write("</tr>\r\n");
      out.write("{{/if}}\t \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<tr>\r\n");
      out.write("<td><strong>CIF</strong></td>\r\n");
      out.write("<td>\r\n");
      out.write("<a style=\"cursor: pointer;\" onclick=\"ViewCIF();\">View</a> \r\n");
      out.write("</td>\r\n");
      out.write("</tr>\r\n");
      out.write("\r\n");
      out.write("</table>\r\n");
      out.write("</td>\r\n");
      out.write("\t\r\n");
      out.write("</script>\t\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- Latest compiled and minified CSS -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css\" integrity=\"sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7\" crossorigin=\"anonymous\">\r\n");
      out.write("\r\n");
      out.write("<!-- Optional theme -->\r\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css\" integrity=\"sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r\" crossorigin=\"anonymous\">\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".main{\r\n");
      out.write("margin-top:-40px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".modal .modal-body {\r\n");
      out.write("    max-height: 800px;\r\n");
      out.write("    overflow-y: auto;\r\n");
      out.write("}\r\n");
      out.write(".modal {\r\n");
      out.write("  text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("@media screen and (min-width: 768px) {\r\n");
      out.write("  .modal:before {\r\n");
      out.write("    content: \" \";\r\n");
      out.write("    display: inline-block;\r\n");
      out.write("    height: 100%;\r\n");
      out.write("    vertical-align: middle;\r\n");
      out.write("  }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".modal-dialog {\r\n");
      out.write("  display: inline-block;\r\n");
      out.write("  text-align: center;\r\n");
      out.write("  vertical-align: middle;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("<script>\r\n");
      out.write("function goBack() {\r\n");
      out.write("    window.history.back();\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "topBar.jsp", out, false);
      out.write('\r');
      out.write('\n');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "leftSidebar.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"main\">\r\n");
      out.write("\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "BandstructureChart.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"page-header\">\r\n");
      out.write("\t<h1><span id='CompoundName'></span> </h1>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\t<div style=\"float:right;\"><button class=\"btn btn-secondary\" onclick=\"goBack()\">Go Back</button></div>\t    \r\n");
      out.write("\r\n");
      out.write("\t<div style=\"clear:both;\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\t    <table style=\"padding-top: 10px;\" class=\"table\" >\r\n");
      out.write("\t    <tbody >\r\n");
      out.write("\t   \r\n");
      out.write("\t    <tr id=\"CompoundDetailsContent\"><td></td>\r\n");
      out.write("\t    <td >\r\n");
      out.write("\t    \t <figure> \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t<canvas id=\"mol-canvas\"></canvas>\r\n");
      out.write("  \t\t\t</figure>\r\n");
      out.write("\t    \r\n");
      out.write("\t    </td></tr>\r\n");
      out.write("\t    </tbody>\r\n");
      out.write("\t    </table>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div  id=\"CifModal\"  class=\"modal fade bs-example-modal-lg\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myLargeModalLabel\">\r\n");
      out.write("    <div class=\"modal-dialog modal-lg\">\r\n");
      out.write("     \r\n");
      out.write("      <!-- Modal content-->\r\n");
      out.write("      \r\n");
      out.write("       \r\n");
      out.write("      <div class=\"modal-content\">\r\n");
      out.write("        <div class=\"modal-header\">\r\n");
      out.write("          <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n");
      out.write("          <h4 class=\"modal-title\" id=\"CompoundFormula\"></h4>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"modal-body\">\r\n");
      out.write("       \r\n");
      out.write("<div id=\"content\" ></div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"modal-footer\">\r\n");
      out.write("          <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Close</button>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("      \r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("  \t\r\n");
      out.write("\t\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
