(function() {
	"use strict";

	//**<---- Dashboard E-Commerce Charts ---->**//

	/* Top Sales Chart JS*/
	const getTopSalesId = document.getElementById('top_sales');
	if (getTopSalesId) {
		var options = {
			series: [
				{
					name: "Current Sale",
					data: [35, 50, 55, 60, 50, 60, 55, 60, 78, 40, 95, 80]
				},
				{
					name: "Last Year Sale",
					data: [70, 50, 40, 40, 62, 52, 80, 40, 60, 53, 70, 70]
				}
			],
			chart: {
				type: "area",
				height: 366,
				zoom: {
					enabled: false
				}
			},
			colors: [
				"#605DFF", "#DDE4FF"
			],
			dataLabels: {
				enabled: false
			},
			stroke: {
				curve: "smooth",
				width: [2, 2, 0],
				dashArray: [0, 6, 0],
			},
			grid: {
				borderColor: "#ffffff"
			},
			fill: {
				type: 'gradient',
				gradient: {
					stops: [0, 90, 100],
					shadeIntensity: 1,
					opacityFrom: 0,
					opacityTo: 0.5
				}
			},
			xaxis: {
				categories: [
					"Jan",
					"Feb",
					"Mar",
					"Apr",
					"May",
					"Jun",
					"Jul",
					"Aug",
					"Sep",
					"Oct",
					"Nov",
					"Dec"
				],
				axisTicks: {
					show: false,
					color: '#B1BBC8'
				},
				axisBorder: {
					show: false,
					color: '#B1BBC8'
				},
				labels: {
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 5,
				max: 100,
				min: 0,
				labels: {
					formatter: (val) => {
						return '$' + val / 1 + 'K'
					},
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'left',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			},
			tooltip: {
				y: {
					formatter: function(val) {
					return "$" + val + "k";
					}
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#top_sales"), options);
		chart.render();
	}
    
    /* Total Orders JS*/
	const getTotalOrders1Id = document.getElementById('total_orders1');
	if (getTotalOrders1Id) {
		var options = {
			series: [
				{
					name: "Completed",
					data: [80, 55, 60, 55, 80]
				},
				{
					name: "Pending",
					data: [50, 85, 60, 70, 60]
				}
			],
			chart: {
				type: "bar",
				height: 99,
				toolbar: {
					show: false
				}
			},
			colors: [
				"#1F64F1", "#C2CDFF"
			],
			plotOptions: {
				bar: {
					columnWidth: "85%"
				}
			},
			dataLabels: {
				enabled: false
			},
			stroke: {
				width: 2,
				show: true,
				colors: ["transparent"]
			},
			grid: {
				borderColor: "#ffffff"
			},
			xaxis: {
				categories: [
					"Jan",
					"Feb",
					"Mar",
					"Apr",
					"May"
				],
				axisTicks: {
					show: false,
					color: '#B1BBC8'
				},
				axisBorder: {
					show: false,
					color: '#B1BBC8'
				},
				labels: {
					show: false,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				show: false,
				labels: {
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				}
			},
			tooltip: {
				y: {
					formatter: function(val) {
						return val + "%";
					}
				}
			},
			legend: {
				show: false,
				fontSize: '12px',
				position: 'bottom',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#total_orders1"), options);
		chart.render();
	}

    /* Total Customers JS*/
	const getTotalCustomersId = document.getElementById('total_customers');
	if (getTotalCustomersId) {
		var options = {
			series: [
				{
					name: "Orders",
					data: [55, 50, 60, 45, 85, 80, 100]
				},
				{
					name: "Sales",
					data: [45, 38, 80, 65, 55, 75, 90]
				}
			],
			chart: {
				height: 140,
				type: "line",
				zoom: {
					enabled: false
				},
				toolbar: {
					show: false
				}
			},
			dataLabels: {
				enabled: false
			},
			colors: [
				"#605DFF", "#C2CDFF"
			],
			stroke: {
				width: 2,
				curve: "straight"
			},
			grid: {
				borderColor: "#ffffff"
			},
			xaxis: {
				categories: [
					"01 Jun",
					"02 Jun",
					"03 Jun",
					"04 Jun",
					"05 Jun",
					"06 Jun",
					"07 Jun"
				],
				axisTicks: {
					show: false,
					color: '#B1BBC8'
				},
				axisBorder: {
					show: false,
					color: '#B1BBC8'
				},
				labels: {
					show: false,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				show: false,
				labels: {
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				}
			},
			legend: {
				show: false,
				fontSize: '12px',
				position: 'bottom',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#total_customers"), options);
		chart.render();
	}

    /* Total Revenue JS*/
	const getTotalRevenueId = document.getElementById('total_evenue');
	if (getTotalRevenueId) {
		var options = {
			series: [
				{
					name: "Fashion",
					data: [20, 40, 25, 60, 30, 50]
				},
					{
					name: "Others",
					data: [20, 20, 25, 15, 35, 25]
				}
			],
			chart: {
				type: "bar",
				height: 100,
				stacked: true,
				toolbar: {
					show: false
				},
				zoom: {
					enabled: true
				}
			},
			plotOptions: {
				bar: {
					columnWidth: "55%"
				}
			},
			colors: [
				"#605DFF", "#C2CDFF"
			],
			grid: {
				borderColor: "#ffffff"
			},
			stroke: {
				width: 2,
				show: true,
				colors: ["transparent"]
			},
			dataLabels: {
				enabled: false
			},
			xaxis: {
				categories: [
					"Jan",
					"Feb",
					"Mar",
					"Apr",
					"May",
					"Jun"
				],
				axisTicks: {
					show: false,
					color: '#B1BBC8'
				},
				axisBorder: {
					show: false,
					color: '#B1BBC8'
				},
				labels: {
					show: false,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				show: false,
				labels: {
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				}
			},
			legend: {
				show: false,
				fontSize: '12px',
				position: 'bottom',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5
				}
			},
			fill: {
				opacity: 1
			}
		};
		var chart = new ApexCharts(document.querySelector("#total_evenue"), options);
		chart.render();
	}

    /* Order Summery JS*/
	const getOrderSummeryId = document.getElementById('order_summery');
	if (getOrderSummeryId) {
		var options = {
			series: [60, 30, 10],
			chart: {
				height: 327,
				type: "donut"
			},
			labels: [
				"Completed", "New Order", "Pending"
			],
			colors: [
				"#37D80A", "#605DFF", "#AD63F6"
			],
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5
				}
			},
			dataLabels: {
				enabled: false
			}
		};
		var chart = new ApexCharts(document.querySelector("#order_summery"), options);
		chart.render();
	}

    /* Returning Customer Rate JS*/
	const getReturningCustomerRateId = document.getElementById('returning_customer_rate');
	if (getReturningCustomerRateId) {
		var options = {
			series: [
				{
					name: "Fifth Time",
					data: [70, 23, 40, 30, 62, 52, 90, 20, 60, 53, 65, 70]
				},
				{
					name: "Fourth Time",
					data: [15, 58, 45, 38, 70, 50, 55, 60, 78, 40, 35, 35]
				}
			],
			chart: {
				height: 300,
				type: "line",
				zoom: {
					enabled: false
				},
				toolbar: {
					show: false
				}
			},
			dataLabels: {
				enabled: false
			},
			colors: [
				"#605DFF", "#AD63F6"
			],
			stroke: {
				curve: "smooth",
				width: 2,
			},
			grid: {
				borderColor: "#F6F7F9"
			},
			markers: {
				size: 4,
				strokeWidth: 0,
				shape: ["circle", "square"],
				hover: {
					size: 5
				}
			},
			xaxis: {
				categories: [
					"Jan",
					"Feb",
					"Mar",
					"Apr",
					"May",
					"Jun",
					"Jul",
					"Aug",
					"Sep",
					"Oct",
					"Nov",
					"Dec"
				],
				axisTicks: {
					show: false,
					color: '#B1BBC8'
				},
				axisBorder: {
					show: false,
					color: '#B1BBC8'
				},
				labels: {
					show: true,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 5,
				max: 100,
				min: 0,
				labels: {
					formatter: (val) => {
						return val + '%'
					},
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				}
			},
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#returning_customer_rate"), options);
		chart.render();
	}


	//**<---- Dashboard CRM Charts ---->**//

	/* Revenue Growth JS*/
	const getRevenueGrowthId = document.getElementById('revenue_growth');
	if (getRevenueGrowthId) {
		var options = {
			series: [
				{
					name: "Revenue Growth",
					data: [3, 7, 7, 10, 9, 11, 15]
				}
			],
			chart: {
				type: "area",
				height: 95,
				zoom: {
					enabled: false
				},
				toolbar: {
					show: false
				}
			},
			colors: [
				"#3584FC"
			],
			dataLabels: {
				enabled: false
			},
			grid: {
				show: false,
				borderColor: "#ECEEF2"
			},
			stroke: {
				curve: "straight",
				width: 1
			},
			xaxis: {
				categories: [
					"Mon",
					"Tue",
					"Wed",
					"Thu",
					"Fri",
					"Sat",
					"Sun"
				],
				axisTicks: {
					show: false,
					color: '#B1BBC8'
				},
				axisBorder: {
					show: false,
					color: '#B1BBC8'
				},
				labels: {
					show: false,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				// tickAmount: 6,
				show: false,
				// max: 150,
				// min: 0,
				labels: {
					formatter: (val) => {
						return '$' + val + 'k'
					},
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				}
			},
			legend: {
				show: false,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'left',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#revenue_growth"), options);
		chart.render();
	}

	// Revenue JS
	const getRevenueId = document.getElementById('revenue_ch');
	if (getRevenueId) {
		var options = {
			series: [
				{
					name: "Solved",
					data: [28, 50, 90, 95, 20, 70, 35]
				},
				{
					name: "In Progress",
					data: [80, 60, 70, 30, 45, 20, 80]
				},
				{
					name: "Pending",
					data: [32, 23, 78, 35, 65, 35, 15]
				},
				{
					name: "Others",
					data: [60, 25, 80, 25, 15, 40, 15]
				}
			],
			chart: {
				type: "bar",
				height: 443,
				toolbar: {
					show: true
				}
			},
			colors: [
				"#605DFF", "#3584FC", "#AD63F6", "#FD5812"
			],
			plotOptions: {
				bar: {
					columnWidth: "45%"
				}
			},
			grid: {
				show: true,
				borderColor: "#ECEEF2"
			},
			dataLabels: {
				enabled: false
			},
			stroke: {
				width: 3,
				show: true,
				colors: ["transparent"]
			},
			xaxis: {
				categories: [
					"Mon",
					"Tue",
					"Wed",
					"Thu",
					"Fri",
					"Sat",
					"Sun"
				],
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				labels: {
					show: true,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 5,
				max: 100,
				min: 0,
				labels: {
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				}
			},
			tooltip: {
				y: {
					formatter: function(val) {
						return val + " Tickets";
					}
				}
			},
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'left',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#revenue_ch"), options);
		chart.render();
	}

    /* Lead Conversion JS*/
	const getLeadConversionId = document.getElementById('lead_conversion');
	if (getLeadConversionId) {
		var options = { 
			series: [
				{
					name: "Lead Conversion",
					data: [3, 6, 7, 6, 9, 10, 7]
				}
			],
			chart: {
				type: "area",
				height: 95,
				zoom: {
					enabled: false
				},
				toolbar: {
					show: false
				}
			},
			colors: [
				"#605DFF"
			],
			dataLabels: {
				enabled: false
			},
			grid: {
				show: false,
				borderColor: "#ECEEF2"
			},
			stroke: {
				curve: "smooth",
				width: 1
			},
			xaxis: {
				categories: [
					"Mon",
					"Tue",
					"Wed",
					"Thu",
					"Fri",
					"Sat",
					"Sun"
				],
				axisTicks: {
					show: false,
					color: '#B1BBC8'
				},
				axisBorder: {
					show: false,
					color: '#B1BBC8'
				},
				labels: {
					show: false,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				// tickAmount: 6,
				show: false,
				// max: 150,
				// min: 0,
				labels: {
					formatter: (val) => {
						return val + '%'
					},
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				}
			},
			legend: {
				show: false,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'left',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#lead_conversion"), options);
		chart.render();
	}
    

    /* Total Orders JS*/ 
	const getTotalOrder2Id = document.getElementById('total_orders2');
	if (getTotalOrder2Id) {
		var options = { 
			series: [
				{
					name: "Total Orders",
					data: [44, 55, 57, 56, 61, 58, 63]
				}
			],
			chart: {
				type: "bar",
				height: 110,
				toolbar: {
					show: false
				}
			},
			plotOptions: {
				bar: {
					columnWidth: "50%",
					borderRadius: 2
				}
			},
			colors: [
				"#0dcaf0"
			],
			dataLabels: {
				enabled: false
			},
			grid: {
				show: false,
				borderColor: "#ECEEF2"
			},
			stroke: {
				width: 2,
				show: true,
				colors: ["transparent"]
			},
			xaxis: {
				categories: [
					"Mon",
					"Tue",
					"Wed",
					"Thu",
					"Fri",
					"Sat",
					"Sun"
				],
				axisTicks: {
					show: false,
					color: '#B1BBC8'
				},
				axisBorder: {
					show: false,
					color: '#B1BBC8'
				},
				labels: {
					show: false,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				// tickAmount: 6,
				show: false,
				// max: 150,
				// min: 0,
				labels: {
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				}
			},
			tooltip: {
				y: {
					formatter: function(val) {
						return "$" + val;
					}
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#total_orders2"), options);
		chart.render();
	}
    

    /* Annual Profit JS*/
	const getAnnualProfitId = document.getElementById('annual_profit');
	if (getAnnualProfitId) {
		var options = { 
			series: [
				{
					name: "Annual Profit",
					data: [3, 12, 8, 10, 15, 10, 7]
				}
			],
			chart: {
				type: "area",
				height: 95,
				zoom: {
					enabled: false
				},
				toolbar: {
					show: false
				}
			},
			colors: [
				"#C52B09"
			],
			dataLabels: {
				enabled: false
			},
			grid: {
				show: false,
				borderColor: "#ECEEF2"
			},
			stroke: {
				curve: "smooth",
				width: 1
			},
			xaxis: {
				categories: [
					"Mon",
					"Tue",
					"Wed",
					"Thu",
					"Fri",
					"Sat",
					"Sun"
				],
				axisTicks: {
					show: false,
					color: '#B1BBC8'
				},
				axisBorder: {
					show: false,
					color: '#B1BBC8'
				},
				labels: {
					show: false,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				// tickAmount: 6,
				show: false,
				// max: 150,
				// min: 0,
				labels: {
					formatter: (val) => {
						return val + '%'
					},
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				}
			},
			legend: {
				show: false,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'left',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#annual_profit"), options);
		chart.render();
	}
    

    /* Balance Overview JS*/
	const getBalanceOverviewId = document.getElementById('balance_overview');
	if (getBalanceOverviewId) {
		var options = {
			series: [
				{
					name: "Revenue",
					data: [5, 12, 20, 23, 25, 30, 40, 45, 50, 70, 65, 80 ]
				},
				{
					name: "Expenses",
					data: [15, 20, 30, 30, 35, 45, 60, 70, 80, 85, 95, 120 ]
				}
			],
			chart: {
				type: "area",
				height: 350,
				zoom: {
					enabled: false
				}
			},
			colors: [
				"#AD63F6", "#605DFF"
			],
			dataLabels: {
				enabled: false
			},
			grid: {
				borderColor: "#ECEEF2"
			},
			stroke: {
				curve: "straight",
				width: 2
			},
			xaxis: {
				categories: [
					"Jan",
					"Feb",
					"Mar",
					"Apr",
					"May",
					"Jun",
					"Jul",
					"Aug",
					"Sep",
					"Oct",
					"Nov",
					"Dec"
				],
				axisTicks: {
					show: false,
					color: '#B1BBC8'
				},
				axisBorder: {
					show: false,
					color: '#B1BBC8'
				},
				labels: {
					show: true,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 6,
				max: 150,
				min: 0,
				labels: {
					formatter: (val) => {
						return '$' + val + 'k'
					},
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				}
			},
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'left',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#balance_overview"), options);
		chart.render();
	}
    

    /* Leads by Sourc JS*/
	const getLeadsbySourcId = document.getElementById('leads_by_sourc');
	if (getLeadsbySourcId) {
		var options = {
			series: [320, 60, 30, 160, 279, 19],
			chart: {
				height: 290,
				type: "donut"
			},
			labels: [
				"Organic", "Paid", "Direct", "Social", "Referrals", "Others"
			],
			colors: [
				"#605DFF", "#3584FC", "#AD63F6", "#0dcaf0", "#25B003", "#FD5812"
			],
			stroke: {
				width: 1,
				show: true,
				colors: ["#ffffff"]
			},
			legend: {
				show: false,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5
				}
			},
			plotOptions: {
				pie: {
					expandOnClick: false,
					donut: {
						labels: {
							show: true,
							name: {
								color: '#64748B'
							},
							value: {
								show: true,
								color: '#3A4252',
								fontSize: '28px',
								fontWeight: '600'
							},
							total: {
								show: true,
								color: '#64748B'
							}
						}
					}
				}
			},
			dataLabels: {
				enabled: false
			},
			tooltip: {
				enabled: false
			}
		}
		var chart = new ApexCharts(document.querySelector("#leads_by_sourc"), options);
		chart.render();
	}
    

    /* Sales Report JS*/
	const getSalesReportId = document.getElementById('sales_report');
	if (getSalesReportId) {
		var options = {
			series: [
				{
					name: "Online",
					data: [45, 23, 62, 60, 110, 100, 135]
				},
				{
					name: "Offline",
					data: [20, 58, 24, 50, 40, 70, 97]
				}
			],
			chart: {
				height: 378,
				type: "line",
				zoom: {
					enabled: false
				},
				toolbar: {
					show: true
				}
			},
			dataLabels: {
				enabled: false
			},
			colors: [
				"#605DFF", "#FE7A36"
			],
			stroke: {
				curve: "straight",
				width: 2
			},
			grid: {
				show: true,
				borderColor: "#F6F7F9"
			},
			markers: {
				size: 4,
				strokeWidth: 0,
				shape: ["circle", "square"],
				hover: {
					size: 5
				}
			},
			xaxis: {
				categories: [
					"Sun",
					"Mon",
					"Tue",
					"Wed",
					"Thu",
					"Fri",
					"Sat"
				],
				axisTicks: {
					show: false,
					color: '#B1BBC8'
				},
				axisBorder: {
					show: false,
					color: '#B1BBC8'
				},
				labels: {
					show: true,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 6,
				max: 150,
				min: 0,
				labels: {
					formatter: (val) => {
						return '$' + val + 'k'
					},
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				}
			},
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'left',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#sales_report"), options);
		chart.render();
	}


	//**<---- Dashboard Project Management Charts ---->**//
    
	/* Projects Roadmap JS */
	const getProjectsRoadmapId = document.getElementById('projects_roadmap');
	if (getProjectsRoadmapId) {
		var options = {

			series: [
				{
					name: "Projects",
					data: [400, 550, 600, 700, 1000, 1100, 1200]
				}
			],
			chart: {
				type: "bar",
				height: 342,
				toolbar: {
					show: false
				}
			},
			colors: [
				"#3584FC"
			],
			plotOptions: {
				bar: {
					horizontal: true
				}
			},
			grid: {
				show: true,
				borderColor: "#ECEEF2"
			},
			dataLabels: {
				enabled: false
			},
			xaxis: {
				categories: [
					"Project Planning",
					"Research",
					"Design",
					"Front-end",
					"Development",
					"Review & QA",
					"Launch"
				],
				axisTicks: {
					show: true,
					color: '#ECEEF2'
				},
				axisBorder: {
					show: true,
					color: '#ECEEF2'
				},
				labels: {
					show: true,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				labels: {
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				},
				axisBorder: {
					show: true,
					color: '#ECEEF2'
				},
				axisTicks: {
					show: true,
					color: '#ECEEF2'
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#projects_roadmap"), options);
		chart.render();
	}

	/* Projects Roadmap 2 JS */
	const getProjectsRoadmap2Id = document.getElementById('projects_roadmap2');
	if (getProjectsRoadmap2Id) {
		var options = {

			series: [
				{
					name: "Projects",
					data: [400, 550, 600, 700, 1000, 1100, 1200]
				}
			],
			chart: {
				type: "bar",
				height: 260,
				toolbar: {
					show: false
				}
			},
			colors: [
				"#3584FC"
			],
			plotOptions: {
				bar: {
					horizontal: true
				}
			},
			grid: {
				show: true,
				borderColor: "#ECEEF2"
			},
			dataLabels: {
				enabled: false
			},
			xaxis: {
				categories: [
					"Project Planning",
					"Research",
					"Design",
					"Front-end",
					"Development",
					"Review & QA",
					"Launch"
				],
				axisTicks: {
					show: true,
					color: '#ECEEF2'
				},
				axisBorder: {
					show: true,
					color: '#ECEEF2'
				},
				labels: {
					show: true,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				labels: {
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				},
				axisBorder: {
					show: true,
					color: '#ECEEF2'
				},
				axisTicks: {
					show: true,
					color: '#ECEEF2'
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#projects_roadmap2"), options);
		chart.render();
	}
    
	/* Projects Progress JS */
	const getProjectsProgressId = document.getElementById('projects_progress');
	if (getProjectsProgressId) {
		var options = {

			series: [
				{
					name: "Completed",
					data: [70, 23, 45, 30, 62, 70]
				},
				{
					name: "In Progress",
					data: [15, 40, 37, 38, 80, 45]
				},
				{
					name: "Not Start Yet",
					data: [50, 11, 60, 15, 31, 30]
				},
				{
					name: "Cancelled",
					data: [30, 60, 25, 22, 50, 15]
				}
			],
			chart: {
				height: 366,
				type: "line",
				zoom: {
					enabled: false
				},
				toolbar: {
					show: true
				}
			},
			dataLabels: {
				enabled: false
			},
			colors: [
				"#605DFF", "#FE7A36", "#AD63F6", "#D71C00"
			],
			stroke: {
				curve: "smooth",
				width: 2
			},
			grid: {
				show: true,
				borderColor: "#ECEEF2"
			},
			markers: {
				size: 4,
				strokeWidth: 0,
				shape: ["circle", "square", "circle", "square"],
				hover: {
					size: 5
				}
			},
			xaxis: {
				categories: [
					"Jan",
					"Feb",
					"Mar",
					"Apr",
					"May",
					"Jun"
				],
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				labels: {
					show: true,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 5,
				max: 100,
				min: 0,
				labels: {
					formatter: (val) => {
						return val + '%'
					},
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				}
			},
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'left',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5
				}
			}
			
		};
		var chart = new ApexCharts(document.querySelector("#projects_progress"), options);
		chart.render();
	}
    
	/* Project Analysis JS */
	const getProjectAnalysisId = document.getElementById('project_analysis');
	if (getProjectAnalysisId) {
		var options = {

			series: [
				{
					name: "Budgets",
					data: [40, 60, 55, 30, 60, 130, 63,]
				},
				{
					name: "Expenses",
					data: [15, 65, 100, 40, 90, 90, 91]
				},
				{
					name: "Revenue",
					data: [55, 70, 30, 50, 110, 60, 52]
				}
			],
			chart: {
				type: "bar",
				height: 337,
				toolbar: {
					show: true
				}
			},
			colors: [
				"#605DFF", "#AD63F6", "#3584FC"
			],
			plotOptions: {
				bar: {
					columnWidth: "60%"
				}
			},
			grid: {
				show: true,
				borderColor: "#ECEEF2"
			},
			dataLabels: {
				enabled: false
			},
			stroke: {
				width: 4,
				show: true,
				colors: ["transparent"]
			},
			xaxis: {
				categories: [
					"Mon",
					"Tue",
					"Wed",
					"Thu",
					"Fri",
					"Sat",
					"Sun"
				],
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				labels: {
					show: true,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 6,
				max: 150,
				min: 0,
				labels: {
					// formatter: (val) => {
					//     return '$' + val + 'k'
					// },
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				}
			},
			tooltip: {
				y: {
					formatter: function(val) {
						return "$" + val + "k";
					}
				}
			},
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'left',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
			
		};
		var chart = new ApexCharts(document.querySelector("#project_analysis"), options);
		chart.render();
	}

	/* Project Analysis JS */
	const getProjectAnalysis2Id = document.getElementById('project_analysis2');
	if (getProjectAnalysis2Id) {
		var options = {

			series: [
				{
					name: "Budgets",
					data: [40, 60, 55, 30, 60, 130, 63,]
				},
				{
					name: "Expenses",
					data: [15, 65, 100, 40, 90, 90, 91]
				},
				{
					name: "Revenue",
					data: [55, 70, 30, 50, 110, 60, 52]
				}
			],
			chart: {
				type: "bar",
				height: 400,
				toolbar: {
					show: true
				}
			},
			colors: [
				"#605DFF", "#AD63F6", "#3584FC"
			],
			plotOptions: {
				bar: {
					columnWidth: "25%"
				}
			},
			grid: {
				show: true,
				borderColor: "#ECEEF2"
			},
			dataLabels: {
				enabled: false
			},
			stroke: {
				width: 4,
				show: true,
				colors: ["transparent"]
			},
			xaxis: {
				categories: [
					"Mon",
					"Tue",
					"Wed",
					"Thu",
					"Fri",
					"Sat",
					"Sun"
				],
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				labels: {
					show: true,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 6,
				max: 150,
				min: 0,
				labels: {
					// formatter: (val) => {
					//     return '$' + val + 'k'
					// },
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				}
			},
			tooltip: {
				y: {
					formatter: function(val) {
						return "$" + val + "k";
					}
				}
			},
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'left',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
			
		};
		var chart = new ApexCharts(document.querySelector("#project_analysis2"), options);
		chart.render();
	}
    
	/* Tasks Overview JS */
	const getTasksOverviewId = document.getElementById('tasks_overview');
	if (getTasksOverviewId) {
		var options = {

			series: [
				55, 44, 30, 12
			],
			chart: {
				height: 415,
				type: "pie",
			},
			labels: [
				"Solved", "In Progress", "Pending", "Unassigned"
			],
			colors: [
				"#37D80A", "#605DFF", "#AD63F6", "#FD5812"
			],
			dataLabels: {
				enabled: false
			},
			plotOptions: {
				pie: {
					expandOnClick: false
				}
			},
			stroke: {
				width: 1,
				show: true,
				colors: ["#ffffff"]
			},
			legend: {
				show: true,
				fontSize: '12px',
				position: 'bottom',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 7
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					radius: 2,
					height: 9,
					offsetX: -2,
					offsetY: -.1,
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#tasks_overview"), options);
		chart.render();
	}

	/* Tasks Overview JS */
	const getTasksOverview4Id = document.getElementById('tasks_overview4');
	if (getTasksOverview4Id) {
		var options = {

			series: [
				55, 44, 30, 12, 22
			],
			chart: {
				height: 413,
				type: "pie",
			},
			labels: [
				"Completed", "In Progress", "Pending", "Active", "Cancelled"
			],
			colors: [
				"#37D80A", "#605DFF", "#AD63F6", "#3584FC", "#FD5812"
			],
			dataLabels: {
				enabled: false
			},
			plotOptions: {
				pie: {
					expandOnClick: false
				}
			},
			stroke: {
				width: 1,
				show: true,
				colors: ["#ffffff"]
			},
			legend: {
				show: true,
				fontSize: '12px',
				position: 'bottom',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 7
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					radius: 2,
					height: 9,
					offsetX: -2,
					offsetY: -.1,
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#tasks_overview4"), options);
		chart.render();
	}

	/* Tasks Overview JS */
	const getTasksOverview3Id = document.getElementById('tasks_overview3');
	if (getTasksOverview3Id) {
		var options = {

			series: [
				55, 44, 30, 12, 22
			],
			chart: {
				height: 172,
				type: "pie",
			},
			labels: [
				"Completed", "In Progress", "Pending", "Active", "Cancelled"
			],
			colors: [
				"#37D80A", "#605DFF", "#AD63F6", "#3584FC", "#FD5812"
			],
			dataLabels: {
				enabled: false
			},
			plotOptions: {
				pie: {
					expandOnClick: false
				}
			},
			stroke: {
				width: 1,
				show: true,
				colors: ["#ffffff"]
			},
			legend: {
				show: true,
				fontSize: '12px',
				position: 'bottom',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 7
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					radius: 2,
					height: 9,
					offsetX: -2,
					offsetY: -.1,
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#tasks_overview3"), options);
		chart.render();
	}
    

	//**<---- Dashboard LMS Charts ---->**//

	// Student’s Interested Topics JS
	const getStudentsInterestedTopicsId = document.getElementById('student_interested_topics');
	if (getStudentsInterestedTopicsId) {
		var options = {
			series: [
				{
					name: "Courses",
					data: [47, 69, 37, 17, 28, 40]
				}
			],
			chart: {
				type: "bar",
				height: 396,
				toolbar: {
					show: false
				}
			},
			colors: [
				"#605DFF"
			],
			plotOptions: {
				bar: {
					barHeight: '21px',
					horizontal: true
				}
			},
			grid: {
				show: true,
				borderColor: "#ECEEF2"
			},
			dataLabels: {
				enabled: false
			},
			xaxis: {
				categories: [
					"UX/UI Design",
					"WordPress",
					"Motion Design",
					"Video Editing",
					"Angular",
					"Python"
				],
				axisTicks: {
					show: true,
					color: '#ECEEF2'
				},
				axisBorder: {
					show: true,
					color: '#ECEEF2'
				},
				labels: {
					show: true,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				labels: {
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				},
				axisBorder: {
					show: true,
					color: '#ECEEF2'
				},
				axisTicks: {
					show: true,
					color: '#ECEEF2'
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#student_interested_topics"), options);
		chart.render();
	}
    
    // Courses Sales JS
	const getCoursesSalesId = document.getElementById('courses_sales');
	if (getCoursesSalesId) {
		var options = {
			series: [
				{
					name: "Sales",
					data: [100, 130, 115, 170, 110, 120, 85, 140, 150, 100, 110, 90, 160, 125, 105, 130, 145, 120, 150, 155, 220, 165]
				}
			],
			chart: {
				type: "area",
				height: 270,
				zoom: {
					enabled: false
				},
				toolbar: {
					show: false
				}
			},
			dataLabels: {
				enabled: false
			},
			stroke: {
				curve: "straight",
				width: 2
			},
			colors: [
				"#605DFF"
			],
			fill: {
				type: 'gradient',
				gradient: {
					stops: [0, 90, 100],
					shadeIntensity: 1,
					opacityFrom: 0.5,
					opacityTo: 0.9
				}
			},
			xaxis: {
				categories: [
					"01 Jan",
					"02 Jan",
					"03 Jan",
					"04 Jan",
					"05 Jan",
					"06 Jan",
					"07 Jan",
					"08 Jan",
					"09 Jan",
					"10 Jan",
					"11 Jan",
					"12 Jan",
					"13 Jan",
					"14 Jan",
					"15 Jan",
					"16 Jan",
					"17 Jan",
					"18 Jan",
					"19 Jan",
					"20 Jan",
					"21 Jan",
					"22 Jan",
				],
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				labels: {
					show: false,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 5,
				show: false,
				max: 250,
				min: 0,
				labels: {
					show: true,
					style: {
						colors: "#64748B",
						fontSize: "12px"
					},
					formatter: (val) => {
						return '$' + val + 'K'
					}
				},
				axisBorder: {
					show: true,
					color: '#ECEEF2'
				},
				axisTicks: {
					show: true,
					color: '#ECEEF2'
				}
			},
			grid: {
				show: false,
				borderColor: "#ECEEF2"
			},
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#courses_sales"), options);
		chart.render();
	}
    
    // Time Spent JS
	const getTimeSpentId = document.getElementById('time_spent');
	if (getTimeSpentId) {
		var options = {
			series: [
				{
					name: "Time Spent",
					data: [30, 70, 80, 95, 90, 20, 40]
				}
			],
			chart: {
				type: "bar",
				height: 255,
				toolbar: {
					show: false
				}
			},
			colors: [
				"#AD63F6"
			],
			plotOptions: {
				bar: {
					columnWidth: "30%"
				}
			},
			grid: {
				show: true,
				borderColor: "#ECEEF2"
			},
			dataLabels: {
				enabled: false
			},
			stroke: {
				width: 4,
				show: true,
				colors: ["transparent"]
			},
			xaxis: {
				categories: [
					"Mon",
					"Tue",
					"Wed",
					"Thu",
					"Fri",
					"Sat",
					"Sun"
				],
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				labels: {
					show: true,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 4,
				max: 100,
				min: 0,
				labels: {
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				}
			},
			tooltip: {
				y: {
					formatter: function(val) {
						return val + " hours";
					}
				}
			},
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'left',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#time_spent"), options);
		chart.render();
	}


	//**<---- Dashboard HelpDesk Charts ---->**//

	// Tickets Resolved JS
	const getTicketsResolvedId = document.getElementById('tickets_resolved');
	if (getTicketsResolvedId) {
		var options = {
			series: [
				{
					name: "Tickets Resolved",
					data: [35, 70, 35, 65, 45, 98, 80]
				}
			],
			chart: {
				type: "area",
				height: 130,
				zoom: {
					enabled: false
				},
				toolbar: {
					show: false
				}
			},
			dataLabels: {
				enabled: false
			},
			stroke: {
				curve: "straight",
				width: 2
			},
			colors: [
				"#605DFF"
			],
			fill: {
				type: 'gradient',
				gradient: {
					stops: [0, 90, 100],
					shadeIntensity: 1,
					opacityFrom: 0.5,
					opacityTo: 0.9
				}
			},
			xaxis: {
				categories: [
					"Mon",
					"Tue",
					"Wed",
					"Thu",
					"Fri",
					"Sat",
					"Sun"
				],
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				labels: {
					show: false,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 5,
				show: false,
				max: 100,
				min: 0,
				labels: {
					show: true,
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				},
				axisBorder: {
					show: true,
					color: '#ECEEF2'
				},
				axisTicks: {
					show: true,
					color: '#ECEEF2'
				}
			},
			grid: {
				show: false,
				borderColor: "#ECEEF2"
			},
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#tickets_resolved"), options);
		chart.render();
	}

	// In Progressn JS
	const getInProgressnId = document.getElementById('in_progress');
	if (getInProgressnId) {
		var options = {
			series: [
				{
					name: "Tickets In Progress",
					data: [30, 65, 50, 85, 65, 75, 60]
				}
			],
			chart: {
				type: "area",
				height: 130,
				zoom: {
					enabled: false
				},
				toolbar: {
					show: false
				}
			},
			dataLabels: {
				enabled: false
			},
			stroke: {
				curve: "straight",
				width: 2
			},
			colors: [
				"#FD5812"
			],
			fill: {
				type: 'gradient',
				gradient: {
					stops: [0, 90, 100],
					shadeIntensity: 1,
					opacityFrom: 0.5,
					opacityTo: 0.9
				}
			},
			xaxis: {
				categories: [
					"Mon",
					"Tue",
					"Wed",
					"Thu",
					"Fri",
					"Sat",
					"Sun"
				],
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				labels: {
					show: false,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 5,
				show: false,
				max: 100,
				min: 0,
				labels: {
					show: true,
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				},
				axisBorder: {
					show: true,
					color: '#ECEEF2'
				},
				axisTicks: {
					show: true,
					color: '#ECEEF2'
				}
			},
			grid: {
				show: false,
				borderColor: "#ECEEF2"
			},
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#in_progress"), options);
		chart.render();
	}

	// Tickets Due JS
	const getTicketsDueId = document.getElementById('tickets_due');
	if (getTicketsDueId) {
		var options = {
			series: [
				{
					name: "Tickets Due",
					data: [35, 70, 40, 65, 45, 70, 65]
				}
			],
			chart: {
				type: "area",
				height: 130,
				zoom: {
					enabled: false
				},
				toolbar: {
					show: false
				}
			},
			dataLabels: {
				enabled: false
			},
			stroke: {
				curve: "straight",
				width: 2
			},
			colors: [
				"#AD63F6"
			],
			fill: {
				type: 'gradient',
				gradient: {
					stops: [0, 90, 100],
					shadeIntensity: 1,
					opacityFrom: 0.5,
					opacityTo: 0.9
				}
			},
			xaxis: {
				categories: [
					"Mon",
					"Tue",
					"Wed",
					"Thu",
					"Fri",
					"Sat",
					"Sun"
				],
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				labels: {
					show: false,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 5,
				show: false,
				max: 100,
				min: 0,
				labels: {
					show: true,
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				},
				axisBorder: {
					show: true,
					color: '#ECEEF2'
				},
				axisTicks: {
					show: true,
					color: '#ECEEF2'
				}
			},
			grid: {
				show: false,
				borderColor: "#ECEEF2"
			},
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#tickets_due"), options);
		chart.render();
	}

	// Tickets New Open JS
	const getTicketsNewOpenId = document.getElementById('tickets_new_open');
	if (getTicketsNewOpenId) {
		var options = {
			series: [
				{
					name: "Tickets New Open",
					data: [40, 55, 35, 85, 50, 85, 95]
				}
			],
			chart: {
				type: "area",
				height: 130,
				zoom: {
					enabled: false
				},
				toolbar: {
					show: false
				}
			},
			dataLabels: {
				enabled: false
			},
			stroke: {
				curve: "straight",
				width: 2
			},
			colors: [
				"#37D80A"
			],
			fill: {
				type: 'gradient',
				gradient: {
					stops: [0, 90, 100],
					shadeIntensity: 1,
					opacityFrom: 0.5,
					opacityTo: 0.9
				}
			},
			xaxis: {
				categories: [
					"Mon",
					"Tue",
					"Wed",
					"Thu",
					"Fri",
					"Sat",
					"Sun"
				],
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				labels: {
					show: false,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 5,
				show: false,
				max: 100,
				min: 0,
				labels: {
					show: true,
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				},
				axisBorder: {
					show: true,
					color: '#ECEEF2'
				},
				axisTicks: {
					show: true,
					color: '#ECEEF2'
				}
			},
			grid: {
				show: false,
				borderColor: "#ECEEF2"
			},
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#tickets_new_open"), options);
		chart.render();
	}

    // Tickets Status JS
	const getTicketsStatusId = document.getElementById('tickets_status');
	if (getTicketsStatusId) {
		var options = {
			series: [
				{
					name: "Solved",
					data: [28, 50, 90, 95, 20, 70, 35]
				},
				{
					name: "In Progress",
					data: [80, 60, 70, 30, 45, 20, 80]
				},
				{
					name: "Pending",
					data: [32, 23, 78, 35, 65, 35, 15]
				},
				{
					name: "Others",
					data: [60, 25, 80, 25, 15, 40, 15]
				}
			],
			chart: {
				type: "bar",
				height: 395,
				toolbar: {
					show: false
				}
			},
			colors: [
				"#605DFF", "#3584FC", "#AD63F6", "#FD5812"
			],
			plotOptions: {
				bar: {
					columnWidth: "65%"
				}
			},
			grid: {
				show: true,
				borderColor: "#ECEEF2"
			},
			dataLabels: {
				enabled: false
			},
			stroke: {
				width: 3,
				show: true,
				colors: ["transparent"]
			},
			xaxis: {
				categories: [
					"Mon",
					"Tue",
					"Wed",
					"Thu",
					"Fri",
					"Sat",
					"Sun"
				],
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				labels: {
					show: true,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 5,
				max: 100,
				min: 0,
				labels: {
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				}
			},
			tooltip: {
				y: {
					formatter: function(val) {
						return val + " Tickets";
					}
				}
			},
			legend: {
				show: false,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'left',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#tickets_status"), options);
		chart.render();
	}
    
    // Customer Satisfaction JS
	const getCustomerSatisfactionId = document.getElementById('customer_satisfaction');
	if (getCustomerSatisfactionId) {
		var options = {
			series: [50, 15, 75, 50],
			chart: {
				height: 170,
				type: "donut"
			},
			labels: [
				"Highly Satisfied", "Satisfied", "Low Satisfied", "Unsatisfied"
			],
			colors: [
				"#AD63F6", "#C2CDFF", "#FFAA72", "#0dcaf0"
			],
			stroke: {
				width: 1,
				show: true,
				colors: ["transparent"]
			},
			legend: {
				show: false,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5
				}
			},
			plotOptions: {
				pie: {
					expandOnClick: false,
					donut: {
						size: '73%',
						labels: {
							show: true,
							name: {
								color: '#fff'
							},
							value: {
								show: true,
								color: '#fff',
								fontSize: '28px',
								fontWeight: '600',
							},
							total: {
								show: true,
								color: '#fff',
								label: 'Overall',
							}
						}
					}
				}
			},
			dataLabels: {
				enabled: false
			},
			tooltip: {
				enabled: true,
				y: {
					formatter: function(val) {
						return val + "%";
					}
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#customer_satisfaction"), options);
		chart.render();
	}

	// Customer Satisfaction JS
	const getCustomerSatisfaction2Id = document.getElementById('customer_satisfaction2');
	if (getCustomerSatisfaction2Id) {
		var options = {
			series: [50, 15, 75, 50],
			chart: {
				height: 175,
				type: "donut"
			},
			labels: [
				"Highly Satisfied", "Satisfied", "Low Satisfied", "Unsatisfied"
			],
			colors: [
				"#AD63F6", "#C2CDFF", "#FFAA72", "#0dcaf0"
			],
			stroke: {
				width: 1,
				show: true,
				colors: ["transparent"]
			},
			legend: {
				show: false,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5
				}
			},
			plotOptions: {
				pie: {
					expandOnClick: false,
					donut: {
						size: '73%',
						labels: {
							show: false,
							name: {
								color: '#64748B'
							},
							value: {
								show: true,
								color: '#3A4252',
								fontSize: '28px',
								fontWeight: '600'
							},
							total: {
								show: true,
								color: '#64748B'
							}
						}
					}
				}
			},
			dataLabels: {
				enabled: false
			},
			tooltip: {
				enabled: true,
				y: {
					formatter: function(val) {
						return val + "%";
					}
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#customer_satisfaction2"), options);
		chart.render();
	}
    
    // Response Time JS
	const getResponseTimeId = document.getElementById('response_time');
	if (getResponseTimeId) {
		var options = {
			series: [
				{
					name: "Response Time",
					data: [100, 130, 115, 170, 110, 120, 85, 140, 150, 100, 110, 90, 160, 125, 105, 130, 145, 120, 150, 155, 220, 165]
				}
			],
			chart: {
				type: "area",
				height: 205,
				zoom: {
					enabled: false
				},
				toolbar: {
					show: false
				}
			},
			dataLabels: {
				enabled: false
			},
			stroke: {
				curve: "straight",
				width: 2
			},
			colors: [
				"#FFB264"
			],
			fill: {
				type: 'gradient',
				gradient: {
					stops: [0, 90, 100],
					shadeIntensity: 1,
					opacityFrom: 0.5,
					opacityTo: 0.9
				}
			},
			xaxis: {
				categories: [
					"01 Jan",
					"02 Jan",
					"03 Jan",
					"04 Jan",
					"05 Jan",
					"06 Jan",
					"07 Jan",
					"08 Jan",
					"09 Jan",
					"10 Jan",
					"11 Jan",
					"12 Jan",
					"13 Jan",
					"14 Jan",
					"15 Jan",
					"16 Jan",
					"17 Jan",
					"18 Jan",
					"19 Jan",
					"20 Jan",
					"21 Jan",
					"22 Jan",
				],
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				labels: {
					show: false,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 5,
				show: false,
				max: 250,
				min: 0,
				labels: {
					show: true,
					style: {
						colors: "#64748B",
						fontSize: "12px"
					},
					formatter: (val) => {
						return val + ' mins'
					}
				},
				axisBorder: {
					show: true,
					color: '#ECEEF2'
				},
				axisTicks: {
					show: true,
					color: '#ECEEF2'
				}
			},
			grid: {
				show: false,
				borderColor: "#ECEEF2"
			},
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#response_time"), options);
		chart.render();
	}

	// Response Time JS
	const getResponseTime2Id = document.getElementById('response_time2');
	if (getResponseTime2Id) {
		var options = {
			series: [
				{
					name: "Response Time",
					data: [100, 130, 115, 170, 110, 120, 85, 140, 150, 100, 110, 90, 160, 125, 105, 130, 145, 120, 150, 155, 220, 165]
				}
			],
			chart: {
				type: "area",
				height: 212,
				width: 600,
				zoom: {
					enabled: false
				},
				toolbar: {
					show: false
				}
			},
			dataLabels: {
				enabled: false
			},
			stroke: {
				curve: "straight",
				width: 2
			},
			colors: [
				"#FFB264"
			],
			fill: {
				type: 'gradient',
				gradient: {
					stops: [0, 90, 100],
					shadeIntensity: 1,
					opacityFrom: 0.5,
					opacityTo: 0.9
				}
			},
			xaxis: {
				categories: [
					"01 Jan",
					"02 Jan",
					"03 Jan",
					"04 Jan",
					"05 Jan",
					"06 Jan",
					"07 Jan",
					"08 Jan",
					"09 Jan",
					"10 Jan",
					"11 Jan",
					"12 Jan",
					"13 Jan",
					"14 Jan",
					"15 Jan",
					"16 Jan",
					"17 Jan",
					"18 Jan",
					"19 Jan",
					"20 Jan",
					"21 Jan",
					"22 Jan",
				],
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				labels: {
					show: false,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 5,
				show: false,
				max: 250,
				min: 0,
				labels: {
					show: true,
					style: {
						colors: "#64748B",
						fontSize: "12px"
					},
					formatter: (val) => {
						return val + ' mins'
					}
				},
				axisBorder: {
					show: true,
					color: '#ECEEF2'
				},
				axisTicks: {
					show: true,
					color: '#ECEEF2'
				}
			},
			grid: {
				show: false,
				borderColor: "#ECEEF2"
			},
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#response_time2"), options);
		chart.render();
	}
	
    // New Tickets vs Solved Tickets JS
	const getNewTicketsvsSolvedTicketsId = document.getElementById('new_tickets_vs_solved_sickets');
	if (getNewTicketsvsSolvedTicketsId) {
		var options = {
			series: [
				{
					name: "New Tickets",
					data: [25, 70, 25, 45, 60, 55, 70]
				},
				{
					name: "Solved Tickets",
					data: [65, 45, 65, 30, 75, 24, 50]
				}
			],
			chart: {
				type: "area",
				height: 492,
				zoom: {
					enabled: false
				},
				toolbar: {
					show: false
				}
			},
			colors: [
				"#605DFF", "#FD5812"
			],
			dataLabels: {
				enabled: false
			},
			stroke: {
				curve: "smooth",
				width: 2
			},
			grid: {
				show: true,
				borderColor: "#ECEEF2"
			},
			fill: {
				type: 'gradient',
				gradient: {
					stops: [0, 90, 100],
					shadeIntensity: 1,
					opacityFrom: 0,
					opacityTo: 0.6
				}
			},
			xaxis: {
				categories: [
					"Mon",
					"Tue",
					"Wed",
					"Thu",
					"Fri",
					"Sat",
					"Sun"
				],
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				labels: {
					show: true,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 4,
				max: 80,
				min: 0,
				labels: {
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				}
			},
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#new_tickets_vs_solved_sickets"), options);
		chart.render();
	}
    
    /* Tasks Overview JS */
	const getTasksOverview2Id = document.getElementById('tasks_overview2');
	if (getTasksOverview2Id) {
		var options = {

			series: [
				55, 44, 30, 12, 22
			],
			chart: {
				height: 460,
				type: "pie",
			},
			labels: [
				"Completed", "In Progress", "Pending", "Active", "Cancelled"
			],
			colors: [
				"#37D80A", "#605DFF", "#AD63F6", "#3584FC", "#FD5812"
			],
			dataLabels: {
				enabled: false
			},
			plotOptions: {
				pie: {
					expandOnClick: false
				}
			},
			stroke: {
				width: 1,
				show: true,
				colors: ["#ffffff"]
			},
			legend: {
				show: true,
				fontSize: '12px',
				position: 'bottom',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 7
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					radius: 2,
					height: 9,
					offsetX: -2,
					offsetY: -.1,
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#tasks_overview2"), options);
		chart.render();
	}

	// New vs Solved JS
	const getNewvsSolvedId = document.getElementById('new_vs_solved');
	if (getNewvsSolvedId) {
		var options = {
			series: [
				{
					name: "New Tickets",
					data: [25, 70, 25, 45, 60, 55, 70]
				},
				{
					name: "Solved Tickets",
					data: [65, 45, 65, 30, 75, 24, 50]
				}
			],
			chart: {
				type: "area",
				height: 395,
				zoom: {
					enabled: false
				},
				toolbar: {
					show: false
				}
			},
			colors: [
				"#605DFF", "#FD5812"
			],
			dataLabels: {
				enabled: false
			},
			stroke: {
				curve: "smooth",
				width: 2
			},
			grid: {
				show: true,
				borderColor: "#ECEEF2"
			},
			fill: {
				type: 'gradient',
				gradient: {
					stops: [0, 90, 100],
					shadeIntensity: 1,
					opacityFrom: 0,
					opacityTo: 0.6
				}
			},
			xaxis: {
				categories: [
					"Mon",
					"Tue",
					"Wed",
					"Thu",
					"Fri",
					"Sat",
					"Sun"
				],
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				labels: {
					show: true,
					style: {
						colors: "#8695AA",
						fontSize: "12px"
					}
				}
			},
			yaxis: {
				tickAmount: 4,
				max: 80,
				min: 0,
				labels: {
					style: {
						colors: "#64748B",
						fontSize: "12px"
					}
				},
				axisBorder: {
					show: false,
					color: '#ECEEF2'
				},
				axisTicks: {
					show: false,
					color: '#ECEEF2'
				}
			},
			legend: {
				show: true,
				position: 'top',
				fontSize: '12px',
				horizontalAlign: 'center',
				itemMargin: {
					horizontal: 8,
					vertical: 0
				},
				labels: {
					colors: '#64748B'
				},
				markers: {
					width: 9,
					height: 9,
					offsetX: -2,
					offsetY: -.5,
					radius: 2
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#new_vs_solved"), options);
		chart.render();
	}



	//**<---- Others All Charts ---->**//

	// Product Trends by Month JS
	const getProductTrendsbyMonthId = document.getElementById('product_trends_by_month');
	if (getProductTrendsbyMonthId) {
		var options = {
			series: [{
				name: "Desktops",
				data: [10, 41, 35, 51, 49, 62, 69, 91, 148]
			  }],
			chart: {
				height: 350,
				type: 'line',
				zoom: {
					enabled: false
				}
			  },
			dataLabels: {
				enabled: false
			},
			stroke: {
				curve: 'straight'
			},
			title: {
				text: 'Product Trends by Month',
				align: 'left',
				style: {
					fontSize:  '14px',
					fontWeight:  '500',
					color:  '#64748B'
				},
			},
			grid: {
				row: {
					colors: ['#f3f3f3', 'transparent'], // takes an array which will be repeated on columns
					opacity: 0.5
				},
			},
			xaxis: {
				categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep'],
			}
		};
		var chart = new ApexCharts(document.querySelector("#product_trends_by_month"), options);
		chart.render();
	}
    
	// Average High & Low Temperature JS
	const getAverageHighLowTemperatureId = document.getElementById('average_high_low_temperature');
	if (getAverageHighLowTemperatureId) {
		var options = {
			series: [
				{
					name: "High - 2013",
					data: [28, 29, 33, 36, 32, 32, 33]
				},
				{
					name: "Low - 2013",
					data: [12, 11, 14, 18, 17, 13, 13]
				}
		  	],
			chart: {
				height: 350,
				type: 'line',
				dropShadow: {
					enabled: true,
					color: '#000',
					top: 18,
					left: 7,
					blur: 10,
					opacity: 0.2
				},
				zoom: {
					enabled: false
				},
				toolbar: {
					show: false
				}
		  	},
			colors: ['#77B6EA', '#545454'],
			dataLabels: {
				enabled: true,
			},
			stroke: {
				curve: 'smooth'
			},
			title: {
				text: 'Average High & Low Temperature',
				align: 'left',
				style: {
					fontSize:  '14px',
					fontWeight:  '500',
					color:  '#64748B'
				},
			},
			grid: {
				borderColor: '#e7e7e7',
				row: {
					colors: ['#f3f3f3', 'transparent'], // takes an array which will be repeated on columns
					opacity: 0.5
				},
			},
			markers: {
				size: 1
			},
			xaxis: {
				categories: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul'],
				title: {
					text: 'Month'
				}
			},
			yaxis: {
				title: {
					text: 'Temperature'
				},
				min: 5,
				max: 40
			},
			legend: {
				position: 'top',
				horizontalAlign: 'right',
				floating: true,
				offsetY: -25,
				offsetX: -5
			}
		};
		var chart = new ApexCharts(document.querySelector("#average_high_low_temperature"), options);
		chart.render();
	}

	//  Stepline Chart JS
	const getSteplineChartId = document.getElementById('stepline_chart');
	if (getSteplineChartId) {
		var options = {
			series: [{
				data: [34, 44, 54, 21, 12, 43, 33, 23, 66, 66, 58]
			}],
			chart: {
				type: 'line',
				height: 350
			},
			stroke: {
				curve: 'stepline',
			},
			dataLabels: {
				enabled: false
			},
			title: {
				text: 'Stepline Chart',
				align: 'left',
				style: {
					fontSize: '14px',
					fontWeight: '500',
					color: '#64748B'
				},
			},
			markers: {
				hover: {
					sizeOffset: 4
				}
			}
		};
		var chart = new ApexCharts(document.querySelector("#stepline_chart"), options);
		chart.render();
	}

	//  Page Statistics JS
	const getPageStatisticsId = document.getElementById('page_statistics');
	if (getPageStatisticsId) {
		var options = {
			series: [{
				name: "Session Duration",
				data: [45, 52, 38, 24, 33, 26, 21, 20, 6, 8, 15, 10]
			},
			{
				name: "Page Views",
				data: [35, 41, 62, 42, 13, 18, 29, 37, 36, 51, 32, 35]
			},
			{
				name: 'Total Visits',
				data: [87, 57, 74, 99, 75, 38, 62, 47, 82, 56, 45, 47]
			}
			],
			chart: {
				height: 350,
				type: 'line',
				zoom: {
					enabled: false
				},
			},
			dataLabels: {
				enabled: false
			},
			stroke: {
				width: [5, 7, 5],
				curve: 'straight',
				dashArray: [0, 8, 5]
			},
			title: {
				text: 'Page Statistics',
				align: 'left',
				style: {
					fontSize: '14px',
					fontWeight: '500',
					color: '#64748B'
				},
			},
			legend: {
				tooltipHoverFormatter: function (val, opts) {
					return val + ' - <strong>' + opts.w.globals.series[opts.seriesIndex][opts.dataPointIndex] + '</strong>'
				}
			},
			markers: {
				size: 0,
				hover: {
					sizeOffset: 6
				}
			},
			xaxis: {
				categories: ['01 Jan', '02 Jan', '03 Jan', '04 Jan', '05 Jan', '06 Jan', '07 Jan', '08 Jan', '09 Jan',
					'10 Jan', '11 Jan', '12 Jan'
				],
			},
			tooltip: {
				y: [
					{
						title: {
							formatter: function (val) {
								return val + " (mins)"
							}
						}
					},
					{
						title: {
							formatter: function (val) {
								return val + " per session"
							}
						}
					},
					{
						title: {
							formatter: function (val) {
								return val;
							}
						}
					}
				]
			},
			grid: {
				borderColor: '#f1f1f1',
			}
		};
		var chart = new ApexCharts(document.querySelector("#page_statistics"), options);
		chart.render();
	}

	// Spline JS
	const getSplineAreaId = document.getElementById('spline_area');
	if (getSplineAreaId) {
		var options = {
			series: [{
			name: 'series1',
			data: [31, 40, 28, 51, 42, 109, 100]
		  }, {
			name: 'series2',
			data: [11, 32, 45, 32, 34, 52, 41]
		  }],
			chart: {
			height: 350,
			type: 'area'
		  },
		  dataLabels: {
			enabled: false
		  },
		  stroke: {
			curve: 'smooth'
		  },
		  xaxis: {
			type: 'datetime',
			categories: ["2018-09-19T00:00:00.000Z", "2018-09-19T01:30:00.000Z", "2018-09-19T02:30:00.000Z", "2018-09-19T03:30:00.000Z", "2018-09-19T04:30:00.000Z", "2018-09-19T05:30:00.000Z", "2018-09-19T06:30:00.000Z"]
		  },
		  tooltip: {
			x: {
			  format: 'dd/MM/yy HH:mm'
			},
		  },
		  };
  
		  var chart = new ApexCharts(document.querySelector("#spline_area"), options);
		  chart.render();
	}

	// Area with Negative Values JS
	const getAreawithNegativeValuesId = document.getElementById('area_with_negative_values');
	if (getAreawithNegativeValuesId) {
		var options= {
			series: [ {

				name: 'north',
				data: [ {
					x: 1996,
						y: 322
				}

				,
				{
				x: 1997,
					y: 324
			}

			,
			{
			x: 1998,
				y: 329
		}

		,
		{
		x: 1999,
			y: 342
		}

		,
		{
		x: 2000,
			y: 348
		}

		,
		{
		x: 2001,
			y: 334
		}

		,
		{
		x: 2002,
			y: 325
		}

		,
		{
		x: 2003,
			y: 316
		}

		,
		{
		x: 2004,
			y: 318
		}

		,
		{
		x: 2005,
			y: 330
		}

		,
		{
		x: 2006,
			y: 355
		}

		,
		{
		x: 2007,
			y: 366
		}

		,
		{
		x: 2008,
			y: 337
		}

		,
		{
		x: 2009,
			y: 352
		}

		,
		{
		x: 2010,
			y: 377
		}

		,
		{
		x: 2011,
			y: 383
		}

		,
		{
		x: 2012,
			y: 344
		}

		,
		{
		x: 2013,
			y: 366
		}

		,
		{
		x: 2014,
			y: 389
		}

		,
		{
		x: 2015,
			y: 334
		}

		]
		}

		,
		{

		name: 'south',
		data: [ {
			x: 1996,
				y: 162
		}

		,
		{
		x: 1997,
			y: 90
		}

		,
		{
		x: 1998,
			y: 50
		}

		,
		{
		x: 1999,
			y: 77
		}

		,
		{
		x: 2000,
			y: 35
		}

		,
		{
		x: 2001,
			y: -45
		}

		,
		{
		x: 2002,
			y: -88
		}

		,
		{
		x: 2003,
			y: -120
		}

		,
		{
		x: 2004,
			y: -156
		}

		,
		{
		x: 2005,
			y: -123
		}

		,
		{
		x: 2006,
			y: -88
		}

		,
		{
		x: 2007,
			y: -66
		}

		,
		{
		x: 2008,
			y: -45
		}

		,
		{
		x: 2009,
			y: -29
		}

		,
		{
		x: 2010,
			y: -45
		}

		,
		{
		x: 2011,
			y: -88
		}

		,
		{
		x: 2012,
			y: -132
		}

		,
		{
		x: 2013,
			y: -146
		}

		,
		{
		x: 2014,
			y: -169
		}

		,
		{
		x: 2015,
			y: -184
		}

		]
		}

		],
		chart: {
			type: 'area',
				height: 350
		}

		,
		dataLabels: {
			enabled: false
		}

		,
		stroke: {
			curve: 'straight'
		}

		,

		title: {

			text: 'Area with Negative Values',
			align: 'left',
			style: {
				fontSize: '14px'
			}
		}

		,
		xaxis: {

			type: 'datetime',
			axisBorder: {
				show: false
			}

			,
			axisTicks: {
				show: false
			}
		}

		,
		yaxis: {
			tickAmount: 4,
			floating: false,

			labels: {
				style: {
					colors: '#8e8da4',
				}

				,
				offsetY: -7,
				offsetX: 0,
			}

			,
			axisBorder: {
				show: false,
			}

			,
			axisTicks: {
				show: false
			}
		}

		,
		fill: {
			opacity: 0.5
		}

		,
		tooltip: {
			x: {
				format: "yyyy",
			}

			,
			fixed: {
				enabled: false,
					position: 'topRight'
			}
		}

		,
		grid: {
			yaxis: {
				lines: {
					offsetX: -30
				}
			}

			,
			padding: {
				left: 20
			}
		}
		};
		var chart=new ApexCharts(document.querySelector("#area_with_negative_values"), options);
		chart.render();
	}

	//  Basic bar JS
	const getBasicBarId = document.getElementById('basic_bar');
	if (getBasicBarId) {
		var options = {
			series: [{
			  	data: [400, 430, 448, 470, 540, 580, 690, 1100, 1200, 1380]
			}],
			chart: {
				type: 'bar',
				height: 430
			},
			plotOptions: {
				bar: {
					borderRadius: 4,
					borderRadiusApplication: 'end',
					horizontal: true,
				}
			},
			dataLabels: {
			  	enabled: false
			},
			xaxis: {
				categories: ['South Korea', 'Canada', 'United Kingdom', 'Netherlands', 'Italy', 'France', 'Japan',
					'United States', 'China', 'Germany'
				],
			}
		};
		var chart = new ApexCharts(document.querySelector("#basic_bar"), options);
        chart.render();
	}

	// Grouped bar JS
	const getGroupedId = document.getElementById('grouped');
	if (getGroupedId) {
		var options = {
		series: [{
			data: [44, 55, 41, 64, 22, 43, 21]
		}, {
			data: [53, 32, 33, 52, 13, 44, 32]
		}],
		chart: {
			type: 'bar',
			height: 430
		},
		plotOptions: {
			bar: {
			horizontal: true,
			dataLabels: {
				position: 'top',
			},
			}
		},
		dataLabels: {
			enabled: true,
			offsetX: -6,
			style: {
			fontSize: '12px',
			colors: ['#fff']
			}
		},
		stroke: {
			show: true,
			width: 1,
			colors: ['#fff']
		},
		tooltip: {
			shared: true,
			intersect: false
		},
		xaxis: {
			categories: [2001, 2002, 2003, 2004, 2005, 2006, 2007],
		},
		};

		var chart = new ApexCharts(document.querySelector("#grouped"), options);
		chart.render();
	}

	// Grouped bar JS
	const getColumnId = document.getElementById('basic_column');
	if (getColumnId) {
		var options = {
			series: [{
			  name: 'Net Profit',
			  data: [44, 55, 57, 56, 61, 58, 63, 60, 66]
			}, {
			  name: 'Revenue',
			  data: [76, 85, 101, 98, 87, 105, 91, 114, 94]
			}, {
			  name: 'Free Cash Flow',
			  data: [35, 41, 36, 26, 45, 48, 52, 53, 41]
			}],
			chart: {
			  type: 'bar',
			  height: 350
			},
			plotOptions: {
			  bar: {
				horizontal: false,
				columnWidth: '55%',
				endingShape: 'rounded'
			  },
			},
			dataLabels: {
			  enabled: false
			},
			stroke: {
			  show: true,
			  width: 2,
			  colors: ['transparent']
			},
			xaxis: {
			  categories: ['Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct'],
			},
			yaxis: {
			  title: {
				text: '$ (thousands)'
			  }
			},
			fill: {
			  opacity: 1
			},
			tooltip: {
			  y: {
				formatter: function (val) {
				  return "$ " + val + " thousands"
				}
			  }
			}
		};
		  
		var chart = new ApexCharts(document.querySelector("#basic_column"), options);
		chart.render();
	}

	// Column with Data Labels JS
	const getColumnwithDataLabelsId = document.getElementById('column_with_data_labels');
	if (getColumnwithDataLabelsId) {
		var options = {
			series: [{
			  name: 'Inflation',
			  data: [2.3, 3.1, 4.0, 10.1, 4.0, 3.6, 3.2, 2.3, 1.4, 0.8, 0.5, 0.2]
			}],
			chart: {
			  height: 350,
			  type: 'bar',
			},
			plotOptions: {
			  bar: {
				borderRadius: 10,
				dataLabels: {
				  position: 'top', // top, center, bottom
				},
			  }
			},
			dataLabels: {
			  enabled: true,
			  formatter: function (val) {
				return val + "%";
			  },
			  offsetY: -20,
			  style: {
				fontSize: '12px',
				colors: ["#304758"]
			  }
			},
		  
			xaxis: {
			  categories: ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"],
			  position: 'top',
			  axisBorder: {
				show: false
			  },
			  axisTicks: {
				show: false
			  },
			  crosshairs: {
				fill: {
				  type: 'gradient',
				  gradient: {
					colorFrom: '#D8E3F0',
					colorTo: '#BED1E6',
					stops: [0, 100],
					opacityFrom: 0.4,
					opacityTo: 0.5,
				  }
				}
			  },
			  tooltip: {
				enabled: true,
			  }
			},
			yaxis: {
			  axisBorder: {
				show: false
			  },
			  axisTicks: {
				show: false,
			  },
			  labels: {
				show: false,
				formatter: function (val) {
				  return val + "%";
				}
			  }
		  
			},
			title: {
			  text: 'Monthly Inflation in Argentina, 2002',
			  floating: true,
			  offsetY: 330,
			  align: 'center',
			  style: {
				color: '#444'
			  }
			}
		};
		  
		var chart = new ApexCharts(document.querySelector("#column_with_data_labels"), options);
		chart.render();
	}

})();