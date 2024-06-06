<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="UTF-8">
        <title>アプリケーションスコープのテスト</title>
    </head>
    <body>
        <h1><c:out value="${applicationScope.app_name}" /></h1>
    </body>
</html>

<%--<c:out>ではない。
            ${}は出力するもの。<c:out>で記述すると、サニタイジング
            が起こりHTMLタグの<>が無害化されてしまう。
            しかし、理由がない限り<c:out>と記述する。 --%>

<%--このファイルはアプリケーションスコープ--%>