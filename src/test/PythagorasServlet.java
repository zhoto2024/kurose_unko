package test;

/*リクエストパラメータとして a と b を持たせてください
 *
サーブレットでは、この2つの辺の長さを取得し、
三平方の定理を使って c2 を求め、Math.sqrt() で平方根にした数値を
斜辺の長さとしてビューに表示できるように格納（セット）してください

3辺ともに実数値としてください。String型から実数値への変換は
Double.parseDouble() を使いましょう

JSPでは、下記「出力結果の例」で示したような文言で、
計算結果を画面へ表示するようにしてください。
表示については、サーブレットにて格納されている値を取得し利用します

出力結果の例
たとえば、
http://localhost:8080/first_webapp/PythagorasServlet?a=3.0&b=4.0
にアクセスすると、以下のように表示されます。

直角をはさむ2辺の長さが 3.0 と 4.0 のとき、
斜辺の長さは 5.0 になります。
*/

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PythagorasServlet
 */
@WebServlet("/PythagorasServlet")
public class PythagorasServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public PythagorasServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String a = request.getParameter("a");
        String b = request.getParameter("b");
        double p = Double.parseDouble(a);
        double q = Double.parseDouble(b);
        double num1 = p*p + q*q;
        double num2 = Math.sqrt(num1);
        request.setAttribute("num2", num2);
        request.setAttribute("p", p);
        request.setAttribute("q", q);
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/calc_c.jsp");
        rd.forward(request, response);
    }
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
