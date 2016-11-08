/**
 * 最外层使用变量
 */
var fDxWins, fDxWin, fDxLayout, fDxToolbar;
var baseUrl = "grid/dx.grid.options?gridName=";
var data;

var init = function (grid) {
    var url = baseUrl + grid.name;
    window.dhx4.ajax.get(url, function (response) {
        data = JSON.parse(response.xmlDoc.responseText);
        fWin(grid);
        fLayout();
        fSearchForm();
        fBar();
        fGrid(grid);
    });
};

/**
 * 初始化最外层 win
 */
var fWin = function (grid) {
    fDxWins = new dhtmlXWindows();
    fDxWins.attachViewportTo(document.body);
    fDxWin = fDxWins.createWindow("fDxWin", 0, 0, 1024, 650);
    fDxWin.setText(grid.name);
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
        label: "当前结果",
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
    $(ids).each(function (i, id) {
        var node = {type: "input"};
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
 * 初始化表格
 */
var fGrid = function (grid) {
    sGrid = fDxLayout.cells("b").attachGrid();
    sGrid.i18n.paging = paging;
    sGrid.enablePaging(true, 20, 5, "pagingbox", true);
    sGrid.setImagePath(data.imagePath);
    sGrid.setHeader(data.header);
    sGrid.setColumnIds(data.columnIds);
    sGrid.setColWidth("*");
    sGrid.init();
    sGrid.setSkin(data.skin);
    sGrid.setPagingSkin(data.pagingSkin);
    sGrid.load(grid.url, "js");
}


/**
 * 初始化工具栏、分页栏
 */
var fBar = function () {
    fDxToolbar = fDxLayout.cells("b").attachToolbar({
        icons_path: "dhtmlx/icon/icons_web/",
        json: [
            {id: "new", text: "新增", type: "button", img: "new.gif"},
            {type: "separator"},
            {id: "del", text: "删除", type: "button"},
            {type: "separator"},
            {id: "mdy", text: "修改", type: "button"}
        ]
    });
    fDxLayout.cells("b").attachStatusBar({
        height: {dhx_skyblue: 30, dhx_web: 31, dhx_terrace: 40}[data.skin],
        text: "<div id='pagingbox'></div>"
    });
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