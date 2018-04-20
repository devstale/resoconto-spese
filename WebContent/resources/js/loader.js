/**
	Loader che fa uso della libreria HoldOn.js (https://sdkcarlos.github.io/sites/holdon.html)
	I vari temi che è possibile usare sono:
		- sk-rect
		- sk-bounce
		- sk-folding-cube
		- sk-circle
		- sk-dot
		- sk-bounce
		- sk-falding-circle
		- sk-cube-grid
		- custom (personalizzato)
**/
var Loader = {
	show: function(){
		HoldOn.open({
			theme: 'sk-folding-cube',
			message: 'Per faveore, attendere il completamento dell\'operazione. ',
			backgroundColor: 'black',
			textColor:'white'
		});
	},
	hide: function(){
		HoldOn.close();
	}
};