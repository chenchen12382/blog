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
            <li class="am-comment">
                <a href="#link-to-user-home">
                    <img src="" alt="" class="am-comment-avatar" width="48" height="48"/>
                </a>

                <div class="am-comment-main">
                    <header class="am-comment-hd">
                        <!--<h3 class="am-comment-title">评论标题</h3>-->
                        <div class="am-comment-meta">
                            <a href="#link-to-user" class="am-comment-author">某人</a>
                            评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time>
                        </div>
                    </header>

                    <div class="am-comment-bd">
                        ...
                    </div>
                </div>
            </li>

            <li class="am-comment">
                <a href="#link-to-user-home">
                    <img src="" alt="" class="am-comment-avatar" width="48" height="48"/>
                </a>

                <div class="am-comment-main">
                    <header class="am-comment-hd">
                        <!--<h3 class="am-comment-title">评论标题</h3>-->
                        <div class="am-comment-meta">
                            <a href="#link-to-user" class="am-comment-author">某人</a>
                            评论于 <time datetime="2013-07-27T04:54:29-07:00" title="2013年7月27日 下午7:54 格林尼治标准时间+0800">2014-7-12 15:30</time>
                        </div>
                    </header>

                    <div class="am-comment-bd">
                        <p>
                            那，那是一封写给南部母亲的信。我茫然站在骑楼下，我又看到永远的樱子走到街心。其实雨下得并不大，却是一生一世中最大的一场雨。而那封信是这样写的，年轻的樱子知不知道呢？
                            <br/>
                            <a href="">
                                <i class="am-icon-reply"></i>
                            </a>
                        </p>
                        <blockquote>
                            妈：我打算在下个月和樱子结婚。
                            <br/>
                            <a href="">
                                <i class="am-icon-reply"></i>
                            </a>

                        </blockquote>
                        <blockquote>
                            妈：我打算在下个月和樱子结婚。
                            <br/>
                            <a href="">
                                <i class="am-icon-reply"></i>
                            </a>

                        </blockquote>
                    </div>
                </div>
            </li>
            <li class="am-comment am-comment-flip"></li>

            <li class="am-comment am-comment-highlight"></li>
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
                    来来来，吐槽点啥吧
                    <input type="t" class="am-modal-prompt-input">
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