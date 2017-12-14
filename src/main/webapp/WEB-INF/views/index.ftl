<!doctype html>
<html>
<head>
<#include "include/common.header.ftl" >
</head>
<body>
<header>
  <#--<div class="log-header">-->
      <#--<h1><a href="/">Amaze UI</a> </h1>-->
  <#--</div>    -->
  <div class="log-re">
      <br>
      <button type="button" class="am-btn am-btn-danger am-round" id="a_main">回首页</button>
  </div>
</header>

<div class="log"> 
  <div class="am-g">
  <div class="am-u-lg-3 am-u-md-6 am-u-sm-8 am-u-sm-centered log-content">
    <h1 class="log-title am-animation-slide-top">博客管理员登陆</h1>
    <br>
    <form class="am-form" id="log-form">
      <div class="am-input-group am-radius am-animation-slide-left">       
        <input type="text" id="userName" class="am-radius" data-validation-message="请输入用户名" placeholder="用户名" required/>
        <span class="am-input-group-label log-icon am-radius"><i class="am-icon-user am-icon-sm am-icon-fw"></i></span>
      </div>      
      <br>
      <div class="am-input-group am-animation-slide-left log-animation-delay">       
        <input type="password" id="password" class="am-form-field am-radius log-input" placeholder="密码" data-validation-message="请输入密码" required>
        <span class="am-input-group-label log-icon am-radius"><i class="am-icon-lock am-icon-sm am-icon-fw"></i></span>
      </div>      
      <br>
      <button type="button" id="submitBtn" class="am-btn am-btn-primary am-btn-block am-btn-lg am-radius am-animation-slide-bottom log-animation-delay">登 录</button>
            <#--<p class="am-animation-slide-bottom log-animation-delay"><a href="#">忘记密码?</a></p>-->
      <div >
          <br>

      </div>
    </form>
  </div>
  </div>
  <footer class="log-footer">   
    © 2014 AllMobilize, Inc. Licensed under MIT license.
  </footer>
</div>
<script src="${ctx}/js/index.js"></script>


</body>

<script>
    $(function () {
        $("#a_main").click(function () {

            window.location.href=ctx;
        })

    })
</script>
</html>