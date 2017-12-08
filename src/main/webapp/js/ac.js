$(function() {
    $('#doc-prompt-toggle').on('click', function() {
        var userName=$.cookie('userName');
        if(userName==null){
            //登陆框  ==做
            window.location.href=ctx+'index';

        }

        $('#my-prompt').modal({
            relatedTarget: this,
            onConfirm: function(e) {
               var nikeName= e.data[0];
               if(nikeName==''||nikeName.length>6){
                   alert("请输入昵称");
                   return;
               }
               var content = e.data[1];
               if(content==''){
                   alert("请输入评论内容");
                   return;
               }

               var id = $('#id').val();
               var data = {'nikeName':nikeName,'content':content,'aid':id};

                $.post("comment",data,function(result){
                    if(result.resultCode==1){
                        $("#nikeName").val('');
                        $("#content").val('');
                        alert(result.resultMessage);
                        // $("#tag_input").val("");
                        window.location.href="a?id="+id;
                    }else {
                        alert(result.resultMessage);
                        // $("#tag_input").val("");
                    }
                });


                alert('你输入的是：' + nikeName || '')
            },
            onCancel: function(e) {
                alert('不想说!');
            }
        });
    });
});

$(function () {



})