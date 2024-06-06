<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>九九表</title>
    </head>
    <body>
      <ul>
        <% for (int i = 1; i<10; i++){
                for (int j = 1; j<10; j++){
                    int num1 = i*j;
        %>          <li> <%=i%>×<%=j%>=<%=num1 %></li>
             <%}
           }
           %>
      </ul>
    </body>
</html>