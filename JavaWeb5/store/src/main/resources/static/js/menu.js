//修改这个变量为实际控制器的地址，如../showGoods.do
var reqpath = "search.html"
/*ajax获得的json对象*/
var typelist = [/*{
	"id": "1",
	"parentId": "0",
	"name": "弯头",
}, {
	"id": "2",
	"parentId": "0",
	"name": "双相钢管件"
}, {
	"id": "3",
	"parentId": "0",
	"name": "盲板"
}, {
	"id": "4",
	"parentId": "0",
	"name": "三通"
}, {
	"id": "5",
	"parentId": "0",
	"name": "无缝管"
}, {
	"id": "6",
	"parentId": "0",
	"name": "异径管"
}, {
	"id": "7",
	"parentId": "0",
	"name": "泵管"
}, {
	"id": "8",
	"parentId": "0",
	"name": "封头"
}, {
	"id": "9",
	"parentId": "0",
	"name": "套管"
}, {
	"id": "10",
	"parentId": "0",
	"name": "承插件",
},*/ {
	"id": "11",
	"parentId": "0",
	"name": "对焊管",
},{
	"id": "12",
	"parentId": "0",
	"name": "管座",
},{
	"id": "13",
	"parentId": "0",
	"name": "支管台",
},{
	"id": "14",
	"parentId": "0",
	"name": "液压法兰",
},{
	"id": "15",
	"parentId": "0",
	"name": "钢制法兰",
},{
	"id": "16",
	"parentId": "0",
	"name": "带颈对焊法兰",
},{
	"id": "17",
	"parentId": "0",
	"name": "板式平焊法兰",
},{
	"id": "18",
	"parentId": "0",
	"name": "扳把式快速接头",
},{
	"id": "19",
	"parentId": "0",
	"name": "法兰盖",
},{
	"id": "20",
	"parentId": "1",
	"name": "45°弯头"
},{
	"id": "21",
	"parentId": "1",
	"name": "90°弯头"
},{
	"id": "22",
	"parentId": "1",
	"name": "180°弯头"
},{
	"id": "23",
	"parentId": "2",
	"name": "UNS S31803/F51 双相不锈钢法兰管件"
},{
	"id": "24",
	"parentId": "2",
	"name": "UNS S32750/F53 双相钢法兰管件"
},{
	"id": "25",
	"parentId": "2",
	"name": "UNS S31254/F44 双相不锈钢法兰管件"
},{
	"id": "26",
	"parentId": "3",
	"name": "板式平板盲板"
},{
	"id": "27",
	"parentId": "3",
	"name": "8 字盲板"
},{
	"id": "28",
	"parentId": "3",
	"name": "插板"
},{
	"id": "29",
	"parentId": "4",
	"name": "TY三通"
},{
	"id": "30",
	"parentId": "4",
	"name": "Y三通"
},{
	"id": "31",
	"parentId": "4",
	"name": "顺水三通 "
},{
	"id": "32",
	"parentId": "5",
	"name": "热轧无缝钢管"
},{
	"id": "33",
	"parentId": "5",
	"name": "冷轧无缝钢管"
},{
	"id": "34",
	"parentId": "5",
	"name": "挤压无缝钢管"
},{
	"id": "35",
	"parentId": "6",
	"name": "圆形变径管"
},{
	"id": "36",
	"parentId": "6",
	"name": "矩形变径管"
},{
	"id": "37",
	"parentId": "6",
	"name": "方形变径管"
},{
	"id": "38",
	"parentId": "7",
	"name": "80型泵管"
},{
	"id": "39",
	"parentId": "7",
	"name": "125型泵管"
},{
	"id": "40",
	"parentId": "7",
	"name": "150型泵管"
},{
	"id": "41",
	"parentId": "8",
	"name": "不锈钢封头"
},{
	"id": "42",
	"parentId": "8",
	"name": "碳素钢封头"
},{
	"id": "43",
	"parentId": "8",
	"name": "复合板封头"
},{
	"id": "44",
	"parentId": "9",
	"name": "刚性套管"
},{
	"id": "45",
	"parentId": "10",
	"name": "90度承插焊弯头"
},{
	"id": "46",
	"parentId": "10",
	"name": "承插焊三通"
},{
	"id": "47",
	"parentId": "10",
	"name": "同心螺纹渐缩管"
},{
	"id": "48",
	"parentId": "11",
	"name": "镀锌焊管"
},{
	"id": "49",
	"parentId": "11",
	"name": "吹氧焊管"
},{
	"id": "50",
	"parentId": "11",
	"name": "公制焊管"
},{
	"id": "51",
	"parentId": "12",
	"name": "对焊管座"
},{
	"id": "52",
	"parentId": "12",
	"name": "承插焊管座"
},{
	"id": "53",
	"parentId": "12",
	"name": "螺纹管座"
},{
	"id": "54",
	"parentId": "13",
	"name": "短管支管台"
},{
	"id": "55",
	"parentId": "13",
	"name": "斜支管台"
},{
	"id": "56",
	"parentId": "13",
	"name": "镶入式支管台"
},{
	"id": "57",
	"parentId": "14",
	"name": "平焊液压"
},{
	"id": "58",
	"parentId": "14",
	"name": "锁口液压"
},{
	"id": "59",
	"parentId": "14",
	"name": "带颈液压"
},{
	"id": "60",
	"parentId": "15",
	"name": "不锈钢法兰"
},{
	"id": "61",
	"parentId": "15",
	"name": "平焊钢法兰"
},{
	"id": "62",
	"parentId": "15",
	"name": "对焊钢法兰"
},{
	"id": "63",
	"parentId": "16",
	"name": "美标ASME B16.5"
},{
	"id": "64",
	"parentId": "16",
	"name": "德标DIN 2630"
},{
	"id": "65",
	"parentId": "16",
	"name": "国标GB/T 9112-2010"
},{
	"id": "66",
	"parentId": "17",
	"name": "德标DIN 2576"
},{
	"id": "67",
	"parentId": "17",
	"name": "欧标EN 1092-1"
},{
	"id": "68",
	"parentId": "17",
	"name": "国标 GB/T 9113.1-2000"
},{
	"id": "69",
	"parentId": "18",
	"name": "A型快速接头"
},{
	"id": "70",
	"parentId": "18",
	"name": "母头外螺纹接头"
},{
	"id": "71",
	"parentId": "18",
	"name": "宝塔头快速接头"
},{
	"id": "72",
	"parentId": "19",
	"name": "平面盲板法盖"
},{
	"id": "73",
	"parentId": "19",
	"name": "凸缘盲板盖"
},{
	"id": "74",
	"parentId": "19",
	"name": "环槽盲板盖"
}, {
	"id": "75",
	"parentId": "9",
	"name": "柔性套管"
},{
	"id": "76",
	"parentId": "9",
	"name": "防水套管"
},]
//加载json数据的到一级分类的方法
function initMenu() {
	for (var i = 0; i < typelist.length; i++) {

		if (typelist[i].parentId == "0") {

			$(".index-menu").append($("<li data='" + typelist[i].id + "'>" + typelist[i].name + "</li>"))
		}
	}
}

window.addEventListener("load", function() {
	initMenu();
	//根据轮播图片的高，导航的高
	//获得轮播图高
	var lunh = $("#myCarousel").height();
	var lih = (lunh - 10) / 18;
	//确定导航高度
	$(".index-menu li").css("height", lih + "px")
	//确定按钮位置	
	var btnt = Math.floor($("#myCarousel").height() / 2 - 30);
	$(".left").css("margin-top", btnt + "px");
	$(".right").css("margin-top", btnt + "px");
	/*左侧分类一级菜单控制二级菜单显示和隐藏*/
	$(".index-menu").hover(function() {
		$("#showIndex").show();
	}, function() {
		$("#showIndex").hide();
	})
	/*左侧分类二级菜单控制三级菜单显示和隐藏*/
	$(".second-menu").hover(function() {
		$("#showSecond").show();
	}, function() {
		$("#showSecond").hide();
	})
	/*二级菜单自己控制显示和隐藏*/
	$("#showIndex").hover(function() {
		$("#showIndex").show();
	}, function() {
		$("#showIndex").hide();
	})
	/*三级菜单自己控制显示和隐藏*/
	$("#showSecond").hover(function() {
		$("#showIndex").show();
		$("#showSecond").show();
	}, function() {
		$("#showIndex").hide();
		$("#showSecond").hide();
	})
	/*一级分类项li鼠标移入移出*/
	var offTop = -100;
	var offLeft = 0;
	$(".index-menu li").hover(function() {
		$(".second-menu").empty();
		/*加载json数据*/
		for (var i = 0; i < typelist.length; i++) {
			if ($(this).attr("data") == typelist[i].parentId) {
				$(".second-menu").append($("<li class='second-menu-li' data='" + typelist[i].id +
					"' >" + typelist[i].name + "</li>"))
			}
		}
		offLeft = $(this).width() + $(this).offset().left;
		offTop = $(this).offset().top;
		$("#showIndex").css("top", offTop - 2 + "px")
		$("#showIndex").css("left", offLeft - 1 + "px")
		$(this).css("background-color", "#f5f5f5");
		$(this).css("color", "#4288c3");
	}, function() {
		$(this).css("background-color", "");
		$(this).css("color", "");
	})
	/*二级分类项li鼠标移入移出*/
	$(".second-menu-li").on("mouseover", function() {
		$(".third-menu").empty();
		/*加载数据*/
		for (var i = 0; i < typelist.length; i++) {
			if ($(this).attr("data") == typelist[i].parentId) {}
			//alert($(document).scrollTop() +":"+$(this).offset().top)
			var ot = $(document).scrollTop() == $(this).offset().top ? offTop : $(this).offset().top;
			var ol = $(this).width() + $(this).offset().left;
			$("#showSecond").css("top", ot - 2 + "px");
			$("#showSecond").css("left", ol + "px")
			$(this).css("background-color", "#4288c3");
			$(this).css("color", "#f5f5f5");
		}
		$(".second-menu-li").live("mouseout", function() {
			$(this).css("background-color", "");
			$(this).css("color", "");
		})
		/*三级分类项li鼠标移入移出*/
		$(".third-menu-li").live("mouseover", function() {
			$(this).css("background-color", "#dddddd");
			$(this).css("color", "#000000");
		})
		$(".third-menu-li").live("mouseout", function() {
			$(this).css("background-color", "");
			$(this).css("color", "");
		})
	})
})
