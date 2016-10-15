$(document).ready(function(){

	// HTML markup implementation, overlap mode
	$( '#menu' ).multilevelpushmenu({
		containersToPush: [$( '#pushobj' )],
		menuHeight: '100%',
		menuWidth: '250px',
		collapsed: true
	});

	$(window).resize(function () {
		$( '#menu' ).multilevelpushmenu( 'redraw' );
	});


});

