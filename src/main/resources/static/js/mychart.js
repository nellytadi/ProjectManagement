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




google.charts.load('current', {'packages':['timeline']});
google.charts.setOnLoadCallback(drawChart);
function drawChart() {
  var container = document.getElementById('timeline');
  var chart = new google.visualization.Timeline(container);
  var dataTable = new google.visualization.DataTable();

  dataTable.addColumn({ type: 'string', id: 'President' });
  dataTable.addColumn({ type: 'date', id: 'Start' });
  dataTable.addColumn({ type: 'date', id: 'End' });
  dataTable.addRows([
    [ 'Washington', new Date(1789, 3, 30), new Date(1797, 2, 4) ],
    [ 'Adams',      new Date(1797, 2, 4),  new Date(1801, 2, 4) ],
    [ 'Jefferson',  new Date(1801, 2, 4),  new Date(1809, 2, 4) ]]);

  chart.draw(dataTable);
}