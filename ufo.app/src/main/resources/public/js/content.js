$grid = $('#grid');
var gridInfo = JSON.parse('${gridInfo!{}}');
console.log(gridInfo);
$.extend(true, params, gridInfo);
console.log(params);
// 主页面
_grid();

var _conf = function () {
    if (selectRow) {
        var p = {
            title: selectRow.name + '基本信息',
            href: 'grid/grid.form?gridName=grid-extend-info&action=modify',
            padding: 20
        };
        console.log(p);
        open(p, _fn);
    } else {
        layer.msg('请选择需要配置的记录！');
    }
};

var _fn = function ($dialog) {
    var id = 0;
    $.ajax({
        async: false,
        url: 'grid/grid.extend',
        data: {gridId: selectRow.id},
        success: function (data) {
            if (data) {
                id = data.id;
                for (var k in data) {
                    if (data[k] instanceof Boolean) {
                        data[k] == true ? data[k] = 'true' : '';
                        data[k] == false ? data[k] = 'false' : '';
                    }
                }
                console.log(data);
                $('#form').form('load', data);
            }
        }
    });
    $('#form').find('#btnOk').click(function () {
        $('#form').form('submit', {
            url: 'grid/upsert.grid.extend?id=' + id,
            onSubmit: function () {
                return $(this).form('enableValidation').form('validate');
            },
            success: function (data) {
                var r = JSON.parse(data);
                if (r.status) {
                    layer.msg(r.message);
                } else {
                    layer.msg('系统去开ufo了，请稍后重试！');
                }
            }
        });
    });
    /*$.getJSON('grid/grid.extend', {gridId: selectRow.id}, function (data) {
     var id = 0;
     if (data) {
     id = data.id;
     for (var k in data) {
     if (data[k] instanceof Boolean) {
     data[k] == true ? data[k] = 'true' : '';
     data[k] == false ? data[k] = 'false' : '';
     }
     }
     console.log(data);
     $('#form').form('load', data);
     }
     $('#form').find('#btnOk').click(function () {
     $('#form').form('submit', {
     url: 'grid/upsert.grid.extend?id=' + id,
     onSubmit: function () {
     layer.msg(1);
     return $(this).form('enableValidation').form('validate');
     },
     success: function (data) {
     var r = JSON.parse(data);
     if (r.status) {
     layer.msg(r.message);
     } else {
     layer.msg('系统去开ufo了，请稍后重试！');
     }
     }
     });
     });
     });*/
    $('#form').find('#btnCancel span.l-btn-text').text('下一步');
    $('#form').find('#btnCancel').click(function () {
        $dialog.dialog('close');
        open({
            title: selectRow.name + '列信息',
            url: 'window-column-setting?gridName=conf-grid-columns-info'
        }, {width: 900, height: 600});
    });
};