window.onload = function () {

	var ctx = $("#lineChart");
	var raw_data_key = [];
	var date_time = [];
	var methane_ppm = [];
	var calibration_zero = [];
	var wind_speed = [];
	var wind_direction = [];

	// JSON API process starts
	$.getJSON("http://localhost:8080/mavenproject3/main/data", function (data) {

		var i = 0;
		$.each(data, function (key, value) {
			// console.log(value)
			data.push({
				x: value.date_time,
				y: i
			});
			i = i + 10;
		});


		setInterval(function () {

			updateChart();

			// Printing on Browsers console
			// You can remove this
			console.log(data)
			console.log(raw_data_key)
			console.log(date_time)
			console.log(methane_ppm)
			console.log(calibration_zero)
			console.log(wind_speed)
			console.log(wind_direction)


		}, 3000);


	});

	function updateChart() {
		$.getJSON("http://localhost:8080/mavenproject3/main/data", function (data) {

			raw_data_key = [];
			date_time = [];
			methane_ppm = [];
			calibration_zero = [];
			wind_speed = [];
			wind_direction = [];
			$.each(data, function (key, value) {

				raw_data_key.push(value.raw_data_key)
				date_time.push(value.date_time)
				methane_ppm.push(value.methane_ppm)
				calibration_zero.push(value.calibration_zero)
				wind_speed.push(value.wind_speed)
				wind_direction.push(value.wind_direction)


				data.push({
					x: (value.date_time),
					y: parseFloat(223)
				});
			});


			var data = {
				labels: date_time,

				// datasets Starts
				datasets: [{
						label: "Methane PPM",
						data: methane_ppm,
						backgroundColor: "blue",
						borderColor: "lightblue",
						fill: false,
						lineTension: 0,
						pointRadius: 5
					},
					{
						label: "Wind Direction",
						data: wind_direction,
						backgroundColor: "green",
						borderColor: "lightgreen",
						fill: false,
						lineTension: 0,
						pointRadius: 5
					},
					{
						label: "Wind Speed",
						data: wind_speed,
						backgroundColor: "red",
						borderColor: "lightred",
						fill: false,
						lineTension: 0,
						pointRadius: 5
					}
				]
			}
			// datasets Ends


			// Title and legends starts
			var options = {
				title: {
					display: true,
					position: "top",
					text: "Basestation Simulator",
					fontSize: 20,
					fontColor: "#111"
				},
				legend: {
					display: "true",
					position: "bottom"
				}
			}
			// Title and legends ends

			// chart starts
			var chart = new Chart(ctx, {
				type: "line",
				data: data,
				options: options
			});
			// chart ends  

			chart.render();

		});
	}

	// JSON API process ends 

}