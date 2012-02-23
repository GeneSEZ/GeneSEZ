var current;

function showOutput(id) {
	if (current) $('#' + current + '> div.output').empty();
	if (current == id) {
		current = undefined;
		return;
	}
	current = id;
	$.ajax({
		async: false,
		url: "html/" + id + ".html",
		success: function(html) {
			$('#' + id + ' div.output').html(html);
		}
	});
}

$(window).load( function() {
	$.ajax({
		async: false,
		url: "html/results.html",
		success: function(html) {
			$('#main_content').html(html);
		}
	});
});
