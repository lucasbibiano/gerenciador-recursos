$(document).ready(function() {
	var url = window.location.href;
	url = url.substr(url.indexOf("/") + 1);
	url = url.substr(url.indexOf("/") + 1);
	url = url.substr(url.indexOf("/"));
	
	$('.hue').text(url);
	
	$(".subnav").find("li:has(a[href='" + url + "'])").addClass("active");
});