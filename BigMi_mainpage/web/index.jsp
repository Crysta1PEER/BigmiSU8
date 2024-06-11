<%-- 
    Document   : index
    Created on : 2024-6-11, 13:59:46
    Author     : 86147
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link  >
    
</head>
<body>
    <header>
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
    </header>
    <div class="body-1">
        <img class="body-1-img" src="img/Top1.jpg" alt="body-1-img" style="">
        <span class="body-1-slogan-1"><p>BIGMI SU8</p></span>
        <span class="body-1-slogan-2"><p>人车合一  我心澎湃</p></span>
        <span class="body-1-guild"><a href="#">查看详情</a></span>
    </div>
    <div class="body-2">
        <img class="body-2-img" src="img/Top2.jpg" alt="body-1-img" style="">
    </div>


    <script>
        const header = document.querySelector('header')
        window.addEventListener('scroll', function () {
            const scrollTopValue = document.documentElement.scrollTop
            if (scrollTopValue >= 1) {
                header.style.backgroundColor = 'rgba(0,0,0,0.85 )'
            }if(scrollTopValue <=1) {
                header.addEventListener('mouseover',function () {
                    header.style.backgroundColor = 'rgba(0,0,0,0.7 )'
                })
                header.addEventListener("mouseout", function (){
                    header.style.backgroundColor = "transparent"
                })

            }
        })
    </script>
</body>
</html>
