/**
 * 加载表格
 * @param params
 */
var grid = function ($grid, p, q) {
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
        if (q) {
            data.queryParams = {};
            $.extend(true, data.queryParams, q);
        }
        data.onSelect = function () {
            selectRow = $grid.datagrid('getSelected');
        };
        data.onUnselect = function () {
            var r = $grid.datagrid('getSelected');
            if (r) {
                selectRow = r;
            } else {
                selectRow = null;
            }
        };
        console.log(data);
        $grid.datagrid(data);
    });
};

/**
 * 删除方法
 * @param removeUrl
 */
var remove = function ($grid, p) {
    var row = $grid.datagrid('getSelected');
    if (row) {
        $.messager.confirm('删除操作确认', '确认删除选中记录？', function (r) {
            if (r) {
                $.getJSON(p.removeUrl, {id: row.id}, function (data) {
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
var modify = function ($grid, p) {
    var row = $grid.datagrid('getSelected');
    if (row) {
        var d = 'win_' + new Date().getMilliseconds();
        $(document.body).append('<div id="' + d + '" class="dialog"></div>');
        var $dialog = $('#' + d);
        $dialog.dialog({
            title: '更新',
            width: 400,
            href: 'grid/grid.form?action=modify&gridName=' + p.gridName,
            modal: true,
            resizable: true,
            onLoad: function () {
                $('#form').form('load', row);
                $('#form').find('#btnOk').click(function () {
                    $('#form').form('submit', {
                        url: p.modifyUrl + '?id=' + row.id,
                        onSubmit: function () {
                            return $(this).form('enableValidation').form('validate');
                        },
                        success: function (data) {
                            $grid.datagrid('reload');
                            $dialog.dialog('close');
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
                $dialog.remove();
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
var insert = function ($grid, p) {
    var d = 'win_' + new Date().getMilliseconds();
    $(document.body).append('<div id="' + d + '" class="dialog"></div>');
    var $dialog = $('#' + d);
    $dialog.dialog({
        title: '新增',
        width: 400,
        href: 'grid/grid.form?action=insert&gridName=' + p.gridName,
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
                        $dialog.dialog('close');
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
            $dialog.remove();
        }
    });
};

/**
 * 查询方法
 * @param $grid
 * @param params
 */
var search = function ($grid, p) {
    var d = 'win_' + new Date().getMilliseconds();
    $(document.body).append('<div id="' + d + '" class="dialog"></div>');
    var $dialog = $('#' + d);
    $dialog.dialog({
        title: '搜索栏',
        width: 400,
        href: 'grid/grid.form?action=search&gridName=' + p.gridName,
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
                $dialog.dialog('close');
                $grid.datagrid('load', queryData);
            });
            $('#form').find('#btnCancel').click(function () {
                $('#form').form('clear');
            });
        },
        onClose: function () {
            $dialog.remove();
        }
    });
};


/**
 * 选择一条记录后打开
 * @param url
 */
var open = function (url, p) {
    var row = $grid.datagrid('getSelected');
    if (row) {
        var d = 'win_' + new Date().getMilliseconds();
        $(document.body).append('<div id="' + d + '" style="overflow:hidden"></div>');
        var $dialog = $('#' + d);
        var title = '';
        if (selectRow) {
            title = '[ ' + selectRow.name + ' ]';
        }
        var options = {
            title: title + '配置窗',
            width: 800,
            height: 600,
            left: 100,
            top: 30,
            modal: true,
            // fit: true,
            collapsible: false,
            minimizable: false,
            maximizable: false,
            // draggable: false,
            resizable: false,
            iconCls: 'icon-save',
            content: $('<iframe src="' + url + '" width="100%" height="100%" frameborder="0" scrolling="no"></iframe>'),
            onClose: function () {
                $dialog.remove();
            }
        };
        if (p) {
            $.extend(true, options, p);
        }
        $dialog.window(options);
    } else {
        layer.msg('请选择需要配置的记录！');
    }
};


