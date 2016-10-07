/**
 * 
 */

function translateText(key){
	var textToTranslate = $("#textToTranslate").val(),
	targetLanguage = $("#targetLanguage").val(), 
	translateUrl='https://www.googleapis.com/language/translate/v2?key='+key+'&source=en'+'&target='+targetLanguage+'&q='+textToTranslate ;
	$.ajax({
		url: translateUrl,
		type: 'GET',
		dataType:'json'
	}).done(function(response){
		$('#translatedText').html('Translated Text: '+response.data.translations[0].translatedText);
		console.log(response);
	}).fail(function(){
		console.log('failed!');
	});
	console.log("Text is: "+key);
}

function langDropdownInit(){
	var langChoicesUrl = '/googletranslateapi';
	
	$.ajax({
		url: langChoicesUrl,
		type: 'GET',
		dataType: 'json',
		data: {
			'langDropDownInit' : 'true'
		}
	}).done(function(response){		
		console.log(response);
		generateDropMenu(response);
	}).fail(function(){
		console.log('failed!');
	});
}

function generateDropMenu(langsObj){
	
	var button = $('<button/>');
		
    button.attr({'class':'btn btn-primary dropdown-toggle', 'type':'button', 'data-toggle':'dropdown'});
    button.text('Select Language');
    
    var span = $('<span/>');
    span.attr({'class':'caret'})
    
    button.append(span)
    
    var ul = $('<ul/>');
    ul.attr({'class':'dropdown-menu scrollable-menu', 'aria-labelledby' : 'dLabel'})
    
    for(var i=0; i<langsObj.languages.length;i++){
    	var li = $('<li/>'),
    	a = $('<a/>'),
    	lang = langsObj.languages[i].language;
    	a.attr({'href':'#'});
    	a.text(lang);
    	li.append(a);
    	ul.append(li);
    }
    console.log(ul[0]);
    
    var dropDownMenuElement = $('#languageDropDown').html('<a id="dLabel" data-target="#" href="#" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Select a language<span class="caret"></span>');
	dropDownMenuElement.append(ul);
    
    
    
    
	/*
	$('#languageDropDown')
	<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Example<span class="caret"></span></button>
	  <ul class="dropdown-menu">
	    <li><a href="#">HTML</a></li>
	    <li><a href="#">CSS</a></li>
	    <li><a href="#">JavaScript</a></li>
	  </ul>*/
}

$(document).on('click', '#langInit', function(){	
	var langChoicesUrl = '/googletranslateapi';
	 
	$.ajax({
		url: langChoicesUrl,
		type: 'GET',
		dataType: 'json',
		data: {
			'langDropDownInit' : 'true'
		}
	}).done(function(response){		
		console.log(response);
	}).fail(function(){
		console.log('failed!');
	});
	
});


$(document).on('click', '#webFonts', function(){	
	var langChoicesUrl = '/googlewebfontsapiservlet';
	
	$.ajax({
		url: langChoicesUrl,
		type: 'GET',
		dataType: 'json',
	}).done(function(response){		
		console.log(response);
	}).fail(function(){
		console.log('failed!');
	});
});


$(document).on('click', '#translateText', function(){
	var text = $("#textToTranslate").val();
	console.log("Text is: "+text);
	
	var langChoicesUrl = '/googletranslateapi';
	
	$.ajax({
		url: langChoicesUrl,
		type: 'GET',
		dataType: 'json',
		data: {
			'textToTranslate' : text,
			'langDropDownInit' : 'false'
		}
	}).done(function(response){		
		console.log(response);
	}).fail(function(){
		console.log('failed!');
	});
	
});