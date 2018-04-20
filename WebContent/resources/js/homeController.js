'use strict'

var apriModaleIscriviti;
var apriModaleConnettiti;

$(function () {
	
	var modaleIscriviti = document.querySelector('#modale-iscriviti');
    var modaleConnettiti = document.querySelector('#modale-connettiti');
    
    if(!modaleIscriviti.showModal) {
    	dialogPolyfill.registerDialog(modaleIscriviti);
    }
    
    if(!modaleConnettiti.showModal) {
    	dialogPolyfill.registerDialog(modaleConnettiti);
    }

    apriModaleIscriviti = function(){
    	modaleIscriviti.showModal();    	
    }
    
    apriModaleConnettiti = function(){
    	modaleConnettiti.showModal();    	
    }

});
