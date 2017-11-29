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
                  <h2 align="center">容我写一篇文章先</h2>
                  <input type="hidden" class="" id="img" name="img"/>
                  <div class="am-form-group">
                      <label for="doc-ipt-email-1">文章标题</label>
                      <input type="text" class="" id="title" placeholder="标题">

                  </div>

                  <div class="am-form-group">
                      <label for="doc-ipt-pwd-1">文章简介</label>
                      <input type="text" id="intro" class="" id="doc-ipt-pwd-1" placeholder="文章简介">
                  </div>
                  <div class="am-form-group " STYLE=" width:200px;" >
                      <label for="doc-select-1 " >TAG</label>
                      <select multiple data-am-selected="{maxHeight: 100}" id="s_tag">
                      <#if tags?has_content >
                          <#list tags as tag >
                              <option value=${tag.id}>${tag.typeName}</option>
                          </#list>
                      </#if>
                         <#--<option value="a">Apple</option>-->
                          <#--<option valu e="b" selected>Banana</option>-->
                          <#--<option value="o">Orange</option>-->
                          <#--<option value="m" selected>Mango</option>-->
                      </select>
                      <span class="am-form-caret"></span>
                  </div>
                  <hr />
                  <button type="button" class="am-btn am-btn-secondary am-round" id="create_tab">新增标签</button>
                  <br/>
                  <hr />
                  <div class="am-btn-group" data-am-button>
                  <#if tags?has_content >
                      <#list tags as tag >
                          <label class="am-btn am-btn-primary">
                              <input type="checkbox" name="doc-js-btn" value=${tag.typeName}> ${tag.typeName}
                          </label>
                          <#--<option value=${tag.typeName}>${tag.typeName}</option>-->
                      </#list>
                  </#if>
                      <#--<label class="am-btn am-btn-primary">-->
                          <#--<input type="checkbox" name="doc-js-btn" value="苹果"> 苹果-->
                      <#--</label>-->
                      <#--<label class="am-btn am-btn-primary">-->
                          <#--<input type="checkbox" name="doc-js-btn" value="橘子"> 橘子-->
                      <#--</label>-->
                      <#--<label class="am-btn am-btn-primary">-->
                          <#--<input type="checkbox" name="doc-js-btn" value="香蕉"> 香蕉-->
                      <#--</label>-->
                  </div>&nbsp;&nbsp;&nbsp;
                  <button type="button" class="am-btn am-btn-danger am-round" id="delete_tag">删除标签</button>
                  <hr />
                  <br/>
                  <br/>
                  <br/>
                  <div>
                      <label>正文</label>

                  </div>
                  <div id="editor">

                      <#--<p>欢迎使用 <b>wangEditor</b> 富文本编辑器</p>-->
                  </div>

                  <p><button type="button" class="am-btn am-btn-default" id="btn">提交</button></p>


                  <div class="am-modal am-modal-prompt" tabindex="-1" id="my-prompt">
                      <div class="am-modal-dialog">
                          <div class="am-modal-hd">新增标签</div>
                          <div class="am-modal-bd">

                              <input type="text" class="am-modal-prompt-input" id="tag_input">
                          </div>
                          <div class="am-modal-footer">
                              <span class="am-modal-btn" data-am-modal-cancel>取消</span>
                              <span class="am-modal-btn" data-am-modal-confirm>提交</span>
                          </div>
                      </div>
                  </div>

                  <div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
                      <div class="am-modal-dialog">
                          <div class="am-modal-hd">Amaze UI</div>
                          <div class="am-modal-bd">
                              你，确定要删除这条记录吗？
                          </div>
                          <div class="am-modal-footer">
                              <span class="am-modal-btn" data-am-modal-cancel>取消</span>
                              <span class="am-modal-btn" data-am-modal-confirm>确定</span>
                          </div>
                      </div>
                  </div>


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
        editor.customConfig.uploadImgServer = '/article/uploadImg';
        editor.customConfig.uploadFileName = 'uploadImg';
        editor.customConfig.uploadImgHooks = {
            success: function (xhr, editor, result) {
                // 图片上传并返回结果，图片插入成功之后触发
                // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
               var URL= result.data[0];
               console.log(URL);
               var img = $("#img").val();
               if(img==""){
                   $("#img").val(URL);
               }
            }
        }

        editor.create();

        document.getElementById('btn').addEventListener('click', function () {
            // 读取 html
//            alert(editor.txt.html())
            var title=$("#title").val();
            var intro=$("#intro").val();
            var content = editor.txt.html();
            var img = $("#img").val();
            if($("#s_tag").val()!=null){
                var tags = $("#s_tag").val().toString();
            }else {
                alert("请选择标签");
                return ;
            }
            var data = {"title":title,"intro":intro,"content":content,"typeId":tags,"img":img}

            $.post("insert",data,function(result){
                if(result.resultCode==1){
                    alert("文章上传成功");
                    window.location.href=ctx+"main";
                }else {
                    alert(result.resultMessage);
                }
            });


        }, false)


    </script>

<#include "include/common.right.ftl">
</div>
<!-- content end -->
<#include "include/common.footer.ftl">


</body>
<script type="text/javascript" src="${ctx}/js/article.js"></script>
</html>