/**
 * 使用说明：
 * 需要提供数据：
 */
// {
//     name: "导航信息表", // 配置表格
//     url: "menu/page.menu", // 表格数据加载路径
//     idUrl: "menu/get.id", // 使用id加载对象路径
//     addUrl: "menu/add.menu", // 添加对象路径
//     modifyUrl: "menu/modify.menu", // 更新对象路径
//     removeUrl: "menu/remove.menu"
// }


/**
 * 最外层使用变量
 */
var fDxWins, fDxWin, fDxLayout, fDxToolbar;
/**
 * 加载配置url
 * @type {string}
 */
var baseUrl = "grid/dx.grid.options?gridName=";
/**
 * 传入数据对象
 */
var requestData;
/**
 * 配置对象
 */
var data;

/**
 * 页面调用初始化方法
 * @param grid
 */
var init = function (grid) {
    requestData = grid;
    var url = baseUrl + grid.name;
    window.dhx4.ajax.get(url, function (response) {
        data = JSON.parse(response.xmlDoc.responseText);
        fWin();
        fLayout();
        fSearchForm();
        fBar();
        fGrid();
        fSearchClick();
        fToolBarClick();
    });
};

/**
 * 初始化最外层 win
 */
var fWin = function () {
    fDxWins = new dhtmlXWindows();
    fDxWins.attachViewportTo(document.body);
    fDxWin = fDxWins.createWindow("fDxWin", 0, 0, 1024, 650);
    fDxWin.setText(requestData.name);
    fDxWin.button("park").hide();
    fDxWin.button("minmax").hide();
    fDxWin.button("close").hide();
    fDxWin.maximize();
    fDxWin.keepInViewport(true);
};

/**
 * 实现 fDxWin 最大/小化
 */
var doResize = function () {
    fDxWin.minimize();
    fDxWin.maximize();
};

/**
 * 初始化最外层 layout
 */
var fLayout = function () {
    fDxLayout = new dhtmlXLayoutObject({
        parent: fDxWin,
        pattern: "2U",
        cells: [
            {id: "a", text: "搜索栏", header: true, width: 235, collapse: true, collapsed_text: "搜索栏"},
            {id: "b", header: false}
        ]
    });
};

/**
 * 第二层变量
 */
var sSearchForm, sGrid;

/**
 * 初始化左侧搜索栏
 * @param data
 */
var fSearchForm = function () {
    sSearchForm = fDxLayout.cells("a").attachForm();
    var formJson = [];
    formJson.push({type: "settings", position: "label-left", inputWidth: 150});
    formJson.push({
        type: "radio",
        name: "isServer",
        label: "页面结果",
        value: false,
        width: 80,
        position: "label-right",
        checked: true,
        offsetLeft: 10
    });
    formJson.push({type: "newcolumn"});
    formJson.push({
        type: "radio",
        name: "isServer",
        width: 80,
        value: true,
        position: "label-right",
        label: "后台结果",
        offsetLeft: 10
    });
    formJson.push({type: "newcolumn"});
    var titles = data.searchTitles.split(",");
    var ids = data.searchIds.split(",");
    var types = data.searchTypes.split(",");
    $(ids).each(function (i, id) {
        var node = {};
        node.type = types[i];
        node.name = id;
        node.label = titles[i] + "：";
        node.width = 100;
        formJson.push(node);
    });
    formJson.push({
        type: "block", offsetTop: 20, inputWidth: 200,
        list: [
            {type: "button", name: "search", value: "搜索", className: "button_search", width: 30},
            {type: "newcolumn"},
            {type: "button", name: "cancel", value: "取消", className: "button_cancel", width: 30}
        ]
    });
    sSearchForm.loadStruct(formJson);
};

/**
 * 绑定search的click事件
 */
var fSearchClick = function () {
    var form = sSearchForm;
    form.attachEvent("onButtonClick", function (name) {
        if (name == "search") {
            var isServer = form.getCheckedValue("isServer");
            var data = form.getFormData();
            if (isServer) {
                var params = [];
                for (var key in data) {
                    if (data[key] && "isServer" != key) {
                        params.push(key + "=" + data[key]);
                    }
                }
                reload(params.join("&"));
            } else {
                for (var key in data) {
                    if (data[key] && "isServer" != key) {
                        var index = sGrid.getColIndexById(key);
                        sGrid.filterBy(index, data[key]);
                    }
                }

            }
        }
        if (name == "cancel") {
            form.clear();
        }
    });
};

/**
 * 重新加载表
 * @param grid
 */
var reload = function (params) {
    sGrid.clearAll(true);
    var url = requestData.url;
    if (params.length > 0) {
        url += "?" + params;
    }
    // 表格重新加载需要初始化的值
    sGrid.setHeader(data.header);
    sGrid.setColumnIds(data.columnIds);
    sGrid.init();
    sGrid.load(url, "js");
};


/**
 * 初始化表格
 */
var fGrid = function () {
    sGrid = fDxLayout.cells("b").attachGrid();
    sGrid.i18n.paging = paging;
    sGrid.enablePaging(true, 20, 5, "pagingbox", true);
    sGrid.setImagePath("dhtmlx/skins/" + data.skin + "/imgs/");
    sGrid.setHeader(data.header);
    sGrid.setColumnIds(data.columnIds);
    sGrid.setColWidth("*");
    sGrid.init();
    sGrid.setSkin("dhx_" + data.skin);
    sGrid.setPagingSkin(data.pagingSkin);
    sGrid.load(requestData.url, "js");
}


/**
 * 初始化工具栏、分页栏
 */
var fBar = function () {
    fDxToolbar = fDxLayout.cells("b").attachToolbar({
        icons_path: "dhtmlx/icon/icons_" + data.skin + "/",
        json: [
            {id: "new", text: "新增", type: "button", img: "new.gif"},
            {type: "separator"},
            {id: "del", text: "删除", type: "button"},
            {type: "separator"},
            {id: "mdy", text: "修改", type: "button"}
        ]
    });
    fDxLayout.cells("b").attachStatusBar({
        height: {dhx_skyblue: 31, dhx_web: 31, dhx_terrace: 40}["dhx_" + data.skin],
        text: "<div id='pagingbox'></div>"
    });
};

/**
 * 绑定toolbar事件
 */
var fToolBarClick = function () {
    fDxToolbar.attachEvent("onClick", function (id) {
        if (id == "new") {
            fAdd();
        }
        if (id == "del") {
            var id = sGrid.getSelectedRowId();
            if (id) {
                window.dhx4.ajax.get(requestData.removeUrl + "?id=" + id, function (response) {
                    var data = JSON.parse(response.xmlDoc.responseText);
                    sGrid.deleteSelectedRows();
                    layer.msg(data.value);
                });
            } else {
                layer.msg("请选择要删除的记录！");
            }
        }
        if (id == "mdy") {
            fModify();
        }
    });
};

/**
 * 弹出框方法
 */
var fDialog = function (p) {
    // 添加新增win
    var dialogWin = fDxWins.createWindow("dialogWin", 200, 100, 350, 300);
    dialogWin.setText(p.text);
    dialogWin.setModal(true);
    dialogWin.button("park").hide();
    dialogWin.button("minmax").hide();
    dialogWin.keepInViewport(true);
    dialogWin.denyResize();
    var dialogToolbar = dialogWin.attachToolbar({
        icons_path: "dhtmlx/icon/icons_" + data.skin + "/",
        json: [
            {id: "save", text: "保存", type: "button", img: "save.gif"},
            {id: "cancel", text: "取消", type: "button"}
        ]
    });
    dialogToolbar.addSpacer("save");
    // 添加form对象
    var dialogForm = dialogWin.attachForm();
    dialogForm.loadStruct(p.formJson);
    dialogForm.enableLiveValidation(true);
    dialogForm.attachEvent("onFocus", function (name, value) {
        focus(dialogForm, name);
    });
    // 绑定事件
    dialogToolbar.attachEvent("onClick", function (id) {
        if (id == "save") {
            dialogForm.validate();
        }
        if (id == "cancel") {
            dialogWin.close();
        }
    });
    dialogForm.attachEvent("onAfterValidate", function (status) {
        if (status) {
            var data = dialogForm.getFormData();
            var params = [];
            for (var key in data) {
                if (data[key]) {
                    params.push(key + "=" + data[key]);
                }
            }
            alert(params.join("&"));
            // window.dhx4.ajax.get(p.url + params.join("&"), function (response) {
            //     var data = JSON.parse(response.xmlDoc.responseText);
            //     layer.msg(data.value);
            //     dialogWin.close();
            // });
        }
    });
};

/**
 * 添加方法
 */
var fAdd = function () {
    var formJson = [];
    formJson.push({type: "settings", position: "label-left", labelWidth: 100, inputWidth: 150});
    var titles = data.insertTitles.split(",");
    var ids = data.insertIds.split(",");
    var types = data.insertTypes.split(",");
    $(ids).each(function (i, id) {
        var node = {};
        node.type = types[i];
        if (types[i] == "hide") {
            node.type = "input";
        }
        node.name = id;
        node.label = titles[i] + "：";
        node.required = true;
        node.validate = "NotEmpty";
        node.width = 100;
        node.offsetTop = 10;
        node.labelLeft = 30;
        formJson.push(node);
    });
    fDialog({
        text: "新增", formJson: formJson, url: requestData.addUrl + "?"
    });
};


/**
 * 更新方法
 */
var fModify = function () {
    var formJson = [];
    formJson.push({type: "settings", position: "label-left", labelWidth: 100, inputWidth: 150});
    var titles = data.modifyTitles.split(",");
    var ids = data.modifyIds.split(",");
    var id = sGrid.getSelectedRowId();
    if (id) {
        window.dhx4.ajax.get(requestData.idUrl + "?id=" + id, function (response) {
            var data = JSON.parse(response.xmlDoc.responseText);
            $(ids).each(function (i, id) {
                var node = {type: "input"};
                node.name = id;
                node.label = titles[i] + "：";
                node.value = data[id];
                node.width = 100;
                node.offsetTop = 10;
                node.labelLeft = 30;
                formJson.push(node);
            });
            fDialog({
                text: "更新", formJson: formJson, url: requestData.modifyUrl + "?id=" + id + "&"
            });
        });
    }
    else {
        layer.msg("请选择需要更新的记录！")
    }
};


/**
 * 分页控件设置
 * @type {{results: string, records: string, to: string, page: string, perpage: string, first: string, previous: string, found: string, next: string, last: string, of: string, notfound: string}}
 */
var paging = {
    results: "结果",
    records: "记录从 ",
    to: " 到 ",
    page: "页码 ",
    perpage: " 条每页",
    first: "首页",
    previous: "下一页",
    found: "查询结果",
    next: "下一页",
    last: "尾页",
    of: " 总计 ",
    notfound: "查询无结果"
};