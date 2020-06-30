var chartDataStr = decodeHtml(chartData);

var chartArr = JSON.parse(chartDataStr);

var numericData = [];
var labelData = [];

for(var i = 0; i < chartArr.length; i++){
	numericData[i]=chartArr[i].value;
	labelData[i]=chartArr[i].label;
}

new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#404bb7","#d4b947","#e34040"],
            borderColor: '#ffffff',
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
    	title:true,
    	text:'Project Status'
    }

});


function decodeHtml(text){
	var txt = document.createElement("textarea");
	txt.innerHTML = text;
	return txt.value;
	
}