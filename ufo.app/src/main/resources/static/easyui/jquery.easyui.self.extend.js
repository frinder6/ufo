/**
 * 定义下面2个参数后，即可自动完成功能
 */
var $grid;
var params = {gridName: '', removeUrl: '', addUrl: '', modifyUrl: ''};
var selectRow;

/**
 * 加载表格，使用全局参数
 * @param params
 */
var _grid = function () {
    grid($grid, params);
};


/**
 * 删除方法
 * @param removeUrl
 */
var _remove = function () {
    remove($grid, params);
};

/**
 * 修改方法
 * @param $grid
 * @param modifyUrl
 */
var _modify = function () {
    modify($grid, params);
};

/**
 * 添加方法
 * @param $grid
 * @param params
 */
var _insert = function () {
    insert($grid, params);
};

/**
 * 查询方法
 * @param $grid
 * @param params
 */
var _search = function () {
    search($grid, params);
};