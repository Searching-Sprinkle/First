
/*全选全不选*/
function checkall(ckbtn) {
	$(".ckitem").prop("checked", $(ckbtn).prop("checked"));
	//calcTotal();
}
//删除按钮
function delCartItem(btn) {
	
	$(btn).parents("tr").remove();
	//calcTotal();
}
//批量删除按钮
function selDelCart() {
	//遍历所有按钮
	for (var i = $(".ckitem").length - 1; i >= 0; i--) {
		//如果选中
		if ($(".ckitem")[i].checked) {
			//删除
			$($(".ckitem")[i]).parents("tr").remove();
		}
	}
	//calcTotal();
}
$(function() {
	//单选一个也得算价格
	$(".ckitem").click(function() {
			//calcTotal();
		})
		//开始时计算价格
		//calcTotal();
})
//计算单行小计价格的方法
function calcRow(rid) {
	//取单价
	var vprice = parseFloat($("#goodsPrice"+rid).html());
	//取数量
	var vnum = parseFloat($("#goodsCount"+rid).val());
	//小计金额
	var vtotal = vprice * vnum;
	//赋值
	$("#goodsCast"+rid).html("¥" + vtotal);
}
