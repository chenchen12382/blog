<!doctype html>
<html>
<head>
<#include "include/common.header.ftl" >
</head>

<body id="blog-article-sidebar">
<!-- header start -->
<#include "include/common.title.ftl">
<!-- header end -->

<!-- content srart -->
<div class="am-g am-g-fixed blog-fixed blog-content">
    <div class="am-u-md-8 am-u-sm-12">
      <article class="am-article blog-article-p">
          <form class="am-form">
              <fieldset>
                  <legend>表单标题</legend>

                  <div class="am-form-group">
                      <label for="doc-ipt-email-1">文章标题</label>
                      <input type="text" class="" id="title" placeholder="标题">
                  </div>

                  <div class="am-form-group">
                      <label for="doc-ipt-pwd-1">文章简介</label>
                      <input type="text" class="" id="doc-ipt-pwd-1" placeholder="文章简介">
                  </div>
                  <div>
                      <label>正文</label>

                  </div>
                  <div id="editor">

                      <p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>
                  </div>

                  <p><button type="button" class="am-btn am-btn-default" id="btn">提交</button></p>
              </fieldset>
          </form>
      </article>
    </div>

    <script type="text/javascript" src="${ctx}/js/wangEditor.min.js"></script>
    <script type="text/javascript">
        var E = window.wangEditor;
        var editor = new E('#editor')
        // 或者 var editor = new E( document.getElementById('#editor') )
//        editor.customConfig.uploadImgShowBase64 = true;
        editor.customConfig.uploadImgServer = '/upload'
        editor.create()

        document.getElementById('btn').addEventListener('click', function () {
            // 读取 html
            alert(editor.txt.html())
        }, false)
    </script>

<#include "include/common.right.ftl">
<!-- content end -->
<#include "include/common.footer.ftl">


</body>
</html>