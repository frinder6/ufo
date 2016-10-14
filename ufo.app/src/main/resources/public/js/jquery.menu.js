!(function ($, window, document, undefined) {

    var defaults = {
        url: ''
    };

    var Menu = function (element, options) {
        this.$this = element;
        this.$opts = options;
    };

    Menu.prototype = {
        constructor: Menu,
        init: function () {
            var e = this;
            $.ajax({
                type: 'POST',
                url: e.$opts.url,
                dataType: 'JSON',
                async: false,
                success: function (data) {
                    e.data = data;
                },
                error: function (msg) {
                    layer.msg(msg);
                }
            });
        },
        createMenu: function () {

        }
    };

    $.fn.Menu = function (options) {
        var menu = new Menu(this, options);
        return menu;
    };

    $.fn.Menu.Constructor = Menu;

})(jQuery, window, document);