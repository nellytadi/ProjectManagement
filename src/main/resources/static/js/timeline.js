var projectTimelineStr = decodeHtml(projectTimeline);

var timeLineArr = JSON.parse(projectTimelineStr);

var resultData = [];


for(var i in timeLineArr){
	resultData.push([i,timeLineArr[i]]);

}

google.charts.load('current', {'packages':['timeline']});
google.charts.setOnLoadCallback(drawChart);
function drawChart() {
  var container = document.getElementById('timeline');
  var chart = new google.visualization.Timeline(container);
  var dataTable = new google.visualization.DataTable();

  dataTable.addColumn({ type: 'string', id: 'Project' });
  dataTable.addColumn({ type: 'date', id: 'Start date' });
  dataTable.addColumn({ type: 'date', id: 'End date' });
  for(var i =0;i < resultData.length;i++){
	  
	  dataTable.addRows([
		  [
			  resultData[i][1]["projectName"],
			  new Date(resultData[i][1]["startDate"]),
			  new Date(resultData[i][1]["endDate"])
		  ]	
	   ]);
	  
  }
 

  chart.draw(dataTable);
}


function decodeHtml(text){
	var txt = document.createElement("textarea");
	txt.innerHTML = text;
	return txt.value;
	
}
