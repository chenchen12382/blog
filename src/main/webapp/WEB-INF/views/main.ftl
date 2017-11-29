<!doctype html>
<html>
<head>
        <#include "include/common.header.ftl" >
</head>

<body id="blog">

<#include "include/common.title.ftl">



<!-- content srart -->
<div class="am-g am-g-fixed blog-fixed">
    <div class="am-u-md-8 am-u-sm-12">
        <div id="list">
        <#if articles?has_content >
            <#list articles as item >
                <article class="am-g blog-entry-article">
                    <div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">
                        <img src=${item.img?default("")} alt="" class="am-u-sm-12">
                    </div>
                    <div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text">
                        <span><a href="" class="blog-color">article &nbsp;</a></span>
                        <span> @陈琛 &nbsp;</span>
                        <span>${item.createDate?date}</span>
                        <h1><a href="">${item.title?default("")}</a></h1>
                        <p>${item.intro?default("")}
                        </p>
                        <p><a href="" class="blog-continue">continue reading</a></p>
                    </div>
                </article>
            </#list>
        </#if>
        </div>
        <div id="page">
            <ul class="am-pagination am-pagination-centered">
                <li class="am-disabled"><a href="#">上一页</a></li>
                <li class="am-active"><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">下一页</a></li>
            </ul>
        </div>

    </div>



    <#--右侧个人介绍-->
<#include "include/common.right.ftl">
</div>
<!-- content end -->
<#include "include/common.footer.ftl">


</body>
</html>