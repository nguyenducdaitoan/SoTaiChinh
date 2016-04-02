var znSlideshow = {
	timerSlideShow: {},
    show: function(divShow, indexShow){
        var eShow = document.getElementById(divShow);
        if(eShow.indexShow && eShow.indexShow!=indexShow)
            zm('#' + divShow + '_' + eShow.indexShow).hide();
        eShow.indexShow = indexShow;
        zm('#' + divShow + '_' + indexShow).hide().opacity(1).fadeIn().show();
    },
    slideshow : function (divShow, lengthShow, indexShow) {
        var eShow = document.getElementById(divShow);
        if (eShow.indexShow){
            zm('#' + divShow + '_' + eShow.indexShow).fadeOut();
            setTimeout(function(){
                znSlideshow.show(divShow, indexShow);
            }, 300);
        }
        else
            znSlideshow.show(divShow, indexShow);
        znSlideshow.timerSlideShow[divShow] = setTimeout(function(){
            if(indexShow==lengthShow)
                indexShow = 1;
            else
                indexShow++;
            znSlideshow.slideshow(divShow, lengthShow, indexShow);
        }, eShow.timeShow);
    },
	    
    startshow : function (divShow, indexShow, timeShow) {
        var eShow = document.getElementById(divShow);
        if(eShow == null) {
            return;
        }
        var zChild = zm(eShow).children('DIV'), lengthShow = zChild.size();
		zChild.hide();
        
        eShow.lengthShow = lengthShow;
        eShow.timeShow = timeShow;
        if(lengthShow == 0) {
            return;
        }
		if(znSlideshow.timerSlideShow[divShow])
			clearTimeout(znSlideshow.timerSlideShow[divShow]);
        znSlideshow.slideshow(divShow, lengthShow, indexShow);	
    },
            
    clickNext : function (divShow) {
		var eShow = document.getElementById(divShow);
        if(eShow== null) {
            return;
        }
        var lengthShow = eShow.lengthShow;
        var indexShow = 1;
        if(eShow.indexShow < lengthShow) {
            indexShow = eShow.indexShow + 1;
        }
        var timeShow = eShow.timeShow;
        znSlideshow.startshow(divShow, indexShow, timeShow);
    },

    clickPrev : function (divShow) {
		var eShow = document.getElementById(divShow);
        if(eShow== null) {
            return;
        }
        var lengthShow = eShow.lengthShow;
        var indexShow = lengthShow;
        if(eShow.indexShow > 1) {
            indexShow = eShow.indexShow - 1;
        }
        var timeShow = eShow.timeShow;
        znSlideshow.startshow(divShow, indexShow, timeShow);
    }
}