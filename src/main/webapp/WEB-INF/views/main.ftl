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
                        <img src=${item.img?default("/images/01.jpg")} alt="" class="am-u-sm-12">
                    </div>
                    <div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text">
                        <span><a href="${ctx}/a?id=${item.id}" class="blog-color">article &nbsp;</a></span>
                        <span> @陈琛 &nbsp;</span>
                        <span>${item.createDate?date}</span>
                        <h1><a href="${ctx}/a?id=${item.id}">${item.title?default("i")}</a></h1>
                        <p>${item.intro?default("")}
                        </p>
                        <p><a href="" class="blog-continue">continue reading</a></p>
                    </div>
                </article>
            </#list>
        </#if>
        </div>
        <div id="page">
        <#assign p=page.getPage()>
            <#assign total=page.getTotalPages()>
            <ul class="am-pagination am-pagination-centered">
                <#if p==1>
                    <li class="am-disabled"><a href="#">上一页</a></li>
                <#else >
                    <li ><a href="/main?page=${p-1}">上一页</a></li>
                </#if>

                <#if p?has_content  >
                    <#if p - 2 &gt;= 1>
                        <li class=><a href="/main?page=${page.getPage()-2}">${page.getPage()-2}</a></li>
                    </#if>
                    <#if page.hasPrePage>
                        <li class=><a href="/main?page=${page.getPage()-1}">${page.getPage()-1}</a></li>
                    </#if>
                    <li class="am-active"><a href="/main?page=${page.getPage()}">${page.getPage()}</a></li>
                    <#if page.hasNextPage>
                        <li ><a href="/main?page=${page.getPage()+1}">${page.getPage()+1}</a></li>
                    </#if>
                    <#if p + 2 <= total>
                        <li ><a href="/main?page=${page.getPage()+2}">${page.getPage()+2}</a></li>
                    </#if>
                </#if>

                <#if page.getPage()==page.getTotalPages()>
                    <li class="am-disabled"><a href="#">下一页</a></li>
                <#else >
                    <li><a href="/main?page=${page.getPage()+1}">下一页</a></li>
                </#if>
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