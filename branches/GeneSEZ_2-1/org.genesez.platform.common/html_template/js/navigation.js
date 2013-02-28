var navigation = new Array();

function startUp(){
	/**
	 * If you want to support more files, just add them here
	 */
	var supported = ['Overview', 'Details'];
	
	root = document.getElementById('navigate');
	var ul_element = document.createElement('ul');
	for(var i = 0; i < supported.length; i++){
		var element = supported[i];
		$.ajax({
			async: false,
			url: "html/" + element.toLowerCase() + ".html",
			success: function(){
				navigation.push(element);
				li_element = document.createElement('li');
				li_element.appendChild(document.createTextNode(element));
				ul_element.appendChild(li_element);
			}
		});
	}
	ul_element.setAttribute('id','navigation');
	root.appendChild(ul_element);
	showNavigation(0);
}

function openNavigation(index) {
	if (typeof(index) != 'number') index = 0;
	if (index < 0 || index > navigation.length) return;
	$.ajax({
		async: true,
		url: "html/" + navigation[index].toLowerCase() + ".html",
		success: function(html) {
			$('#main_content').html(html);
			showNavigation(index);
		}
	});
}

function showNavigation(active) {
	$('#navigation > li').each( function(i, element) {
		if (i == active) {
			$(element).html('<strong>' + navigation[i] + '</strong>');
			$(element).addClass('active');
		} else {
			$(element).html('<a href="#">' + navigation[i] + '</a>');
			$(element).removeClass('active');
			$(element).click(function() { openNavigation(i); });
		}
	});
}

$(window).load(startUp);
$(window).load(openNavigation);