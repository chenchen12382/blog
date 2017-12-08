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
            <input type="hidden" value="${article.id}" id="id"/>
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
            <div>
                <i class="am-icon-comment"></i>
                <span class="blog-comment" style="text-align: center">评论区</span>
                <span style="float: right;"><button type="button" class="am-btn am-btn-success" id="doc-prompt-toggle">发表评论</button></span>
            </div>
        </form>

        <hr>
        <ul class="am-comments-list am-comments-list-flip">
        <#if comments?has_content>
            <#list comments as item>

                <li class="am-comment">
                    <a href="#">
                        <img src="" alt="" class="am-comment-avatar" width="48" height="48"/>
                    </a>

                    <div class="am-comment-main">
                        <header class="am-comment-hd">
                            <!--<h3 class="am-comment-title">评论标题</h3>-->
                            <div class="am-comment-meta">
                                <a href="#" class="am-comment-author">${item.nikeName}</a>
                                评论于 <time datetime="${item.createDate?date}" title="${item.createDate?date}">2014-7-12 15:30</time>
                            </div>
                        </header>

                        <div class="am-comment-bd">
                            <p>
                                ${item.content}
                            </p>
                        </div>
                    </div>
                </li>
            </#list>
        </#if>

        </ul>

        <ul class="am-pagination blog-article-margin">
        <#if paginator.hasPrePage>
            <li class="am-pagination-prev"><a href="${ctx}/a?id=${article.id}&page=${paginator.getPrePage()}" class="">上一页评论</a></li>
        </#if>

        <#if paginator.hasNextPage>
            <li class="am-pagination-next"><a href="${ctx}/a?id=${article.id}&page=${paginator.getNextPage()}">下一页评论</a></li>
        </#if>


        </ul>


        <#--<button-->
                <#--type="button"-->
                <#--class="am-btn am-btn-success"-->
                <#--id="doc-prompt-toggle">-->
            <#--Prompt-->
        <#--</button>-->

        <div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt">
            <div class="am-modal-dialog">
                <div class="am-modal-hd">发表评论</div>
                <div class="am-modal-bd">
                    <input id="nikeName" name="nikeName" type="t" class="am-modal-prompt-input" placeholder="昵称">
                </div>
                <div class="am-modal-bd">
                    <input type="t" id="content" name="content" class="am-modal-prompt-input" placeholder="评论内容">
                </div>
                <div class="am-modal-footer">
                    <span class="am-modal-btn" data-am-modal-cancel>取消</span>
                    <span class="am-modal-btn" data-am-modal-confirm>提交</span>
                </div>
            </div>
        </div>


    </div>


<#include "include/common.right.ftl">
</div>
<!-- content end -->
<#include "include/common.footer.ftl">
</body>
<script src="${ctx}/js/ac.js"></script>
</html>