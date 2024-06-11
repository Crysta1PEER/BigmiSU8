<%-- 
    Document   : header
    Created on : 2024-6-8, 16:22:23
    Author     : 86147
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="headerCss.css">
    </head>
    <body>
        <div class="header">
            <div class="logo">
                <a href="#">BIGMI</a>
            </div>
            <div class="Top-middle">
                <ul>
                    <li class="nav"><a href="#">首页</a></li>
                    <li class="nav">
                        <a href="#">大米 SU8</a>
                        <ul class="dropdown-content">
                            <li><a href="">SU8</a></li>
                            <li><a href="">SU8 Pro</a></li>
                            <li><a href="">SU8 Max</a></li>
                            <li><a href="">车型对比</a></li>
                        </ul>
                    </li>
                    <li class="nav"><a href="#">关于我们</a></li>
                </ul>
            </div>
            <div class="Top-right">
                <button class="chooseBtn"><a href="#">去购车页面</a></button>
                <button class="loginBtn"><a class="loginBtn-a"href="#">登录</a></button>
            </div>
    </div>
        
    
    <script>
        const header = document.querySelector('header');
        window.addEventListener('scroll', function () {
            const scrollTopValue = document.documentElement.scrollTop;
            if (scrollTopValue >= 1) {
                header.style.backgroundColor = 'rgba(0,0,0,0.85 )';
            }if(scrollTopValue <=1) {
                header.addEventListener('mouseover',function () {
                    header.style.backgroundColor = 'rgba(0,0,0,0.7 )';
                });
                header.addEventListener("mouseout", function (){
                    header.style.backgroundColor = "transparent";
                });

            }
        })
    </script>
    </body>
</html>
