function clk(who, id) {
	Digg.hit(id);
	who.onmousedown="";
	return true;
}