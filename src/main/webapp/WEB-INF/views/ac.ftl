<!doctype html>
<html>
<head>
<#include "include/common.header.ftl" >
</head>

<body id="blog-article-sidebar">
<!-- header start -->
<#include "include/common.title.ftl">
<!-- header end -->
<!-- nav start -->
<!-- nav end -->
<!-- content srart -->
<div class="am-g am-g-fixed blog-fixed blog-content">
    <div class="am-u-md-8 am-u-sm-12">
      <article class="am-article blog-article-p">
        <div class="am-article-hd">
          <h1 class="am-article-title blog-text-center">${article.title}</h1>
          <p class="am-article-meta blog-text-center">
              <span><a href="#" class="blog-color">article &nbsp;</a></span>-
              <span><a href="#">@陈琛 &nbsp;</a></span>-
              <span><a href="#">${article.createDate?date}</a></span>
          </p>
        </div>        
        <div class="am-article-bd">
        <img src="${article.img?default("${ctx}/images/01.jpg")}" alt="" class="blog-entry-img blog-article-margin">
            <p>
                ${article.content}
            </p>
        </div>
      </article>
        <ul class="am-pagination blog-article-margin">
            <#if pre?has_content>
                <li class="am-pagination-prev"><a href="${ctx}/a?id=${pre}" class="">上一篇</a></li>
            <#else >
                <li class="am-disabled"><a href="#" class="">上一篇</a></li>
            </#if>

            <#if next?has_content>
                <li class="am-pagination-next"><a href="${ctx}/a?id=${next}">下一篇</a></li>
            <#else >
                <li class="am-disabled"><a href="#" class="">下一篇</a></li>
            </#if>


        </ul>
        
        <hr>

        <form class="am-form am-g">
            <h3 class="blog-comment">评论</h3>
          <fieldset>
            <div class="am-form-group am-u-sm-4 blog-clear-left">
              <input type="text" class="" placeholder="名字">
            </div>
            <div class="am-form-group am-u-sm-4">
              <input type="email" class="" placeholder="邮箱">
            </div>

            <div class="am-form-group am-u-sm-4 blog-clear-right">
              <input type="password" class="" placeholder="网站">
            </div>
        
            <div class="am-form-group">
              <textarea class="" rows="5" placeholder="一字千金"></textarea>
            </div>
        
            <p><button type="submit" class="am-btn am-btn-default">发表评论</button></p>
          </fieldset>
        </form>

        <hr>
    </div>

<#include "include/common.right.ftl">
</div>
<!-- content end -->
<#include "include/common.footer.ftl">
</body>
</html>