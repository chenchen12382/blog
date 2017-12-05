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
               var comment= e.data;
               var id = $('#id').val();
               var data = {'comment':comment,'userName':userName,'id':id};

                $.post("comment",data,function(result){
                    if(result.resultCode==1){
                        alert("删除成功");
                        // $("#tag_input").val("");
                        location.reload();
                    }else {
                        alert(result.resultMessage);
                        // $("#tag_input").val("");
                    }
                });


                alert('你输入的是：' + e.data || '')
            },
            onCancel: function(e) {
                alert('不想说!');
            }
        });
    });
});
