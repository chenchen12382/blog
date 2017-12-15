<header class="am-g am-g-fixed blog-fixed blog-text-center blog-header">
    <div class="am-u-sm-8 am-u-sm-centered">
        <img width="600" src="${ctx}/images/cc.png" alt="Amaze UI Logo"/>
        <#--<h2 class="am-hide-sm-only">陈琛的个人博客</h2>-->
    </div>

    <script>

        function articleIndex() {
            var userName=$.cookie("userName");
            if(userName==undefined){
                window.location.href=ctx+'login';
                return;
            }else {
                window.location.href=ctx+'article/index'
            }
        }
    </script>

    <script>
        function serchArticle() {
            var name = $('#i_search').val();
//            var data = {"name":name};
            window.location.href=ctx+'?name='+name;


        }
    </script>
</header>

<hr>
<nav class="am-g am-g-fixed blog-fixed blog-nav">
    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only blog-button" data-am-collapse="{target: '#blog-collapse'}" ><span class="am-sr-only">导航切换</span> <span class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="blog-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav">
            <li class="am-active"><a href="${ctx}/">首页</a></li>
        <#--<li class="am-dropdown" data-am-dropdown>-->
        <#--<a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">-->
        <#--首页布局 <span class="am-icon-caret-down"></span>-->
        <#--</a>-->
        <#--<ul class="am-dropdown-content">-->
        <#--<li><a href="lw-index.html">1. blog-index-standard</a></li>         -->
        <#--<li><a href="lw-index-nosidebar.html">2. blog-index-nosidebar</a></li>-->
        <#--<li><a href="lw-index-center.html">3. blog-index-layout</a></li>-->
        <#--<li><a href="lw-index-noslider.html">4. blog-index-noslider</a></li>-->
        <#--</ul>-->
        <#--</li>-->
            <li><a href="javascript:articleIndex()" id="a_article">写文章</a></li>
            <li><a href="${ctx}/img">图片库</a></li>
        </ul>
        <form class="am-topbar-form am-topbar-right am-form-inline" role="search">
            <div class="am-form-group">
                <input type="text" class="am-form-field am-input-sm" placeholder="搜索" id="i_search">
                <a href="javascript:serchArticle()"><i class="am-icon-search am-icon-fw"></i></a>
            </div>
        </form>
    </div>
</nav>
<hr>