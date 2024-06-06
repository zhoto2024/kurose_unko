<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>ピタゴラス定理</title>
    </head>
    <body>


          <p>直角をはさむ2辺の長さが
           <%=request.getAttribute("p") %> と
           <%=request.getAttribute("q") %> のとき、
          斜辺の長さは <%=request.getAttribute("num2") %>
           になります。</p>
    </body>
</html>

<%--        <%= request.getAttribute("result") %>
        <%= request.getAttribute("p") %>
        <%= request.getAttribute("q") %>
--%>