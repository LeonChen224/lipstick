
$(function(){
	
	var time = 3 * 1000;// 滑动时间间隔
	var bottom_time = 6 * 1000; // 进入下方时滑块时间间隔
	
	var spLength = $('.slide_point span').length,
		scimgWidth = $(window).width(),
		sulWidth = scimgWidth * spLength,
		sNum = 0;
		$(".slide_cont ul").width(sulWidth);
		$(".slide_cont ul li").width(scimgWidth);
	var sTimer = setInterval(moveSlide,time);
	function moveSlide(){
			sNum++;
			if (sNum >= spLength) {
				sNum = 0;
			};
			showPics(sNum);
		}
	//鼠标移入下方的块进行滚动
	$('.slide_point span').mouseover(function(){
			clearInterval(sTimer);
			sNum = $(this).index();
			showPics(sNum);
		}).mouseleave(function(){
			sTimer = setInterval(moveSlide,bottom_time);
		});
	//图片自动滚动
	function showPics(sNum){
		$(".slide_point span").eq(sNum).find('img').attr('src','img/image/2_'+(sNum+1)+'.png');
		$(".slide_point span").eq(sNum).find('img').css({'width':'210px','height':'280px'});
		$(".slide_point span").find('img').each(function(index){
			if(sNum!=index){
				$(this).attr('src','img/image/0_'+(index+1)+'.png');
				$(this).css({'width':'200px','height':'250px'});
			}
		});
		$(".slide_point span").eq(sNum).addClass("cur_point").siblings().removeClass("cur_point");
		$(".slide_cont ul").animate({
			"margin-left" : -scimgWidth * sNum 
		});

	}
});
	
	
	
(function($){
	
$.fn.tabso=function( options ){

	var opts=$.extend({},$.fn.tabso.defaults,options );
	
	return this.each(function(i){
		var _this=$(this);
		var $menus=_this.children( opts.menuChildSel );
		var $container=$( opts.cntSelect ).eq(i);
		
		if( !$container) return;
		
		if( opts.tabStyle=="move"||opts.tabStyle=="move-fade"||opts.tabStyle=="move-animate" ){
			var step=0;
			if( opts.direction=="left"){
				step=$container.children().children( opts.cntChildSel ).outerWidth(true);
			}else{
				step=$container.children().children( opts.cntChildSel ).outerHeight(true);
			}
		}
		
		if( opts.tabStyle=="move-animate" ){ var animateArgu=new Object();	}
		
		$menus[ opts.tabEvent]( function(){
			var index=$menus.index( $(this) );
			$( this).addClass( opts.onStyle )
				.siblings().removeClass( opts.onStyle )
			$( this).children('em').addClass(opts.onStyle2);
			$( this).siblings().children('em').removeClass( opts.onStyle2 );
			switch( opts.tabStyle ){
				case "fade":
					if( !($container.children( opts.cntChildSel ).eq( index ).is(":animated")) ){
						$container.children( opts.cntChildSel ).eq( index ).siblings().css( "display", "none")
							.end().stop( true, true ).fadeIn( opts.aniSpeed );
					}
					break;
				case "move":
					$container.children( opts.cntChildSel ).css(opts.direction,-step*index+"px");
					break;
				case "move-fade":
					if( $container.children( opts.cntChildSel ).css(opts.direction)==-step*index+"px" ) break;
					$container.children( opts.cntChildSel ).stop(true).css("opacity",0).css(opts.direction,-step*index+"px").animate( {"opacity":1},opts.aniSpeed );
					break;
				case "move-animate":
					animateArgu[opts.direction]=-step*index+"px";
					$container.children( opts.cntChildSel ).stop(true).animate( animateArgu,opts.aniSpeed,opts.aniMethod );
					break;
				default:
					$container.children( opts.cntChildSel ).eq( index ).css( "display", "block")
						.siblings().css( "display","none" );
			}
	
		});
		
		$menus.eq(0)[ opts.tabEvent ]();
		
	});
};	

$.fn.tabso.defaults={
	cntSelect : ".content_wrap",
	tabEvent2 : "mouseleave",
	tabEvent : "mouseover",
	tabStyle : "normal",
	direction : "top",
	aniMethod : "swing",
	aniSpeed : "fast",
	onStyle : "current",
	onStyle2:"tab2",
	menuChildSel : "*",
	cntChildSel : "*"
};

})(jQuery);	