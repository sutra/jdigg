function clk(who, id) {
	// Digg.hit(id);
	if (document.images) {
		var p = new Image();
		p.src = "hit.html?id=" + id;
	}
	who.onmousedown="";
	return true;
}