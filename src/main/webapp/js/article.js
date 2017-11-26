$(function() {
    $('#create_tab').on('click', function() {
        $('#my-prompt').modal({
            relatedTarget: this,
            onConfirm: function(e) {
                var  val = e.data;
                var data = {"typeName":val};
                $.post("tag",data,function(result){
                    if(result.resultCode==1){
                        alert("标签上传成功");
                        $("#tag_input").val("");
                        location.reload();
                    }else {
                        alert(result.resultMessage);
                        $("#tag_input").val("");
                    }
                });

                // alert('你输入的是：' + data || '')
            },
            onCancel: function(e) {
                // alert('不想说!');
            }
        });
    });
});


$(function() {
    $('#delete_tag').on('click', function() {
        $('#my-confirm').modal({
            relatedTarget: this,
            onConfirm: function(options) {
                var checked = $('[name="doc-js-btn"]');
                if(checked.length<1){
                    alert("请选择后再提交");
                    return;
                }
                // var $link = $(this.relatedTarget).prev('a');
                // var msg = '你要删除的链接 ID 为 ' + checked.get(1) ;
                var data = '';
                for(var i=0;i<checked.length;i++){
                    if(checked[i].checked==true){
                        // alert(checked[i].checked);
                        if(i==checked.length){
                            data+=checked[i].value;
                            return;
                        }
                        data+=checked[i].value+",";

                    }
                }


                $.post("delete",{"tags":data},function(result){
                    if(result.resultCode==1){
                        alert("删除成功");
                        // $("#tag_input").val("");
                        location.reload();
                    }else {
                        alert(result.resultMessage);
                        $("#tag_input").val("");
                    }
                });

                // alert(msg);
            },
            // closeOnConfirm: false,
            onCancel: function() {
                alert('算求，不弄了');
            }

        });
    });
});
