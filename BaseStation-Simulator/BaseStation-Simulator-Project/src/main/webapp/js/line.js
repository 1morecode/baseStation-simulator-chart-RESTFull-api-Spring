$(document).ready(function(){
    //get canvas
    var ctx = $("#line-chartcanvas");

    var sensorA = [0, 5, 12, 15, 20, 22, 25, 28, 31, 35];
    var sensorB = [15, 16, 18, 23, 26, 31, 35, 38, 42, 45];
    var sensorC = [31, 26, 28, 34, 42, 38, 36, 41, 51, 55];
    var data = {
        labels : ["Point1", "Point2", "Point3", "Point4", "Point5", "Point6", "Point7", "Point8", "Point9", "Point10"],
        datasets : [
            {
                label : "Sensor A",
                data : sensorA,
                backgroundColor : "blue",
                borderColor : "lightblue",
                fill : false,
                lineTension : 0,
                pointRadius : 5
            },
            {
                label : "Sensor B",
                data : sensorB,
                backgroundColor : "green",
                borderColor : "lightgreen",
                fill : false,
                lineTension : 0,
                pointRadius : 5
            },
            {
                label : "Sensor C",
                data : sensorC,
                backgroundColor : "red",
                borderColor : "lightred",
                fill : false,
                lineTension : 0,
                pointRadius : 5
            }
        ]
    };

    var options = {
        title : {
            display : true,
            position : "top",
            text : "Basestation Simulator",
            fontSize : 20,
            fontColor : "#111"
        },
        legend : {
            display : "true",
            position : "bottom"
        }
    };

    var chart = new Chart( ctx, {
        type :"line",
        data : data,
        options : options
    });
});