$(document).ready(function() {
	var url = window.location.href;
	
	url = url.substr(37, url.length);
	$('hue').text(url);
	url = url.substr(0, url.indexOf("/"));
	
	$(".subnav").find("li:has(a[href*='" + url + "'])").addClass("active");
});