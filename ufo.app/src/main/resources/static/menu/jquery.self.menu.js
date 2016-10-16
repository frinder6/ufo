$(function () {

    /**
     * 加载menu
     */
    var loadMenu = function () {
        $.ajax({
            type: 'POST',
            url: 'menu/server.menu',
            dataType: 'JSON',
            async: true,
            success: function (data) {
                $('#menu').html(data.value);
                initMenu();
            },
            error: function (msg) {
                console.log(msg);
            }
        });
    };

    loadMenu();

    var initMenu = function () {
        /**
         * 初始化菜单项
         */
        $('nav#menu').mmenu({
            extensions: ['effect-slide-menu', 'shadow-page', 'shadow-panels'],
            counters: true,
            iconPanels: true,
            navbar: {
                title: '导航栏'
            },
            navbars: [
                {
                    position: 'top',
                    content: ['searchfield']
                }, {
                    position: 'top',
                    content: [
                        'prev',
                        'title',
                        'close'
                    ]
                }, {
                    position: 'bottom',
                    content: [
                        '<a href="http://mmenu.frebsite.nl/wordpress-plugin.html" target="_blank">WordPress plugin</a>'
                    ]
                }
            ]
        });
    };

});