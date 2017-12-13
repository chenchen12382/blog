<div class="am-u-md-4 am-u-sm-12 blog-sidebar">

    <div class="blog-sidebar-widget blog-bor">
        <h2 class="blog-text-center blog-title"><span>关于我</span></h2>
        <img src="${ctx}/assets/i/f14.jpg" alt="about me" class="blog-entry-img" >
        <h3>${user.nickName}</h3>
        <p>${user.mood}</p>
    <#--</p><p>我不想成为一个庸俗的人。十年百年后，当我们死去，质疑我们的人同样死去，后人看到的是裹足不前、原地打转的你，还是一直奔跑、走到远方的我？</p>-->
    </div>
    <div class="blog-sidebar-widget blog-bor">
        <h2 class="blog-text-center blog-title"><span>联系我</span></h2>
        <p>
            <a href="https://github.com/chenchen12382"><span class="am-icon-github am-icon-fw blog-icon" title="我的github"></span></a>
            <a href="tencent://QQInterLive/?Cmd=2&Uin=391313748"><span class="am-icon-qq am-icon-fw am-primary blog-icon" title="加我好友呗"></span></a>
            <a href="${ctx}/images/wx.png"><span class="am-icon-weixin am-icon-fw blog-icon" title="微信扫一扫"></span></a>
        </p>
    </div>
    <div class="blog-clear-margin blog-sidebar-widget blog-bor am-g ">
        <h2 class="blog-title"><span>标签</span></h2>
        <div class="am-u-sm-12 blog-clear-padding">
        <#if rightTags?has_content>
            <#list rightTags as tag>
                <a href="${ctx}/?tag=${tag.getTypeName()}" class="blog-tag">${tag.getTypeName()}</a>
            </#list>
        </#if>

        </div>
    </div>
    <div class="blog-sidebar-widget blog-bor">
        <h2 class="blog-title"><span>占位</span></h2>
        <ul class="am-list">
            <li><a href="#">每个人都有一个死角， 自己走不出来，别人也闯不进去。</a></li>
            <li><a href="#">我把最深沉的秘密放在那里。</a></li>
            <li><a href="#">你不懂我，我不怪你。</a></li>
            <li><a href="#">每个人都有一道伤口， 或深或浅，盖上布，以为不存在。</a></li>
        </ul>
    </div>
</div>
