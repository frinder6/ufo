/**
 *
 */
var dxLayout, dxWins, dxWin, dxGrid, dxToolbar;
var baseUrl = "grid/dx.grid.options?gridName=";

/**
 * dhxLayoutGrid
 * @param grid
 */
var dhxLayoutGrid = function (grid) {
    dxLayout = new dhtmlXLayoutObject({
        parent: document.body,
        pattern: "2U",
        cells: [
            {id: "a", text: "搜索栏", header: true, width: 235, collapse: true, collapsed_text: "搜索栏"},
            {id: "b", header: false}
        ]
    });

    dxLayout.cells("b").attachToolbar({
        icons_path: "dhtmlx/icon/icons_web/",
        json: buttons
    });

    var url = baseUrl + grid.name;
    window.dhx4.ajax.get(url, function (response) {
        var data = JSON.parse(response.xmlDoc.responseText);
        var searchForm = dxLayout.cells("a").attachForm();
        searchForm.loadStruct(formJson(data));
        dxLayout.cells("b").attachStatusBar({
            height: {dhx_skyblue: 30, dhx_web: 31, dhx_terrace: 40}[data.skin],
            text: "<div id='pagingbox'></div>"
        });
        dxGrid = dxLayout.cells("b").attachGrid();
        gridSettings(data);
        dxGrid.load(grid.url, "js");
    });
};

/**
 *
 * @type {*[]}
 */
var formJson = function (data) {
    var formJson = [];
    formJson.push({type: "settings", position: "label-left", labelWidth: 80, inputWidth: 100});
    var titles = data.searchTitles.split(",");
    var ids = data.searchIds.split(",");
    $(ids).each(function (i, id) {
        var node = {type: "input"};
        node.name = id;
        node.label = titles[i] + "：";
        formJson.push(node);
    });
    formJson.push({
        type: "block", offsetTop: 20, inputWidth: 200,
        list: [
            {type: "button", value: "搜索", className: "button_search", width: 30},
            {type: "newcolumn"},
            {type: "button", value: "取消", className: "button_cancel", width: 30}
        ]
    });
    return formJson;
};


/**
 * dhxWindowGrid
 * @param grid
 */
var dhxWindowGrid = function (grid) {
    dxWins = new dhtmlXWindows();
    dxWins.attachViewportTo("dxWindow");
    dxWin = dxWins.createWindow("dxWin", 0, 0, 1024, 650);
    dxWin.setText(grid.name);
    dxWin.button("park").hide();
    dxWin.button("minmax").hide();
    dxWin.button("close").hide();
    dxWin.maximize();
    dxWin.keepInViewport(true);
    dxToolbar = dxWin.attachToolbar({
        icons_path: "dhtmlx/icon/icons_web/",
        json: buttons
    });

    var url = baseUrl + grid.name;
    window.dhx4.ajax.get(url, function (response) {
        var data = JSON.parse(response.xmlDoc.responseText);
        dxWin.attachStatusBar({
            height: {dhx_skyblue: 30, dhx_web: 31, dhx_terrace: 40}[data.skin],
            text: "<div id='pagingbox'></div>"
        });
        dxGrid = dxWin.attachGrid();
        gridSettings(data);
        dxGrid.load(grid.url, "js");
    });
};

/**
 * doResize
 */
var doResize = function () {
    dxWin.minimize();
    dxWin.maximize();
};


/**
 * grid settings
 * @param data
 */
var gridSettings = function (data) {
    dxGrid.i18n.paging = paging;
    dxGrid.enablePaging(true, 20, 5, "pagingbox", true);
    dxGrid.setImagePath(data.imagePath);
    dxGrid.setHeader(data.header);
    // dxGrid.setColumnIds(data.columnIds);
    dxGrid.setColWidth("*");
    dxGrid.init();
    dxGrid.setSkin(data.skin);
    dxGrid.setPagingSkin(data.pagingSkin);
};

/**
 *
 * @type {*[]}
 */
var buttons = [
    {id: "new", text: "新增", type: "button", img: "new.gif"},
    {type: "separator"},
    {id: "del", text: "删除", type: "button"},
    {type: "separator"},
    {id: "mdy", text: "修改", type: "button"}
];

/**
 * paging 设置
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