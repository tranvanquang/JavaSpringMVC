$(document).ready(function() {
	$('.single-bed').click(function(event) {
		$('.single-bed-rooms-list').removeClass('display-none');
		$('.single-bed').addClass('select-type-room');
		$('.couple-bed-rooms-list').addClass('display-none');
		$('.couple-bed').removeClass('select-type-room');
	});
	$('.couple-bed').click(function(event) {
		$('.couple-bed-rooms-list').removeClass('display-none');
		$('.couple-bed').addClass('select-type-room');
		$('.single-bed-rooms-list').addClass('display-none');
		$('.single-bed').removeClass('select-type-room');
	})
});