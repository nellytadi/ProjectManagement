new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels: ['January', 'February', 'March', 'April', 'May'],
        datasets: [{
            label: 'My First dataset',
            backgroundColor: ["#ff5733","#ffe633","#4cff33","#33a8ff","#8d33ff"],
            borderColor: '#ffffff',
            data: [5, 10, 35, 12, 20]
        }]
    },

    // Configuration options go here
    options: {}

});