$(function () {
    var $result = $('#eventsResult');

    $('#eventsTable').on('all.bs.table', function (e, name, args) {
        console.log('Event:', name, ', data:', args);
    })
    .on('click-row.bs.table', function (e, row, $element) {
        $result.text('Event: click-row.bs.table');
    })
    .on('dbl-click-row.bs.table', function (e, row, $element) {
        $result.text('Event: dbl-click-row.bs.table');
    })
    .on('sort.bs.table', function (e, name, order) {
        $result.text('Event: sort.bs.table');
    })
    .on('check.bs.table', function (e, row) {
        $result.text('Event: check.bs.table');
    })
    .on('uncheck.bs.table', function (e, row) {
        $result.text('Event: uncheck.bs.table');
    })
    .on('check-all.bs.table', function (e) {
        $result.text('Event: check-all.bs.table');
    })
    .on('uncheck-all.bs.table', function (e) {
        $result.text('Event: uncheck-all.bs.table');
    })
    .on('load-success.bs.table', function (e, data) {
        $result.text('Event: load-success.bs.table');
    })
    .on('load-error.bs.table', function (e, status) {
        $result.text('Event: load-error.bs.table');
    })
    .on('column-switch.bs.table', function (e, field, checked) {
        $result.text('Event: column-switch.bs.table');
    })
    .on('page-change.bs.table', function (e, number, size) {
        $result.text('Event: page-change.bs.table');
    })
    .on('search.bs.table', function (e, text) {
        $result.text('Event: search.bs.table');
    });
});

$(document).ready(function () {
    zebra();

    $('.checkall').on('click', function () {
        var $this = $(this),
            // Test to see if it is checked
            checked = $this.prop('checked'),
            //Find all the checkboxes
            cbs = $this.closest('table').children('tbody').find('.checkbox');
        // Check or Uncheck them.
        cbs.prop('checked', checked);
        //toggle the selected class to all the trs
        cbs.closest('tr').toggleClass('selected', checked);
    });
    $('tbody tr').on('click', function () {
        var $this = $(this).toggleClass('selected');
        $this.find('.checkbox').prop('checked', $this.hasClass('selected'));
        if(!$this.hasClass('selected')) {
            $this.closest('table').children('thead').find('.checkall').prop('checked', false); 
        }
    });
    $('.delete_single').on('click', function(e){
        e.preventDefault();
        //Dont let the click bubble up to the tr
        e.stopPropagation();
        var $this = $(this),
            c = confirm('Are you sure you want to delete this row?');
        if(!c) { return false;}
        $this.closest('tr').fadeOut(function(){ $(this).remove(); zebra(); });
    });
    //dynamically creates a URL
    $('span.deleteall').on('click', function(e){
        e.preventDefault();
        var mediaType = getPageName();
        var $this = $(this), 
            $trows = $this.closest('table').children('tbody').find('tr.selected'),
            sel = !!$trows.length;
        // Don't confirm delete if no rows selected.
        if(!sel){
            alert('No rows selected');
            return false;
        }
        var c = confirm('Are you sure you want to delete the slected rows?');
        if(!c) { return false; }
        $trows.fadeOut(function(){ $trows.remove(); zebra(); deleteFromDatabase(mediaType,$trows.find('td:last').text());});
    });
    function getPageName(){
    	var mediaPageName = window.location.pathname;
        var mediaType = null;
        if(mediaPageName.includes('books')){
        	mediaType = 'Book';
        }else if(mediaPageName.includes('movies')){
        	mediaType = 'Movie';
        }else if(mediaPageName.includes('music')){
        	mediaType = 'Music';
        }else if(mediaPageName.includes('contacts')){
        	mediaType = 'Contact';
        }
    	return mediaType;
    }
    
    function deleteFromDatabase(mediaType, key){
    	
    	var xhttp = new XMLHttpRequest();
    	  xhttp.onreadystatechange = function() {
    	    if (xhttp.readyState == 4 && xhttp.status == 200) {
    	      //document.getElementById("demo").innerHTML = xhttp.responseText;
    	    }
    	  };
    	  xhttp.open("POST", "http://localhost:8080/DatabaseProject/delete" + mediaType + "/" + key, true);
    	  xhttp.send();
    };
    
   $('span.addall').on('click', function(e){
      e.preventDefault();
      var title, about;
      var mediaType = getPageName();
      var secondaryStat = getSecondaryStat(mediaType);
      title = prompt("Please enter the Title or Name");
      about = prompt("Please enter " + secondaryStat);
      addToDatabase(mediaType, title, about);
   });
   
   function addToDatabase(mediaType, title, about){
	   var math = Math.random()/10;
	   var xhttp = new XMLHttpRequest();
 	  xhttp.onreadystatechange = function() {
 	    if (xhttp.readyState == 4 && xhttp.status == 200) {
 	    	console.log("inside on success function");
 	    	$('#dtable tr:last').before('<tr> <td> <input type="checkbox" class="checkbox" name="selectedItems"/></td><td>' + title +'</td><td>' + about +'</td><td>??</td></tr>');
 	    }
 	  };
 	  xhttp.open("POST", "http://localhost:8080/DatabaseProject/add" + mediaType + "/" + title + "/" + about, true);
 	  xhttp.send();
   };
   function getSecondaryStat(mediaType){
	   var secondaryStat;
	   if(mediaType.includes('Book')){
		   secondaryStat = 'Author';
	   }else if(mediaType.includes('Movie')){
		   secondaryStat = 'Rating';
	   }else if(mediaType.includes('Music')){
		   secondaryStat = 'Composer';
	   }else if(mediaType.includes('Contact')){
		   secondaryStat = 'Email or Phone';
	   }
	   return secondaryStat;

   };
    $('span.test').on('click', function(e){
        e.preventDefault();
        $("#dialog").dialog({
            autoOpen: false,
            buttons: { 
                Ok: function() {
                    $("#nameentered").text($("#name").val());
                    $(this).dialog("close");
                },
                Cancel: function () {
                    $(this).dialog("close");
                }
            }
        });

        $("#open").click(function () {
            $("#dialog").dialog("open");
        });
    });
    
    
    
//    if(!deleteFromDatabase){
//    function deleteFromDatabase2(movieKey){
//    	var xhttp = new XMLHttpRequest();
//  	  xhttp.onreadystatechange = function() {
//  	    if (xhttp.readyState == 4 && xhttp.status == 200) {
//  	      //document.getElementById("demo").innerHTML = xhttp.responseText;
//  	    }
//  	  };
//  	  xhttp.open("POST", "http://localhost:8080/DatabaseProject/deleteMovie/" + movieKey, true);
//  	  xhttp.send();
//    }
//  };
   
//would be better if zebra was done in pure css
    function zebra(){
       $(".zebra-style").find('tbody')
           .find('.odd').removeClass('odd').end()
           .find('tr:odd').addClass("odd");
    };
});

$(document).ready(function(){
	$('#formsubmit').click(function(){
		
		$.post("submit", 
			{fname: $('#fname').val(), surname: $('#surname').val()}, 
			function(){;
			
			}
		);
	});
});