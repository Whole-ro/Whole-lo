
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*, model.entity.*, model.manager.*"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://fonts.googleapis.com/css?family=Inter&display=swap" rel="stylesheet" />
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Corinthia:wght@700&display=swap" rel="stylesheet">
        <link href="./css/agreement.css" rel="stylesheet"/>
        <title>약관동의</title>
    </head>
    <body>
        <div class="agreement_header">
            <header>
                <h3>Whole로 가입하기</h3>
                <img src="./img/ic_linelogo.png">
            </header>
        </div>
        <div class="agreement_step_container">
            <span class="step_number">01</span>
            <span class="step_number">02</span>
            <span class="step_number">03</span>
            <span class="step_title">약관동의</span>
            <span class="step_title">본인인증</span>
            <span class="step_title">회원정보입력</span>
        </div>
        <div class="top_line"><hr></div>
        <div class="agreement_content">
            <div class="content_title">Whole로 회원 약관동의</div>
            <div class="content_text"> Whole로 서비스 이용을 위해 아래 이용약관 및 정보 이용에 동의해 주세요. </div>
            <form>
                <div class="agreements">
                    <table class="agreement_table">
                        <tr>
                            <td>
                                <label class="container">
                                    <input type="checkbox" class="checkbox_style">
                                    <span style="font-size: 30px; font-weight:bold" class="padding_set">전체 동의</span>
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label class="container">
                                    <input type="checkbox">
                                    <span class="padding_set">Whole로 이용약관<span class="red">(필수)</span></span>
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="text" id="agree01" value="이용 약관1" readonly="true"></td>
                        </tr>
                        <tr>
                            <td>
                                <label class="container">
                                    <input type="checkbox">
                                    <span class="padding_set">개인(신용)정보 수집 및 이용동의</span><span class="red">(필수)</span>
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="text" id="agree02" value="이용 약관2" readonly="true"></td>
                        </tr>
                        <tr>
                            <td>
                                <label class="container">
                                    <input type="checkbox">
                                    <span class="padding_set">마케팅 정보 수신동의(선택)</span>
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="text" id="agree03" value="이용 약관3" readonly="true"></td>
                        </tr>
                    </table>
                </div>
                <button type="button" class="nextBtn" onClick="location.href='<c:url value='/user/register'/>'"/>
               
            </form>
        </div>
    </body>
</html>