/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.38
 * Generated at: 2023-02-24 09:25:50 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.mall;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.apache.ibatis.reflection.SystemMetaObject;
import com.ds.damin.mall.MallDto;
import java.util.List;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/mall/../include/css.jsp", Long.valueOf(1677215857568L));
    _jspx_dependants.put("/WEB-INF/views/mall/../include/nav.jsp", Long.valueOf(1677212829700L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("org.apache.ibatis.reflection.SystemMetaObject");
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.ds.damin.mall.MallDto");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"ko\">\n");
      out.write("\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <meta content=\"width=device-width, initial-scale=1.0\" name=\"viewport\">\n");
      out.write("\n");
      out.write("  <title>MyPortfolio Bootstrap Template - Index</title>\n");
      out.write("  <meta content=\"\" name=\"description\">\n");
      out.write("  <meta content=\"\" name=\"keywords\">\n");
      out.write('\r');
      out.write('\n');

String ctx=request.getContextPath();
request.setAttribute("ctx", ctx);

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("  <meta content=\"\" name=\"description\">\r\n");
      out.write("  <meta content=\"\" name=\"keywords\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Favicons -->\r\n");
      out.write("  <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/img/favicon.png\" rel=\"icon\">\r\n");
      out.write("  <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/img/apple-touch-icon.png\" rel=\"apple-touch-icon\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Google Fonts -->\r\n");
      out.write("  <link href=\"https://fonts.googleapis.com/css?family=https://fonts.googleapis.com/css?family=Inconsolata:400,500,600,700|Raleway:400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Vendor CSS Files -->\r\n");
      out.write("  <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/vendor/aos/aos.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/vendor/bootstrap/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/vendor/bootstrap-icons/bootstrap-icons.css\" rel=\"stylesheet\">\r\n");
      out.write("  <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/vendor/swiper/swiper-bundle.min.css\" rel=\"stylesheet\">\r\n");
      out.write("\r\n");
      out.write("  <!-- Template Main CSS File -->\r\n");
      out.write("  <link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("  \r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js\"></script>\r\n");
      out.write("  <!-- =======================================================\r\n");
      out.write("  * Template Name: MyPortfolio - v4.10.0\r\n");
      out.write("  * Template URL: https://bootstrapmade.com/myportfolio-bootstrap-portfolio-website-template/\r\n");
      out.write("  * Author: BootstrapMade.com\r\n");
      out.write("  * License: https://bootstrapmade.com/license/\r\n");
      out.write("  ======================================================== -->\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body>\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("  <!-- ======= Navbar ======= -->\r\n");
      out.write("  <div class=\"collapse navbar-collapse custom-navmenu\" id=\"main-navbar\">\r\n");
      out.write("    <div class=\"container py-2 py-md-5\">\r\n");
      out.write("      <div class=\"row align-items-start\">\r\n");
      out.write("        <div class=\"col-md-2\">\r\n");
      out.write("          <ul class=\"custom-menu\">\r\n");
      out.write("            <li><a href=\"index.html\">신발</a></li>\r\n");
      out.write("            <li><a href=\"about.html\">의류</a></li>\r\n");
      out.write("          </ul>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"col-md-6 d-none d-md-block  mr-auto\">\r\n");
      out.write("          <div class=\"tweet d-flex\">\r\n");
      out.write("            <div>\r\n");
      out.write("              <p>  NEW BALANCE(뉴발란스)는 1906년 미국 매사추세츠 주 보스턴에서 발에 장애가 있거나 경찰 소방관 우체부 등\r\n");
      out.write("                하루 종일 서서 일하는 발에 무리가 가는 사람들을 위해 아치 서포트(Arch Support : 지지대가 있는 신발 깔창)를\r\n");
      out.write("                만드는데서부터 시작되었습니다. 닭의 세 개의 발톱이 만드는 균형 (Balance)에서 영감을 얻어 아치 서포트와\r\n");
      out.write("                신발을 개발하였습니다. 지금의 뉴발란스(New balance)라는 회사명과 브랜드 명도 불균형한 발에\r\n");
      out.write("                새로운 균형을 창조한다 하는 개념으로부터 유래되었습니다.</p>\r\n");
      out.write("            </div>\r\n");
      out.write("          </div>\r\n");
      out.write("        </div>\r\n");
      out.write("      </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("  </div>\r\n");
      out.write("\r\n");
      out.write("  <nav class=\"navbar navbar-light custom-navbar\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("      <a class=\"navbar-brand\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/damin/\">NEW BALANCE</a>\r\n");
      out.write("      <a href=\"#\" class=\"burger\" data-bs-toggle=\"collapse\" data-bs-target=\"#main-navbar\">\r\n");
      out.write("        <span></span>\r\n");
      out.write("      </a>\r\n");
      out.write("    </div>\r\n");
      out.write("  </nav>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("</script>");
      out.write("\n");
      out.write("  <main id=\"main\">\n");
      out.write("\n");
      out.write("    <!-- ======= Works Section ======= -->\n");
      out.write("    <section class=\"section site-portfolio\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"row mb-5 align-items-center\">\n");
      out.write("          <div class=\"col-md-12 col-lg-6 mb-4 mb-lg-0\" data-aos=\"fade-up\">\n");
      out.write("            <h2>손이 자주 가는 아이템</h2>\n");
      out.write("            <p class=\"mb-0\">어디든 매치가 쉬운 뉴발란스 아이템으로, 다양한 룩을 완성해보세요!</p>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-md-12 col-lg-6 text-start text-lg-end\" data-aos=\"fade-up\" data-aos-delay=\"100\">\n");
      out.write("            <div id=\"filters\" class=\"filters\">\n");
      out.write("              <a href=\"#\" data-filter=\".web\">신상품순</a>\n");
      out.write("              <a href=\"#\" data-filter=\".design\">높은 가격순</a>\n");
      out.write("              <a href=\"#\" data-filter=\".branding\">낮은 가격순</a>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        ");
List<MallDto> list = (List<MallDto>)request.getAttribute("mallList"); 
      out.write("\n");
      out.write("        ");
for(int i=0; i<list.size(); i++){ 
        	MallDto dto = list.get(i);
      out.write("\n");
      out.write("        <div id=\"product\" class=\"row no-gutter\" data-aos=\"fade-up\" data-aos-delay=\"200\">\n");
      out.write("          <div class=\"item web col-sm-6 col-md-4 col-lg-4 mb-4\">\n");
      out.write("            <a href=\"{ctx}/mall/view?seq=");
      out.print(dto.getP_seq() );
      out.write("\" class=\"item-wrap fancybox\">\n");
      out.write("              <div class=\"work-info\">\n");
      out.write("                <h3>");
      out.print(dto.getP_name());
      out.write("</h3>\n");
      out.write("                <span>");
      out.print(dto.getP_price());
      out.write("</span>\n");
      out.write("              </div>\n");
      out.write("              <img class=\"img-fluid\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/img/img_1.jpg\">\n");
      out.write("            </a>\n");
      out.write("          </div>\n");
      out.write("\t\t");
} 
      out.write("\n");
      out.write("      </div>\n");
      out.write("    </section><!-- End  Works Section -->\n");
      out.write("\n");
      out.write("    <!-- ======= Clients Section ======= -->\n");
      out.write("    <section class=\"section\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"row justify-content-center text-center mb-4\">\n");
      out.write("          <div class=\"col-5\">\n");
      out.write("            <h3 class=\"h3 heading\">My Clients</h3>\n");
      out.write("            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit explicabo inventore.</p>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("          <div class=\"col-4 col-sm-4 col-md-2\">\n");
      out.write("            <a href=\"#\" class=\"client-logo\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/img/logo-adobe.png\" alt=\"Image\" class=\"img-fluid\"></a>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-4 col-sm-4 col-md-2\">\n");
      out.write("            <a href=\"#\" class=\"client-logo\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/img/logo-uber.png\" alt=\"Image\" class=\"img-fluid\"></a>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-4 col-sm-4 col-md-2\">\n");
      out.write("            <a href=\"#\" class=\"client-logo\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/img/logo-apple.png\" alt=\"Image\" class=\"img-fluid\"></a>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-4 col-sm-4 col-md-2\">\n");
      out.write("            <a href=\"#\" class=\"client-logo\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/img/logo-netflix.png\" alt=\"Image\" class=\"img-fluid\"></a>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-4 col-sm-4 col-md-2\">\n");
      out.write("            <a href=\"#\" class=\"client-logo\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/img/logo-nike.png\" alt=\"Image\" class=\"img-fluid\"></a>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-4 col-sm-4 col-md-2\">\n");
      out.write("            <a href=\"#\" class=\"client-logo\"><img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/img/logo-google.png\" alt=\"Image\" class=\"img-fluid\"></a>\n");
      out.write("          </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </section><!-- End Clients Section -->\n");
      out.write("\n");
      out.write("    <!-- ======= Services Section ======= -->\n");
      out.write("    <section class=\"section services\">\n");
      out.write("      <div class=\"container\">\n");
      out.write("        <div class=\"row justify-content-center text-center mb-4\">\n");
      out.write("          <div class=\"col-5\">\n");
      out.write("            <h3 class=\"h3 heading\">My Services</h3>\n");
      out.write("            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit explicabo inventore.</p>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"row\">\n");
      out.write("\n");
      out.write("          <div class=\"col-12 col-sm-6 col-md-6 col-lg-3\">\n");
      out.write("            <i class=\"bi bi-card-checklist\"></i>\n");
      out.write("            <h4 class=\"h4 mb-2\">Web Design</h4>\n");
      out.write("            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit explicabo inventore.</p>\n");
      out.write("            <ul class=\"list-unstyled list-line\">\n");
      out.write("              <li>Lorem ipsum dolor sit amet consectetur adipisicing</li>\n");
      out.write("              <li>Non pariatur nisi</li>\n");
      out.write("              <li>Magnam soluta quod</li>\n");
      out.write("              <li>Lorem ipsum dolor</li>\n");
      out.write("              <li>Cumque quae aliquam</li>\n");
      out.write("            </ul>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-12 col-sm-6 col-md-6 col-lg-3\">\n");
      out.write("            <i class=\"bi bi-binoculars\"></i>\n");
      out.write("            <h4 class=\"h4 mb-2\">Mobile Applications</h4>\n");
      out.write("            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit explicabo inventore.</p>\n");
      out.write("            <ul class=\"list-unstyled list-line\">\n");
      out.write("              <li>Lorem ipsum dolor sit amet consectetur adipisicing</li>\n");
      out.write("              <li>Non pariatur nisi</li>\n");
      out.write("              <li>Magnam soluta quod</li>\n");
      out.write("              <li>Lorem ipsum dolor</li>\n");
      out.write("              <li>Cumque quae aliquam</li>\n");
      out.write("            </ul>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-12 col-sm-6 col-md-6 col-lg-3\">\n");
      out.write("            <i class=\"bi bi-brightness-high\"></i>\n");
      out.write("            <h4 class=\"h4 mb-2\">Graphic Design</h4>\n");
      out.write("            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit explicabo inventore.</p>\n");
      out.write("            <ul class=\"list-unstyled list-line\">\n");
      out.write("              <li>Lorem ipsum dolor sit amet consectetur adipisicing</li>\n");
      out.write("              <li>Non pariatur nisi</li>\n");
      out.write("              <li>Magnam soluta quod</li>\n");
      out.write("              <li>Lorem ipsum dolor</li>\n");
      out.write("              <li>Cumque quae aliquam</li>\n");
      out.write("            </ul>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"col-12 col-sm-6 col-md-6 col-lg-3\">\n");
      out.write("            <i class=\"bi bi-calendar4-week\"></i>\n");
      out.write("            <h4 class=\"h4 mb-2\">SEO</h4>\n");
      out.write("            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit explicabo inventore.</p>\n");
      out.write("            <ul class=\"list-unstyled list-line\">\n");
      out.write("              <li>Lorem ipsum dolor sit amet consectetur adipisicing</li>\n");
      out.write("              <li>Non pariatur nisi</li>\n");
      out.write("              <li>Magnam soluta quod</li>\n");
      out.write("              <li>Lorem ipsum dolor</li>\n");
      out.write("              <li>Cumque quae aliquam</li>\n");
      out.write("            </ul>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </section><!-- End Services Section -->\n");
      out.write("\n");
      out.write("  </main><!-- End #main -->\n");
      out.write("\n");
      out.write("  <!-- ======= Footer ======= -->\n");
      out.write("  <footer class=\"footer\" role=\"contentinfo\">\n");
      out.write("    <div class=\"container\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-sm-6\">\n");
      out.write("          <p class=\"mb-1\" style=\"font-size: 13px;\"> &copy;  New Balance<br>\n");
      out.write("          개인정보 처리방침 / 이용약관 / ㈜이랜드월드패션사업부 / 서울특별시 금천구 가산디지털1로 159 <br>이랜드월드\n");
      out.write("온라인 고객센터 : 1566-0086, AS/오프라인 고객센터 : 080-999-0456<br>\n");
      out.write("대표 이메일 : webmaster@nbkorea.com\n");
      out.write("호스팅 서비스 제공자 : (주)라드씨엔에스</p>\n");
      out.write("          <div class=\"credits\">\n");
      out.write("            <!--\n");
      out.write("            All the links in the footer should remain intact.\n");
      out.write("            You can delete the links only if you purchased the pro version.\n");
      out.write("            Licensing information: https://bootstrapmade.com/license/\n");
      out.write("            Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/buy/?theme=MyPortfolio\n");
      out.write("          -->\n");
      out.write("            Designed by <a href=\"https://bootstrapmade.com/\">BootstrapMade</a>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"col-sm-6 social text-md-end\">\n");
      out.write("          <a href=\"#\"><span class=\"bi bi-twitter\"></span></a>\n");
      out.write("          <a href=\"#\"><span class=\"bi bi-facebook\"></span></a>\n");
      out.write("          <a href=\"#\"><span class=\"bi bi-instagram\"></span></a>\n");
      out.write("          <a href=\"#\"><span class=\"bi bi-linkedin\"></span></a>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("  </footer>\n");
      out.write("\n");
      out.write("  <a href=\"#\" class=\"back-to-top d-flex align-items-center justify-content-center\"><i class=\"bi bi-arrow-up-short\"></i></a>\n");
      out.write("\n");
      out.write("  <!-- Vendor JS Files -->\n");
      out.write("  <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/vendor/aos/aos.js\"></script>\n");
      out.write("  <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/vendor/bootstrap/js/bootstrap.bundle.min.js\"></script>\n");
      out.write("  <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/vendor/isotope-layout/isotope.pkgd.min.js\"></script>\n");
      out.write("  <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/vendor/swiper/swiper-bundle.min.js\"></script>\n");
      out.write("  <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/vendor/php-email-form/validate.js\"></script>\n");
      out.write("\n");
      out.write("  <!-- Template Main JS File -->\n");
      out.write("  <script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${ctx}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/resources/assets/js/main.js\"></script>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
