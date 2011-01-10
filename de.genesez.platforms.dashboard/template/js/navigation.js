function showPackages() {
	$.ajax({
		async: false,
		url: "html/navigation/packages.html",
		success: function(html) {
			$('#packages').html(html);
			$('#classifier').empty();
			$('#coreTree').empty();
			$('#showPackages').addClass('currentNavigationItem');
			$('#showClassifier').removeClass('currentNavigationItem');
			$('#showCoreTree').removeClass('currentNavigationItem');
		}
	});
}

function showPackage(name) {
	$.ajax({
		async: false,
		url: "html/traceability/structure/" + name + "/package-summary.html",
		success: function(html) {
			$('#col3_content').html(html);
			showNavigation(-1);
		}
	});
}

function showClassifierList() {
	$.ajax({
		async: false,
		url: "html/navigation/classifier.html",
		success: function(html) {
			$('#classifier').html(html);
			$('#packages').empty();
			$('#coreTree').empty();
			$('#showPackages').removeClass('currentNavigationItem');
			$('#showClassifier').addClass('currentNavigationItem');
			$('#showCoreTree').removeClass('currentNavigationItem');
		}
	});
}

function showClassifier(path, name) {
	$.ajax({
		async: false,
		url: "html/traceability/structure/" + path + "/" + name + ".html",
		success: function(html) {
			$('#col3_content').html(html);
			showNavigation(-1);
		}
	});
}

function showScenarios() {
	$.ajax({
		async: false,
		url: "html/navigation/scenarios.html",
		success: function(html) {
			$('#scenarios').html(html);
			$('#requirements').empty();
			$('#showRequirements').removeClass('currentNavigationItem');
			$('#showScenarios').addClass('currentNavigationItem');
		}
	});
}

function showScenario(id) {
	$.ajax({
		async: false,
		url: "html/traceability/specification/scenarios/" + id + ".html",
		success: function(html) {
			$('#col3_content').html(html);
			showNavigation(-1);
		}
	});
}

function showRequirements() {
	$.ajax({
		async: false,
		url: "html/navigation/requirements.html",
		success: function(html) {
			$('#requirements').html(html);
			$('#scenarios').empty();
			$('#showRequirements').addClass('currentNavigationItem');
			$('#showScenarios').removeClass('currentNavigationItem');
		}
	});
}

function showRequirement(id) {
	$.ajax({
		async: false,
		url: "html/traceability/specification/requirements/" + id + ".html",
		success: function(html) {
			$('#col3_content').html(html);
			showNavigation(-1);
		}
	});
}

var navigation = ['Dashboard', 'Revised', 'Unsatisfied', 'Unspecified', 'Traceable'];

function openNavigation(index) {
	if (typeof(index) != 'number') index = 1;
	if (index < 0 || index > navigation.length) return;
	$.ajax({
		async: true,
		url: "html/traceability/" + navigation[index].toLowerCase() + ".html",
		success: function(html) {
			$('#col3_content').html(html);
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

$(window).load(showClassifierList);
$(window).load(showScenarios);
$(window).load(openNavigation);
$(window).load(function() {
	$('#showPackages').click(showPackages);
	$('#showClassifier').click(showClassifierList);
	$('#showScenarios').click(showScenarios);
	$('#showRequirements').click(showRequirements);
});
