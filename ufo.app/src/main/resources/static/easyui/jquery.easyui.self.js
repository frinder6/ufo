/**
 * 定义下面2个参数后，即可自动完成功能
 */
var $grid;
var params = {gridName: '', removeUrl: '', addUrl: '', modifyUrl: ''}

/**
 * 加载表格，使用全局参数
 * @param params
 */
var grid = function () {
    $.getJSON('grid/grid.options', {gridName: params.gridName}, function (data) {
        console.log(data);
        $.each(data.columns[0], function (i, v) {
            if (v.formatter) {
                v.formatter = eval('(' + v.formatter + ')');
            }
        });
        $.each(data.toolbar, function (i, v) {
            if (v.handler) {
                v.handler = eval('(' + v.handler + ')');
            }
        });
        console.log(data);
        $grid.datagrid(data);
    });
};

/**
 * 加载表格，使用自定义参数
 * @param params
 */
var gridp = function (grid, p, queryParams) {
    $.getJSON('grid/grid.options', {gridName: p.gridName}, function (data) {
        console.log(data);
        $.each(data.columns[0], function (i, v) {
            if (v.formatter) {
                v.formatter = eval('(' + v.formatter + ')');
            }
        });
        $.each(data.toolbar, function (i, v) {
            if (v.handler) {
                v.handler = eval('(' + v.handler + ')');
            }
        });
        if (queryParams){
            data.queryParams = {};
            $.extend(true, data.queryParams, queryParams);
        }
        console.log(data);
        grid.datagrid(data);
    });
};

/**
 * 删除方法
 * @param removeUrl
 */
var remove = function () {
    var row = $grid.datagrid('getSelected');
    if (row) {
        $.messager.confirm('删除操作确认', '确认删除选中记录？', function (r) {
            if (r) {
                $.getJSON(params.removeUrl, {id: row.id}, function (data) {
                    $grid.datagrid('reload');
                    if (data.status) {
                        layer.msg(data.message);
                        row = null;
                    } else {
                        layer.msg('系统去开ufo了，请稍后重试！');
                    }
                });
            }
        });
    } else {
        layer.msg('请选择需要删除的记录！');
    }
};

/**
 * 修改方法
 * @param $grid
 * @param modifyUrl
 */
var modify = function () {
    var row = $grid.datagrid('getSelected');
    if (row) {
        $(document.body).append('<div id="dialog"></div>');
        $('#dialog').dialog({
            title: '更新',
            width: 400,
            href: 'grid/grid.form?action=modify&gridName=' + params.gridName,
            modal: true,
            resizable: true,
            onLoad: function () {

                $('#form').form('load', row);
                $('#form').find('#btnOk').click(function () {
                    $('#form').form('submit', {
                        url: params.modifyUrl + '?id=' + row.id,
                        onSubmit: function () {
                            return $(this).form('enableValidation').form('validate');
                        },
                        success: function (data) {
                            $grid.datagrid('reload');
                            $('#dialog').dialog('close');
                            var r = JSON.parse(data);
                            if (r.status) {
                                layer.msg(r.message);
                            } else {
                                layer.msg('系统去开ufo了，请稍后重试！');
                            }
                        }
                    });
                });
                $('#form').find('#btnCancel').click(function () {
                    $('#form').form('clear');
                });
            },
            onClose: function () {
                $('#form').form('clear');
                $('#dialog').remove();
            }
        });
    } else {
        layer.msg('请选择需要更新的记录！');
    }
};

/**
 * 添加方法
 * @param $grid
 * @param params
 */
var insert = function () {
    $(document.body).append('<div id="dialog"></div>');
    $('#dialog').dialog({
        title: '新增',
        width: 400,
        href: 'grid/grid.form?action=insert&gridName=' + params.gridName,
        modal: true,
        resizable: true,
        onLoad: function () {
            $('#form').find('#btnOk').click(function () {
                $('#form').form('submit', {
                    url: params.addUrl,
                    onSubmit: function () {
                        return $(this).form('enableValidation').form('validate');
                    },
                    success: function (data) {
                        $('#dialog').dialog('close');
                        $grid.datagrid('reload');
                        var r = JSON.parse(data);
                        if (r.status) {
                            layer.msg(r.message);
                        } else {
                            layer.msg('系统去开ufo了，请稍后重试！');
                        }
                    }
                });
            });
            $('#form').find('#btnCancel').click(function () {
                $('#form').form('clear');
            });
        },
        onClose: function () {
            $('#form').form('clear');
            $('#dialog').remove();
        }
    });
};

/**
 * 查询方法
 * @param $grid
 * @param params
 */
var search = function () {
    $(document.body).append('<div id="dialog"></div>');
    $('#dialog').dialog({
        title: '搜索栏',
        width: 400,
        href: 'grid/grid.form?action=search&gridName=' + params.gridName,
        left: 20,
        top: 50,
        modal: false,
        resizable: true,
        onLoad: function () {
            $('#form').find('#btnOk').click(function () {
                var formData = $('#form').serializeArray();
                var queryData = {};
                $.each(formData, function (i, v) {
                    if (v.value != '') {
                        queryData[v.name] = v.value;
                    }
                });
                $('#dialog').dialog('close');
                $grid.datagrid('load', queryData);
            });
            $('#form').find('#btnCancel').click(function () {
                $('#form').form('clear');
            });
        },
        onClose: function () {
            $('#dialog').remove();
        }
    });
};