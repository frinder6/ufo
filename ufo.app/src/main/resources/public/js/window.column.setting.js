$lgrid = $('#lgrid');
$rgrid = $('#rgrid');
var gridId = selectRow.id;
grid($lgrid, {gridName: 'conf-grid-columns-info'}, {gridId: gridId});
grid($rgrid, {gridName: 'conf-table-columns-info'});

/**
 * 左表保存方法
 */
var _lsave = function () {
    var rows = $lgrid.datagrid('getChanges');
    console.log(rows);
    if (rows) {
        $.ajax({
            url: '/grid/add.columns',
            type: "POST",
            data: JSON.stringify({
                gridId: gridId,
                entityList: rows
            }),
            success: function (data) {
                layer.msg(data.message);
            },
            dataType: 'json',
            contentType: 'application/json'
        });
    }
};

/**
 * 左表删除方法
 */
var _lremove = function () {
    remove($lgrid, {removeUrl: '/grid/remove.column'});
};

/**
 * 右表导入方法
 */
var _rimport = function () {
    var rows = $rgrid.datagrid('getSelections');
    // 先添加
    $.each(rows, function (i, row) {
        $lgrid.datagrid('appendRow', row);
    });
    // 后删除
    $.each(rows, function (i, row) {
        $rgrid.datagrid('deleteRow', $rgrid.datagrid('getRowIndex', row));
    });
};

/**
 * 下拉grid变化时触发事件
 * @param v
 */
var _rchange = function (v) {
    $rgrid.datagrid('load', {tableName: v, gridId: parent.selectRow.id});
};