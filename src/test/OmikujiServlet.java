package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OmikujiServlet
 */
@WebServlet("/OmikujiServlet")
public class OmikujiServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public OmikujiServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");

        List<String> errors = new ArrayList<String>();

        if(username == null || username.equals("")) {
            errors.add("氏名を入力してください");
        }

        //入力内容にエラーがあったかどうか
        if(errors.size() > 0) {
            request.setAttribute("errors",  errors);
        } else {
            String[] fortune = {"大吉", "吉", "中吉", "小吉", "末吉", "凶"};
            request.setAttribute("fortune", fortune[(int)(Math.random() * 6)]);
            request.setAttribute("username", username);
        }

            RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/omikuji_result.jsp");
            rd.forward(request, response);
    }

}
